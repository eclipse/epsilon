/*********************************************************************
 * Copyright (c) 2019 The University of York.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.erl.execute.data;

import java.util.Objects;
import java.util.AbstractMap.SimpleEntry;
import java.util.Map.Entry;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.erl.dom.IExecutableDataRuleElement;
import org.eclipse.epsilon.erl.execute.context.IErlContext;

/**
 * A single rule-based construct and model element combination.
 * This class represents the most atomic (i.e. highest level of granularity) data structure possible.
 * 
 * @author Sina Madani
 * @since 1.6
 */
public abstract class RuleAtom<T extends IExecutableDataRuleElement> {

	public final T unit;
	public final Object element;
	
	public RuleAtom(T construct, Object modelElement) {
		this.unit = construct;
		this.element = modelElement;
	}
	
	public Object execute(IErlContext context) throws EolRuntimeException {
		return unit.execute(element, context);
	}
	
	public Entry<T, Object> asEntry() {
		return new SimpleEntry<>(unit, element);
	}
	
	@Override
	public String toString() {
		return getClass().getSimpleName()+" [unit=" + unit + ", element=" + element + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(unit, element);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (!(obj instanceof RuleAtom)) return false;
		RuleAtom<?> other = (RuleAtom<?>) obj;
		return
			Objects.equals(this.element, other.element) &&
			Objects.equals(this.unit, other.unit);
	}
}
