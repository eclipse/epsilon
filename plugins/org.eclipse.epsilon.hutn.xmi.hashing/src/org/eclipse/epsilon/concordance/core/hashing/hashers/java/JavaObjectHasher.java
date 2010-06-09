/*******************************************************************************
 * Copyright (c) 2009 The University of York.
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
package org.eclipse.epsilon.concordance.core.hashing.hashers.java;

import org.eclipse.epsilon.concordance.core.hashing.hashers.Hasher;


public class JavaObjectHasher implements Hasher {

	private static JavaObjectHasher instance = new JavaObjectHasher();
	
	public static JavaObjectHasher getInstance() {
		return instance;
	}
	
	private JavaObjectHasher() {}
	
	
	public int hash(Object object) {	
		return object == null ? 0 : object.hashCode();
	}
}
