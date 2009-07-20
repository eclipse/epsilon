/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package endlabels;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link endlabels.Model#getClases <em>Clases</em>}</li>
 *   <li>{@link endlabels.Model#getAsociations <em>Asociations</em>}</li>
 * </ul>
 * </p>
 *
 * @see endlabels.EndlabelsPackage#getModel()
 * @model annotation="gmf.diagram foo='bar'"
 * @generated
 */
public interface Model extends EObject {
	/**
	 * Returns the value of the '<em><b>Clases</b></em>' containment reference list.
	 * The list contents are of type {@link endlabels.Class}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Clases</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Clases</em>' containment reference list.
	 * @see endlabels.EndlabelsPackage#getModel_Clases()
	 * @model containment="true"
	 * @generated
	 */
	EList<endlabels.Class> getClases();

	/**
	 * Returns the value of the '<em><b>Asociations</b></em>' containment reference list.
	 * The list contents are of type {@link endlabels.Association}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Asociations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Asociations</em>' containment reference list.
	 * @see endlabels.EndlabelsPackage#getModel_Asociations()
	 * @model containment="true"
	 * @generated
	 */
	EList<Association> getAsociations();

} // Model
