/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.etl.dom;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.epsilon.common.module.IModule;
import org.eclipse.epsilon.common.module.ModuleElement;
import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.common.util.AstUtil;
import org.eclipse.epsilon.common.util.CollectionUtil;
import org.eclipse.epsilon.eol.dom.ExecutableBlock;
import org.eclipse.epsilon.eol.dom.Parameter;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.types.EolModelElementType;
import org.eclipse.epsilon.eol.types.EolType;
import org.eclipse.epsilon.erl.dom.ExtensibleNamedRule;
import org.eclipse.epsilon.etl.execute.context.IEtlContext;
import org.eclipse.epsilon.etl.parse.EtlParser;
import org.eclipse.epsilon.etl.trace.TransformationList;
import org.eclipse.epsilon.etl.trace.TransformationTrace;

public class TransformationRule extends ExtensibleNamedRule {
	
	protected Parameter sourceParameter;
	protected List<Parameter> targetParameters = new ArrayList<>();
	protected ExecutableBlock<Boolean> guard = null;
	protected ExecutableBlock<Void> body = null;
	protected IEtlContext context;
	
	@Override
	public AST getSuperRulesAst(AST cst) {
		return AstUtil.getChild(cst, EtlParser.EXTENDS);
	}
	
	public Parameter getSourceParameter() {
		return sourceParameter;
	}
	
	public void setSourceParameter(Parameter sourceParameter) {
		this.sourceParameter = sourceParameter;
	}
	
	public ExecutableBlock<Void> getBody() {
		return body;
	}
	
	public void setBody(ExecutableBlock<Void> body) {
		this.body = body;
	}
	
	public ExecutableBlock<Boolean> getGuard() {
		return guard;
	}
	
	public void setGuard(ExecutableBlock<Boolean> guard) {
		this.guard = guard;
	}
	
