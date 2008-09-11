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

package org.eclipse.epsilon.ewl.emf;

import org.eclipse.ui.IWorkbenchPart;

public abstract class WorkbenchPartRefresher {
	
	
	protected IWorkbenchPart part = null;
	
	public WorkbenchPartRefresher() {
		
	}

	public IWorkbenchPart getPart() {
		return part;
	}



	public void setPart(IWorkbenchPart part) {
		this.part = part;
	}



	public abstract void refresh();
	
}
 