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

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;

public interface IPropertySetter {
	
	public void invoke(Object value) throws EolRuntimeException;
	
	public void setProperty(String property);
	
	public String getProperty();
	
	public void setObject(Object object);
	
	public Object getObject();
	
	public AST getAst();

	public void setAst(AST ast);
	
	public void setContext(IEolContext context);
	
	public IEolContext getContext();
}
