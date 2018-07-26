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

public class ToolGraphMapEcoreValidationDelegate extends AbstractEcoreModelValidationDelegate {

	@Override
	protected String getMarkerType() {
		return "org.eclipse.epsilon.eugenia.validation.problem.gmf";
	}
	
	@Override
	public String getBuiltinTransformation() {
		return "transformations/ECore2GMF.evl";
	}
	
	@Override
	public EugeniaActionDelegateStep getStep() {
		return EugeniaActionDelegateStep.validateforgmf;
	}
	
}
