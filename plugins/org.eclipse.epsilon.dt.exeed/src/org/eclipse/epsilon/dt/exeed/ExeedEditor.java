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

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EventObject;
import java.util.HashMap;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.command.CommandStackListener;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.presentation.EcoreEditor;
import org.eclipse.emf.ecore.presentation.EcoreEditorPlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.BinaryResourceImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.GenericXMLResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceSetItemProvider;
import org.eclipse.emf.edit.ui.dnd.LocalTransfer;
import org.eclipse.emf.edit.ui.dnd.ViewerDragAdapter;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.epsilon.common.dt.util.LogUtil;
import org.eclipse.epsilon.emc.emf.InMemoryEmfModel;
import org.eclipse.epsilon.emf.dt.EmfRegistryManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.actions.WorkspaceModifyOperation;

public class ExeedEditor extends EcoreEditor {

	protected ExeedImageTextProvider imageTextProvider = null;
	protected boolean showAllResources = getPlugin().getPreferenceStore().getBoolean(ExeedPreferencePage.SHOW_ALL_RESOURCES);
	protected boolean showReferenceNamesInCreateActions = !getPlugin().getPreferenceStore().getBoolean(ExeedPreferencePage.HIDE_REFERENCE_NAMES);;
	protected boolean sortProperties = !getPlugin().getPreferenceStore().getBoolean(ExeedPreferencePage.KEEP_PROPERTY_DECLARATION_ORDER);
	
	ExeedItemProviderAdapterFactory exeedItemProviderAdapterFactory = null;
	
	
	
	@Override
	public Diagnostic analyzeResourceProblems(Resource resource,
			Exception exception) {
		
		//if (resource == null) {
			return Diagnostic.OK_INSTANCE;
		//}
		//else {
		//	return super.analyzeResourceProblems(resource, exception);
		//}
	}
	
	protected ExeedPlugin getPlugin() {
		return ExeedPlugin.getDefault();
	}
	
	public ExeedItemProviderAdapterFactory getItemProviderAdapterFactory() {
		return exeedItemProviderAdapterFactory;
	}
	
	public void refresh() {
		
		currentViewer.refresh();
	}
	
	static HashMap resourceMap = new HashMap();
	
	class IDXMIResourceFactoryImpl extends XMIResourceFactoryImpl {

		@Override
		public Resource createResource(URI arg0) {
			
			IDXMIResource resource = new IDXMIResource(arg0);
			
			resource.setTrackingModification(true);
			
			Adapter adapter = new Adapter() {

				public Notifier getTarget() {
					return null;
				}

				public boolean isAdapterForType(Object type) {
					return false;
				}

				public void notifyChanged(Notification notification) {
					if (ExeedEditor.this.getViewer() != null) {
						Display.getDefault().syncExec(new Runnable() {
							public void run() {
								ExeedEditor.this.getViewer().refresh();
							}
						});
					}
				}

				public void setTarget(Notifier newTarget) {
					
				}
				
			};
			
			resource.eAdapters().add(adapter);
			
			return resource;
			/*
			if (resourceMap.containsKey(arg0.toString())) {
				return (Resource) resourceMap.get(arg0.toString());
			}
			else {
				Resource resource = new IDXMIResource(arg0);
				resource.setTrackingModification(false);
				resourceMap.put(arg0.toString(), resource);
				return resource;
			}*/
		}
		
	}
	
	class IDXMIResource extends XMIResourceImpl {

		public IDXMIResource(URI uri) {
			super(uri);
		}
		
