/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.egl.traceability;

public abstract class Content<P> {

	private P parent;
	
	public Content(P parent) {
		this.parent = parent;
	}
	
	public P getParent() {
		return parent;
	}
	
	protected void setParent(P parent) {
		this.parent = parent;
	}
}
