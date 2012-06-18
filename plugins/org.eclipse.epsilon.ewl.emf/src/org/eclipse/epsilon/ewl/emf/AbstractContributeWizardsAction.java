/*******************************************************************************
 * Copyright (c) 2008-2012 The University of York, Antonio García-Domínguez.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 *     Antonio García-Domínguez - recreate the menu on every call to getMenu
 *                                (required in Eclipse 4.x), clean up
 ******************************************************************************/
package org.eclipse.epsilon.ewl.emf;

import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.epsilon.common.dt.console.EpsilonConsole;
import org.eclipse.epsilon.common.dt.util.EclipseUtil;
import org.eclipse.epsilon.common.dt.util.LogUtil;
import org.eclipse.epsilon.emc.emf.EmfPrettyPrinter;
import org.eclipse.epsilon.emc.emf.EmfUtil;
import org.eclipse.epsilon.emc.emf.InMemoryEmfModel;
import org.eclipse.epsilon.eol.EolSystem;
import org.eclipse.epsilon.eol.dt.ExtensionPointToolNativeTypeDelegate;
import org.eclipse.epsilon.eol.dt.userinput.JFaceUserInput;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.ewl.EwlModule;
import org.eclipse.epsilon.ewl.EwlWizardInstance;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuCreator;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MenuEvent;
import org.eclipse.swt.events.MenuListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

public abstract class AbstractContributeWizardsAction implements IObjectActionDelegate, IMenuCreator, MenuListener {
	protected ISelection selection;
	protected IWorkbenchPart targetPart;
	protected InMemoryEmfModel model;
	
	/**
	 * Constructor for ContributeWizardsAction.
	 */
	public AbstractContributeWizardsAction() {
		super();
	}

