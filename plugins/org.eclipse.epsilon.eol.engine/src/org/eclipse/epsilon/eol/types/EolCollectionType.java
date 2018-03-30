/*******************************************************************************
 * Copyright (c) 2008-2013 The University of York, Antonio García-Domínguez.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 *     Antonio García Domínguez - add generics, clean up dead code,
 *                                remove type cache (bug #410403).
 ******************************************************************************/
package org.eclipse.epsilon.eol.types;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.epsilon.eol.exceptions.EolIllegalOperationParametersException;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;

public class EolCollectionType extends EolType {
	
	protected static Set<IEolCollectionTypeResolver> collectionTypeResolvers;
	protected EolType contentType = EolAnyType.Instance;
	
	public static Set<IEolCollectionTypeResolver> getCollectionTypeResolvers() {
		if (collectionTypeResolvers == null) {
			collectionTypeResolvers = new HashSet<>();
		}
		return collectionTypeResolvers;
	}
	
	private String name;
	
	public static EolCollectionType Collection = new EolCollectionType("Collection");
	public static EolCollectionType Bag = new EolCollectionType("Bag");
	public static EolCollectionType Sequence = new EolCollectionType("Sequence");
	public static EolCollectionType Set = new EolCollectionType("Set");
	public static EolCollectionType OrderedSet = new EolCollectionType("OrderedSet");
	
	public EolCollectionType(String name) {
		this.name = name;
	}
	
	public EolCollectionType(String name, EolType contentType) {
		this(name);
		this.contentType = contentType;
	}
	
	public EolCollectionType getTypeOf(Collection<?> c) {
		if (c instanceof EolSequence) return Sequence;
		else if (c instanceof EolOrderedSet) return OrderedSet;
		else if (c instanceof EolSet) return Set;
		else if (c instanceof EolBag) return Bag;

		for (IEolCollectionTypeResolver collectionTypeResolver : getCollectionTypeResolvers()) {
			if (collectionTypeResolver.canResolveType(c)) {
				return collectionTypeResolver.resolveType(c);
			}
		}

		if (c instanceof List) return (c instanceof Set) ? OrderedSet : Sequence;
		else if (c instanceof Set) return Set;
		else return Bag;
	}
	
	public static void main(String[] args) throws Exception {
		EolModule module = new EolModule();
		module.parse("Set{}.isTypeOf(Set).println();");
		module.execute();
	}
	
	@Override
	public boolean isType(Object o) {
		
		if (!(o instanceof Collection)) return false;
		Collection<?> c = (Collection<?>) o;
		if (this.isCollection()) return false; // Collection is abstract
		return getTypeOf(c).getName() == this.getName();
	}

	@Override
	public boolean isKind(Object o) {
		if (!(o instanceof Collection)) return false;
		
		EolCollectionType collectionType = getTypeOf((Collection<?>) o);
		
		if (this.isCollection()) return true;
		else if (this.isBag()) return collectionType.isBag() || collectionType.isSequence();
		else if (this.isSequence()) return collectionType.isSequence();
		else if (this.isOrderedSet()) return collectionType.isOrderedSet();
		else if (this.isSet()) return collectionType.isSet() || collectionType.isOrderedSet(); 
		
		return false;
	}
	
	@Override
	public Object createInstance() {
		try {
			if (this.isCollection()) return null;
			else if (this.isBag()) {
				return new EolBag<>();
			}
			else if (this.isSequence()) {
				return new EolSequence<>();
			}
			else if (this.isOrderedSet()) {
				return new EolOrderedSet<>();
			}
			else return new EolSet<>();
			
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
		if (Bag.isType(c)) return new EolBag<>();
		else if (Sequence.isType(c)) return new EolSequence<>();
		else if (OrderedSet.isType(c)) return new EolOrderedSet<>();
		else if (Set.isType(c)) return new EolSet<>();
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
	
	public boolean isBag() {
		return getName().equals("Bag");
	}
	
	public boolean isSequence() {
		return getName().equals("Sequence");
	}
	
	public boolean isSet() {
		return getName().equals("Set");
	}
	
	public boolean isOrderedSet() {
		return getName().equals("OrderedSet");
	}
	
	public boolean isCollection() {
		return getName().equals("Collection");
	}
	
	public EolType getContentType() {
		return contentType;
	}
	
	public void setContentType(EolType contentType) {
		this.contentType = contentType;
	}
	
	@Override
	public String toString() {
		return this.getName() + "<" + this.getContentType() + ">";
	}	
}
