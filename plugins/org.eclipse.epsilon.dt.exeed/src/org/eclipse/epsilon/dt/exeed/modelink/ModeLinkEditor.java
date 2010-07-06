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

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.epsilon.common.dt.util.LogUtil;
import org.eclipse.epsilon.dt.exeed.ExeedEditor;
import org.eclipse.epsilon.dt.exeed.modelink.ModeLinkInnerEditorInput.Position;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IPropertyListener;
import org.eclipse.ui.part.MultiEditor;
import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;

/**
 * A MultiEditor is a composite of editors.
 * 
 * This class is intended to be subclassed.
 * 		
 */
public class ModeLinkEditor extends MultiEditor {
	
	//TODO: When a tab is closed prompt the user to save editor if dirty
	//TODO: Figure out how to add an editor at runtime
	
	protected CTabFolder leftFolder;
	protected CTabFolder rightFolder;
	protected CTabFolder middleFolder;
	//protected List<ExeedEditor> closedEditors = new ArrayList();
	
	@Override
	protected void drawGradient(IEditorPart innerEditor, Gradient g) {
		
	}
	
	public void initFolder(CTabFolder folder) {
		if (folder.getItemCount() > 0) {
			folder.setSelection(0);
		}
	}
	
	
	protected void setInnerEditors(IEditorPart[] editors) {
		try {
			Field f = MultiEditor.class.getDeclaredField("innerEditors");
			f.setAccessible(true);
			f.set(this, editors);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public CTabFolder createFolder(Composite parent) {
		CTabFolder folder = new CTabFolder(parent, SWT.BORDER);
		/*
		folder.addCTabFolder2Listener(new CTabFolder2Listener() {

			public void close(CTabFolderEvent event) {
				ExeedEditorTabItem item = (ExeedEditorTabItem) event.item;
				closedEditors.add(item.getEditor());
				saveState();
			}

			public void maximize(CTabFolderEvent event) {
				// TODO Auto-generated method stub
				
			}

			public void minimize(CTabFolderEvent event) {
				// TODO Auto-generated method stub
				
			}

			public void restore(CTabFolderEvent event) {
				// TODO Auto-generated method stub
				
			}

			public void showList(CTabFolderEvent event) {
				// TODO Auto-generated method stub
				
			}
			
		});
		*/
		ToolBar t = new ToolBar(folder, SWT.HORIZONTAL | SWT.FLAT);
		ToolBarManager tbm = new ToolBarManager(t);
		//tbm.add(new AddModelAction(folder));
		tbm.update(true);
		//folder.setTabPosition(SWT.BOTTOM);
		//folder.setTopRight(t, SWT.RIGHT);
		//folder.setTabHeight(23);
		folder.setTabPosition(SWT.BOTTOM);
		folder.setSimple(true);
		t.setVisible(true);

		/*
		Button b = new Button(folder,SWT.NONE);
		b.setText("BTN");
		b.setImage(Activator.getImageDescriptor("icons/emfmodel.gif").createImage());
		folder.setTopRight(b);
		*/
		
		//parent.setLayout(new org.eclipse.swt.layout.RowLayout());
		//folder.setLayout(new FillLayout());
		//folder.setTabPosition(SWT.BOTTOM);
		//folder.setSimple(false);
		
		folder.addSelectionListener(new SelectionListener(){

			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item instanceof CTabItem) {
					((CTabItem) e.item).getControl().setFocus();
				}
			}
			
		});
		
		/*
		CTabFolderUtil.addDndSupport(folder, new CTabFolderUtil.TabOrderChangeListener() {
			public void tabOrderChanged() {
				saveState();
			}
		});
		*/
		
		return folder;
	}
	
	// Saves the state of the editor
	protected void saveState() {
		
		Document doc = new Document();
		Element root = new Element("modelink");
		root.getAttributes().add(new Attribute("threeWay", getEditorInput().isThreeWay() + ""));
		doc.setRootElement(root);
		root.addContent(createFolderElements(leftFolder, "left"));
		root.addContent(createFolderElements(rightFolder, "right"));
		root.addContent(createFolderElements(middleFolder, "middle"));
		
		try {
			new StoreXmlDocumentOperation(doc, getEditorInput().getOriginalInput().getFile()).run(null);
			getEditorInput().getOriginalInput().getFile().refreshLocal(0, null);
		} catch (Exception e) {
			LogUtil.log(e);
		}
		
	}
	
	protected List<Element> createFolderElements(CTabFolder folder, String position) {
		ArrayList<Element> elements = new ArrayList();
		if (folder == null) return elements;
		CTabItem[] tabItems = folder.getItems();
		for (int i=0;i<tabItems.length;i++) {
			InnerEditorTabItem item = (InnerEditorTabItem) tabItems[i];
			IEditorPart editor = item.getEditor();
			//if (!closedEditors.contains(editor)) {
			ModeLinkInnerEditorInput input = (ModeLinkInnerEditorInput) editor.getEditorInput();
			Element el = new Element("model");
			el.getAttributes().add(new Attribute("path", input.getFile().getFullPath().toOSString()));
			el.getAttributes().add(new Attribute("position", position));
			elements.add(el);
			//}
		}
		return elements;
	}
	
	@Override
	public ModeLinkEditorInput getEditorInput() {
		return (ModeLinkEditorInput) super.getEditorInput();
	}
	
	@Override
	public void createPartControl(Composite parent) {
		SashForm form = new SashForm(parent, SWT.HORIZONTAL);
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
		
	}
    
	/*
	public Composite createInnerPartControl(Composite parent,
            final IEditorPart e) {
		CTabFolder tabFolder = new CTabFolder(parent, SWT.NONE | SWT.BOTTOM);
		tabFolder.setSimple(false);
		CTabItem tabItem = new CTabItem(tabFolder, SWT.BORDER | SWT.MULTI);
		
        Composite content = new Composite(tabFolder, SWT.NONE);
        content.setLayout(new FillLayout());
        e.createPartControl(content);
        tabItem.setControl(content);
        tabItem.setText(e.getTitle());
        
        content.addListener(SWT.Activate, new Listener() {
            public void handleEvent(Event event) {
                if (event.type == SWT.Activate) {
					activateEditor(e);
				}
            }
        });
        return content;
    }
    */
	
	protected void addSelectionPropagationSupport(ExeedEditor editor, ModeLinkEditor modeLinkEditor) {
		
		((TreeViewer) editor.getViewer()).addSelectionChangedListener(
				new LinkingModelSelectionListener(editor, modeLinkEditor)
		);
		
	}
	
	protected Composite createEditorTab(CTabFolder folder, final IEditorPart editor) {
		Composite content = new Composite(folder, SWT.NONE);
        final InnerEditorTabItem item = new InnerEditorTabItem(folder, SWT.NONE, editor);
        
        //item.setImage(Activator.getImageDescriptor("icons/emfmodel.gif").createImage());
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
					activateEditor(editor);
				}
            }
        });
        
        return content;

	}
	
    @Override
	public Composite createInnerPartControl(Composite parent,
            final IEditorPart e) {
    	
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
		String partName = (getEditorInput()).getOriginalInput().getFile().getName();
		//if (isDirty()) partName = "*" + partName;
		return partName;
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
	
	
}
