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

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.eclipse.epsilon.common.concurrent.ConcurrencyUtils;
import org.eclipse.epsilon.evl.dom.Constraint;

public class ConstraintTrace implements Iterable<ConstraintTraceItem> {

	protected final Set<Constraint> storageOptimised;
	//Map of model element instances to their constraints along with results
	protected final Map<Object, Map<Constraint, Boolean>> storage;
	protected final Collection<ConstraintTraceItem> iterable;
	
	public ConstraintTrace() {
		this(false);
	}
	
	public ConstraintTrace(boolean concurrent) {
		storageOptimised = concurrent ? ConcurrencyUtils.concurrentSet() : new HashSet<>();
		storage = concurrent ? ConcurrencyUtils.concurrentMap() : new HashMap<>();
		iterable = concurrent ? ConcurrencyUtils.concurrentSet(): new HashSet<>();
	}
	
	public void addAll(Collection<? extends ConstraintTrace> others) {
		for (ConstraintTrace ct : others) {
			storageOptimised.addAll(ct.storageOptimised.stream().collect(Collectors.toSet()));
			storage.putAll(ct.storage);
			iterable.addAll(ct.iterable.stream().collect(Collectors.toSet()));
		}
	}
	
	public void addAll(ConstraintTrace... others) {
		addAll(Arrays.asList(others));
	}
	
	/**
	 * Indicates that this constraint was checked in an optimised manner, so
	 * we only have the trace items for the invalid items and anything else
	 * is considered checked and valid.
	 */
	public void addCheckedOptimised(Constraint constraint) {
		storageOptimised.add(constraint);
	}

	public void addChecked(Constraint constraint, Object object, boolean result) {
		Map<Constraint, Boolean> results = storage.get(object);
		if (results == null) {
			results = new HashMap<>();
			storage.put(object, results);
		}
		results.put(constraint, result);
		
		ConstraintTraceItem cti = new ConstraintTraceItem(object, constraint, result);
		iterable.add(cti);
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
		if (results == null) {
			// We could not find any individual trace items - it might
			// have only been checked by optimised constraints.
			return storageOptimised.contains(constraint);
		}
		else {
			// If we have an individual trace item, use it - otherwise,
			// see if this constraint was checked in an optimised way.
			final Boolean result = results.get(constraint);
			return result != null ? result : storageOptimised.contains(constraint);
		}
	}

	public Stream<ConstraintTraceItem> stream() {
		return iterable.stream();
	}
	
	@Override
	public Iterator<ConstraintTraceItem> iterator() {
		return iterable.iterator();
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(iterable);
	}
	
	@Override
	public boolean equals(Object other) {
		if (this == other) return true;
		if (!(other instanceof ConstraintTrace))
			return false;
		
		ConstraintTrace ct = (ConstraintTrace) other;
		return Objects.equals(this.iterable, ct.iterable);
	}
}
