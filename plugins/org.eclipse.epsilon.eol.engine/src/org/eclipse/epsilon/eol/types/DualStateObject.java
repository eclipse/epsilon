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
package org.eclipse.epsilon.eol.types;

public class DualStateObject {
	
	protected boolean isWrapped;
	protected Object o;
	protected Object wrapped;
	protected Object unwrapped;
	
	public DualStateObject(Object o) {
		this.o = o;
		this.isWrapped = o instanceof EolAny;
	}
	
	public boolean isNull() {
		return o == null;
	}
	
	public Object getWrapped() {
		if (isWrapped) return o;
		else {
			return EolTypeWrapper.getInstance().wrap(o);
		}
	}
	
	public Object getUnwrapped() {
		if (!isWrapped) return o;
		else {
			return EolTypeWrapper.getInstance().unwrap(o);
		}
	}
	
	// TODO : Optimize
	public boolean equals(Object other) {
		if (this.isNull() && other instanceof DualStateObject && ((DualStateObject) other).isNull()) return true;
		if (other == null || this.isNull() || !(other instanceof DualStateObject) || ((DualStateObject) other).isNull()) return false;
		DualStateObject dso = (DualStateObject) other;
		return this.getUnwrapped().equals(dso.getUnwrapped()) || this.getWrapped().equals(dso.getWrapped());
	}
}
