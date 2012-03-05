package org.eclipse.epsilon.eugenia;

import java.util.List;

import org.eclipse.emf.codegen.ecore.generator.Generator;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.generator.GenBaseGeneratorAdapter;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.jface.action.IAction;

public class GenerateEmfCodeDelegate extends EugeniaActionDelegate {

	@Override
	public void runImpl(IAction action) throws Exception {
		
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource resource = resourceSet.createResource(URI.createURI(gmfFileSet.getGenModelPath()));
		resource.load(null);
		GenModel genModel = (GenModel) resource.getContents().get(0);
		
		genModel.setCanGenerate(true);
		
		// generate the code
		Generator generator = new Generator();
		generator.setInput(genModel);
		generator.generate(genModel,
				GenBaseGeneratorAdapter.MODEL_PROJECT_TYPE,
				new BasicMonitor.Printing(System.err));
		generator.generate(genModel,
				GenBaseGeneratorAdapter.EDIT_PROJECT_TYPE,
				new BasicMonitor.Printing(System.err));
		generator.generate(genModel,
				GenBaseGeneratorAdapter.EDITOR_PROJECT_TYPE,
				new BasicMonitor.Printing(System.err));
		generator.generate(genModel,
				GenBaseGeneratorAdapter.TESTS_PROJECT_TYPE,
				new BasicMonitor.Printing(System.err));
		
	}
	
	@Override
	public String getBuiltinTransformation() {
		return null;
	}

	@Override
	public String getCustomizationTransformation() {
		return null;
	}

	@Override
	public List<IModel> getModels() throws Exception {
		return null;
	}

	@Override
	public String getTitle() {
		return "Generating EMF model, edit, editor and test code";
	}

}
