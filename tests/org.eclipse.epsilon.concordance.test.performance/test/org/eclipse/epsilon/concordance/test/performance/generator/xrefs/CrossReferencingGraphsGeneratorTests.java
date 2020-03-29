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
package org.eclipse.epsilon.concordance.test.performance.generator.xrefs;

import java.io.File;
import java.util.Iterator;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.epsilon.common.dt.test.util.TestThatUsesAProject;
import org.eclipse.epsilon.emc.emf.EmfModelFactory;
import org.eclipse.epsilon.test.util.ModelWithEolAssertions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class CrossReferencingGraphsGeneratorTests extends TestThatUsesAProject {

	private static IProject project;
	private static ModelWithEolAssertions first, second, third;
	
	@BeforeClass
	public static void generateModel() throws Exception {
		project = createProject("test");
		
		final Iterator<File> generated = new CrossReferencingGraphsGenerator().generate(project.getLocation().toFile(), "Graph", 3).iterator();
		
		first  = new ModelWithEolAssertions(EmfModelFactory.getInstance().loadEmfModel("First",  generated.next(), "graph"));
		second = new ModelWithEolAssertions(EmfModelFactory.getInstance().loadEmfModel("Second", generated.next(), "graph"));
		third  = new ModelWithEolAssertions(EmfModelFactory.getInstance().loadEmfModel("Third",  generated.next(), "graph"));

	}
	
	@AfterClass
	public static void deleteProject() throws CoreException {
		deleteResource(project);
	}
	
	@Test
	public void modelsShouldNowContainOneHundredEdges() {
		first.assertEquals(100,  "Edge.all.size");
		second.assertEquals(100, "Edge.all.size");
		third.assertEquals(100,  "Edge.all.size");
	}
	
	@Test
	public void shouldProduceEdgesReferencingTwoNodes() {
		first.assertTrue("Edge.all.forAll(e|e.source.isDefined() and e.target.isDefined())");
		second.assertTrue("Edge.all.forAll(e|e.source.isDefined() and e.target.isDefined())");
		third.assertTrue("Edge.all.forAll(e|e.source.isDefined() and e.target.isDefined())");
	}
	
	@Test
	public void modelShouldContainTwentyCrossReferences() throws Throwable {
		first.assertEquals(20,  "Edge.all.select(e|'Graph2'.isSubstringOf(e.target.eResource().uri.toString()) or 'Graph3'.isSubstringOf(e.target.eResource().uri.toString())).size()");
		second.assertEquals(20, "Edge.all.select(e|'Graph1'.isSubstringOf(e.target.eResource().uri.toString()) or 'Graph3'.isSubstringOf(e.target.eResource().uri.toString())).size()");
		third.assertEquals(20,  "Edge.all.select(e|'Graph1'.isSubstringOf(e.target.eResource().uri.toString()) or 'Graph2'.isSubstringOf(e.target.eResource().uri.toString())).size()");
	}
}
