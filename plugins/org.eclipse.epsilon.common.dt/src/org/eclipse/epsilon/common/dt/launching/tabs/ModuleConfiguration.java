package org.eclipse.epsilon.common.dt.launching.tabs;

import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.swt.widgets.Composite;

public interface ModuleConfiguration {
	
	/**
	 * Create the composite that contains the module configuration options
	 * @param group		a SWT Composite that can be used to place swt widgets required
	 * 					for configuring the module. 
	 */
	void createModuleConfigurationWidgets(Composite group);
	
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