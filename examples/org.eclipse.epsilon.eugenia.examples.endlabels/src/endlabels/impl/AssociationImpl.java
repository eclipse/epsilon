/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package endlabels.impl;

import endlabels.Association;
import endlabels.EndlabelsPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Association</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link endlabels.impl.AssociationImpl#getSource <em>Source</em>}</li>
 *   <li>{@link endlabels.impl.AssociationImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link endlabels.impl.AssociationImpl#getSourceLabel <em>Source Label</em>}</li>
 *   <li>{@link endlabels.impl.AssociationImpl#getTargetLabel <em>Target Label</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AssociationImpl extends NamedElementImpl implements Association {
	/**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected endlabels.Class source;

	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected endlabels.Class target;

	/**
	 * The default value of the '{@link #getSourceLabel() <em>Source Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceLabel()
	 * @generated
	 * @ordered
	 */
	protected static final String SOURCE_LABEL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSourceLabel() <em>Source Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceLabel()
	 * @generated
	 * @ordered
	 */
	protected String sourceLabel = SOURCE_LABEL_EDEFAULT;

	/**
	 * The default value of the '{@link #getTargetLabel() <em>Target Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetLabel()
	 * @generated
	 * @ordered
	 */
	protected static final String TARGET_LABEL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTargetLabel() <em>Target Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetLabel()
	 * @generated
	 * @ordered
	 */
	protected String targetLabel = TARGET_LABEL_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AssociationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EndlabelsPackage.Literals.ASSOCIATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public endlabels.Class getSource() {
		if (source != null && source.eIsProxy()) {
			InternalEObject oldSource = (InternalEObject)source;
			source = (endlabels.Class)eResolveProxy(oldSource);
			if (source != oldSource) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EndlabelsPackage.ASSOCIATION__SOURCE, oldSource, source));
			}
		}
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public endlabels.Class basicGetSource() {
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSource(endlabels.Class newSource) {
		endlabels.Class oldSource = source;
		source = newSource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EndlabelsPackage.ASSOCIATION__SOURCE, oldSource, source));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public endlabels.Class getTarget() {
		if (target != null && target.eIsProxy()) {
			InternalEObject oldTarget = (InternalEObject)target;
			target = (endlabels.Class)eResolveProxy(oldTarget);
			if (target != oldTarget) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EndlabelsPackage.ASSOCIATION__TARGET, oldTarget, target));
			}
		}
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public endlabels.Class basicGetTarget() {
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(endlabels.Class newTarget) {
		endlabels.Class oldTarget = target;
		target = newTarget;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EndlabelsPackage.ASSOCIATION__TARGET, oldTarget, target));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSourceLabel() {
		return sourceLabel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceLabel(String newSourceLabel) {
		String oldSourceLabel = sourceLabel;
		sourceLabel = newSourceLabel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EndlabelsPackage.ASSOCIATION__SOURCE_LABEL, oldSourceLabel, sourceLabel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTargetLabel() {
		return targetLabel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetLabel(String newTargetLabel) {
		String oldTargetLabel = targetLabel;
		targetLabel = newTargetLabel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EndlabelsPackage.ASSOCIATION__TARGET_LABEL, oldTargetLabel, targetLabel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EndlabelsPackage.ASSOCIATION__SOURCE:
				if (resolve) return getSource();
				return basicGetSource();
			case EndlabelsPackage.ASSOCIATION__TARGET:
				if (resolve) return getTarget();
				return basicGetTarget();
			case EndlabelsPackage.ASSOCIATION__SOURCE_LABEL:
				return getSourceLabel();
			case EndlabelsPackage.ASSOCIATION__TARGET_LABEL:
				return getTargetLabel();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case EndlabelsPackage.ASSOCIATION__SOURCE:
				setSource((endlabels.Class)newValue);
				return;
			case EndlabelsPackage.ASSOCIATION__TARGET:
				setTarget((endlabels.Class)newValue);
				return;
			case EndlabelsPackage.ASSOCIATION__SOURCE_LABEL:
				setSourceLabel((String)newValue);
				return;
			case EndlabelsPackage.ASSOCIATION__TARGET_LABEL:
				setTargetLabel((String)newValue);
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
			case EndlabelsPackage.ASSOCIATION__SOURCE:
				setSource((endlabels.Class)null);
				return;
			case EndlabelsPackage.ASSOCIATION__TARGET:
				setTarget((endlabels.Class)null);
				return;
			case EndlabelsPackage.ASSOCIATION__SOURCE_LABEL:
				setSourceLabel(SOURCE_LABEL_EDEFAULT);
				return;
			case EndlabelsPackage.ASSOCIATION__TARGET_LABEL:
				setTargetLabel(TARGET_LABEL_EDEFAULT);
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
			case EndlabelsPackage.ASSOCIATION__SOURCE:
				return source != null;
			case EndlabelsPackage.ASSOCIATION__TARGET:
				return target != null;
			case EndlabelsPackage.ASSOCIATION__SOURCE_LABEL:
				return SOURCE_LABEL_EDEFAULT == null ? sourceLabel != null : !SOURCE_LABEL_EDEFAULT.equals(sourceLabel);
			case EndlabelsPackage.ASSOCIATION__TARGET_LABEL:
				return TARGET_LABEL_EDEFAULT == null ? targetLabel != null : !TARGET_LABEL_EDEFAULT.equals(targetLabel);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (sourceLabel: ");
		result.append(sourceLabel);
		result.append(", targetLabel: ");
		result.append(targetLabel);
		result.append(')');
		return result.toString();
	}

} //AssociationImpl
