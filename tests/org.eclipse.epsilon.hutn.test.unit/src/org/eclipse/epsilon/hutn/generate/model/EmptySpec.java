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
 * $Id: EmptySpec.java,v 1.2 2008/08/07 12:44:20 louis Exp $
 */
package org.eclipse.epsilon.hutn.generate.model;

import static org.eclipse.epsilon.hutn.test.unit.util.IntermediateUtil.*;

import org.eclipse.epsilon.hutn.exceptions.HutnGenerationException;
import org.junit.BeforeClass;
import org.junit.Test;

public class EmptySpec extends HutnModelGeneratorTest {

	@BeforeClass
	public static void generateModel() throws HutnGenerationException {
		model = modelGeneratorTest(createSpec("families"));
	}
	
	@Test
	public void modelShouldHaveNoFamilies() {
		model.assertEquals(0, "Family.allInstances().size()");
	}
	
	@Test
	public void modelShouldHaveNoPets() {
		model.assertEquals(0, "Pet.allInstances().size()");
	}
}
