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
