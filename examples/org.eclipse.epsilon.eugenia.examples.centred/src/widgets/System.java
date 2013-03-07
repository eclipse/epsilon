/**
 */
package widgets;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>System</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link widgets.System#getWidgets <em>Widgets</em>}</li>
 * </ul>
 * </p>
 *
 * @see widgets.WidgetsPackage#getSystem()
 * @model annotation="gmf.diagram foo='bar'"
 * @generated
 */
public interface System extends EObject
{
  /**
   * Returns the value of the '<em><b>Widgets</b></em>' containment reference list.
   * The list contents are of type {@link widgets.Widget}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Widgets</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Widgets</em>' containment reference list.
   * @see widgets.WidgetsPackage#getSystem_Widgets()
   * @model containment="true"
   * @generated
   */
  EList<Widget> getWidgets();

} // System
