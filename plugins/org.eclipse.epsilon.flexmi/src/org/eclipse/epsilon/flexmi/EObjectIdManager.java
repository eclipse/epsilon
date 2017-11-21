package org.eclipse.epsilon.flexmi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

public class EObjectIdManager {
	
	protected HashMap<String, List<EObject>> cache = new HashMap<String, List<EObject>>();
	
	public void setEObjectId(EObject eObject, String id) {
		List<EObject> eObjects = cache.get(id);
		if (eObjects == null) {
			eObjects = new ArrayList<EObject>();
			cache.put(id, eObjects);
		}
		eObjects.add(eObject);
	}
	
	public List<EObject> getEObjectsById(String id) {
		List<EObject> eObjects = cache.get(id);
		if (eObjects == null) return Collections.emptyList();
		else return eObjects;
	}
	
	public boolean hasId(EObject eObject) {
		return cache.values().contains(eObject);
	}
}
