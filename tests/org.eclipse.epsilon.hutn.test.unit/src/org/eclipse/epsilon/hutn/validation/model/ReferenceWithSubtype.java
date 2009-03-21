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
 * $Id: ReferenceWithSubtype.java,v 1.2 2008/10/09 11:54:05 louis Exp $
 */
package org.eclipse.epsilon.hutn.validation.model;

import static org.eclipse.epsilon.hutn.test.unit.util.IntermediateUtil.createClass;
import static org.eclipse.epsilon.hutn.test.unit.util.IntermediateUtil.createPackage;
import static org.eclipse.epsilon.hutn.test.unit.util.IntermediateUtil.createSpec;
import static org.eclipse.epsilon.hutn.test.unit.util.IntermediateUtil.createReferenceSlot;
import static org.eclipse.epsilon.hutn.test.unit.util.IntermediateUtil.createAttributeSlot;
import static org.junit.Assert.assertEquals;

import org.eclipse.epsilon.hutn.exceptions.HutnValidationException;
import org.junit.BeforeClass;
import org.junit.Test;

public class ReferenceWithSubtype extends HutnModelValidationTest {

	@BeforeClass
	public static void validateModel() throws HutnValidationException {
		problems = modelValidationTest(createSpec("families", createPackage(createClass("Fido", "Dog", createAttributeSlot("breed", "poodle")),
		                                                                    createClass("The Smiths",
		                                                                                "Family",
		                                                                                createReferenceSlot("pets", "Fido")))));
	}
	
	@Test
	public void validationShouldReportNoProblems() {
		assertEquals(0, problems.size());
	}
}
