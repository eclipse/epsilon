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
 * $Id: ValidDefaultAttribute.java,v 1.2 2008/08/07 12:44:22 louis Exp $
 */
package org.eclipse.epsilon.hutn.validation.config.defaultAttribute;

import static org.junit.Assert.*;

import java.util.List;

import org.eclipse.epsilon.hutn.exceptions.HutnValidationException;
import org.eclipse.epsilon.hutn.validation.config.HutnConfigFileValidationTest;
import org.eclipse.epsilon.common.parse.problem.ParseProblem;
import org.junit.BeforeClass;
import org.junit.Test;

public class ValidDefaultAttribute extends HutnConfigFileValidationTest {

	private static List<ParseProblem> problems;
	
	@BeforeClass
	public static void buildModel() throws HutnValidationException {
		problems = configFileValidationTest(createConfiguration(createIdentifierRule("Family", "id")));
	}
	
	@Test
	public void validatorShouldProduceNoErrors() {
		assertEquals(0, problems.size());
	}
}
