/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package flowchart.impl;

import flowchart.FlowchartPackage;
import flowchart.Node;
import flowchart.Subflow;
import flowchart.Transition;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

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
public class SubflowImpl extends FlowchartImpl implements Subflow {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SubflowImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FlowchartPackage.Literals.SUBFLOW;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return (String)eGet(FlowchartPackage.Literals.NODE__NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		eSet(FlowchartPackage.Literals.NODE__NAME, newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Transition> getOutgoing() {
		return (EList<Transition>)eGet(FlowchartPackage.Literals.NODE__OUTGOING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Transition> getIncoming() {
		return (EList<Transition>)eGet(FlowchartPackage.Literals.NODE__INCOMING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == Node.class) {
			switch (derivedFeatureID) {
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
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == Node.class) {
			switch (baseFeatureID) {
				case FlowchartPackage.NODE__NAME: return FlowchartPackage.SUBFLOW__NAME;
				case FlowchartPackage.NODE__OUTGOING: return FlowchartPackage.SUBFLOW__OUTGOING;
				case FlowchartPackage.NODE__INCOMING: return FlowchartPackage.SUBFLOW__INCOMING;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //SubflowImpl
