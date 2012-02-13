package org.eclipse.epsilon.common.dt.launching.tabs;

import org.eclipse.debug.ui.ILaunchConfigurationDialog;
import org.eclipse.debug.ui.ILaunchConfigurationTab;
import org.eclipse.epsilon.common.dt.launching.tabs.EpsilonLaunchConfigurationTabGroup;

public interface EpsilonLaunchConfigurationTabContributor {
	
	public ILaunchConfigurationTab[] getTabs(EpsilonLaunchConfigurationTabGroup tabGroup, ILaunchConfigurationDialog dialog, String mode);
	
}
