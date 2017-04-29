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
package org.eclipse.epsilon.egl.dom;

import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.epsilon.common.module.IModule;
import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.common.util.AstUtil;
import org.eclipse.epsilon.egl.EglFileGeneratingTemplate;
import org.eclipse.epsilon.egl.EglPersistentTemplate;
import org.eclipse.epsilon.egl.EglTemplate;
import org.eclipse.epsilon.egl.EglTemplateFactory;
import org.eclipse.epsilon.egl.EgxModule;
import org.eclipse.epsilon.egl.execute.context.IEglContext;
import org.eclipse.epsilon.egl.parse.EgxParser;
import org.eclipse.epsilon.eol.dom.ExecutableBlock;
import org.eclipse.epsilon.eol.dom.Parameter;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.FrameType;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.parse.EolParser;
import org.eclipse.epsilon.eol.types.EolMap;
import org.eclipse.epsilon.erl.dom.ExtensibleNamedRule;

public class GenerationRule extends ExtensibleNamedRule {
	
	protected Parameter sourceParameter = null;
	protected ExecutableBlock<String> targetBlock = null;
	protected ExecutableBlock<Boolean> guardBlock = null;
	protected ExecutableBlock<String> templateBlock = null;
	protected ExecutableBlock<EolMap> parametersBlock = null;
	protected ExecutableBlock<Void> preBlock = null;
	protected ExecutableBlock<Void> postBlock = null;
	protected ExecutableBlock<Boolean> overwriteBlock = null;
	protected ExecutableBlock<Boolean> mergeBlock = null;
	protected ExecutableBlock<Boolean> appendBlock = null;
	protected Boolean isGreedy;
	
	public GenerationRule() {}
	
	@SuppressWarnings("unchecked")
	public void build(AST cst, IModule module) {
		super.build(cst, module);
		AST sourceParameterAst = cst.getFirstChild().getNextSibling();
		if (sourceParameterAst != null && sourceParameterAst.getType() == EolParser.FORMAL) {
			sourceParameter = (Parameter) module.createAst(sourceParameterAst, this);
		}
		
		templateBlock = (ExecutableBlock<String>) module.createAst(AstUtil.getChild(cst, EgxParser.TEMPLATE), this);
		guardBlock = (ExecutableBlock<Boolean>) module.createAst(AstUtil.getChild(cst, EgxParser.GUARD), this);
		targetBlock = (ExecutableBlock<String>) module.createAst(AstUtil.getChild(cst, EgxParser.TARGET), this);
		parametersBlock = (ExecutableBlock<EolMap>) module.createAst(AstUtil.getChild(cst, EgxParser.PARAMETERS), this);
		preBlock = (ExecutableBlock<Void>) module.createAst(AstUtil.getChild(cst, EgxParser.PRE), this);
		postBlock = (ExecutableBlock<Void>) module.createAst(AstUtil.getChild(cst, EgxParser.POST), this);
		overwriteBlock = (ExecutableBlock<Boolean>) module.createAst(AstUtil.getChild(cst, EgxParser.OVERWRITE), this);
		mergeBlock = (ExecutableBlock<Boolean>) module.createAst(AstUtil.getChild(cst, EgxParser.MERGE), this);
		appendBlock = (ExecutableBlock<Boolean>) module.createAst(AstUtil.getChild(cst, EgxParser.APPEND), this);
	}
	
	public boolean isGreedy() throws EolRuntimeException {
		if (isGreedy == null) {
			isGreedy = getBooleanAnnotationValue("greedy", null);
		}
		return isGreedy;
	}
	
	public void generateAll(IEglContext context, EglTemplateFactory templateFactory, EgxModule module) throws EolRuntimeException {
		
		Collection<?> all = new ArrayList<Object>();
		
		if (sourceParameter != null) {
			all = getAllInstances(sourceParameter, context, !isGreedy());
		}
		else {
			all.add(null);
		}
		
		Map<URI, EglTemplate> templateCache = new HashMap<URI, EglTemplate>();
		
		for (Object o : all) {
			
			if (sourceParameter != null) {
				context.getFrameStack().enterLocal(FrameType.PROTECTED, this, Variable.createReadOnlyVariable(sourceParameter.getName(), o));
			}
			else {
				context.getFrameStack().enterLocal(FrameType.PROTECTED, this);
			}
			
			boolean guard = (guardBlock == null) ? true : guardBlock.execute(context, false);
			if (!guard) continue;
			
			if (preBlock != null) preBlock.execute(context, false);
			
			boolean overwrite = (overwriteBlock == null) ? true : overwriteBlock.execute(context, false);
			boolean merge = (mergeBlock == null) ? true : mergeBlock.execute(context, false);
			boolean append = (appendBlock == null) ? false : appendBlock.execute(context, false);
			
			EolMap parameters = (parametersBlock == null) ? new EolMap() : parametersBlock.execute(context, false);
			String template = (templateBlock == null) ? "" : templateBlock.execute(context, false);
			
			String target = targetBlock.execute(context, false);
			
			URI templateUri = templateFactory.resolveTemplate(template);
			
			if (!templateCache.containsKey(templateUri)) {
				templateCache.put(templateUri, templateFactory.load(templateUri));
			}
			
			EglTemplate eglTemplate = templateCache.get(templateUri);
			
			if (sourceParameter != null) {
				eglTemplate.populate(sourceParameter.getName(), o);
			}
			
			for (Object key : parameters.keySet()) {
				eglTemplate.populate(key + "", parameters.get(key));
			}
			
			File generated = null;
			if (eglTemplate instanceof EglPersistentTemplate) {
				if (append) {
					if (eglTemplate instanceof EglFileGeneratingTemplate) {
						generated = ((EglFileGeneratingTemplate) eglTemplate).append(target);
					}
				}
				else {
					generated = ((EglPersistentTemplate) eglTemplate).generate(target, overwrite, merge);
				}
			}
			
			module.getInvokedTemplates().add(eglTemplate.getTemplate());
			
			if (postBlock != null) {
				context.getFrameStack().enterLocal(FrameType.UNPROTECTED, postBlock, Variable.createReadOnlyVariable("generated", generated));
				postBlock.execute(context, false);
				context.getFrameStack().leaveLocal(postBlock);
			}
			
			context.getFrameStack().leaveLocal(this);
			
			eglTemplate.reset();
		}
			
	}
	
	@Override
	public List<?> getModuleElements() {
		return Collections.emptyList();
	}
	
	@Override
	public String toString() {
		String label = getName();
		if (sourceParameter != null) {
			label += " (" + sourceParameter.getTypeName() + ")";
		}
		return label;
	}

	@Override
	public AST getSuperRulesAst(AST cst) {
		return null;
	}
	
}
