/*******************************************************************************
 * Copyright (c) 2011 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Antonio Garcia-Dominguez - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.eunit.dt.ui;

import org.eclipse.epsilon.eol.eunit.EUnitTest;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.ui.IViewSite;

/**
 * Content provider for the test tree shown in the EUnit view.
 *
 * @author Antonio García-Domínguez
 * @version 1.0
 */
class TestTreeContentProvider implements ITreeContentProvider {
	private EUnitTest rootTest = null;
	private final IViewSite viewSite;

	TestTreeContentProvider(IViewSite viewSite) {
		this.viewSite = viewSite;
	}

	public void inputChanged(Viewer v, Object oldInput, Object newInput) {
		if (newInput instanceof EUnitTest) {
			rootTest = (EUnitTest)newInput;
		}
	}

	public void dispose() {}

	public Object[] getElements(Object parent) {
		if (parent.equals(viewSite)) {
			return getChildren(rootTest);
		}
		return getChildren(parent);
	}

	public Object getParent(Object child) {
		if (child instanceof EUnitTest) {
			return ((EUnitTest)child).getParent();
		}
		return null;
	}

	public Object[] getChildren(Object parent) {
		if (parent instanceof EUnitTest) {
			return ((EUnitTest)parent).getChildren().toArray();
		}
		return new Object[0];
	}

	public boolean hasChildren(Object parent) {
		if (parent instanceof EUnitTest) {
			return !((EUnitTest)parent).getChildren().isEmpty();
		}
		return false;
	}
}