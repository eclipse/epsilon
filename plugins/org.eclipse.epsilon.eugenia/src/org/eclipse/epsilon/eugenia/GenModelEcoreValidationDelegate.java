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

public class GenModelEcoreValidationDelegate extends AbstractEcoreModelValidationDelegate {

	@Override
	protected String getMarkerType() {
		return "org.eclipse.epsilon.eugenia.validation.problem.emf";
	}
	
	@Override
	public String getBuiltinTransformation() {
		return "transformations/Ecore2GenModel.evl";
	}
	
	@Override
	public EugeniaActionDelegateStep getStep() {
		return EugeniaActionDelegateStep.validateforgenmodel;
	}
	
}
