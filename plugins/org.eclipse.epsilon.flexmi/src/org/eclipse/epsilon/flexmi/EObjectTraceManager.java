/*********************************************************************
* Copyright (c) 2008 The University of York.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.flexmi;

import java.util.HashMap;
import java.util.Map;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;

public class EObjectTraceManager {
	
	protected Map<EObject, EObjectLocation> eObjectLineTrace = new HashMap<>();
	protected Map<EObjectLocation, EObject> lineEObjectTrace = new HashMap<>();
	
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
