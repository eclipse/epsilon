package org.eclipse.epsilon.flexmi;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;

public class EAttributeSlot {
	
	protected EAttribute eAttribute;
	protected EObject eObject;
	
	public EAttribute getEAttribute() {
		return eAttribute;
	}
	
	public void setEAttribute(EAttribute eAttribute) {
		this.eAttribute = eAttribute;
	}
	
	public EObject getEObject() {
		return eObject;
	}
	
	public void setEObject(EObject eObject) {
		this.eObject = eObject;
	}
	
	public void newValue(String value) {
		
	}
	
}
