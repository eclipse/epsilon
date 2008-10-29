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
 * $Id: HutnSwitch.java,v 1.4 2008/08/15 10:05:57 dkolovos Exp $
 */
package org.eclipse.epsilon.hutn.model.hutn.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.epsilon.hutn.model.hutn.BooleanSlot;
import org.eclipse.epsilon.hutn.model.hutn.ClassObject;
import org.eclipse.epsilon.hutn.model.hutn.ClassObjectContainer;
import org.eclipse.epsilon.hutn.model.hutn.ContainmentSlot;
import org.eclipse.epsilon.hutn.model.hutn.EnumSlot;
import org.eclipse.epsilon.hutn.model.hutn.FloatSlot;
import org.eclipse.epsilon.hutn.model.hutn.HutnPackage;
import org.eclipse.epsilon.hutn.model.hutn.IntegerSlot;
import org.eclipse.epsilon.hutn.model.hutn.ModelElement;
import org.eclipse.epsilon.hutn.model.hutn.NsUri;
import org.eclipse.epsilon.hutn.model.hutn.NullSlot;
import org.eclipse.epsilon.hutn.model.hutn.PackageObject;
import org.eclipse.epsilon.hutn.model.hutn.ReferenceSlot;
import org.eclipse.epsilon.hutn.model.hutn.Slot;
import org.eclipse.epsilon.hutn.model.hutn.Spec;
import org.eclipse.epsilon.hutn.model.hutn.StringSlot;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipse.epsilon.hutn.model.hutn.HutnPackage
 * @generated
 */
public class HutnSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static HutnPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HutnSwitch() {
		if (modelPackage == null) {
			modelPackage = HutnPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public T doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch(eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case HutnPackage.SPEC: {
				Spec spec = (Spec)theEObject;
				T result = caseSpec(spec);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HutnPackage.NS_URI: {
				NsUri nsUri = (NsUri)theEObject;
				T result = caseNsUri(nsUri);
				if (result == null) result = caseModelElement(nsUri);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HutnPackage.MODEL_ELEMENT: {
				ModelElement modelElement = (ModelElement)theEObject;
				T result = caseModelElement(modelElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HutnPackage.OBJECT: {
				org.eclipse.epsilon.hutn.model.hutn.Object object = (org.eclipse.epsilon.hutn.model.hutn.Object)theEObject;
				T result = caseObject(object);
				if (result == null) result = caseModelElement(object);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HutnPackage.PACKAGE_OBJECT: {
				PackageObject packageObject = (PackageObject)theEObject;
				T result = casePackageObject(packageObject);
				if (result == null) result = caseObject(packageObject);
				if (result == null) result = caseClassObjectContainer(packageObject);
				if (result == null) result = caseModelElement(packageObject);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HutnPackage.CLASS_OBJECT: {
				ClassObject classObject = (ClassObject)theEObject;
				T result = caseClassObject(classObject);
				if (result == null) result = caseObject(classObject);
				if (result == null) result = caseModelElement(classObject);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HutnPackage.SLOT: {
				Slot slot = (Slot)theEObject;
				T result = caseSlot(slot);
				if (result == null) result = caseModelElement(slot);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HutnPackage.STRING_SLOT: {
				StringSlot stringSlot = (StringSlot)theEObject;
				T result = caseStringSlot(stringSlot);
				if (result == null) result = caseSlot(stringSlot);
				if (result == null) result = caseModelElement(stringSlot);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HutnPackage.BOOLEAN_SLOT: {
				BooleanSlot booleanSlot = (BooleanSlot)theEObject;
				T result = caseBooleanSlot(booleanSlot);
				if (result == null) result = caseSlot(booleanSlot);
				if (result == null) result = caseModelElement(booleanSlot);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HutnPackage.INTEGER_SLOT: {
				IntegerSlot integerSlot = (IntegerSlot)theEObject;
				T result = caseIntegerSlot(integerSlot);
				if (result == null) result = caseSlot(integerSlot);
				if (result == null) result = caseModelElement(integerSlot);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HutnPackage.FLOAT_SLOT: {
				FloatSlot floatSlot = (FloatSlot)theEObject;
				T result = caseFloatSlot(floatSlot);
				if (result == null) result = caseSlot(floatSlot);
				if (result == null) result = caseModelElement(floatSlot);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HutnPackage.NULL_SLOT: {
				NullSlot nullSlot = (NullSlot)theEObject;
				T result = caseNullSlot(nullSlot);
				if (result == null) result = caseSlot(nullSlot);
				if (result == null) result = caseModelElement(nullSlot);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HutnPackage.CONTAINMENT_SLOT: {
				ContainmentSlot containmentSlot = (ContainmentSlot)theEObject;
				T result = caseContainmentSlot(containmentSlot);
				if (result == null) result = caseSlot(containmentSlot);
				if (result == null) result = caseClassObjectContainer(containmentSlot);
				if (result == null) result = caseModelElement(containmentSlot);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HutnPackage.REFERENCE_SLOT: {
				ReferenceSlot referenceSlot = (ReferenceSlot)theEObject;
				T result = caseReferenceSlot(referenceSlot);
				if (result == null) result = caseSlot(referenceSlot);
				if (result == null) result = caseModelElement(referenceSlot);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HutnPackage.ENUM_SLOT: {
				EnumSlot enumSlot = (EnumSlot)theEObject;
				T result = caseEnumSlot(enumSlot);
				if (result == null) result = caseSlot(enumSlot);
				if (result == null) result = caseModelElement(enumSlot);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HutnPackage.CLASS_OBJECT_CONTAINER: {
				ClassObjectContainer classObjectContainer = (ClassObjectContainer)theEObject;
				T result = caseClassObjectContainer(classObjectContainer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Spec</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Spec</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSpec(Spec object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ns Uri</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ns Uri</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNsUri(NsUri object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModelElement(ModelElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Object</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Object</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseObject(org.eclipse.epsilon.hutn.model.hutn.Object object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Package Object</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Package Object</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePackageObject(PackageObject object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Class Object</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Class Object</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClassObject(ClassObject object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Slot</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Slot</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSlot(Slot object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>String Slot</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>String Slot</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStringSlot(StringSlot object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Boolean Slot</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Boolean Slot</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBooleanSlot(BooleanSlot object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Integer Slot</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Integer Slot</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIntegerSlot(IntegerSlot object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Float Slot</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Float Slot</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFloatSlot(FloatSlot object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Null Slot</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Null Slot</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNullSlot(NullSlot object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Containment Slot</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Containment Slot</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseContainmentSlot(ContainmentSlot object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Reference Slot</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Reference Slot</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReferenceSlot(ReferenceSlot object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Enum Slot</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Enum Slot</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEnumSlot(EnumSlot object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Class Object Container</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Class Object Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClassObjectContainer(ClassObjectContainer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public T defaultCase(EObject object) {
		return null;
	}

} //HutnSwitch
