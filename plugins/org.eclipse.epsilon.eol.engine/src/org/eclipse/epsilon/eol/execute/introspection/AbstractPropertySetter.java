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

import org.eclipse.epsilon.common.module.ModuleElement;
import org.eclipse.epsilon.eol.execute.context.IEolContext;

public abstract class AbstractPropertySetter implements IPropertySetter {
	
	protected String property;
	protected Object object;
	protected IEolContext context;
	protected ModuleElement ast;
	
	@Override
	public IEolContext getContext() {
		return context;
	}

	@Override
	public void setContext(IEolContext context) {
		this.context = context;
	}

	@Override
	public ModuleElement getAst() {
		return ast;
	}

	@Override
	public void setAst(ModuleElement ast) {
		this.ast = ast;
	}
 
	@Override
	public Object getObject() {
		return object;
	}
 
	@Override
	public void setObject(Object object) {
		this.object = object;
	}

	@Override
	public String getProperty() {
		return property;
	}

	@Override
	public void setProperty(String property) {
		this.property = property;
	}
}
