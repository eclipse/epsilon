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

public class TwoMetamodels extends HutnAcceptanceTest {
	
	@BeforeClass
	public static void executeHutn() throws Exception {
		final String hutn = "@Spec {"                                  +
	                        "	MetaModel \"FamiliesMetaModel\" {"     +
	                        "		nsUri = \"families\""              +
	                        "	}"                                     +
	                        "	MetaModel \"BankAccountsMetamodel\" {" +
	                        "		nsUri = \"bankAccounts\""          +
	                        "	}"                                     +
	                        "}"                                        +
                            "Families {"                               +
                            "	Person \"John\" {"                       +
                            "		accounts: Account \"JohnAccount\" {" +
                            "		          	sortCode: \"1234\""      +
                            "		          	number: \"5678\""        +
                            "       } "                                  +
                            "	}"                                       +
                            "}";
		
		model = generateModel(hutn);
		
		model.setVariable("john", "Person.all.first");
	}
	
	@Test
	public void johnShouldHaveOneAccount() {
		model.assertEquals(1, "john.accounts.size()");
	}
	
	@Test
	public void accountShouldHaveCorrectSortCode() {
		model.assertEquals("1234", "john.accounts.first.sortCode");
	}
	
	@Test
	public void accountShouldHaveCorrectNumber() {
		model.assertEquals("5678", "john.accounts.first.number");
	}
}
