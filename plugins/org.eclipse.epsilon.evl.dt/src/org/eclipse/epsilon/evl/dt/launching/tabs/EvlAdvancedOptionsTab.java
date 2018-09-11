/*********************************************************************
* Copyright (c) 2008 The University of York.
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
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.epsilon.common.dt.util.LogUtil;
import org.eclipse.epsilon.evl.dt.EvlPlugin;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.PlatformUI;

public class EvlAdvancedOptionsTab extends AbstractLaunchConfigurationTab {

	public static final String OPTIMIZE_CONSTRAINTS = "optimizeConstraints";
	
	private Button optimizeConstraintsBtn, parallelBtn;

	private final SelectionListener selectionListener = new SelectionListener() {
		
		@Override
		public void widgetSelected(SelectionEvent e) {
			updateLaunchConfigurationDialog();
		}
		
		@Override
		public void widgetDefaultSelected(SelectionEvent e) {
			updateLaunchConfigurationDialog();
		}
	};
	
	@Override
	public void createControl(Composite parent) {
		
		final FillLayout parentLayout = new FillLayout();
		parent.setLayout(parentLayout);

		final Composite control = new Composite(parent, SWT.NONE);
		setControl(control);
		control.setLayout(new GridLayout(1, false));
		
		PlatformUI.getWorkbench().getHelpSystem().setHelp(control, "org.eclipse.epsilon.help.egl_generated_text_tab");
		
		createOptimizationGroup(control);
		createParallelGroup(control);
		
		control.setBounds(0, 0, 300, 300);
		control.layout();
		control.pack();
	}

	private void createOptimizationGroup(Composite control) {
		optimizeConstraintsBtn = new Button(control, SWT.CHECK);
		optimizeConstraintsBtn.setText("Optimize Constraints to Select Operations");
		optimizeConstraintsBtn.addSelectionListener(selectionListener);
	}

	private void createParallelGroup(Composite control) {
		parallelBtn = new Button(control, SWT.CHECK);
		parallelBtn.setText("Use multi-threaded implementation");
		parallelBtn.addSelectionListener(selectionListener);
	}

	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
		
	}

	@Override
	public void initializeFrom(ILaunchConfiguration configuration) {
		try {
			optimizeConstraintsBtn.setSelection(configuration.getAttribute(OPTIMIZE_CONSTRAINTS, false));
		}
		catch (CoreException e) {
			LogUtil.log("Error encountered whilst attempting to restore selection of default formatters from launch configuration", e);
		}
	}
	
	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(OPTIMIZE_CONSTRAINTS, optimizeConstraintsBtn.getSelection());
	}

	@Override
	public String getName() {
		return "Advanced";
	}

	@Override
	public Image getImage() {
		return EvlPlugin.getDefault().createImage("icons/advanced.gif");
	}

}
