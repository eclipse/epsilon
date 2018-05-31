package org.eclipse.epsilon.eol.launch;

import static java.lang.System.nanoTime;
import java.nio.file.Path;
import java.util.*;
import org.eclipse.epsilon.common.launch.ProfilableRunConfiguration;
import org.eclipse.epsilon.common.util.CollectionUtil;
import org.eclipse.epsilon.common.util.StringProperties;
import org.eclipse.epsilon.common.util.profiling.*;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.eol.IEolModule;

/**
 * Convenience class for running EOL programs over models.
 * 
 * @author Sina Madani
 */
public abstract class IEolRunConfiguration<M extends IEolModule, R> extends ProfilableRunConfiguration<R> {
	
	protected static final Set<IModel> LOADED_MODELS = new HashSet<>();
	public final Map<IModel, StringProperties> modelsAndProperties;
	public final M module;
	public final Map<String, ?> parameters;
	
	public IEolRunConfiguration(
		Path eolFile,
		Map<IModel, StringProperties> modelsAndProperties,
		Optional<M> eolModule,
		Optional<Map<String, ?>> parameters,
		Optional<Boolean> showResults,
		Optional<Boolean> profileExecution,
		Optional<Integer> configID,
		Optional<Path> scratchFile) {
			super(eolFile, showResults, profileExecution, configID, scratchFile);
			this.parameters = parameters.orElse(Collections.emptyMap());
			this.modelsAndProperties = modelsAndProperties;
			this.module = eolModule.orElseGet(this::getDefaultModule);
			this.id = configID.orElseGet(() ->
				Objects.hash(
					super.id,
					Objects.toString(this.modelsAndProperties),
					Objects.toString(this.module.getSourceUri())
				)
			);
	}
	
	public IEolRunConfiguration(IEolRunConfiguration<? extends M, ? extends R> other) {
		this(
			other.script,
			other.modelsAndProperties,
			Optional.of(other.module),
			Optional.of(other.parameters),
			Optional.of(other.showResults),
			Optional.of(other.profileExecution),
			Optional.of(other.id),
			Optional.ofNullable(other.outputFile)
		);
		this.result = other.result;
	}
	
	/**
	 * @return a concrete (i.e. non-abstract) implementation of IEolModule.
	 */
	protected abstract M getDefaultModule();
	
	@Override
	protected void preExecute() throws Exception {
		super.preExecute();
		
		long startMemory = 0, parseStartTime = 0;
		
		if (profileExecution) {
			startMemory = BenchmarkUtils.getTotalMemoryUsage();
			parseStartTime = nanoTime();
		}
		
		if (module.parse(script.toFile()) && modelsAndProperties != null && !modelsAndProperties.isEmpty()) {
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
		
		if (profileExecution) {
			long parseEndTime = nanoTime();
			long endMemory = BenchmarkUtils.getTotalMemoryUsage();
			addProfileInfo("Parsing model", parseEndTime-parseStartTime, endMemory-startMemory);
		}
		
		if (!parameters.isEmpty()) {
			module.getContext().getFrameStack().put(parameters);
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	protected R execute() throws EolRuntimeException {
		Object execResult;
		if (profileExecution && module instanceof ProfilableIEolModule) {
			ProfilableIEolModule profMod = (ProfilableIEolModule) module;
			execResult = profMod.profileExecution();
			profiledStages.addAll(profMod.getProfiledStages());
		}
		else {
			execResult = module.execute();
		}
		return (R) execResult;
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
	public boolean equals(Object other) {
		if (!super.equals(other)) return false;
		
		IEolRunConfiguration<?, ?> eoc = (IEolRunConfiguration<?, ?>) other;
		return
			Objects.equals(this.module, eoc.module) &&
			CollectionUtil.equalsIgnoreOrder(this.modelsAndProperties.keySet(), eoc.modelsAndProperties.keySet());
	}
}
