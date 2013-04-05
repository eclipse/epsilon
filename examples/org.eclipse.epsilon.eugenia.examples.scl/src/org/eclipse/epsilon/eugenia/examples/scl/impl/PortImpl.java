/**
 */
package org.eclipse.epsilon.eugenia.examples.scl.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.epsilon.eugenia.examples.scl.Connector;
import org.eclipse.epsilon.eugenia.examples.scl.Port;
import org.eclipse.epsilon.eugenia.examples.scl.SclPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Port</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.epsilon.eugenia.examples.scl.impl.PortImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.epsilon.eugenia.examples.scl.impl.PortImpl#getOutgoing <em>Outgoing</em>}</li>
 *   <li>{@link org.eclipse.epsilon.eugenia.examples.scl.impl.PortImpl#getIncoming <em>Incoming</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PortImpl extends EObjectImpl implements Port
{
  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The cached value of the '{@link #getOutgoing() <em>Outgoing</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOutgoing()
   * @generated
   * @ordered
   */
  protected Connector outgoing;

  /**
   * The cached value of the '{@link #getIncoming() <em>Incoming</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIncoming()
   * @generated
   * @ordered
   */
  protected Connector incoming;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PortImpl()
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
    return SclPackage.Literals.PORT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SclPackage.PORT__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Connector getOutgoing()
  {
    return outgoing;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetOutgoing(Connector newOutgoing, NotificationChain msgs)
  {
    Connector oldOutgoing = outgoing;
    outgoing = newOutgoing;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SclPackage.PORT__OUTGOING, oldOutgoing, newOutgoing);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOutgoing(Connector newOutgoing)
  {
    if (newOutgoing != outgoing)
    {
      NotificationChain msgs = null;
      if (outgoing != null)
        msgs = ((InternalEObject)outgoing).eInverseRemove(this, SclPackage.CONNECTOR__FROM, Connector.class, msgs);
      if (newOutgoing != null)
        msgs = ((InternalEObject)newOutgoing).eInverseAdd(this, SclPackage.CONNECTOR__FROM, Connector.class, msgs);
      msgs = basicSetOutgoing(newOutgoing, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SclPackage.PORT__OUTGOING, newOutgoing, newOutgoing));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Connector getIncoming()
  {
    if (incoming != null && incoming.eIsProxy())
    {
      InternalEObject oldIncoming = (InternalEObject)incoming;
      incoming = (Connector)eResolveProxy(oldIncoming);
      if (incoming != oldIncoming)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, SclPackage.PORT__INCOMING, oldIncoming, incoming));
      }
    }
    return incoming;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Connector basicGetIncoming()
  {
    return incoming;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetIncoming(Connector newIncoming, NotificationChain msgs)
  {
    Connector oldIncoming = incoming;
    incoming = newIncoming;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SclPackage.PORT__INCOMING, oldIncoming, newIncoming);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIncoming(Connector newIncoming)
  {
    if (newIncoming != incoming)
    {
      NotificationChain msgs = null;
      if (incoming != null)
        msgs = ((InternalEObject)incoming).eInverseRemove(this, SclPackage.CONNECTOR__TO, Connector.class, msgs);
      if (newIncoming != null)
        msgs = ((InternalEObject)newIncoming).eInverseAdd(this, SclPackage.CONNECTOR__TO, Connector.class, msgs);
      msgs = basicSetIncoming(newIncoming, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SclPackage.PORT__INCOMING, newIncoming, newIncoming));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case SclPackage.PORT__OUTGOING:
        if (outgoing != null)
          msgs = ((InternalEObject)outgoing).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SclPackage.PORT__OUTGOING, null, msgs);
        return basicSetOutgoing((Connector)otherEnd, msgs);
      case SclPackage.PORT__INCOMING:
        if (incoming != null)
          msgs = ((InternalEObject)incoming).eInverseRemove(this, SclPackage.CONNECTOR__TO, Connector.class, msgs);
        return basicSetIncoming((Connector)otherEnd, msgs);
    }
    return super.eInverseAdd(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case SclPackage.PORT__OUTGOING:
        return basicSetOutgoing(null, msgs);
      case SclPackage.PORT__INCOMING:
        return basicSetIncoming(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
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
      case SclPackage.PORT__NAME:
        return getName();
      case SclPackage.PORT__OUTGOING:
        return getOutgoing();
      case SclPackage.PORT__INCOMING:
        if (resolve) return getIncoming();
        return basicGetIncoming();
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
      case SclPackage.PORT__NAME:
        setName((String)newValue);
        return;
      case SclPackage.PORT__OUTGOING:
        setOutgoing((Connector)newValue);
        return;
      case SclPackage.PORT__INCOMING:
        setIncoming((Connector)newValue);
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
      case SclPackage.PORT__NAME:
        setName(NAME_EDEFAULT);
        return;
      case SclPackage.PORT__OUTGOING:
        setOutgoing((Connector)null);
        return;
      case SclPackage.PORT__INCOMING:
        setIncoming((Connector)null);
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
      case SclPackage.PORT__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case SclPackage.PORT__OUTGOING:
        return outgoing != null;
      case SclPackage.PORT__INCOMING:
        return incoming != null;
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
    result.append(" (name: ");
    result.append(name);
    result.append(')');
    return result.toString();
  }

} //PortImpl
