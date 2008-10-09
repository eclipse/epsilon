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
package org.eclipse.epsilon.hutn.test.util;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.epsilon.emc.emf.EmfUtil;
import org.eclipse.epsilon.hutn.test.acceptance.models.Families;
import org.junit.BeforeClass;

public class HutnTestWithFamiliesMetaModel {

	protected static final String CONFIG_FILE = "../org.eclipse.epsilon.hutn.test.dependencies/models/org/eclipse/epsilon/hutn/test/acceptance/models/FamiliesConfig.model";
	
	@BeforeClass
	public static void registerMetaModels() throws Exception {
		EmfUtil.register(Families.getMetaModelUri(), EPackage.Registry.INSTANCE);
	}
}
