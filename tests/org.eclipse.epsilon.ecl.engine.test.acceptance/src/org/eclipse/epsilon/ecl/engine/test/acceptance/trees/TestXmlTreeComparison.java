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
import java.util.function.Supplier;
import org.eclipse.epsilon.ecl.IEclModule;
import org.eclipse.epsilon.ecl.engine.test.acceptance.EclAcceptanceTestUtil;
import org.eclipse.epsilon.emc.plainxml.PlainXmlModel;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class TestXmlTreeComparison {
	
	protected IEclModule module;
	protected HashMap<String, Object> prepost;
	
	@Parameter
	public Supplier<? extends IEclModule> moduleGetter;
	
	@Parameters(name = "{0}")
	public static Iterable<Supplier<? extends IEclModule>> modules() {
		return EclAcceptanceTestUtil.modules();
	}
	
	@Before
	public void setup() throws Exception {
		module = moduleGetter.get();
		module.parse(getClass().getResource("trees.ecl").toURI());
		prepost = new HashMap<>();
		module.getContext().getFrameStack().put(Variable.createReadOnlyVariable("prepost", prepost));
		loadXmlModel("Left", "left.xml");
		loadXmlModel("Right", "right.xml");
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
		module.getContext().getModelRepository().addModel(model);
		return model;
	}
	
}
