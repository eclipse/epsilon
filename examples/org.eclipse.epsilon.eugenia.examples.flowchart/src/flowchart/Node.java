/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package flowchart;

import org.eclipse.emf.cdo.CDOObject;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link flowchart.Node#getName <em>Name</em>}</li>
 *   <li>{@link flowchart.Node#getOutgoing <em>Outgoing</em>}</li>
 *   <li>{@link flowchart.Node#getIncoming <em>Incoming</em>}</li>
 * </ul>
 * </p>
 *
 * @see flowchart.FlowchartPackage#getNode()
 * @model abstract="true"
 *        annotation="gmf.node label='name' label.icon='false'"
 * @generated
 */
public interface Node extends EObject {
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
   * @see flowchart.FlowchartPackage#getNode_Name()
   * @model
   * @generated
   */
	String getName();

	/**
   * Sets the value of the '{@link flowchart.Node#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
	void setName(String value);

	/**
   * Returns the value of the '<em><b>Outgoing</b></em>' reference list.
   * The list contents are of type {@link flowchart.Transition}.
   * It is bidirectional and its opposite is '{@link flowchart.Transition#getSource <em>Source</em>}'.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outgoing</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Outgoing</em>' reference list.
   * @see flowchart.FlowchartPackage#getNode_Outgoing()
   * @see flowchart.Transition#getSource
   * @model opposite="source"
   * @generated
   */
	EList<Transition> getOutgoing();

	/**
   * Returns the value of the '<em><b>Incoming</b></em>' reference list.
   * The list contents are of type {@link flowchart.Transition}.
   * It is bidirectional and its opposite is '{@link flowchart.Transition#getTarget <em>Target</em>}'.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Incoming</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Incoming</em>' reference list.
   * @see flowchart.FlowchartPackage#getNode_Incoming()
   * @see flowchart.Transition#getTarget
   * @model opposite="target"
   * @generated
   */
	EList<Transition> getIncoming();

} // Node
