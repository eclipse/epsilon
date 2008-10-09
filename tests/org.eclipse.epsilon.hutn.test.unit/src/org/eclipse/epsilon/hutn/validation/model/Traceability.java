/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************
 *
 * $Id: Traceability.java,v 1.1 2008/08/07 14:51:11 louis Exp $
 */

package org.eclipse.epsilon.hutn.validation.model;

import static org.eclipse.epsilon.hutn.test.unit.util.IntermediateUtil.createClass;
import static org.eclipse.epsilon.hutn.test.unit.util.IntermediateUtil.createPackage;
import static org.eclipse.epsilon.hutn.test.unit.util.IntermediateUtil.createSpec;
import static org.junit.Assert.assertEquals;

import org.eclipse.epsilon.hutn.exceptions.HutnValidationException;
import org.junit.BeforeClass;
import org.junit.Test;

public class Traceability extends HutnModelValidationTest {
	
	@BeforeClass
	public static void validateModel() throws HutnValidationException {
		problems = modelValidationTest(createSpec("families", createPackage(createClass("Fido", "Pet",    10, 1),
		                                                                    createClass("Fido", "Person", 20, 13))));
	}
	
	@Test
	public void validationShouldReportTwoProblems() {
		assertEquals(2, problems.size());
	}
	
	@Test
	public void firstProblemShouldOnCorrectLine() {
		assertEquals(10, problems.get(0).getLine());
	}
	
	@Test
	public void firstProblemShouldAtCorrectColumn() {
		assertEquals(1, problems.get(0).getColumn());
	}
	
	@Test
	public void secondProblemShouldOnCorrectLine() {
		assertEquals(20, problems.get(1).getLine());
	}
	
	@Test
	public void secondProblemShouldAtCorrectColumn() {
		assertEquals(13, problems.get(1).getColumn());
	}
}
