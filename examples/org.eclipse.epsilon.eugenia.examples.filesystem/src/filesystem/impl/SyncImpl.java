/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package filesystem.impl;

import filesystem.File;
import filesystem.FilesystemPackage;
import filesystem.Sync;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.internal.cdo.CDOObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sync</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link filesystem.impl.SyncImpl#getSource <em>Source</em>}</li>
 *   <li>{@link filesystem.impl.SyncImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link filesystem.impl.SyncImpl#getLastSync <em>Last Sync</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SyncImpl extends CDOObjectImpl implements Sync {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SyncImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FilesystemPackage.Literals.SYNC;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected int eStaticFeatureCount() {
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public File getSource() {
		return (File)eGet(FilesystemPackage.Literals.SYNC__SOURCE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSource(File newSource) {
		eSet(FilesystemPackage.Literals.SYNC__SOURCE, newSource);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public File getTarget() {
		return (File)eGet(FilesystemPackage.Literals.SYNC__TARGET, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(File newTarget) {
		eSet(FilesystemPackage.Literals.SYNC__TARGET, newTarget);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLastSync() {
		return (String)eGet(FilesystemPackage.Literals.SYNC__LAST_SYNC, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLastSync(String newLastSync) {
		eSet(FilesystemPackage.Literals.SYNC__LAST_SYNC, newLastSync);
	}

} //SyncImpl
