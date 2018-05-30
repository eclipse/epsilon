package org.eclipse.epsilon.eol.dt.launching.tabs;

import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.epsilon.common.dt.EpsilonPlugin;
import org.eclipse.epsilon.common.dt.launching.tabs.AbstractAdvancedConfigurationTab;
import org.eclipse.epsilon.eol.dt.EolPlugin;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;

public class EolAdvancedConfigurationTab extends AbstractAdvancedConfigurationTab {

	@Override
	public EpsilonPlugin getPlugin() {
		return EolPlugin.getDefault();
	}


	@Override
	public void createAdditionalGroups(Composite control) {
		// Nothing to add
	}


	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
		// No defaults
	}


	@Override
	public String getLanguage() {
		return "EOL";
	}


}
