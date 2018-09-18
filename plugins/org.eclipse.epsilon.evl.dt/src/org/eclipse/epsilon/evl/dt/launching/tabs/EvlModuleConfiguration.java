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

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.epsilon.common.dt.launching.tabs.AbstractModuleConfiguration;
import org.eclipse.epsilon.evl.EvlModule;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

public class EvlModuleConfiguration extends AbstractModuleConfiguration {

	private Button optimizeConstraintsBtn;

	@Override
	public void createModuleConfigurationWidgets(Composite group) {
		optimizeConstraintsBtn = new Button(group, SWT.CHECK);
		optimizeConstraintsBtn.setText("Optimize Constraints to Select Operations");
	}

	@Override
	public void initializeFrom(ILaunchConfiguration configuration) {
		try {
			if (configuration.getAttribute(EvlModule.OPTIMIZE_CONSTRAINTS, false)) {
				optimizeConstraintsBtn.setSelection(true);
			}
		}
		catch (CoreException e) {
			// skip 
		}
	}

	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		boolean optimiseConstraints = optimizeConstraintsBtn != null ? optimizeConstraintsBtn.getSelection() : false;
		configuration.setAttribute(EvlModule.OPTIMIZE_CONSTRAINTS, optimiseConstraints);
	}
}
