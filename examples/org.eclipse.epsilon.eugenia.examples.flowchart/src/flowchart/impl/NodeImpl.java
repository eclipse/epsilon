/**
 */
package flowchart.impl;

import flowchart.FlowchartPackage;
import flowchart.Node;
import flowchart.Transition;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link flowchart.impl.NodeImpl#getName <em>Name</em>}</li>
 *   <li>{@link flowchart.impl.NodeImpl#getOutgoing <em>Outgoing</em>}</li>
 *   <li>{@link flowchart.impl.NodeImpl#getIncoming <em>Incoming</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class NodeImpl extends EObjectImpl implements Node
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
   * The cached value of the '{@link #getOutgoing() <em>Outgoing</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOutgoing()
   * @generated
   * @ordered
   */
  protected EList<Transition> outgoing;

  /**
   * The cached value of the '{@link #getIncoming() <em>Incoming</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIncoming()
   * @generated
   * @ordered
   */
  protected EList<Transition> incoming;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected NodeImpl()
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
    return FlowchartPackage.Literals.NODE;
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
      eNotify(new ENotificationImpl(this, Notification.SET, FlowchartPackage.NODE__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Transition> getOutgoing()
  {
    if (outgoing == null)
    {
      outgoing = new EObjectWithInverseResolvingEList<Transition>(Transition.class, this, FlowchartPackage.NODE__OUTGOING, FlowchartPackage.TRANSITION__SOURCE);
    }
    return outgoing;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Transition> getIncoming()
  {
    if (incoming == null)
    {
      incoming = new EObjectWithInverseResolvingEList<Transition>(Transition.class, this, FlowchartPackage.NODE__INCOMING, FlowchartPackage.TRANSITION__TARGET);
    }
    return incoming;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case FlowchartPackage.NODE__OUTGOING:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getOutgoing()).basicAdd(otherEnd, msgs);
      case FlowchartPackage.NODE__INCOMING:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getIncoming()).basicAdd(otherEnd, msgs);
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
      case FlowchartPackage.NODE__OUTGOING:
        return ((InternalEList<?>)getOutgoing()).basicRemove(otherEnd, msgs);
      case FlowchartPackage.NODE__INCOMING:
        return ((InternalEList<?>)getIncoming()).basicRemove(otherEnd, msgs);
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
      case FlowchartPackage.NODE__NAME:
        return getName();
      case FlowchartPackage.NODE__OUTGOING:
        return getOutgoing();
      case FlowchartPackage.NODE__INCOMING:
        return getIncoming();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case FlowchartPackage.NODE__NAME:
        setName((String)newValue);
        return;
      case FlowchartPackage.NODE__OUTGOING:
        getOutgoing().clear();
        getOutgoing().addAll((Collection<? extends Transition>)newValue);
        return;
      case FlowchartPackage.NODE__INCOMING:
        getIncoming().clear();
        getIncoming().addAll((Collection<? extends Transition>)newValue);
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
      case FlowchartPackage.NODE__NAME:
        setName(NAME_EDEFAULT);
        return;
      case FlowchartPackage.NODE__OUTGOING:
        getOutgoing().clear();
        return;
      case FlowchartPackage.NODE__INCOMING:
        getIncoming().clear();
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
      case FlowchartPackage.NODE__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case FlowchartPackage.NODE__OUTGOING:
        return outgoing != null && !outgoing.isEmpty();
      case FlowchartPackage.NODE__INCOMING:
        return incoming != null && !incoming.isEmpty();
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

} //NodeImpl
