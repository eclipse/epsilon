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

package org.eclipse.epsilon.dt.epackageregistryexplorer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.edit.provider.ReflectiveItemProvider;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.PropertySource;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.custom.ViewForm;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.ui.views.properties.IPropertySource;

public class PackageRegistryExplorerView extends ViewPart implements ISelectionProvider{
	
	protected Collection<ISelectionChangedListener> selectionChangedListeners = new ArrayList<ISelectionChangedListener>();
	protected boolean backRunning = false;
	protected TreeViewer classViewer;
	protected ViewForm featureViewerForm;
	protected TreeViewer featureViewer;
	protected ArrayList<EPackage> ePackages = new ArrayList<EPackage>();
	protected List<TreePath> history = new ArrayList<TreePath>();
	protected CLabel selectedClassLabel = null;
	protected boolean showInheritedFeatures = true;
	protected boolean showDerivedFeatures = true;
	protected boolean showOppositeReference = false;
	protected boolean showOperations = false;
	
	public boolean isShowOppositeReference() {
		return showOppositeReference;
	}

	public void setShowOppositeReference(boolean showOppositeReference) {
		this.showOppositeReference = showOppositeReference;
		featureViewer.refresh();
	}

	public boolean isShowOperations() {
		return showOperations;
	}

	public void setShowOperations(boolean showOperations) {
		this.showOperations = showOperations;
		featureViewer.refresh();
	}

	public boolean isShowInheritedFeatures() {
		return showInheritedFeatures;
	}

	public void setShowInheritedFeatures(boolean showInheritedFeatures) {
		this.showInheritedFeatures = showInheritedFeatures;
		featureViewer.refresh();
	}

	public boolean isShowDerivedFeatures() {
		return showDerivedFeatures;
	}

	public void setShowDerivedFeatures(boolean showDerivedFeatures) {
		this.showDerivedFeatures = showDerivedFeatures;
		featureViewer.refresh();
	}

	public List<EPackage> getEPackages() {
		return ePackages;
	}
	
