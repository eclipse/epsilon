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
package org.eclipse.epsilon.eol.execute.operations.simple;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.operations.AbstractOperation;


public class AllSuperClassesOperation extends AbstractOperation{

	@Override
	public Object execute(Object source, AST operationAst, IEolContext context) throws EolRuntimeException {
		return getAllSuperClasses(source.getClass());
	}
	
	public Set getAllSuperClasses(Class clazz){
		
		HashSet allSuperClasses = new HashSet();
		allSuperClasses.add(clazz);
		
		/*
		
		Class[] interfaces = clazz.getInterfaces();
		
		for (int i=0;i<interfaces.length;i++){
			allSuperClasses.addAll(getAllSuperClasses(interfaces[i]));
		}
		*/
		
		if (clazz.getSuperclass() != null)
		allSuperClasses.addAll(getAllSuperClasses(clazz.getSuperclass()));
		
		return allSuperClasses;
	}
	
}
