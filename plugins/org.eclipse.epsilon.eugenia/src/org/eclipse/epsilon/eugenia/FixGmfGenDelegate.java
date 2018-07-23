/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.eugenia;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.codegen.ecore.genmodel.GenModelPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.gmf.codegen.gmfgen.GMFGenPackage;
import org.eclipse.gmf.gmfgraph.GMFGraphPackage;
import org.eclipse.gmf.mappings.GMFMapPackage;
import org.eclipse.gmf.tooldef.GMFToolPackage;

public class FixGmfGenDelegate extends EugeniaActionDelegate {
	
	@Override
	public String getBuiltinTransformation() {
		return "transformations/FixGMFGen.eol";
	}

	@Override
	public String getCustomizationTransformation() {
		return "FixGMFGen.eol";
	}
	
	@Override
	public EugeniaActionDelegateStep getStep() {
		return EugeniaActionDelegateStep.gmfgen;
	}
	
	@Override
	public List<IModel> getModels() throws Exception {
		List<IModel> models = new ArrayList<IModel>();

		// Antonio: GmfGen needs to be disposed before all the others: otherwise, all its contents
		// disappear during disposal and we end up saving an empty model. It only happens when we
		// refer to something in the .genmodel from the .gmfgen model, as we do for the new
		// 'label.parser' annotation.
		models.add(loadModel("GmfGen", gmfFileSet.getGmfGenPath(), GMFGenPackage.eINSTANCE.getNsURI(), true, true, false));

		models.add(loadModel("ECore", gmfFileSet.getEcorePath(), EcorePackage.eNS_URI, true, false, true));
		models.add(loadModel("GenModel", gmfFileSet.getGenModelPath(), GenModelPackage.eINSTANCE.getNsURI(), true, false, false));
		models.add(loadModel("GmfGraph", gmfFileSet.getGmfGraphPath(), GMFGraphPackage.eINSTANCE.getNsURI(), true, false, false));
		models.add(loadModel("GmfTool", gmfFileSet.getGmfToolPath(), GMFToolPackage.eINSTANCE.getNsURI(), true, false, false));
		models.add(loadModel("GmfMap", gmfFileSet.getGmfMapPath(), GMFMapPackage.eINSTANCE.getNsURI(), true, false, false));

		return models;
	}

	@Override
	public List<Variable> getExtraVariables() {
		ArrayList<Variable> variables = new ArrayList<Variable>();
		variables.add(CopyrightProvider.getCopyrightVariable(getSelectedFile()));
		return variables;
	}
	
	@Override
	public String getTitle() {
		return "Synchronizing .gmfgen model";
	}

}
