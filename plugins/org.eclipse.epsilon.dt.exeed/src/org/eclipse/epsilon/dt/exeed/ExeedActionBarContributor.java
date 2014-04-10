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
package org.eclipse.epsilon.dt.exeed;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.presentation.EcoreActionBarContributor;
import org.eclipse.emf.edit.command.CommandParameter;
import org.eclipse.emf.edit.ui.action.CreateChildAction;
import org.eclipse.epsilon.common.dt.util.ListContentProvider;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.dialogs.ListSelectionDialog;

public class ExeedActionBarContributor extends EcoreActionBarContributor {

	protected ExeedImageTextProvider provider;
	//protected boolean showReferenceNamesInCreateActions = !getPlugin().getPreferenceStore().getBoolean(ExeedPreferencePage.HIDE_REFERENCE_NAMES);
	
	ExeedEditor editor;
	
	protected ConfigureEPackagesAction configureEPackagesAction;
	protected ToggleShowHideEObjectInfoAction toggleShowHideEObjectInfoAction;
	protected ShowHideAdditionalResourcesAction showHideAdditionalResourcesAction;
	protected ShowHideReferenceNamesAction showHideReferenceNamesAction;
	protected ToggleSortPropertiesAction toggleSortPropertiesAction;
	
	protected String getMenuTitle() {
		return "Exeed";
	}
	
	protected ExeedPlugin getPlugin() {
		return ExeedPlugin.getDefault();
	}
	
	@Override
	protected IMenuManager createSubmenuManager() {
		MenuManager menuManager = new MenuManager(getMenuTitle(), "org.eclipse.emf.ecoreMenuID");
		
		configureEPackagesAction = new ConfigureEPackagesAction();
		menuManager.add(configureEPackagesAction);
		
		toggleShowHideEObjectInfoAction = new ToggleShowHideEObjectInfoAction();
		menuManager.add(toggleShowHideEObjectInfoAction);
		
		showHideAdditionalResourcesAction = new ShowHideAdditionalResourcesAction();
		menuManager.add(showHideAdditionalResourcesAction);
		
		showHideReferenceNamesAction = new ShowHideReferenceNamesAction();
		menuManager.add(showHideReferenceNamesAction);
		
		toggleSortPropertiesAction = new ToggleSortPropertiesAction();
		menuManager.add(toggleSortPropertiesAction);
		
		return menuManager;
	}
	
	@Override
	public void setActiveEditor(IEditorPart part) {
		super.setActiveEditor(part);
		ExeedEditor editor = (ExeedEditor) part;
		this.editor = editor;
		if (editor == null) return;
		toggleShowHideEObjectInfoAction.setChecked(editor.getImageTextProvider().isShowStructuralInfo());
		showHideAdditionalResourcesAction.setChecked(editor.isShowAllResources());
		showHideReferenceNamesAction.setChecked(editor.isShowReferenceNamesInCreateActions());
		toggleSortPropertiesAction.setChecked(editor.getPropertySheetPage().isAlphabeticallySorted());
		
	}

	class ToggleShowHideEObjectInfoAction extends Action {
		
		public ToggleShowHideEObjectInfoAction() {
			super();
			setText("Show Structural Info");
			//setChecked(getPlugin().getPreferenceStore().getBoolean(ExeedPreferencePage.SHOW_STRUCTURAL_INFO));
		}
		
		@Override
		public void run() {
			ExeedEditor editor = (ExeedEditor) ExeedActionBarContributor.this.getActiveEditor();
			ExeedImageTextProvider imageTextProvider = editor.getImageTextProvider();
			imageTextProvider.setShowStructuralInfo(!imageTextProvider.isShowStructuralInfo());
			//this.setChecked(!this.isChecked());
			editor.refresh();
		}			
		
	}

	class ToggleSortPropertiesAction extends Action {
		
		public ToggleSortPropertiesAction() {
			super();
			setText("Sort Properties");
			setChecked(true);
			//setChecked(!getPlugin().getPreferenceStore().getBoolean(ExeedPreferencePage.KEEP_PROPERTY_DECLARATION_ORDER));
		}
		
		@Override
		public void run() {
			ExeedEditor editor = (ExeedEditor) ExeedActionBarContributor.this.getActiveEditor();
			editor.getPropertySheetPage().setAlphabeticallySorted(!editor.getPropertySheetPage().isAlphabeticallySorted());
		}			
		
	}
	
	class ShowHideAdditionalResourcesAction extends Action {
		public ShowHideAdditionalResourcesAction() {
			super();
			setText("Show Additional Resources");
			setChecked(true);
			//setChecked(getPlugin().getPreferenceStore().getBoolean(ExeedPreferencePage.SHOW_ALL_RESOURCES));
		}
		
