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

import org.eclipse.jface.action.IAction;

public abstract class GuardedEcoreModelGenerationDelegate extends EugeniaActionDelegate {
	
	protected boolean valid = false;
	
	@Override
	public void runImpl(IAction action) throws Exception {
		
		AbstractEcoreModelValidationDelegate validateEcoreModelDelegate = createEcoreModelValidationDelegate();
		validateEcoreModelDelegate.setClearConsole(false);
		validateEcoreModelDelegate.setSelection(getSelectedFile());
		validateEcoreModelDelegate.runImpl(action);
		valid = validateEcoreModelDelegate.isValid();
		
		if (isValid()) {
			super.runImpl(action);
		}
	}
	
	public boolean isValid() {
		return valid;
	}
	
	public abstract AbstractEcoreModelValidationDelegate createEcoreModelValidationDelegate();
	
}
