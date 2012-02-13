package org.eclipse.epsilon.examples.launchconfigurationextension;

import org.eclipse.debug.ui.ILaunchConfigurationDialog;
import org.eclipse.debug.ui.ILaunchConfigurationTab;
import org.eclipse.epsilon.common.dt.launching.tabs.EpsilonLaunchConfigurationTabContributor;
import org.eclipse.epsilon.common.dt.launching.tabs.EpsilonLaunchConfigurationTabGroup;

public class DummyLaunchConfigurationTabContributor implements EpsilonLaunchConfigurationTabContributor {

	@Override
	public ILaunchConfigurationTab[] getTabs(
			EpsilonLaunchConfigurationTabGroup tabGroup,
			ILaunchConfigurationDialog dialog, String mode) {
		return new ILaunchConfigurationTab[]{new DummyLaunchConfigurationTab()};
	}

}
