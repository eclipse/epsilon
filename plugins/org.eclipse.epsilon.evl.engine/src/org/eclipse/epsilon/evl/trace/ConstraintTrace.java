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
package org.eclipse.epsilon.evl.trace;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import org.eclipse.epsilon.evl.EvlConstraint;

//FIXME : Make the ConstraintTrace iterable so that it can be used from EOL code
public class ConstraintTrace implements Iterable{
	
	HashMap storage = new HashMap();
	ArrayList iterable = new ArrayList();
	
	public ConstraintTrace() {
		super();
	}
	
	public void addChecked(EvlConstraint constraint, Object object, boolean result){
		HashMap results;
		results = (HashMap) storage.get(object);
		if (results == null){
			results = new HashMap();
			storage.put(object, results);
		}
		results.put(constraint, result);
		iterable.add(new ConstraintTraceItem(object, constraint, result));
	}
	
	public boolean isChecked(EvlConstraint constraint, Object object) {
		HashMap results;
		results = (HashMap) storage.get(object);	
		if (results == null){
			return false;
		}
		else {
			return results.get(constraint) != null;
		}
	}
	
	public boolean isSatisfied(EvlConstraint constraint, Object object) {
		HashMap results;
		results = (HashMap) storage.get(object);
		if (results == null){
			return false;
		}
		else {
			return ((Boolean)results.get(constraint)).booleanValue();
		}
	}

	public Iterator iterator() {
		return iterable.iterator();
	}
	
}
