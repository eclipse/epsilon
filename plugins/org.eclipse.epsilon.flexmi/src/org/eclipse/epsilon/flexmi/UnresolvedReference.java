package org.eclipse.epsilon.flexmi;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

public class UnresolvedReference {
	
	protected EObject eObject;
	protected EReference eReference;
	protected String value;
	protected int line;
	protected String attributeName;
	
	public UnresolvedReference(EObject eObject, EReference eReference, String attributeName, String value, int line) {
		super();
		this.eObject = eObject;
		this.eReference = eReference;
		this.value = value;
		this.line = line;
		this.attributeName = attributeName;
	}

	public EObject getEObject() {
		return eObject;
	}
	
	public void setEObject(EObject eObject) {
		this.eObject = eObject;
	}
	
	public EReference getEReference() {
		return eReference;
	}
	
	public void seteReference(EReference eReference) {
		this.eReference = eReference;
	}
	
	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	
	public int getLine() {
		return line;
	}
	
	public void setLine(int line) {
		this.line = line;
	}
	
	public String getAttributeName() {
		return attributeName;
	}
	
	public void setAttributeName(String attributeName) {
		this.attributeName = attributeName;
	}
	
	public boolean resolve(Collection<EObject> candidates) {
		for (EObject candidate : candidates) {
			if (eReference.getEReferenceType().isInstance(candidate)) {
				new EReferenceSlot(eReference, getEObject()).newValue(candidate);
				return true;
			}
		}
		return false;
	}
	
}
