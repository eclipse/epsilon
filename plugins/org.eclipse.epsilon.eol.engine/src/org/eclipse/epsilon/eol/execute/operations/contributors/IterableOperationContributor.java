/*******************************************************************************
 * Copyright (c) 2012 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.eol.execute.operations.contributors;

import java.util.*;
import org.eclipse.epsilon.common.util.CollectionUtil;
import org.eclipse.epsilon.common.util.StringUtil;
import org.eclipse.epsilon.eol.types.EolBag;
import org.eclipse.epsilon.eol.types.EolCollectionType;
import org.eclipse.epsilon.eol.types.EolOrderedSet;
import org.eclipse.epsilon.eol.types.EolSequence;
import org.eclipse.epsilon.eol.types.EolSet;
import org.eclipse.epsilon.eol.types.NumberUtil;

public class IterableOperationContributor extends OperationContributor {

	public IterableOperationContributor() {}
	
	public static void main(String[] args) {
		
		Collection<Object> c = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			c.add(i);
		}
		IterableOperationContributor ioc = new IterableOperationContributor(c);
		System.out.println(ioc.first(10));
		
	}
	
	public IterableOperationContributor(Iterable<?> target) {
		this.target = target;
	}

	@SuppressWarnings("unchecked")
	protected Iterable<Object> getIterable() {
		return (Iterable<Object>) target;
	}

	protected boolean isCollection() {
		return target instanceof Collection;
	}

	@SuppressWarnings("unchecked")
	protected Collection<Object> getCollection() {
		return (Collection<Object>) target;
	}

	protected boolean isList() {
		return target instanceof List;
	}
	
	protected List<?> getList() {
		return (List<?>) target;
	}
	
	protected boolean isSet() {
		return target instanceof Set;
	}
	
	protected Set<?> getSet() {
		return (Set<?>) target;
	}
	
	@Override
	public boolean contributesTo(Object target) {
		return target instanceof Iterable;
	}
	
	public Object random() {
		if (isEmpty()) return null;
		final int size = size();
		return nth(size > 0 ? new Random().nextInt(size) : 0);
	}

	public int size() {
		if (isCollection()) {
			return getCollection().size();
		} else {
			int size = 0;
			for (Iterator<Object> it = getIterable().iterator(); it.hasNext(); ++size) {
				it.next();
			}
			return size;
		}
	}

	public Object at(int index) {
		if (isList()) {
			return getList().get(index);
		}
		else {
			Iterator<?> it = getIterable().iterator();
			int i = 0;
			while (it.hasNext()) {
				Object next = it.next();
				if (i == index) return next;
				else i++;
			}
		}
		return null;
	}
	
	public Object removeAt(int index) {
		if (isList()) {
			return getList().remove(index);
		}
		else {
			Object toRemove = null;
			Iterator<?> it = getIterable().iterator();
			int i;
			for (i = 0; it.hasNext() && i <= index; ++i) {
				toRemove = it.next();
			}
			if (toRemove != null && i == index + 1) {
				it.remove();
			}
			return toRemove;
		}
	}

	public List<Object> asSequence() {
		EolSequence<Object> copy = new EolSequence<>();
		copy(getIterable(), copy);
		return copy;
	}
	
	public EolSet<Object> asSet() {
		EolSet<Object> copy = new EolSet<>();
		copy(getIterable(), copy);
		return copy;
	}
	
	public EolBag<Object> asBag() {
		EolBag<Object> copy = new EolBag<>();
		copy(getIterable(), copy);
		return copy;
	}
	
	public EolOrderedSet<Object> asOrderedSet() {
		EolOrderedSet<Object> copy = new EolOrderedSet<>();
		copy(getIterable(), copy);
		return copy;
	}
	
	public Number sum() {
		Number sum = 0;
		for (Object next : getIterable()) {
			if (next instanceof Number){
				sum = NumberUtil.add(sum, (Number) next);
			}
		}
		return sum;
	}
	
	public Number product() {
		if (isEmpty()) {
			return 0.0f;
		}

		Number product = 1;
		for (Object next : getIterable()) {
			if (next instanceof Number){
				product = NumberUtil.multiply(product, (Number) next);
			}
		}
		return product;
	}
	
	public boolean isEmpty() {
		if (target instanceof Collection<?>) return ((Collection<?>) target).isEmpty();
		return !getIterable().iterator().hasNext();
	}

	public boolean notEmpty(){
		return !isEmpty();
	}
	
	protected <T> void copy(Iterable<T> source, Collection<T> target) {
		Iterator<T> it = source.iterator();
		while (it.hasNext()) {
			target.add(it.next());
		}
	}

	@Override
	public Collection<?> clone() {
		// May require its own contributor
		if (isCollection()) {
			return EolCollectionType.clone(getCollection());
		}
		return null;
	}

	public boolean includes(Object key) {
		if (isCollection()) {
			return getCollection().contains(key);
		} else {
			Iterator<?> it = getIterable().iterator();
			while (it.hasNext()) {
				Object o = it.next();
				if (Objects.equals(o, key)) {
					return true;
				}
			}
			return false;
		}
	}
	
	public boolean excludes(Object o) {
		return !includes(o);
	}
	
	public boolean includesAll(Collection<?> col) {
		for (Object item : col) {
			if (!includes(item)) return false;
		}
		return true;
	}
	
	public boolean excludesAll(Collection<?> col) {
		for (Object item : col) {
			if (includes(item)) return false;
		}
		return true;
	}
	
	public int count(Object o) {
		int count = 0;
		for (Object item : getIterable()) {
			if (Objects.equals(item, o)) count ++;
		}
		return count;
	}

	public Collection<Object> includingAll(Collection<Object> col) {
		Collection<Object> result = createCollection();
		addAll(getIterable(), result);
		addAll(col, result);
		return result;
	}

	public Collection<Object> including(Object o) {
		Collection<Object> result = createCollection();
		addAll(getIterable(), result);
		result.add(o);
		return result;
	}

	/**
	 * TODO : See this
	 * @return
	 */
	public Collection<Object> flatten() {
		Collection<Object> col;
		if (isCollection()) {
			col = getCollection();
		}
		else {
			col = createCollection();
			addAll(getIterable(), col);
		}
		return CollectionUtil.flatten(col);
	}

	public Collection<Object> excluding(Object o) {
		Collection<Object> excluding = createCollection();
		addAll(getIterable(), excluding);
		while (excluding.contains(o)) {
			excluding.remove(o);
		}
		return excluding;
	}

	public Collection<Object> excludingAll(Collection<?> col) {
		Collection<Object> difference = createCollection();
		for (Object next : getIterable()) {
			if (!col.contains(next)){
				difference.add(next);
			}
		}
		/*
		 * The normal way would be to use the removeAll method like following
		 * but the MDR IndexSetWrapper does not support it.
		 */
		return difference;
	}
	
	public Collection<Object> first(int number) {
		Iterator<Object> it = getIterable().iterator();
		ArrayList<Object> result = new ArrayList<>();
		int i = 0;
		while (it.hasNext() && i < number) {
			result.add(it.next());
			i++;
		}
		return result;
	}
	
	public Object first() {
		return nth(0);
	}
	
	public Object second() {
		return nth(1);
	}
	
	public Object third() {
		return nth(2);
	}
	
	public Object fourth() {
		return nth(3);
	}
	
	public Object last() {
		if (isCollection()) {
			return nth(getCollection().size() - 1);
		}
		else {
			final Iterator<Object> it = getIterable().iterator();
			Object o = null;
			while (it.hasNext()) {
				o = it.next();
			}
			return o;
		}
	}
	
	public int indexOf(Object o) {
		if (isList()) {
			return getList().indexOf(o);
		}
		else {
			int counter = 0;
			for (Object item : getIterable()) {
				if (Objects.equals(item, o)) {
					return counter;
				}
				counter++;
			}
			return -1;
		}
	}
	
	private Object nth(int index) {
		if (isEmpty()) return null;
		return at(index);
	}
	
	public String concat() {
		return concat("");
	}
	
	public String concat(String delimiter) {
		return CollectionUtil.join(getIterable(), delimiter, new CollectionUtil.ElementPrinter() {
			@Override
			public String print(Object element) {
				//FIXME : Use the pretty printer manager here
				return StringUtil.toString(element, "");
			}
		});
	}
	
	public Number max() {
		return max(0);
	}
	
	public Number max(Number default_) {
		Number max = null;
		for (Object next : getIterable()) {
			if (next instanceof Number) {
				Number nextNumber = (Number) next;
				if (max == null) {
					max = nextNumber;
				}
				else {
					if (NumberUtil.greaterThan(nextNumber, max)) {
						max = nextNumber;
					}
				}
			}
		}
		if (max == null) 
			max = default_;
		
		return max;
	}
	
	public Number min() {
		return min(0);
	}
	
	public Number min(Number default_) {
		Number min = null;
		for (Object next : getIterable()) {
			if (next instanceof Number) {
				Number nextNumber = (Number) next;
				if (min == null) {
					min = nextNumber;
				}
				else {
					if (NumberUtil.lessThan(nextNumber, min)) {
						min = nextNumber;
					}
				}
			}
		}
		if (min == null) 
			min = default_;
		
		return min;
	}
	
	public Collection<Object> invert() {
		EolSequence<Object> sequence = new EolSequence<>();
		for (Object o : getIterable()) {
			sequence.add(0, o);
		}
		return sequence;
	}

	public Collection<Object> createCollection() {
		if (isCollection()) {
			return EolCollectionType.createSameType(getCollection());
		} else {
			return new EolSequence<>();
		}
	}
	
	public Set<Set<Object>> powerset() {
		
		List<Object> originalSet = asSequence();
		
		Set<Set<Object>> sets = new HashSet<>();
	    if (originalSet.isEmpty()) {
	    	sets.add(new HashSet<>());
	    	return sets;
	    }
	    
	    Object head = originalSet.get(0);
	    Set<Object> rest = new HashSet<>(originalSet.subList(1, originalSet.size())); 
	    for (Set<Object> set : new IterableOperationContributor(rest).powerset()) {
	    	Set<Object> newSet = new HashSet<>();
	    	newSet.add(head);
	    	newSet.addAll(set);
	    	sets.add(newSet);
	    	sets.add(set);
	    }		
	    return sets;
	}
	
	private static void addAll(final Iterable<Object> elements, Collection<Object> target) {
		if (elements instanceof Collection) {
			target.addAll((Collection<Object>)elements);
		}
		else {
			for (Object o : elements) {
				target.add(o);
			}
		}
	}
}
