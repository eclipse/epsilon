/*******************************************************************************
 * Copyright (c) 2008-2016 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 *     Antonio Garcia-Dominguez - use collection interfaces and consider
 *                                optimised execution
 ******************************************************************************/
package org.eclipse.epsilon.evl.trace;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.epsilon.evl.dom.Constraint;

public class ConstraintTrace implements Iterable<ConstraintTraceItem> {

	protected Set<Constraint> storageOptimised = new HashSet<Constraint>();
	protected Map<Object, Map<Constraint, Boolean>> storage = new HashMap<Object, Map<Constraint, Boolean>>();
	protected List<ConstraintTraceItem> iterable = new ArrayList<ConstraintTraceItem>();

	/**
	 * Indicates that this constraint was checked in an optimised manner, so
	 * we only have the trace items for the invalid items and anything else
	 * is considered checked and valid.
	 */
	public void addCheckedOptimised(Constraint constraint) {
		storageOptimised.add(constraint);
	}

	public void addChecked(Constraint constraint, Object object, boolean result){
		Map<Constraint, Boolean> results;
		results = storage.get(object);
		if (results == null){
			results = new HashMap<Constraint, Boolean>();
			storage.put(object, results);
		}
		results.put(constraint, result);
		iterable.add(new ConstraintTraceItem(object, constraint, result));
	}

	public boolean isChecked(Constraint constraint, Object object) {
		if (storageOptimised.contains(constraint)) {
			return true;
		}
		final Map<Constraint, Boolean> results = storage.get(object);
		return results != null && results.get(constraint) != null;
	}

	public boolean isSatisfied(Constraint constraint, Object object) {
		Map<Constraint, Boolean> results = storage.get(object);
		if (results == null){
			// We could not find any individual trace items - it might
			// have only been checked by optimised constraints.
			return storageOptimised.contains(constraint);
		}
		else {
			// If we have an individual trace item, use it - otherwise,
			// see if this constraint was checked in an optimised way.
			final Boolean result = results.get(constraint);
			return result != null ? result.booleanValue() : storageOptimised.contains(constraint);
		}
	}

	public Iterator<ConstraintTraceItem> iterator() {
		return iterable.iterator();
	}
	
}
