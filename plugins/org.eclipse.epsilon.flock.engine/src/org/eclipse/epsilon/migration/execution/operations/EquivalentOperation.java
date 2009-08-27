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
package org.eclipse.epsilon.migration.execution.operations;

import java.util.List;

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.operations.simple.AbstractSimpleOperation;
import org.eclipse.epsilon.migration.IMigrationContext;
import org.eclipse.epsilon.migration.execution.exceptions.ConservativeCopyException;


public class EquivalentOperation extends AbstractSimpleOperation {
	
	@SuppressWarnings("unchecked")
	@Override
	public Object execute(Object originalModelElement, List parameters, IEolContext context, AST ast) throws ConservativeCopyException {
		return ((IMigrationContext)context).getUnwrappedEquivalent(originalModelElement);
	}
}
