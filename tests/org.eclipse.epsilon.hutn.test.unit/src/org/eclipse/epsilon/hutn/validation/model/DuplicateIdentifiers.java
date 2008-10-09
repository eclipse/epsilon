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
 * $Id: DuplicateIdentifiers.java,v 1.1 2008/08/07 14:51:11 louis Exp $
 */

package org.eclipse.epsilon.hutn.validation.model;

import static org.eclipse.epsilon.hutn.test.unit.util.IntermediateUtil.createClass;
import static org.eclipse.epsilon.hutn.test.unit.util.IntermediateUtil.createPackage;
import static org.eclipse.epsilon.hutn.test.unit.util.IntermediateUtil.createSpec;
import static org.junit.Assert.assertEquals;

import org.eclipse.epsilon.hutn.exceptions.HutnValidationException;
import org.junit.BeforeClass;
import org.junit.Test;

public class DuplicateIdentifiers extends HutnModelValidationTest {

	@BeforeClass
	public static void validateModel() throws HutnValidationException {
		problems = modelValidationTest(createSpec("families", createPackage(createClass("Fido", "Pet"),
		                                                                    createClass("Fido", "Person"))));
	}
	
	@Test
	public void validationShouldReportTwoProblems() {
		assertEquals(2, problems.size());
	}
	
	@Test
	public void firstReasonShouldBeDuplicateIdentifier() {
		assertEquals("Duplicate identifier: Fido", problems.get(0).getReason());
	}
	
	@Test
	public void secondReasonShouldBeDuplicateIdentifier() {
		assertEquals("Duplicate identifier: Fido", problems.get(1).getReason());
	}
}
