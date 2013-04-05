/**
 */
package org.eclipse.epsilon.eugenia.examples.scl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Component</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.epsilon.eugenia.examples.scl.Component#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.epsilon.eugenia.examples.scl.Component#getSubcomponents <em>Subcomponents</em>}</li>
 *   <li>{@link org.eclipse.epsilon.eugenia.examples.scl.Component#getPorts <em>Ports</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.epsilon.eugenia.examples.scl.SclPackage#getComponent()
 * @model annotation="gmf.node label='name' color='232,232,232'"
 * @generated
 */
public interface Component extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.eclipse.epsilon.eugenia.examples.scl.SclPackage#getComponent_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.eclipse.epsilon.eugenia.examples.scl.Component#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Subcomponents</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.epsilon.eugenia.examples.scl.Component}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Subcomponents</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Subcomponents</em>' containment reference list.
   * @see org.eclipse.epsilon.eugenia.examples.scl.SclPackage#getComponent_Subcomponents()
   * @model containment="true"
   *        annotation="gmf.compartment layout='free'"
   * @generated
   */
  EList<Component> getSubcomponents();

  /**
   * Returns the value of the '<em><b>Ports</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.epsilon.eugenia.examples.scl.Port}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Ports</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ports</em>' containment reference list.
   * @see org.eclipse.epsilon.eugenia.examples.scl.SclPackage#getComponent_Ports()
   * @model containment="true"
   * @generated
   */
  EList<Port> getPorts();

} // Component
