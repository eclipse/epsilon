package org.eclipse.epsilon.ecl.dt.launching.tabs;

import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.epsilon.common.dt.EpsilonPlugin;
import org.eclipse.epsilon.common.dt.launching.tabs.AbstractAdvancedConfigurationTab;
import org.eclipse.epsilon.ecl.dt.EclPlugin;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;

public class EclAdvancedConfigurationTab extends AbstractAdvancedConfigurationTab {

	@Override
	public EpsilonPlugin getPlugin() {
		return EclPlugin.getDefault();
	}

	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
		// TODO Implement ILaunchConfigurationTab.setDefaults
//		throw new UnsupportedOperationException("Unimplemented Method    ILaunchConfigurationTab.setDefaults invoked.");
	}

	@Override
	public void createAdditionalGroups(Composite control) {
		// TODO Implement AbstractAdvancedConfigurationTab.createAdditionalGroups
//		throw new UnsupportedOperationException("Unimplemented Method    AbstractAdvancedConfigurationTab.createAdditionalGroups invoked.");
	}

	@Override
	public String getLanguage() {
		return "ECL";
	}
	
}
