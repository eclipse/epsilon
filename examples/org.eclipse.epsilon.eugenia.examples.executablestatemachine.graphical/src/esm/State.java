/**
 */
package esm;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link esm.State#getName <em>Name</em>}</li>
 *   <li>{@link esm.State#getIncoming <em>Incoming</em>}</li>
 *   <li>{@link esm.State#getOutgoing <em>Outgoing</em>}</li>
 * </ul>
 * </p>
 *
 * @see esm.EsmPackage#getState()
 * @model annotation="gmf.node figure='ellipse' label='name' label.placement='external' label.icon='false'"
 * @generated
 */
public interface State extends EObject
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
   * @see esm.EsmPackage#getState_Name()
   * @model required="true"
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link esm.State#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Incoming</b></em>' reference list.
   * The list contents are of type {@link esm.Transition}.
   * It is bidirectional and its opposite is '{@link esm.Transition#getTarget <em>Target</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Incoming</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Incoming</em>' reference list.
   * @see esm.EsmPackage#getState_Incoming()
   * @see esm.Transition#getTarget
   * @model opposite="target"
   * @generated
   */
  EList<Transition> getIncoming();

  /**
   * Returns the value of the '<em><b>Outgoing</b></em>' reference list.
   * The list contents are of type {@link esm.Transition}.
   * It is bidirectional and its opposite is '{@link esm.Transition#getSource <em>Source</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Outgoing</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Outgoing</em>' reference list.
   * @see esm.EsmPackage#getState_Outgoing()
   * @see esm.Transition#getSource
   * @model opposite="source"
   * @generated
   */
  EList<Transition> getOutgoing();

} // State
