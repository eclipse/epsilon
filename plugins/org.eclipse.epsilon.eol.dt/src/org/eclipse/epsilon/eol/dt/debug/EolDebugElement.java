package org.eclipse.epsilon.eol.dt.debug;

import org.eclipse.debug.core.model.DebugElement;
import org.eclipse.debug.core.model.IDebugTarget;

public class EolDebugElement extends DebugElement {

	public EolDebugElement(IDebugTarget target) {
		super(target);
	}

	public String getModelIdentifier() {
		return EolDebugConstants.MODEL_IDENTIFIER;
	}

}
