/*********************************************************************
* Copyright (c) 2008 The University of York.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.ecl.engine.test.acceptance.trees;

import java.io.File;
import java.util.HashMap;

import org.eclipse.epsilon.ecl.EclModule;
import org.eclipse.epsilon.emc.plainxml.PlainXmlModel;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestXmlTreeComparison {
	
	protected EclModule module = null;
	protected HashMap<String, Object> prepost;
	
	@Before
	public void setup() throws Exception {
		module = new EclModule();
		module.parse(getClass().getResource("trees.ecl").toURI());
		prepost = new HashMap<String, Object>();
		module.getContext().getFrameStack().put(Variable.createReadOnlyVariable("prepost", prepost));
		module.getContext().getModelRepository().addModel(loadXmlModel("Left", "left.xml"));
		module.getContext().getModelRepository().addModel(loadXmlModel("Right", "right.xml"));
		module.execute();
	}
	
	@Test
	public void testCorrectNumberOfMatches() throws Exception {
		// t1 and t2 should match only
		assertEquals(2, module.getContext().getMatchTrace().getReduced().getMatches().size());
	}
	
	@Test
	public void testPreExecuted() {
		assertEquals("pre", prepost.get("pre"));		
	}
	
	@Test
	public void testPostExecuted() {
		assertEquals("post", prepost.get("post"));		
	}
	
	protected PlainXmlModel loadXmlModel(String name, String fileName) throws Exception {
		PlainXmlModel model = new PlainXmlModel();
		model.setName(name);
		model.setFile(new File(getClass().getResource(fileName).toURI()));
		model.load();
		return model;
	}
	
}
