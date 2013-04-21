package org.eclipse.epsilon.eugenia;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.epsilon.eol.IEolExecutableModule;
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
		List<IModel> models = new ArrayList<IModel>();
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
	protected void preExecuteCustomisation(IEolExecutableModule module) {
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
