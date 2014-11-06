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
package org.eclipse.epsilon.etl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.Lexer;
import org.antlr.runtime.TokenStream;
import org.eclipse.epsilon.common.module.ModuleElement;
import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.common.parse.EpsilonParser;
import org.eclipse.epsilon.common.util.AstUtil;
import org.eclipse.epsilon.eol.dom.ExecutableBlock;
import org.eclipse.epsilon.eol.dom.Import;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.erl.ErlModule;
import org.eclipse.epsilon.erl.dom.NamedRuleList;
import org.eclipse.epsilon.etl.dom.EquivalentAssignmentStatement;
import org.eclipse.epsilon.etl.dom.TransformationRule;
import org.eclipse.epsilon.etl.execute.context.EtlContext;
import org.eclipse.epsilon.etl.execute.context.IEtlContext;
import org.eclipse.epsilon.etl.execute.operations.EtlOperationFactory;
import org.eclipse.epsilon.etl.parse.EtlLexer;
import org.eclipse.epsilon.etl.parse.EtlParser;
import org.eclipse.epsilon.etl.strategy.DefaultTransformationStrategy;
import org.eclipse.epsilon.etl.strategy.FastTransformationStrategy;


public class EtlModule extends ErlModule implements IEtlModule {
	
	protected NamedRuleList<TransformationRule> declaredTransformationRules = null;
	protected NamedRuleList<TransformationRule> transformationRules = null;
	protected IEtlContext context = null;
	
	public EtlModule(){
		reset();
	}
	
	@Override
	protected Lexer createLexer(ANTLRInputStream inputStream) {
		return new EtlLexer(inputStream);
	}

	@Override
	public EpsilonParser createParser(TokenStream tokenStream) {
		return new EtlParser(tokenStream);
	}

	@Override
	public String getMainRule() {
		return "etlModule";
	}
	
	@Override
	public AST adapt(AST cst, AST parentAst) {
		if (cst.getType() == EtlParser.TRANSFORM) {
			return new TransformationRule();
		}
		else if (cst.getType() == EtlParser.GUARD) {
			return new ExecutableBlock<Boolean>(Boolean.class);
		}
		else if (cst.getType() == EtlParser.BLOCK && cst.getParent() != null && cst.getParent().getType() == EtlParser.TRANSFORM) {
			return new ExecutableBlock<Void>(Void.class);
		}
		else if (cst.getType() == EtlParser.SPECIAL_ASSIGNMENT) {
			return new EquivalentAssignmentStatement();
		}
		return super.adapt(cst, parentAst);
	}
	
	@Override
	public void buildModel() throws Exception {
		
		super.buildModel();
		
		// Parse the transform rules
		for (AST transformationRuleAst : AstUtil.getChildren(ast, EtlParser.TRANSFORM)) {
			declaredTransformationRules.add((TransformationRule) transformationRuleAst);
		}

		getParseProblems().addAll(calculateSuperRules(getTransformationRules()));
	}
	
	public List<TransformationRule> getDeclaredTransformationRules() {
		return declaredTransformationRules;
	}

	protected boolean hasLazyRules(IEtlContext context) {
		for (TransformationRule rule : getTransformationRules()) {
			try {
				if (rule.isLazy()) {
					return true;
				}
			} catch (EolRuntimeException e) {}
		}
		return false;
	}
	
	public Object execute() throws EolRuntimeException {
		
		// Initialize the context
		prepareContext(context);
		context.setOperationFactory(new EtlOperationFactory());
		
		if (hasLazyRules(context)) {
			context.setTransformationStrategy(new DefaultTransformationStrategy());
		}
		else {
			context.setTransformationStrategy(new FastTransformationStrategy());
		}
		
		context.getFrameStack().put(Variable.createReadOnlyVariable("transTrace", context.getTransformationTrace()));
		context.getFrameStack().put(Variable.createReadOnlyVariable("context", context));
		context.getFrameStack().put(Variable.createReadOnlyVariable("module", this));
		
		execute(getPre(), context);
		
		// Execute the transformModel() method of the strategy
		if (context.getTransformationStrategy() != null){
			context.getTransformationStrategy().transformModels(context);
		}
		
		execute(getPost(), context);
		
		return context.getTransformationTrace();
	}
	
	@Override
	public HashMap<String, Class<?>> getImportConfiguration() {
		HashMap<String, Class<?>> importConfiguration = super.getImportConfiguration();
		importConfiguration.put("etl", EtlModule.class);
		return importConfiguration;
	}

	@Override
	public IEtlContext getContext(){
		return context;
	}
	
	public void setContext(IEtlContext context){
		this.context = context;
	}
	
	@Override
	public List<ModuleElement> getModuleElements(){
		final List<ModuleElement> children = new ArrayList<ModuleElement>();
		children.addAll(getImports());
		children.addAll(getDeclaredPre());
		children.addAll(declaredTransformationRules);
		children.addAll(getDeclaredPost());
		children.addAll(getDeclaredOperations());
		return children;
	}
	
	@Override
	public void reset(){
		super.reset();
		//preBlock = null;
		//postBlock = null;
		transformationRules = null;
		declaredTransformationRules = new NamedRuleList<TransformationRule>();
		context = new EtlContext();
	}

	public List<TransformationRule> getTransformationRules() {
		if (transformationRules == null) {
			transformationRules = new NamedRuleList<TransformationRule>();
			for (Import import_ : imports) {
				if (import_.isLoaded() && (import_.getModule() instanceof IEtlModule)) {
					IEtlModule module = (IEtlModule) import_.getModule();
					transformationRules.addAll(module.getTransformationRules());
				}
			}
			transformationRules.addAll(declaredTransformationRules);
		}
		return transformationRules;
	}

	@Override
	protected int getPostBlockTokenType() {
		return EtlParser.POST;
	}

	@Override
	protected int getPreBlockTokenType() {
		return EtlParser.PRE;
	}

	@Override
	public void setContext(IEolContext context) {
		if (context instanceof IEtlContext) {
			this.context = (IEtlContext) context;
		}
	}
		
}
