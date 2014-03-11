/**
 */
package org.eclipse.epsilon.emc.muddle;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Slot</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.epsilon.emc.muddle.Slot#getValues <em>Values</em>}</li>
 *   <li>{@link org.eclipse.epsilon.emc.muddle.Slot#getFeature <em>Feature</em>}</li>
 *   <li>{@link org.eclipse.epsilon.emc.muddle.Slot#getOwningElement <em>Owning Element</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.epsilon.emc.muddle.MuddlePackage#getSlot()
 * @model
 * @generated
 */
public interface Slot extends EObject {
	/**
	 * Returns the value of the '<em><b>Values</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Object}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Values</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Values</em>' attribute list.
	 * @see org.eclipse.epsilon.emc.muddle.MuddlePackage#getSlot_Values()
	 * @model
	 * @generated
	 */
	EList<Object> getValues();

	/**
	 * Returns the value of the '<em><b>Feature</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.epsilon.emc.muddle.Feature#getSlots <em>Slots</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Feature</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Feature</em>' reference.
	 * @see #setFeature(Feature)
	 * @see org.eclipse.epsilon.emc.muddle.MuddlePackage#getSlot_Feature()
	 * @see org.eclipse.epsilon.emc.muddle.Feature#getSlots
	 * @model opposite="slots"
	 * @generated
	 */
	Feature getFeature();

	/**
	 * Sets the value of the '{@link org.eclipse.epsilon.emc.muddle.Slot#getFeature <em>Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Feature</em>' reference.
	 * @see #getFeature()
	 * @generated
	 */
	void setFeature(Feature value);

	/**
	 * Returns the value of the '<em><b>Owning Element</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.epsilon.emc.muddle.MuddleElement#getSlots <em>Slots</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owning Element</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owning Element</em>' container reference.
	 * @see #setOwningElement(MuddleElement)
	 * @see org.eclipse.epsilon.emc.muddle.MuddlePackage#getSlot_OwningElement()
	 * @see org.eclipse.epsilon.emc.muddle.MuddleElement#getSlots
	 * @model opposite="slots" transient="false"
	 * @generated
	 */
	MuddleElement getOwningElement();

	/**
	 * Sets the value of the '{@link org.eclipse.epsilon.emc.muddle.Slot#getOwningElement <em>Owning Element</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Element</em>' container reference.
	 * @see #getOwningElement()
	 * @generated
	 */
	void setOwningElement(MuddleElement value);

} // Slot
