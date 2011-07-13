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
import static org.eclipse.epsilon.egl.dt.launching.EglLaunchConfigurationAttributes.TEMPLATE_FACTORY_TYPE;

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
import org.eclipse.epsilon.egl.dt.extensions.formatter.FormatterLocatorException;
import org.eclipse.epsilon.egl.dt.extensions.formatter.FormatterSpecification;
import org.eclipse.epsilon.egl.dt.extensions.templateFactoryType.TemplateFactoryTypeSpecification;
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
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.ui.PlatformUI;

public class EglGeneratedTextConfigurationTab extends AbstractLaunchConfigurationTab {

	private ListWithControls<FormatterSpecification> defaultFormattersTable;
	private Combo templateFactoryTypeCombo;
		
	@Override
	public void createControl(Composite parent) {
		try {
			final FillLayout parentLayout = new FillLayout();
			parent.setLayout(parentLayout);

			final Composite control = new Composite(parent, SWT.NONE);
			setControl(control);
			control.setLayout(new GridLayout(1, false));
			
			PlatformUI.getWorkbench().getHelpSystem().setHelp(control, "org.eclipse.epsilon.help.egl_generated_text_tab");
			
			createDefaultFormattersGroup(control);
			createTemplateFactoryTypeGroup(control);
			
			control.setBounds(0, 0, 300, 300);
			control.layout();
			control.pack();
			
		    defaultFormattersTable.setFocus();
		
		} catch (FormatterLocatorException e) {
			LogUtil.log(e);
		}
	}

	private void createDefaultFormattersGroup(Composite control) {
		final Group group = createGroup(control, "Default Formatters: ");
		
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
	
	private void createTemplateFactoryTypeGroup(Composite control) {
		final Group group = createGroup(control, "Type of Template Factory: ");
		
		final Collection<TemplateFactoryTypeSpecification> specs = TemplateFactoryTypeSpecification.loadAllFromExtensionPoints();
		final Collection<String> templateFactoryTypeNames = new LinkedList<String>();
		
		for (TemplateFactoryTypeSpecification spec : specs) {
			templateFactoryTypeNames.add(spec.getName());
		}
		
		templateFactoryTypeCombo = new Combo(group, SWT.READ_ONLY);
		templateFactoryTypeCombo.setItems(templateFactoryTypeNames.toArray(new String[]{}));
		templateFactoryTypeCombo.select(0);
		
		templateFactoryTypeCombo.addSelectionListener(new SelectionListener() {
			
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
	
	private Group createGroup(Composite control, final String name) {
		final Group group = new Group(control, SWT.SHADOW_ETCHED_IN);
		group.setLayout(new GridLayout(2, false));
		group.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		group.setText(name);
		return group;
	}

	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {}

	@Override
	public void initializeFrom(ILaunchConfiguration configuration) {
		try {
			@SuppressWarnings("unchecked")
			final Collection<String> defaultFormatterIdentifiers = configuration.getAttribute(DEFAULT_FORMATTERS, Collections.emptyList());
			defaultFormattersTable.setItems(FormatterSpecification.findByIdentifiers(defaultFormatterIdentifiers));
			
			final String templateFactoryTypeIdentifier = configuration.getAttribute(TEMPLATE_FACTORY_TYPE, TemplateFactoryTypeSpecification.getDefault());
			templateFactoryTypeCombo.select(TemplateFactoryTypeSpecification.indexOf(templateFactoryTypeIdentifier));
			
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
		
		final String indexOfSelectedTemplateFactoryType = TemplateFactoryTypeSpecification.findByIndex(templateFactoryTypeCombo.getSelectionIndex()).getIdentifier();
		configuration.setAttribute(TEMPLATE_FACTORY_TYPE, indexOfSelectedTemplateFactoryType);
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
