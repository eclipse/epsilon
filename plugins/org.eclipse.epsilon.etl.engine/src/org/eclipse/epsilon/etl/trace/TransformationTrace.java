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

import java.util.*;
import org.eclipse.epsilon.common.concurrent.ConcurrencyUtils;
import org.eclipse.epsilon.common.util.CollectionUtil;
import org.eclipse.epsilon.etl.dom.TransformationRule;

public class TransformationTrace {
	
	Map<Object, Collection<Transformation>> cache;
	Collection<Transformation> transformations;
	boolean isConcurrent;
	
	public TransformationTrace() {
		this(false);
	}
	
	public TransformationTrace(boolean concurrent) {
		this.isConcurrent = concurrent;
		cache = concurrent ? ConcurrencyUtils.concurrentMap() : new HashMap<>();
		transformations = newCollection();
	}
	
	<T> Collection<T> newCollection() {
		return isConcurrent ? new Vector<>() : new ArrayList<>();
	}
	
	public void add(Object source, Collection<Object> targets, TransformationRule rule) {
		Transformation transformation = new Transformation(source, targets);
		transformation.setRule(rule);
		transformations.add(transformation);
		Collection<Transformation> transformations = cache.get(source);
		if (transformations == null) {
			cache.put(source, transformations = newCollection());
		}
		transformations.add(transformation);
	}
	
	public Collection<Transformation> getTransformations() {
		return transformations;
	}
	
	public  Collection<Transformation> getTransformations(Object source) {
		Collection<Transformation> t =  cache.get(source);
		return t != null ? t : newCollection();
	}

	public Collection<?> getTransformationTargets(Object source, String rule) {
		Collection<Object> targets = CollectionUtil.createDefaultList();
		for (Transformation transformation : getTransformations()) {
			if (rule == null || rule.equals(transformation.getRule().getName())) {
				if (source.equals(transformation.source)) {					
					targets.addAll(transformation.getTargets());
				}
			}
		}
		return targets;
	}
	
	public boolean containsTransformedBy(TransformationRule rule) {
		return getTransformations().stream().anyMatch(t -> t.getRule() == rule);
	}
}
