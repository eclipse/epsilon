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

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class EolTypeWrapper {
	
	private static EolTypeWrapper instance = new EolTypeWrapper();
	
	public static EolTypeWrapper getInstance(){
		return instance;
	}
	
	public Object wrap(Object o){
		
		if (o == null) return o;
		
		if (o instanceof Integer){
			return new EolInteger(((Integer) o).intValue());
		} else if (o instanceof Long){
			return new EolInteger(((Long)o).intValue());
		} else if (o instanceof Boolean){
			return new EolBoolean(((Boolean)o).booleanValue());
		} else if (o instanceof String){
			return new EolString(o.toString());
		} else if (o instanceof Float) {
			return new EolReal(((Float)o).floatValue());
		} else if (o instanceof Double) {
			return new EolReal(((Double)o).floatValue());
		} else if (o instanceof Iterator){
			return new EolSequence((Iterator)o);
		} else if (o instanceof List){
			return new EolSequence((Collection)o);
		} else if (o instanceof Set){
			return new EolSet((Collection)o);
		} else if (o instanceof Collection){
			return new EolBag((Collection)o);
		} else if (o instanceof Iterable) {
			return new EolSequence((Iterable) o);
		} else if (o instanceof Object[]){
			return new EolSequence((Object[]) o);
		} else {
			return o;
		}
	}
	
	public Object unwrap(Object o){
		
		if (o == null) return o;
		
		if (o instanceof EolInteger){
			return new Integer(((EolInteger)o).intValue());
		} else if (o instanceof EolString){
			return new String(((EolString)o).stringValue());
		} else if (o instanceof EolReal){
			return new Float(((EolReal)o).floatValue());
		} else if (o instanceof EolBoolean){
			return new Boolean(((EolBoolean)o).booleanValue());
		} else if (o instanceof EolCollection){
			return ((EolCollection)o).getStorage();
		}
		
		return o;
	}

}
