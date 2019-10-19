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
import org.eclipse.epsilon.common.parse.problem.ParseProblem;
import org.eclipse.epsilon.common.util.CollectionUtil;
import org.eclipse.epsilon.common.util.StringProperties;
import static org.eclipse.epsilon.common.util.profiling.BenchmarkUtils.profileExecutionStage;
import org.eclipse.epsilon.eol.exceptions.EolParseException;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.concurrent.IEolContextParallel;
import org.eclipse.epsilon.eol.models.CachedModel;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.eol.IEolModule;

/**
 * Convenience class for running EOL programs over models.
 * 
 * @author Sina Madani
 * @since 1.6
 */
public abstract class IEolRunConfiguration extends ProfilableRunConfiguration {
	
	public final Map<IModel, StringProperties> modelsAndProperties;
	public final Map<String, Object> parameters;
	protected final boolean loadModels;
	private final IEolModule module;
	
	public IEolRunConfiguration(Builder<? extends IEolRunConfiguration, ?> builder) {
		super(builder);
		this.parameters = builder.parameters;
		this.modelsAndProperties = builder.modelsAndProperties;
		this.loadModels = builder.loadModels;
		this.module = Objects.requireNonNull(builder.module, "Module cannot be null!");
		
		IEolContext context = module.getContext();
		if (builder.isParallel() && builder.parallelism > 0 && context instanceof IEolContextParallel) {
			IEolContextParallel pContext = (IEolContextParallel) context;
			pContext.setParallelism(builder.parallelism);
		}
		
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
		this.loadModels = other.loadModels;
	}
	
	/**
	 * 
	 * @return The concrete instance of IEolModule.
	 */
	public IEolModule getModule() {
		return module;
	}
	
	@Override
	protected void preExecute() throws Exception {
		super.preExecute();
		
		prepareModule();
		
		if (loadModels) {
			loadModels();
		}
	}
	
	protected void prepareModule() throws Exception {
		if (profileExecution) {
			profileExecutionStage(profiledStages, "Parsing script", () -> module.parse(script));
		}
		else {
			module.parse(script);
		}
		Collection<ParseProblem> parseProblems = module.getParseProblems();
		if (!parseProblems.isEmpty()) {
			writeOut(parseProblems);
			throw new EolParseException(parseProblems);
		}
		
		if (!parameters.isEmpty()) {
			module.getContext().getFrameStack().put(parameters, false);
		}
	}
	
	protected final void loadModels() throws EolModelLoadingException {
		if (profileExecution) {
			profileExecutionStage(profiledStages, "Loading model(s)", this::loadModelsImpl);
		}
		else {
			this.loadModelsImpl();
		}
	}
	
	protected void loadModelsImpl() throws EolModelLoadingException {
		if (modelsAndProperties != null && !modelsAndProperties.isEmpty()) {
			for (Map.Entry<IModel, StringProperties> modelAndProp : modelsAndProperties.entrySet()) {
				IModel model = modelAndProp.getKey();
				if (!(model instanceof CachedModel) || !((CachedModel<?>) model).isLoaded()) {
					StringProperties modelProperties = modelAndProp.getValue();
					if (modelProperties != null) {
						model.load(modelProperties); 
					}
					else {
						model.load();
					}
				}
				module.getContext().getModelRepository().addModel(model);
			}
		}
	}
	
	public void dispose() {
		module.getContext().dispose();
		parameters.clear();
		//modelsAndProperties.keySet().forEach(IModel::dispose);
		modelsAndProperties.clear();
		module.setContext(null);
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
	protected List<Object> getProfilingOutput() {
		List<Object> prof = new ArrayList<>(super.getProfilingOutput());
		prof.addAll(Arrays.asList(printMarker, getModule().getContext().getExecutorFactory().getExecutionController()));
		return prof;
	}
	
	@Override
	public String toString() {
		return super.toString()+
		", moduleClass="+module.getClass().getName()+
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
	public static abstract class Builder<C extends IEolRunConfiguration, B extends Builder<C, B>> extends ProfilableRunConfiguration.Builder<C, B> {
		protected Builder() {
			super();
		}
		protected Builder(Class<C> runConfigClass) {
			super(runConfigClass);
		}
		
		@Override
		public C build() {
			if (module == null) {
				module = createModule();
			}
			
			module.getContext().setProfilingEnabled(profileExecution);
			
			return buildReflective(() -> {
				class InstantiableEOC extends IEolRunConfiguration {
					public InstantiableEOC(Builder<C, B> builder) {
						super(builder);
					}
				};
				
				return (C) new InstantiableEOC(this);
			});
		}
		
		protected abstract IEolModule createModule();
		
		public IEolModule module;
		public Map<IModel, StringProperties> modelsAndProperties = new LinkedHashMap<>(4);
		public Map<String, Object> parameters = new LinkedHashMap<>(4);
		public boolean loadModels = true;
		public int parallelism = Integer.MIN_VALUE;

		public boolean isParallel() {
			return parallelism > -1;
		}
		
		public B skipModelLoading() {
			return withModelLoading(false);
		}
		public B withModelLoading(boolean load) {
			this.loadModels = load;
			return (B) this;
		}
		public B withModule(IEolModule module) {
			this.module = module;
			return (B) this;
		}
		public B withModel(IModel model) {
			return withModel(model, null);
		}
		public B withModel(IModel model, StringProperties properties) {
			this.modelsAndProperties.put(model, properties);
			return (B) this;
		}
		public B withModels(Map<IModel, StringProperties> modelsAndProps) {
			this.modelsAndProperties.putAll(modelsAndProps);
			return (B) this;
		}
		public B withModels(IModel... models) {
			for (IModel model : models) {
				withModel(model);
			}
			return (B) this;
		}
		public B withProperties(StringProperties properties) {
			modelsAndProperties.values().forEach(prop -> prop.putAll(properties));
			return (B) this;
		}
		public B withProperty(String name, Object value) {
			modelsAndProperties.values().forEach(prop -> prop.put(name, value));
			return (B) this;
		}
		public B withParameter(String name, Object value) {
			this.parameters.put(name, value);
			return (B) this;
		}
		public B withParameters(Map<String, Object> params) {
			this.parameters.putAll(params);
			return (B) this;
		}
		public B withParallelism(int parallelism) {
			this.parallelism = parallelism;
			return (B) this;
		}
	}
}
