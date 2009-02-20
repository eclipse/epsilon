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
 * $Id$
 */
package org.eclipse.epsilon.hutn.test.models;

import java.io.File;

import org.eclipse.emf.common.util.URI;
import org.eclipse.epsilon.hutn.test.models.util.FileUtil;

public abstract class BankAccounts {

	private BankAccounts() {}
	
	public static File getMetaModelFile() {
		return FileUtil.getFile("BankAccounts.ecore", BankAccounts.class);
	}
	
	public static URI getMetaModelUri() {
		return URI.createFileURI(getMetaModelFile().getAbsolutePath());
	}
}
