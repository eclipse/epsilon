/**
 */
package rcpapp;

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
 *   <li>{@link rcpapp.Model#getComponents <em>Components</em>}</li>
 * </ul>
 * </p>
 *
 * @see rcpapp.RcpappPackage#getModel()
 * @model annotation="gmf.diagram rcp='true'"
 * @generated
 */
public interface Model extends EObject
{
  /**
   * Returns the value of the '<em><b>Components</b></em>' containment reference list.
   * The list contents are of type {@link rcpapp.Component}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Components</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Components</em>' containment reference list.
   * @see rcpapp.RcpappPackage#getModel_Components()
   * @model containment="true"
   * @generated
   */
  EList<Component> getComponents();

} // Model
