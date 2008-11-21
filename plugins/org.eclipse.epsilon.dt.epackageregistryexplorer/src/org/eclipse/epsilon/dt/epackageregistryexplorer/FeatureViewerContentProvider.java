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

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

public class FeatureViewerContentProvider implements ITreeContentProvider {
	
	protected PackageRegistryExplorerView view;
	
	public FeatureViewerContentProvider(PackageRegistryExplorerView view) {
		this.view = view;
	}
	
	public Object[] getElements(Object inputElement) {
		if (inputElement instanceof EClass) {
			ArrayList<Object> eStructuralFeatures = new ArrayList<Object>();
			eStructuralFeatures.addAll(((EClass) inputElement).getEAllStructuralFeatures());
			eStructuralFeatures.addAll(BridgeSupport.getBridgeEnds((EClass)inputElement, view.getEPackages()));
			return eStructuralFeatures.toArray();
		}
		else if (inputElement instanceof EEnum) {
			return ((EEnum) inputElement).getELiterals().toArray();
		}
		return new Object[0];
	}

	public Object[] getChildren(Object parentElement) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getParent(Object element) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean hasChildren(Object element) {
		// TODO Auto-generated method stub
		return false;
	}

	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		// TODO Auto-generated method stub
		
	}
}
 