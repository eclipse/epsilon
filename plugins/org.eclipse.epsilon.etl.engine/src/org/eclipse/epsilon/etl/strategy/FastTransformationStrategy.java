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
package org.eclipse.epsilon.etl.strategy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.eclipse.epsilon.common.util.CollectionUtil;
import org.eclipse.epsilon.eol.dom.Parameter;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.types.EolCollectionType;
import org.eclipse.epsilon.erl.strategy.IEquivalentProvider;
import org.eclipse.epsilon.etl.dom.TransformationRule;
import org.eclipse.epsilon.etl.execute.context.IEtlContext;
import org.eclipse.epsilon.etl.trace.Transformation;
import org.eclipse.epsilon.etl.trace.TransformationList;

public class FastTransformationStrategy implements ITransformationStrategy{
	
	protected IEquivalentProvider equivalentProvider;
	protected HashMap<Object, Collection<Object>> flatTrace = new HashMap<Object, Collection<Object>>();
	protected HashMap<Object, TransformationList> pendingTransformations = new HashMap<Object, TransformationList>();
	
	public FastTransformationStrategy(){
		equivalentProvider = this;
	}
	
	public List<Object> getExcluded() {
		return Collections.emptyList();
	}
	
	public boolean canTransform(Object source) {
		return !getExcluded().contains(source);
	}
	
	public Collection<?> transform(Object source, IEtlContext context, List<String> rules) throws EolRuntimeException{
		
		throw new UnsupportedOperationException(
				"FastTransformationStrategy cannot transform single objects. " +
				"Please use DefaultTransformationStrategy instead.");
		
	}
	
	public Collection<?> getEquivalents(Object source, IEolContext context_, List<String> rules) throws EolRuntimeException{
		IEtlContext context = (IEtlContext) context_;
		
		if (pendingTransformations.containsKey(source)) {
			TransformationList transformations = pendingTransformations.remove(source);
			executeTransformations(transformations, context);
		}
		
		if (rules == null || rules.isEmpty()) return flatTrace.get(source);
		
		Collection<Object> equivalents = new ArrayList<Object>();
		for (Transformation transformation : context.getTransformationTrace().getTransformations(source)) {
			if (rules.contains(transformation.getRule().getName())) {
				equivalents.addAll(transformation.getTargets());
			}
		}
		return equivalents;
	}
	
	public Object getEquivalent(Object source, IEolContext context_, List<String> rules) throws EolRuntimeException {
		IEtlContext context = (IEtlContext) context_;
		
		Collection<?> equivalents = getEquivalents(source, context, rules);
		
		if (equivalents != null && !equivalents.isEmpty()) {
			return CollectionUtil.getFirst(equivalents);
		}
		else {
			return null;
		}
		
	}
	
	public Collection<?> getEquivalent(Collection<?> collection, IEolContext context_, List<String> rules) throws EolRuntimeException{
		IEtlContext context = (IEtlContext) context_;
		return CollectionUtil.flatten(getEquivalents(collection, context, rules));
	}
	
	public Collection<?> getEquivalents(Collection<?> collection, IEolContext context_, List<String> rules) throws EolRuntimeException{
		IEtlContext context = (IEtlContext) context_;
		Collection<Object> equivalents = CollectionUtil.createDefaultList();
		Iterator<?> it = collection.iterator();
		while (it.hasNext()){
			Object equivalent = getEquivalents(it.next(), context, rules);
			if (equivalent != null && !equivalents.contains(equivalent)){
				equivalents.add(equivalent);
			}
		}
		return equivalents;
	}
	
	
	public void transformModels(IEtlContext context) throws EolRuntimeException {
		
		for (TransformationRule transformRule : context.getModule().getTransformationRules()) {			
			if (!transformRule.isLazy() && !transformRule.isAbstract()) {
				Collection<?> sources = transformRule.getAllInstances(transformRule.getSourceParameter(), context, !transformRule.isGreedy());
				
				for (Object instance : sources) {
					if (!getExcluded().contains(instance) && transformRule.appliesTo(instance, context, false, false)){
						
						Collection<Object> targets = CollectionUtil.createDefaultList();
						
						for (Parameter target : transformRule.getTargetParameters()) {
							targets.add(target.getType(context).createInstance());
						}
						
						context.getTransformationTrace().add(instance, targets, transformRule);
						
					}
				}
			}
		}
		
		for (Transformation transformation : context.getTransformationTrace().getTransformations()) {
			
			if (flatTrace.containsKey(transformation.getSource())) {
				if (transformation.getRule().isPrimary()) {
					flatTrace.put(transformation.getSource(), 
							EolCollectionType.join(transformation.getTargets(), flatTrace.get(transformation.getSource())));
				}
				else {
					flatTrace.get(transformation.getSource()).addAll(transformation.getTargets());
				}
			}
			else {
				flatTrace.put(transformation.getSource(), EolCollectionType.clone(transformation.getTargets()));
			}
			
			if (pendingTransformations.containsKey(transformation.getSource())) {
				pendingTransformations.get(transformation.getSource()).add(transformation);
			}
			else {
				TransformationList transformations = new TransformationList();
				transformations.add(transformation);
				pendingTransformations.put(transformation.getSource(), transformations);
			}
			
		}
		
		executeTransformations(context.getTransformationTrace().getTransformations(), context);
		
	}
	
	protected void executeTransformations(TransformationList transformations, IEtlContext context) throws EolRuntimeException {
		for (Transformation transformation : transformations) {
			TransformationRule rule = transformation.getRule();
			if (!rule.hasTransformed(transformation.getSource())) {
				rule.transform(transformation.getSource(), transformation.getTargets(), context);
			}
		} 		
	}
	
	public void setEquivalentProvider(IEquivalentProvider equivalentProvider) {
		this.equivalentProvider = equivalentProvider;
	}

	public IEquivalentProvider getEquivalentProvider() {
		return equivalentProvider;
	}
	

}
