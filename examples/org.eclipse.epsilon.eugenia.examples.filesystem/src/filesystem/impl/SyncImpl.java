/**
 */
package filesystem.impl;

import filesystem.File;
import filesystem.FilesystemPackage;
import filesystem.Sync;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

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
public class SyncImpl extends EObjectImpl implements Sync
{
  /**
   * The cached value of the '{@link #getSource() <em>Source</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSource()
   * @generated
   * @ordered
   */
  protected File source;

  /**
   * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTarget()
   * @generated
   * @ordered
   */
  protected File target;

  /**
   * The default value of the '{@link #getLastSync() <em>Last Sync</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLastSync()
   * @generated
   * @ordered
   */
  protected static final String LAST_SYNC_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getLastSync() <em>Last Sync</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLastSync()
   * @generated
   * @ordered
   */
  protected String lastSync = LAST_SYNC_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SyncImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return FilesystemPackage.Literals.SYNC;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public File getSource()
  {
    if (source != null && source.eIsProxy())
    {
      InternalEObject oldSource = (InternalEObject)source;
      source = (File)eResolveProxy(oldSource);
      if (source != oldSource)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, FilesystemPackage.SYNC__SOURCE, oldSource, source));
      }
    }
    return source;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public File basicGetSource()
  {
    return source;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSource(File newSource)
  {
    File oldSource = source;
    source = newSource;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FilesystemPackage.SYNC__SOURCE, oldSource, source));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public File getTarget()
  {
    if (target != null && target.eIsProxy())
    {
      InternalEObject oldTarget = (InternalEObject)target;
      target = (File)eResolveProxy(oldTarget);
      if (target != oldTarget)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, FilesystemPackage.SYNC__TARGET, oldTarget, target));
      }
    }
    return target;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public File basicGetTarget()
  {
    return target;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTarget(File newTarget)
  {
    File oldTarget = target;
    target = newTarget;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FilesystemPackage.SYNC__TARGET, oldTarget, target));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getLastSync()
  {
    return lastSync;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLastSync(String newLastSync)
  {
    String oldLastSync = lastSync;
    lastSync = newLastSync;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FilesystemPackage.SYNC__LAST_SYNC, oldLastSync, lastSync));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case FilesystemPackage.SYNC__SOURCE:
        if (resolve) return getSource();
        return basicGetSource();
      case FilesystemPackage.SYNC__TARGET:
        if (resolve) return getTarget();
        return basicGetTarget();
      case FilesystemPackage.SYNC__LAST_SYNC:
        return getLastSync();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case FilesystemPackage.SYNC__SOURCE:
        setSource((File)newValue);
        return;
      case FilesystemPackage.SYNC__TARGET:
        setTarget((File)newValue);
        return;
      case FilesystemPackage.SYNC__LAST_SYNC:
        setLastSync((String)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case FilesystemPackage.SYNC__SOURCE:
        setSource((File)null);
        return;
      case FilesystemPackage.SYNC__TARGET:
        setTarget((File)null);
        return;
      case FilesystemPackage.SYNC__LAST_SYNC:
        setLastSync(LAST_SYNC_EDEFAULT);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case FilesystemPackage.SYNC__SOURCE:
        return source != null;
      case FilesystemPackage.SYNC__TARGET:
        return target != null;
      case FilesystemPackage.SYNC__LAST_SYNC:
        return LAST_SYNC_EDEFAULT == null ? lastSync != null : !LAST_SYNC_EDEFAULT.equals(lastSync);
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (lastSync: ");
    result.append(lastSync);
    result.append(')');
    return result.toString();
  }

} //SyncImpl
