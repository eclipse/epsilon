/*******************************************************************************
 * Copyright (c) 2008-2013 The University of York, Antonio García-Domínguez
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 *     Antonio García-Domínguez - switch to frame stack
 ******************************************************************************/
package org.eclipse.epsilon.eol.exceptions.flowcontrol;

import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.FrameStack;


public class EolBreakException extends EolRuntimeException {
	private static final long serialVersionUID = 974932679559521197L;
	private boolean breaksAll;
	
	public EolBreakException(FrameStack stack, boolean breaksAll) {
		super("Break only allowed inside a loop", stack);
		this.breaksAll = breaksAll;
	}

	public boolean isBreaksAll() {
		return breaksAll;
	}

	public void setBreaksAll(boolean breaksAll) {
		this.breaksAll = breaksAll;
	}
}
