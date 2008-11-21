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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.viewers.ITableFontProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.plugin.AbstractUIPlugin;

public class ECoreLabelProvider extends LabelProvider implements ITableFontProvider {
	@Override
	public Image getImage(Object element) {
		if (element instanceof EPackage) {
			return AbstractUIPlugin.imageDescriptorFromPlugin("org.eclipse.emf.ecore.edit", "icons/full/obj16/EPackage.gif").createImage();
		}
		else if (element instanceof EClass) {
			if (BridgeSupport.isBridge((EClass)element)) {
				return AbstractUIPlugin.imageDescriptorFromPlugin("org.eclipse.epsilon.emc.emf.dt", "icons/Bridge.gif").createImage();
			}
			return AbstractUIPlugin.imageDescriptorFromPlugin("org.eclipse.emf.ecore.edit", "icons/full/obj16/EClass.gif").createImage();	
		}
		else if (element instanceof EDataType) {
			return AbstractUIPlugin.imageDescriptorFromPlugin("org.eclipse.emf.ecore.edit", "icons/full/obj16/EDataType.gif").createImage();
		}
		else if (element instanceof EAttribute) {
			return AbstractUIPlugin.imageDescriptorFromPlugin("org.eclipse.emf.ecore.edit", "icons/full/obj16/EAttribute.gif").createImage();
		}
		else if (element instanceof EReference) {
			EReference eReference = (EReference) element;
			if (BridgeSupport.isBridgeEnd(eReference)) {
				return AbstractUIPlugin.imageDescriptorFromPlugin("org.eclipse.epsilon.emc.emf.dt", "icons/BridgeEnd.gif").createImage();
			}
			return AbstractUIPlugin.imageDescriptorFromPlugin("org.eclipse.emf.ecore.edit", "icons/full/obj16/EReference.gif").createImage();
		}
		else if (element instanceof BridgeEndDescriptor) {
			return AbstractUIPlugin.imageDescriptorFromPlugin("org.eclipse.epsilon.emc.emf.dt", "icons/BridgeFeature.gif").createImage();			
		}
		else if (element instanceof SubTypesDescriptor) {
			return AbstractUIPlugin.imageDescriptorFromPlugin("org.eclipse.epsilon.emc.emf.dt", "icons/Subtypes.png").createImage();			
		}
		else if (element instanceof SuperTypesDescriptor) {
			return AbstractUIPlugin.imageDescriptorFromPlugin("org.eclipse.epsilon.emc.emf.dt", "icons/Supertypes.png").createImage();			
		}
		else return super.getImage(element);
	}

	@Override
	public String getText(Object element) {
		if (element instanceof EPackage) {
			EPackage ePackage = (EPackage) element;
			return ePackage.getName() + " (" + ePackage.getNsURI() + ")";
		}
		else if (element instanceof EClassifier) {
			return ((EClassifier) element).getName();
		}
		else if (element instanceof EStructuralFeature) {
			EStructuralFeature sf = ((EStructuralFeature) element);
			String signature = sf.getName();
			if (sf.getEType() != null) {
				signature = signature + " : " + sf.getEType().getName();
			}
			if (sf.isMany()) {
				signature = signature + " [*]";
			}
			return signature;
		}
		else if (element instanceof BridgeEndDescriptor) {
			return getText(((BridgeEndDescriptor) element).getEStructuralFeature());
		}
		else if (element instanceof SubTypesDescriptor) {
			return "";
		}
		else if (element instanceof SuperTypesDescriptor) {
			return "";
		}
		else return element.toString();
	}

	public Font getFont(Object element, int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
 