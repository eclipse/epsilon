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
package org.eclipse.epsilon.eol.execute.operations.declarative;

import java.util.Collection;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.common.util.CollectionUtil;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.operations.AbstractOperation;
import org.eclipse.epsilon.eol.execute.operations.contributors.IterableOperationContributor;


public class RejectOperation extends AbstractOperation{

	@Override
	public Object execute(Object obj, AST ast, IEolContext context) throws EolRuntimeException{
		
		SelectOperation selectOperation = new SelectOperation();
		
		Collection selected = (Collection) selectOperation.execute(obj, ast, context);		
		Collection source = CollectionUtil.asCollection(obj);
		
		return new IterableOperationContributor(source).excludingAll(selected);
		
	}

}
