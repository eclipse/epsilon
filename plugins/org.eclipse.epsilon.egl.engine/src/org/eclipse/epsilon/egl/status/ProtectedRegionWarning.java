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
package org.eclipse.epsilon.egl.status;

public class ProtectedRegionWarning extends Warning {

	private final String id;
	
	public ProtectedRegionWarning(String id) {
		this(id, null);
	}
	
	public ProtectedRegionWarning(String id, String path) {
		super("The protected region '" + id + "' " + 
		      "was not preserved in " + (path == null ? "the new output." : path));
		
		this.id = id;
	}

	public String getId() {
		return id;
	}
}
