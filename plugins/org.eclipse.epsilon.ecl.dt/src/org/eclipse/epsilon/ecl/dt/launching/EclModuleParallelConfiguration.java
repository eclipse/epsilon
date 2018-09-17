package org.eclipse.epsilon.ecl.dt.launching;

import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Spinner;

public class EclModuleParallelConfiguration extends EclModuleConfiguration {

	protected Spinner numThreadsSelector;
	protected Label numThreadsLabel;
	
	@Override
	public Composite createModuleConfigurationGroup(Composite parent) {
		Composite group = super.createModuleConfigurationGroup(parent);
		Composite container = createParallelContainer(group);
		numThreadsLabel = createThreadsLabel(container);
		numThreadsSelector = createThreadsSelector(container);
		return group;
	}

	@Override
	public void initializeFrom(ILaunchConfiguration configuration) {
		super.initializeFrom(configuration);
		initializeThreadsFromConfiguration(configuration, numThreadsSelector);
	}

	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		super.performApply(configuration);
		performApplyThreadsForConfiguration(configuration, numThreadsSelector);
	}
	
}
