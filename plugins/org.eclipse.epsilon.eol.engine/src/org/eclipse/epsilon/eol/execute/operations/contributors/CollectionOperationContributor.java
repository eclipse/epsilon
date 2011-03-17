package org.eclipse.epsilon.eol.execute.operations.contributors;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.epsilon.commons.util.CollectionUtil;
import org.eclipse.epsilon.commons.util.StringUtil;
import org.eclipse.epsilon.eol.types.EolBag;
import org.eclipse.epsilon.eol.types.EolCollectionType;
import org.eclipse.epsilon.eol.types.EolOrderedSet;
import org.eclipse.epsilon.eol.types.EolSequence;
import org.eclipse.epsilon.eol.types.EolSet;
import org.eclipse.epsilon.eol.types.NumberUtil;
import org.eclipse.epsilon.eol.types.ObjectUtil;

public class CollectionOperationContributor extends OperationContributor {
	
	public CollectionOperationContributor() {}
	
	public CollectionOperationContributor(Collection target) {
		this.target = target;
	}
	
	protected Collection getCollection() {
		return (Collection) target;
	}
	
	protected boolean isList() {
		return target instanceof List;
	}
	
	protected List getList() {
		return (List) target;
	}
	
	protected boolean isSet() {
		return target instanceof Set;
	}
	
	protected Set getSet() {
		return (Set) target;
	}
	
	@Override
	public boolean contributesTo(Object target) {
		return target instanceof Collection;
	}
	
	public Object random() {
		int index = (int) Math.round((Math.random() * getCollection().size()) + 0.5);
		return nth(index - 1);
	}
	
	public Object at(int index) {
		if (isList()) {
			return getList().get(index);
		}
		else {
			Iterator it = getCollection().iterator();
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
		if (target instanceof List) {
			return ((List) target).remove(index);
		}
		else {
			Object toRemove = new CollectionOperationContributor((Collection) target).at(index);
			((Collection) target).remove(toRemove);
			return toRemove;
		}
	}
	
	public List asSequence() {
		EolSequence copy = new EolSequence();
		copy(getCollection(), copy);
		return copy;
	}
	
	public EolSet asSet() {
		EolSet copy = new EolSet();
		copy(getCollection(), copy);
		return copy;
	}
	
	public EolBag asBag() {
		EolBag copy = new EolBag();
		copy(getCollection(), copy);
		return copy;
	}
	
	public EolOrderedSet asOrderedSet() {
		EolOrderedSet copy = new EolOrderedSet();
		copy(getCollection(), copy);
		return copy;
	}
	
	public Number sum() {
		Iterator it = getCollection().iterator();
		Number sum = 0;
		while (it.hasNext()){
			Object next = it.next();
			if (next instanceof Number){
				sum = NumberUtil.add(sum, (Number) next);
			}
		}
		return sum;
	}
	
	public Number product() {
		Iterator it = getCollection().iterator();
		
		if (isEmpty()) {
			return 0.0f;
		}
		
		Number product = 1;
		
		while (it.hasNext()){
			Object next = it.next();
			if (next instanceof Number){
				product = NumberUtil.multiply(product, (Number) next);
			}
		}
		return product;
	}
	
	public boolean isEmpty(){
		return getCollection().size() == 0;
	}
	
	public boolean notEmpty(){
		return !isEmpty();
	}
	
	protected void copy(Collection source, Collection target) {
		Iterator it = source.iterator();
		while (it.hasNext()) {
			target.add(it.next());
		}
	}
	
	public Collection<Object> clone() {
		return EolCollectionType.clone(getCollection());
	}
	
	public boolean includes(Object o) {
		return getCollection().contains(o);
	}
	
	public boolean excludes(Object o) {
		return !includes(o);
	}
	
	public boolean includesAll(Collection col) {
		for (Object item : col) {
			if (!includes(item)) return false;
		}
		return true;
	}
	
	public boolean excludesAll(Collection col) {
		for (Object item : col) {
			if (includes(item)) return false;
		}
		return true;
	}
	
	public int count(Object o) {
		int count = 0;
		for (Object item : getCollection()) {
			if (ObjectUtil.equals(item, o)) count ++;
		}
		return count;
	}
	
	public Collection includingAll(Collection col) {
		Collection result = createCollection();
		result.addAll(getCollection());
		result.addAll(col);
		return result;
	}
	
	public Collection including(Object o) {
		Collection result = createCollection();
		result.addAll(getCollection());
		result.add(o);
		return result;
	}
	
	/**
	 * TODO : See this
	 * @return
	 */
	public Collection flatten(){
		return CollectionUtil.flatten(getCollection());
	}
	
	public Collection excluding(Object o) {
		Collection excluding = createCollection();
		excluding.addAll(getCollection());
		while (excluding.contains(o)) {
			excluding.remove(o);
		}
		return excluding;
	}
	
	public Collection excludingAll(Collection col) {
		Collection difference = createCollection();
		for (Object next : getCollection()) {
			if (!col.contains(next)){
				difference.add(next);
			}
		}
		//The normal way would be to
		//use the removeAll method like
		//following but the MDR IndexSetWrapper
		//does not support it
		return difference;
	}
	
	public Object first(){
		return nth(0);
	}
	
	public Object second(){
		return nth(1);
	}
	
	public Object third(){
		return nth(2);
	}
	
	public Object fourth(){
		return nth(3);
	}
	
	public Object last(){
		return nth(getCollection().size() - 1);
	}
	
	public int indexOf(Object o) {
		if (isList()) {
			return getList().indexOf(o);
		}
		else {
			int counter = 0;
			for (Object item : getCollection()) {
				if (ObjectUtil.equals(item, o)) {
					return counter;
				}
				else {
					counter ++;
				}
			}
			return -1;
		}
	}
	
	private Object nth(int index) {
		if (this.isEmpty()) return null;
		return this.at(index);
	}
	
	public String concat() {
		return concat("");
	}
	
	public String concat(String delimiter) {
		final StringBuilder result = new StringBuilder();

		for (Iterator<?> iterator = getCollection().iterator(); iterator.hasNext();) {
			Object next = iterator.next();
			
			//FIXME : Use the pretty printer manager here
			result.append(StringUtil.toString(next, ""));
			
			if (iterator.hasNext()) {
				result.append(delimiter);
			}
		}
		return result.toString();
	}
	
	public Number max() {
		return max(0);
	}
	
	public Number max(Number default_) {
		Number max = null;
		for (Object next : getCollection()) {
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
		for (Object next : getCollection()) {
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
	
	public Collection subset(int lower, int upper) {
		return null;
	}
	
	public Collection invert() {
		EolSequence sequence = new EolSequence();
		for (Object o : getCollection()) {
			sequence.add(0, o);
		}
		return sequence;
	}
	
	public Collection createCollection() {
		return EolCollectionType.createSameType(getCollection());
	}
}
