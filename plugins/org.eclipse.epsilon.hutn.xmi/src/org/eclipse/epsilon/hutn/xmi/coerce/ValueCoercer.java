/*******************************************************************************
 * Copyright (c) 2009 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************
 *
 * $Id$
 */
package org.eclipse.epsilon.hutn.xmi.coerce;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;


public final class ValueCoercer {

	private final List<AbstractCoercionStrategy<?>> strategies = new LinkedList<AbstractCoercionStrategy<?>>();
	private final Resource resource;
	
	public ValueCoercer(Resource resource) {
		this.resource = resource;
		
		strategies.add(new StringToBooleanCoercionStrategy(this));
		strategies.add(new StringToIntegerCoercionStrategy(this));
		strategies.add(new StringToFloatCoercionStrategy(this));
		strategies.add(new StringToReferenceCoercionStrategy(this));
		strategies.add(new EListCoercionStrategy(this));
	}
	
	public Object coerce(Object value) {
		return applyStrategy(value);
	}
	
	private Object applyStrategy(Object value) {
		for (AbstractCoercionStrategy<?> strategy : strategies) {
			if (strategy.applicable(value)) {
				return strategy.coerce(value);
			}
		}
		
		return value;
	}
	
	
	Resource getResource() {
		return resource;
	}
}
