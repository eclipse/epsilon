/*******************************************************************************
 * Copyright (c) 2009 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
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
