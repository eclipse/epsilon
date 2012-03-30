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
package org.eclipse.epsilon.epl.dt.launching.tabs;

import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.epsilon.common.dt.EpsilonPlugin;
import org.eclipse.epsilon.common.dt.launching.AbstractSourceConfigurationTab;
import org.eclipse.epsilon.common.dt.launching.tabs.LabeledControl;
import org.eclipse.epsilon.epl.dt.EplPlugin;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Text;

public class EplSourceConfigurationTab extends AbstractSourceConfigurationTab{
	
	@Override
	public EpsilonPlugin getPlugin() {
		return EplPlugin.getDefault();
	}

	@Override
	public String getImagePath() {
		return "icons/epl.gif";
	}

	@Override
	public String getFileExtension() {
		return "epl";
	}

	@Override
	public String getSelectionTitle() {
		return "Select an EPL Program";
	}

	@Override
	public String getSelectionSubtitle() {
		return "EPL Programs in Workspace";
	}

	public String getLaunchConfigurationKey() {
		return "SOURCE.EPL";
	}
	
	Button repeatWhileMatchesFoundButton;
	
	@Override
	public void createControl(Composite parent) {
		super.createControl(parent);
//		extras.setLayout(new GridLayout(1, true));
//		
//		repeatWhileMatchesFoundButton = new Button(extras, SWT.CHECK);
//		repeatWhileMatchesFoundButton.setSelection(false);
//		repeatWhileMatchesFoundButton.setText("Repeat while matches are found");
//		
//		LabeledControl maxLoopsControl = new LabeledControl(parent, SWT.NONE, "Maximum number of iterations") {
//			
//			@Override
//			protected Control createLabeled(Composite parent) {
//				return new Text(parent, SWT.NONE);
//			}
//		};
		
	}
	
	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		super.performApply(configuration);
	}
	
	@Override
	public void initializeFrom(ILaunchConfiguration configuration) {
		super.initializeFrom(configuration);
	}

}
