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

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.Lexer;
import org.antlr.runtime.TokenStream;
import org.eclipse.epsilon.commons.module.ModuleElement;
import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.commons.parse.EpsilonParser;
import org.eclipse.epsilon.commons.util.AstUtil;
import org.eclipse.epsilon.eol.EolImport;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.erl.ErlModule;
import org.eclipse.epsilon.erl.rules.INamedRule;
import org.eclipse.epsilon.etl.execute.EtlExecutorFactory;
import org.eclipse.epsilon.etl.execute.context.EtlContext;
import org.eclipse.epsilon.etl.execute.context.IEtlContext;
import org.eclipse.epsilon.etl.execute.operations.EtlOperationFactory;
import org.eclipse.epsilon.etl.parse.EtlLexer;
import org.eclipse.epsilon.etl.parse.EtlParser;
import org.eclipse.epsilon.etl.strategy.DefaultTransformationStrategy;
import org.eclipse.epsilon.etl.strategy.FastTransformationStrategy;


public class EtlModule extends ErlModule implements IEtlModule {
	
	protected TransformRules declaredTransformRules = null;
	protected TransformRules transformRules = null;
	protected IEtlContext context = null;
	
	public EtlModule(){
		reset();
	}
	
	@Override
	public Lexer createLexer(InputStream inputStream) {
		ANTLRInputStream input = null;
		try {
			input = new ANTLRInputStream(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new EtlLexer(input);
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
	public void buildModel() throws Exception {
		
		super.buildModel();
		
		// Parse the transform rules
		for (AST matchRuleAst : AstUtil.getChildren(ast, EtlParser.TRANSFORM)) {
			declaredTransformRules.add(new TransformRule(matchRuleAst));
		}
		
		getParseProblems().addAll(declaredTransformRules.calculateSuperRules(getTransformRules()));
	}
	
	public TransformRules getDeclaredTransformRules() {
		return declaredTransformRules;
	}

	protected boolean hasLazyRules(IEtlContext context) {
		for (INamedRule rule : getTransformRules()) {
			TransformRule transformRule = (TransformRule) rule;
			try {
				if (transformRule.isLazy()) {
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
		
		EtlExecutorFactory etlExecutorFactory = new EtlExecutorFactory();
		etlExecutorFactory.setExecutionController(context.getExecutorFactory().getExecutionController());
		context.setExecutorFactory(etlExecutorFactory);
		
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
	public List<ModuleElement> getChildren(){
		final List<ModuleElement> children = new ArrayList<ModuleElement>();
		children.addAll(getImports());
		children.addAll(getDeclaredPre());
		children.addAll(declaredTransformRules);
		children.addAll(getDeclaredPost());
		children.addAll(getDeclaredOperations());
		return children;
	}
	
	@Override
	public void reset(){
		super.reset();
		//preBlock = null;
		//postBlock = null;
		transformRules = null;
		declaredTransformRules = new TransformRules();
		context = new EtlContext();
	}
	/*
	public void setSourceModel(IEolModel sourceModel) {
		this.sourceModel = sourceModel;
	}

	public IEolModel getSourceModel() {
		return sourceModel;
	}

	public void setTargetModel(IEolModel targetModel) {
		this.targetModel = targetModel;
	}

	public IEolModel getTargetModel() {
		return targetModel;
	}
*/
	public TransformRules getTransformRules() {
		if (transformRules == null) {
			transformRules = new TransformRules();
			for (EolImport import_ : imports) {
				if (import_.isLoaded() && (import_.getModule() instanceof IEtlModule)) {
					IEtlModule module = (IEtlModule) import_.getModule();
					transformRules.addAll(module.getTransformRules());
				}
			}
			transformRules.addAll(declaredTransformRules);
		}
		return transformRules;
	}

	@Override
	protected int getPostBlockTokenType() {
		return EtlParser.POST;
	}

	@Override
	protected int getPreBlockTokenType() {
		return EtlParser.PRE;
	}
		
}
