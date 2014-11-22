/*******************************************************************************
 * Copyright (c) 2009 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.flock.execution.operations;

import java.util.List;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.operations.simple.SimpleOperation;
import org.eclipse.epsilon.flock.IFlockContext;
import org.eclipse.epsilon.flock.execution.exceptions.ConservativeCopyException;


public class EquivalentOperation extends SimpleOperation {
	
	@Override
	public Object execute(Object originalModelElement, List<?> parameters, IEolContext context, AST ast) throws ConservativeCopyException {
		return ((IFlockContext)context).getConservativeCopyContext().getEquivalent(originalModelElement);
	}
}
