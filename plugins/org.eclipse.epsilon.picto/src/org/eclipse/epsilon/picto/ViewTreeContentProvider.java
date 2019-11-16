/*********************************************************************
* Copyright (c) 2008 The University of York.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.picto;

import org.eclipse.jface.viewers.ITreeContentProvider;

public class ViewTreeContentProvider implements ITreeContentProvider {
	
	@Override
	public boolean hasChildren(Object element) {
		return !((ViewTree) element).getChildren().isEmpty();
	}
	
	@Override
	public Object getParent(Object element) {
		return ((ViewTree) element).getParent();
	}
	
	@Override
	public Object[] getElements(Object inputElement) {
		return getChildren(inputElement);
	}
	
	@Override
	public Object[] getChildren(Object parentElement) {
		return ((ViewTree) parentElement).getChildren().toArray();
	}
}
