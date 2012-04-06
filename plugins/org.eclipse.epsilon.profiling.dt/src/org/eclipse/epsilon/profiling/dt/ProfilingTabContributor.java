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
package org.eclipse.epsilon.profiling.dt;

import org.eclipse.debug.ui.ILaunchConfigurationDialog;
import org.eclipse.debug.ui.ILaunchConfigurationTab;
import org.eclipse.epsilon.common.dt.launching.tabs.EpsilonLaunchConfigurationTabContributor;
import org.eclipse.epsilon.common.dt.launching.tabs.EpsilonLaunchConfigurationTabGroup;

public class ProfilingTabContributor implements
		EpsilonLaunchConfigurationTabContributor {

	public ProfilingTabContributor() {
		
	}

	@Override
	public ILaunchConfigurationTab[] getTabs(
			EpsilonLaunchConfigurationTabGroup tabGroup,
			ILaunchConfigurationDialog dialog, String mode) {
		
		return new ILaunchConfigurationTab[]{new ProfilingConfigurationTab()};
	}

}
