package org.eclipse.epsilon.emc.plainxml;

import java.io.File;

import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;

public class Workbench {
	
	
	public static void main(String[] args) throws Exception {
		new Workbench().run();
	}
	
	public void run() throws Exception {
		String dir = "E:/Projects/Eclipse/3.5.1/workspace/org.eclipse.epsilon.emc.plainxml/src/org/eclipse/epsilon/emc/plainxml/";
		
		EolModule module = new EolModule();
		module.parse(new File(dir + "testplainxml.eol"));

		//module.getContext().getModelRepository().addModel(createModel("XML", "http://www.eclipse.org/forums/rdf.php?mode=m&l=1&basic=1&frm=22&n=10", false));
		module.getContext().getModelRepository().addModel(createModel("XML", dir + "test.xml", true));
		//module.getContext().getModelRepository().addModel(createModel("XML2", dir + "test2.xml"));
		//module.getContext().getModelRepository().addModel(createModel("XML", dir + "test3.xml", true));
		
		module.execute();
		module.getContext().getModelRepository().dispose();
		
		
	}
	
	public PlainXmlModel createModel(String name, String path, boolean file) throws EolModelLoadingException{
		PlainXmlModel model = new PlainXmlModel();
		model.setName(name);
		if (file) {
			model.setFile(new File(path));
		}
		else {
			model.setUri(path);
		}
		model.setReadOnLoad(false);
		model.setStoredOnDisposal(true);
		model.load();
		return model;
	}
	
}
