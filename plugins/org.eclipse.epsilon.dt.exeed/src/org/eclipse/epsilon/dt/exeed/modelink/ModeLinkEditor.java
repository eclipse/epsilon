/*******************************************************************************
 * Copyright (c) 2008-2012 The University of York, Antonio García-Domínguez.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 *     Antonio García-Domínguez - code cleanup, add support for forcing the Exeed editor
 ******************************************************************************/
package org.eclipse.epsilon.dt.exeed.modelink;

import java.lang.reflect.Method;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.epsilon.dt.exeed.ExeedEditor;
import org.eclipse.epsilon.dt.exeed.modelink.ModeLinkInnerEditorInput.Position;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.custom.ViewForm;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IPropertyListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.part.MultiEditor;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.ui.views.properties.PropertySheetPage;

/**
 * Two-way or three-way model editor. Can use both the default registered editors or the Exeed editors.
 */
public class ModeLinkEditor extends MultiEditor implements ISelectionChangedListener {

	//TODO: When a tab is closed prompt the user to save editor if dirty
	//TODO: Figure out how to add an editor at runtime

	private CTabFolder leftFolder;
	private CTabFolder rightFolder;
	private CTabFolder middleFolder;
	private ToolBar toolbar;

	private PropertySheetPage properties;

	public ToolBar getToolbar() {
		return toolbar;
	}
	
	@Override
	protected void drawGradient(IEditorPart innerEditor, Gradient g) {
		// do nothing
	}

