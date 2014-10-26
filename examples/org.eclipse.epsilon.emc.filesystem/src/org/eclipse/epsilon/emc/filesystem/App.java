package org.eclipse.epsilon.emc.filesystem;

import java.io.File;

import org.eclipse.epsilon.eol.EolModule;

public class App {
	
	public static void main(String[] args) throws Exception {
		
		EolModule module = new EolModule();		
		module.parse("Tester.all.println();");
		
		/*
		module.parse("var tester = Tester.all.selectOne(t|t.p_name = 'Tom Jones');" + 
					 "var requirementIds = tester.p_requirements.split(',');" +
					 "Requirement.all.select(r|requirementIds.includes(r.name)).p_priority.println();");
		*/
		
		FilesystemModel model = new FilesystemModel(new File("test-data"));
		model.setName("M");
		module.getContext().getModelRepository().addModel(model);
		
		module.execute();
	}
}
