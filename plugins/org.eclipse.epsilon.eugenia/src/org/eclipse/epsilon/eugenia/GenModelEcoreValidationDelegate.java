package org.eclipse.epsilon.eugenia;

public class GenModelEcoreValidationDelegate extends AbstractEcoreModelValidationDelegate {

	@Override
	protected String getMarkerType() {
		return "org.eclipse.epsilon.eugenia.validation.problem.emf";
	}
	
	@Override
	public String getBuiltinTransformation() {
		return "transformations/Ecore2GenModel.evl";
	}

}
