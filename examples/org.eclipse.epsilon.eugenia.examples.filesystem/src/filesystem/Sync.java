/**
 */
package filesystem;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sync</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link filesystem.Sync#getSource <em>Source</em>}</li>
 *   <li>{@link filesystem.Sync#getTarget <em>Target</em>}</li>
 *   <li>{@link filesystem.Sync#getLastSync <em>Last Sync</em>}</li>
 * </ul>
 * </p>
 *
 * @see filesystem.FilesystemPackage#getSync()
 * @model annotation="gmf.link label='lastSync' source='source' target='target' style='dot' width='2'"
 * @generated
 */
public interface Sync extends EObject
{
  /**
   * Returns the value of the '<em><b>Source</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Source</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Source</em>' reference.
   * @see #setSource(File)
   * @see filesystem.FilesystemPackage#getSync_Source()
   * @model
   * @generated
   */
  File getSource();

  /**
   * Sets the value of the '{@link filesystem.Sync#getSource <em>Source</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Source</em>' reference.
   * @see #getSource()
   * @generated
   */
  void setSource(File value);

  /**
   * Returns the value of the '<em><b>Target</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Target</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Target</em>' reference.
   * @see #setTarget(File)
   * @see filesystem.FilesystemPackage#getSync_Target()
   * @model
   * @generated
   */
  File getTarget();

  /**
   * Sets the value of the '{@link filesystem.Sync#getTarget <em>Target</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Target</em>' reference.
   * @see #getTarget()
   * @generated
   */
  void setTarget(File value);

  /**
   * Returns the value of the '<em><b>Last Sync</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Last Sync</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Last Sync</em>' attribute.
   * @see #setLastSync(String)
   * @see filesystem.FilesystemPackage#getSync_LastSync()
   * @model
   * @generated
   */
  String getLastSync();

  /**
   * Sets the value of the '{@link filesystem.Sync#getLastSync <em>Last Sync</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Last Sync</em>' attribute.
   * @see #getLastSync()
   * @generated
   */
  void setLastSync(String value);

} // Sync
