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
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.eclipse.epsilon.commons.util.ListSet;

public class EolSet extends EolCollection{
	
	// No TreeSet as it creates problems when comparing
	public EolSet(){
		//storage = new ArrayList();
		storage = new HashSet();
		//storage = new TreeSet(new EntryOrderComparator());
		//storage = new ListSet();
	}
	
	/**
	 * Creates a new EolSet from a collection
	 * @pre col must not contain duplicates
	 * @param col
	 */
	public EolSet(Collection col){
		storage = col;
		//removeDuplicates();
	}
	
	@Override
	public void add(Object o){
		if (!includes(o).booleanValue()){
			//System.err.println("EolSet " + storage.getClass() + " + " + o.getClass());
			storage.add(o);
		}
	}
	
	@Override
	public void addAll(EolCollection col){
		Iterator it = col.getStorage().iterator();
		while (it.hasNext()){
			Object o = it.next();
			if (!includes(o).booleanValue()){
				storage.add(o);
			}
		}
	}
	
	protected void removeDuplicates(){
		List unique = new ArrayList();
		Iterator it = storage.iterator();
		while (it.hasNext()){
			DualStateObject dso = new DualStateObject(it.next());
			if (!unique.contains(dso.getWrapped()) && !unique.contains(dso.getUnwrapped())){
				unique.add(dso.getUnwrapped());
			}
		}
		//try {
			storage.clear();
			it = unique.iterator();
			while (it.hasNext()){
				storage.add(it.next());
			}
		//}
		//catch (Exception ex) {
			// Unmodifiable collection - do nothing
		//}
	}
	
	public static EolSet asSet(Object obj){
		if (obj instanceof EolSet){
			return (EolSet)obj;
		}
		else if (obj instanceof EolCollection) {
			EolSet result = new EolSet(((EolCollection)obj).clone().getStorage());
			result.removeDuplicates();
			return result;
		}
		else{
			EolSet result = new EolSet();
			result.add(obj);
			return result;
		}
	}

	@Override
	public EolCollection createCollection() {
		return new EolSet();
	}

	@Override
	public EolCollection createCollection(Collection storage) {
		return new EolSet(storage);
	}
	
	class EntryOrderComparator implements Comparator {

		public int compare(Object o1, Object o2) {
			
			if (o1 == null && o2 == null) return 0;
			if (o1 == null || o2 == null) return 1;
			
			DualStateObject dso1 = new DualStateObject(o1);
			DualStateObject dso2 = new DualStateObject(o2);
			
			if (dso1.getWrapped().equals(dso2.getWrapped()) || dso1.getUnwrapped().equals(dso2.getUnwrapped())) return 0;
			
			return 1;
		}
		
	}
}
