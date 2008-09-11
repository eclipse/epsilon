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
package org.eclipse.epsilon.etl.dt.launching;

import org.eclipse.debug.ui.AbstractLaunchConfigurationTabGroup;
import org.eclipse.debug.ui.CommonTab;
import org.eclipse.debug.ui.ILaunchConfigurationDialog;
import org.eclipse.debug.ui.ILaunchConfigurationTab;
import org.eclipse.epsilon.common.dt.launching.tabs.ModelsConfigurationTab;
import org.eclipse.epsilon.etl.dt.launching.tabs.EtlSourceConfigurationTab;

public class EtlLaunchConfigurationTabGroup extends AbstractLaunchConfigurationTabGroup{

	public void createTabs(ILaunchConfigurationDialog dialog, String mode) { 
		ILaunchConfigurationTab[] tabs = 
			new ILaunchConfigurationTab[]{
				new EtlSourceConfigurationTab(),
				new ModelsConfigurationTab(),
				//new ModelChoiceTab(),
				//new TransformationStrategyConfigurationTab(),
				//new LibrariesConfigurationTab(),
				//new ToolsConfigurationTab(),
				new CommonTab()
			};
		setTabs(tabs);
	}

}
