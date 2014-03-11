/**
 */
package org.eclipse.epsilon.emc.muddle;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Muddle</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.epsilon.emc.muddle.Muddle#getTypes <em>Types</em>}</li>
 *   <li>{@link org.eclipse.epsilon.emc.muddle.Muddle#getElements <em>Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.epsilon.emc.muddle.MuddlePackage#getMuddle()
 * @model
 * @generated
 */
public interface Muddle extends EObject {
	/**
	 * Returns the value of the '<em><b>Types</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.epsilon.emc.muddle.Type}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Types</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Types</em>' containment reference list.
	 * @see org.eclipse.epsilon.emc.muddle.MuddlePackage#getMuddle_Types()
	 * @model containment="true"
	 * @generated
	 */
	EList<Type> getTypes();

	/**
	 * Returns the value of the '<em><b>Elements</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.epsilon.emc.muddle.MuddleElement}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.epsilon.emc.muddle.MuddleElement#getMuddle <em>Muddle</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Elements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Elements</em>' containment reference list.
	 * @see org.eclipse.epsilon.emc.muddle.MuddlePackage#getMuddle_Elements()
	 * @see org.eclipse.epsilon.emc.muddle.MuddleElement#getMuddle
	 * @model opposite="muddle" containment="true"
	 * @generated
	 */
	EList<MuddleElement> getElements();

} // Muddle
