package org.eclipse.epsilon.flexmi;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

public class EReferenceSlot {
	
	protected EReference eReference;
	protected EObject eObject;
	
	public EReferenceSlot(EReference eReference, EObject eObject) {
		super();
		this.eReference = eReference;
		this.eObject = eObject;
	}
	
	public EReference getEReference() {
		return eReference;
	}
	
	public void setEReference(EReference eReference) {
		this.eReference = eReference;
	}
	
	public EObject getEObject() {
		return eObject;
	}
	
	public void getEObject(EObject container) {
		this.eObject = container;
	}
	
	@SuppressWarnings("unchecked")
	public void newValue(EObject value) {
		if (eReference.isMany()) ((List<Object>)eObject.eGet(eReference)).add(value);
		else eObject.eSet(eReference, value);
	}
	
}
