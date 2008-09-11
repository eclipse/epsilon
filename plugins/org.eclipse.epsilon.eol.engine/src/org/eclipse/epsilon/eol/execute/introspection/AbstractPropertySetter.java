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
package org.eclipse.epsilon.eol.execute.introspection;

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.eol.execute.context.IEolContext;


public abstract class AbstractPropertySetter implements IPropertySetter{
	
	protected String property;
	protected Object object;
	protected IEolContext context;
	protected AST ast;
	
	public IEolContext getContext() {
		return context;
	}

	public void setContext(IEolContext context) {
		this.context = context;
	}

	public AST getAst() {
		return ast;
	}

	public void setAst(AST ast) {
		this.ast = ast;
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
}
