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
package org.eclipse.epsilon.common.dt.actions;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

public abstract class AbstractObjectActionDelegate implements IObjectActionDelegate {
	
	protected ISelection selection;
	
	
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {}

	public void selectionChanged(IAction action, ISelection selection) {
		this.selection = selection;
	}
	
	protected Object getFirstElementOf(ISelection selection) {
		if (selection instanceof IStructuredSelection)
			return ((IStructuredSelection)selection).getFirstElement();
		
		else
			return null;	
	}
	
	protected Object getFirstElementInSelection() {
		return getFirstElementOf(selection);	
	}
	
	public abstract void run(IAction action);
}
