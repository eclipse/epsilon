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

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;

public class BridgeSupport {
	
	public static boolean isBridge(EClass eClass) {
		if (eClass.getEAnnotation("bridge") != null) return true;
		for (EClass superType : eClass.getEAllSuperTypes()) {
			if (isBridge(superType)) return true;
		}
		return false;
	}
	
	public static boolean isBridgeEnd(EStructuralFeature eStructuralFeature) {
		return eStructuralFeature.getEAnnotation("bridge.end") != null;
	}
	
	protected static boolean isSubtypeOf(EClass subtype, EClassifier supertype) {
		if (subtype == supertype || subtype.getName().equalsIgnoreCase(supertype.getName())) return true;
		if (subtype.getEAllSuperTypes().contains(supertype)) {
			return true;
		}
		return false;
	}
	
	public static Set<BridgeEndDescriptor> getBridgeEnds(EClass eClass, List<EPackage> ePackages) {
			
			Set<BridgeEndDescriptor> bridgeEnds = new HashSet<BridgeEndDescriptor>();
			
			for (EPackage p : ePackages) {
				for (EClassifier o : p.getEClassifiers()) {
					if (o instanceof EClass) {
						EClass bridge = (EClass) o;
						if (isBridge(bridge)) {
							for (EStructuralFeature bridgeEnd : bridge.getEStructuralFeatures()) {
								if (eClass.getName().equalsIgnoreCase("ControlFlow") && bridgeEnd.getName().equalsIgnoreCase("probability")) {
									System.err.println("Somewhere");
									System.err.println(isBridgeEnd(bridgeEnd));
								}
								if (isBridgeEnd(bridgeEnd) && isSubtypeOf(eClass, bridgeEnd.getEType())) {
									for (EStructuralFeature sf : bridge.getEAllStructuralFeatures()) {
										if (sf != bridgeEnd) {
											bridgeEnds.add(new BridgeEndDescriptor(sf));
										}
									}
								}
							}
						}
					}
				}
			}
			
			System.err.println(bridgeEnds);
			
			return bridgeEnds;
			
		}
}
 