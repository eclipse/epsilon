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
package org.eclipse.epsilon.eml.dt.launching;

import org.eclipse.debug.ui.ILaunchConfigurationTab;
import org.eclipse.epsilon.common.dt.launching.tabs.EpsilonLaunchConfigurationTabGroup;
import org.eclipse.epsilon.eml.dt.launching.tabs.EmlEclSourceConfigurationTab;
import org.eclipse.epsilon.eml.dt.launching.tabs.EmlSourceConfigurationTab;

public class EmlLaunchConfigurationTabGroup extends EpsilonLaunchConfigurationTabGroup{

	@Override
	public ILaunchConfigurationTab getSourceConfigurationTab() {
		// It's fine to return null here as this is superseded by
		// the getSourceConfigurationTabs() method
		return null;
	}
	
	@Override
	public ILaunchConfigurationTab[] getSourceConfigurationTabs() {
		return new ILaunchConfigurationTab[]{new EmlSourceConfigurationTab(), new EmlEclSourceConfigurationTab()};
	}

}
