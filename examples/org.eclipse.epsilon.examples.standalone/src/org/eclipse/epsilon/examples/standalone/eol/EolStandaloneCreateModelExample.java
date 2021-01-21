/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.examples.standalone.eol;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.eclipse.epsilon.common.util.StringProperties;
import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.epsilon.eol.launch.EolRunConfiguration;

/**
 * This example demonstrates using the Epsilon Object Language, the core language of Epsilon, 
 * in a stand-alone manner, to create a new EMF model
 * 
 * @author Dimitrios Kolovos
 */
public class EolStandaloneCreateModelExample {
	
	public static void main(String[] args) throws Exception {
		Path root = Paths.get(EolStandaloneCreateModelExample.class.getResource("").toURI()),
			modelsRoot = root.getParent().resolve("models");
		
		EmfModel model = new EmfModel();
		model.setName("Model");
		model.setMetamodelFile(modelsRoot.resolve("Tree.ecore").toFile().getAbsolutePath());
		model.setModelFile(modelsRoot.resolve("Tree.new.xmi").toFile().getAbsolutePath());
		model.setReadOnLoad(false);
		model.setStoredOnDisposal(true);
		model.load();
		
		EolModule module = new EolModule();
		module.parse(EolStandaloneCreateModelExample.class.getResource("CreateTree.eol").toURI());
		module.getContext().getModelRepository().addModel(model);
		module.execute();
		
		model.dispose();
		System.out.println("Created new model in " + model.getModelFile());
	}
	
}
