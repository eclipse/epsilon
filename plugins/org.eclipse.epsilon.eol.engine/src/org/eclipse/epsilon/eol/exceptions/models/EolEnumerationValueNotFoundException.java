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

public class EolEnumerationValueNotFoundException extends EolRuntimeException{
	
	protected String enumeration;
	protected String label;
	protected String model;
	
	public EolEnumerationValueNotFoundException(String enumeration, String label, String model) {
		this.enumeration = enumeration;
		this.label = label;
		this.model = model;
	}
	
	@Override
	public String getReason() {
		return "Cannot find enumeration literal " + enumeration + "#" + label + " in model " + model;
	}
	
}
