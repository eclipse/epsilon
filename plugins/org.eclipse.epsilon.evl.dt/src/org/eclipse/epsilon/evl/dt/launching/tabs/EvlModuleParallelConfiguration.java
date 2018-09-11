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
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Spinner;

public class EvlModuleParallelConfiguration extends EvlModuleConfiguration {

	protected Spinner numThreads;
	
	@Override
	public Composite createModuleConfigurationGroup(Composite parent) {
		final Composite group = super.createModuleConfigurationGroup(parent);
		numThreads = new Spinner(group, SWT.BORDER);
		numThreads.setMinimum(1);
		final int initialThreads = ConcurrencyUtils.DEFAULT_PARALLELISM;
		numThreads.setSelection(initialThreads);
		numThreads.setIncrement(initialThreads % 2 == 0 ? 2 : (initialThreads % 3 == 0 ? 3 : 1));
		numThreads.setToolTipText("Number of threads");
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
