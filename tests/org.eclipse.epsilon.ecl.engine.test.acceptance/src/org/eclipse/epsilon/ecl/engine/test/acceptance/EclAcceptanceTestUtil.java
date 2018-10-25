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

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Supplier;
import org.eclipse.epsilon.ecl.*;
import org.eclipse.epsilon.ecl.concurrent.*;
import org.eclipse.epsilon.ecl.launch.EclRunConfiguration;
import org.eclipse.epsilon.eol.engine.test.acceptance.util.EolAcceptanceTestUtil;

public class EclAcceptanceTestUtil extends EolAcceptanceTestUtil {
	protected EclAcceptanceTestUtil() {}
	
	@SafeVarargs
	public static Collection<EclRunConfiguration> getScenarios(Supplier<? extends IEclModule>... moduleGetters) {
		ArrayList<EclRunConfiguration> scenarios = new ArrayList<>();
		//TODO implement
		return scenarios;
	}
	
	public static Collection<Supplier<? extends IEclModule>> modules() {
		return parallelModules(THREADS, EclModule::new, EclModuleParallel::new/*, EclModuleParallelRules::new*/);
	}
}
