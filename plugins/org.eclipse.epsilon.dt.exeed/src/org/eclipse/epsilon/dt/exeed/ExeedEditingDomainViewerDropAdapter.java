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
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.ui.dnd.EditingDomainViewerDropAdapter;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.TreeItem;

public class ExeedEditingDomainViewerDropAdapter extends
		EditingDomainViewerDropAdapter {

	protected List<EReference> qualifiedReferences = new ArrayList();
	protected EditingDomain editingDomain;
	protected Viewer viewer;
	protected Image setReferenceValueImage = null;
	protected Image addReferenceValueImage = null;
	
	
	public ExeedEditingDomainViewerDropAdapter(EditingDomain domain, Viewer viewer, ExeedPlugin plugin) {
		super(domain, viewer);
		this.editingDomain = domain;
		this.viewer = viewer;
		addReferenceValueImage = plugin.getImageDescriptor("icons/add.gif").createImage();
		setReferenceValueImage = plugin.getImageDescriptor("icons/set.gif").createImage();
	}

	@Override
	public void dragOver(DropTargetEvent event) {
		
		super.dragOver(event);
		
		
		//if (event.detail == DND.DROP_NONE || event.detail == DND.DROP_COPY) {
		
		if (event.detail == DND.DROP_NONE) {
			
			qualifiedReferences.clear();
			
			TreeItem item = (TreeItem) event.item;
			
			if (item == null || !(item.getData() instanceof EObject)) {
				return;
			}

			EObject targetEObject = (EObject) item.getData();

			Iterator rit = targetEObject.eClass().getEAllReferences()
					.iterator();
			
			while (rit.hasNext()) {
				EReference ref = (EReference) rit.next();

				boolean areInstancesOf = true;
				Iterator it = source.iterator();
				
				if (!ref.isMany() && source.size() > 1) continue;
				
				while (it.hasNext() && areInstancesOf) {
					Object next = it.next();
					if (ref.getEType().isInstance(next)) {
						areInstancesOf = true;
					}
					else {
						areInstancesOf = false;
					}
				}
				if (areInstancesOf) {
					if (event.detail != DND.DROP_LINK) {
						event.detail = DND.DROP_LINK;
					}
					qualifiedReferences.add(ref);
				}
			}

		}
	}
	
	protected String detailToString(int detail) {
		if (detail == DND.DROP_COPY) {
			return "Copy";
		} else if (detail == DND.DROP_DEFAULT) {
			return "Default";
		} else if (detail == DND.DROP_LINK) {
			return "Link";
		} else if (detail == DND.DROP_MOVE) {
			return "Move";
		} else if (detail == DND.DROP_NONE) {
			return "None";
		} else if (detail == DND.DROP_TARGET_MOVE) {
			return "TargetMove";
		} else {
			return "Unrecognized : " + detail;
		}
	}
	
	@Override
	public void dropAccept(final DropTargetEvent event) {
		
		
		//if (event.detail != DND.DROP_LINK) {
			super.dropAccept(event);
		//}
		//else {
		// Create a SetReferenceValueCommand with undo support etc.
			if (qualifiedReferences.size() > 0) {
	
				//Menu m = new Menu(ExeedEditor.this.getSite().getShell(), SWT.POP_UP);
				Menu m = new Menu(viewer.getControl().getShell(), SWT.POP_UP);
	
				for (EReference reference : qualifiedReferences) {
	
					final Command command;
					Image image = null;
	
					if (reference.isMany()) {
						command = new AddReferenceValuesCommand(
								(EObject) event.item.getData(), source, reference);
						image = addReferenceValueImage;
					} else {
						command = new SetReferenceValueCommand(
								(EObject) event.item.getData(), (EObject) source
										.iterator().next(), reference);
						image = setReferenceValueImage;
					}
	
					MenuItem mi = new MenuItem(m, SWT.PUSH);
					mi.setText(command.getLabel());
					mi.setImage(image);
					
					mi.addListener(SWT.Selection, new Listener() {
	
						public void handleEvent(Event event) {
							editingDomain.getCommandStack().execute(command);
						}
	
					});
	
				}
	
				m.setLocation(new Point(event.x, event.y));
				m.setVisible(true);
				qualifiedReferences.clear();
				source = null;
			}
		}
	//}

}
