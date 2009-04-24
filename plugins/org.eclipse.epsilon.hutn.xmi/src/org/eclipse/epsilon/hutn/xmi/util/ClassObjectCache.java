/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************
 *
 * $Id$
 */
package org.eclipse.epsilon.hutn.xmi.util;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.epsilon.hutn.model.hutn.ClassObject;
import org.eclipse.epsilon.hutn.model.hutn.HutnFactory;

public class ClassObjectCache {

	private final Map<String, ClassObject> cache = new HashMap<String, ClassObject>();

	
	public ClassObject get(String identifier) {
		if (!cache.containsKey(identifier)) {
			final ClassObject co = HutnFactory.eINSTANCE.createClassObject();
			co.setIdentifier(identifier);
			cache.put(identifier, co);
		}
		
		return cache.get(identifier);
	}
}
