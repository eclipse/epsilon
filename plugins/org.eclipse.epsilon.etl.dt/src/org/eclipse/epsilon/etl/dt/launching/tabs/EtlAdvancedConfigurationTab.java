package org.eclipse.epsilon.etl.dt.launching.tabs;

import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.epsilon.common.dt.EpsilonPlugin;
import org.eclipse.epsilon.common.dt.launching.tabs.AbstractAdvancedConfigurationTab;
import org.eclipse.epsilon.etl.dt.EtlPlugin;

public class EtlAdvancedConfigurationTab extends AbstractAdvancedConfigurationTab {

	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
	}

	@Override
	public EpsilonPlugin getPlugin() {
		return EtlPlugin.getDefault();
	}

	@Override
	public String getLanguage() {
		return "ETL";
	}



}
