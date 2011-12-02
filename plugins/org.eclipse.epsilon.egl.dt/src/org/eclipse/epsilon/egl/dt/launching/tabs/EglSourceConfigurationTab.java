/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.egl.dt.launching.tabs;

import static org.eclipse.epsilon.egl.dt.launching.EglLaunchConfigurationAttributes.*;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.epsilon.common.dt.EpsilonPlugin;
import org.eclipse.epsilon.common.dt.launching.AbstractSourceConfigurationTab;
import org.eclipse.epsilon.egl.dt.EglPlugin;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class EglSourceConfigurationTab extends AbstractSourceConfigurationTab implements SelectionListener {

	
	protected Text outputFilePath;
	private Button generateToConsole;
	private Button generateToFile;
	private Button browseForOutputFile;
	private Button appendToFile;
	private Text traceDestination;
	private Button browseForTraceDestination;
	private Button produceTrace;
	
	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setLayout( new RowLayout());
		
		new EglSourceConfigurationTab().createControl(shell);
		
		shell.pack();
		shell.open();
		while( !shell.isDisposed())
		{
			if(!display.readAndDispatch()) 
				display.sleep();
		}
		display.dispose();
	}
	
	@Override
	public void createControl(Composite parent) {
		
		FillLayout parentLayout = new FillLayout();
		parent.setLayout(parentLayout);

		Composite control = new Composite(parent, SWT.NONE);
		setControl(control);
		
		control.setLayout(new GridLayout(1, false));
		
		createSourceGroup(control);
		createTargetGroup(control);
		createTraceGroup(control);
		
		control.setBounds(0, 0, 300, 300);
		control.layout();
		control.pack();
		
		canSave();
	}

	private void createSourceGroup(Composite control) {
		final Group sourceGroup = createGroup(control, "Source", 2);
		
		GridData filePathData = new GridData(GridData.FILL_HORIZONTAL);
		filePath = new Text(sourceGroup, SWT.BORDER);
		filePath.setLayoutData(filePathData);
		filePath.addModifyListener(this);
		
		createBrowseWorkspaceButton(sourceGroup, filePath);
	}

	private void createTargetGroup(Composite control) {
		final Group targetGroup = createGroup(control, "Target:", 1);
		
		generateToConsole = new Button(targetGroup, SWT.RADIO);
		generateToConsole.setText("Generate text to console");
		generateToConsole.addSelectionListener(this);
		
		generateToFile = new Button(targetGroup, SWT.RADIO);
		generateToFile.setText("Generate text to a file:");
		generateToFile.addSelectionListener(new SelectionListener() {
			
			public void widgetDefaultSelected(SelectionEvent e) {
				updateEnabledStateOfOutputFileWidgets();
			}

			public void widgetSelected(SelectionEvent e) {
				updateEnabledStateOfOutputFileWidgets();
				
				if (generateToFile.getSelection())
					outputFilePath.setFocus();
			}
			
		});
		
		final Composite outputFileContainer = createTwoColumnComposite(targetGroup);
		outputFilePath = createPathTextBox(outputFileContainer);		
		browseForOutputFile = createBrowseWorkspaceButton(outputFileContainer, outputFilePath);
		
		GridData appendToFileData = new GridData(GridData.FILL_HORIZONTAL);
		appendToFileData.horizontalIndent = 25;
		appendToFile = new Button(outputFileContainer, SWT.CHECK);
		appendToFile.setText("Append to file");
		appendToFile.setLayoutData(appendToFileData);
		appendToFile.addSelectionListener(this);
	}
	
	private void createTraceGroup(Composite control) {
		final Group traceGroup = createGroup(control, "Trace:", 1);
		
		produceTrace = new Button(traceGroup, SWT.CHECK);
		produceTrace.setText("Produce a trace model?");
		produceTrace.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				updateEnabledStateOfTraceWidgets();
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				updateEnabledStateOfTraceWidgets();
			}
		});		
		
		final Composite traceDestinationContainer = createTwoColumnComposite(traceGroup);
		traceDestination = createPathTextBox(traceDestinationContainer);
		browseForTraceDestination = createBrowseWorkspaceButton(traceDestinationContainer, traceDestination);
	}
	
	private Group createGroup(Composite control, String name, int numberOfColumns) {
		final Group group = new Group(control, SWT.SHADOW_ETCHED_IN);
		group.setLayout(new GridLayout(numberOfColumns, false));
		group.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		group.setText(name);
		return group;
	}
	
	private Composite createTwoColumnComposite(Composite parent) {
		final Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		composite.setLayout(new GridLayout(2, false));
		return composite;
	}
	
	private Text createPathTextBox(Composite parent) {
		final Text text = new Text(parent, SWT.BORDER);
		
		final GridData data = new GridData(GridData.FILL_HORIZONTAL);
		data.horizontalIndent = 25;
		text.setLayoutData(data);
		
		text.addModifyListener(this);
		
		return text;
	}
	
	private Button createBrowseWorkspaceButton(Composite parent, Text target) {
		final Button button = new Button(parent, SWT.NONE);
		button.setText("Browse Workspace...");
		button.addListener(SWT.Selection, new SelectSourceListener(target));
		return button;
	}
	
	protected void updateEnabledStateOfOutputFileWidgets() {
		boolean enable = generateToFile.getSelection(); 
			
		outputFilePath.setEnabled(enable);
		browseForOutputFile.setEnabled(enable);
		appendToFile.setEnabled(enable);
	}
	
	private void updateEnabledStateOfTraceWidgets() {
		traceDestination.setEnabled(produceTrace.getSelection());
		browseForTraceDestination.setEnabled(produceTrace.getSelection());
	}
	
	
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
		super.setDefaults(configuration);
		
		configuration.setAttribute(GENERATE_TO, GENERATE_TO_CONSOLE);
		configuration.setAttribute(OUTPUT_FILE_PATH, "");
		configuration.setAttribute(APPEND_TO_FILE, false);
		configuration.setAttribute(PRODUCE_TRACE, false);
	}
	
	public void initializeFrom(ILaunchConfiguration configuration) {
		super.initializeFrom(configuration);
		
		try {
			switch (configuration.getAttribute(GENERATE_TO, GENERATE_TO_CONSOLE)) {
				case GENERATE_TO_CONSOLE:
					generateToConsole.setSelection(true);
					generateToFile.setSelection(false);
					break;
				
				case GENERATE_TO_FILE:
					generateToFile.setSelection(true);
					generateToConsole.setSelection(false);
					break;
			}
			
			outputFilePath.setText(configuration.getAttribute(OUTPUT_FILE_PATH, ""));			
			appendToFile.setSelection(configuration.getAttribute(APPEND_TO_FILE, false));
			
			traceDestination.setText(configuration.getAttribute(TRACE_DESTINATION, ""));
			produceTrace.setSelection(configuration.getAttribute(PRODUCE_TRACE, false));
			
			updateEnabledStateOfOutputFileWidgets();
			updateEnabledStateOfTraceWidgets();
			
		} catch (CoreException e) {
			// ignore
		}
		
	}

	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		super.performApply(configuration);
		
		configuration.setAttribute(GENERATE_TO,
		                           generateToFile.getSelection() ? GENERATE_TO_FILE : GENERATE_TO_CONSOLE);
		configuration.setAttribute(OUTPUT_FILE_PATH, outputFilePath.getText());
		configuration.setAttribute(APPEND_TO_FILE, appendToFile.getSelection());
		
		configuration.setAttribute(TRACE_DESTINATION, traceDestination.getText());
		configuration.setAttribute(PRODUCE_TRACE, produceTrace.getSelection());
	}
	
	@Override
	public EpsilonPlugin getPlugin() {
		return EglPlugin.getDefault();
	}

	@Override
	public String getImagePath() {
		return "icons/egl.png";
	}

	@Override
	public String getFileExtension() {
		return "egl";
	}

	@Override
	public String getSelectionTitle() {
		return "Select an EGL Program";
	}

	@Override
	public String getSelectionSubtitle() {
		return "EGL Programs in Workspace";
	}

	public String getLaunchConfigurationKey() {
		return "SOURCE.EGL";
	}

	@Override
	public String getTitle() {
		return "Template";
	}

	public void widgetDefaultSelected(SelectionEvent e) {}

	public void widgetSelected(SelectionEvent e) {
		canSave();
		updateLaunchConfigurationDialog();
	}
}
