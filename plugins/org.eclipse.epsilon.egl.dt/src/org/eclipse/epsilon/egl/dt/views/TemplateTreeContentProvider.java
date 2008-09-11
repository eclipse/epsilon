/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.egl.dt.views;

import org.eclipse.epsilon.egl.traceability.Container;
import org.eclipse.epsilon.egl.traceability.Content;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

public class TemplateTreeContentProvider implements ITreeContentProvider {

	private static final Object[] EMPTY = new Object[0];

	
	public Object[] getChildren(Object parentElement) {
		if (parentElement instanceof Container) {
			return ((Container<?>)parentElement).getChildren().toArray();
		}
		
		return EMPTY;
	}

	public Object getParent(Object element) {
		if (element instanceof Content) {
			return ((Content<?>)element).getParent();
		}
		
		return null;
	}

	public boolean hasChildren(Object element) {
		if (element instanceof Container) {
			return ((Container<?>)element).hasChildren();
		}
		
		return false;
	}

	public Object[] getElements(Object inputElement) {
		return getChildren(inputElement);
	}

	public void dispose() {}

	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {}
	
}
