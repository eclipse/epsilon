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

import org.eclipse.epsilon.common.module.IModule;
import org.eclipse.epsilon.common.module.ModuleElement;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

public class ModuleContentProvider implements ITreeContentProvider{
	
	private IModule module;
	
	public Object[] getChildren(Object parentElement) {
		return ((ModuleElement) parentElement).getChildren().toArray();
	}

	public Object getParent(Object element) {
		return module;
	}

	public boolean hasChildren(Object element) {
		//return (element == module);
		return (element instanceof ModuleElement && ((ModuleElement)element).getChildren().size() > 0) ;
	}

	public Object[] getElements(Object inputElement) {
		return ((ModuleElement) inputElement).getChildren().toArray();
	}

	public void dispose() {
		// TODO Auto-generated method stub
	}

	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		module = (IModule) newInput;
	}
	
	
	
}
