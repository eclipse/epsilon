/*******************************************************************************
 * Copyright (c) 2009 The University of York.
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
package org.eclipse.epsilon.hutn.xmi.postprocessor;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.epsilon.hutn.model.hutn.ClassObject;
import org.eclipse.epsilon.hutn.model.hutn.ReferenceSlot;
import org.eclipse.epsilon.hutn.model.hutn.Spec;
import org.eclipse.epsilon.hutn.xmi.util.EmfUtil;

public class IdentifierPostProcessor {

	private final Spec spec;

	private final Map<String, String> renamings = new HashMap<String, String>();
	private final Map<String, Integer> counters = new HashMap<String, Integer>(); 

	
	public IdentifierPostProcessor(Spec spec) {
		this.spec = spec;
	}

	public void process() {
		renameClassObjects();
		updateReferenceSlots();
	}
	
	private void renameClassObjects() {
		for (ClassObject co : allClassObjects()) {
			final String type = co.getType() == null ? "UnknownType" : co.getType();
			final String newIdentifier = type + counterFor(type);
			
			renamings.put(co.getIdentifier(), newIdentifier);
			co.setIdentifier(newIdentifier);
		}
	}
	
	
	private List<ClassObject> allClassObjects() {
		return EmfUtil.getAllModelElementsOfType(spec, ClassObject.class);
	}
	
	private int counterFor(String type) {
		if (!counters.containsKey(type)) {
			counters.put(type, 1);
		}
		
		int current = counters.get(type);
		counters.put(type, current+1);
		
		return current;
	}
	
	
	
	private void updateReferenceSlots() {
		for (ReferenceSlot slot : allReferenceSlots()) {
			final List<String> newValues = new LinkedList<String>();
			
			for (String identifier : slot.getValues()) {
				newValues.add(renamings.get(identifier));
			}
			
			slot.getValues().clear();
			slot.getValues().addAll(newValues);
		}
	}
	
	private List<ReferenceSlot> allReferenceSlots() {
		return EmfUtil.getAllModelElementsOfType(spec, ReferenceSlot.class);
	}
}
