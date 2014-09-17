/**
 */
package SimpleBPMN.impl;

import SimpleBPMN.BPMNElement;
import SimpleBPMN.FlowObject;
import SimpleBPMN.Lane;
import SimpleBPMN.SimpleBPMNPackage;

import java.util.Collection;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Lane</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link SimpleBPMN.impl.LaneImpl#getFlowObjects <em>Flow Objects</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LaneImpl extends SwimlaneImpl implements Lane {
	/**
	 * The cached value of the '{@link #getFlowObjects() <em>Flow Objects</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFlowObjects()
	 * @generated
	 * @ordered
	 */
	protected EList<FlowObject> flowObjects;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LaneImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SimpleBPMNPackage.Literals.LANE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FlowObject> getFlowObjects() {
		if (flowObjects == null) {
			flowObjects = new EObjectContainmentEList<FlowObject>(FlowObject.class, this, SimpleBPMNPackage.LANE__FLOW_OBJECTS);
		}
		return flowObjects;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SimpleBPMNPackage.LANE__FLOW_OBJECTS:
				return ((InternalEList<?>)getFlowObjects()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SimpleBPMNPackage.LANE__FLOW_OBJECTS:
				return getFlowObjects();
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
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SimpleBPMNPackage.LANE__FLOW_OBJECTS:
				getFlowObjects().clear();
				getFlowObjects().addAll((Collection<? extends FlowObject>)newValue);
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
	public void eUnset(int featureID) {
		switch (featureID) {
			case SimpleBPMNPackage.LANE__FLOW_OBJECTS:
				getFlowObjects().clear();
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
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case SimpleBPMNPackage.LANE__FLOW_OBJECTS:
				return flowObjects != null && !flowObjects.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //LaneImpl
