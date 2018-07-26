/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.eol.exceptions.flowcontrol;

import org.eclipse.epsilon.common.module.ModuleElement;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;


public class EolBreakException extends EolRuntimeException{
	
	protected boolean breaksAll;
	
	public EolBreakException(ModuleElement ast, boolean breaksAll){
		this.ast = ast;
		this.reason = "Break only allowed inside a loop";
		this.breaksAll = breaksAll;
	}

	public boolean isBreaksAll() {
		return breaksAll;
	}

	public void setBreaksAll(boolean breaksAll) {
		this.breaksAll = breaksAll;
	}
	
	
	
}
