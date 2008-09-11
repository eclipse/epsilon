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
package org.eclipse.epsilon.dt.exeed.modelink;

import java.util.ArrayList;

import org.eclipse.core.resources.IFile;
import org.eclipse.epsilon.common.dt.launching.dialogs.BrowseWorkspaceUtil;
import org.eclipse.epsilon.dt.exeed.ExeedPlugin;
import org.eclipse.epsilon.dt.exeed.modelink.ModeLinkInnerEditorInput.Position;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

public class ConfigureLinkedModelsPage extends WizardPage {
	
	private ModeLink modeLink;
	private TableViewer modelsViewer;
	protected Position position;
	
	protected ConfigureLinkedModelsPage(String pageName, ModeLink modeLink, Position position) {
		super(pageName);
		this.modeLink = modeLink;
		this.position = position;
		this.setTitle("Models in the " + position.toString().toLowerCase() + " panel");
		this.setDescription("Specify the models to be displayed in the " + position.toString().toLowerCase() + " panel of the editor");
	}
	
	public void createControl(Composite parent) {
		
		Composite control = new Composite(parent, SWT.FILL);
		setControl(control);
		GridLayout controlLayout = new GridLayout(2, false);
		control.setLayout(controlLayout);

		modelsViewer = new TableViewer(control, SWT.BORDER);

		modelsViewer.setContentProvider(new LinkedModelsContentProvider());
		modelsViewer.setLabelProvider(new ModelLabelProvider());
		modelsViewer.setInput(modeLink.getLinkedModels());
		
		GridData buttonsData = new GridData(GridData.VERTICAL_ALIGN_BEGINNING);

		GridData viewerData = new GridData(GridData.FILL_BOTH);
		modelsViewer.getControl().setLayoutData(viewerData);

		Composite buttons = new Composite(control, SWT.FILL | SWT.TOP);
		buttons.setLayoutData(buttonsData);

		GridLayout buttonsLayout = new GridLayout(1, true);
		buttons.setLayout(buttonsLayout);

		createButton(buttons, "Add...").addListener(SWT.Selection, new AddModelListener());
		//createButton(buttons, "Add2...").addListener(SWT.Selection, new AddRegisteredEPackageListener());
		createButton(buttons, "Remove").addListener(SWT.Selection, new RemoveModelListener());
		
		control.pack();
		control.layout();
		
	}

	
	private Button createButton(Composite parent, String text) {
		Button button = new Button(parent, SWT.NONE);
		button.setText(text);
		button.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		return button;
	}
	/*
	class AddRegisteredEPackageListener implements Listener{

		public void handleEvent(Event event) {
			
			ElementListSelectionDialog dialog = new ElementListSelectionDialog( 
					Display.getDefault().getActiveShell(), 
					new LabelProvider() {

						@Override
						public String getText(Object element) {
							return ((EPackage) element).getNsURI();
						}
						
						
						
					});
			
			dialog.setMessage("Select an EPackage");
			dialog.setTitle("Registered EPackages");
			
			List<EPackage> ePackages = new ArrayList<EPackage>();
			
			for (Object value : EPackage.Registry.INSTANCE.values()) {
				if (value instanceof EPackage) {
					ePackages.add((EPackage) value);
				}
			}
			
			dialog.setElements(ePackages.toArray());
			
			if (dialog.open() == Window.OK) {
				if (dialog.getResult().length > 0) {
					EPackage ePackage = (EPackage) dialog.getResult()[0];
					modeLink.getLinkedModels().add(new LinkedModel("virtual/" + ePackage.eResource().getURI().toFileString() + ".registry", position.toString()));
				}
			}
		
			modelsViewer.refresh();
		}
	}
*/
	class AddModelListener implements Listener{

		public void handleEvent(Event event) {
			
			IFile selection = BrowseWorkspaceUtil.browseFile(ConfigureLinkedModelsPage.this.getShell(), "Select a model", "Select a model", "", null);
			
			//for (int i=0;i<selection.length;i++) {
				//if (selection[i] instanceof IFile) {
					modeLink.getLinkedModels().add(new LinkedModel(selection.getFullPath().toOSString(), position.toString()));
				//}
			//}
			modelsViewer.refresh();
		}
	}


	class RemoveModelListener implements Listener{

		public void handleEvent(Event event) {
			IStructuredSelection selection = (IStructuredSelection) modelsViewer.getSelection();
			if (selection.getFirstElement() == null) return;
			modeLink.getLinkedModels().remove(selection.getFirstElement());
			modelsViewer.refresh(true);
		}
		
	}

	class ModelLabelProvider implements ILabelProvider{
		
		Image emfModelImage = ExeedPlugin.getDefault().getImageDescriptor("icons/emfmodel.gif").createImage();
		
		public Image getImage(Object element) {
			return emfModelImage;
		}

		public String getText(Object element) {
			return ((LinkedModel) element).getPath();
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
	
	class LinkedModelsContentProvider implements IStructuredContentProvider {

		public Object[] getElements(Object inputElement) {
			ArrayList filtered = new ArrayList();
			for (LinkedModel m : modeLink.getLinkedModels()) {
				if (m.getPosition() == position) {
					filtered.add(m);
				}
			}
			return filtered.toArray();
		}

		public void dispose() {
			
		}

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			
		}
		
	}
	
}
