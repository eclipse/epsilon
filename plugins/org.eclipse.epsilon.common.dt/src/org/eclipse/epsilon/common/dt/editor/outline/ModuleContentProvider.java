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
package org.eclipse.epsilon.common.dt.editor.outline;

import java.util.List;

import org.eclipse.epsilon.common.module.ModuleElement;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

public abstract class ModuleContentProvider implements ITreeContentProvider{
	
	public Object[] getChildren(Object parentElement) {
		return getVisibleChildren((ModuleElement) parentElement).toArray();
	}

	public Object getParent(Object element) {
		return ((ModuleElement) element).getParent();
	}

	public boolean hasChildren(Object element) {
		return (element instanceof ModuleElement && getVisibleChildren((ModuleElement)element).size() > 0) ;
	}

	public Object[] getElements(Object inputElement) {
		return getVisibleChildren((ModuleElement) inputElement).toArray();
	}

	public void dispose() {}

	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		
	}
	
	public abstract List<ModuleElement> getVisibleChildren(ModuleElement moduleElement);
	
	public abstract ModuleElement getFocusedModuleElement(ModuleElement moduleElement);
	
}
