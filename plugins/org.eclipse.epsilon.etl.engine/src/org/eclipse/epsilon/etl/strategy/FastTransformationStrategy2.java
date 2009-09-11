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

import org.eclipse.epsilon.eol.EolFormalParameter;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.types.EolBag;
import org.eclipse.epsilon.eol.types.EolCollection;
import org.eclipse.epsilon.eol.types.EolInteger;
import org.eclipse.epsilon.eol.types.EolSequence;
import org.eclipse.epsilon.erl.rules.INamedRule;
import org.eclipse.epsilon.erl.strategy.IEquivalentProvider;
import org.eclipse.epsilon.etl.TransformRule;
import org.eclipse.epsilon.etl.execute.context.IEtlContext;
import org.eclipse.epsilon.etl.trace.Transformation;
import org.eclipse.epsilon.etl.trace.TransformationTrace;
import org.eclipse.epsilon.etl.trace.Transformations;

public class FastTransformationStrategy2 implements ITransformationStrategy{
	
	protected IEquivalentProvider equivalentProvider;
	protected HashMap<Object, EolCollection> flatTrace = new HashMap<Object, EolCollection>();
	
	public FastTransformationStrategy2(){
		equivalentProvider = this;
	}
	
	public List<Object> getExcluded() {
		return Collections.EMPTY_LIST;
	}
	
	public boolean canTransform(Object source) {
		return !getExcluded().contains(source);
	}
	
	public EolCollection transform(Object source, IEtlContext context, List<String> rules) throws EolRuntimeException{
		
		for (INamedRule rule : context.getModule().getTransformRules()) {
			TransformRule transformRule = (TransformRule) rule;
			if (transformRule.isLazy() && !transformRule.hasTransformed(source) && transformRule.appliesTo(source, context, false)) {
				EolCollection targets = transformRule.transform(source, context);
				if (flatTrace.containsKey(source)) {
					if (transformRule.isPrimary()) {
						flatTrace.put(source, targets.includingAll(flatTrace.get(source)));
					}
					else {
						flatTrace.get(source).addAll(targets);
					}
				}
				else {
					flatTrace.put(source, targets.clone());
				}
			}
		}
		
		return flatTrace.get(source);
		
		//throw new UnsupportedOperationException(
		//		"FastTransformationStrategy cannot transform single objects. " +
		//		"Please use DefaultTransformationStrategy instead.");
		
	}
	
	public EolCollection getEquivalents(Object source, IEolContext context_, List<String> rules) throws EolRuntimeException{
		IEtlContext context = (IEtlContext) context_;
		return transform(source, context, rules);
		
		//return flatTrace.get(source);
	}
	
	public Object getEquivalent(Object source, IEolContext context_, List<String> rules) throws EolRuntimeException {
		IEtlContext context = (IEtlContext) context_;
		
		EolCollection equivalents = getEquivalents(source, context, rules);
		
		if (!equivalents.isEmpty().booleanValue()) {
			return equivalents.at(new EolInteger(0));
		}
		else {
			return null;
		}
		
	}
	
	public EolCollection getEquivalent(Collection collection, IEolContext context_, List<String> rules) throws EolRuntimeException{
		IEtlContext context = (IEtlContext) context_;
		return getEquivalents(collection, context, rules).flatten();
	}
	
	public EolCollection getEquivalents(Collection collection, IEolContext context_, List<String> rules) throws EolRuntimeException{
		IEtlContext context = (IEtlContext) context_;
		EolCollection equivalents = new EolBag();
		Iterator it = collection.iterator();
		while (it.hasNext()){
			Object equivalent = getEquivalents(it.next(), context, rules);
			if (equivalent != null && equivalents.includes(equivalent).not().booleanValue()){
				equivalents.add(equivalent);
			}
		}
		return equivalents;
	}
	
	public void transformModels(IEtlContext context) throws EolRuntimeException {
		
		// System.err.println("Creating targets");
		
		for (INamedRule rule : context.getModule().getTransformRules()) {			
			TransformRule transformRule = ((TransformRule)rule);
			if (!transformRule.isLazy() && !transformRule.isAbstract()) {
				Collection<Object> sources;
				
				if (transformRule.isGreedy()) {
					sources = transformRule.getAllOfSourceKind(context);
				}
				else {
					sources = transformRule.getAllOfSourceType(context);
				}
				
				for (Object instance : sources) {
					if (!getExcluded().contains(instance) && transformRule.appliesTo(instance, context, false, false)){
						
						EolCollection targets = new EolSequence();
						
						for (EolFormalParameter target : transformRule.getTargetParameters()) {
							targets.add(target.getType(context).createInstance());
						}
						
						context.getTransformationTrace().add(instance, targets, transformRule);
						
					}
				}
			}
		}
		
		//System.err.println("Flattening trace");
		
		for (Transformation transformation : context.getTransformationTrace().getTransformations()) {
			
			if (flatTrace.containsKey(transformation.getSource())) {
				if (transformation.getRule().isPrimary()) {
					flatTrace.put(transformation.getSource(), 
							transformation.getTargets().includingAll(flatTrace.get(transformation.getSource())));
				}
				else {
					flatTrace.get(transformation.getSource()).addAll(transformation.getTargets());
				}
			}
			else {
				flatTrace.put(transformation.getSource(), transformation.getTargets().clone());
			}
			
		}
		
		//System.err.println("Running rules");
		for (Transformation transformation : (Transformations) context.getTransformationTrace().getTransformations().clone()) {
			transformation.getRule().transform(transformation.getSource(), transformation.getTargets(), context);
		} 
		
	}
		
	public void setEquivalentProvider(IEquivalentProvider equivalentProvider) {
		this.equivalentProvider = equivalentProvider;
	}

	public IEquivalentProvider getEquivalentProvider() {
		return equivalentProvider;
	}
	

}
