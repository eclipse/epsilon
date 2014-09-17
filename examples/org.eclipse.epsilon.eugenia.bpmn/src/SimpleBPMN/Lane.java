/**
 */
package SimpleBPMN;

import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Lane</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link SimpleBPMN.Lane#getFlowObjects <em>Flow Objects</em>}</li>
 * </ul>
 * </p>
 *
 * @see SimpleBPMN.SimpleBPMNPackage#getLane()
 * @model
 * @generated
 */
public interface Lane extends Swimlane {

	/**
	 * Returns the value of the '<em><b>Flow Objects</b></em>' containment reference list.
	 * The list contents are of type {@link SimpleBPMN.FlowObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Flow Objects</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Flow Objects</em>' containment reference list.
	 * @see SimpleBPMN.SimpleBPMNPackage#getLane_FlowObjects()
	 * @model containment="true"
	 * @generated
	 */
	EList<FlowObject> getFlowObjects();
} // Lane
