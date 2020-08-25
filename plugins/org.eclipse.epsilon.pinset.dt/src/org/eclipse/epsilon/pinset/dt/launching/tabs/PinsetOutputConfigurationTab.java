/*********************************************************************
 * Copyright (c) 2020 The University of York.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *********************************************************************/
package org.eclipse.epsilon.pinset.dt.launching.tabs;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

/**
 * PinsetOutputConfigurationTab.
 *
 * @author Alfonso de la Vega
 * @since 2.1
 */
public class PinsetOutputConfigurationTab
		extends AbstractLaunchConfigurationTab implements ModifyListener {
	// Configuration keys
	public static final String OUTPUT_FOLDER = "outputFolder";
	public static final String SILENT_EXECUTION = "silentExecution";

	// Configuration default values
	public static final String DEFAULT_OUTPUT_FOLDER = "";
	public static final boolean DEFAULT_SILENT_EXECUTION = false;

	protected Label folderLabel;
	protected Text folderPath;
	protected Button silentExecutionButton;

	@Override
	public void createControl(Composite parent) {

		FillLayout parentLayout = new FillLayout();
		parent.setLayout(parentLayout);

		Composite control = new Composite(parent, SWT.NONE);
		setControl(control);

		GridLayout controlLayout = new GridLayout(1, false);
		control.setLayout(controlLayout);

		final Group outputGroup = createGroup(control,
				"Introduce a folder for the generated output", 1);

		GridData filePathData = new GridData(GridData.FILL_HORIZONTAL);
		folderPath = new Text(outputGroup, SWT.BORDER);
		folderPath.setLayoutData(filePathData);
		folderPath.addModifyListener(this);

		final Group executionGroup = createGroup(control,
				"Execution options", 1);

		silentExecutionButton = new Button(executionGroup, SWT.CHECK);
		silentExecutionButton.setText(
				"Silent Execution (Omit non-fatal errors in column generation)");
		silentExecutionButton.setLayoutData(filePathData);
		silentExecutionButton.addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				updateLaunchConfigurationDialog();
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				updateLaunchConfigurationDialog();
			}
		});

		control.setBounds(0, 0, 300, 300);
		control.layout();
		control.pack();

		canSave();
	}

	protected Group createGroup(Composite control, String name, int numberOfColumns) {
		final Group group = new Group(control, SWT.SHADOW_ETCHED_IN);
		group.setLayout(new GridLayout(numberOfColumns, false));
		group.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		group.setText(name);
		return group;
	}

	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
	}

	@Override
	public void initializeFrom(ILaunchConfiguration configuration) {
		try {
			folderPath.setText(configuration.getAttribute(OUTPUT_FOLDER,
					DEFAULT_OUTPUT_FOLDER));
			silentExecutionButton.setSelection(configuration.getAttribute(
					SILENT_EXECUTION, DEFAULT_SILENT_EXECUTION));
			canSave();
			updateLaunchConfigurationDialog();
		}
		catch (CoreException e) {
			// Ignore
		}
	}

	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(OUTPUT_FOLDER, folderPath.getText());
		configuration.setAttribute(SILENT_EXECUTION, silentExecutionButton.getSelection());
	}

	@Override
	public boolean canSave() {
		IFolder folder = null;
		try {
			folder = ResourcesPlugin.getWorkspace().getRoot().getFolder(
					new Path(folderPath.getText()));
		}
		catch (Exception ex) {
			// do nothing
		}
		if (folder == null || !folder.exists()) {
			setErrorMessage("Selected folder "
					+ folderPath.getText() + " does not exist");
			return false;
		}
		else {
			setErrorMessage(null);
			return true;
		}
	}

	@Override
	public void modifyText(ModifyEvent e) {
		canSave();
		updateLaunchConfigurationDialog();
	}

	@Override
	public String getName() {
		return getTitle();
	}

	public String getTitle() {
		return "Output";
	}
}
