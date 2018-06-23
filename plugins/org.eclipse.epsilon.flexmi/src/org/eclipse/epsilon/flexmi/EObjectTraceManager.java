package org.eclipse.epsilon.flexmi;

import java.util.HashMap;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;

public class EObjectTraceManager {
	
	protected HashMap<EObject, EObjectLocation> eObjectLineTrace = new HashMap<EObject, EObjectLocation>();
	protected HashMap<EObjectLocation, EObject> lineEObjectTrace = new HashMap<EObjectLocation, EObject>();
	
	public void trace(EObject eObject, URI uri, int line) {
		eObjectLineTrace.put(eObject, new EObjectLocation(uri, line));
		lineEObjectTrace.put(new EObjectLocation(uri, line), eObject);
	}
	
	public EObject getEObject(URI uri, int line) {
		return lineEObjectTrace.get(new EObjectLocation(uri, line));
	}
	
	public EObjectLocation getLine(EObject eObject) {
		return eObjectLineTrace.get(eObject);
	}
}
