/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
******************************************************************************/

package org.eclipse.epsilon.eol.dt.debug;

import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.model.DebugElement;
import org.eclipse.debug.core.model.IDebugTarget;

public class EolDebugElement extends DebugElement {

	public EolDebugElement(IDebugTarget target) {
		super(target);
	}

	public String getModelIdentifier() {
		return EolDebugConstants.MODEL_IDENTIFIER;
	}

	@Override
	public void fireEvent(DebugEvent event) {
		// TODO Auto-generated method stub
		super.fireEvent(event);
	}
}
 