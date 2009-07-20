/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package endlabels.impl;

import endlabels.Association;
import endlabels.EndlabelsPackage;
import endlabels.Model;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link endlabels.impl.ModelImpl#getClases <em>Clases</em>}</li>
 *   <li>{@link endlabels.impl.ModelImpl#getAsociations <em>Asociations</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ModelImpl extends EObjectImpl implements Model {
	/**
	 * The cached value of the '{@link #getClases() <em>Clases</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClases()
	 * @generated
	 * @ordered
	 */
	protected EList<endlabels.Class> clases;

	/**
	 * The cached value of the '{@link #getAsociations() <em>Asociations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAsociations()
	 * @generated
	 * @ordered
	 */
	protected EList<Association> asociations;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EndlabelsPackage.Literals.MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<endlabels.Class> getClases() {
		if (clases == null) {
			clases = new EObjectContainmentEList<endlabels.Class>(endlabels.Class.class, this, EndlabelsPackage.MODEL__CLASES);
		}
		return clases;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Association> getAsociations() {
		if (asociations == null) {
			asociations = new EObjectContainmentEList<Association>(Association.class, this, EndlabelsPackage.MODEL__ASOCIATIONS);
		}
		return asociations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EndlabelsPackage.MODEL__CLASES:
				return ((InternalEList<?>)getClases()).basicRemove(otherEnd, msgs);
			case EndlabelsPackage.MODEL__ASOCIATIONS:
				return ((InternalEList<?>)getAsociations()).basicRemove(otherEnd, msgs);
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
			case EndlabelsPackage.MODEL__CLASES:
				return getClases();
			case EndlabelsPackage.MODEL__ASOCIATIONS:
				return getAsociations();
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
			case EndlabelsPackage.MODEL__CLASES:
				getClases().clear();
				getClases().addAll((Collection<? extends endlabels.Class>)newValue);
				return;
			case EndlabelsPackage.MODEL__ASOCIATIONS:
				getAsociations().clear();
				getAsociations().addAll((Collection<? extends Association>)newValue);
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
			case EndlabelsPackage.MODEL__CLASES:
				getClases().clear();
				return;
			case EndlabelsPackage.MODEL__ASOCIATIONS:
				getAsociations().clear();
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
			case EndlabelsPackage.MODEL__CLASES:
				return clases != null && !clases.isEmpty();
			case EndlabelsPackage.MODEL__ASOCIATIONS:
				return asociations != null && !asociations.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ModelImpl
