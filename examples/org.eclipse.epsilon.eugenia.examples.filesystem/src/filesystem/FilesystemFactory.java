/**
 */
package filesystem;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see filesystem.FilesystemPackage
 * @generated
 */
public interface FilesystemFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  FilesystemFactory eINSTANCE = filesystem.impl.FilesystemFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Filesystem</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Filesystem</em>'.
   * @generated
   */
  Filesystem createFilesystem();

  /**
   * Returns a new object of class '<em>Drive</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Drive</em>'.
   * @generated
   */
  Drive createDrive();

  /**
   * Returns a new object of class '<em>Folder</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Folder</em>'.
   * @generated
   */
  Folder createFolder();

  /**
   * Returns a new object of class '<em>Shortcut</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Shortcut</em>'.
   * @generated
   */
  Shortcut createShortcut();

  /**
   * Returns a new object of class '<em>Sync</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Sync</em>'.
   * @generated
   */
  Sync createSync();

  /**
   * Returns a new object of class '<em>File</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>File</em>'.
   * @generated
   */
  File createFile();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  FilesystemPackage getFilesystemPackage();

} //FilesystemFactory
