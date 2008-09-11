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
package org.eclipse.epsilon.evl.dt.launching;

import org.eclipse.debug.ui.AbstractLaunchConfigurationTabGroup;
import org.eclipse.debug.ui.CommonTab;
import org.eclipse.debug.ui.ILaunchConfigurationDialog;
import org.eclipse.debug.ui.ILaunchConfigurationTab;
import org.eclipse.epsilon.common.dt.launching.tabs.ModelsConfigurationTab;
import org.eclipse.epsilon.evl.dt.launching.tabs.EvlSourceConfigurationTab;

public class EvlLaunchConfigurationTabGroup extends AbstractLaunchConfigurationTabGroup{

	public void createTabs(ILaunchConfigurationDialog dialog, String mode) { 
		ILaunchConfigurationTab[] tabs = 
			new ILaunchConfigurationTab[]{
				new EvlSourceConfigurationTab(),
				new ModelsConfigurationTab(),
				//new ToolsConfigurationTab(),
				new CommonTab()
			};
		setTabs(tabs);
	}

}
