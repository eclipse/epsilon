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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

public class PackageRegistryContentProvider implements ITreeContentProvider {
	
	protected PackageRegistryExplorerView view;
	
	public PackageRegistryContentProvider(PackageRegistryExplorerView view) {
		this.view = view;
	}
	
	public Object[] getChildren(Object parentElement) {
		if (parentElement instanceof EPackage) {
			return ((EPackage) parentElement).getEClassifiers().toArray();
		}
		else if (parentElement instanceof EClass) {
			EClass eClass = (EClass) parentElement;
			return getInheritanceDescriptors(eClass).toArray();
		}
		else if (parentElement instanceof SuperTypesDescriptor) {
			return ((SuperTypesDescriptor) parentElement).getEClass().getESuperTypes().toArray();
		}
		else if (parentElement instanceof SubTypesDescriptor) {
			SubTypesDescriptor subTypesDescriptor = (SubTypesDescriptor) parentElement;
			return subTypesDescriptor.getSubtypes(view.getEPackages()).toArray();
		}
		
		return Collections.EMPTY_LIST.toArray();
	}

	public Object getParent(Object element) {
		return null;
	}

	public Collection<Object> getInheritanceDescriptors(EClass eClass) {
		ArrayList<Object> inheritanceDescriptors = new ArrayList<Object>();
		if (eClass.getESuperTypes().size() > 0) {
			inheritanceDescriptors.add(new SuperTypesDescriptor(eClass));
		}
		SubTypesDescriptor subTypesDescriptor = new SubTypesDescriptor(eClass);
		if (subTypesDescriptor.hasSubtypes(view.getEPackages())) {
			inheritanceDescriptors.add(subTypesDescriptor);
		}
		return inheritanceDescriptors;
	}
	
	public boolean hasChildren(Object element) {
		if (element instanceof EClass) {
			return getInheritanceDescriptors((EClass) element).size() > 0;
		}
		else if (element instanceof EDataType) {
			return false;
		}
		else {
			return true;
		}
	}

	public Object[] getElements(Object inputElement) {
		return view.getEPackages().toArray();
	}

	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		// TODO Auto-generated method stub
		
	}
	
}
 