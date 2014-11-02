/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.evl.trace;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import org.eclipse.epsilon.evl.dom.Constraint;

public class ConstraintTrace implements Iterable<ConstraintTraceItem> {
	
	HashMap<Object, HashMap<Constraint, Boolean>> storage = new HashMap<Object, HashMap<Constraint, Boolean>>();
	ArrayList<ConstraintTraceItem> iterable = new ArrayList<ConstraintTraceItem>();
	
	public ConstraintTrace() {
		super();
	}
	
	public void addChecked(Constraint constraint, Object object, boolean result){
		HashMap<Constraint, Boolean> results;
		results = storage.get(object);
		if (results == null){
			results = new HashMap<Constraint, Boolean>();
			storage.put(object, results);
		}
		results.put(constraint, result);
		iterable.add(new ConstraintTraceItem(object, constraint, result));
	}
	
	public boolean isChecked(Constraint constraint, Object object) {
		HashMap<Constraint, Boolean> results;
		results = storage.get(object);
		if (results == null){
			return false;
		}
		else {
			return results.get(constraint) != null;
		}
	}
	
	public boolean isSatisfied(Constraint constraint, Object object) {
		HashMap<Constraint, Boolean> results;
		results = storage.get(object);
		if (results == null){
			return false;
		}
		else {
			return results.get(constraint).booleanValue();
		}
	}

	public Iterator<ConstraintTraceItem> iterator() {
		return iterable.iterator();
	}
	
}
