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
package org.eclipse.epsilon.eol.exceptions;

import org.eclipse.epsilon.common.module.ModuleElement;
import org.eclipse.epsilon.eol.execute.context.IEolContext;


public class EolIllegalPropertyException extends EolRuntimeException{
	
	protected String property;
	protected Object object;
	
	
	public EolIllegalPropertyException(Object object, String property, ModuleElement ast, IEolContext context) {
		super();
		this.ast = ast;
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
		//return "Object " + object + " does not support this property: " + property;
		return "Property '" + property + "' not found in object " + (context == null ? object : context.getPrettyPrinterManager().toString(object));
	}
	
}
