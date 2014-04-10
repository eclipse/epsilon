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
package org.eclipse.epsilon.etl.trace;

import java.util.Collection;
import java.util.HashMap;

import org.eclipse.epsilon.etl.TransformRule;

public class TransformationTrace {
	
	//List storage = new ArrayList();
	HashMap<Object, Transformations> cache = new HashMap<Object, Transformations>();
	Transformations transformations = new Transformations();
	
	public void add(Object source, Collection<Object> targets, TransformRule rule){
		Transformation transformation = new Transformation();
		transformation.setSource(source);
		transformation.setTargets(targets);
		transformation.setRule(rule);
		transformations.add(transformation);
		//cache.put(source, transformation);
		Transformations transformations = cache.get(source);
		if (transformations == null) {
			transformations = new Transformations();
			transformations.add(transformation);
			cache.put(source, transformations);
		}
		else {
			transformations.add(transformation);
		}
	}
	
	public Transformations getTransformations() {
		/*
		Transformations transformations = new Transformations();
		for (Object key : cache.keySet()) {
			transformations.addAll((Transformations)cache.get(key));
		}*/
		return transformations;
	}
	
	public Transformations getTransformations(Object source){
		if (cache.containsKey(source)){
			return cache.get(source);
		}
		else {
			Transformations transformations = new Transformations();
			return transformations;
		}
		/*
		ListIterator li = storage.listIterator();
		Transformations transformations = new Transformations();
		while (li.hasNext()){
			Transformation transformation = (Transformation)li.next();
			if (transformation.of(source)){
				transformations.add(transformation);
			}
		}
		return transformations;
		*/
	}
	/*
	public Transformations getTransformations(Object source, TransformRule rule){
		ListIterator li = storage.listIterator();
		Transformations transformations = new Transformations();
		while (li.hasNext()){
			Transformation transformation = (Transformation)li.next();
			if (transformation.of(source) && transformation.getRule() == rule){
				transformations.add(transformation);
			}
		}
		return transformations;		
	}
	*/
}
