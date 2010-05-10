/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.eugenia;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.codegen.ecore.genmodel.GenModelPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.epsilon.commons.util.FileUtil;
import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.epsilon.eol.IEolExecutableModule;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.etl.EtlModule;
import org.eclipse.gmf.codegen.gmfgen.GMFGenPackage;

public class Ecore2GenModelDelegate extends EugeniaActionDelegate {
	
	@Override
	public IEolExecutableModule createBuiltinModule() {
		return new EtlModule();
	}
	
	@Override
	public String getBuiltinTransformation() {
		return "transformations/Ecore2GenModel.etl";
	}

	@Override
	public String getCustomizationTransformation() {
		return "Ecore2GenModel.eol";
	}
	
	@Override
	public List<EmfModel> getModels() throws Exception {
		
		List<EmfModel> models = new ArrayList<EmfModel>();
		
		models.add(loadModel("Ecore", gmfFileSet.getEcorePath(), EcorePackage.eINSTANCE.getNsURI(), true, false, true));
		models.add(loadModel("GenModel", gmfFileSet.getGenModelPath(), GenModelPackage.eINSTANCE.getNsURI(), false, true, false));
		
		return models;
	}

	@Override
	public List<Variable> getExtraVariables() {
		ArrayList<Variable> variables = new ArrayList<Variable>();
		variables.add(CopyrightProvider.getCopyrightVariable(getSelectedFile()));
		variables.add(Variable.createReadOnlyVariable("pluginName", getSelectedFile().getProject().getName()));
		variables.add(Variable.createReadOnlyVariable("foreignModel", getSelectedFile().getName()));
		return variables;
	}
	
	@Override
	public String getTitle() {
		return "Generating .genmodel";
	}

}
