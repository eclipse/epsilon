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
