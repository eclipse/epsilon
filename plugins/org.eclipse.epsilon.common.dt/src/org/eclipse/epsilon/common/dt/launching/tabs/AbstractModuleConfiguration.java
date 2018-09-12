package org.eclipse.epsilon.common.dt.launching.tabs;

import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.epsilon.common.dt.util.DialogUtil;
import org.eclipse.swt.widgets.Composite;

public class AbstractModuleConfiguration implements ModuleConfiguration {

	@Override
	public Composite createModuleConfigurationGroup(Composite parent) {
		final Composite group = DialogUtil.createGroupContainer(parent, "", 2);
		return group;
	}

	@Override
	public void initializeFrom(ILaunchConfiguration configuration) {
		// Nothing to do
	}

	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		// Nothing to store
	}

}
