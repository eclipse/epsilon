/**
 */
package esm;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Transition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link esm.Transition#getAction <em>Action</em>}</li>
 *   <li>{@link esm.Transition#getActionImpl <em>Action Impl</em>}</li>
 *   <li>{@link esm.Transition#getSource <em>Source</em>}</li>
 *   <li>{@link esm.Transition#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @see esm.EsmPackage#getTransition()
 * @model annotation="gmf.link source='source' target='target' target.decoration='arrow' label='action'"
 * @generated
 */
public interface Transition extends EObject
{
  /**
   * Returns the value of the '<em><b>Action</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Action</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Action</em>' attribute.
   * @see #setAction(String)
   * @see esm.EsmPackage#getTransition_Action()
   * @model
   * @generated
   */
  String getAction();

  /**
   * Sets the value of the '{@link esm.Transition#getAction <em>Action</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Action</em>' attribute.
   * @see #getAction()
   * @generated
   */
  void setAction(String value);

  /**
   * Returns the value of the '<em><b>Action Impl</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Action Impl</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Action Impl</em>' containment reference.
   * @see #setActionImpl(EObject)
   * @see esm.EsmPackage#getTransition_ActionImpl()
   * @model containment="true"
   * @generated
   */
  EObject getActionImpl();

  /**
   * Sets the value of the '{@link esm.Transition#getActionImpl <em>Action Impl</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Action Impl</em>' containment reference.
   * @see #getActionImpl()
   * @generated
   */
  void setActionImpl(EObject value);

  /**
   * Returns the value of the '<em><b>Source</b></em>' reference.
   * It is bidirectional and its opposite is '{@link esm.State#getOutgoing <em>Outgoing</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Source</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Source</em>' reference.
   * @see #setSource(State)
   * @see esm.EsmPackage#getTransition_Source()
   * @see esm.State#getOutgoing
   * @model opposite="outgoing" required="true"
   * @generated
   */
  State getSource();

  /**
   * Sets the value of the '{@link esm.Transition#getSource <em>Source</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Source</em>' reference.
   * @see #getSource()
   * @generated
   */
  void setSource(State value);

  /**
   * Returns the value of the '<em><b>Target</b></em>' reference.
   * It is bidirectional and its opposite is '{@link esm.State#getIncoming <em>Incoming</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Target</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Target</em>' reference.
   * @see #setTarget(State)
   * @see esm.EsmPackage#getTransition_Target()
   * @see esm.State#getIncoming
   * @model opposite="incoming" required="true"
   * @generated
   */
  State getTarget();

  /**
   * Sets the value of the '{@link esm.Transition#getTarget <em>Target</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Target</em>' reference.
   * @see #getTarget()
   * @generated
   */
  void setTarget(State value);

} // Transition
