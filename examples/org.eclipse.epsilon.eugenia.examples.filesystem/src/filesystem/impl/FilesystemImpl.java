/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package filesystem.impl;

import filesystem.Drive;
import filesystem.Filesystem;
import filesystem.FilesystemPackage;
import filesystem.Sync;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.internal.cdo.CDOObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Filesystem</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link filesystem.impl.FilesystemImpl#getDrives <em>Drives</em>}</li>
 *   <li>{@link filesystem.impl.FilesystemImpl#getSyncs <em>Syncs</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FilesystemImpl extends CDOObjectImpl implements Filesystem {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FilesystemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FilesystemPackage.Literals.FILESYSTEM;
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
	@SuppressWarnings("unchecked")
	public EList<Drive> getDrives() {
		return (EList<Drive>)eGet(FilesystemPackage.Literals.FILESYSTEM__DRIVES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Sync> getSyncs() {
		return (EList<Sync>)eGet(FilesystemPackage.Literals.FILESYSTEM__SYNCS, true);
	}

} //FilesystemImpl
