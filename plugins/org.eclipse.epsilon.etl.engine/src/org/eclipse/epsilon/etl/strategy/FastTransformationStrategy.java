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

public class FastTransformationStrategy implements ITransformationStrategy{
	
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
	
	public FastTransformationStrategy(){
		equivalentProvider = this;
	}
	
	public List<Object> getExcluded() {
		return Collections.EMPTY_LIST;
	}
	
	public boolean canTransform(Object source) {
		return !getExcluded().contains(source);
	}
	
	public EolCollection transform(Object source, IEtlContext context, List<String> rules) throws EolRuntimeException{
		
		EolSequence targets = new EolSequence();
		
		//TODO : Change this to be less restrictive...
		if (!canTransform(source)) return targets;
		
		for (INamedRule rule : context.getModule().getTransformRules().getRulesFor(source, context)) {
			TransformRule transformRule = (TransformRule) rule;
			if (rules == null || rules.contains(rule.getName())) {
				
				EolCollection transformed = transformRule.transform(source, context);
				
				if (!transformRule.isPrimary(context)) {
					targets.addAll(transformed);
				}
				else {
					int i = 0;
					for (Object target : transformed.getStorage()) {
						targets.add(new EolInteger(i), target);
						i++;
					}
				}
			}
		}
		
		return targets;
		
		//return context.getTransformationTrace().getTransformations(source).getTargets();
		
		/*
		Transformations transformations = context.getTransformationTrace().getTransformations(source);
		EolCollection targets = new EolBag();
		

		if (!transformations.isEmpty()){
			targets = transformations.getTargets();
		}
		else {
			TransformRules transformRules = context.getModule().getTransformRules().getRulesFor(source, context);
			//if (transformRules.isEmpty()){
			//	transformRules = context.getModule().getTransformRules().getRulesFor(source, context, false);
			//}
			if (!transformRules.isEmpty()){
				Iterator it = transformRules.iterator();
				while (it.hasNext()){
					TransformRule transformRule = (TransformRule) it.next();
					targets.addAll(transformRule.transform(source, context));
				}
			} else {
				//int b = context.getModule().getTargetModel().allInstances().size();
				Object equivalent = autoTransform(source, context);
				targets.add(equivalent);
				if (equivalent == null) {
					context.getTransformationTrace().add(source, targets, null);
				}
				//int a = context.getModule().getTargetModel().allInstances().size();
				//if (b>a) {System.err.println(b + " : " + a);}
			}
			
		}
		*/
		
		//return targets;
	}
	
	public EolCollection getEquivalents(Object source, IEolContext context_, List<String> rules) throws EolRuntimeException{
		IEtlContext context = (IEtlContext) context_;
		// First transform the source
		return transform(source, context, rules);
		// Then collect all the targets both implicit and explicit from
		// the transformation trace and return them
		//return context.getTransformationTrace().getTransformations(source).getTargets();
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
		
		/*
		Transformations transformations = context.getTransformationTrace().getTransformations(source);
		
		for (Transformation transformation : transformations) {
			if (transformation.getRule().isPrimary(context)) {
				if (rules == null || rules.contains(transformation.getRule().getName())) {
					return transformation.getTargets().first();
				}
			}
		}
		
		if (!transformations.isEmpty()) {
			return transformations.get(0).getTargets().at(new EolInteger(0));
		}
		*/
		
		/*
		EolCollection equivalents = getEquivalents(source, context);
		if (equivalents.getStorage().isEmpty()){
			return null;
		}
		else {
			return equivalents.first();
		}*/
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
	
	/*
	public void transformModel2(IEtlContext context) throws EolRuntimeException {
		Iterator it = sourceModel.allContents().iterator();
		TransformationTrace trace = context.getTransformationTrace();
		while (it.hasNext()){
			Object sourceInstance = it.next();
			if (trace.getTransformations(sourceInstance).size() == 0){
				//autoTransform(sourceInstance, context);
				transform(sourceInstance,context);
			}
		}		
	}
	*/
	
	public void transformModels(IEtlContext context) throws EolRuntimeException {
		for (INamedRule rule : context.getModule().getTransformRules()) {			
			TransformRule transformRule = ((TransformRule)rule);
			if (!transformRule.isLazy(context) && !transformRule.isAbstract()) {
				transformRule.transformAll(context, getExcluded());
			}
		}
	}
	
	//public String getId(){
	//	return this.getClass().getCanonicalName();
	//}
	
	public void setEquivalentProvider(IEquivalentProvider equivalentProvider) {
		this.equivalentProvider = equivalentProvider;
	}

	public IEquivalentProvider getEquivalentProvider() {
		return equivalentProvider;
	}
	

}
