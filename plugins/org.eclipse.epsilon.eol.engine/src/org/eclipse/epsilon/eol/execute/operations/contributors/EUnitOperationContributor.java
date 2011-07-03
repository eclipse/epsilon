/*******************************************************************************
 * Copyright (c) 2011 Antonio García-Domínguez.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Antonio García-Domínguez - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.eol.execute.operations.contributors;

import org.eclipse.epsilon.eol.exceptions.EolAssertionException;
import org.eclipse.epsilon.eol.exceptions.EolInternalException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelNotFoundException;
import org.eclipse.epsilon.eol.models.IComparableModel;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.eol.types.EolObjectComparator;

/**
 * Operation contributor for the EUnit assertions.
 */
public class EUnitOperationContributor extends OperationContributor {

	@Override
	public boolean contributesTo(Object target) {
		return true;
	}

	public void assertTrue(boolean condition) throws EolAssertionException {
		assertTrue("Violated assertion", condition);
	}

	public void assertTrue(String message, boolean condition) throws EolAssertionException {
		compareBoolean(message, condition, true);
	}

	public void assertFalse(boolean condition) throws EolAssertionException {
		assertFalse("Violated assertion", condition);
	}

	public void assertFalse(String message, boolean condition) throws EolAssertionException {
		compareBoolean(message, condition, false);
	}

	public void assertEquals(Object expected, Object obtained) throws EolAssertionException {
		final String sExpected = context.getPrettyPrinterManager().print(expected);
		final String sObtained = context.getPrettyPrinterManager().print(obtained);
		final String message = "Expected " + sExpected + ", but got " + sObtained + " instead";
		assertEquals(message, expected, obtained);
	}

	public void assertEquals(String message, Object expected, Object obtained) throws EolAssertionException {
		compareGeneric(message, expected, obtained, true);
	}

	public void assertEquals(Number expected, Number obtained, Number ulps) throws EolAssertionException {
		assertEquals(null, expected, obtained, ulps);
	}

	public void assertEquals(String message, Number expected, Number obtained, Number ulps) throws EolAssertionException {
		compareUlps(message, expected, obtained, ulps, true);
	}

	public void assertEqualModels(String expectedModelName, String obtainedModelName) throws EolModelNotFoundException, EolAssertionException, EolInternalException {
		assertEqualModels(null, expectedModelName, obtainedModelName);
	}

	public void assertEqualModels(String message, String expectedModelName, String obtainedModelName) throws EolModelNotFoundException, EolAssertionException, EolInternalException {
		compareModels(message, expectedModelName, obtainedModelName, true);
	}

	public void assertNotEquals(Object expected, Object obtained) throws EolAssertionException {
		assertNotEquals("Expected something different from " + expected + ", but got something equal to it", expected, obtained);
	}

	public void assertNotEquals(String message, Object expected, Object obtained) throws EolAssertionException {
		compareGeneric(message, expected, obtained, false);
	}

	public void assertNotEquals(Number expected, Number obtained, Number ulps) throws EolAssertionException {
		assertNotEquals(null, expected, obtained, ulps);
	}

	public void assertNotEquals(String message, Number expected, Number obtained, Number ulps) throws EolAssertionException {
		compareUlps(message, expected, obtained, ulps, false);
	}

	public void assertNotEqualModels(String expectedModelName, String obtainedModelName) throws EolModelNotFoundException, EolAssertionException, EolInternalException {
		assertNotEqualModels(null, expectedModelName, obtainedModelName);
	}

	public void assertNotEqualModels(String message, String expectedModelName, String obtainedModelName) throws EolModelNotFoundException, EolAssertionException, EolInternalException {
		compareModels(message, expectedModelName, obtainedModelName, false);
	}

	public void fail(String message) throws EolAssertionException {
		throw new EolAssertionException(message, context.getFrameStack().getCurrentStatement(), null, null, null);
	}

	private IComparableModel getComparableModel(String name) throws EolModelNotFoundException
	{
		IModel expectedModel = context.getModelRepository().getModelByName(name);
		if (!(expectedModel instanceof IComparableModel)) {
			throw new IllegalArgumentException(
				String.format("The model '%s' does not support comparison", name));
		}
		return (IComparableModel)expectedModel;
	}

