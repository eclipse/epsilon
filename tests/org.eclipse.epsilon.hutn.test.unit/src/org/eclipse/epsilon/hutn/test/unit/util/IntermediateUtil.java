/**
 * *******************************************************************************
 * Copyright (c) 2008 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 * ******************************************************************************
 *
 * $Id: IntermediateUtil.java,v 1.4 2008/08/08 17:19:01 louis Exp $
 */
package org.eclipse.epsilon.hutn.test.unit.util;

import java.util.Arrays;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.epsilon.emc.emf.EmfUtil;
import org.eclipse.epsilon.hutn.model.hutn.AttributeSlot;
import org.eclipse.epsilon.hutn.model.hutn.ClassObject;
import org.eclipse.epsilon.hutn.model.hutn.ContainmentSlot;
import org.eclipse.epsilon.hutn.model.hutn.HutnFactory;
import org.eclipse.epsilon.hutn.model.hutn.NsUri;
import org.eclipse.epsilon.hutn.model.hutn.PackageObject;
import org.eclipse.epsilon.hutn.model.hutn.ReferenceSlot;
import org.eclipse.epsilon.hutn.model.hutn.Slot;
import org.eclipse.epsilon.hutn.model.hutn.Spec;

public abstract class IntermediateUtil {

	private IntermediateUtil() {}
	
	public static AttributeSlot createAttributeSlot(String feature, Object... values) {
		final AttributeSlot slot = HutnFactory.eINSTANCE.createAttributeSlot();
		slot.setFeature(feature);
		
		slot.getValues().addAll(Arrays.asList(values));
		
		return slot;
	}
	
	public static ContainmentSlot createContainmentSlot(String feature, ClassObject... values) {
		final ContainmentSlot slot = HutnFactory.eINSTANCE.createContainmentSlot();
		slot.setFeature(feature);
		
		slot.getValues().addAll(Arrays.asList(values));
		
		return slot;
	}
	
	public static ReferenceSlot createReferenceSlot(String feature, String... values) {
		final ReferenceSlot slot = HutnFactory.eINSTANCE.createReferenceSlot();
		slot.setFeature(feature);
		
		slot.getValues().addAll(Arrays.asList(values));
		
		return slot;
	}
	
	public static ClassObject createClass(String identifier, String type, Slot<?>... slots) {
		return createClass(identifier, type, 0, 0, slots);
	}
	
	public static ClassObject createClass(String identifier, String type, int line, int column, Slot<?>... slots) {
		final ClassObject cls = HutnFactory.eINSTANCE.createClassObject();
		cls.setIdentifier(identifier);
		cls.setType(type);
		cls.setLine(line);
		cls.setCol(column);
		
		for (Slot<?> slot : slots)
			cls.getSlots().add(slot);
		
		return cls;
	}
	
	public static PackageObject createPackage(ClassObject... classes) {
		final PackageObject pkg = HutnFactory.eINSTANCE.createPackageObject();
		
		for (ClassObject cls : classes) {
			pkg.getClassObjects().add(cls);
		}
		
		return pkg;
	}
	
	public static Spec createSpec(PackageObject... packages) {
		return createSpec(null, packages);
	}
	
	public static Spec createSpec(String nsUri, PackageObject... packages) {
		final Spec spec = HutnFactory.eINSTANCE.createSpec();
		EmfUtil.createResource(spec);
		
		if (nsUri != null) {
			final NsUri uri = HutnFactory.eINSTANCE.createNsUri();
			uri.setValue(nsUri);
			spec.getNsUris().add(uri);
		}
		
		for (PackageObject pkg : packages) {
			spec.getObjects().add(pkg);
			pkg.getMetamodel().add(EPackage.Registry.INSTANCE.getEPackage(nsUri));
		}
		
		return spec;
	}
}
