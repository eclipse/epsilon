/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
******************************************************************************/
package org.eclipse.epsilon.dt.epackageregistryexplorer;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ResourceLocator;

public class ShowOperationsAction extends Action {
	
	protected PackageRegistryExplorerView view; 
	
	public ShowOperationsAction(PackageRegistryExplorerView view) {
		this.view = view;
		this.setChecked(view.isShowOperations());
		this.setText("Show operations");
		ResourceLocator.imageDescriptorFromBundle("org.eclipse.emf.ecore.edit", "icons/full/obj16/EOperation.gif").ifPresent(this::setImageDescriptor);
	}
	
	@Override
	public void run() {
		view.setShowOperations(!view.isShowOperations());
	}
}
 
