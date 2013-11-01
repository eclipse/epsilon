/*******************************************************************************
 * Copyright (c) 2008-2013 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 *     Antonio García-Domínguez - switch to frame stacks, simplify ctor
 ******************************************************************************/
package org.eclipse.epsilon.eol.exceptions.flowcontrol;

import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.FrameStack;

public class EolContinueException extends EolRuntimeException {
	private static final long serialVersionUID = -693895427586389565L;

	public EolContinueException(FrameStack frameStack) {
		super("Statement 'continue;' is only valid in loops", frameStack);
	}

}
