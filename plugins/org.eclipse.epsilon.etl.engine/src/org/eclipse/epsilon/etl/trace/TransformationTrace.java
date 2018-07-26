/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.etl.trace;

import java.util.Collection;
import java.util.HashMap;

import org.eclipse.epsilon.etl.dom.TransformationRule;

public class TransformationTrace {
	
	//List storage = new ArrayList();
	HashMap<Object, TransformationList> cache = new HashMap<Object, TransformationList>();
	TransformationList transformations = new TransformationList();
	
	public void add(Object source, Collection<Object> targets, TransformationRule rule){
		Transformation transformation = new Transformation();
		transformation.setSource(source);
		transformation.setTargets(targets);
		transformation.setRule(rule);
		transformations.add(transformation);
		//cache.put(source, transformation);
		TransformationList transformations = cache.get(source);
		if (transformations == null) {
			transformations = new TransformationList();
			transformations.add(transformation);
			cache.put(source, transformations);
		}
		else {
			transformations.add(transformation);
		}
	}
	
	public TransformationList getTransformations() {
		/*
		Transformations transformations = new Transformations();
		for (Object key : cache.keySet()) {
			transformations.addAll((Transformations)cache.get(key));
		}*/
		return transformations;
	}
	
	public TransformationList getTransformations(Object source){
		if (cache.containsKey(source)){
			return cache.get(source);
		}
		else {
			TransformationList transformations = new TransformationList();
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
