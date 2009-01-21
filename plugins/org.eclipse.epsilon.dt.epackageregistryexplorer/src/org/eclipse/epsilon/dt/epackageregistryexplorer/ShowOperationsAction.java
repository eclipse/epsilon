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

package org.eclipse.epsilon.dt.epackageregistryexplorer;

import org.eclipse.jface.action.Action;
import org.eclipse.ui.plugin.AbstractUIPlugin;

public class ShowOperationsAction extends Action {
	
	protected PackageRegistryExplorerView view; 
	
	public ShowOperationsAction(PackageRegistryExplorerView view) {
		this.view = view;
		this.setChecked(view.isShowOperations());
		this.setText("Show operations");
		this.setImageDescriptor(AbstractUIPlugin.imageDescriptorFromPlugin("org.eclipse.emf.ecore.edit", "icons/full/obj16/EOperation.gif"));
	}
	
	@Override
	public void run() {
		view.setShowOperations(!view.isShowOperations());
	}
}
 