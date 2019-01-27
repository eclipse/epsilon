/*********************************************************************
 * Copyright (c) 2018 The University of York.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.ecl.engine.test.acceptance;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Supplier;

import org.eclipse.epsilon.common.util.StringProperties;
import org.eclipse.epsilon.ecl.*;
import org.eclipse.epsilon.ecl.concurrent.*;
import org.eclipse.epsilon.ecl.launch.EclRunConfiguration;
import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.epsilon.eol.engine.test.acceptance.util.EolAcceptanceTestUtil;

/**
 * 
 * @author Sina Madani
 * @since 1.6
 */
public class EclAcceptanceTestUtil extends EolAcceptanceTestUtil {
	protected EclAcceptanceTestUtil() {}
	
	static final String testsBase = getTestBaseDir(EclAcceptanceTestUtil.class);

	@SafeVarargs
	public static Collection<EclRunConfiguration> getScenarios(Supplier<? extends IEclModule>... moduleGetters) {
		ArrayList<EclRunConfiguration> scenarios = new ArrayList<>();
		
		String matchesRoot = testsBase+"/matches/";
		Path matchesMM = Paths.get(matchesRoot+"mymetamodel.ecore");
		StringProperties
			leftModelProps = createModelProperties(matchesMM, Paths.get(matchesRoot+"Left.model")),
			rightModelProps = createModelProperties(matchesMM, Paths.get(matchesRoot+"Right.model"));
		
		for (Supplier<? extends IEclModule> moduleSup : moduleGetters) {
			scenarios.add(EclRunConfiguration.Builder()
				.withScript(matchesRoot+"CompareInstance")
				.withModel(new EmfModel(), leftModelProps)
				.withModel(new EmfModel(), rightModelProps)
				.withModule(moduleSup.get())
				.build()
			);
		}
		
		return scenarios;
	}
	
	public static Collection<Supplier<? extends IEclModule>> modules() {
		return parallelModules(THREADS, EclModule::new, EclModuleParallel::new/*, EclModuleParallelRules::new*/);
	}
}
