/*******************************************************************************
 * Copyright (c) 2012 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.eol.util;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

public class IdentityBasedWeakReference extends WeakReference<Object> {
	
	int hashCode = -1;
	
	public IdentityBasedWeakReference(Object referent, ReferenceQueue<Object> referenceQueue) {
		super(referent, referenceQueue);
		hashCode = System.identityHashCode(referent);

	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) return false;
		else return this.hashCode() == obj.hashCode();
	}
	
	@Override
	public int hashCode() {
		return hashCode;
	}
	
	
	
}
