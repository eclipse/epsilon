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
package org.eclipse.epsilon.eol.types;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Collection;
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
	
	@Override
	public boolean isType(Object o) {
		
		if (!(o instanceof Collection)) return false;
		
		Collection c = (Collection) o;
		
		if (this == Collection) return false; // Collection is abstract
		else if (this == Bag) 
			return c instanceof EolBag || 
			CollectionAnnotator.getInstance().getType(c) == AnnotatedCollectionType.Bag;
		else if (this == Sequence) 
			return 
				c instanceof EolSequence || 
				(c instanceof List && !(c instanceof Set)) || 
				CollectionAnnotator.getInstance().getType(c) == AnnotatedCollectionType.Sequence;
		else if (this == OrderedSet) 
			return c instanceof EolOrderedSet || 
			(c instanceof List && c instanceof Set) || 
			CollectionAnnotator.getInstance().getType(c) == AnnotatedCollectionType.OrderedSet;
		else if (this == Set) {
			return c instanceof EolSet || 
			(c instanceof Set && !(c instanceof List)) || 
			CollectionAnnotator.getInstance().getType(c) == AnnotatedCollectionType.Set; 
		}
		return true;
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
				return new EolBag();
			}
			else if (this == Sequence) {
				return new EolSequence();
			}
			else if (this == OrderedSet) {
				return new EolOrderedSet();
			}
			else return new EolSet();
			
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
	
	public static String getTypeName(Collection c) {
		if (Bag.isType(c)) return Bag.getName();
		else if (Sequence.isType(c)) return Sequence.getName();
		else if (OrderedSet.isType(c)) return OrderedSet.getName();
		else if (Set.isType(c)) return Set.getName();
		else return c.getClass().getSimpleName();
	}
	
	public static Collection createSameType(Collection c) {
		if (Bag.isType(c)) return new EolBag();
		else if (Sequence.isType(c)) return new EolSequence();
		else if (OrderedSet.isType(c)) return new EolOrderedSet();
		else if (Set.isType(c)) return new EolSet();
		else return null;
	}
	
	public static Collection clone(Collection c) {
		Collection clone = createSameType(c);
		clone.addAll(c);
		return clone;
	}
	
	public static Collection join(Collection c1, Collection c2) {
		Collection joined = createSameType(c1);
		joined.addAll(c1);
		joined.addAll(c2);
		return joined;
	}
	
	public static boolean isUnique(Collection c) {
		return Set.isType(c) || OrderedSet.isType(c);
	}
	
	public static boolean isOrdered(Collection c) {
		return Sequence.isType(c) || OrderedSet.isType(c);
	}
	
}
