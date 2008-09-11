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

import java.util.TreeMap;

public class EolMap extends TreeMap<Object, Object>{

	public static void main(String[] args) {
		
		EolMap m = new EolMap();
		
		m.put(new EolString("a"), 5);
		
		Object o = m.get(new EolString("a"));
		
		System.err.println(o);
		
	}
	
	/*
	private HashMap storage;
	
	public EolMap() {
		super();
		storage = new HashMap();
	}
	
	public void put(EolString key, Object value){
		storage.put(key.getValue(),value);
	}
	
	public Object get(EolString key){
		return storage.get(key.getValue());
	}
	
	public EolBoolean contains(EolString key) {
		return new EolBoolean(storage.containsKey(key.getValue()));
	}
	
	@Override
	public String toString() {
		Iterator it = storage.keySet().iterator();
		String str = "[";
		while (it.hasNext()){
			String key = it.next().toString();
			str += key + "=" + String.valueOf(storage.get(key));
			if (it.hasNext()){
				str += ", ";
			}
		}
		str += "]";
		return str;
	}
	*/
}
