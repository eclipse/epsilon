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
import java.util.List;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.part.ViewPart;

public class PackageRegistryExplorerView extends ViewPart {
	
	protected boolean backRunning = false;
	protected TreeViewer classViewer;
	protected TreeViewer featureViewer;
	protected ArrayList<EPackage> ePackages = new ArrayList<EPackage>();
	protected List<TreePath> history = new ArrayList<TreePath>();
	
	public List<EPackage> getEPackages() {
		return ePackages;
	}
	
	@Override
	public void createPartControl(Composite parent) {
		
		
		ECoreLabelProvider eCoreLabelProvider = new ECoreLabelProvider();
		
		SashForm sashForm = new SashForm(parent, SWT.VERTICAL);
		
		classViewer = new TreeViewer(sashForm, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		classViewer.setContentProvider(new PackageRegistryContentProvider(this));
		classViewer.setLabelProvider(eCoreLabelProvider);
		classViewer.addSelectionChangedListener(new ClassViewerSelectionChangedListener());
		classViewer.setSorter(new AlphabeticalSorter());
		classViewer.setInput(getViewSite());
		
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
		
		featureViewer = new TreeViewer(sashForm, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		featureViewer.setContentProvider(new FeatureViewerContentProvider(this));
		featureViewer.setLabelProvider(eCoreLabelProvider);
		featureViewer.setSorter(new AlphabeticalSorter());
		featureViewer.setInput(null);
		featureViewer.addDoubleClickListener(new IDoubleClickListener() {

			public void doubleClick(DoubleClickEvent event) {
				IStructuredSelection s = (IStructuredSelection) event.getSelection();
				if (s.getFirstElement() != null) {
					if (s.getFirstElement() instanceof EStructuralFeature) {
						EStructuralFeature f = (EStructuralFeature) s.getFirstElement();
						classViewer.setSelection(new TreeSelection(new TreePath(new Object[]{f.getEType().getEPackage(), f.getEType()})));
					}
					else if (s.getFirstElement() instanceof BridgeEndDescriptor) {
						EStructuralFeature f = ((BridgeEndDescriptor) s.getFirstElement()).getEStructuralFeature();
						classViewer.setSelection(new TreeSelection(new TreePath(new Object[]{f.getEContainingClass().getEPackage(), f.getEContainingClass()})));	
					}
				}
			}
			
		});
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
				System.err.println(history.size());
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
			for (Object o : EPackage.Registry.INSTANCE.values()) {
				if (o instanceof EPackage) {
					ePackages.add((EPackage)o);
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

	    final int limit = 20, percent = 50;
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
		// TODO Auto-generated method stub
		
	}

}
 