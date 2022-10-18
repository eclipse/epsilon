package org.eclipse.epsilon.examples.standalone.egl.flexmiemfatic;

import java.nio.file.Paths;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.emfatic.core.EmfaticResourceFactory;
import org.eclipse.epsilon.egl.EglTemplateFactoryModuleAdapter;
import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.epsilon.flexmi.FlexmiResourceFactory;

public class EglFlexmiEmfaticStandaloneExample {

	public static void main(String[] args) throws Exception {

		// Make Flexmi and Emfatic known to EMF as we will use them
		// to express the input model and metamodel of the transformation
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("flexmi", new FlexmiResourceFactory());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("emf", new EmfaticResourceFactory());
		
		// Parse the EGL template
		EglTemplateFactoryModuleAdapter module = new EglTemplateFactoryModuleAdapter();
		module.parse(EglFlexmiEmfaticStandaloneExample.class.getResource("project2html.egl"));
		
		// Configure its source model
		EmfModel model = new EmfModel();
		model.setModelFile(Paths.get(EglFlexmiEmfaticStandaloneExample.class.getResource("psl.flexmi").toURI()).toFile().getAbsolutePath());
		model.setMetamodelFile(Paths.get(EglFlexmiEmfaticStandaloneExample.class.getResource("psl.emf").toURI()).toFile().getAbsolutePath());
		model.setName("M");
		model.load();
		module.getContext().getModelRepository().addModel(model);

		// Execute the EGL template and print its output
		System.out.println(module.execute());
	}

}
