package org.eclipse.epsilon.eol.engine.test.acceptance;

import static org.junit.Assert.assertEquals;

import java.util.Collection;

import org.eclipse.epsilon.emc.plainxml.PlainXmlModel;
import org.eclipse.epsilon.eol.EolModule;
import org.junit.Test;

public class ContextlessFirstOrderOperationTests {
	
	@Test
	public void testContextlessModelElementTypeSelect() throws Exception {
		assertEquals(2, ((Collection<?>) run("return select(a : t_a | true);", "<a><a/></a>")).size());
	}
	
	@Test
	public void testContextlessModelElementTypeCollect() throws Exception {
		assertEquals(2, run("return collect(a : t_a | 1).sum();", "<a><a/></a>"));
	}
	
	@Test
	public void testContextlessIntegerCollect() throws Exception {
		assertEquals(0, run("return collect(a : Integer | 1).sum();", "<a><a/></a>"));
	}
	
	public Object run(String eol, String xml) throws Exception {
		EolModule module = new EolModule();
		module.parse(eol);
		
		PlainXmlModel model = new PlainXmlModel();
		model.setName("M");
		model.setXml("<?xml version=\"1.0\"?>" + xml);
		model.load();
		
		module.getContext().getModelRepository().addModel(model);	
		
		return module.execute();
	}
	
}
