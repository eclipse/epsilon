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
package org.eclipse.epsilon.concordance.ui;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.epsilon.common.dt.util.ListContentProvider;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

public class ModelExtensionsPreferencePage extends PreferencePage implements
		IWorkbenchPreferencePage {

	private ArrayList<String> extensions = null;
	private TableViewer extensionsViewer;

	public ModelExtensionsPreferencePage() {
	
	}

	public ModelExtensionsPreferencePage(String title) {
		super(title);
	}

	public ModelExtensionsPreferencePage(String title, ImageDescriptor image) {
		super(title, image);
	}

	@Override
	protected Control createContents(Composite parent) {
		extensions = ModelExtensionsManager.getInstance().getExtensions();
		
		Composite control = new Composite(parent, SWT.FILL);
		GridLayout controlLayout = new GridLayout(2, false);
		control.setLayout(controlLayout);

		extensionsViewer = new TableViewer(control, SWT.BORDER);

		extensionsViewer.setContentProvider(new ListContentProvider());
		extensionsViewer.setLabelProvider(new MetamodelLabelProvider());
		extensionsViewer.setInput(extensions);
		
		GridData buttonsData = new GridData(GridData.VERTICAL_ALIGN_BEGINNING);

		GridData viewerData = new GridData(GridData.FILL_BOTH);
		extensionsViewer.getControl().setLayoutData(viewerData);

		Composite buttons = new Composite(control, SWT.FILL | SWT.TOP);
		buttons.setLayoutData(buttonsData);

		GridLayout buttonsLayout = new GridLayout(1, true);
		buttons.setLayout(buttonsLayout);

		createButton(buttons, "Add").addListener(SWT.Selection, new AddExtensionListener());
		createButton(buttons, "Remove").addListener(SWT.Selection, new RemoveMetamodelListener());
		
		control.pack();
		control.layout();
		
		return control;
	}
	
	class MetamodelLabelProvider implements ILabelProvider {
		
		//protected Image registerImage = EmfUtilPlugin.getImageDescriptor("icons/register.gif").createImage();
		
		public Image getImage(Object element) {
			//return registerImage;
			return null;
		}

		public String getText(Object element) {
			return element.toString();
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
	
	class AddExtensionListener implements Listener{

		public void handleEvent(Event event) {
			InputDialog dialog = new InputDialog(Display.getDefault().getActiveShell(),"Add extension","Add a model extension (e.g. ecore, uml, xmi)","",null);
			if (dialog.open() == Window.OK) {
				extensions.add(dialog.getValue());
			}
			extensionsViewer.refresh(true);
		}
		
	}
	
	class RemoveMetamodelListener implements Listener{

		public void handleEvent(Event event) {
			IStructuredSelection selection = (IStructuredSelection) extensionsViewer.getSelection();
			if (selection.getFirstElement() == null) return;
			int index = extensions.indexOf(selection.getFirstElement());
			extensions.remove(index);
			extensionsViewer.refresh(true);
		}
		
	}
	
	private Button createButton(Composite parent, String text) {
		Button button = new Button(parent, SWT.NONE);
		button.setText(text);
		button.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		return button;
	}

	public void init(IWorkbench workbench) {
		
	}
	
	@Override
	protected void performDefaults() {
		super.performDefaults();
		extensions.clear();
		extensions.addAll(ModelExtensionsManager.getInstance().getExtensions());
		extensionsViewer.refresh();
	}

	@Override
	public boolean performOk() {
		ModelExtensionsManager.getInstance().setExtensions(extensions);
		return super.performOk();
	}

}
