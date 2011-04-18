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
package org.eclipse.epsilon.eol.execute.operations.simple.assertions;

import java.util.List;

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.eol.exceptions.EolAssertionException;
import org.eclipse.epsilon.eol.exceptions.EolInternalException;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.operations.simple.AbstractSimpleOperation;
import org.eclipse.epsilon.eol.models.IComparableModel;
import org.eclipse.epsilon.eol.models.IModel;

/**
 * <p>Model equality assertion. Performs a comparison between two entire models in the context's
 * model repository. Useful for testing model transformations for regressions.</p>
 *
 * <p>Accepts 2 formats:</p>
 * <ul>
 * <li>message, name of the model with the expected contents, name of the model with the actual contents</li>
 * <li>name of the model with the expected contents, name of the model with the actual contents</li>
 * </ul>
 *
 * @author Antonio García-Domínguez
 */
public class ModelEqualityAssertionOperation extends AbstractSimpleOperation {

	private boolean mustBeEqual;

	public ModelEqualityAssertionOperation(boolean mustBeEqual) {
		this.mustBeEqual = mustBeEqual;
	}

	@Override
	public Object execute(Object source, List parameters, IEolContext context, AST ast) throws EolRuntimeException {
		if (!context.isAssertionsEnabled()) {return null;}

		// Extract the message from the parameter list
		Object message = null;
		if (parameters.size() > 2) {
			message = parameters.remove(0);
		}

		// Extract the other arguments and check they are comparable models
		String expectedModelName = (String)parameters.remove(0);
		String actualModelName = (String)parameters.remove(0);
		final IModel expectedModel = context.getModelRepository().getModelByName(expectedModelName);
		final IModel actualModel = context.getModelRepository().getModelByName(actualModelName);
		if (!(expectedModel instanceof IComparableModel)) {
			throw new IllegalArgumentException(
				String.format("The expected model '%s' does not support comparison", expectedModelName));
		}
		else if (!(actualModel instanceof IComparableModel)) {
			throw new IllegalArgumentException(
				String.format("The actual model '%s' does not support comparison", actualModelName));
		}

		// Perform the comparison
		final IComparableModel expectedCModel = (IComparableModel)expectedModel;
		final IComparableModel actualCModel = (IComparableModel)actualModel;
		Object delta;
		try {
			delta = actualCModel.computeDifferencesWith(expectedCModel);
		} catch (Exception e) {
			throw new EolInternalException(e);
		}
		if ((delta == null) == mustBeEqual) {
			return true;
		}
 
		if (message == null) {
			message = "Expected " + expectedModelName
				+ " to be " + (mustBeEqual ? "equal" : "different") + " to "
				+ actualModelName + ", but it is not";
		}
		if (mustBeEqual) {
			throw new EolAssertionException(message.toString(), ast, expectedCModel, actualCModel, delta);
		}
		else {
			throw new EolAssertionException(message.toString(), ast, null, null, null);
		}
	}

}
