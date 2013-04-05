/**
 */
package org.eclipse.epsilon.eugenia.examples.scl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Port</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.epsilon.eugenia.examples.scl.Port#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.epsilon.eugenia.examples.scl.Port#getOutgoing <em>Outgoing</em>}</li>
 *   <li>{@link org.eclipse.epsilon.eugenia.examples.scl.Port#getIncoming <em>Incoming</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.epsilon.eugenia.examples.scl.SclPackage#getPort()
 * @model annotation="gmf.node figure='ellipse' size='15,15' label.icon='false' label.placement='external' label='name'"
 * @generated
 */
public interface Port extends EObject
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
   * @see org.eclipse.epsilon.eugenia.examples.scl.SclPackage#getPort_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.eclipse.epsilon.eugenia.examples.scl.Port#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Outgoing</b></em>' containment reference.
   * It is bidirectional and its opposite is '{@link org.eclipse.epsilon.eugenia.examples.scl.Connector#getFrom <em>From</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Outgoing</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Outgoing</em>' containment reference.
   * @see #setOutgoing(Connector)
   * @see org.eclipse.epsilon.eugenia.examples.scl.SclPackage#getPort_Outgoing()
   * @see org.eclipse.epsilon.eugenia.examples.scl.Connector#getFrom
   * @model opposite="from" containment="true"
   * @generated
   */
  Connector getOutgoing();

  /**
   * Sets the value of the '{@link org.eclipse.epsilon.eugenia.examples.scl.Port#getOutgoing <em>Outgoing</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Outgoing</em>' containment reference.
   * @see #getOutgoing()
   * @generated
   */
  void setOutgoing(Connector value);

  /**
   * Returns the value of the '<em><b>Incoming</b></em>' reference.
   * It is bidirectional and its opposite is '{@link org.eclipse.epsilon.eugenia.examples.scl.Connector#getTo <em>To</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Incoming</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Incoming</em>' reference.
   * @see #setIncoming(Connector)
   * @see org.eclipse.epsilon.eugenia.examples.scl.SclPackage#getPort_Incoming()
   * @see org.eclipse.epsilon.eugenia.examples.scl.Connector#getTo
   * @model opposite="to"
   * @generated
   */
  Connector getIncoming();

  /**
   * Sets the value of the '{@link org.eclipse.epsilon.eugenia.examples.scl.Port#getIncoming <em>Incoming</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Incoming</em>' reference.
   * @see #getIncoming()
   * @generated
   */
  void setIncoming(Connector value);

} // Port
