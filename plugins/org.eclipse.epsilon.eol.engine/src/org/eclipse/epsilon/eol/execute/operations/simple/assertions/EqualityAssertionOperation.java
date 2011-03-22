/*******************************************************************************
 * Copyright (c) 2008-2011 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 *     Antonio Garcia-Dominguez - revised message, pass message in 3-arg version,
 *                                share code between assertEquals and assertNotEquals,
 *                                ulp-based floating-point number comparison
 ******************************************************************************/
package org.eclipse.epsilon.eol.execute.operations.simple.assertions;

import java.util.List;

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.eol.exceptions.EolAssertionException;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.operations.simple.AbstractSimpleOperation;
import org.eclipse.epsilon.eol.types.EolObjectComparator;

/**
 * <p>Basic equality assertion. Can be called in several ways:</p>
 * 
 * <ul>
 * <li>With 2 arguments: expected value and actual value.</li>
 * <li>With 3 arguments:
 *   <ul>
 *   <li>If the first argument is a string: explanation, expected value, actual value.</li>
 *   <li>Otherwise: expected floating-point number, actual floating-point number, acceptable error margin (integer
 *   measured in ulps of the expected floating-point number).</li>
 *   </ul>
 * </li>
 * <li>With 4 arguments: explanation, expected floating-point number, actual floating-point number, error margin (in ulps).</li>
 * </ul>
 *
 * @see Math#ulp(double)
 */
public class EqualityAssertionOperation extends AbstractSimpleOperation {

	private final boolean mustBeEqual;

	/**
	 * Creates the operation.
	 * 
	 * @param mustBeEqual
	 *            <code>true</code> if operands must be equal,
	 *            <code>false</code> if they must <b>not</b> be equal.
	 */
	public EqualityAssertionOperation(boolean mustBeEqual) {
		this.mustBeEqual = mustBeEqual;
	}

	@Override
	public Object execute(Object source, List parameters, IEolContext context,
			AST ast) throws EolRuntimeException {

		if (!context.isAssertionsEnabled()) {return null;}

		// Extract the message from the parameter list
		Object message = null;
		if (parameters.size() > 2 && parameters.get(0) instanceof String) {
			message = parameters.remove(0);
		}

		// Extract the other arguments
		Object expectedValue = parameters.remove(0);
		Object actualValue = parameters.remove(0);
		Number nUlps = null;
		if (!parameters.isEmpty()
				&& expectedValue instanceof Number
				&& actualValue instanceof Number
				&& parameters.get(0) instanceof Number) {
			nUlps = (Number)parameters.remove(0);
		}

		// There shouldn't be any unprocessed parameters now
		if (!parameters.isEmpty()) {
			throw new EolAssertionException("Illegal number of arguments or wrong types", ast);
		}

		String expected;
		String obtained = context.getPrettyPrinterManager().toString(actualValue);
		if (nUlps == null) {
			// Regular comparison
			if (EolObjectComparator.equals(expectedValue, actualValue) == mustBeEqual) {
				return true;
			}
			else {
				expected = context.getPrettyPrinterManager().toString(expectedValue);
			}
		}
		else {
			// Approximate comparison, specific for floating-point values
			final Number nExpected = (Number)expectedValue;
			final Number nActual = (Number)actualValue;
			final long intUlps = nUlps.longValue();

			// Try to use the same floating-point type than the expected value:
			// double values will need many more ulps to perform comparisons
			boolean bIsEqual = false;
			if (expectedValue instanceof Float) {
				final float flExpected = ((Number)expectedValue).floatValue();
				final float flActual = nActual.floatValue();
				final float flMargin = intUlps * Math.ulp(flExpected);
				bIsEqual = Math.abs(flActual - flExpected) <= flMargin;
				expected = "in [" + (flExpected - flMargin) + ", " + (flExpected + flMargin) + "]";
			}
			else {
				final double dblExpected = nExpected.doubleValue();
				final double dblActual = nActual.doubleValue();
				final double dblMargin = intUlps * Math.ulp(dblExpected);
				bIsEqual = Math.abs(dblActual - dblExpected) <= dblMargin;
				expected = "in [" + (dblExpected - dblMargin) + ", " + (dblExpected + dblMargin) + "]";
			}

			if (bIsEqual) {
				return true;
			}
		}

		if (message == null) {
			if (mustBeEqual) {
				message = "Expected " + expected + ", but got " + obtained + " instead";
			}
			else {
				message = "Expected something different, but got " + obtained + " as well";
			}
		}

		throw new EolAssertionException(message.toString(), ast);
	}

}
