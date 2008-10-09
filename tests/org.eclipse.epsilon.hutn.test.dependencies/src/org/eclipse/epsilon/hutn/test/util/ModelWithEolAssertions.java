/**
 * *******************************************************************************
 * Copyright (c) 2008 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 * ******************************************************************************
 *
 * $Id: ModelWithEolAssertions.java,v 1.4 2008/08/12 08:58:18 louis Exp $
 */
package org.eclipse.epsilon.hutn.test.util;

import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.eol.types.EolBoolean;
import org.eclipse.epsilon.eol.EolEvaluator;

public class ModelWithEolAssertions {
	
	private final IModel model;
	private final EolEvaluator evaluator; 
	
	public ModelWithEolAssertions(IModel model) {
		this.model = model;
		evaluator  = new EolEvaluator(model);
	}
	
	public void dispose() {
		model.dispose();
	}
	
	public void assertEmpty() {
		boolean modelIsEmpty = ((EolBoolean)evaluator.evaluate(model.getName() + ".allInstances.isEmpty()")).booleanValue();
		
		org.junit.Assert.assertTrue(modelIsEmpty);
	}
	
	public void assertEquals(Object expected, String actual) {
		assertEquals(null, expected, actual);
	}
	
	public void assertEquals(String message, Object expected, String actual) {
		if (expected instanceof String) {
			final String expectedStr = (String)expected;
			
			// When the expected string contains a hash symbol assume that
			// it is an enumeration literal, so don't wrap it in quotes
			// Unless the expected string *starts* with a hash, then it's a
			// positive adjective, so do wrap it in quotes
			if (expectedStr.startsWith("#") || !expectedStr.contains("#")) {
				expected = "'" + expected + "'";
			}
		}
		
		final Object expectedResult = evaluator.evaluate(expected);
		final Object actualResult   = evaluator.evaluate(actual);
		
//		System.err.println(expectedResult.getClass() + " : " + expectedResult);
//		System.err.println(actualResult.getClass()   + " : " + actualResult);
		
		if (message == null)
			org.junit.Assert.assertEquals(expectedResult, actualResult);
		else
			org.junit.Assert.assertEquals(message, expectedResult, actualResult);
	
	}
	
	public void assertTrue(String eolStatement) {
		assertTrue(null, eolStatement);
	}
	
	public void assertTrue(String message, String eolStatement) {
		final Object result = evaluator.evaluate(eolStatement);
		
		if (result instanceof EolBoolean)
			if (message == null)
				org.junit.Assert.assertTrue(((EolBoolean)result).booleanValue());
			else
				org.junit.Assert.assertTrue(message, ((EolBoolean)result).booleanValue());
		else
			throw new IllegalArgumentException("Could not determine a boolean value for '" + eolStatement + "'");
	}
	
	public void assertFalse(String eolStatement) {
		assertFalse(null, eolStatement);
	}
	
	public void assertFalse(String message, String eolStatement) {
		assertTrue(null, "not " + eolStatement);
	}
	
	public void assertDefined(String eolStatement) {
		assertDefined(null, eolStatement);
	}
	
	public void assertDefined(String message, String eolStatement) {	
		final Object result = evaluator.evaluate(eolStatement);
		
		if (message == null)
			org.junit.Assert.assertNotNull(result);
		else
			org.junit.Assert.assertNotNull(message, result);
	
	}
	
	public void assertUndefined(String eolStatement) {
		assertUndefined(null, eolStatement);
	}
	
	public void assertUndefined(String message, String eolStatement) {	
		final Object result = evaluator.evaluate(eolStatement);
		
		if (message == null)
			org.junit.Assert.assertNull(result);
		else
			org.junit.Assert.assertNull(message, result);
	
	}
	
	
	public void setVariable(String name, String eolStatement) {
		evaluator.setVariable(name, eolStatement);
	}
	
	public void store(String path) {
		System.err.println(path);
		model.store(path);
	}
}
