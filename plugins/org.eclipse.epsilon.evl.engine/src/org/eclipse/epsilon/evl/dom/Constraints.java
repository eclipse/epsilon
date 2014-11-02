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
package org.eclipse.epsilon.evl.dom;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.evl.execute.context.IEvlContext;

public class Constraints implements Iterable<Constraint> {
	
	protected List<Constraint> storage = new ArrayList<Constraint>();
	
	//protected HashMap<String, EvlConstraint> storage = new HashMap<String, EvlConstraint>();
	
	public Constraints() {
		super();
	}
	
	public void addConstraint(Constraint constraint){
		storage.add(constraint);
	}
	
	public Constraint getConstraint(String name, Object target, IEvlContext context) throws EolRuntimeException{
		for (Constraint constraint : storage) {
			if (constraint.getName().equals(name) && 
					constraint.getConstraintContext().getAllOfSourceKind(context).contains(target)) {// && constraint.appliesTo(target, context)) {
				return constraint;
			}
		}
		return null;
	}
	
	public Collection<Constraint> values() {
		return storage;
	}
	
	public Iterator<Constraint> iterator() {
		return storage.iterator();
	}

}