	/**
	 * @see IObjectActionDelegate#setActivePart(IAction, IWorkbenchPart)
	 */
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		this.targetPart = targetPart;
	}

	/**
	 * @see IActionDelegate#run(IAction)
	 */
	public void run(IAction action) {
		// do nothing
	}

	/**
	 * @see IActionDelegate#selectionChanged(IAction, ISelection)
	 */
	public void selectionChanged(IAction action, ISelection selection) {
		this.selection = selection;
		action.setMenuCreator(this);
	}

	@Override
	public void dispose() {
		if (model != null) {
			model.dispose();
		}
	}

	@Override
	public Menu getMenu(Menu parent) {
		Menu wizardsMenu = new Menu(parent);
		wizardsMenu.addMenuListener(this);
		return wizardsMenu;
	}

	@Override
	public Menu getMenu(Control parent) {
		Menu wizardsMenu = new Menu(parent);
		wizardsMenu.addMenuListener(this);
		return wizardsMenu;
	}

	public void menuHidden(MenuEvent e) {
		// not interested in this event
	}

	public void menuShown(MenuEvent e) {
		populateWizardsMenu((Menu)e.widget);
	}

	protected abstract EObject getEObject(Object selected);

	protected abstract EditingDomain getEditingDomain();

	protected abstract WorkbenchPartRefresher getWorkbenchPartRefresher();

	protected void execute(Command command) {
		EditingDomain editingDomain = getEditingDomain();		
		if (editingDomain != null) {
			editingDomain.getCommandStack().execute(command);
		}
		else {
			command.execute();
		}
	}

	protected List<URI> getEwlURIsForEObjects(Collection<EObject> eObjects) {
		Set<String> eObjectURIs = new TreeSet<String>(); 
		for (EObject eObject : eObjects) {
			String eObjectNsURI = EmfUtil.getTopEPackage(eObject).getNsURI();
			eObjectURIs.add(eObjectNsURI);
		}
	
		List<URI> wizardURIs = new ArrayList<URI>();
		for (IConfigurationElement configurationElement : getConfigurationElements()) {
			String namespaceURI = configurationElement.getAttribute("namespaceURI");
			if (namespaceURI.equalsIgnoreCase("*") || eObjectURIs.contains(namespaceURI)) {
				String pluginId = configurationElement.getDeclaringExtension().getNamespaceIdentifier();
				try {
					String path = configurationElement.getAttribute("file");
					wizardURIs.add(FileLocator.find(Platform.getBundle(pluginId), new Path(path), null).toURI());
				} catch (Exception e) {
					LogUtil.log(e);
				}
			}
		}
		for (WizardsExtensionPreference preference : WizardsExtensionPreference.getPreferences()) {
			String namespaceURI = preference.getNamespaceURI();
			if (namespaceURI.equalsIgnoreCase("*") || eObjectURIs.contains(namespaceURI)) {
				wizardURIs.add(new File(EclipseUtil.getWorkspaceFileAbsolutePath(preference.getWizards())).toURI());
			}
		}
		
		return wizardURIs;
	}

	private void populateWizardsMenu(Menu wizardsMenu) {
		// Clean the menu
		for (MenuItem item : wizardsMenu.getItems()) {
			item.dispose();
		}
		
		List<EObject> eObjects = new ArrayList<EObject>();
		List<EwlWizardInstance> applicableWizards = new ArrayList<EwlWizardInstance>();

		if ((selection instanceof IStructuredSelection)) {
			IStructuredSelection structuredSelection = (IStructuredSelection) selection;
			Iterator<?> it = structuredSelection.iterator();
			
			while (it.hasNext()) {
				Object next = it.next();
				
				EObject eObject = getEObject(next);
				if (eObject != null) {
					eObjects.add(eObject);
				}
			}

			final List<URI> uris = getEwlURIsForEObjects(eObjects);
			final Resource resource = eObjects.get(0).eResource();
			final List<EPackage> ePackages = loadExtraPackages(resource);
			if (!eObjects.isEmpty()) {
				ePackages.add(EmfUtil.getTopEPackage(eObjects.get(0)));
			}
			model = new InMemoryEmfModel("Model", resource, ePackages);

			for (URI uri : uris) {
				EwlModule module = new EwlModule();
				
				try {
					module.parse(uri);
					module.getContext().setErrorStream(EpsilonConsole.getInstance().getErrorStream());
					module.getContext().setOutputStream(EpsilonConsole.getInstance().getDebugStream());
					module.getContext().getNativeTypeDelegates().add(new ExtensionPointToolNativeTypeDelegate());
					module.getContext().setUserInput(new JFaceUserInput(module.getContext().getPrettyPrinterManager()));
					module.getContext().getFrameStack().put(Variable.createReadOnlyVariable("editor", targetPart));
					module.getContext().getPrettyPrinterManager().addPrettyPrinter(new EmfPrettyPrinter());
					EolSystem system = new EolSystem();
					system.setContext(module.getContext());
					module.getContext().getFrameStack().put(Variable.createReadOnlyVariable("System", system));
				} catch (Exception e) {
					LogUtil.log(e);
					continue;
				}
				
				module.getContext().getModelRepository().addModel(model);
				
				Object self = null;
				if (eObjects.size() > 1) {
					self = eObjects;
				}
				else if (eObjects.size() == 1){
					self = eObjects.get(0);
				}
				
				try {
					applicableWizards.addAll(module.getWizardsFor(self));
				} catch (EolRuntimeException e) {
					EpsilonConsole.getInstance().getErrorStream().println(e.toString());
				}
			}
		}
		
		for (final EwlWizardInstance wizard : applicableWizards) {
			final MenuItem wizardItem = new MenuItem(wizardsMenu, SWT.NONE);
			try {
				wizardItem.setText(wizard.getTitle());
			} catch (EolRuntimeException e) {
				wizardItem.setText("<error> " + wizard.getWizard().getName());
				LogUtil.log(e);
			}
			wizardItem.addSelectionListener(new SelectionListener() {
				public void widgetDefaultSelected(SelectionEvent e) {
				
				}

				public void widgetSelected(SelectionEvent e) {
						
						WorkbenchPartRefresher refresher = getWorkbenchPartRefresher();
						refresher.setPart(targetPart);
						
						ExecuteWizardInstanceCommand command = 
							new ExecuteWizardInstanceCommand(wizard, model, refresher);
						
						execute(command);
				}
			});
		}
	}

	private List<EPackage> loadExtraPackages(Resource resource) {
		final List<EPackage> ePackages = new ArrayList<EPackage>();
		for (IConfigurationElement elem : this.getConfigurationElements()) {
			final String extraPackages = elem.getAttribute("extraPackages");
			if (extraPackages == null) continue;

			for (String packageURI : extraPackages.split(",")) {
				final EPackage ePackage = EPackage.Registry.INSTANCE.getEPackage(packageURI);
				if (ePackage != null) {
					ePackages.add(ePackage);
				}
			}
		}
		return ePackages;
	}
	
	private IConfigurationElement[] getConfigurationElements() {
		return Platform.getExtensionRegistry().getConfigurationElementsFor("org.eclipse.epsilon.ewl.emf.wizards");
	}
}
