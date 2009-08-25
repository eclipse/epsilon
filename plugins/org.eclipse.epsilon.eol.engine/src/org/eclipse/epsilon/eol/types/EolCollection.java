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
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.eclipse.epsilon.commons.util.StringUtil;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.prettyprinting.PrettyPrinterManager;

public abstract class EolCollection extends EolAny{
	
	//TODO : Add a modifiable property to check if the 
	// collection is modifiable. Then add checks in all
	// the functions that change the collection. Finally
	// revise the method in TypeWrapper where we create
	// a sequence from an Iterable and make the resulting
	// sequence non-modifiable. We can also set the 
	// modifiable property from model-specific
	// property getters
	
	protected Collection storage; // The internal storage
	
	public EolCollection(Collection storage){
		this.storage = storage;
	}
	
	public EolCollection(){
		storage = new ArrayList();
	}
	
	/*
	public boolean equals(Object other) {
		if (other instanceof EolCollection) {
			EolCollection col = (EolCollection) other;
			if (isUnique()) {
				if (!col.size().equals(size())) return false;
				
				for (int i = 0; i < col.size().intValue(); i++) {
					if (!col.at(new EolInteger(i)).equals(this.at(new EolInteger(i)))) {
						return false;
					}
				}
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}
	*/
	
	public boolean isOrdered() {
		return this instanceof EolSequence || this instanceof EolOrderedSet;
	}
	
	public boolean isUnique() {
		return this instanceof EolSet || this instanceof EolOrderedSet;
	}
	
	public EolCollection(Object[] array){
		storage = new ArrayList();
		for (int i=0; i<array.length;i++){
			storage.add(array[i]);
		}
	}
		
	/**
	 * Returns the interal storage
	 * of the collection
	 * @return java.util.Collection
	 */
	public Collection getStorage(){
		return storage;
	}
	
	@Override
	public EolCollection clone(){
		EolCollection clone = createCollection();
		clone.addAll(this);
		return clone;
	}
	
	public void clear() {
		storage.clear();
	}
	
	/**
	 * Returns the size of the collection
	 * @return EolInteger
	 */
	public EolInteger size(){
		return new EolInteger(storage.size());
	}
	
	/**
	 * Returns true if the collection includes
	 * the declared object and false
	 * otherwise
	 * @param col The object
	 * @return EolBoolean
	 */	
	public EolBoolean includes(Object o){
		DualStateObject dso = new DualStateObject(o);
		for (Object i : storage) {
			if (i == null && o == null) return EolBoolean.TRUE;
			if (i == null || o == null) continue;
			if (dso.getWrapped().equals(i) || dso.getUnwrapped().equals(i)) return EolBoolean.TRUE;
		}
		return EolBoolean.FALSE;
		//return new EolBoolean(storage.contains(dso.getWrapped()) || storage.contains(dso.getUnwrapped()));
	}
	
	/**
	 * Returns true if the collection excludes
	 * the declared object and false
	 * otherwise
	 * @param col The object
	 * @return EolBoolean
	 */
	public EolBoolean excludes(Object o){
		return includes(o).not();
	}
	
	/**
	 * Returns true if the collection includes
	 * all the declared elements and false
	 * otherwise
	 * @param col The collection of the included elemetns
	 * @return EolBoolean
	 */	
	public EolBoolean includesAll(EolCollection col){
		Iterator it = storage.iterator();
		while (it.hasNext()){
			if (includes(it.next()).not().booleanValue()) return EolBoolean.FALSE;
		}
		return EolBoolean.TRUE;
	}
	
	/**
	 * Returns true if the collection excludes
	 * all the declared elements and false
	 * otherwise
	 * @param col The collection of the excluded elemetns
	 * @return EolBoolean
	 */
	public EolBoolean excludesAll(EolCollection col){
		Iterator it = storage.iterator();
		while (it.hasNext()){
			if (includes(it.next()).booleanValue()) return EolBoolean.FALSE;
		}
		return EolBoolean.TRUE;
	}
	
	/**
	 * Returns how many times object o
	 * exists in the collection
	 * @param o The object
	 * @return EolInteger
	 */
	public EolInteger count(Object o){
		
		DualStateObject dso = new DualStateObject(o);
		
		Iterator it = storage.iterator();
		int count = 0;
		while (it.hasNext()){
			Object next = it.next();
			if (dso.getWrapped().equals(next) || dso.getUnwrapped().equals(next)) {
				count++;
			}
		}
		return new EolInteger(count);
	}


	
	/**
	 * Returns true if the collection is
	 * empty
	 * @return EolBoolean
	 */
	public EolBoolean isEmpty(){
		return new EolBoolean(storage.size() == 0);
	}
	
