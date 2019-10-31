/*********************************************************************
* Copyright (c) 2008 The University of York.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.eugenia;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.epsilon.eol.IEolModule;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.eugenia.operationcontributors.ContextlessOperationContributor;
import org.eclipse.epsilon.eugenia.operationcontributors.EClassOperationContributor;
import org.eclipse.epsilon.eugenia.operationcontributors.EModelElementOperationContributor;

public class AnnotateEcoreDelegate extends EugeniaActionDelegate {
	
	protected boolean saveEcore = false;
	
	public AnnotateEcoreDelegate setSaveEcore(boolean saveEcore) {
		this.saveEcore = saveEcore;
		return this;
	}
	
	@Override
	public String getTitle() {
		return "Annotating .ecore";
	}

	@Override
	public EugeniaActionDelegateStep getStep() {
		return EugeniaActionDelegateStep.annotate;
	}
	
	@Override
	public List<IModel> getModels() throws Exception {
		List<IModel> models = new ArrayList<>();
		final EmfModel ecoreModel = loadModel("Ecore", gmfFileSet.getEcorePath(), EcorePackage.eINSTANCE.getNsURI(), true, saveEcore, true);
		models.add(ecoreModel);
		return models;
	}

	@Override
	public String getBuiltinTransformation() {
		return "transformations/AnnotateEcore.eol";
	}

	@Override
	public String getCustomizationTransformation() {
		return "AnnotateEcore.eol";
	}
	
	@Override
	protected void preExecuteCustomisation(IEolModule module) {
		super.preExecuteCustomisation(module);
		module.getContext().getOperationContributorRegistry().add(new EModelElementOperationContributor());
		module.getContext().getOperationContributorRegistry().add(new ContextlessOperationContributor());
		module.getContext().getOperationContributorRegistry().add(new EClassOperationContributor());
	}
	
	@Override
	protected void disposeModel(IModel model) {
		if (saveEcore) model.dispose();
		else super.disposeModel(model);
	}
	
}
