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
package org.eclipse.epsilon.dt.exeed;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.util.EcoreUtil.UsageCrossReferencer;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ReflectiveItemProvider;
import org.eclipse.jface.resource.ImageDescriptor;

public class ExeedItemProvider extends ReflectiveItemProvider {

	protected ImageTextProvider imageTextProvider;
	protected ExeedPlugin plugin = null;
	
	@Override
	protected String getFeatureText(Object feature) {
		String def = super.getFeatureText(feature);
		if (feature instanceof EStructuralFeature) {
			return imageTextProvider.getEStructuralFeatureLabel((EStructuralFeature) feature, def);
		}
		return def;
	}
	
	public ExeedItemProvider(AdapterFactory arg0, ExeedPlugin plugin) {
		super(arg0);
		this.plugin = plugin;
	}

	@Override
	public Object getImage(Object arg0) {
		ImageDescriptor imageDescriptor = imageTextProvider.getEObjectImageDescriptor(arg0, null);
		if (imageDescriptor != null) {
			return imageDescriptor;
		} else {
			return super.getImage(arg0);
		}
	}

	@Override
	public String getText(Object arg0) {
		if (isCalledFromTreeViewer()) {
			return imageTextProvider.getEObjectLabel(arg0, super.getText(arg0), false);
		} else {
			return imageTextProvider.getEObjectReferenceLabel(arg0,
					imageTextProvider
							.getEObjectLabel(arg0, super.getText(arg0), false));
		}
	}

	public void setImageTextProvider(ImageTextProvider imageTextProvider) {
		this.imageTextProvider = imageTextProvider;
	}
	
	@Override
	public List getPropertyDescriptors(Object object) {
		
		itemPropertyDescriptors = new ArrayList();

		for (Iterator i = ((EObject) object).eClass()
				.getEAllStructuralFeatures().iterator(); i.hasNext();) {
			EStructuralFeature eFeature = (EStructuralFeature) i.next();
			if (!(eFeature instanceof EReference)
					|| !((EReference) eFeature).isContainment()) {
//				itemPropertyDescriptors.add(new ItemPropertyDescriptor(
				ItemPropertyDescriptor itemPropertyDescriptor = new ExeedItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory)
								.getRootAdapterFactory(),
								getFeatureText(eFeature),
								getResourceLocator().getString(
								"_UI_Property_description",
								new Object[] { getFeatureText(eFeature),
										eFeature.getEType().getName() }),
						eFeature, eFeature.isChangeable(),
						//ItemPropertyDescriptor.GENERIC_VALUE_IMAGE));
						getImageForEType(eFeature.getEType()),
						imageTextProvider);
				
				itemPropertyDescriptors.add(itemPropertyDescriptor);
				
			}
		}

		return itemPropertyDescriptors;
	}
	
	/*
	@Override
	public Collection<?> getChildren(Object object) {
		Collection children = super.getChildren(object);
		
		Collection toRemove = new ArrayList();
		
		for (Object child : children) {
			EObject eObject = (EObject) child;
			Collection<Setting> settings = 
				UsageCrossReferencer.find(eObject, eObject.eResource().getResourceSet());
			
			for (Setting setting : settings) {
				if (isNested(setting.getEStructuralFeature())) {
					toRemove.add(child);
				}
			}
			
		}
		
		children.removeAll(toRemove);
		
		EObject eObject = (EObject) object;
		
		for (EReference ref : eObject.eClass().getEAllReferences()) {
			if(isNested(ref)) {
				if (ref.isMany()) {
					children.addAll((Collection)eObject.eGet(ref));
				}
				else {
					children.add(eObject.eGet(ref));
				}
			}
		}
		
		return children;
	}
	*/
	protected boolean isNested(EStructuralFeature sf) {
		EAnnotation eAnnotation = sf.getEAnnotation("exeed");
		if (eAnnotation != null) {
			Object detailValue = eAnnotation.getDetails().get("nested");
			return detailValue != null;
		}
		return false;
	}
	
	/*
	@Override
	protected Collection<? extends EStructuralFeature> getChildrenFeatures(
			Object object) {
		ArrayList<EStructuralFeature> childrenFeatures = new ArrayList<EStructuralFeature>();
		childrenFeatures.addAll(super.getChildrenFeatures(object));
		
		EObject eObject = (EObject) object;
		for (EReference ref : eObject.eClass().getEAllReferences()) {
			EAnnotation eAnnotation = ref.getEAnnotation("exeed");
			if (eAnnotation != null) {
				Object detailValue = eAnnotation.getDetails().get("nested");
				if (detailValue != null) {
					childrenFeatures.add(ref);
				}
			}
		}
		return childrenFeatures;
	}
	*/
	
	protected Object getImageForEType(EClassifier eType) {
		if (eType instanceof EDataType) {
			if (eType.getName().equalsIgnoreCase("Integer")) {
				return ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE;
			} else if (eType.getName().equalsIgnoreCase("Boolean")) {
				return ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE;
			} else if (eType.getName().equalsIgnoreCase("String")) {
				return ItemPropertyDescriptor.TEXT_VALUE_IMAGE;
			} else if (eType.getName().equalsIgnoreCase("Real")) {
				return ItemPropertyDescriptor.REAL_VALUE_IMAGE;
			}
		}
		else {
			ImageDescriptor id = plugin.getImageDescriptor(ItemPropertyDescriptor.GENERIC_VALUE_IMAGE.toString());
			return imageTextProvider.getEClassImageDescriptor((EClass)eType, id);
		}
		return ItemPropertyDescriptor.GENERIC_VALUE_IMAGE;
	}

	protected boolean isCalledFromTreeViewer() {
		Exception ex = new Exception();
		StackTraceElement[] stackTrace = ex.getStackTrace();
		for (int i = 0; i < stackTrace.length; i++) {
			if (stackTrace[i].toString().indexOf("AbstractTreeViewer") > -1) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	protected void gatherMetaData(EModelElement eModelElement) {
		initializeCache();
		super.gatherMetaData(eModelElement);
	}
	
	protected void initializeCache() {
		// Override the initialization of super.gatherMetadata
		// to avoid double EClasses added by late discovery of extensions
		if (allRoots == null) {
			allRoots = new UniqueArrayList();
			allEClasses = new UniqueArrayList();
			allEPackages = new UniqueArrayList();
		}
	}
	
	public void loadRegisteredEPackage(String nsUri) {
		initializeCache();
		EPackage ePackage = (EPackage) EPackage.Registry.INSTANCE.get(nsUri); 
		if (!allEPackages.contains(ePackage)) {
			allEPackages.add(ePackage);
			ListIterator li = ePackage.getEClassifiers().listIterator();
			while (li.hasNext()) {
				Object next = li.next();
				if (!allEClasses.contains(next)) {
					allEClasses.add((EClass)next);
				}
			}
		}
	}


	
	/*
	public void unloadRegisteredEPackage(String nsUri) {
		initializeCache();
		EPackage ePackage = (EPackage) EPackage.Registry.INSTANCE.get(nsUri); 
		if (allEPackages.contains(ePackage)) {
			allEPackages.remove(ePackage);
			ListIterator li = ePackage.getEClassifiers().listIterator();
			while (li.hasNext()) {
				Object next = li.next();
				if (allEClasses.contains(next)) {
					allEClasses.remove((EClass)next);
				}
			}
		}
	}
	
	public List<EPackage> getEPackages() {
		return allEPackages;
	}
	*/
	
}
