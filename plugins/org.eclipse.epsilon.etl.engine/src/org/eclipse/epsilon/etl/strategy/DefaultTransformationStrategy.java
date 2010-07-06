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
import java.util.Iterator;
import java.util.List;

import org.eclipse.epsilon.commons.util.CollectionUtil;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.erl.rules.INamedRule;
import org.eclipse.epsilon.erl.strategy.IEquivalentProvider;
import org.eclipse.epsilon.etl.TransformRule;
import org.eclipse.epsilon.etl.execute.context.IEtlContext;

public class DefaultTransformationStrategy implements ITransformationStrategy{
	
	protected IEquivalentProvider equivalentProvider;
	//protected IModel sourceModel;
	//protected IModel targetModel;
	
	//public IModel getSourceModel() {
	//	return sourceModel;
	//}

	//public void setSourceModel(IModel sourceModel) {
	//	this.sourceModel = sourceModel;
	//}

	//public IModel getTargetModel() {
	//	return targetModel;
	//}

	//public void setTargetModel(IModel targetModel) {
	//	this.targetModel = targetModel;
	//}

	//public void load(StringProperties properties) {
	//	
	//}
	
	public DefaultTransformationStrategy(){
		equivalentProvider = this;
	}
	
	public List<Object> getExcluded() {
		return Collections.EMPTY_LIST;
	}
	
	public boolean canTransform(Object source) {
		return !getExcluded().contains(source);
	}
	
	public Collection transform(Object source, IEtlContext context, List<String> rules) throws EolRuntimeException{
		
		List targets = CollectionUtil.createDefaultList();
		
		//TODO : Change this to be less restrictive...
		if (!canTransform(source)) return targets;
		
		for (INamedRule rule : context.getModule().getTransformRules().getRulesFor(source, context)) {
			TransformRule transformRule = (TransformRule) rule;
			if (rules == null || rules.contains(rule.getName())) {
				
				Collection transformed = transformRule.transform(source, context);
				
				if (!transformRule.isPrimary()) {
					targets.addAll(transformed);
				}
				else {
					int i = 0;
					for (Object target : transformed) {
						targets.add(i, target);
						i++;
					}
				}
			}
		}
		
		return targets;
		
	}
	
	public Collection getEquivalents(Object source, IEolContext context_, List<String> rules) throws EolRuntimeException{
		IEtlContext context = (IEtlContext) context_;
		// First transform the source
		return transform(source, context, rules);
		// Then collect all the targets both implicit and explicit from
		// the transformation trace and return them
		//return context.getTransformationTrace().getTransformations(source).getTargets();
	}
	
	public Object getEquivalent(Object source, IEolContext context_, List<String> rules) throws EolRuntimeException {
		IEtlContext context = (IEtlContext) context_;
		
		Collection equivalents = getEquivalents(source, context, rules);
		
		if (!equivalents.isEmpty()) {
			return CollectionUtil.getFirst(equivalents);
		}
		else {
			return null;
		}
	
	}
	
	public Collection getEquivalent(Collection collection, IEolContext context_, List<String> rules) throws EolRuntimeException{
		IEtlContext context = (IEtlContext) context_;
		return CollectionUtil.flatten(getEquivalents(collection, context, rules));
	}
	
	public Collection getEquivalents(Collection collection, IEolContext context_, List<String> rules) throws EolRuntimeException{
		IEtlContext context = (IEtlContext) context_;
		Collection<Object> equivalents = CollectionUtil.createDefaultList();
		for (Object item : collection) {
			Object equivalent = getEquivalents(item, context, rules);
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
				transformRule.transformAll(context, getExcluded());
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
