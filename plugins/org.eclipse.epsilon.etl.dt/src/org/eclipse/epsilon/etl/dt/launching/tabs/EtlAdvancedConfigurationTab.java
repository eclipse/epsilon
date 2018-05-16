package org.eclipse.epsilon.etl.dt.launching.tabs;

import java.util.Arrays;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.epsilon.common.dt.EpsilonPlugin;
import org.eclipse.epsilon.common.dt.launching.tabs.AbstractAdvancedConfigurationTab;
import org.eclipse.epsilon.etl.dt.EtlPlugin;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;

public class EtlAdvancedConfigurationTab extends AbstractAdvancedConfigurationTab {

	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
		// TODO Implement EtlAdvancedConfigurationTab.setDefaults
//		throw new UnsupportedOperationException(
//				"Unimplemented Method    EtlAdvancedConfigurationTab.setDefaults invoked.");
	}

	@Override
	public EpsilonPlugin getPlugin() {
		return EtlPlugin.getDefault();
	}


	@Override
	public void createAdditionalGroups(FillLayout parentLayout) {
		// TODO Implement EtlAdvancedConfigurationTab.createAdditionalGroups
//		throw new UnsupportedOperationException(
//				"Unimplemented Method    EtlAdvancedConfigurationTab.createAdditionalGroups invoked.");
	}

	@Override
	public void storeValuesInConfiguration(ILaunchConfiguration configuration) {
		// TODO Implement EtlAdvancedConfigurationTab.storeValuesInConfiguration
//		throw new UnsupportedOperationException(
//				"Unimplemented Method    EtlAdvancedConfigurationTab.storeValuesInConfiguration invoked.");
	}

	@Override
	public void populateFromConfiguration(ILaunchConfiguration configuration) throws CoreException {
		// TODO Implement EtlAdvancedConfigurationTab.populateFromConfiguration
	}
	
	@Override
	public List<String> getImplementations() {
		return Arrays.asList("Etl");
	}

}
