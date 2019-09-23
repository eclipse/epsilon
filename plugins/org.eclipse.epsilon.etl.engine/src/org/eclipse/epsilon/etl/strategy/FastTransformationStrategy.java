/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.etl.strategy;

import java.util.*;
import org.eclipse.epsilon.common.util.CollectionUtil;
import org.eclipse.epsilon.eol.dom.Parameter;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.types.EolCollectionType;
import org.eclipse.epsilon.erl.execute.context.IErlContext;
import org.eclipse.epsilon.etl.dom.TransformationRule;
import org.eclipse.epsilon.etl.execute.context.IEtlContext;
import org.eclipse.epsilon.etl.trace.Transformation;
import org.eclipse.epsilon.etl.trace.TransformationTrace;

public class FastTransformationStrategy extends AbstractTransformationStrategy {
	
	protected Map<Object, Collection<Object>> flatTrace = new HashMap<>();
	protected Map<Object, Collection<Transformation>> pendingTransformations = new HashMap<>();
	
	@Override
	public Collection<?> transform(Object source, IEtlContext context, List<String> rules) throws EolRuntimeException {	
		throw new UnsupportedOperationException(
				"FastTransformationStrategy cannot transform single objects. " +
				"Please use DefaultTransformationStrategy instead.");
	}
	
	@Override
	public Collection<?> getEquivalents(Object source, IErlContext context_, List<String> rules) throws EolRuntimeException {
		IEtlContext context = (IEtlContext) context_;
		
		if (pendingTransformations.containsKey(source)) {
			Collection<Transformation> transformations = pendingTransformations.remove(source);
			executeTransformations(transformations, context);
		}
		
		if (rules == null || rules.isEmpty()) return flatTrace.get(source);
		
		Collection<Object> equivalents = new ArrayList<>();
		for (Transformation transformation : context.getTransformationTrace().getTransformations(source)) {
			if (rules.contains(transformation.getRule().getName())) {
				equivalents.addAll(transformation.getTargets());
			}
		}
		return equivalents;
	}
	
	@Override
	public void transformModels(IEtlContext context) throws EolRuntimeException {
		
		TransformationTrace transTrace = context.getTransformationTrace();
		
		for (TransformationRule transformRule : context.getModule().getTransformationRules()) {			
			if (!transformRule.isLazy(context) && !transformRule.isAbstract()) {
				Collection<?> sources = transformRule.getAllInstances(transformRule.getSourceParameter(), context, !transformRule.isGreedy());
				
				for (Object instance : sources) {
					if (!getExcluded().contains(instance) && transformRule.appliesTo(instance, context, false, false)) {
						
						Collection<Object> targets = CollectionUtil.createDefaultList();
						
						for (Parameter target : transformRule.getTargetParameters()) {
							targets.add(target.getType(context).createInstance());
						}
						
						transTrace.add(instance, targets, transformRule);
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
				Collection<Transformation> transformations = new ArrayList<>(1);
				transformations.add(transformation);
				pendingTransformations.put(transformation.getSource(), transformations);
			}
			
		}
		
		executeTransformations(context.getTransformationTrace().getTransformations(), context);
	}
	
	protected void executeTransformations(Collection<Transformation> transformations, IEtlContext context) throws EolRuntimeException {
		for (Transformation transformation : transformations) {
			TransformationRule rule = transformation.getRule();
			if (!rule.hasTransformed(transformation.getSource())) {
				rule.transform(transformation.getSource(), transformation.getTargets(), context);
			}
		} 		
	}
}
