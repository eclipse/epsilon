/*******************************************************************************
 * Copyright (c) 2008-2012 The University of York, Antonio García-Domínguez.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 *     Antonio García-Domínguez - fix DND in Eclipse Juno
 ******************************************************************************/
package org.eclipse.epsilon.dt.exeed;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.ui.dnd.EditingDomainViewerDropAdapter;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.TreeItem;

public class ExeedEditingDomainViewerDropAdapter extends EditingDomainViewerDropAdapter {

	protected Image setReferenceValueImage = null;
	protected Image addReferenceValueImage = null;
	
	public ExeedEditingDomainViewerDropAdapter(EditingDomain domain, Viewer viewer, ExeedPlugin plugin) {
		super(domain, viewer);
		addReferenceValueImage = plugin.getImageDescriptor("icons/add.gif").createImage();
		setReferenceValueImage = plugin.getImageDescriptor("icons/set.gif").createImage();
	}


	@Override
	public void drop(final DropTargetEvent event) {
		super.drop(event);

		source = getDragSource(event);
		final List<EReference> qualifiedReferences = listQualifiedReferences(event);
		if (!qualifiedReferences.isEmpty()) {
			Menu m = new Menu(viewer.getControl());

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
						domain.getCommandStack().execute(command);
					}
				});
			}

			final Display display = Display.getCurrent();
			m.setLocation(event.x, event.y);
			m.setVisible(true);
			while (!m.isDisposed () && m.isVisible ()) {
				if (!display.readAndDispatch ()) display.sleep ();
			}
			m.dispose ();
			qualifiedReferences.clear();
			source = null;
		}
	}

	private List<EReference> listQualifiedReferences(DropTargetEvent event) {
		final List<EReference> qualifiedReferences = new ArrayList<EReference>();
	
		TreeItem item = (TreeItem) event.item;
		if (item == null || !(item.getData() instanceof EObject)) {
			return qualifiedReferences;
		}

		EObject targetEObject = (EObject) item.getData();
		Iterator<EReference> rit = targetEObject.eClass().getEAllReferences().iterator();

		while (rit.hasNext()) {
			final EReference ref = (EReference) rit.next();
			if (!ref.isMany() && source.size() > 1) continue;

			boolean areInstancesOf = true;
			final Iterator<?> it = source.iterator();
			final EClassifier eType = ref.getEType();
			while (it.hasNext() && areInstancesOf) {
				Object next = it.next();
				areInstancesOf = eType.isInstance(next);
			}
			if (areInstancesOf) {
				qualifiedReferences.add(ref);
			}
		}

		return qualifiedReferences;
	}

}
