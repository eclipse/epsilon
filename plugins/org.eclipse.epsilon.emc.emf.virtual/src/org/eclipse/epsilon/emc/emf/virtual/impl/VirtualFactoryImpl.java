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
 * $Id: VirtualFactoryImpl.java,v 1.2 2008/07/30 11:13:02 dkolovos Exp $
 */
package org.eclipse.epsilon.emc.emf.virtual.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.epsilon.emc.emf.virtual.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class VirtualFactoryImpl extends EFactoryImpl implements VirtualFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static VirtualFactory init() {
		try {
			VirtualFactory theVirtualFactory = (VirtualFactory)EPackage.Registry.INSTANCE.getEFactory("virtualEmf"); 
			if (theVirtualFactory != null) {
				return theVirtualFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new VirtualFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VirtualFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case VirtualPackage.VIRTUAL_MODEL: return createVirtualModel();
			case VirtualPackage.VIRTUAL_OBJECT: return createVirtualObject();
			case VirtualPackage.STRING_SLOT: return createStringSlot();
			case VirtualPackage.INTEGER_SLOT: return createIntegerSlot();
			case VirtualPackage.BOOLEAN_SLOT: return createBooleanSlot();
			case VirtualPackage.FLOAT_SLOT: return createFloatSlot();
			case VirtualPackage.REFERENCE_SLOT: return createReferenceSlot();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VirtualModel createVirtualModel() {
		VirtualModelImpl virtualModel = new VirtualModelImpl();
		return virtualModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VirtualObject createVirtualObject() {
		VirtualObjectImpl virtualObject = new VirtualObjectImpl();
		return virtualObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringSlot createStringSlot() {
		StringSlotImpl stringSlot = new StringSlotImpl();
		return stringSlot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntegerSlot createIntegerSlot() {
		IntegerSlotImpl integerSlot = new IntegerSlotImpl();
		return integerSlot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BooleanSlot createBooleanSlot() {
		BooleanSlotImpl booleanSlot = new BooleanSlotImpl();
		return booleanSlot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FloatSlot createFloatSlot() {
		FloatSlotImpl floatSlot = new FloatSlotImpl();
		return floatSlot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReferenceSlot createReferenceSlot() {
		ReferenceSlotImpl referenceSlot = new ReferenceSlotImpl();
		return referenceSlot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VirtualPackage getVirtualPackage() {
		return (VirtualPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static VirtualPackage getPackage() {
		return VirtualPackage.eINSTANCE;
	}

} //VirtualFactoryImpl
