package org.eclipse.epsilon.eol.engine.test.acceptance.util;

import static org.eclipse.epsilon.emc.emf.EmfModel.*;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import org.eclipse.epsilon.common.concurrent.ConcurrencyUtils;
import org.eclipse.epsilon.common.util.FileUtil;
import org.eclipse.epsilon.common.util.StringProperties;
import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.epsilon.eol.IEolModule;
import org.eclipse.epsilon.eol.launch.IEolRunConfiguration;
import org.eclipse.epsilon.eol.models.IModel;

public class EolAcceptanceTestUtil {
	private EolAcceptanceTestUtil() {}
	
	public static final int[] THREADS = new int[] {
		0, 1, 2, 3, 4,
		(ConcurrencyUtils.DEFAULT_PARALLELISM/2)+1,
		(ConcurrencyUtils.DEFAULT_PARALLELISM*2)-1,
		Byte.MAX_VALUE,
		//0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16,
		//Short.MAX_VALUE/8
	};
	
	public static List<String[]> addAllInputs(String[] scripts, String[] models, String metamodel, String scriptExt, String scriptRoot, String modelRoot, String metamodelRoot) {
		ArrayList<String[]> inputsCol = new ArrayList<>(scripts.length*models.length);
		for (String script : scripts) {
			for (String model : models) {
				inputsCol.add(new String[] {
					scriptRoot+script+'.'+scriptExt,
					modelRoot+model,
					metamodelRoot+metamodel
				});
			}
		}
		return inputsCol;
	}
	
	public static int getScenarioID(String[] inputs) {
		return Arrays.deepHashCode(inputs);
	}
	
	/**
	 * A list of pre-configured Runnables which will call the execute() method on the provided module.
	 * @param modules A collection of IEolModules to use in combination with each set of test data.
	 */
	public static <M extends IEolModule, C extends IEolRunConfiguration<M, ?>> Collection<C> getScenarios(
		Class<C> clazz,
		List<String[]> testInputs,
		Collection<Supplier<? extends M>> moduleGetters,
		Function<String[], Integer> idCalculator) {
		try {
			if (idCalculator == null) idCalculator = EolAcceptanceTestUtil::getScenarioID;
			
			List<C> scenarios = new ArrayList<>(moduleGetters.size()*(testInputs.size()+2));
			Optional<Boolean> showResults = Optional.of(false), profileExecution = Optional.of(false);
			
			for (String[] testInput : testInputs) {
				Path eolScript = Paths.get(testInput[0]);
				
				Path modelFile = Paths.get(testInput[1]);
				Path metamodelFile = Paths.get(testInput[2]);
				StringProperties properties = new StringProperties();
				properties.put(PROPERTY_READONLOAD, true);
				properties.put(PROPERTY_CACHED, true);
				properties.put(PROPERTY_STOREONDISPOSAL, true);
				properties.put(PROPERTY_NAME, FileUtil.removeExtension(modelFile.getFileName().toString()));
				properties.put(PROPERTY_MODEL_URI, modelFile.toUri().toString());
				properties.put(PROPERTY_FILE_BASED_METAMODEL_URI, metamodelFile.toUri().toString());
				
				IModel model = new EmfModel();
				
				for (Supplier<? extends M> moduleGetter : moduleGetters) {
					scenarios.add(clazz.getConstructor(
							Path.class,
							Map.class,
							Optional.class,
							Optional.class,
							Optional.class,
							Optional.class,
							Optional.class,
							Optional.class
						)
						.newInstance(
							eolScript,									 // Path to the script to run
							Collections.singletonMap(model, properties), // Model and metamodel paths
							Optional.of(moduleGetter.get()),			 // IEolModule
							Optional.empty(),							 // Script parameters
							showResults,								 // Whether to show results
							profileExecution,							 // Whether to measure execution time
							Optional.of(idCalculator.apply(testInput)),	 // Unique identifier for this configuration
							Optional.empty()							 // Output file
						)
					);
				}
			}
			
			return scenarios;
		}
		catch (SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
	}
	
	public static <M extends IEolModule> Collection<? extends M> unwrapModules(Collection<Supplier<? extends M>> moduleGetters) {
		return moduleGetters.stream().map(Supplier::get).collect(Collectors.toList());
	}
	
	@SafeVarargs
	public static <M extends IEolModule> Collection<Supplier<? extends M>> parallelModules(int[] parallelisms, Supplier<M> standardModuleGetter, Function<Integer, M>... parallelModuleConstructors) {
		Collection<Supplier<? extends M>> modules = new ArrayList<>(1+(parallelModuleConstructors.length*parallelisms.length));
		if (standardModuleGetter != null) {
			modules.add(standardModuleGetter);
		}
		for (int thread : parallelisms) {
			for (Function<Integer, M> constructor : parallelModuleConstructors) {
				modules.add(() -> constructor.apply(thread));
			}
		}
		return modules;
	}
	
	@SafeVarargs
	public static <M extends IEolModule> Collection<Supplier<? extends M>> parallelModules(Supplier<M> standardModuleGetter, Function<Integer, M>... moduleConstructors) {
		return parallelModules(THREADS, standardModuleGetter, moduleConstructors);
	}
}
