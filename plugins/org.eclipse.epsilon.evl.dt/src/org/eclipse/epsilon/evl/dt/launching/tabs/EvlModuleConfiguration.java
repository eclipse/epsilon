package org.eclipse.epsilon.evl.dt.launching.tabs;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.epsilon.common.dt.launching.tabs.ModuleConfiguration;
import org.eclipse.epsilon.common.dt.util.DialogUtil;
import org.eclipse.epsilon.evl.EvlModule;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

public class EvlModuleConfiguration implements ModuleConfiguration {

	private Button optimizeConstraintsBtn;

	@Override
	public Composite createModuleConfigurationGroup(Composite parent) {
		final Composite group = DialogUtil.createGroupContainer(parent, "Module Configuration", 2);
		optimizeConstraintsBtn = new Button(group, SWT.CHECK);
		optimizeConstraintsBtn.setText("Optimize Constraints to Select Operations");
		return group;
	}

	@Override
	public void initializeFrom(ILaunchConfiguration configuration) {
		try {
			if (configuration.getAttribute(EvlModule.OPTIMIZE_CONSTRAINTS, false)) {
				optimizeConstraintsBtn.setSelection(true);
			}
		} catch (CoreException e) {
			// skip 
		}
	}

	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(EvlModule.OPTIMIZE_CONSTRAINTS, optimizeConstraintsBtn.getSelection());

	}


}
