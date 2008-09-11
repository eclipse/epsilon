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

import java.net.URI;

public class OutputFile extends Container<ProtectedRegion> {
	
	protected OutputFile(Template template, String name, URI uri) {
		super(template, name, uri);
		
		if (template==null)
			throw new NullPointerException("template cannot be null.");
		
		if (uri==null)
			throw new NullPointerException("uri cannot be null.");
	}

	public ProtectedRegion addProtectedRegion(String id, boolean enabled, int offset) {
		final ProtectedRegion pr = new ProtectedRegion(this, id, enabled, offset);
		super.add(pr);
		return pr;
	}
}
