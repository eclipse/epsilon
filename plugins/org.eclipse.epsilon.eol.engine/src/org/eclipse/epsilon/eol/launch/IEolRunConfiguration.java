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

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.*;
import java.util.stream.Stream;
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
public abstract class IEolRunConfiguration<M extends IEolModule> extends ProfilableRunConfiguration {
	
	protected static final Set<IModel> LOADED_MODELS = new HashSet<>();
	public final Map<IModel, StringProperties> modelsAndProperties;
	public final M module;
	public final Map<String, Object> parameters;
	
	public IEolRunConfiguration(Builder<M, ? extends IEolRunConfiguration<M>, ?> builder) {
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
	
	public IEolRunConfiguration(IEolRunConfiguration<? extends M> other) {
		super(other);
		this.modelsAndProperties = other.modelsAndProperties;
		this.module = other.module;
		this.parameters = other.parameters;
	}
	
	/**
	 * @return a concrete (i.e. non-abstract) implementation of IEolModule.
	 */
	protected abstract M getDefaultModule();
	
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
		
		IEolRunConfiguration<?> other = (IEolRunConfiguration<?>) obj;
		return
			Objects.equals(this.module, other.module) &&
			CollectionUtil.equalsIgnoreOrder(this.modelsAndProperties.keySet(), other.modelsAndProperties.keySet());
	}
	
	
	// WARNING: Nasty stuff!
	@SuppressWarnings("unchecked")
	public static class Builder<M extends IEolModule, C extends IEolRunConfiguration<M>, B extends Builder<M, C, B>> extends ProfilableRunConfiguration.Builder<C, B> {
		protected Class<C> configClass;
		public Builder() {
			this(null);
		}
		public Builder(Class<C> runConfigClass) {
			setConfigClass(runConfigClass);
		}
		private void setConfigClass(Class<C> runConfigClass) {
			this.configClass = runConfigClass != null ? runConfigClass :
				(Class<C>) getClass().getDeclaringClass();
		}
		
		@Override
		public C build() {
			try {
				if (Modifier.isAbstract(this.configClass.getModifiers())) {
					class InstantiableEOC extends IEolRunConfiguration<M> {
						public InstantiableEOC(Builder<M, ? extends IEolRunConfiguration<M>, ?> builder) {
							super(builder);
						}
						@Override
						protected M getDefaultModule() {
							throw new UnsupportedOperationException();
						}
					};
					
					return (C) new InstantiableEOC((Builder<M, ? extends IEolRunConfiguration<M>, ?>) this);
				}
				
				return (C) Stream.of(configClass.getConstructors())
					.filter(constructor -> constructor.getParameterCount() == 1)
					.filter(constructor -> Stream.of(constructor.getParameterTypes())
						.filter(clazz -> clazz.getName().contains("Builder"))
						.findAny().isPresent()
					)
					.findAny()
					.orElseThrow(() -> new NoSuchMethodException("Couldn't find builder constructor for class '"+configClass.getName()+"'."))
				.newInstance(this);
			}
			catch (NullPointerException | InvocationTargetException | InstantiationException | IllegalAccessException | IllegalArgumentException | NoSuchMethodException | SecurityException ex) {
				throw new IllegalStateException(ex);
			}
		}
		
		public M module;
		public Map<IModel, StringProperties> modelsAndProperties = new HashMap<>(4);
		public Map<String, Object> parameters = new HashMap<>(4);

		public Builder<M, C, B> withModule(M module) {
			this.module = module;
			return this;
		}
		public Builder<M, C, B> withModel(IModel model) {
			return withModel(model, new StringProperties());
		}
		public Builder<M, C, B> withModel(IModel model, StringProperties properties) {
			this.modelsAndProperties.put(model, properties);
			return this;
		}
		public Builder<M, C, B> withModels(Map<IModel, StringProperties> modelsAndProps) {
			this.modelsAndProperties.putAll(modelsAndProps);
			return this;
		}
		public Builder<M, C, B> withParameter(String name, Object value) {
			this.parameters.put(name, value);
			return this;
		}
		public Builder<M, C, B> withParameters(Map<String, Object> params) {
			this.parameters.putAll(params);
			return this;
		}
	}
	
	public static <M extends IEolModule, C extends IEolRunConfiguration<M>, B extends Builder<M, C, B>> Builder<M, C, B> Builder() {
		return new Builder<>();
	}
	
	public static <M extends IEolModule, C extends IEolRunConfiguration<M>, B extends Builder<M, C, B>> Builder<M, C, B> Builder(Class<C> clazz) {
		return new Builder<>(clazz);
	}
}