	private void compareBoolean(String message, boolean condition, final boolean expected) throws EolAssertionException {
		if (condition != expected) {
			throw new EolAssertionException(
					context.getPrettyPrinterManager().toString(message),
					context.getFrameStack().getCurrentStatement(),
					expected, condition, null);
		}
	}

	private void compareGeneric(String message, Object expected, Object obtained, final boolean mustBeEqual)
			throws EolAssertionException {
		if (EolObjectComparator.equals(expected, obtained) != mustBeEqual) {
			throw new EolAssertionException(
					message, context.getFrameStack().getCurrentStatement(), expected, obtained, null);
		}
	}

	private void compareModels(String message, String expectedModelName, String actualModelName, boolean mustBeEqual) throws EolModelNotFoundException, EolAssertionException, EolInternalException {
		final IComparableModel expectedCModel = getComparableModel(expectedModelName);
		final IComparableModel actualCModel = getComparableModel(actualModelName);

		// Compare the models
		Object delta = null;
		final boolean bExpectedEmpty = expectedCModel.allContents().isEmpty();
		final boolean bActualEmpty = actualCModel.allContents().isEmpty();
		try {
			if (!bExpectedEmpty && !bActualEmpty) {
				// We only use the driver-specific comparison if both models are not empty
				delta = actualCModel.computeDifferencesWith(expectedCModel);
			}
			else if (bExpectedEmpty != bActualEmpty) {
				delta = "expected "
					+ (bExpectedEmpty ? "is" : "is not")
					+ " empty, actual "
					+ (bActualEmpty ? "is" : "is not")
					+ " empty";
			}
		} catch (Exception e) {
			throw new EolInternalException(e);
		}

		// Does the comparison result match our expectations?
		if ((delta == null) == mustBeEqual) {
			return;
		}

		if (message == null) {
			if (bExpectedEmpty) {
				message = "Expected " + actualModelName
					+ (mustBeEqual ? " to be also" : " not to be") + " empty, but it is "
					+ (bActualEmpty ? "empty" : "not");
			}
			else {
				message = "Expected " + actualModelName
					+ " to be " + (mustBeEqual ? "equal" : "different") + " to "
					+ expectedModelName + ", but it is " + (bActualEmpty ? "empty" : "not");
			}
		}

		if (mustBeEqual) {
			throw new EolAssertionException(message.toString(), context.getFrameStack().getCurrentStatement(), expectedCModel, actualCModel, delta);
		}
		else {
			throw new EolAssertionException(message.toString(), context.getFrameStack().getCurrentStatement(), null, null, null);
		}
	}

	private void compareUlps(String message, Number expected, Number obtained, Number ulps, boolean mustBeEqual) throws EolAssertionException {
		final long intUlps = ulps.longValue();

		boolean bIsEqual = false;
		String upperBound = null, lowerBound = null;
		if (expected instanceof Float) {
			final float flExpected = ((Number)expected).floatValue();
			final float flActual = obtained.floatValue();
			final float flMargin = intUlps * Math.ulp(flExpected);
			bIsEqual = Math.abs(flActual - flExpected) <= flMargin;
			lowerBound = Float.toString(flExpected - flMargin);
			upperBound = Float.toString(flExpected + flMargin);
		}
		else {
			final double dblExpected = expected.doubleValue();
			final double dblActual = obtained.doubleValue();
			final double dblMargin = intUlps * Math.ulp(dblExpected);
			bIsEqual = Math.abs(dblActual - dblExpected) <= dblMargin;
			lowerBound = Double.toString(dblExpected - dblMargin);
			upperBound = Double.toString(dblExpected + dblMargin);
		}

		if (bIsEqual != mustBeEqual) {
			if (message == null) {
				message = "Expected " + expected + (mustBeEqual ? "not " : "")
					+ "to be in [" + lowerBound + ", " + upperBound + "]";
			}
			throw new EolAssertionException(message, context.getFrameStack().getCurrentStatement(), expected, obtained, null);
		}
	}
}
