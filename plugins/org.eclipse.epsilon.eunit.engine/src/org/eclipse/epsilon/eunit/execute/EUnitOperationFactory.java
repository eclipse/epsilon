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

import java.lang.reflect.InvocationTargetException;
import java.util.logging.Logger;

import org.eclipse.epsilon.eol.execute.operations.AbstractOperation;
import org.eclipse.epsilon.eol.execute.operations.OperationFactory;


/**
 * Operation factory for EUnit-specific assertions. These assertions
 * are EUnit-specific since they require extra dependencies, and we do not
 * want to pollute EOL with them.
 *
 * @author Antonio Garcia-Dominguez
 */
public class EUnitOperationFactory extends OperationFactory {

	// We can't use the Error Log in this plugin, as we do not want EUnit to depend on the Eclipse UI
	private static final Logger LOGGER
		= Logger.getLogger(EUnitOperationFactory.class.getName());
	private static final String TREE_EQ_CLASS
		= "org.eclipse.epsilon.eunit.execute.operations.TreeEqualityAssertionOperation";

	@Override
	protected void createCache() {
		super.createCache();
		addTreeEqualityOperations();
	}

	public void addTreeEqualityOperations() {
		try {
			final AbstractOperation equalTreesOp
				= createTreeEqualityOperation(true);
			final AbstractOperation nequalTreesOp
				= createTreeEqualityOperation(false);

			// assertEqual{Files,Directories} are really the same
			// thing (something more like assertEqualFileTrees),
			// but we alias them to both names to avoid confusing users
			operationCache.put("assertEqualFiles", equalTreesOp);
			operationCache.put("assertEqualDirectories", equalTreesOp);
			operationCache.put("assertNotEqualFiles", nequalTreesOp);
			operationCache.put("assertNotEqualDirectories", nequalTreesOp);
		}
		catch (Exception ex) {
			// EMF Compare is not available: these operations cannot be used
			LOGGER.warning(
				"Could not add the file tree equality operations: "
					+ ex.getLocalizedMessage());
		}
	}

	public AbstractOperation createTreeEqualityOperation(
			final boolean mustBeEqual) throws InstantiationException,
			IllegalAccessException, InvocationTargetException,
			NoSuchMethodException, ClassNotFoundException {
		final AbstractOperation equalTreesOp
			= (AbstractOperation)Class.forName(TREE_EQ_CLASS)
				.getDeclaredConstructor(boolean.class)
				.newInstance(mustBeEqual);
		return equalTreesOp;
	}
}
