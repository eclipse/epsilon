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

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.eclipse.epsilon.common.util.CollectionUtil;
import org.eclipse.epsilon.eol.EolFormalParameter;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.types.EolCollectionType;
import org.eclipse.epsilon.erl.rules.INamedRule;
import org.eclipse.epsilon.erl.strategy.IEquivalentProvider;
import org.eclipse.epsilon.etl.TransformRule;
import org.eclipse.epsilon.etl.execute.context.IEtlContext;
import org.eclipse.epsilon.etl.trace.Transformation;
import org.eclipse.epsilon.etl.trace.Transformations;

public class FastTransformationStrategy implements ITransformationStrategy{
	
	protected IEquivalentProvider equivalentProvider;
	protected HashMap<Object, Collection<Object>> flatTrace = new HashMap<Object, Collection<Object>>();
	protected HashMap<Object, Transformations> pendingTransformations = new HashMap<Object, Transformations>();
	
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
			Transformations transformations = pendingTransformations.remove(source);
			executeTransformations(transformations, context);
		}
		
		return flatTrace.get(source);
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
		
		for (INamedRule rule : context.getModule().getTransformRules()) {			
			TransformRule transformRule = ((TransformRule)rule);
			if (!transformRule.isLazy() && !transformRule.isAbstract()) {
				Collection<?> sources;
				
				if (transformRule.isGreedy()) {
					sources = transformRule.getSourceType(context).getAllOfKind();
				}
				else {
					sources = transformRule.getSourceType(context).getAllOfType();
				}
				
				for (Object instance : sources) {
					if (!getExcluded().contains(instance) && transformRule.appliesTo(instance, context, false, false)){
						
						Collection<Object> targets = CollectionUtil.createDefaultList();
						
						for (EolFormalParameter target : transformRule.getTargetParameters()) {
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
				Transformations transformations = new Transformations();
				transformations.add(transformation);
				pendingTransformations.put(transformation.getSource(), transformations);
			}
			
		}
		
		executeTransformations(context.getTransformationTrace().getTransformations(), context);
		
	}
	
	protected void executeTransformations(Transformations transformations, IEtlContext context) throws EolRuntimeException {
		for (Transformation transformation : transformations) {
			TransformRule rule = transformation.getRule();
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