		@Override
		public void run() {
			ExeedEditor editor = (ExeedEditor) ExeedActionBarContributor.this.getActiveEditor();
			editor.setShowAllResources(!editor.isShowAllResources());
			editor.refresh();
		}			
		
	}

	class ShowHideReferenceNamesAction extends Action {
		public ShowHideReferenceNamesAction() {
			super();
			setText("Show Reference Names");
			setChecked(true);
			//setChecked(showReferenceNamesInCreateActions);
		}
		
		@Override
		public void run() {
			ExeedEditor editor = (ExeedEditor) ExeedActionBarContributor.this.getActiveEditor();
			editor.setShowReferenceNamesInCreateActions(!editor.isShowReferenceNamesInCreateActions());
			//this.setChecked(!this.isChecked());
			//showReferenceNamesInCreateActions = !showReferenceNamesInCreateActions;
			
			editor.refresh();
		}			
		
	}
	
	class ConfigureEPackagesAction extends Action {
		@Override
		public String getText() {
			return "Load EPackages...";
		}

		@Override
		public void run() {
			ExeedEditor editor = (ExeedEditor) ExeedActionBarContributor.this.getActiveEditor();
			
			ArrayList registeredPackages = new ArrayList(EPackage.Registry.INSTANCE.keySet());
			Collections.sort(registeredPackages);
			
			ListSelectionDialog dlg = new ListSelectionDialog(
					editor.getSite().getShell(),
					registeredPackages,
					new ListContentProvider(),
					new LabelProvider() {
						 
						@Override
						public Image getImage(Object element) {
							return getPlugin().getImageDescriptor("icons/package.gif").createImage();
						}
						
					},
					"Select registered EPackages"
			);
			
			dlg.setBlockOnOpen(true);
			if (dlg.open() == Window.OK) {
				for (Object o : dlg.getResult()) {
					editor.getItemProviderAdapterFactory().getItemProvider().loadRegisteredEPackage(o.toString());
				}
			}

		}
	}
	
	
	@Override
	protected Collection generateCreateChildActions(Collection descriptors,
			ISelection selection) {
		Collection actions = super.generateCreateChildActions(descriptors,
				selection);
		inspect(actions);
		updateImageDescriptors(descriptors, actions);
		return sortActionCollection(actions);
	}
	
	protected void inspect(Collection actions) {
		Iterator it = actions.iterator();
		while (it.hasNext()) {
			CreateChildAction a = (CreateChildAction) it.next();
		}
	}
	
	@Override
	protected Collection generateCreateSiblingActions(Collection descriptors,
			ISelection selection) {
		Collection actions = super.generateCreateSiblingActions(descriptors,
				selection);
		updateImageDescriptors(descriptors, actions);
		/*
		IAction action = new Action() {
			
		};
		action.setText("Category");
		action.setMenuCreator(new IMenuCreator() {

			public void dispose() {
				// TODO Auto-generated method stub
				
			}

			public Menu getMenu(Control parent) {
				return new Menu(parent);
			}

			public Menu getMenu(Menu parent) {
				return new Menu(parent);
			}
			
		});
		*/
		actions = sortActionCollection(actions);
		//actions.add(action);
		return actions;
	}

	protected void updateImageDescriptors(Collection descriptors,
			Collection actions) {
		if (descriptors == null || actions == null || editor == null)
			return;

		Iterator dit = descriptors.iterator();
		Iterator ait = actions.iterator();

		while (dit.hasNext()) {
			CommandParameter commandParameter = (CommandParameter) dit.next();
			if (ait.hasNext()) {
				Action action = (Action) ait.next();
				// Need the following check in case of XML models
				if (commandParameter.getEValue() != null) {
					EClass eClass = commandParameter.getEValue().eClass();
					action.setImageDescriptor(provider.getEClassImageDescriptor(eClass,
							action.getImageDescriptor()));
					
					if (!editor.isShowReferenceNamesInCreateActions()) {
						action.setText(eClass.getName());
					}
					
				}
			}
		}
	}

	protected List sortActionCollection(Collection col) {

		ArrayList list = new ArrayList(col);
		Collections.sort(list, new Comparator<IAction>() {
			public int compare(IAction a1, IAction a2) {
				return a1.getText().compareTo(a2.getText());
			}
		});

		return list;
	}

	public ExeedImageTextProvider getProvider() {
		return provider;
	}

	public void setProvider(ExeedImageTextProvider provider) {
		this.provider = provider;
	}

}
