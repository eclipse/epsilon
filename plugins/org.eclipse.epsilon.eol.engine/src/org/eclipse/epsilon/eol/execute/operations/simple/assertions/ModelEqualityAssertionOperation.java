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
import org.eclipse.epsilon.eol.exceptions.models.EolModelNotFoundException;
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

		// Extract the models and check that they are comparable
		final String expectedModelName = (String)parameters.remove(0);
		final String actualModelName = (String)parameters.remove(0);
		final IComparableModel expectedCModel = getComparableModel(context, expectedModelName);
		final IComparableModel actualCModel = getComparableModel(context, actualModelName);

		// Perform the comparison
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
			message = "Expected " + actualModelName
				+ " to be " + (mustBeEqual ? "equal" : "different") + " to "
				+ expectedModelName + ", but it is not";
		}
		if (mustBeEqual) {
			throw new EolAssertionException(message.toString(), ast, expectedCModel, actualCModel, delta);
		}
		else {
			throw new EolAssertionException(message.toString(), ast, null, null, null);
		}
	}

	private IComparableModel getComparableModel(IEolContext context, String name)
		throws EolModelNotFoundException
	{
		IModel expectedModel = context.getModelRepository().getModelByName(name);
		if (!(expectedModel instanceof IComparableModel)) {
			throw new IllegalArgumentException(
				String.format("The model '%s' does not support comparison", name));
		}
		return (IComparableModel)expectedModel;
	}

}
