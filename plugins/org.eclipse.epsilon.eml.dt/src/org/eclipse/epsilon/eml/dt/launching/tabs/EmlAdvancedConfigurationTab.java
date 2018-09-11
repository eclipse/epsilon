package org.eclipse.epsilon.eml.dt.launching.tabs;

import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.epsilon.common.dt.EpsilonPlugin;
import org.eclipse.epsilon.common.dt.launching.tabs.AbstractAdvancedConfigurationTab;
import org.eclipse.epsilon.eml.dt.EmlPlugin;

public class EmlAdvancedConfigurationTab extends AbstractAdvancedConfigurationTab {

	@Override
	public EpsilonPlugin getPlugin() {
		return EmlPlugin.getDefault();
	}

	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
	}


	@Override
	public String getLanguage() {
		return "EML";
	}

}
