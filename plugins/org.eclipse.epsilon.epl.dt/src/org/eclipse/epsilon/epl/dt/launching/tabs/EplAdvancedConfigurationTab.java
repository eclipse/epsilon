package org.eclipse.epsilon.epl.dt.launching.tabs;

import java.util.Arrays;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.epsilon.common.dt.EpsilonPlugin;
import org.eclipse.epsilon.common.dt.launching.tabs.AbstractAdvancedConfigurationTab;
import org.eclipse.epsilon.epl.dt.EplPlugin;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;

public class EplAdvancedConfigurationTab extends AbstractAdvancedConfigurationTab {

	@Override
	public EpsilonPlugin getPlugin() {
		return EplPlugin.getDefault();
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
		return "EPL";
	}

	
}
