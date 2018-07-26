/*********************************************************************
* Copyright (c) 2008 The University of York.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.etl.engine.test.acceptance.tree2graph;

import static org.junit.Assert.assertTrue;

import java.io.File;

import org.eclipse.epsilon.etl.engine.test.acceptance.EtlTest;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.epsilon.etl.EtlModule;
import org.eclipse.epsilon.test.util.ResourceComparator;
import org.junit.Test;

public class Tree2GraphTest extends EtlTest {

	@Test
	public void testTree2GraphTransformation() throws Exception {
		
		EtlModule module = new EtlModule();
		module.parse(new File(getFullPath("Tree2Graph.etl")));
		
		registerMetamodel("models/Tree.ecore");
		registerMetamodel("models/Graph.ecore");
		
		EmfModel graphModel = loadModel("Graph", "models/graph.model", "Graph", false, false);
		
		module.getContext().getModelRepository().addModel(loadModel("Tree", "models/tree.model", "Tree", true, false));
		module.getContext().getModelRepository().addModel(graphModel);
		
		module.execute();
		
		Resource graphModelOracle = getResource("models/graph.model");
		
		assertTrue(new ResourceComparator().compare(graphModelOracle, graphModel.getModelImpl()));
		
		module.getContext().dispose();		
	}
	
}
