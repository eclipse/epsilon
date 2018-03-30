package org.eclipse.epsilon.evl.execute.concurrent;

import java.util.AbstractMap.SimpleEntry;
import java.util.Map.Entry;
import org.eclipse.epsilon.common.module.ModuleElement;
import org.eclipse.epsilon.evl.execute.context.IEvlContext;

/*
 * A single EVL construct (e.g. Constraint or ConstraintContext) and model element combination.
 * This class represents the most atomic (i.e. highest level of granularity) data structure possible.
 */
abstract class EvlAtom<T extends ModuleElement> {

	public final T unit;
	public final Object element;
	public final IEvlContext context;
	
	public EvlAtom(T construct, Object modelElement) {
		this(construct, modelElement, null);
	}
	
	public EvlAtom(T construct, Object modelElement, IEvlContext evlContext) {
		this.unit = construct;
		this.element = modelElement;
		this.context = evlContext;
	}
	
	public Entry<T, Object> asEntry() {
		return new SimpleEntry<>(unit, element);
	}
}
