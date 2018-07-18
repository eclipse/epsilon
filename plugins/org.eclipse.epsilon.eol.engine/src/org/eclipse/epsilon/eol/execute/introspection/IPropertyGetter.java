/*******************************************************************************
 * Copyright (c) 2008-2016 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 *     Antonio Garcia-Dominguez - add isPropertySet
 ******************************************************************************/
package org.eclipse.epsilon.eol.execute.introspection;

import org.eclipse.epsilon.common.module.ModuleElement;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;


public interface IPropertyGetter {
	
	public boolean hasProperty(Object object, String property);
	
	public Object invoke(Object object, String property) throws EolRuntimeException;
	
	public ModuleElement getAst();
	
	public void setAst(ModuleElement ast);
	
	public void setContext(IEolContext context);
	
	public IEolContext getContext();
}
