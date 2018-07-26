/*******************************************************************************
 * Copyright (c) 2009 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************
 *
 * $Id$
 */
package org.eclipse.concordance.test.performance;

import org.eclipse.concordance.test.performance.generator.metamodel.MixedGraphAndEcoreGenerator;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.epsilon.concordance.clients.migration.AutomaticMigrationIntegrationTest;
import org.junit.Before;
import org.junit.Test;

public class ConformanceCheckerPerformanceTests extends AutomaticMigrationIntegrationTest {
	
	@Before @Override
	public void setupNature() throws CoreException, InterruptedException {
		new MixedGraphAndEcoreGenerator().generate(project.getLocation().toFile(), 100, 10);		
		refreshContents(project);
		System.out.println(project.members().length - 1 + " models were generated.");
		
		addConcordanceNature(project);
		waitFor(eventsForNewFiles(modelsIn(project)));
		
		printTimes("Indexing");
		printTimes("DetermineNsUri");
		//Profiler.INSTANCE.reset();
	}

	@Test
	public void timeConformance() throws Exception {
		registerMetamodel(dynamicallyLoadPackage("org.eclipse.epsilon.concordance.test.performance", "/src/org/eclipse/concordance/test/performance/ModifiedGraph.ecore"));
		
		Thread.sleep(30000);
		
		printTimes("FindingAllInstances");
		printTimes("Conformance");
	}

	
	private void printTimes(String type) {
		//System.out.println(type + " was executed " + Profiler.INSTANCE.getExecutionCount(type) + " times.");
		//System.out.println("Aggregated total: " + Profiler.INSTANCE.getTotalTime(type, true));
		//System.out.println("Individual total: " + Profiler.INSTANCE.getTotalTime(type, false));
	}
}
