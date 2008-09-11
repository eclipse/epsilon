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
package org.eclipse.epsilon.eol.dt.launching.tabs;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.epsilon.common.dt.launching.dialogs.BrowseWorkspaceUtil;
import org.eclipse.epsilon.eol.dt.EolPlugin;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;

public class EolSourceConfigurationTab1 extends AbstractLaunchConfigurationTab implements ModifyListener{
	
	protected Label fileLabel;
	protected Text filePath;
	protected Button browse;
	
	public void createControl(Composite parent) {
		
		FillLayout parentLayout = new FillLayout();
		parent.setLayout(parentLayout);

		Composite control = new Composite(parent, SWT.NONE);
		setControl(control);
		
		GridLayout controlLayout = new GridLayout(3, false);
		control.setLayout(controlLayout);
		
		fileLabel = new Label(control, SWT.NONE);
		
		GridData filePathData = new GridData(GridData.FILL_HORIZONTAL);
		filePath = new Text(control, SWT.BORDER);
		filePath.setLayoutData(filePathData);
		filePath.addModifyListener(this);
		
		Button browse = new Button(control, SWT.NONE);
		browse.setText("Browse Workspace...");
		browse.addListener(SWT.Selection, new SelectSourceListener());
		
		fileLabel.setText("Source: ");
		
		control.layout();
		control.pack();
		
		canSave();
		
	}

	@Override
	public Image getImage() {
		return EolPlugin.getDefault().createImage("icons/eol.gif");
	}

	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
		// TODO Auto-generated method stub
	}

	public void initializeFrom(ILaunchConfiguration configuration) {
		try {
			filePath.setText(configuration.getAttribute(EolPlugin.EOLPROGRAM, ""));
			canSave();
			updateLaunchConfigurationDialog();
		} catch (CoreException e) {
			//Ignore
		}
	}

	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(EolPlugin.EOLPROGRAM, filePath.getText());
	
	}

	public String getName() {
		return "EOL Program";
	}
	
	@Override
	public boolean canSave(){
		
		String workspacePath = ResourcesPlugin.getWorkspace().getRoot().getRawLocation().toPortableString();
		
		java.io.File f = new java.io.File(workspacePath + filePath.getText());
		if (!f.exists()){
			setErrorMessage("Selected file " + filePath.getText() + " does not exist");
			return false;
		}
		else {
			setErrorMessage(null);
			return true;			
		}
	}
	
	class SelectSourceListener implements Listener{

		public void handleEvent(Event event) {
			String selected = 
				BrowseWorkspaceUtil.browseFilePath(getShell(),
				"Select EOL Program source"
				,"EOL Programs in Workspace"
				,"eol"
				,EolPlugin.getDefault().createImage("icons/eol.gif"));
			
			if (selected!=null) filePath.setText(selected);
		}
		
	}

	public void modifyText(ModifyEvent e) {
		canSave();
		updateLaunchConfigurationDialog();
	}
	

}
