package org.eclipse.epsilon.emc.filesystem;

import java.io.File;

import org.eclipse.epsilon.eol.EolModule;

public class App {
	
	public static void main(String[] args) throws Exception {
		
		EolModule module = new EolModule();
		module.parse("File.all.selectOne(f|f.name = 'test.txt').println();");
		
		FilesystemModel model = new FilesystemModel(new File("."));
		model.setName("M");
		module.getContext().getModelRepository().addModel(model);
		
		module.execute();
	}
	
}
