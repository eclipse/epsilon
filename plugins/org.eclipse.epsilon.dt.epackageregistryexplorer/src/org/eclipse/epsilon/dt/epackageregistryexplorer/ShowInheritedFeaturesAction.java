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

public class ShowInheritedFeaturesAction extends Action {
	
	protected PackageRegistryExplorerView view; 
	
	public ShowInheritedFeaturesAction(PackageRegistryExplorerView view) {
		this.view = view;
		this.setChecked(view.isShowInheritedFeatures());
		this.setText("Show inherited features");
		this.setImageDescriptor(Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "icons/supertypes.png"));
	}
	
	@Override
	public void run() {
		view.setShowInheritedFeatures(!view.isShowInheritedFeatures());
	}
}
 