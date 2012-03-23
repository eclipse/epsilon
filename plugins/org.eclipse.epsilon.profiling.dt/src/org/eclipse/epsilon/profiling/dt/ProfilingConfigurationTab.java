/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.profiling.dt;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.epsilon.common.dt.EpsilonCommonsPlugin;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

public class ProfilingConfigurationTab extends AbstractLaunchConfigurationTab{
	
	private Button enableProfilerButton = null;
	private Button resetProfilerButton = null;
	private Button fineGrainedProfilingButton = null;
	
	public void createControl(Composite parent) {
		
		FillLayout parentLayout = new FillLayout();
		parent.setLayout(parentLayout);

		Composite control = new Composite(parent, SWT.FILL);
		setControl(control);
		GridLayout controlLayout = new GridLayout(1, false);
		control.setLayout(controlLayout);
		
		enableProfilerButton = createCheckbox(control, "Enable profiling", null);
		resetProfilerButton = createCheckbox(control, "Reset profiler before launch", enableProfilerButton);
		resetProfilerButton.setEnabled(false);
		fineGrainedProfilingButton = createCheckbox(control, "Fine-grained profiling", enableProfilerButton);
		fineGrainedProfilingButton.setEnabled(false);
		
		control.pack();
		control.layout();
		
		canSave();
	}

	
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
		
	}
	
	public void initializeFrom(ILaunchConfiguration configuration) {
		try {
			boolean profilerEnabled = configuration.getAttribute(ProfilingLaunchConfigurationAttributes.PROFILING_ENABLED, false);
			boolean resetProfiler = configuration.getAttribute(ProfilingLaunchConfigurationAttributes.RESET_PROFILER, false);
			boolean fineGrainedProfiling = configuration.getAttribute(ProfilingLaunchConfigurationAttributes.FINE_GRAINED_PROFILING, false);
			enableProfilerButton.setSelection(profilerEnabled);
			resetProfilerButton.setSelection(resetProfiler);
			fineGrainedProfilingButton.setSelection(fineGrainedProfiling);
			resetProfilerButton.setEnabled(enableProfilerButton.getSelection());
			fineGrainedProfilingButton.setEnabled(enableProfilerButton.getSelection());
			canSave();
			updateLaunchConfigurationDialog();
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}
	
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(ProfilingLaunchConfigurationAttributes.PROFILING_ENABLED, enableProfilerButton.getSelection());
		configuration.setAttribute(ProfilingLaunchConfigurationAttributes.RESET_PROFILER, resetProfilerButton.getSelection());
		configuration.setAttribute(ProfilingLaunchConfigurationAttributes.FINE_GRAINED_PROFILING, fineGrainedProfilingButton.getSelection());
		
	}

	public String getName() {
		return "Profiling";
	}
	
	@Override
	public Image getImage() {
		return EpsilonCommonsPlugin.createImage("icons/profiling.png");
	}
	
	@Override
	public boolean canSave(){
		setErrorMessage(null);
		return true;
	}
	
	private Button createCheckbox(Composite parent, String text, final Button parentCheckBox) {
		final Button button = new Button(parent, SWT.CHECK);
		button.setText(text);
		GridData gridData = new GridData(GridData.FILL_HORIZONTAL);
		
		if (parentCheckBox != null) {
			gridData.horizontalIndent = 8;
			parentCheckBox.addSelectionListener(new SelectionListener() {
				
				@Override
				public void widgetSelected(SelectionEvent e) {
					button.setSelection(parentCheckBox.getSelection());
					button.setEnabled(parentCheckBox.getSelection());
				}
				
				@Override
				public void widgetDefaultSelected(SelectionEvent e) {
					
				}
			});
		}
		
		button.setLayoutData(gridData);
		button.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				updateLaunchConfigurationDialog();
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				
			}
		});
		return button;
	}
	
}
