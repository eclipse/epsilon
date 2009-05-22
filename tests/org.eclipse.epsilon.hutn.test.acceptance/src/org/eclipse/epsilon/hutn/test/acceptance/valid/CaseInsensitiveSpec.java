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
 * $Id: Simple.java,v 1.2 2008/08/07 12:44:23 louis Exp $
 */
package org.eclipse.epsilon.hutn.test.acceptance.valid;

import org.eclipse.epsilon.hutn.test.acceptance.util.HutnAcceptanceTest;
import org.junit.BeforeClass;
import org.junit.Test;

public class CaseInsensitiveSpec extends HutnAcceptanceTest {
	
	@BeforeClass
	public static void executeHutn() throws Exception {
		final String hutn = "@spec {"                              +
	                        "	Metamodel \"FamiliesMetaModel\" {" +
	                        "		nsURI = \"families\""          +
	                        "	}"                                 +
	                        "}"                                    +
                            "Families {"                           +
                            "	Family \"The Smiths\" {"           +
                            "		name: \"The Smiths\""          +
                            "	}"                                 +
                            "}";
		
		model = generateModel(hutn);
	}
	
	@Test
	public void modelShouldHaveOneFamily() {
		model.assertEquals(1, "Family.allInstances().size()");
	}
	
	@Test
	public void familyShouldBeCalledTheSmiths() {
		model.assertEquals("The Smiths", "Family.allInstances().first().name");
	}
}
