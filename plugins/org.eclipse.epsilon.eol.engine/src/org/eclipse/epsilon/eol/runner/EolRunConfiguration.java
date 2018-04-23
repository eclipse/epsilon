package org.eclipse.epsilon.eol.runner;

import static java.lang.System.nanoTime;
import java.nio.file.Path;
import java.util.*;
import org.eclipse.epsilon.common.runner.ProfilableRunConfiguration;
import org.eclipse.epsilon.common.util.StringProperties;
import org.eclipse.epsilon.eol.IEolModule;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.profiling.util.BenchmarkUtils;

/**
 * Convenience class for running ERL programs over models.
 * 
 * @author Sina Madani
 */
public abstract class EolRunConfiguration<M extends IEolModule> extends ProfilableRunConfiguration<Object> {
	
	protected static final Set<IModel> LOADED_MODELS = new HashSet<>();
	public final StringProperties modelProperties;
	public final IModel model;
	public final M module;
	
	public EolRunConfiguration(
		Path erlFile,
		StringProperties properties,
		IModel model,
		Optional<Boolean> showResults,
		Optional<Boolean> profileExecution,
		Optional<M> eolModule,
		Optional<Integer> configID,
		Optional<Path> scratchFile) {
			super(erlFile, showResults, profileExecution, configID, scratchFile);
			this.modelProperties = properties;
			this.model = model;
			this.module = eolModule.orElseGet(this::getDefaultModule);
			this.id = configID.orElseGet(() ->
				Objects.hash(
					super.id,
					Objects.toString(this.model),
					Objects.toString(this.modelProperties),
					Objects.toString(this.module.getSourceUri())
				)
			);
	}

	public EolRunConfiguration(EolRunConfiguration<? extends M> other) {
		this(
			other.script,
			other.modelProperties,
			other.model,
			Optional.of(other.showResults),
			Optional.of(other.profileExecution),
			Optional.of(other.module),
			Optional.of(other.id),
			Optional.of(other.outputFile)
		);
		this.result = other.result;
	}
	
	/**
	 * @return a concrete (i.e. non-abstract) implementation of IErlModule.
	 */
	protected abstract M getDefaultModule();
	
	@Override
	public void preExecute() throws Exception {
		super.preExecute();
		
		long startMemory = 0, parseStartTime = 0;
		
		if (profileExecution) {
			startMemory = BenchmarkUtils.getTotalMemoryUsage();
			parseStartTime = nanoTime();
		}
		
		if (module.parse(script.toFile()) && model != null) {
			if (!LOADED_MODELS.contains(model)) {
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
		
		if (profileExecution) {
			long parseEndTime = nanoTime();
			long endMemory = BenchmarkUtils.getTotalMemoryUsage();
			addProfileInfo("Parsing model", parseEndTime-parseStartTime, endMemory-startMemory);
		}
	}
	
	@Override
	public Object execute() throws EolRuntimeException {
		Object execResult;
		if (profileExecution && module instanceof ProfilableIEolModule) {
			ProfilableIEolModule profMod = (ProfilableIEolModule) module;
			execResult = profMod.profileExecution();
			profiledStages.addAll(profMod.getProfiledStages());
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
		"', model='"+Objects.toString(model.getName()+"'");
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), module, model);
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public boolean equals(Object other) {
		if (!super.equals(other)) return false;
		
		EolRunConfiguration erc = (EolRunConfiguration) other;
		return
			Objects.equals(this.module, erc.module) &&
			Objects.equals(this.model, erc.model);
	}
}
