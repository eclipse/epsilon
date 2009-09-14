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
import java.util.Iterator;
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
import org.eclipse.epsilon.etl.strategy.FastTransformationStrategy2;


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
		// TODO Auto-generated method stub
		return new EtlParser(tokenStream);
	}

	@Override
	public String getMainRule() {
		return "etlModule";
	}
	
	@Override
	public void buildModel() throws Exception {
		
		super.buildModel();
		
		//Parse the pre block		
		//AST preBlockAst = AstUtil.getChild(ast, EtlParserTokenTypes.PREBLOCK);
		//if (preBlockAst != null){
		//	preBlock = new EolLabeledBlock(preBlockAst,"pre");
		//}
		
		//Parse the post block		
		//AST postBlockAst = AstUtil.getChild(ast, EtlParserTokenTypes.POSTBLOCK);
		//if (postBlockAst != null){
		//	postBlock = new EolLabeledBlock(postBlockAst,"post");
		//}
		
		// Parse the transform rules
		Iterator it = AstUtil.getChildren(ast, EtlParser.TRANSFORM).iterator();
		while (it.hasNext()){
			AST matchRuleAst = (AST) it.next();
			TransformRule transformRule = new TransformRule(matchRuleAst);
			declaredTransformRules.add(transformRule);
		}
		
		getParseProblems().addAll(declaredTransformRules.calculateSuperRules(getTransformRules()));
		
		/*
		// Calculate the super rules
		it = declaredTransformRules.iterator();
		while (it.hasNext()){
			TransformRule transformRule = (TransformRule) it.next();
			try {
				transformRule.calculateSuperRules(getTransformRules());
			} catch (ErlRuleNotFoundException e) {
				ParseProblem problem = new ParseProblem();
				problem.setLine(transformRule.getAst().getLine());
				problem.setReason(e.getReason());
				getParseProblems().add(problem);
			} catch (ErlCircularRuleInheritanceException e) {
				ParseProblem problem = new ParseProblem();
				problem.setLine(transformRule.getAst().getLine());
				problem.setReason(e.getReason());
				getParseProblems().add(problem);
			}
		}
		*/
	}

	//public EolLabeledBlock getPreBlock() {
	///	return preBlock;
	//}

	//public EolLabeledBlock getPostBlock() {
	//	return postBlock;
	//}
	
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
		context.setModule(this);
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
		
		//context.setTransformationStrategy(new FastTransformationStrategy2());
		
		//context.getModelRepository().addModel(sourceModel);
		//context.getModelRepository().addModel(targetModel);
		
		context.getFrameStack().put(Variable.createReadOnlyVariable("transTrace", context.getTransformationTrace()));
		context.getFrameStack().put(Variable.createReadOnlyVariable("context", context));
		context.getFrameStack().put(Variable.createReadOnlyVariable("module", this));
		
		// Reload the target model so that it is clean
		//targetModel.setReadWrite(EolModel.WRITE_ONLY);
		//targetModel.load();
		
		execute(getPre(), context);
		
		// Execute the preBlock
		//if (preBlock != null){
		//	context.getExecutorFactory().executeAST(preBlock.getAst(), context);
		//}
		
		// Execute the transformModel() method of the strategy
		if (context.getTransformationStrategy() != null){
			context.getTransformationStrategy().transformModels(context);
		}
		
		// Execute the postBlock
		//if (postBlock != null) {
		//	context.getExecutorFactory().executeAST(postBlock.getAst(), context);
		//}
		
		execute(getPost(), context);
		
		return context.getTransformationTrace();
	}
	
	@Override
	public HashMap<String, Class> getImportConfiguration() {
		HashMap<String, Class> importConfiguration = super.getImportConfiguration();
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
		List children = new ArrayList();
		children.addAll(getImports());
		children.addAll(getDeclaredPre());
		//if (preBlock != null){
		//	children.add(preBlock);
		//}
		//if (postBlock != null){
		//	children.add(postBlock);
		//}
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
