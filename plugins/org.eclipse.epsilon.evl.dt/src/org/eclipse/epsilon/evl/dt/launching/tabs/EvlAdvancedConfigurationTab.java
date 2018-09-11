package org.eclipse.epsilon.evl.dt.launching.tabs;

import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.epsilon.common.dt.EpsilonPlugin;
import org.eclipse.epsilon.common.dt.launching.tabs.AbstractAdvancedConfigurationTab;
import org.eclipse.epsilon.evl.dt.EvlPlugin;

public class EvlAdvancedConfigurationTab extends AbstractAdvancedConfigurationTab {


	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {

	}

		
	@Override
	public EpsilonPlugin getPlugin() {
		return EvlPlugin.getDefault();
	}

	@Override
	public String getLanguage() {
		return "EVL";
	}

	
}
