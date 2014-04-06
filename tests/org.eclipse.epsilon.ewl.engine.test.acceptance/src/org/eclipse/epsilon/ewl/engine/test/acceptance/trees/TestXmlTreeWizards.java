package org.eclipse.epsilon.ewl.engine.test.acceptance.trees;

import java.io.File;
import java.util.HashMap;

import org.eclipse.epsilon.emc.plainxml.PlainXmlModel;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.ewl.EwlModule;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestXmlTreeWizards {
	
	protected EwlModule module = null;
	protected HashMap<String, Object> info;
	protected PlainXmlModel model = null;
	
	@Before
	public void setup() throws Exception {
		module = new EwlModule();
		module.parse(getClass().getResource("trees.ewl").toURI());
		info = new HashMap<String, Object>();
		model = loadXmlModel("Tree", "tree.xml");
		module.getContext().getFrameStack().put(Variable.createReadOnlyVariable("info", info));
		module.getContext().getModelRepository().addModel(model);
	}
	
	@Test
	public void testCorrectNumberOfWizards() throws Exception {
		Object t1 = model.getAllOfType("t_tree").iterator().next();
		assertEquals(1, module.getWizardsFor(t1).size());
	}

	@Test
	public void testCorrectTitle() throws Exception {
		Object t1 = model.getAllOfType("t_tree").iterator().next();
		assertEquals("Delete t1", module.getWizardsFor(t1).get(0).getTitle());
	}
	
	@Test
	public void testExecute() throws Exception {
		Object t1 = model.getAllOfType("t_tree").iterator().next();
		module.getWizardsFor(t1).get(0).process();
		assertEquals(true, info.get("deleted"));
	}
	
	protected PlainXmlModel loadXmlModel(String name, String fileName) throws Exception {
		PlainXmlModel model = new PlainXmlModel();
		model.setName(name);
		model.setFile(new File(getClass().getResource(fileName).toURI()));
		model.load();
		return model;
	}
	
}
