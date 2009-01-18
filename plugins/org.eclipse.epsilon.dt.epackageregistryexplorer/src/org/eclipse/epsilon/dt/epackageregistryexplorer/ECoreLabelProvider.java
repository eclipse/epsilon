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

import java.util.ListIterator;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.resource.FontRegistry;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.viewers.IColorProvider;
import org.eclipse.jface.viewers.IFontProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.plugin.AbstractUIPlugin;

public class ECoreLabelProvider extends LabelProvider implements IFontProvider, IColorProvider {
	
	protected PackageRegistryExplorerView view;
	
	public ECoreLabelProvider(PackageRegistryExplorerView view) {
		this.view = view;
	}
	
	@Override
	public Image getImage(Object element) {
		if (element instanceof EPackage) {
			return AbstractUIPlugin.imageDescriptorFromPlugin("org.eclipse.emf.ecore.edit", "icons/full/obj16/EPackage.gif").createImage();
		}
		else if (element instanceof EClass) {
			if (BridgeSupport.isBridge((EClass)element)) {
				return AbstractUIPlugin.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "icons/bridge.gif").createImage();
			}
			return AbstractUIPlugin.imageDescriptorFromPlugin("org.eclipse.emf.ecore.edit", "icons/full/obj16/EClass.gif").createImage();	
		}
		else if (element instanceof EDataType) {
			return AbstractUIPlugin.imageDescriptorFromPlugin("org.eclipse.emf.ecore.edit", "icons/full/obj16/EDataType.gif").createImage();
		}
		else if (element instanceof EAttribute) {
			return AbstractUIPlugin.imageDescriptorFromPlugin("org.eclipse.emf.ecore.edit", "icons/full/obj16/EAttribute.gif").createImage();
		}
		else if (element instanceof EOperation) {
			return AbstractUIPlugin.imageDescriptorFromPlugin("org.eclipse.emf.ecore.edit", "icons/full/obj16/EOperation.gif").createImage();
		}
		else if (element instanceof EReference) {
			EReference eReference = (EReference) element;
			if (BridgeSupport.isBridgeEnd(eReference)) {
				return AbstractUIPlugin.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "icons/bridgeEnd.gif").createImage();
			}
			return AbstractUIPlugin.imageDescriptorFromPlugin("org.eclipse.emf.ecore.edit", "icons/full/obj16/EReference.gif").createImage();
		}
		else if (element instanceof BridgeEndDescriptor) {
			return AbstractUIPlugin.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "icons/bridgeFeature.gif").createImage();			
		}
		else if (element instanceof SubTypesDescriptor) {
			return AbstractUIPlugin.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "icons/subtypes.png").createImage();			
		}
		else if (element instanceof SuperTypesDescriptor) {
			return AbstractUIPlugin.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "icons/supertypes.png").createImage();			
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
			if (view.isShowOppositeReference() && sf instanceof EReference) {
				EReference opposite = ((EReference) sf).getEOpposite();
				if (opposite != null) {
					signature = signature + "#" + opposite.getName();
				}
			}
			if (sf.isMany()) {
				signature = signature + " [*]";
			}
			return signature;
		}
		else if (element instanceof EOperation) {
			EOperation eOperation = (EOperation) element;
			String signature = eOperation.getName() + "(";
			ListIterator<EParameter> li = eOperation.getEParameters().listIterator();
			while (li.hasNext()) {
				EParameter parameter = (EParameter) li.next();
				signature = signature + parameter.getName() + ":" + getTypeName(parameter.getEType());
				if (li.hasNext()) signature = signature + ", ";
			}
			signature = signature + ")";
			signature = signature + " : " + getTypeName(eOperation.getEType());
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
	
	protected String getTypeName(EClassifier classifier) {
		if (classifier == null) {
			return "void";
		}
		else {
			return classifier.getName();
		}
	}
	
	public Color getBackground(Object element) {
		return null;
	}

	public Color getForeground(Object element) {
		return null;
	}

	public Font getFont(Object element) {
		FontRegistry reg = JFaceResources.getFontRegistry();
		if (element instanceof EClass) {
			EClass eClass = (EClass) element;
			if (eClass.isAbstract()) {
				return reg.getItalic("");
			}
		}
		if (element instanceof EReference) {
			EReference eReference = (EReference) element;
			if (eReference.isContainment()) {
				return reg.getBold("");
			}
		}
		if (element instanceof EStructuralFeature) {
			EStructuralFeature eStructuralFeature = (EStructuralFeature) element;
			if (eStructuralFeature.isDerived()) {
				return reg.getItalic("");
			}
		}
		return null;
	}
	
	
}
 