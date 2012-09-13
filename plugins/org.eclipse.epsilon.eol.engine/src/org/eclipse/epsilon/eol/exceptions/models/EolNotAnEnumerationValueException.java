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
package org.eclipse.epsilon.eol.exceptions.models;

import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;


public class EolNotAnEnumerationValueException extends EolRuntimeException{
	
	protected Object instance;
	
	public EolNotAnEnumerationValueException(Object instance) {
		super();
		this.instance = instance;
	}
	
	@Override
	public String getReason() {
		return instance + " is not an enumeration value";
	}

}
