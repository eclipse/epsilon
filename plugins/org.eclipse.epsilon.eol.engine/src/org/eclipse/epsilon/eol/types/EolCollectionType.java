/*******************************************************************************
 * Copyright (c) 2008-2012 The University of York, Antonio García-Domínguez.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 *     Antonio García Domínguez - add generics, clean up dead code.
 ******************************************************************************/
package org.eclipse.epsilon.eol.types;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.eclipse.epsilon.eol.exceptions.EolIllegalOperationParametersException;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.types.CollectionAnnotator.AnnotatedCollectionType;

public class EolCollectionType extends EolType {

	private String name;
		
	public static EolCollectionType Collection = new EolCollectionType("Collection");
	public static EolCollectionType Bag = new EolCollectionType("Bag");
	public static EolCollectionType Sequence = new EolCollectionType("Sequence");
	public static EolCollectionType Set = new EolCollectionType("Set");
	public static EolCollectionType OrderedSet = new EolCollectionType("OrderedSet");
	
	private EolCollectionType(String name){
		this.name = name;
	}
	
	public EolCollectionType getTypeOf(Collection<?> c) {
		AnnotatedCollectionType annotatedCollectionType = CollectionAnnotator.getInstance().getType(c);
		if (annotatedCollectionType != null) {
			if (annotatedCollectionType == AnnotatedCollectionType.Bag) return Bag;
			if (annotatedCollectionType == AnnotatedCollectionType.Sequence) return Sequence;
			if (annotatedCollectionType == AnnotatedCollectionType.Set) return Set;
			if (annotatedCollectionType == AnnotatedCollectionType.OrderedSet) return OrderedSet;
		}
		
		if (c instanceof EolSequence || (c instanceof List && !(c instanceof Set))) return Sequence;
		if (c instanceof EolOrderedSet || (c instanceof List && c instanceof Set)) return OrderedSet;
		if (c instanceof EolSet || (c instanceof Set && !(c instanceof List))) return Set;
		else return Bag;
	}
	
	@Override
	public boolean isType(Object o) {
		if (!(o instanceof Collection)) return false;
		Collection<?> c = (Collection<?>) o;
		if (this == Collection) return false; // Collection is abstract
		return getTypeOf(c) == this;
	}

	@Override
	public boolean isKind(Object o) {
		if (!(o instanceof Collection)) return false;
		
		if (this == Collection) return true;
		else if (this == Bag) return Bag.isType(o) || Sequence.isType(o);
		else if (this == Sequence) return Sequence.isType(o);
		else if (this == OrderedSet) return OrderedSet.isType(o);
		else if (this == Set) return Set.isType(o) || OrderedSet.isType(o); 
		
		return false;
	}
	
	@Override
	public Object createInstance() {
		try {
			if (this == Collection) return null;
			else if (this == Bag) {
				return new EolBag<Object>();
			}
			else if (this == Sequence) {
				return new EolSequence<Object>();
			}
			else if (this == OrderedSet) {
				return new EolOrderedSet<Object>();
			}
			else return new EolSet<Object>();
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public Object createInstance(List<Object> parameters)
			throws EolRuntimeException {
		throw new EolIllegalOperationParametersException("createInstance");
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	public static String getTypeName(Collection<?> c) {
		if (Bag.isType(c)) return Bag.getName();
		else if (Sequence.isType(c)) return Sequence.getName();
		else if (OrderedSet.isType(c)) return OrderedSet.getName();
		else if (Set.isType(c)) return Set.getName();
		else return c.getClass().getSimpleName();
	}
	
	public static <T> Collection<T> createSameType(Collection<T> c) {
		if (Bag.isType(c)) return new EolBag<T>();
		else if (Sequence.isType(c)) return new EolSequence<T>();
		else if (OrderedSet.isType(c)) return new EolOrderedSet<T>();
		else if (Set.isType(c)) return new EolSet<T>();
		else return null;
	}
	
	public static <T> Collection<T> clone(Collection<T> c) {
		Collection<T> clone = createSameType(c);
		clone.addAll(c);
		return clone;
	}
	
	public static <T> Collection<T> join(Collection<T> c1, Collection<T> c2) {
		Collection<T> joined = createSameType(c1);
		joined.addAll(c1);
		joined.addAll(c2);
		return joined;
	}
	
	public static boolean isUnique(Collection<?> c) {
		return Set.isType(c) || OrderedSet.isType(c);
	}
	
	public static boolean isOrdered(Collection<?> c) {
		return Sequence.isType(c) || OrderedSet.isType(c);
	}
	
}
