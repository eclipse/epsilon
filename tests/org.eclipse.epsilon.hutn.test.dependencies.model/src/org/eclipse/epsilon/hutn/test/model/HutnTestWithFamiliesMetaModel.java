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
 * $Id: HutnTestWithFamiliesMetaModel.java,v 1.3 2008/08/13 16:21:37 louis Exp $
 */
package org.eclipse.epsilon.hutn.test.model;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.epsilon.emc.emf.EmfUtil;
import org.eclipse.epsilon.hutn.test.model.bankAccounts.BankAccountsPackage;
import org.eclipse.epsilon.hutn.test.model.families.FamiliesPackage;
import org.eclipse.epsilon.hutn.test.models.BankAccounts;
import org.eclipse.epsilon.hutn.test.models.Families;
import org.junit.AfterClass;
import org.junit.BeforeClass;

public class HutnTestWithFamiliesMetaModel {
	
	protected static final String CONFIG_FILE = 
		"../org.eclipse.epsilon.hutn.test.dependencies.model/" +
		"models/org/eclipse/epsilon/hutn/test/models/" +
		"FamiliesConfig.model";
	
	public static final String BANK_ACCOUNTS_MODEL_URI = Families.getBankAccountsModelUri().toString();
	
	@BeforeClass
	public static void registerMetaModels() throws Exception {
		EmfUtil.register(Families.getMetaModelUri(), EPackage.Registry.INSTANCE);
		EmfUtil.register(BankAccounts.getMetaModelUri(), EPackage.Registry.INSTANCE);
	}
	
	@AfterClass
	public static void unregisterMetaModels() throws Exception {
		EPackage.Registry.INSTANCE.remove(FamiliesPackage.eNS_URI);
		EPackage.Registry.INSTANCE.remove(BankAccountsPackage.eNS_URI);
	}

	protected static String families(String body) {
		return "@Spec {"                               + '\n' +
	           "	MetaModel \"FamiliesMetaModel\" {" + '\n' +
	           "		nsUri = \"families\""          + '\n' +
	           "	}"                                 + '\n' +
	           "}"                                     + '\n' +
	           ""                                      + '\n' +
	           "families {"                            + '\n' +
	           body                                    + '\n' +
	           "}";
	}
}
