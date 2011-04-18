/*******************************************************************************
 * Copyright (c) 2011 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Antonio Garcia-Dominguez - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.eunit.execute;

import org.eclipse.epsilon.eol.execute.operations.AbstractOperation;
import org.eclipse.epsilon.eol.execute.operations.OperationFactory;
import org.eclipse.epsilon.eunit.execute.operations.TreeEqualityAssertionOperation;

/**
 * Operation factory for EUnit-specific assertions. These assertions
 * are EUnit-specific since they require extra dependencies, and we do not
 * want to pollute EOL with them.
 *
 * @author Antonio Garcia-Dominguez
 */
public class EUnitOperationFactory extends OperationFactory {
	@Override
	protected void createCache() {
		super.createCache();
		addTreeEqualityOperations();
	}

	public void addTreeEqualityOperations() {
		final AbstractOperation equalTreesOp  = new TreeEqualityAssertionOperation(true);
		final AbstractOperation nequalTreesOp = new TreeEqualityAssertionOperation(false);

		// assertEqual{Files,Directories} are really the same
		// thing (something more like assertEqualFileTrees),
		// but we alias them to both names to avoid confusing users
		operationCache.put("assertEqualFiles", equalTreesOp);
		operationCache.put("assertEqualDirectories", equalTreesOp);
		operationCache.put("assertNotEqualFiles", nequalTreesOp);
		operationCache.put("assertNotEqualDirectories", nequalTreesOp);
	}
}