	/**
	 * Returns true if the collection is not empty
	 * @return EolBoolean
	 */
	public EolBoolean notEmpty(){
		return isEmpty().not();
	}
	
	/**
	 * Adds the object to the end 
	 * of the sequence
	 * @param o
	 * @return EolVoid
	 */
	public void add(Object o){
		try {
			storage.add(o);
		}
		catch (Throwable t){
			t.printStackTrace();
		}
	}
	
	/**
	 * Adds all the object of the 
	 * <code>col</code> collection
	 * to this collection
	 * @param col
	 */
	public void addAll(EolCollection col){
		storage.addAll(col.getStorage());
	}
	
	public EolCollection includingAll(EolCollection col){
		EolCollection result = createCollection();
		result.addAll(this);
		result.addAll(col);
		return result;
	}
	
	public EolCollection including(Object o){
		EolCollection result = createCollection();
		result.addAll(this);
		result.add(o);
		return result;		
	}
	
	/**
	 * Removes <code>o</code> from
	 * the collection
	 * @param o
	 * @return
	 */
	public void remove(Object o){
		DualStateObject dso = new DualStateObject(o);
		storage.remove(dso.getWrapped());
		storage.remove(dso.getUnwrapped());
	}
	
	/**
	 * Removes all the object of the 
	 * <code>col</code> collection
	 * from this collection
	 * @param col
	 * @return EolVoid
	 */
	public void removeAll(EolCollection col){
		//TODO: Throw an unmodifiable collection exception in case that fails?
		for (Object o : col.getStorage()) {
			remove(o);
		}
	}
	
	/**
	 * Returns a flattened version of the collection
	 * @return EolSequence
	 */
	public EolCollection flatten(){
		
		// First see if there are no nested collections
		// and in this case just return this
		
		boolean hasNested = false;
		for (Object o : storage) {
			if (o instanceof EolCollection) {
				hasNested = true;
				break;
			}
		}
		
		if (!hasNested) return this;
		
		// If there are nested collections
		
		EolCollection flattened = createCollection();
		Iterator it = storage.iterator();
		while (it.hasNext()){
			Object next = it.next();
			if (next instanceof EolCollection){
				flattened.addAll(((EolCollection)next).flatten());
			}
			else {
				flattened.add(next);
			}
		}
		return flattened;
	}
	
	
	/**
	 * Returns the difference of this sequence with
	 * sequence <code>seq</code>
	 * @param col
	 * @return EolSequence
	 */
	public EolCollection excludingAll(EolCollection col){
		EolCollection difference = createCollection();
		Iterator it = iterator();
		while (it.hasNext()){
			Object next = it.next();
			DualStateObject dso = new DualStateObject(next);
			if (!col.includes(next).booleanValue()){
				difference.add(next);
			}
		}
		//The normal way would be to
		//use the removeAll method like
		//following but the MDR IndexSetWrapper
		//does not support it
		return difference;
	}	
	
	/**
	 * Returns the iterator of the internal
	 * storage collection
	 * @return java.util.Iterator
	 */
	public Iterator iterator(){
		return storage.iterator();
	}

	/*
	public boolean equals(Object other) {
		if (other == null) return false;
		if (other.getClass()!=this.getClass()) return false;
		EolCollection otherCollection = (EolCollection) other;
		
		if (this.size().intValue() != otherCollection.size().intValue()) return false;
		
		if (this.isOrdered()) {
			int index = 0;
			for (Object otherObject : otherCollection.getStorage()) {
				
			}
		}
		
	}*/
	
	public static EolCollection asCollection(Object obj) {
		if (obj instanceof EolCollection)
			return (EolCollection) obj;
		else if (obj instanceof EolModelElementType ){
			return new EolSequence(((EolModelElementType)obj).all());
		}
		else{
			EolCollection result = new EolBag();
			result.add(obj);
			return result;
		}
	}
	
	public Object first(){
		if (this.isEmpty().booleanValue()) return null;
		return this.at(new EolInteger(0));
	}
	
	public Object last(){
		if (this.isEmpty().booleanValue()) return null;
		return this.at(new EolInteger(storage.size() - 1));
	}
	
	
	/**
	 * Returns the index of <code>o</code> in
	 * the sequence or <code>-1</code> if it 
	 * does not exist in the sequence
	 * @param o
	 * @return EolInteger
	 */
	public EolInteger indexOf(Object o){
		
		Iterator it = storage.iterator();
		DualStateObject dso = new DualStateObject(o);
		int counter = 0;
		
		while (it.hasNext()){
			Object next = it.next();
			
			if (dso.getWrapped().equals(next) || dso.getUnwrapped().equals(next)) {
				return new EolInteger(counter);
			}
			else {
				counter ++;
			}
		}
		
		return new EolInteger(-1);
		
	}
	
