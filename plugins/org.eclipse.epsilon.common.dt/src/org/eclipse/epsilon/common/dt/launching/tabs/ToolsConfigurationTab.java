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
package org.eclipse.epsilon.common.dt.launching.tabs;

import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.epsilon.common.dt.EpsilonCommonsPlugin;
import org.eclipse.epsilon.common.dt.launching.dialogs.ToolConfigurationDialog;
import org.eclipse.epsilon.common.dt.util.StringList;
import org.eclipse.epsilon.common.util.StringProperties;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

public class ToolsConfigurationTab extends AbstractLaunchConfigurationTab{
	
	private List<String> tools = new StringList();
	private TableViewer toolsViewer;

	public void createControl(Composite parent) {
		
		FillLayout parentLayout = new FillLayout();
		parent.setLayout(parentLayout);

		Composite control = new Composite(parent, SWT.FILL);
		setControl(control);
		GridLayout controlLayout = new GridLayout(2, false);
		control.setLayout(controlLayout);

		toolsViewer = new TableViewer(control, SWT.BORDER);

		toolsViewer.setContentProvider(new ListContentProvider());
		toolsViewer.setLabelProvider(new ModelLabelProvider());
		toolsViewer.setInput(tools);
		
		GridData buttonsData = new GridData(GridData.VERTICAL_ALIGN_BEGINNING);

		GridData viewerData = new GridData(GridData.FILL_BOTH);
		toolsViewer.getControl().setLayoutData(viewerData);

		Composite buttons = new Composite(control, SWT.FILL | SWT.TOP);
		buttons.setLayoutData(buttonsData);

		GridLayout buttonsLayout = new GridLayout(1, true);
		buttons.setLayout(buttonsLayout);

		createButton(buttons, "Add...").addListener(SWT.Selection, new AddModelListener());
		createButton(buttons, "Edit...").addListener(SWT.Selection, new EditModelListener());
		createButton(buttons, "Remove").addListener(SWT.Selection, new RemoveModelListener());
		//createButton(buttons, "Up");
		//createButton(buttons, "Down");
		//createButton(buttons, "Test");
		
		control.pack();
		control.layout();
		
		canSave();
	}

	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
		// TODO Auto-generated method stub
	}

	public void initializeFrom(ILaunchConfiguration configuration) {
		try {
			tools = new StringList(configuration.getAttribute("tools", new StringList()));
			toolsViewer.setInput(tools);
			toolsViewer.refresh(true);
			canSave();
			updateLaunchConfigurationDialog();
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}

	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute("tools", tools);
	}

	public String getName() {
		return "Tools";
	}
	
	@Override
	public Image getImage() {
		return EpsilonCommonsPlugin.getDefault().createImage("icons/tool.gif");
	}
	
	@Override
	public boolean canSave(){
		setErrorMessage(null);
		return true;
	}
	
	private Button createButton(Composite parent, String text) {
		Button button = new Button(parent, SWT.NONE);
		button.setText(text);
		button.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		return button;
	}
	
	class AddModelListener implements Listener{

		public void handleEvent(Event event) {
			
			try {
				ToolConfigurationDialog toolConfigurationDialog = new ToolConfigurationDialog(ToolsConfigurationTab.this.getShell());
				toolConfigurationDialog.setBlockOnOpen(true);
				toolConfigurationDialog.open();
				if (toolConfigurationDialog.getReturnCode() == Window.OK){
					tools.add(toolConfigurationDialog.getProperties().toString());
					toolsViewer.refresh(true);
					canSave();
					updateLaunchConfigurationDialog();
				}
			} catch (Exception e) {
				//PDE.logException(e);
				e.printStackTrace();
			}

		}
	}

	class EditModelListener implements Listener{

		public void handleEvent(Event event) {
			
			IStructuredSelection selection = (IStructuredSelection) toolsViewer.getSelection();
			if (selection.getFirstElement() == null) return;
			
			StringProperties properties = new StringProperties();
			properties.load(selection.getFirstElement().toString());
			
			ToolConfigurationDialog dialog = new ToolConfigurationDialog(ToolsConfigurationTab.this.getShell());
			dialog.setBlockOnOpen(true);
			
			dialog.setProperties(properties);
			dialog.open();
			if (dialog.getReturnCode() == Window.OK){
				int index = tools.indexOf(selection.getFirstElement());
				tools.add(index, dialog.getProperties().toString());
				tools.remove(index + 1);
				toolsViewer.refresh(true);
				canSave();
				updateLaunchConfigurationDialog();				
			}
		}
	}	
	
	class RemoveModelListener implements Listener{

		public void handleEvent(Event event) {
			IStructuredSelection selection = (IStructuredSelection) toolsViewer.getSelection();
			if (selection.getFirstElement() == null) return;
			int index = tools.indexOf(selection.getFirstElement());
			tools.remove(index);
			toolsViewer.refresh(true);
			canSave();
			updateLaunchConfigurationDialog();
		}
		
	}
	
	class ListContentProvider implements IStructuredContentProvider{

		public Object[] getElements(Object inputElement) {
			List<?> list = (List<?>) inputElement;
			return list.toArray();
		}

		public void dispose() {
			// TODO Auto-generated method stub
		}

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			
		}
		
	}
	
	class ModelLabelProvider implements ILabelProvider{

		public Image getImage(Object element) {
			return EpsilonCommonsPlugin.getDefault().createImage("icons/tool.gif");
		}

		public String getText(Object element) {
			StringProperties properties = new StringProperties();
			properties.load(element.toString());
			return properties.getProperty("name") + " (" + properties.getProperty("class") + ")";
		}

		public void addListener(ILabelProviderListener listener) {
			// TODO Auto-generated method stub
		}

		public void dispose() {
			// TODO Auto-generated method stub
			
		}

		public boolean isLabelProperty(Object element, String property) {
			// TODO Auto-generated method stub
			return false;
		}

		public void removeListener(ILabelProviderListener listener) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
}
