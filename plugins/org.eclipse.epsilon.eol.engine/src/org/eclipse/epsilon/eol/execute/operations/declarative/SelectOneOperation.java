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

public class SelectOneOperation extends SelectOperation {

	@Override
	public Object execute(Object obj, AST ast, IEolContext context) throws EolRuntimeException {
		setReturnOnFirstMatch(true);
		Collection<?> result = (Collection<?>) super.execute(obj, ast, context);
		return CollectionUtil.getFirst(result);
	}
	
}
