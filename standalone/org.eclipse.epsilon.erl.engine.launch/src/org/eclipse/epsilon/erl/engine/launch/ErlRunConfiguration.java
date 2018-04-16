package org.eclipse.epsilon.erl.engine.launch;

import static java.lang.System.nanoTime;
import java.nio.file.Path;
import java.util.*;
import org.eclipse.epsilon.common.util.StringProperties;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.erl.IErlModule;
import org.eclipse.epsilon.erl.engine.profiling.ProfilableIErlModule;
import org.eclipse.epsilon.profiling.util.BenchmarkUtils;
import org.eclipse.epsilon.launch.ProfilableRunConfiguration;

/**
 * Convenience class for running ERL programs over models.
 * Currently only EMF models are fully supported.
 * Note that this needn't be subclassed to use it,
 * you can just add the required projects to the classpath
 * and call it with appropriate arguments, but the first argument
 * must be a fully qualified name of a subtype of IErlModule.
 * 
 * @author Sina Madani
 */
public class ErlRunConfiguration<M extends IErlModule> extends ProfilableRunConfiguration<Object> {

	/**
	 * Allows the caller to invoke any subclass of IErlModule.
	 */
	@SuppressWarnings({"unchecked", "rawtypes"})
	public static void main(String[] args) throws ClassNotFoundException {
		if (args.length > 0) {
			new ErlConfigParser(Class.forName(args[0]), ErlRunConfiguration.class)
				.apply(Arrays.copyOfRange(args, 1, args.length))
				.run();
		}
	}
	
	protected static final Set<IModel> LOADED_MODELS = new HashSet<>();
	public final StringProperties modelProperties;
	public final IModel model;
	public final M module;
	
	public ErlRunConfiguration(
		Path erlFile,
		StringProperties properties,
		IModel model,
		Optional<Boolean> showResults,
		Optional<Boolean> profileExecution,
		Optional<M> erlModule,
		Optional<Integer> configID,
		Optional<Path> scratchFile) {
			super(erlFile, showResults, profileExecution, configID, scratchFile);
			this.modelProperties = properties;
			this.model = model;
			this.module = erlModule.orElseGet(this::getDefaultModule);
			this.id = configID.orElseGet(() ->
				Objects.hash(
					super.id,
					Objects.toString(this.model),
					Objects.toString(this.modelProperties),
					Objects.toString(this.module.getSourceUri())
				)
			);
	}

	public ErlRunConfiguration(ErlRunConfiguration<? extends M> other) {
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
	 * Should be overriden by subclasses and return a concrete (i.e. non-abstract) implementation of IErlModule.
	 */
	protected M getDefaultModule() {
		return null;
	}
	
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
		if (profileExecution && module instanceof ProfilableIErlModule) {
			ProfilableIErlModule profMod = (ProfilableIErlModule) module;
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
		
		ErlRunConfiguration erc = (ErlRunConfiguration) other;
		return
			Objects.equals(this.module, erc.module) &&
			Objects.equals(this.model, erc.model);
	}
}
