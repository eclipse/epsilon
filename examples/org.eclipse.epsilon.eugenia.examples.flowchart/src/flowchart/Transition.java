/**
 */
package flowchart;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Transition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link flowchart.Transition#getName <em>Name</em>}</li>
 *   <li>{@link flowchart.Transition#getSource <em>Source</em>}</li>
 *   <li>{@link flowchart.Transition#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @see flowchart.FlowchartPackage#getTransition()
 * @model annotation="gmf.link label='name' source='source' target='target' target.decoration='arrow'"
 * @generated
 */
public interface Transition extends EObject
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
   * @see flowchart.FlowchartPackage#getTransition_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link flowchart.Transition#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Source</b></em>' reference.
   * It is bidirectional and its opposite is '{@link flowchart.Node#getOutgoing <em>Outgoing</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Source</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Source</em>' reference.
   * @see #setSource(Node)
   * @see flowchart.FlowchartPackage#getTransition_Source()
   * @see flowchart.Node#getOutgoing
   * @model opposite="outgoing"
   * @generated
   */
  Node getSource();

  /**
   * Sets the value of the '{@link flowchart.Transition#getSource <em>Source</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Source</em>' reference.
   * @see #getSource()
   * @generated
   */
  void setSource(Node value);

  /**
   * Returns the value of the '<em><b>Target</b></em>' reference.
   * It is bidirectional and its opposite is '{@link flowchart.Node#getIncoming <em>Incoming</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Target</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Target</em>' reference.
   * @see #setTarget(Node)
   * @see flowchart.FlowchartPackage#getTransition_Target()
   * @see flowchart.Node#getIncoming
   * @model opposite="incoming"
   * @generated
   */
  Node getTarget();

  /**
   * Sets the value of the '{@link flowchart.Transition#getTarget <em>Target</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Target</em>' reference.
   * @see #getTarget()
   * @generated
   */
  void setTarget(Node value);

} // Transition
