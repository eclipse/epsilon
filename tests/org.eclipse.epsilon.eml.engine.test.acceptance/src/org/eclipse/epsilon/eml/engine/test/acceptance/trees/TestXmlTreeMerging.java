package org.eclipse.epsilon.eml.engine.test.acceptance.trees;

import java.io.File;
import java.util.HashMap;

import org.eclipse.epsilon.ecl.EclModule;
import org.eclipse.epsilon.emc.emf.xml.XmlModel;
import org.eclipse.epsilon.emc.plainxml.PlainXmlModel;
import org.eclipse.epsilon.eml.EmlModule;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestXmlTreeMerging {
	
	protected EclModule eclModule = null;
	protected EmlModule emlModule = null;
	protected PlainXmlModel mergedModel = null;
	
	protected HashMap<String, Object> info;
	
	@Before
	public void setup() throws Exception {
		
		PlainXmlModel leftModel = loadXmlModel("Left", "left.xml");
		PlainXmlModel rightModel = loadXmlModel("Right", "right.xml");
		leftModel.getAliases().add("Source");
		rightModel.getAliases().add("Right");
		
		eclModule = new EclModule();
		eclModule.parse(getClass().getResource("trees.ecl").toURI());
		info = new HashMap<String, Object>();
		eclModule.getContext().getFrameStack().put(Variable.createReadOnlyVariable("info", info));
		eclModule.getContext().getModelRepository().addModel(leftModel);
		eclModule.getContext().getModelRepository().addModel(rightModel);
		eclModule.execute();
		
		mergedModel = loadXmlModel("Merged", "merged.xml", false);
		emlModule = new EmlModule();
		emlModule.parse(getClass().getResource("trees.eml").toURI());
		emlModule.getContext().getFrameStack().put(Variable.createReadOnlyVariable("info", info));
		emlModule.getContext().getModelRepository().addModel(leftModel);
		emlModule.getContext().getModelRepository().addModel(rightModel);
		emlModule.getContext().setMatchTrace(eclModule.getContext().getMatchTrace().getReduced());
		emlModule.getContext().getModelRepository().addModel(mergedModel);
		emlModule.execute();
	}
	
	@Test
	public void testCorrectNumberOfElements() throws Exception {
		assertEquals(5, mergedModel.getAllOfKind("t_tree").size());
	}
	
	@Test
	public void testPreExecuted() {
		assertEquals("pre", info.get("pre"));		
	}
	
	@Test
	public void testPostExecuted() {
		assertEquals("post", info.get("post"));		
	}
	
	@Test
	public void testOverrideByName() {
		assertNotEquals(true, info.get("imported"));		
	}
	
	protected PlainXmlModel loadXmlModel(String name, String fileName, boolean readOnLoad) throws Exception {
		PlainXmlModel model = new PlainXmlModel();
		model.setName(name);
		model.setFile(new File(getClass().getResource(fileName).toURI()));
		model.setReadOnLoad(readOnLoad);
		model.load();
		return model;
	}
	
	protected PlainXmlModel loadXmlModel(String name, String fileName) throws Exception {
		return loadXmlModel(name, fileName, true);
	}
	
}
