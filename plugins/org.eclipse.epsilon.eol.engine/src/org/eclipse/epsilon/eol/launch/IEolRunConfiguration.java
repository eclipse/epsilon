/*********************************************************************
 * Copyright (c) 2018 The University of York.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.eol.launch;

import java.util.*;
import org.eclipse.epsilon.common.launch.ProfilableRunConfiguration;
import org.eclipse.epsilon.common.util.CollectionUtil;
import org.eclipse.epsilon.common.util.StringProperties;
import static org.eclipse.epsilon.common.util.profiling.BenchmarkUtils.profileExecutionStage;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.eol.IEolModule;

/**
 * Convenience class for running EOL programs over models.
 * 
 * @author Sina Madani
 * @since 1.6
 */
public abstract class IEolRunConfiguration extends ProfilableRunConfiguration {
	
	protected static final Set<IModel> LOADED_MODELS = new HashSet<>();
	public final Map<IModel, StringProperties> modelsAndProperties;
	public final Map<String, Object> parameters;
	private final IEolModule module;
	
	public IEolRunConfiguration(Builder<? extends IEolRunConfiguration, ?> builder) {
		super(builder);
		this.parameters = builder.parameters;
		this.modelsAndProperties = builder.modelsAndProperties;
		this.module = Optional.ofNullable(builder.module).orElseGet(this::getDefaultModule);
		this.id = Optional.ofNullable(builder.id).orElseGet(() ->
			Objects.hash(
				super.id,
				Objects.toString(this.modelsAndProperties),
				Objects.toString(this.module.getSourceUri())
			)
		);
	}
	
	public IEolRunConfiguration(IEolRunConfiguration other) {
		super(other);
		this.modelsAndProperties = other.modelsAndProperties;
		this.module = other.module;
		this.parameters = other.parameters;
	}
	
	/**
	 * 
	 * @return The concrete instance of IEolModule.
	 */
	public IEolModule getModule() {
		return module;
	}
	
	/**
	 * @return a concrete (i.e. non-abstract) implementation of IEolModule.
	 */
	protected abstract IEolModule getDefaultModule();
	
	@Override
	protected void preExecute() throws Exception {
		super.preExecute();
		
		if (profileExecution) {
			profileExecutionStage(profiledStages, "Parsing script", () -> module.parse(script.toFile()));
			profileExecutionStage(profiledStages, "Parsing model", this::parseModels);
		}
		else {
			module.parse(script.toFile());
			this.parseModels();
		}
		
		if (!parameters.isEmpty()) {
			module.getContext().getFrameStack().put(parameters, false);
		}
	}
	
	protected void parseModels() throws EolModelLoadingException {
		if (modelsAndProperties != null && !modelsAndProperties.isEmpty()) {
			for (Map.Entry<IModel, StringProperties> modelAndProp : modelsAndProperties.entrySet()) {
				IModel model = modelAndProp.getKey();
				if (!LOADED_MODELS.contains(model)) {
					StringProperties modelProperties = modelAndProp.getValue();
					if (modelProperties != null) {
						model.load(modelProperties); 
					}
					else {
						model.load();
					}
					LOADED_MODELS.add(model);
				}
				module.getContext().getModelRepository().addModel(model);
			}
		}
	}
	
	@Override
	protected Object execute() throws EolRuntimeException {
		Object execResult;
		
		if (profileExecution) {
			if (module instanceof ProfilableIEolModule) {
				ProfilableIEolModule profMod = (ProfilableIEolModule) module;
				execResult = profMod.profileExecution();
				profiledStages.addAll(profMod.getProfiledStages());
			}
			else {
				execResult = profileExecutionStage(profiledStages, "execute()", module::execute);
			}
		}
		else {
			execResult = module.execute();
		}
		
		return execResult;
	}
	
	@Override
	public String toString() {
		return super.toString()+
		", module="+module+
		"', models='"+Objects.toString(modelsAndProperties)+"'";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), module, modelsAndProperties);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (!super.equals(obj)) return false;
		
		IEolRunConfiguration other = (IEolRunConfiguration) obj;
		return
			Objects.equals(this.module, other.module) &&
			CollectionUtil.equalsIgnoreOrder(this.modelsAndProperties.keySet(), other.modelsAndProperties.keySet());
	}
	
	
	@SuppressWarnings("unchecked")
	public static class Builder<C extends IEolRunConfiguration, B extends Builder<C, B>> extends ProfilableRunConfiguration.Builder<C, B> {
		protected Builder() {
			super();
		}
		protected Builder(Class<C> runConfigClass) {
			super(runConfigClass);
		}
		
		@Override
		public C build() {
			return buildReflective(() -> {
				class InstantiableEOC extends IEolRunConfiguration {
					public InstantiableEOC(Builder<C, B> builder) {
						super(builder);
					}
					@Override
					protected IEolModule getDefaultModule() {
						throw new UnsupportedOperationException();
					}
				};
				
				return (C) new InstantiableEOC((Builder<C, B>) this);
			});
		}
		
		public IEolModule module;
		public Map<IModel, StringProperties> modelsAndProperties = new HashMap<>(4);
		public Map<String, Object> parameters = new HashMap<>(4);

		public Builder<C, B> withModule(IEolModule module) {
			this.module = module;
			return this;
		}
		
		public Builder<C, B> withModel(IModel model) {
			return withModel(model, new StringProperties());
		}
		public Builder<C, B> withModel(IModel model, StringProperties properties) {
			this.modelsAndProperties.put(model, properties);
			return this;
		}
		public Builder<C, B> withModels(Map<IModel, StringProperties> modelsAndProps) {
			this.modelsAndProperties.putAll(modelsAndProps);
			return this;
		}
		public Builder<C, B> withModels(IModel... models) {
			for (IModel model : models) {
				withModel(model);
			}
			return this;
		}
		
		public Builder<C, B> withProperties(StringProperties properties) {
			modelsAndProperties.values().forEach(prop -> prop.putAll(properties));
			return this;
		}
		public Builder<C, B> withProperty(String name, Object value) {
			modelsAndProperties.values().forEach(prop -> prop.put(name, value));
			return this;
		}
		
		public Builder<C, B> withParameter(String name, Object value) {
			this.parameters.put(name, value);
			return this;
		}
		public Builder<C, B> withParameters(Map<String, Object> params) {
			this.parameters.putAll(params);
			return this;
		}
	}
	
	public static <C extends IEolRunConfiguration, B extends Builder<C, B>> Builder<C, B> Builder(Class<C> clazz) {
		return new Builder<>(clazz);
	}
}
