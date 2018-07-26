/*******************************************************************************
 * Copyright (c) 2012 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
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
