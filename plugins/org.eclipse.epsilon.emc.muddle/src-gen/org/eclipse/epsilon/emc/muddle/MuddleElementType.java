/**
 */
package org.eclipse.epsilon.emc.muddle;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Element Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.epsilon.emc.muddle.MuddleElementType#getInstances <em>Instances</em>}</li>
 *   <li>{@link org.eclipse.epsilon.emc.muddle.MuddleElementType#getFeatures <em>Features</em>}</li>
 *   <li>{@link org.eclipse.epsilon.emc.muddle.MuddleElementType#getSuperTypes <em>Super Types</em>}</li>
 *   <li>{@link org.eclipse.epsilon.emc.muddle.MuddleElementType#getSubTypes <em>Sub Types</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.epsilon.emc.muddle.MuddlePackage#getMuddleElementType()
 * @model
 * @generated
 */
public interface MuddleElementType extends Type {
	/**
	 * Returns the value of the '<em><b>Instances</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.epsilon.emc.muddle.MuddleElement}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.epsilon.emc.muddle.MuddleElement#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Instances</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Instances</em>' reference list.
	 * @see org.eclipse.epsilon.emc.muddle.MuddlePackage#getMuddleElementType_Instances()
	 * @see org.eclipse.epsilon.emc.muddle.MuddleElement#getType
	 * @model opposite="type"
	 * @generated
	 */
	EList<MuddleElement> getInstances();

	/**
	 * Returns the value of the '<em><b>Features</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.epsilon.emc.muddle.Feature}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.epsilon.emc.muddle.Feature#getOwningType <em>Owning Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Features</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Features</em>' containment reference list.
	 * @see org.eclipse.epsilon.emc.muddle.MuddlePackage#getMuddleElementType_Features()
	 * @see org.eclipse.epsilon.emc.muddle.Feature#getOwningType
	 * @model opposite="owningType" containment="true"
	 * @generated
	 */
	EList<Feature> getFeatures();

	/**
	 * Returns the value of the '<em><b>Super Types</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.epsilon.emc.muddle.MuddleElementType}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.epsilon.emc.muddle.MuddleElementType#getSubTypes <em>Sub Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Super Types</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Super Types</em>' reference list.
	 * @see org.eclipse.epsilon.emc.muddle.MuddlePackage#getMuddleElementType_SuperTypes()
	 * @see org.eclipse.epsilon.emc.muddle.MuddleElementType#getSubTypes
	 * @model opposite="subTypes"
	 * @generated
	 */
	EList<MuddleElementType> getSuperTypes();

	/**
	 * Returns the value of the '<em><b>Sub Types</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.epsilon.emc.muddle.MuddleElementType}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.epsilon.emc.muddle.MuddleElementType#getSuperTypes <em>Super Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sub Types</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub Types</em>' reference list.
	 * @see org.eclipse.epsilon.emc.muddle.MuddlePackage#getMuddleElementType_SubTypes()
	 * @see org.eclipse.epsilon.emc.muddle.MuddleElementType#getSuperTypes
	 * @model opposite="superTypes"
	 * @generated
	 */
	EList<MuddleElementType> getSubTypes();

} // MuddleElementType
