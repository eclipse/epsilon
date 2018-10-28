/*******************************************************************************
 * Copyright (c) 2008-2018 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
>>>>>>> origin/master
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 *     Sina Madani - refactoring
 ******************************************************************************/
package org.eclipse.epsilon.evl.execute.context;

import java.util.*;
import java.util.stream.Collectors;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.erl.execute.context.IErlContext;
import org.eclipse.epsilon.evl.IEvlModule;
import org.eclipse.epsilon.evl.dom.Constraint;
import org.eclipse.epsilon.evl.execute.UnsatisfiedConstraint;
import org.eclipse.epsilon.evl.trace.ConstraintTrace;

public interface IEvlContext extends IErlContext {
	
	Set<UnsatisfiedConstraint> getUnsatisfiedConstraints();
	
	ConstraintTrace getConstraintTrace();

	/**
	 * @since 1.6
	 */
	public static final String OPTIMIZE_CONSTRAINT_TRACE = "optimizeConstraintTrace";
	
	/**
	 * Return true if the constraint results cache is optimized. When optimized, constraint results
	 * will only be cached during satisfies operation executions, that is, results will only be
	 * cached if required. If false, constraint results will always be cached.
	 * <p>
	 * The default value is false;
	 * @return
	 */
	boolean isOptimizeConstraintTrace();

	/**
	 * Set the flag for using optimized contraint result caching.
	 * @see #isOptimizeConstraintTrace()
	 * @param use	Set to true to use optimzied contraint caching.
	 */
	void setOptimizeConstraintTrace(boolean optimized);
	
	/**
	 * @since 1.6
	 * @return
	 */
	default boolean hasFixes() {
		return getUnsatisfiedConstraints()
			.stream()
			.map(UnsatisfiedConstraint::getFixes)
			.anyMatch(fixes -> !fixes.isEmpty());
	}
	
	/**
	 * @return A mapping from a Constraint to all of its unsatisfied instances.
	 * @since 1.6
	 */
	default Map<Constraint, Set<Object>> sortUnsatisfiedConstraints() {
		return getUnsatisfiedConstraints()
			.stream()
			.collect(Collectors.groupingBy(
				UnsatisfiedConstraint::getConstraint,
				LinkedHashMap::new, 
				Collectors.mapping(UnsatisfiedConstraint::getInstance, Collectors.toSet())
			));
	}
	
	/**
	 * @return A sorted entry of Constraints with the number of unsatisfied instances, in descending order.
	 * @since 1.6
	 */
	default Map<Constraint, Integer> getUnsatisfiedConstraintsBySize() {
		return sortUnsatisfiedConstraints()
			.entrySet()
			.stream()
			.map(entry -> new AbstractMap.SimpleEntry<>(entry.getKey(), entry.getValue().size()))
			.sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
			.collect(Collectors.toMap(
				Map.Entry::getKey, Map.Entry::getValue, (a, b) -> b, LinkedHashMap::new)
			);
	}
	
	/**
	 * 
	 * @return
	 * @since 1.6
	 */
	default Set<Constraint> getConstraintsDependedOn() {
		return getModule().getConstraints()
			.stream()
			.filter(Constraint::isDependedOn)
			.collect(Collectors.toSet());
	}
	
	/**
	 * Casts the IModule to IEvlModule
	 * @see org.eclipse.epsilon.eol.execute.context.IEolContext#getModule()
	 * @since 1.6
	 */
	@Override
	default IEvlModule getModule() {
		return (IEvlModule) ((IEolContext)this).getModule();
	}
}