	public CTabFolder createFolder(Composite parent) {
		CTabFolder folder = new CTabFolder(parent, SWT.BORDER);
		ToolBar t = new ToolBar(folder, SWT.HORIZONTAL | SWT.FLAT);
		ToolBarManager tbm = new ToolBarManager(t);

		tbm.update(true);
		folder.setTabPosition(SWT.BOTTOM);
		folder.setSimple(true);
		t.setVisible(true);
	
		folder.addSelectionListener(new SelectionListener(){
			public void widgetDefaultSelected(SelectionEvent e) {
				// do nothing
			}

			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item instanceof CTabItem) {
					((CTabItem) e.item).getControl().setFocus();
				}
			}
		});

		return folder;
	}

	@Override
	public void createPartControl(Composite parent) {
		ViewForm container = new ViewForm(parent, SWT.NONE);
	
		SashForm form = new SashForm(container, SWT.HORIZONTAL);
		leftFolder = createFolder(form);
		if (getEditorInput().isThreeWay()) {
			middleFolder = createFolder(form);
		}
		rightFolder = createFolder(form);

		for (int i=0;i<getInnerEditors().length;i++) {
			createInnerPartControl(form, getInnerEditors()[i]);
		}

		initFolder(leftFolder);
		if (getEditorInput().isThreeWay()) {
			initFolder(middleFolder);
		}
		initFolder(rightFolder);

		toolbar = new ToolBar(container, SWT.FLAT | SWT.WRAP);
		ToolBarManager tbm = new ToolBarManager(toolbar);
		tbm.update(true);
		container.setTopCenter(toolbar);
		container.setContent(form);
		toolbar.setVisible(true);

		/*
		 * WORKAROUND for Eclipse 3.x: this is required in order to make the control of each
		 * inner editor's site's pane visible and with a non-zero size. Otherwise,
		 * org.eclipse.ui.internal.PartService#firePartActivated will not notify
		 * its listeners properly, since deferControl will return a non-null value.
		 * If the listeners are not properly notified, the Properties view will not
		 * work properly in Eclipse 3.x with the ModeLink editor.
		 *
		 * Also, we need to use reflection, as getPane() is no longer available in PartSite
		 * in Eclipse 4.x.
		 */
		for (IEditorPart innerEditor : getInnerEditors()) {
			final IWorkbenchPartSite site = innerEditor.getSite();
			try {
				final Method getPane = site.getClass().getMethod("getPane");
				final Object pane = getPane.invoke(site);
				final Method getControl = pane.getClass().getMethod("getControl");
				final Control paneControl = (Control)getControl.invoke(pane);
				paneControl.setSize(1, 1);
				paneControl.setVisible(true);
			}
			catch (NoSuchMethodException e) {
				// workaround is unavailable in Eclipse 4.x
			}
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public ModeLinkEditorInput getEditorInput() {
		return (ModeLinkEditorInput) super.getEditorInput();
	}

	@Override
	public Composite createInnerPartControl(Composite parent, final IEditorPart e) {
    	CTabFolder folder;
    	ModeLinkInnerEditorInput input = (ModeLinkInnerEditorInput) e.getEditorInput();
    	if (input.getPosition() == Position.LEFT) {
    		folder = leftFolder;
    	} else if (input.getPosition() == Position.RIGHT){
    		folder = rightFolder;
    	}
    	else {
    		folder = middleFolder;
    	}
    	
    	return createEditorTab(folder, e);
    }
	
	@Override
	public String getPartName() {
		return (getEditorInput()).getOriginalInput().getFile().getName();
	}

	/*
     * @see IWorkbenchPart#setFocus()
     */
    @Override
	public void setFocus() {
        try {
        	super.setFocus();
        }
        catch (Exception ex) {}
    }

	@Override
	public Object getAdapter(@SuppressWarnings("rawtypes") Class key) {
		if (key.equals(IPropertySheetPage.class)) {
			// Workaround for Eclipse 4.x: we can't activate the inner editors anymore,
			// so the ModeLink editor has to supply its own property sheet page. This
			// trick does not work in Eclipse 3.x, though, so it has its own workaround.
			if (properties == null) {
				 properties = new PropertySheetPage();
			}
			return properties;
		}
		return super.getAdapter(key);
	}

	@Override
	public void selectionChanged(SelectionChangedEvent event) {
		if (properties != null && event.getSource() instanceof IWorkbenchPart) {
			properties.selectionChanged((IWorkbenchPart)event.getSource(), event.getSelection());
		}
	}

	private void addSelectionPropagationSupport(ExeedEditor editor, ModeLinkEditor modeLinkEditor) {
		((TreeViewer) editor.getViewer()).addSelectionChangedListener(
				new LinkingModelSelectionListener(editor, modeLinkEditor)
		);
	}

	private Composite createEditorTab(CTabFolder folder, final IEditorPart editor) {
		Composite content = new Composite(folder, SWT.NONE);
	    final InnerEditorTabItem item = new InnerEditorTabItem(folder, SWT.NONE, editor);
	    item.setControl(content);
	    editor.addPropertyListener(new IPropertyListener() {
	    	public void propertyChanged(Object source, int propId) {
	    		if (propId == IEditorPart.PROP_DIRTY) {
	    			ModeLinkEditor.this.firePropertyChange(IEditorPart.PROP_DIRTY);
	    			String text = editor.getEditorInput().getName();
	    			if (editor.isDirty()) {
						text = "*" + text;
					}
					item.setText(text);
				}
			}
	    });
	
	    item.setText(editor.getEditorInput().getName());
	    content.setLayout(new FillLayout());
	    editor.createPartControl(content);
	    
	    if (folder == middleFolder || (!getEditorInput().isThreeWay() && folder == rightFolder)) {
	    	if (editor instanceof ExeedEditor) {
	    		addSelectionPropagationSupport((ExeedEditor)editor, this);
	    	}
	    }
	    
	    content.addListener(SWT.Activate, new Listener() {
	        public void handleEvent(Event event) {
	            if (event.type == SWT.Activate) {
	            	removeListenerFromActiveEditor();

	            	if (properties != null && editor instanceof IEditingDomainProvider) {
	            		final IEditingDomainProvider iedp = (IEditingDomainProvider)editor;
	            		if (iedp.getEditingDomain() instanceof AdapterFactoryEditingDomain) {
	            			final AdapterFactoryEditingDomain afed = (AdapterFactoryEditingDomain)iedp.getEditingDomain();
	            			final AdapterFactory af = afed.getAdapterFactory();
            				properties.setPropertySourceProvider(new AdapterFactoryContentProvider(af));
	            		}
	            	}
					activateEditor(editor);
					addListenerToActiveEditor();
				}
	        }

			private void addListenerToActiveEditor() {
				if (getActiveEditor() instanceof ISelectionProvider) {
					final ISelectionProvider oldSP = (ISelectionProvider)getActiveEditor();
					oldSP.addSelectionChangedListener(ModeLinkEditor.this);
				}
			}

			private void removeListenerFromActiveEditor() {
				if (getActiveEditor() instanceof ISelectionProvider) {
					final ISelectionProvider oldSP = (ISelectionProvider)getActiveEditor();
					oldSP.removeSelectionChangedListener(ModeLinkEditor.this);
				}
			}
	    });
	    
	    return content;
	}

	private void initFolder(CTabFolder folder) {
		if (folder.getItemCount() > 0) {
			folder.setSelection(0);
		}
	}
}
