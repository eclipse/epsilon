/*******************************************************************************
 * Copyright (c) 2012 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.egl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.epsilon.common.module.ModuleElement;
import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.common.util.AstUtil;
import org.eclipse.epsilon.egl.execute.context.IEglContext;
import org.eclipse.epsilon.egl.parse.EgxParser;
import org.eclipse.epsilon.eol.EolFormalParameter;
import org.eclipse.epsilon.eol.annotations.EolAnnotationsUtil;
import org.eclipse.epsilon.eol.exceptions.EolIllegalReturnException;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.Return;
import org.eclipse.epsilon.eol.execute.context.FrameType;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.parse.EolParser;
import org.eclipse.epsilon.eol.types.EolMap;
import org.eclipse.epsilon.eol.types.EolModelElementType;
import org.eclipse.epsilon.eol.types.EolType;
import org.eclipse.epsilon.erl.rules.NamedRule;

public class GenerationRule extends NamedRule implements ModuleElement {
	
	protected EolFormalParameter sourceParameter = null;
	protected AST targetAst = null;
	protected AST guardAst = null;
	protected AST templateAst = null;
	protected AST parametersAst = null;
	protected AST preAst = null;
	protected AST postAst = null;
	protected AST overwriteAst = null;
	protected AST protectRegionsAst = null;
	protected Boolean isGreedy;
	
	public GenerationRule(AST ast) {
		parse(ast);
	}
	
	protected void parse(AST ast) {
		this.ast = ast;
		name = ast.getFirstChild().getText();
		AST sourceParameterAst = ast.getFirstChild().getNextSibling();
		if (sourceParameterAst != null && sourceParameterAst.getType() == EolParser.FORMAL) {
			sourceParameter = new EolFormalParameter(sourceParameterAst);
		}
		templateAst = AstUtil.getChild(ast, EgxParser.TEMPLATE);
		guardAst = AstUtil.getChild(ast, EgxParser.GUARD);
		targetAst = AstUtil.getChild(ast, EgxParser.TARGET);
		parametersAst = AstUtil.getChild(ast, EgxParser.PARAMETERS);
		preAst = AstUtil.getChild(ast, EgxParser.PRE);
		postAst = AstUtil.getChild(ast, EgxParser.POST);
		overwriteAst = AstUtil.getChild(ast, EgxParser.OVERWRITE);
		protectRegionsAst = AstUtil.getChild(ast, EgxParser.PROTECTREGIONS);
		
	}
	
	public boolean isGreedy() throws EolRuntimeException {
		if (isGreedy == null) {
			isGreedy = EolAnnotationsUtil.getBooleanAnnotationValue(ast, "greedy", null);
		}
		return isGreedy;
	}
	
	public void generateAll(IEglContext context, EglTemplateFactory templateFactory, EgxModule module) throws EolRuntimeException {
		
		Collection<?> all = new ArrayList<Object>();
		
		if (sourceParameter != null) {
			EolType sourceParameterType = sourceParameter.getType(context);
			
			if (sourceParameterType instanceof EolModelElementType) {
				
				if (isGreedy()) {
					all = ((EolModelElementType) sourceParameterType).getAllOfKind();
				}
				else {
					all = ((EolModelElementType) sourceParameterType).getAllOfType();
				}
			}
		}
		else {
			all.add(null);
		}
			
		for (Object o : all) {
			
			if (sourceParameter != null) {
				context.getFrameStack().enterLocal(FrameType.PROTECTED, getAst(), Variable.createReadOnlyVariable(sourceParameter.getName(), o));
			}
			else {
				context.getFrameStack().enterLocal(FrameType.PROTECTED, getAst());
			}
			
			if (preAst != null) context.getExecutorFactory().executeAST(preAst.getFirstChild(), context);
			
			boolean guard = true;
			if (guardAst != null) {
				Return r = (Return) context.getExecutorFactory().executeBlockOrExpressionAst(guardAst.getFirstChild(), context);
				Object value = r.getValue();
				if (!(value instanceof Boolean)) {
					throw new EolIllegalReturnException("Boolean", value, guardAst, context);
				}
				guard = (Boolean) value;
			}
			
			if (!guard) continue;
			
			boolean overwrite = true;
			if (overwriteAst != null) {
				Return r = (Return) context.getExecutorFactory().executeBlockOrExpressionAst(overwriteAst.getFirstChild(), context);
				Object value = r.getValue();
				if (!(value instanceof Boolean)) {
					throw new EolIllegalReturnException("Boolean", value, overwriteAst, context);
				}
				overwrite = (Boolean) value;
			}
			
			boolean protectRegions = true;
			if (protectRegionsAst != null) {
				Return r = (Return) context.getExecutorFactory().executeBlockOrExpressionAst(protectRegionsAst.getFirstChild(), context);
				Object value = r.getValue();
				if (!(value instanceof Boolean)) {
					throw new EolIllegalReturnException("Boolean", value, protectRegionsAst, context);
				}
				protectRegions = (Boolean) value;
			}
			
			EolMap parameters = new EolMap();
			if (parametersAst != null) {
				Return r = (Return) context.getExecutorFactory().executeBlockOrExpressionAst(parametersAst.getFirstChild(), context);
				Object value = r.getValue();
				if (!(value instanceof EolMap)) {
					throw new EolIllegalReturnException("Map", value, parametersAst, context);
				}
				parameters = (EolMap) value;
			}
			
			String template = null;
			if (templateAst != null) {
				Return r = (Return) context.getExecutorFactory().executeBlockOrExpressionAst(templateAst.getFirstChild(), context);
				template = r.getValue() + "";
			}
			
			String target = null;
			if (targetAst != null) {
				Return r = (Return) context.getExecutorFactory().executeBlockOrExpressionAst(targetAst.getFirstChild(), context);
				target = r.getValue() + "";
			}
			
			EglTemplate eglTemplate = templateFactory.load(template);
			
			if (sourceParameter != null) {
				eglTemplate.populate(sourceParameter.getName(), o);
			}
			
			for (Object key : parameters.keySet()) {
				eglTemplate.populate(key + "", parameters.get(key));
			}
			
			if (eglTemplate instanceof EglFileGeneratingTemplate) {
				((EglFileGeneratingTemplate) eglTemplate).generate(target, overwrite, protectRegions);
			}
			
			module.getInvokedTemplates().add(eglTemplate.getTemplate());
			
			if (postAst != null) context.getExecutorFactory().executeAST(postAst.getFirstChild(), context);
			
			context.getFrameStack().leaveLocal(getAst());
			
		}
			
	}
	
	@Override
	public List<?> getChildren() {
		return Collections.emptyList();
	}
	
	@Override
	public String toString() {
		String label = this.name;
		System.err.println(sourceParameter);
		if (sourceParameter != null) {
			label += " (" + sourceParameter.getTypeName() + ")";
		}
		return label;
	}
	
}