	@Override
	public void createPartControl(Composite parent) {
		
		
		ECoreLabelProvider eCoreLabelProvider = new ECoreLabelProvider(this);
		
		SashForm sashForm = new SashForm(parent, SWT.VERTICAL);
		
		classViewer = new TreeViewer(sashForm, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		classViewer.setContentProvider(new PackageRegistryContentProvider(this));
		classViewer.setLabelProvider(eCoreLabelProvider);
		classViewer.addSelectionChangedListener(new ClassViewerSelectionChangedListener());
		classViewer.setSorter(new AlphabeticalSorter());
		classViewer.setInput(getViewSite());
		getSite().setSelectionProvider(this);		
		
		classViewer.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				
				if (backRunning) return;
				
				
				
				TreeSelection selection = (TreeSelection) event.getSelection();
				
				if (selection.getPaths().length == 0) return;
				
				if (history.size() == 0) {
					history.add(0, selection.getPaths()[0]);
				}
				else if (history.get(0) != selection.getPaths()[0]) {
					history.add(0, selection.getPaths()[0]);
				}
			}
			
		});
		
		//Composite composite = new Composite(sashForm, SWT.NONE);
		
		//composite.setLayout(new FormLayout());
		//ToolBar t = new ToolBar(composite, SWT.NONE);
		//ToolBarManager m = new ToolBarManager(t);
		//m.add(new RefreshAction());
		
		featureViewerForm = new ViewForm(sashForm, SWT.NONE);
		
		featureViewer = new TreeViewer(featureViewerForm, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		featureViewerForm.setContent(featureViewer.getControl());
		featureViewer.setContentProvider(new FeatureViewerContentProvider(this));
		featureViewer.setLabelProvider(eCoreLabelProvider);
		featureViewer.setSorter(new AlphabeticalSorter());
		featureViewer.setInput(null);
		featureViewer.addDoubleClickListener(new IDoubleClickListener() {

			public void doubleClick(DoubleClickEvent event) {
				IStructuredSelection s = (IStructuredSelection) event.getSelection();
				if (s.getFirstElement() != null) {
					if (s.getFirstElement() instanceof ETypedElement) {
						ETypedElement f = (ETypedElement) s.getFirstElement();
						classViewer.setSelection(new TreeSelection(new TreePath(new Object[]{f.getEType().getEPackage(), f.getEType()})));
					}
					else if (s.getFirstElement() instanceof DecoratorHookDescriptor) {
						EStructuralFeature f = ((DecoratorHookDescriptor) s.getFirstElement()).getEStructuralFeature();
						classViewer.setSelection(new TreeSelection(new TreePath(new Object[]{f.getEContainingClass().getEPackage(), f.getEContainingClass()})));	
					}
				}
			}
			
		});
		
		featureViewer.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				notifySelectionChangedListeners(featureViewer);
			}
			
		});
		
		selectedClassLabel = new CLabel(featureViewerForm, SWT.NONE);
		featureViewerForm.setTopLeft(selectedClassLabel);
		
		ToolBar featureViewerToolBar= new ToolBar(featureViewerForm, SWT.FLAT | SWT.WRAP);
		featureViewerForm.setTopCenter(featureViewerToolBar);
		ToolBarManager manager = new ToolBarManager(featureViewerToolBar);
		manager.add(new ShowOperationsAction(this));
		manager.add(new ShowOppositeReferenceAction(this));
		manager.add(new ShowDerivedFeaturesAction(this));
		manager.add(new ShowInheritedFeaturesAction(this));
		manager.update(true);
		
		//layout(parent);
		contributeToActionBars();
	}
	
	
	private void contributeToActionBars() {
		IActionBars bars = getViewSite().getActionBars();
		bars.getToolBarManager().add(new BackAction());
		bars.getToolBarManager().add(new RefreshAction());
	}
	
	class ClassViewerSelectionChangedListener implements ISelectionChangedListener {

		public void selectionChanged(SelectionChangedEvent event) {
			IStructuredSelection selection = (IStructuredSelection) event.getSelection();
			TreeItem[] selectedItems = classViewer.getTree().getSelection();
			if (selectedItems.length > 0) {
				selectedClassLabel.setText(selectedItems[0].getText());
				selectedClassLabel.setImage(selectedItems[0].getImage());
				notifySelectionChangedListeners(classViewer);
			}
			featureViewer.setInput(selection.getFirstElement());
		}
		
	}
	
	class BackAction extends Action {
		
		protected boolean running = false;
		
		public BackAction() {
			this.setText("Back");
			this.setImageDescriptor(Activator.getDefault().getImageDescriptor("icons/back.png"));
		}
		
		@Override
		public void run() {
			
			backRunning = true;
			
			if (history.size() > 1) {
				classViewer.setSelection(new TreeSelection(history.get(1)));
				history.remove(1);
			}
			
			backRunning = false;
		}		
	}
	
	class RefreshAction extends Action {
		
		public RefreshAction() {
			this.setText("Refresh");
			this.setImageDescriptor(Activator.getDefault().getImageDescriptor("icons/refresh.gif"));
		}
		
		@Override
		public void run() {
			ArrayList<EPackage> ePackages = new ArrayList<EPackage>();
			
			//Avoid concurrent modification exceptions that can happen when iterating
			//directly over INSTANCE.values()
			ArrayList<Object> ePackageRegistryValues = new ArrayList<Object>();
			ePackageRegistryValues.addAll(EPackage.Registry.INSTANCE.values());
			
			for (Object o : ePackageRegistryValues) {
				if (o instanceof EPackage) {
					ePackages.add((EPackage)o);
				}
				else if (o instanceof EPackage.Descriptor) {
					try {
						ePackages.add(((EPackage.Descriptor) o).getEPackage());
					}
					catch (Exception ex) { 
						// Problematic package descriptor - ignore
					}
				}
			}
			PackageRegistryExplorerView.this.ePackages = ePackages;
			classViewer.refresh();
		}
	}
	
	public static void main(String[] args) {

		
		    final Display display = new Display();
		    Shell shell = new Shell(display);
		    shell.setLayout(new FillLayout());

		    SashForm form = new SashForm(shell, SWT.VERTICAL);
		    form.setLayout(new FillLayout());

		    Composite child1 = new Composite(form, SWT.NONE);
		    child1.setLayout(new FillLayout());
		    new Label(child1, SWT.NONE).setText("Label in pane 1");

		    Composite child2 = new Composite(form, SWT.NONE);
		    child2.setLayout(new FillLayout());
		    new Button(child2, SWT.PUSH).setText("Button in pane2");

		    Composite child3 = new Composite(form, SWT.NONE);
		    child3.setLayout(new FillLayout());
		    new Label(child3, SWT.PUSH).setText("Label in pane3");

		    form.setWeights(new int[] { 30, 40, 30 });
		    shell.open();
		    while (!shell.isDisposed()) {
		      if (!display.readAndDispatch())
		        display.sleep();
		    }
		    display.dispose();

		

	}
	
	protected void layout(final Composite parent) {
		final SashForm sash = new SashForm(parent, SWT.HORIZONTAL);
	    final FormLayout form = new FormLayout();
	    parent.setLayout(form);

	    FormData button1Data = new FormData();
	    button1Data.left = new FormAttachment(0, 0);
	    button1Data.right = new FormAttachment(sash, 0);
	    button1Data.top = new FormAttachment(0, 0);
	    button1Data.bottom = new FormAttachment(100, 0);
	    classViewer.getControl().setLayoutData(button1Data);

	    int percent = 50;
	    final FormData sashData = new FormData();
	    sashData.left = new FormAttachment(percent, 0);
	    sashData.top = new FormAttachment(0, 0);
	    sashData.bottom = new FormAttachment(100, 0);
	    sash.setLayoutData(sashData);
	    /*
	    sash.addListener(SWT.Selection, new Listener() {
	      public void handleEvent(Event e) {
	        Rectangle sashRect = sash.getBounds();
	        Rectangle shellRect = parent.getClientArea();
	        int right = shellRect.width - sashRect.width - limit;
	        e.x = Math.max(Math.min(e.x, right), limit);
	        if (e.x != sashRect.x) {
	          sashData.left = new FormAttachment(0, e.x);
	          parent.layout();
	        }
	      }
	    });
*/
	    FormData button2Data = new FormData();
	    button2Data.left = new FormAttachment(sash, 0);
	    button2Data.right = new FormAttachment(100, 0);
	    button2Data.top = new FormAttachment(0, 0);
	    button2Data.bottom = new FormAttachment(100, 0);
	    featureViewer.getControl().setLayoutData(button2Data);
		
	}
	
	@Override
	public void setFocus() {
		
	}

	public void addSelectionChangedListener(ISelectionChangedListener listener) {
		selectionChangedListeners.add(listener);
	}

	public ISelection getSelection() {
		return null;
	}

	public void notifySelectionChangedListeners(Viewer viewer) {
		for (ISelectionChangedListener listener : selectionChangedListeners) {
			final Object selected = ((IStructuredSelection)viewer.getSelection()).getFirstElement();
			
			IAdaptable adaptable = new IAdaptable() {

				@SuppressWarnings("rawtypes")
				public Object getAdapter(Class adapter) {
					
					if (selected instanceof EObject && adapter == IPropertySource.class) {
						
						return new PropertySource(selected, new ReflectiveItemProvider(new ReflectiveItemProviderAdapterFactory()));
					}
					return null;
				}
				
			};
			listener.selectionChanged(new SelectionChangedEvent(this, new StructuredSelection(adaptable)));
		}
	}
	
	public void removeSelectionChangedListener(
			ISelectionChangedListener listener) {
		selectionChangedListeners.remove(listener);
		
	}

	public void setSelection(ISelection selection) {
		// TODO Auto-generated method stub
		
	}

}
 