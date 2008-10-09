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
 * $Id: IncorrectlyTypedDefaultValue.java,v 1.3 2008/08/07 12:44:20 louis Exp $
 */
package org.eclipse.epsilon.hutn.validation.config.defaultValue;

import static org.junit.Assert.*;

import java.util.List;

import org.eclipse.epsilon.hutn.exceptions.HutnValidationException;
import org.eclipse.epsilon.hutn.validation.config.HutnConfigFileValidationTest;
import org.eclipse.epsilon.commons.parse.problem.ParseProblem;
import org.junit.BeforeClass;
import org.junit.Test;

public class IncorrectlyTypedDefaultValue extends HutnConfigFileValidationTest {

	private static List<ParseProblem> problems;
	
	private final static String defaultValue = "4";
	
	@BeforeClass
	public static void buildModel() throws HutnValidationException {
		problems = configFileValidationTest(createConfiguration(createDefaultValueRule("Family", "nuclear", defaultValue)));
	}
	
	@Test
	public void validatorShouldProduceOneError() {
		assertEquals(1, problems.size());
	}
	
	@Test
	public void errorMessageShouldIndicateNonExistentAttribute() {
		assertEquals("The attribute \"nuclear\" for the classifier \"Family\" is not compatible with the value: " + defaultValue, problems.get(0).getReason());
	}
}
