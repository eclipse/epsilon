package org.eclipse.epsilon.eol.dt.launching.tabs;

import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.epsilon.common.dt.EpsilonPlugin;
import org.eclipse.epsilon.common.dt.launching.tabs.AbstractAdvancedConfigurationTab;
import org.eclipse.epsilon.eol.dt.EolPlugin;

public class EolAdvancedConfigurationTab extends AbstractAdvancedConfigurationTab {

	@Override
	public EpsilonPlugin getPlugin() {
		return EolPlugin.getDefault();
	}

	@Override
	public String getLanguage() {
		return "EOL";
	}

	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
	}


}
