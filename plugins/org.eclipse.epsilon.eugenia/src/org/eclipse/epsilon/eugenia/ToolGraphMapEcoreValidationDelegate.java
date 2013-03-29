package org.eclipse.epsilon.eugenia;

public class ToolGraphMapEcoreValidationDelegate extends AbstractEcoreModelValidationDelegate {

	@Override
	protected String getMarkerType() {
		return "org.eclipse.epsilon.eugenia.validation.problem.gmf";
	}
	
	@Override
	public String getBuiltinTransformation() {
		return "transformations/ECore2GMF.evl";
	}

}