	public List<Parameter> getTargetParameters() {
		return targetParameters;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void build(AST cst, IModule module) {
		
		super.build(cst, module);
		
		this.guard = (ExecutableBlock<Boolean>) module.createAst(AstUtil.getChild(cst, EtlParser.GUARD), this);
		this.body = (ExecutableBlock<Void>) module.createAst(AstUtil.getChild(cst, EtlParser.BLOCK), this);	
		
		//Parse the formal parameters
		AST sourceParameterAst = cst.getFirstChild().getNextSibling();;
		sourceParameter = (Parameter) module.createAst(sourceParameterAst, this);
		
		AST targetParametersAst = sourceParameterAst.getNextSibling();
		AST targetParameterAst = targetParametersAst.getFirstChild();
		
		while (targetParameterAst != null){
			targetParameters.add((Parameter) module.createAst(targetParameterAst, this));
			targetParameterAst = targetParameterAst.getNextSibling();
		}
		
	}
	
	@Override
	public boolean isLazy(IEolContext context) throws EolRuntimeException {
		return super.isLazy(context) || !(sourceParameter.getType(context) instanceof EolModelElementType);
	}
	
	public boolean hasTransformed(Object source) {
		return transformedElements.contains(source);
	}
			
	protected Collection<Object> rejected = new ArrayList<>();
	
	public boolean appliesTo(Object source, IEtlContext context, boolean asSuperRule) throws EolRuntimeException {
		return appliesTo(source, context, asSuperRule, true);
	}
	
	//TODO: Add support for rejected objects to other languages as well!
	public boolean appliesTo(Object source, IEtlContext context, boolean asSuperRule, boolean checkTypes) throws EolRuntimeException {
		
		if (hasTransformed(source)) return true;
		if (rejected.contains(source)) return false;
		
		boolean appliesToTypes;
		
		if (!checkTypes) {
			appliesToTypes = true;
		}
		else {
			boolean ofTypeOnly = !(isGreedy() || asSuperRule);
			if (ofTypeOnly) {
				appliesToTypes = sourceParameter.getType(context).isType(source);
			}
			else {
				appliesToTypes = sourceParameter.getType(context).isKind(source);	
			}
		}
		
		boolean guardSatisfied = true;
		
		if (appliesToTypes && guard != null){
			
			guardSatisfied = guard.execute(context, 
					Variable.createReadOnlyVariable(sourceParameter.getName(), source), 
					Variable.createReadOnlyVariable("self", this));	
		}
		
		boolean applies = appliesToTypes && guardSatisfied;
		
		for (ExtensibleNamedRule superRule : getSuperRules()) {
			TransformationRule rule = (TransformationRule) superRule;
			if (!rule.appliesTo(source, context, true)) { applies = false; break; }
		}
		
		if (!applies) {rejected.add(source);}
		
		return applies;
	}
	
	public void transformAll(IEtlContext context, List<Object> excluded) throws EolRuntimeException{
		
		Collection<?> all = getAllInstances(sourceParameter, context, !isGreedy());
		
		for (Object instance : all) {
			if (!excluded.contains(instance) && appliesTo(instance, context, false)){
				transform(instance, context);
			}
		}
		
	}
	
	public Collection<?> transform(Object source, Collection<Object> targets, IEtlContext context) throws EolRuntimeException {
		transformedElements.add(source);
		executeSuperRulesAndBody(source, targets, context);
		return targets;
	}
	
	protected Set<Object> transformedElements = new HashSet<>();
	
	public Collection<?> transform(Object source, IEtlContext context) throws EolRuntimeException{
		
		TransformationTrace transformationTrace = context.getTransformationTrace();
		
		if (hasTransformed(source)) {
			TransformationList transformations = transformationTrace.getTransformations(source);
			return transformations.getTargets(getName());
		}
		else {
			transformedElements.add(source);
		}
		
		Collection<Object> targets = CollectionUtil.createDefaultList();
		
		for (Parameter targetParameter : targetParameters) {
			EolType targetParameterType = (EolType) targetParameter.getType(context);
			targets.add(targetParameterType.createInstance());
		}
		
		transformationTrace.add(source, targets, this);
		executeSuperRulesAndBody(source, targets, context);
		return targets;
	}
	
	protected void executeSuperRulesAndBody(Object source, Collection<Object> targets_, IEtlContext context) throws EolRuntimeException{
		
		List<Object> targets = CollectionUtil.asList(targets_);
		
		// Execute super-rules
		for (ExtensibleNamedRule rule : superRules){
			TransformationRule superRule = (TransformationRule) rule;
			superRule.transform(source, targets, context);
		}
		
		List<Variable> variables = new ArrayList<>();
		variables.add(Variable.createReadOnlyVariable("self", this));
		variables.add(Variable.createReadOnlyVariable(sourceParameter.getName(), source));
		for (Parameter targetParameter : targetParameters) {
			variables.add(Variable.createReadOnlyVariable(targetParameter.getName(), targets.get(targetParameters.indexOf(targetParameter))));
		}
		body.execute(context, variables.toArray(new Variable[]{}));
	}
	
	public List<ModuleElement> getModuleElements() {
		return Collections.emptyList();
	}
	
	@Override
	public String toString() {
		
		String targetTypes = "";
		Iterator<Parameter> it = targetParameters.iterator();
		while (it.hasNext()){
			Parameter fp  = it.next();
			targetTypes += fp.getTypeName();
			if (it.hasNext()){
				targetTypes += ", ";
			}
		}
		
		return getName() + " (" + sourceParameter.getTypeName() + ") : " + targetTypes;
	}
	
	protected Boolean isPrimary = null;
	
	public boolean isPrimary() throws EolRuntimeException {
		if (isPrimary == null) {
			isPrimary = getBooleanAnnotationValue("primary", null);
		}
		return isPrimary;
	}
	
	public boolean canTransformExcluded(IEtlContext context) throws EolRuntimeException {
		return getBooleanAnnotationValue("excluded", context, false, true);
	}
	
	public void dispose() {
		transformedElements.clear();
		rejected.clear();
		rejected = null;
		transformedElements = null;
	}
	
}
