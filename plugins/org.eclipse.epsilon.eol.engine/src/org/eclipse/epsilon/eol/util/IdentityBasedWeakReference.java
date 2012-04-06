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

import java.lang.ref.WeakReference;

public class IdentityBasedWeakReference extends WeakReference<Object> {

	public IdentityBasedWeakReference(Object referent) {
		super(referent);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) return false;
		else return this.hashCode() == obj.hashCode();
	}
	
	@Override
	public int hashCode() {
		if (this.get() != null) {
			return System.identityHashCode(this.get());
		}
		else {
			return super.hashCode();
		}
	}
	
}
