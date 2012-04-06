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
package org.eclipse.epsilon.emc.emf;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;

public class EmfXMIResource extends XMIResourceImpl {
	
	protected boolean useXmiIds = false;
	
	public boolean isUseXmiIds() {
		return useXmiIds;
	}
	
	public void setUseXmiIds(boolean useXmiIds) {
		this.useXmiIds = useXmiIds;
	}
	
	public EmfXMIResource(URI uri) {
		super(uri);
	}
	
	@Override
	protected boolean useUUIDs() {
		return isUseXmiIds();
	}
	
}
