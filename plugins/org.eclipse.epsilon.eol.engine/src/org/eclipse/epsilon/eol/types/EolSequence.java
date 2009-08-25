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
import java.util.Iterator;
import java.util.List;

public class EolSequence extends EolCollection{
	
	public EolSequence(){
		super();
	}
	
	public EolSequence(Iterable iterable) {
		Iterator it = iterable.iterator();
		
		this.storage = new ArrayList();
		while (it.hasNext()) {
			storage.add(it.next());
		}
	}
	
	public EolSequence(Iterator iterator) {
		this.storage = new ArrayList();
		while (iterator.hasNext()) {
			storage.add(iterator.next());
		}
	}
	
	public EolSequence(Collection collection){
		super(collection);
	}
	
	public EolSequence(Object[] array){
		super(array);
	}
	
	/**
	 * Returns the declared object
	 * as an XolSequence
	 * @param obj
	 * @return
	 */
	public static EolSequence asSequence(Object obj){
		EolSequence result = null;
		if (obj instanceof EolSequence){
			return (EolSequence) obj;
		}
		else if (obj instanceof EolCollection){
			result = new EolSequence(((EolCollection) obj).clone().getStorage());
		} else if (obj instanceof Collection){
			//TODO : See if this is needed
			result = new EolSequence((Collection) obj);
		} else if (obj instanceof Iterable) {
			result = new EolSequence((Iterable) obj);
		}
		 else {
			result = new EolSequence();
			result.add(obj);
		}
		return result;
	}
	
	/**
	 * Returns a new XolSequence that contains
	 * all the elements of the sequence plus
	 * <code>o</code> in the beginning
	 * @param o
	 * @return EolSequence
	 */
	public EolSequence prepend(Object o){
		EolSequence appended = new EolSequence(this.storage);
		appended.add(new EolInteger(0),o);
		return appended;		
	}
	
	
	
	/**
	 * Adds <code>o</code> to the sequence at the
	 * index <code>i</code>
	 * @param o
	 * @param i
	 * @return
	 */
	public void add(EolInteger i, Object o){
		//if (i.lessThan(this.size().add(new EolInteger(1))).booleanValue()){
		((List) storage).add(i.intValue(), o);
		//}
	}
	
	public EolSequence invert() {
		Iterator it = storage.iterator();
		EolSequence inverted = new EolSequence();
		while (it.hasNext()) {
			inverted.add(new EolInteger(0), it.next());
		}
		return inverted;
	}
	
	/**
	 * Returns a new sequence with <code>o</code>
	 * added at index <code>i</code>
	 * @param i
	 * @param o
	 * @return XolSequence
	 */
	public EolSequence insertAt(EolInteger i, Object o){
		EolSequence result = new EolSequence(this.storage);
		result.add(i, o);
		return result;
	}
	
	/**
	 * Returns a new subsequence that contains
	 * the elements of this sequence starting 
	 * from <code>lower</code> and ending at
	 * <code>upper</code>
	 * @param lower
	 * @param upper
	 * @return XolSequence
	 */
	public EolSequence subSequence(EolInteger lower, EolInteger upper){
		List sublist = ((List) storage).subList(lower.intValue(), upper.intValue());
		return new EolSequence(sublist);
	}
	
	@Override
	public EolCollection createCollection(){
		return new EolSequence();
	}
	
	@Override
	public EolCollection createCollection(Collection storage){
		return new EolSequence(storage);
	}
}
