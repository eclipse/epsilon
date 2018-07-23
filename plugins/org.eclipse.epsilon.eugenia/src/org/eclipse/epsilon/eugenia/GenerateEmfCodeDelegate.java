/*******************************************************************************
 * Copyright (c) 2012 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
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
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.jface.action.IAction;

public class GenerateEmfCodeDelegate extends EugeniaActionDelegate {

	@Override
	public void runImpl(IAction action) throws Exception {
		
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource resource = resourceSet.createResource(URI.createURI(gmfFileSet.getGenModelPath()));
		resource.load(null);
		EcoreUtil.resolveAll(resourceSet);

		// If the EPackage uses other EPackages and those use other EPackages as well, we'll need
		// to keep calling reconcile() iteratively until we reach a fixed point - bug 495925
		GenModel genModel = (GenModel) resource.getContents().get(0);
		int oldSize;
		do {
			oldSize = genModel.getGenPackages().size();
			genModel.reconcile();
		} while (genModel.getGenPackages().size() != oldSize);
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
	public EugeniaActionDelegateStep getStep() {
		return EugeniaActionDelegateStep.emfcode;
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
