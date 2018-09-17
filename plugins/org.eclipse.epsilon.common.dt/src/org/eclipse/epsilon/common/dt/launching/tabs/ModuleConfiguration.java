package org.eclipse.epsilon.common.dt.launching.tabs;

import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.swt.widgets.Composite;

public interface ModuleConfiguration {
	
	/**
	 * Create the composite that contains the module configuration options
	 * @param parent
	 * @return
	 */
	Composite createModuleConfigurationGroup(Composite parent);
	
	/**
	 * Initialise the composite for this module with the configuration values
	 * @param configuration
	 */
	void initializeFrom(ILaunchConfiguration configuration);

	/**
	 * Store the configured values in the configuration
	 * @param configuration
	 */
	void performApply(ILaunchConfigurationWorkingCopy configuration);
	
}