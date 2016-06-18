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
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;


public abstract class AbstractPropertyGetter implements IPropertyGetter{
	
	protected ModuleElement ast;
	protected IEolContext context;
	
	public ModuleElement getAst(){
		return ast;
	}
	
	public void setAst(ModuleElement ast){
		this.ast = ast;
	}

	public IEolContext getContext() {
		return context;
	}

	public void setContext(IEolContext context) {
		this.context = context;
	}

	public boolean hasProperty(Object object, String property) {
		try {
			this.invoke(object, property);
			return true;
		} catch (EolRuntimeException e) {
			return false;
		}
		
	}
	
}
