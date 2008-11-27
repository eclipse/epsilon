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
package org.eclipse.epsilon.emc.emf.bridge;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.epsilon.emc.emf.EmfPropertyGetter;
import org.eclipse.epsilon.emc.emf.EmfPropertySetter;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.introspection.IPropertyGetter;
import org.eclipse.epsilon.eol.execute.introspection.IPropertySetter;

public class BridgeEmfModel extends EmfModel { 
	
	EObject bridge = null;
	BridgeDescriptor bridgeDescriptor = null;
	
	List<BridgeDescriptor> bridgeDescriptors;
	
	protected List<EClass> getBridgeEClasses(Collection<EPackage> ePackages) {
		List<EClass> bridgeEClasses = new ArrayList<EClass>();
		for (EPackage ePackage :ePackages) {
			for (EClassifier eClassifier : ePackage.getEClassifiers()) {
				if (eClassifier instanceof EClass) {
					EClass eClass = (EClass) eClassifier;
					if (isBridge(eClass)) {
						bridgeEClasses.add(eClass);
					}
				}
			}
			bridgeEClasses.addAll(getBridgeEClasses(ePackage.getESubpackages()));
		}
		return bridgeEClasses;
	}
	
	protected List<BridgeDescriptor> getBridgeDescriptors() {
		
		if (bridgeDescriptors == null) {
			bridgeDescriptors = new ArrayList<BridgeDescriptor>();
			
			List<EClass> bridgeEClasses = getBridgeEClasses(packages);
			
			for (EClass bridgeEClass : bridgeEClasses) {
				for (EReference bridgeEnd : bridgeEClass.getEAllReferences()) {
					if (isBridgeEnd(bridgeEnd)) {
						BridgeDescriptor bridgeDescriptor = new BridgeDescriptor();
						bridgeDescriptor.setEClass(bridgeEClass);
						bridgeDescriptor.setEReference(bridgeEnd);
						bridgeDescriptors.add(bridgeDescriptor);
					}
				}
			}
			
		}
		
		return bridgeDescriptors;
		
	}
	
	@Override
	public boolean knowsAboutProperty(Object instance, String property) {
		
		//If it is not an EObject don't look any further
		if (!(instance instanceof EObject)) return false;
		
		//If it is a model element of the bridge model return true
		if (super.owns(instance)) {
			bridge = (EObject) instance; 
			return true;
		}
		
		// Look for a suitable bridge descriptor
		this.bridgeDescriptor = null;
		for (BridgeDescriptor bridgeDescriptor : getBridgeDescriptors()) {
			if (bridgeDescriptor.bridges((EObject) instance, property)) {
				this.bridgeDescriptor = bridgeDescriptor;
				break;
			}
		}
		
		if (this.bridgeDescriptor == null) return false;
		
		// If we find the descriptor, 
		// also cache the 
		// actual bridge
		
		Collection<EObject> candidateBridges = new ArrayList<EObject>();
		try {
			candidateBridges = getAllOfKind(getFullyQualifiedName(bridgeDescriptor.getEClass()));
		}
		catch (Exception ex) {
			
		}
		
		for (EObject candidateBridge : candidateBridges) {
			if (isBridgeTo(candidateBridge, instance, bridgeDescriptor.getEReference())) {
				bridge = candidateBridge;
				return true;
			}
		}
		
		// No bridge found but if we have reached here
		// it means that we have found a bridge descriptor
		// at least
		bridge = null;
		return true;
		
	}
	
	protected boolean isBridge(EClass e) {
		if (e.getEAnnotation("bridge") != null) {
			return true;
		}
		else {
			for (EClass supertype : e.getESuperTypes()) {
				if (isBridge(supertype)) {
					return true;
				}
			}
		}
		return false;
	}
	
	protected boolean isBridgeEnd(EReference e) {
		return e.getEAnnotation("bridge.end") != null;
	}
	
	@SuppressWarnings("unchecked")
	protected boolean isBridgeTo(EObject candidateBridge, Object target, EReference eReference) {
		
		//if (!isBridge(candidateBridge.eClass())) return false;
			
		if (eReference.isMany()) {
			if (((Collection<Object>)candidateBridge.eGet(eReference)).contains(target)) {
				return true;
			}
		}
		else {
			if (candidateBridge.eGet(eReference) == target) {
				return true;
			}
		}
		
		return false;
	}
	
	@Override
	public IPropertyGetter getPropertyGetter() {
		return new BridgeEmfPropertyGetter();
	}
	
	@Override
	public IPropertySetter getPropertySetter() {
		return new BridgeEmfPropertySetter();
	}
	
	class BridgeEmfPropertyGetter extends EmfPropertyGetter {
		@Override
		public Object invoke(Object object, String property)
				throws EolRuntimeException {
			if (bridge == null) {
				if (bridgeDescriptor.getLastValueFeature().isMany()) {
					return new ArrayList<Object>();
				}
				else {
					return bridgeDescriptor.getLastValueFeature()
						.getDefaultValue();
				}
			}
			else {
				return super.invoke(bridge, property);
			}
		}
	}
	
	class BridgeEmfPropertySetter extends EmfPropertySetter {

		@Override
		public void invoke(Object value) throws EolRuntimeException {
			if (bridge != null) {
				this.object = bridge;
				super.invoke(value);
			}
			else {
				throw new EolRuntimeException("Cannot set the value of feature " + this.property + " as the bridge object does not exist");
			}
		}
		
	}
	
}
 