	/**
	 * Returns the object stored under index
	 * <code>i</code> in the sequence
	 * @param i
	 * @return java.lang.Object
	 */
	public Object at(EolInteger i){
		Iterator it = storage.iterator();
		int counter = 0;
		while (it.hasNext()){
			Object next = it.next();
			if (i.intValue() == counter){
				return next;
			}
			counter ++;
		}
		return null;
	}
	
	/**
	 * Returns a new sequence that
	 * contains the elements of this
	 * sequence except <code>o</code>
	 * @param seq
	 * @return EolSequence
	 */
	public EolCollection excluding(Object o){
		DualStateObject dso = new DualStateObject(o);
		EolCollection result = createCollection();
		for (Object item : storage) {
			if (!(dso.getWrapped().equals(item) || dso.getUnwrapped().equals(item))) {
				result.add(item);
			}
		}
		return result;
	}
		
	public EolReal sum() {
		Iterator it = this.storage.iterator();
		EolReal sum = new EolReal();
		while (it.hasNext()){
			DualStateObject dso = new DualStateObject(it.next());
			if (dso.getWrapped() instanceof EolReal){
				sum = sum.add((EolReal) dso.getWrapped());
			}
		}
		return sum;
	}
	
	public EolReal product() {
		Iterator it = this.storage.iterator();
		
		if (isEmpty().value) {
			return new EolReal(0.0, true);
		}
		
		EolReal product = new EolReal(1.0, true);
		
		while (it.hasNext()){
			DualStateObject dso = new DualStateObject(it.next());
			if (dso.getWrapped() instanceof EolReal){
				product = product.multiply((EolReal) dso.getWrapped());
			}
		}
		return product;
	}
	
	public EolString concat(String delimiter) {
		String str = "";
		Iterator it = this.storage.iterator();
		while (it.hasNext()) {
			Object next = it.next();
			//FIXME : Use the pretty printer manager here
			str += StringUtil.toString(next, "");
			if (it.hasNext()) {
				str += delimiter;
			}
		}
		return new EolString(str);
	}
	
	public EolReal max() {
		return max(new EolInteger(0));
	}
	
	public EolReal max(EolReal default_) {
		Iterator it = this.storage.iterator();
		EolReal max = null;
		while (it.hasNext()){
			DualStateObject dso = new DualStateObject(it.next());
			if (dso.getWrapped() instanceof EolReal) {
				EolReal nextReal = (EolReal) dso.getWrapped();
				if (max == null) {
					max = nextReal;
				}
				else {
					if (nextReal.greaterThan(max).booleanValue()) {
						max = nextReal;
					}
				}
			}
		}
		if (max == null) 
			max = default_;
		
		return max;
	}
	
	public EolReal min() {
		return min(new EolInteger(0));
	}
	
	public EolReal min(EolReal default_) {
		Iterator it = this.storage.iterator();
		EolReal min = null;
		while (it.hasNext()){
			DualStateObject dso = new DualStateObject(it.next());
			if (dso.getWrapped() instanceof EolReal) {
				EolReal nextReal = (EolReal) dso.getWrapped();
				if (min == null) {
					min = nextReal;
				}
				else {
					if (nextReal.lessThan(min).booleanValue()) {
						min = nextReal;
					}
				}
			}
		}
		if (min == null) 
			min = default_;
		
		return min;
	}
	
	public boolean equals(EolCollection col){
		return this.getStorage().equals(col.getStorage());
	}
	
	public EolSet asSet(){
		return EolSet.asSet(this);
	}
	
	public EolSequence asSequence(){
		return EolSequence.asSequence(this);
	}
	
	public void sort(PrettyPrinterManager ppm) throws EolRuntimeException {
		Collections.sort((List)storage, new EolComparator(ppm));
	}
	
	private class EolComparator implements Comparator<Object> {

		private final PrettyPrinterManager ppm;
		
		public EolComparator(PrettyPrinterManager ppm) {
			this.ppm = ppm;
		}
		
		public int compare(Object o1, Object o2) {
			if (o1 instanceof Comparable && o2 instanceof Comparable) {
				return ((Comparable)o1).compareTo(o2);
			} else {
				return ppm.toString(o1).compareTo(ppm.toString(o2));
			}
		}
	}
	 
	public abstract EolCollection createCollection();
	
	public abstract EolCollection createCollection(Collection storage);
	
}
