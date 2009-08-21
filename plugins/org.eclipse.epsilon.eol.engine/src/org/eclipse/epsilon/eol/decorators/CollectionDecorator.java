/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
******************************************************************************/

package org.eclipse.epsilon.eol.decorators;

import java.util.Collection;

public class CollectionDecorator implements ObjectDecorator {

	protected Collection c;
	
	public boolean decorates(Object o) {
		return o instanceof Collection;
	}
	
	public void setDecoratedObject(Object o) {
		c = (Collection) o;
	}
	
	public Collection<?> asSequence() {
		return null;
	}
	
	public Collection<?> asSet() {
		return null;
	}
	
	public Collection clone() {
		return null;
	}
	
	public String concat(String delimiter) {
		return null;
	}
	
}
 