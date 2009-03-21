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
 * $Id: Enumerations.java,v 1.2 2008/08/12 12:52:33 louis Exp $
 */
package org.eclipse.epsilon.hutn.test.acceptance.valid;

import org.eclipse.epsilon.hutn.test.acceptance.util.HutnAcceptanceTest;
import org.junit.BeforeClass;
import org.junit.Test;

public class Enumerations extends HutnAcceptanceTest {
	
	@BeforeClass
	public static void executeHutn() throws Exception {
		final String hutn = "@Spec {"                                  +
	                        "	MetaModel \"FamiliesMetaModel\" {"     +
	                        "		nsUri = \"families\""              +
	                        "	}"                                     +
	                        "}"                                        +
                            "Families {"                               +
                            "	Dog \"Fido\" {"                        +
                            "		breed: labrador"                   +
                            "	}"                                     +
                            "}";
		
		model = generateModel(hutn);
		
		model.setVariable("fido", "Pet.allInstances().first()");
	}
	
	@Test
	public void modelShouldHaveOnePet() {
		model.assertEquals(1, "Pet.allInstances().size()");
	}
	
	@Test
	public void fidoShouldBeALabrador() throws Throwable {
		model.assertEquals("DogBreed#labrador", "fido.breed");
	}
}
