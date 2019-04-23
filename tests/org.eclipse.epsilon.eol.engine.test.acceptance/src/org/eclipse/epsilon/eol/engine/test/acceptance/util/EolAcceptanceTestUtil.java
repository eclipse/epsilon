/*********************************************************************
 * Copyright (c) 2018 The University of York.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.eol.engine.test.acceptance.util;

import static org.eclipse.epsilon.emc.emf.EmfModel.PROPERTY_FILE_BASED_METAMODEL_URI;
import static org.eclipse.epsilon.emc.emf.EmfModel.PROPERTY_MODEL_URI;
import static org.eclipse.epsilon.eol.models.CachedModel.PROPERTY_CACHED;
import static org.eclipse.epsilon.eol.models.CachedModel.PROPERTY_CONCURRENT;
import static org.eclipse.epsilon.eol.models.Model.PROPERTY_NAME;
import static org.eclipse.epsilon.eol.models.Model.PROPERTY_READONLOAD;
import static org.eclipse.epsilon.eol.models.Model.PROPERTY_STOREONDISPOSAL;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import org.eclipse.epsilon.common.util.FileUtil;
import org.eclipse.epsilon.common.util.StringProperties;
import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.epsilon.eol.IEolModule;
import org.eclipse.epsilon.eol.concurrent.EolModuleParallel;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.launch.IEolRunConfiguration;
import org.eclipse.epsilon.test.util.EpsilonTestUtil;

/**
 * 
 * @author Sina Madani
 * @since 1.6
 */
public class EolAcceptanceTestUtil extends EpsilonTestUtil {
	protected EolAcceptanceTestUtil() {}
	
	public static void testExceptionEquivalenceBetweenModules(String code) throws Exception {
		EolRuntimeException expectedException = executeReturnException(code, new EolModule());
		EolRuntimeException actualException = executeReturnException(code, new EolModuleParallel());
		testExceptionEquivalence(expectedException, actualException);
	}
	
	public static EolRuntimeException executeReturnException(String code, IEolModule module) throws Exception {
		try {
			module.parse(code);
			module.execute();
			return null;
		}
		catch (EolRuntimeException ex) {
			return ex;
		}
	}
	
	public static void testExceptionEquivalence(EolRuntimeException expected, EolRuntimeException actual) {
		assertNotNull(expected);
		assertNotNull(expected);
		assertEquals(expected.getAst().toString(), actual.getAst().toString());
	}
	
	public static final int[] THREADS = {
		0, 1, 2, 3, 10, Byte.MAX_VALUE/2
		//(ConcurrencyUtils.DEFAULT_PARALLELISM/2)+1,
		//(ConcurrencyUtils.DEFAULT_PARALLELISM*2)-1
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
	
	public static StringProperties createModelProperties(Path modelFile, Path metamodelFile) {
		StringProperties properties = new StringProperties();
		properties.put(PROPERTY_READONLOAD, true);
		properties.put(PROPERTY_CACHED, true);
		properties.put(PROPERTY_CONCURRENT, true);
		properties.put(PROPERTY_STOREONDISPOSAL, false);
		properties.put(PROPERTY_NAME, FileUtil.removeExtension(modelFile.getFileName().toString()));
		properties.put(PROPERTY_MODEL_URI, modelFile.toUri().toString());
		properties.put(PROPERTY_FILE_BASED_METAMODEL_URI, metamodelFile.toUri().toString());
		return properties;
	}
	
	public static <M extends IEolModule, C extends IEolRunConfiguration> Collection<C> getScenarios(
			Class<C> clazz,
			List<String[]> testInputs,
			Collection<Supplier<? extends M>> moduleGetters,
			Function<String[], Integer> idCalculator) {

		if (idCalculator == null) idCalculator = EolAcceptanceTestUtil::getScenarioID;
		
		List<C> scenarios = new ArrayList<>(moduleGetters.size()*(testInputs.size()+2));
		
		for (String[] testInput : testInputs) {
			Path eolScript = Paths.get(testInput[0]);
			
			Path modelFile = Paths.get(testInput[1]);
			Path metamodelFile = Paths.get(testInput[2]);
			
			for (Supplier<? extends M> moduleGetter : moduleGetters) {
				scenarios.add(IEolRunConfiguration.Builder(clazz)
					.withScript(eolScript)
					.withModel(new EmfModel(), createModelProperties(modelFile, metamodelFile))
					.withModule(moduleGetter.get())
					.withId(idCalculator.apply(testInput))
					.build()
				);
			}
		}
		
		return scenarios;
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
}
