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
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class EolSet extends EolCollection{
	
	// No TreeSet as it creates problems when comparing
	public EolSet(){
		storage = new HashSet();
		//storage = new TreeSet(new SimpleComparator());
	}
	
	public EolSet(Collection col){
		storage = col;
		//removeDuplicates();
	}
	
	@Override
	public void add(Object o){
		if (!storage.contains(o)){
			//System.err.println("EolSet " + storage.getClass() + " + " + o.getClass());
			storage.add(o);
		}
	}
	
	@Override
	public void addAll(EolCollection col){
		Iterator it = col.getStorage().iterator();
		while (it.hasNext()){
			Object o = it.next();
			if (!storage.contains(o)){
				storage.add(o);
			}
		}
	}
	
	
	protected void removeDuplicates(){
		List unique = new ArrayList();
		Iterator it = storage.iterator();
		while (it.hasNext()){
			Object next = it.next();
			if (!unique.contains(next)){
				unique.add(next);
			}
		}
		
		storage.clear();
		it = unique.iterator();
		while (it.hasNext()){
			storage.add(it.next());
		}
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
	
	class SimpleComparator implements Comparator {

		public int compare(Object arg0, Object arg1) {
			if (arg0 == null) {
				if (arg1 == null) {
					return 0;
				}
				else {
					return 1;
				}
			}
			else if (arg0 == arg1) {
				return 0;
			}
			else if (arg0.equals(arg1)){
				return 0;
			}
			else return 1;
		}
		
	}
}
