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
package org.eclipse.epsilon.evl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class EvlConstraints implements Iterable {
	
	protected HashMap<String, EvlConstraint> storage = new HashMap<String, EvlConstraint>();
	
	public EvlConstraints() {
		super();
	}
	
	public void addConstraint(EvlConstraint constraint){
		storage.put(constraint.getName(), constraint);
	}
	
	public EvlConstraint getConstraint(String name){
		return storage.get(name);
	}
	
	public Collection values() {
		return storage.values();
	}
	
	public Iterator iterator() {
		return values().iterator();
	}

}
