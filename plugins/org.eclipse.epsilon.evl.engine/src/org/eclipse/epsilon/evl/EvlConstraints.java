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

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.evl.execute.context.IEvlContext;

public class EvlConstraints implements Iterable {
	
	protected List<EvlConstraint> storage = new ArrayList<EvlConstraint>();
	
	//protected HashMap<String, EvlConstraint> storage = new HashMap<String, EvlConstraint>();
	
	public EvlConstraints() {
		super();
	}
	
	public void addConstraint(EvlConstraint constraint){
		storage.add(constraint);
	}
	
	public EvlConstraint getConstraint(String name, Object target, IEvlContext context) throws EolRuntimeException{
		for (EvlConstraint constraint : storage) {
			if (constraint.getName().equals(name) && constraint.appliesTo(target, context)) {
				return constraint;
			}
		}
		return null;
	}
	
	public Collection values() {
		return storage;
	}
	
	public Iterator iterator() {
		return storage.iterator();
	}

}
