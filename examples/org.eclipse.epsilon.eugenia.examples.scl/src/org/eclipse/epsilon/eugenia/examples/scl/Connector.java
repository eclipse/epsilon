/**
 */
package org.eclipse.epsilon.eugenia.examples.scl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Connector</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.epsilon.eugenia.examples.scl.Connector#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.epsilon.eugenia.examples.scl.Connector#getFrom <em>From</em>}</li>
 *   <li>{@link org.eclipse.epsilon.eugenia.examples.scl.Connector#getTo <em>To</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.epsilon.eugenia.examples.scl.SclPackage#getConnector()
 * @model annotation="gmf.link source='from' target='to' label='name' target.decoration='arrow'"
 * @generated
 */
public interface Connector extends EObject
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
   * @see org.eclipse.epsilon.eugenia.examples.scl.SclPackage#getConnector_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.eclipse.epsilon.eugenia.examples.scl.Connector#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>From</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link org.eclipse.epsilon.eugenia.examples.scl.Port#getOutgoing <em>Outgoing</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>From</em>' container reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>From</em>' container reference.
   * @see #setFrom(Port)
   * @see org.eclipse.epsilon.eugenia.examples.scl.SclPackage#getConnector_From()
   * @see org.eclipse.epsilon.eugenia.examples.scl.Port#getOutgoing
   * @model opposite="outgoing" transient="false"
   * @generated
   */
  Port getFrom();

  /**
   * Sets the value of the '{@link org.eclipse.epsilon.eugenia.examples.scl.Connector#getFrom <em>From</em>}' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>From</em>' container reference.
   * @see #getFrom()
   * @generated
   */
  void setFrom(Port value);

  /**
   * Returns the value of the '<em><b>To</b></em>' reference.
   * It is bidirectional and its opposite is '{@link org.eclipse.epsilon.eugenia.examples.scl.Port#getIncoming <em>Incoming</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>To</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>To</em>' reference.
   * @see #setTo(Port)
   * @see org.eclipse.epsilon.eugenia.examples.scl.SclPackage#getConnector_To()
   * @see org.eclipse.epsilon.eugenia.examples.scl.Port#getIncoming
   * @model opposite="incoming"
   * @generated
   */
  Port getTo();

  /**
   * Sets the value of the '{@link org.eclipse.epsilon.eugenia.examples.scl.Connector#getTo <em>To</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>To</em>' reference.
   * @see #getTo()
   * @generated
   */
  void setTo(Port value);

} // Connector
