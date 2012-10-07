/**
 */
package flowchart.impl;

import flowchart.FlowchartPackage;
import flowchart.Node;
import flowchart.Subflow;
import flowchart.Transition;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Subflow</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link flowchart.impl.SubflowImpl#getName <em>Name</em>}</li>
 *   <li>{@link flowchart.impl.SubflowImpl#getOutgoing <em>Outgoing</em>}</li>
 *   <li>{@link flowchart.impl.SubflowImpl#getIncoming <em>Incoming</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SubflowImpl extends FlowchartImpl implements Subflow
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
  protected SubflowImpl()
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
    return FlowchartPackage.Literals.SUBFLOW;
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
      eNotify(new ENotificationImpl(this, Notification.SET, FlowchartPackage.SUBFLOW__NAME, oldName, name));
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
      outgoing = new EObjectWithInverseResolvingEList<Transition>(Transition.class, this, FlowchartPackage.SUBFLOW__OUTGOING, FlowchartPackage.TRANSITION__SOURCE);
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
      incoming = new EObjectWithInverseResolvingEList<Transition>(Transition.class, this, FlowchartPackage.SUBFLOW__INCOMING, FlowchartPackage.TRANSITION__TARGET);
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
      case FlowchartPackage.SUBFLOW__OUTGOING:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getOutgoing()).basicAdd(otherEnd, msgs);
      case FlowchartPackage.SUBFLOW__INCOMING:
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
      case FlowchartPackage.SUBFLOW__OUTGOING:
        return ((InternalEList<?>)getOutgoing()).basicRemove(otherEnd, msgs);
      case FlowchartPackage.SUBFLOW__INCOMING:
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
      case FlowchartPackage.SUBFLOW__NAME:
        return getName();
      case FlowchartPackage.SUBFLOW__OUTGOING:
        return getOutgoing();
      case FlowchartPackage.SUBFLOW__INCOMING:
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
      case FlowchartPackage.SUBFLOW__NAME:
        setName((String)newValue);
        return;
      case FlowchartPackage.SUBFLOW__OUTGOING:
        getOutgoing().clear();
        getOutgoing().addAll((Collection<? extends Transition>)newValue);
        return;
      case FlowchartPackage.SUBFLOW__INCOMING:
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
      case FlowchartPackage.SUBFLOW__NAME:
        setName(NAME_EDEFAULT);
        return;
      case FlowchartPackage.SUBFLOW__OUTGOING:
        getOutgoing().clear();
        return;
      case FlowchartPackage.SUBFLOW__INCOMING:
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
      case FlowchartPackage.SUBFLOW__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case FlowchartPackage.SUBFLOW__OUTGOING:
        return outgoing != null && !outgoing.isEmpty();
      case FlowchartPackage.SUBFLOW__INCOMING:
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
  public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass)
  {
    if (baseClass == Node.class)
    {
      switch (derivedFeatureID)
      {
        case FlowchartPackage.SUBFLOW__NAME: return FlowchartPackage.NODE__NAME;
        case FlowchartPackage.SUBFLOW__OUTGOING: return FlowchartPackage.NODE__OUTGOING;
        case FlowchartPackage.SUBFLOW__INCOMING: return FlowchartPackage.NODE__INCOMING;
        default: return -1;
      }
    }
    return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass)
  {
    if (baseClass == Node.class)
    {
      switch (baseFeatureID)
      {
        case FlowchartPackage.NODE__NAME: return FlowchartPackage.SUBFLOW__NAME;
        case FlowchartPackage.NODE__OUTGOING: return FlowchartPackage.SUBFLOW__OUTGOING;
        case FlowchartPackage.NODE__INCOMING: return FlowchartPackage.SUBFLOW__INCOMING;
        default: return -1;
      }
    }
    return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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

} //SubflowImpl
