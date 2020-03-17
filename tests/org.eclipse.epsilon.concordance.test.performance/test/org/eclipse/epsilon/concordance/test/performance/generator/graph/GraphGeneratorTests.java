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
package org.eclipse.epsilon.concordance.test.performance.generator.graph;

import java.io.File;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.epsilon.common.dt.test.util.TestThatUsesAProject;
import org.eclipse.epsilon.concordance.test.performance.generator.graph.GraphGenerator;
import org.eclipse.epsilon.emc.emf.EmfModelFactory;
import org.eclipse.epsilon.test.util.ModelWithEolAssertions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class GraphGeneratorTests extends TestThatUsesAProject {

	private static IProject project;
	private static ModelWithEolAssertions model;
	
	@BeforeClass
	public static void generateModel() throws Exception {
		project           = createProject("test");
		final File target = createEmptyFile(project, "Graph.model").getLocation().toFile();
		
		new GraphGenerator().generate(target);
		
		model = new ModelWithEolAssertions(EmfModelFactory.getInstance().loadEmfModel("Model", target, "graph"));
	}
	
	@AfterClass
	public static void deleteProject() throws CoreException {
		deleteResource(project);
	}
	
	
	@Test
	public void shouldProduceOneGraph() {
		model.assertEquals(1, "Graph.all.size");
	}
	
	@Test
	public void shouldProduceOneHundredNodes() {
		model.assertEquals(100, "Node.all.size");
	}
	
	@Test
	public void shouldProduceNodesContainedInGraph() {
		model.assertTrue("Node.all.forAll(n|Graph.all.first.nodes.includes(n))");
	}
	
	@Test
	public void shouldProduceEightyEdges() {
		model.assertEquals(80, "Edge.all.size");
	}
	
	@Test
	public void shouldProduceEdgesReferencingTwoNodes() {
		model.assertTrue("Edge.all.forAll(e|e.source.isDefined() and e.target.isDefined())");
	}
}
