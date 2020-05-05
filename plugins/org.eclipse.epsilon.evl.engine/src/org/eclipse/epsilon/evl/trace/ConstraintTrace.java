/*******************************************************************************
 * Copyright (c) 2008-2020 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 *     Antonio Garcia-Dominguez - use collection interfaces and consider
 *                                optimised execution
 *     Sina Madani - Concurrency support and optimisation
 ******************************************************************************/
package org.eclipse.epsilon.evl.trace;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.eclipse.epsilon.common.concurrent.ConcurrencyUtils;
import org.eclipse.epsilon.evl.dom.Constraint;

public class ConstraintTrace implements Iterable<ConstraintTraceItem> {

	protected final Set<Constraint> storageOptimised;
	protected final Set<ConstraintTraceItem> iterable;
	
	public ConstraintTrace() {
		this(false);
	}
	
	/**
	 * @since 1.6
	 * @param concurrent
	 */
	public ConstraintTrace(boolean concurrent) {
		storageOptimised = concurrent ? ConcurrencyUtils.concurrentSet() : new HashSet<>();
		iterable = concurrent ? ConcurrencyUtils.concurrentSet(): new HashSet<>();
	}
	
	/**
	 * 
	 * @param others
	 * @since 1.6
	 */
	public void addAll(Collection<? extends ConstraintTrace> others) {
		for (ConstraintTrace ct : others) {
			storageOptimised.addAll(ct.storageOptimised.stream().collect(Collectors.toSet()));
			iterable.addAll(ct.iterable.stream().collect(Collectors.toSet()));
		}
	}
	
	/**
	 * @param others
	 * @since 1.6
	 */
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
		ConstraintTraceItem cti = new ConstraintTraceItem(object, constraint, result);
		iterable.add(cti);
	}

	public boolean isChecked(Constraint constraint, Object instance) {
		return storageOptimised.contains(constraint) ||
			iterable.stream().anyMatch(cti -> cti.equals(constraint, instance));
	}

	public boolean isSatisfied(Constraint constraint, Object instance) {
		if (storageOptimised.contains(constraint)) return true;
		ConstraintTraceItem cti = new ConstraintTraceItem(instance, constraint, true);
		return iterable.stream().anyMatch(cti::equals);
	}

	/**
	 * @since 1.6
	 */
	public void clear() {
		if (storageOptimised != null) storageOptimised.clear();
		if (iterable != null) iterable.clear();
	}
	
	/**
	 * 
	 * @return
	 * @since 1.6
	 */
	public Stream<ConstraintTraceItem> stream() {
		return iterable.stream();
	}
	
	@Override
	public Iterator<ConstraintTraceItem> iterator() {
		return iterable.iterator();
	}
	
	/**
	 * @since 1.6
	 */
	@Override
	public int hashCode() {
		return Objects.hash(iterable, storageOptimised);
	}
	
	/**
	 * @since 1.6
	 */
	@Override
	public boolean equals(Object other) {
		if (this == other) return true;
		if (!(other instanceof ConstraintTrace))
			return false;
		
		ConstraintTrace ct = (ConstraintTrace) other;
		return
			Objects.equals(this.storageOptimised, ct.storageOptimised) &&
			Objects.equals(this.iterable, ct.iterable);
	}
}
