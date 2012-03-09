/*******************************************************************************
 * Copyright (c) 2009 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************
 *
 * $Id$
 */
package org.eclipse.concordance.test.performance;

import java.util.Random;

import org.eclipse.concordance.test.performance.generator.xrefs.CrossReferencingGraphsGenerator;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.epsilon.concordance.clients.test.ConcordanceClientIntegrationTest;
import org.eclipse.epsilon.concordance.history.ConcordanceHistory.EventType;
import org.junit.Before;
import org.junit.Test;

public class CrossReferenceReconcilerPerformanceTests extends ConcordanceClientIntegrationTest {

	private static final int NUMBER_OF_MODELS     = 100;
	private static final int NUMBER_OF_OPERATIONS = 10;
	
	
	@Before @Override
	public void setupNature() throws CoreException, InterruptedException {
		new CrossReferencingGraphsGenerator().generate(project.getLocation().toFile(), "Graph", NUMBER_OF_MODELS);
		
		refreshContents(project);
		System.out.println(project.members().length - 1 + " models were generated.");
		
		addConcordanceNature(project);
		waitFor(eventsForNewFiles(modelsIn(project)));
		
		printTimes("Indexing");
		
		//Profiler.INSTANCE.reset();
	}

	@Test
	public void delete() throws CoreException, InterruptedException {
		for (int index = 1; index <= NUMBER_OF_OPERATIONS; index++) {
			final IFile randomGraph = randomGraph();
			
			System.out.println("Deleting: " + randomGraph.getName());
			deleteResource(randomGraph);
			waitFor(event(EventType.DELETE, randomGraph));
		}
		
		printTimes("Delete");
	}
	
	@Test
	public void move() throws CoreException, InterruptedException {
		for (int index = 1; index <= NUMBER_OF_OPERATIONS; index++) {
			IFile randomGraph    = randomGraph();
			final String newPath = randomGraph.getName().replace("Graph", "Moved");
			
			System.out.println("Moving: " + randomGraph.getName() + " to " + newPath);
			randomGraph = moveFile(randomGraph, newPath);
			waitFor(event(EventType.MOVE, randomGraph));
		}
		
		printTimes("Move");
	}

	@Test
	public void change() throws CoreException, InterruptedException {
		for (int index = 1; index <= NUMBER_OF_OPERATIONS; index++) {
			final IFile randomGraph = randomGraph();
			
			System.out.println("Changing: " + randomGraph.getName());
			new GraphUpdater().update(randomGraph.getLocation().toFile());
			randomGraph.refreshLocal(IResource.DEPTH_ZERO, null);
			
			waitFor(event(EventType.CHANGE, randomGraph));
		}
		
		printTimes("Change");
	}
	
	
	private void printTimes(String type) {
		//System.out.println(type + " was executed " + Profiler.INSTANCE.getExecutionCount(type) + " times.");
		//System.out.println("Aggregated total: " + Profiler.INSTANCE.getTotalTime(type, true));
		//System.out.println("Individual total: " + Profiler.INSTANCE.getTotalTime(type, false));
	}
	
	
	private IFile randomGraph() throws CoreException {
		IResource graph = null;
		final Random rnd = new Random();
		
		do {
			graph = project.findMember("Graph" + (rnd.nextInt(100) + 1) + ".model");
		} while (graph == null || !graph.exists());
		
		return (IFile)graph;
	}
}
