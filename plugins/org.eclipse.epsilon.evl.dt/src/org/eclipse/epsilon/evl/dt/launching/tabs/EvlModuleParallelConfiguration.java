/*********************************************************************
 * Copyright (c) 2018 The University of York.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.evl.dt.launching.tabs;

import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.epsilon.common.concurrent.ConcurrencyUtils;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Spinner;

public class EvlModuleParallelConfiguration extends EvlModuleConfiguration {

	protected Spinner numThreadsSelector;
	protected Label numThreadsLabel;
	
	@Override
	public Composite createModuleConfigurationGroup(Composite parent) {
		final Composite group = super.createModuleConfigurationGroup(parent);
		
		final Composite container = new Composite(group, SWT.FILL);
		container.setLayout(new GridLayout(2, false));
		container.setLayoutData(new GridData(GridData.FILL_VERTICAL));
		
		numThreadsLabel = new Label(container, SWT.WRAP);
		numThreadsLabel.setText("Number of threads: ");
		
		numThreadsSelector = new Spinner(container, SWT.BORDER);
		numThreadsSelector.setMinimum(1);
		final int initialThreads = ConcurrencyUtils.DEFAULT_PARALLELISM;
		numThreadsSelector.setSelection(initialThreads);
		numThreadsSelector.setIncrement(initialThreads % 2 == 0 ? 2 : (initialThreads % 3 == 0 ? 3 : 1));
		numThreadsSelector.setToolTipText("Parallelism");
		
		return group;
	}

	@Override
	public void initializeFrom(ILaunchConfiguration configuration) {
		super.initializeFrom(configuration);
	}

	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		super.performApply(configuration);
	}

}
