/*********************************************************************
* Copyright (c) 2008 The University of York.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.picto;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.epsilon.common.module.ModuleElement;
import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.egl.EglTemplate;
import org.eclipse.epsilon.egl.EglTemplateFactory;
import org.eclipse.epsilon.egl.EgxModule;
import org.eclipse.epsilon.egl.dom.GenerationRule;
import org.eclipse.epsilon.egl.execute.context.IEgxContext;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.FrameStack;
import org.eclipse.epsilon.eol.execute.context.FrameType;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.Variable;

public class LazyEgxModule extends EgxModule {
	
	public LazyEgxModule() {
		super();
	}
	
	public LazyEgxModule(EglTemplateFactory templateFactory) {
		super(templateFactory);
	}
	
	@Override
	public ModuleElement adapt(AST cst, ModuleElement parentAst) {
		ModuleElement ast = super.adapt(cst, parentAst);
		if (ast instanceof GenerationRule) return new LazyGenerationRule();
		else return ast;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	protected Object processRules() throws EolRuntimeException {
		IEgxContext context = getContext();
		List<LazyGenerationRuleContentPromise> promises = new ArrayList<>();
		for (GenerationRule rule : getGenerationRules()) {
			promises.addAll((List<LazyGenerationRuleContentPromise>) context.getExecutorFactory().execute(rule, context));
		}
		return promises;
	}
	
	public class LazyGenerationRule extends GenerationRule {
		
		@Override
		public Object execute(IEolContext context_, Object element) throws EolRuntimeException {
			IEgxContext context = (IEgxContext) context_;
			FrameStack frameStack = context.getFrameStack();
			
			if (sourceParameter != null) {
				frameStack.enterLocal(FrameType.PROTECTED, this, Variable.createReadOnlyVariable(sourceParameter.getName(), element));
			}
			else {
				frameStack.enterLocal(FrameType.PROTECTED, this);
			}
			
			if (guardBlock != null && !guardBlock.execute(context, false)) {
				frameStack.leaveLocal(this);
				return null;
			}
			
			if (preBlock != null) {
				preBlock.execute(context, false);
			}
			
			final String templateName = (templateBlock == null) ? "" : templateBlock.execute(context, false);
			final EglTemplateFactory templateFactory = context.getTemplateFactory();
			List<Variable> variables = new ArrayList<>();
			URI templateUri = templateFactory.resolveTemplate(templateName);
			
			if (sourceParameter != null) {
				variables.add(Variable.createReadOnlyVariable(sourceParameter.getName(), element));
			}
			
			if (parametersBlock != null) {
				for (Map.Entry<String, ?> entry : parametersBlock.execute(context, false).entrySet()) {
					variables.add(Variable.createReadOnlyVariable(entry.getKey(), entry.getValue()));
				}
			}
			
			frameStack.leaveLocal(this);
			return new LazyGenerationRuleContentPromise(templateFactory, templateUri, variables);
		}
		
		@Override
		public Object execute(IEolContext context) throws EolRuntimeException {
			List<LazyGenerationRuleContentPromise> promises = new ArrayList<>();
			for (Object element : getAllElements(context)) {
				Object result = context.getExecutorFactory().execute(this, context, element);
				if (result instanceof LazyGenerationRuleContentPromise) {
					promises.add((LazyGenerationRuleContentPromise) result);
				}
			}
			return promises;
		}
	}
	
	public class LazyGenerationRuleContentPromise implements ContentPromise {
		protected EglTemplateFactory templateFactory;
		protected URI templateUri;
		protected List<Variable> variables;
		
		public LazyGenerationRuleContentPromise() {}
		
		public LazyGenerationRuleContentPromise(EglTemplateFactory templateFactory, URI templateUri, List<Variable> variables) {
			super();
			this.templateFactory = templateFactory;
			this.templateUri = templateUri;
			this.variables = variables;
		}
		
		public List<Variable> getVariables() {
			return variables;
		}
		
		public String getContent() throws Exception {
			
			EglTemplate template = templateFactory.load(templateUri);
			
			for (Variable variable : variables) {
				template.populate(variable.getName(), variable.getValue());
			}
			return template.process();
		}
		
	}
		
}