		@Override
		protected boolean useUUIDs() {
			return true;
		}
		
	}
	
	
	public ExeedEditor() {
		super();

		// EcoreItemProviderAdapterFactory a;
		// Create an adapter factory that yields item providers.

		List factories = new ArrayList();
		//factories.add(new ResourceItemProviderAdapterFactory());
		
		factories.add(new ResourceItemProviderAdapterFactory() {

			@Override
			public Adapter createResourceSetAdapter() {
				// TODO Auto-generated method stub
				//return super.createResourceSetAdapter();
				return new ResourceSetItemProvider(this) {
					
					  @Override
					public Collection getChildren(Object object)
					  {
					    ResourceSet resourceSet = (ResourceSet)object;
					    if (showAllResources) {
					    	return resourceSet.getResources();
					    }
					    else {
					    	 ArrayList list = new ArrayList();
							    list.add(resourceSet.getResources().get(0));
							    return list;
					    }
					  }
				};
			}
			
		});
		
		//factories.add(new EcoreItemProviderAdapterFactory());
		//factories.add(new ReflectiveItemProviderAdapterFactory());
		exeedItemProviderAdapterFactory = new ExeedItemProviderAdapterFactory(getPlugin());
		factories.add(exeedItemProviderAdapterFactory);
		factories.add(new ReflectiveItemProviderAdapterFactory());
		
		adapterFactory = new ComposedAdapterFactory(factories);

		// Create the command stack that will notify this editor as commands are
		// executed.
		//
		BasicCommandStack commandStack = new BasicCommandStack();

		// Add a listener to set the most recent command's affected objects to
		// be the selection of the viewer with focus.
		// 
		commandStack.addCommandStackListener(new CommandStackListener() {
			public void commandStackChanged(final EventObject event) {
				getContainer().getDisplay().asyncExec(new Runnable() {
					public void run() {
						firePropertyChange(IEditorPart.PROP_DIRTY);

						// Try to select the affected objects.
						//
						Command mostRecentCommand = ((CommandStack) event
								.getSource()).getMostRecentCommand();
						if (mostRecentCommand != null) {
							setSelectionToViewer(mostRecentCommand
									.getAffectedObjects());
						}
						if (propertySheetPage != null && propertySheetPage.getControl() != null && 
								!propertySheetPage.getControl().isDisposed()) {
							propertySheetPage.refresh();
						}
					}
				});
			}
		});

		// Create the editing domain with a special command stack.
		editingDomain = new AdapterFactoryEditingDomain(adapterFactory,
				commandStack, new HashMap());
		
		editingDomain.getResourceSet().getResourceFactoryRegistry().
		getExtensionToFactoryMap().put("xml", new GenericXMLResourceFactoryImpl());
		
		editingDomain.getResourceSet().getResourceFactoryRegistry().
		getExtensionToFactoryMap().put("*", new IDXMIResourceFactoryImpl());
		
		editingDomain.getResourceSet().getResourceFactoryRegistry().
		getExtensionToFactoryMap().put("bim", new ResourceFactoryImpl() {
			@Override
			public Resource createResource(URI uri) {
				// TODO Auto-generated method stub
				return new BinaryResourceImpl(uri);
			}
		});
		
		
		editingDomain.getResourceSet().getResourceFactoryRegistry().
		getExtensionToFactoryMap().put("registered", new Resource.Factory () {

			public Resource createResource(URI uri) {
				IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(uri.toString().replace("platform:/resource/", "")));
				String nsUri = "";
				try {
					InputStream is = file.getContents();
					InputStreamReader r = new InputStreamReader(is);
					BufferedReader br = new BufferedReader(r);
					nsUri = br.readLine();
				}
				catch (Exception e) {
					LogUtil.log(e);
				}
				
				//return new WrappedResource(EPackage.Registry.INSTANCE.getEPackage(nsUri).eResource());
				return EPackage.Registry.INSTANCE.getEPackage(nsUri).eResource();
				
			}
			
		});
		
		
		//exeedItemProviderAdapterFactory.getItemProvider().loadRegisteredEPackage("ExtM2");
		
	}

	@Override
	public ExeedPropertySheetPage getPropertySheetPage()
	  {
	    if (propertySheetPage == null)
	    {
	      propertySheetPage =
	        new ExeedPropertySheetPage(editingDomain, ExeedEditor.this, getPlugin());
	        
	      propertySheetPage.setPropertySourceProvider(new AdapterFactoryContentProvider(adapterFactory));
	    
	    }

	    return (ExeedPropertySheetPage) propertySheetPage;
	  }
	  
	  /**
	   * This is for implementing {@link IEditorPart} and simply saves the model file.
	   * <!-- begin-user-doc -->
	   * <!-- end-user-doc -->
	   * @generated
	   */
	  @Override
	public void doSave(IProgressMonitor progressMonitor)
	  {
	    // Do the work within an operation because this is a long running activity that modifies the workbench.
	    //
	    WorkspaceModifyOperation operation =
	      new WorkspaceModifyOperation()
	      {
	        // This is the method that gets invoked when the operation runs.
	        //
	        @Override
			public void execute(IProgressMonitor monitor)
	        {
	          // Save the resources to the file system.
	          //
	          //boolean first = true;
	          //for (Iterator i = editingDomain.getResourceSet().getResources().iterator(); i.hasNext(); )
	          //{
	        	//Resource resource = (Resource)i.next();
	        	Resource resource = editingDomain.getResourceSet().getResources().iterator().next();
	            //if ((first || !resource.getContents().isEmpty() || isPersisted(resource)) && !editingDomain.isReadOnly(resource))
	            //{
	              try
	              {
	                savedResources.add(resource);
	                resource.save(Collections.EMPTY_MAP);
	              }
	              catch (Exception exception)
	              {
	                resourceToDiagnosticMap.put(resource, analyzeResourceProblems(resource, exception));
	              }
	              //first = false;
	            //}
	          //}
	        }
	      };
	    
	    
	    updateProblemIndication = false;
	    try
	    {
	      // This runs the options, and shows progress.
	      //
	      new ProgressMonitorDialog(getSite().getShell()).run(true, false, operation);

	      // Refresh the necessary state.
	      //
	      ((BasicCommandStack)editingDomain.getCommandStack()).saveIsDone();
	      firePropertyChange(IEditorPart.PROP_DIRTY);
	    }
	    catch (Exception exception)
	    {
	      // Something went wrong that shouldn't.
	      //
	      EcoreEditorPlugin.INSTANCE.log(exception);
	    }
	    updateProblemIndication = true;
	    updateProblemIndication();
	    
	  }

	@Override
	protected void createContextMenuForGen(StructuredViewer viewer) {
		MenuManager contextMenu = new MenuManager("#PopUp");
		contextMenu.add(new Separator("additions"));
		contextMenu.setRemoveAllWhenShown(true);
		contextMenu.addMenuListener(this);
		Menu menu = contextMenu.createContextMenu(viewer.getControl());
		viewer.getControl().setMenu(menu);
		getSite().registerContextMenu(contextMenu, viewer);

		int dndOperations = DND.DROP_COPY | DND.DROP_MOVE | DND.DROP_LINK;
		Transfer[] transfers = new Transfer[] { LocalTransfer.getInstance() };
		viewer.addDragSupport(dndOperations, transfers, new ViewerDragAdapter(
				viewer));
		viewer.addDropSupport(dndOperations, transfers,
				new ExeedEditingDomainViewerDropAdapter(editingDomain, viewer, getPlugin()));
	}

	protected void registerCustomMetamodels() {
		
	}
	
	@Override
	public void createPages() {
		
		EmfRegistryManager.getInstance();
		registerCustomMetamodels();
		
		//if (1>0) throw new IllegalStateException("See who comes first");
		
		super.createPages();
		
		//EcoreUtil.resolveAll(this.getEditingDomain().getResourceSet());
		
		TreeViewer viewer = (TreeViewer) getViewer();
		
		viewer.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				event.getSource();
			}
			
		});
		
		Resource mainResource = this.getEditingDomain().getResourceSet().getResources().get(0);
		
		InMemoryEmfModel model = new InMemoryEmfModel(mainResource);
		model.setCachingEnabled(false);
		
		/*
		ListIterator li = this.getEditingDomain().getResourceSet().getResources().listIterator();
		List<InMemoryEmfModel> models = new ArrayList();
		
		EcoreActionBarContributor.ExtendedLoadResourceAction a;
		
		while (li.hasNext()) {
			Resource modelImpl = (Resource) li.next();
			Resource metamodelImpl = ((EObject) modelImpl.getAllContents().next())
			.eClass().eResource();
			InMemoryEmfModel model = new InMemoryEmfModel(modelImpl, metamodelImpl);
			Iterator it = metamodelImpl.getAllContents();
			while (it.hasNext()) {
				Object next = it.next();
				if (next instanceof EPackage) {
					model.getAliases().add(((EPackage) next).getNsURI());
				}
			}
			models.add(model);
		}
		*/

		imageTextProvider = new ExeedImageTextProvider(model, getPlugin(), this);

		exeedItemProviderAdapterFactory.setImageTextProvider(imageTextProvider);

		((ExeedActionBarContributor) this.getActionBarContributor())
				.setProvider(imageTextProvider);

	}
	
	public ExeedImageTextProvider getImageTextProvider() {
		return imageTextProvider;
	}

	public boolean isShowAllResources() {
		return showAllResources;
	}

	public void setShowAllResources(boolean showAllResources) {
		this.showAllResources = showAllResources;
	}

	public boolean isSortProperties() {
		return sortProperties;
	}

	public void setSortProperties(boolean sortProperties) {
		this.sortProperties = sortProperties;
	}

	public boolean isShowReferenceNamesInCreateActions() {
		return showReferenceNamesInCreateActions;
	}

	public void setShowReferenceNamesInCreateActions(
			boolean showReferenceNamesInCreateActions) {
		this.showReferenceNamesInCreateActions = showReferenceNamesInCreateActions;
	}
	
	
}
