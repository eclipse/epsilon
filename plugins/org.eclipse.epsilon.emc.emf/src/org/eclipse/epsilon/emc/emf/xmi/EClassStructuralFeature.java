package org.eclipse.epsilon.emc.emf.xmi;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;

public class EClassStructuralFeature {

	protected EClass eClass;
	protected EStructuralFeature eStructuralFeature;

	public EClassStructuralFeature(EClass eClass, EStructuralFeature eStructuralFeature) {
		super();
		this.eClass = eClass;
		this.eStructuralFeature = eStructuralFeature;
	}

	public EClass getEClass() {
		return eClass;
	}

	public EStructuralFeature getEStructuralFeature() {
		return eStructuralFeature;
	}

}