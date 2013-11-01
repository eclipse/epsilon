/*******************************************************************************
 * Copyright (c) 2008-2013 The University of York, Antonio García-Domínguez.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 *     Antonio García-Domínguez - switch to frame stack
 ******************************************************************************/
package org.eclipse.epsilon.eol.exceptions;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.execute.context.IEolContext;


public class EolIllegalPropertyException extends EolRuntimeException {
	private static final long serialVersionUID = -2770110184378723634L;

	protected String property;
	protected Object object;
	
	public EolIllegalPropertyException(Object object, String property, IEolContext context) {
		this(object, property, null, context);
	}

	public EolIllegalPropertyException(Object object, String property, AST extraAST, IEolContext context) {
		super(null, extraAST, context != null ? context.getFrameStack() : null);

		this.object = object;
		this.property = property;
		this.context = context;
	}
	
	public Object getObject() {
		return object;
	}
	
	public void setObject(Object object) {
		this.object = object;
	}
	
	public String getProperty() {
		return property;
	}
	
	public void setProperty(String property) {
		this.property = property;
	}
	
	@Override
	public String getReason(){
		return "Property '" + property + "' not found in object " + (context == null ? object : context.getPrettyPrinterManager().toString(object));
	}
	
}
