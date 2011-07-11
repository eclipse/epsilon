/*******************************************************************************
 * Copyright (c) 2011 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.egl.dt.launching.tabs;

import static org.eclipse.epsilon.egl.dt.launching.EglLaunchConfigurationAttributes.DEFAULT_FORMATTERS;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.epsilon.common.dt.util.LogUtil;
import org.eclipse.epsilon.egl.dt.EglPlugin;
import org.eclipse.epsilon.egl.dt.formatter.FormatterLocatorException;
import org.eclipse.epsilon.egl.dt.formatter.FormatterSpecification;
import org.eclipse.epsilon.egl.dt.widgets.ListListener;
import org.eclipse.epsilon.egl.dt.widgets.ListWithControls;
import org.eclipse.epsilon.egl.dt.widgets.ListWithControls.ItemFactory;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;

public class EglGeneratedTextConfigurationTab extends AbstractLaunchConfigurationTab {

	private ListWithControls<FormatterSpecification> defaultFormattersTable;
	
	/// TODO next
	/// - selection of default content type (can be none: "unspecified")
	/// ---- can a content type have a default formatter attached. priority (from lowest to highest): template factory formatters, content type formatters, template-specific formatters
	/// - selection of template factory (defaults to EglFileGeneratingTemplate)
	/// - descriptions for selected formatters / content types / template factory
	/// - online help (see EMF model config dialogue for an example)
	
	@Override
	public void createControl(Composite parent) {
		try {
			final FillLayout parentLayout = new FillLayout();
			parent.setLayout(parentLayout);

			final Composite control = new Composite(parent, SWT.NONE);
			setControl(control);
			control.setLayout(new GridLayout(1, false));
			
			createDefaultFormattersGroup(control);
			
			control.setBounds(0, 0, 300, 300);
			control.layout();
			control.pack();
		
		} catch (FormatterLocatorException e) {
			LogUtil.log(e);
		}
	}

	private void createDefaultFormattersGroup(final Composite control) {
		final Group group = new Group(control, SWT.SHADOW_ETCHED_IN);
		group.setLayout(new GridLayout(2, false));
		group.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		group.setText("Default Formatters: ");
		
		final GridData tableData = new GridData();
		tableData.horizontalAlignment = SWT.FILL;
		tableData.verticalAlignment = SWT.FILL;
		tableData.grabExcessHorizontalSpace = true;
		
		defaultFormattersTable = new ListWithControls<FormatterSpecification>(group, SWT.NONE);
	    defaultFormattersTable.setSize(500, 200);
	    defaultFormattersTable.setLayoutData(tableData);
	    
	    defaultFormattersTable.setLabelProvider(new FormatterSpecificationLabelProvider());
	    defaultFormattersTable.setItemFactory(new ItemFactory<FormatterSpecification>() {

			@Override
			public FormatterSpecification createItem() {
				final FormatterSelectionDialogue dialogue = new FormatterSelectionDialogue(getShell());
				dialogue.setBlockOnOpen(true);
				dialogue.open();
				
				if (dialogue.getReturnCode() == Window.OK){
					return dialogue.getSelectedFormatter();
					
				} else {
					return null;
				}
			}
		});
	    
	    
	    defaultFormattersTable.addModelListener(new ListListener() {

			@Override
			public void changed(ChangeType changeType, Object item, int index) {
				updateLaunchConfigurationDialog();
			}
	    	
	    });
	    
	    defaultFormattersTable.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				updateLaunchConfigurationDialog();
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				updateLaunchConfigurationDialog();
			}
		});
	}

	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {}

	@Override
	public void initializeFrom(ILaunchConfiguration configuration) {
		try {
			@SuppressWarnings("unchecked")
			final Collection<String> defaultFormatterIdentifiers = configuration.getAttribute(DEFAULT_FORMATTERS, Collections.emptyList());
			final Collection<FormatterSpecification> defaultFormatters = FormatterSpecification.findByIdentifiers(defaultFormatterIdentifiers);
			
			defaultFormattersTable.setItems(defaultFormatters);
		
		} catch (CoreException e) {
			LogUtil.log("Error encountered whilst attempting to restore selection of default formatters from launch configuration", e);
		}
		
	}

	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		final List<String> defaultFormatterIdentifiers = new LinkedList<String>();
		
		for (FormatterSpecification spec : defaultFormattersTable.getItems()) {
			defaultFormatterIdentifiers.add(spec.getIdentifier());
		}
		
		configuration.setAttribute(DEFAULT_FORMATTERS, defaultFormatterIdentifiers);
	}

	@Override
	public String getName() {
		return "Generated Text";
	}
	
	@Override
	public Image getImage() {
		return EglPlugin.getDefault().createImage("icons/formatter.png");
	}
}
