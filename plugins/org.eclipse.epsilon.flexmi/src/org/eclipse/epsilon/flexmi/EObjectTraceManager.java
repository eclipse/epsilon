package org.eclipse.epsilon.flexmi;

import java.util.HashMap;

import org.eclipse.emf.ecore.EObject;

public class EObjectTraceManager {
	
	protected HashMap<EObject, Integer> eObjectLineTrace = new HashMap<EObject, Integer>();
	protected HashMap<Integer, EObject> lineEObjectTrace = new HashMap<Integer, EObject>();
	
	public void trace(EObject eObject, int line) {
		eObjectLineTrace.put(eObject, line);
		lineEObjectTrace.put(line, eObject);
	}
	
	public EObject getEObject(int line) {
		return lineEObjectTrace.get(line);
	}
	
	public int getLine(EObject eObject) {
		return eObjectLineTrace.get(eObject);
	}
}
