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
package org.eclipse.epsilon.eml;

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
import org.eclipse.epsilon.eml.execute.EmlExecutorFactory;
import org.eclipse.epsilon.eml.execute.context.EmlContext;
import org.eclipse.epsilon.eml.parse.EmlLexer;
import org.eclipse.epsilon.eml.parse.EmlParser;
import org.eclipse.epsilon.eol.EolImport;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.etl.EtlModule;
import org.eclipse.epsilon.etl.execute.EtlExecutorFactory;


public class EmlModule extends EtlModule {
	
	//protected EolLabeledBlock preBlock;
	//protected EolLabeledBlock postBlock;
	//protected EolLabeledBlock midBlock;
	protected EmlContext context = new EmlContext();
	//protected IEolModel leftModel = null;
	//protected IEolModel rightModel = null;
	//protected IEolModel mergedModel = null;
	//protected ASTFactory astFactory = null;
	//protected TransformRules transformRules = null;
	protected MergeRules declaredMergeRules = null;
	protected MergeRules mergeRules = null;
	
	public EmlModule(){
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
		return new EmlLexer(input);
	}

	@Override
	public EpsilonParser createParser(TokenStream tokenStream) {
		// TODO Auto-generated method stub
		return new EmlParser(tokenStream);
	}

	@Override
	public String getMainRule() {
		return "emlModule";
	}

	@Override
	public HashMap<String, Class> getImportConfiguration() {
		HashMap<String, Class> importConfiguration = super.getImportConfiguration();
		importConfiguration.put("eml", EmlModule.class);
		return importConfiguration;
	}

	@Override
	public void buildModel() throws Exception {
		
		super.buildModel();
		
		Iterator it;
		
		//Parse the pre match block
		//AST preBlockAst = AstUtil.getChild(ast, EmlParserTokenTypes.PREBLOCK);
		//if (preBlockAst != null){
		//	preBlock = new EolLabeledBlock(preBlockAst,"pre");
		//}
		
		//Parse the post match block		
		//AST postBlockAst = AstUtil.getChild(ast, EmlParserTokenTypes.POSTBLOCK);
		//if (postBlockAst != null){
		//	postBlock = new EolLabeledBlock(postBlockAst,"post");
		//}
		
		//	Parse the pre merge block
		//AST midBlockAst = AstUtil.getChild(ast, EmlParserTokenTypes.MIDBLOCK);
		//if (midBlockAst != null){
		//	midBlock = new EolLabeledBlock(midBlockAst,"mid");
		//}
		
		// Parse the merge rules
		it = AstUtil.getChildren(ast, EmlParser.MERGE).iterator();
		while (it.hasNext()){
			AST mergeRuleAst = (AST) it.next();
			MergeRule mergeRule = new MergeRule(mergeRuleAst);
			declaredMergeRules.add(mergeRule);
		}
		
		// Parse the transform rules
		//it = AstUtil.getChildren(ast, EmlParserTokenTypes.TRANSFORMRULE).iterator();
		//while (it.hasNext()){
		//	AST transformRuleAst = (AST) it.next();
		//	TransformRule transformRule = new TransformRule(transformRuleAst);
		//	transformRules.add(transformRule);
		//}
		
		getParseProblems().addAll(declaredMergeRules.calculateSuperRules(getMergeRules()));
		
		// Calculate the super rules
		//calculateSuperRules(declaredMergeRules);
		//calculateSuperRules(transformRules);
		
	}
	
	/*
	public void calculateSuperRules(NamedRules rules){
		Iterator it = rules.iterator();
		while (it.hasNext()){
			ExtensibleNamedRule rule = (ExtensibleNamedRule) it.next();
			try {
				rule.calculateSuperRules(rules);
			} catch (ErlRuleNotFoundException e) {
				ParseProblem problem = new ParseProblem();
				problem.setLine(rule.getAst().getLine());
				problem.setReason(e.getReason());
				getParseProblems().add(problem);
			} catch (ErlCircularRuleInheritanceException e) {
				ParseProblem problem = new ParseProblem();
				problem.setLine(rule.getAst().getLine());
				problem.setReason(e.getReason());
				getParseProblems().add(problem);
			}
		}		
	}
	*/
	
	@Override
	public Object execute() throws EolRuntimeException{
		
		context.setModule(this);
		
		context.getFrameStack().put(Variable.createReadOnlyVariable("matchTrace", context.getMatchTrace()));
		context.getFrameStack().put(Variable.createReadOnlyVariable("mergeTrace", context.getMergeTrace()));
		context.getFrameStack().put(Variable.createReadOnlyVariable("transTrace", context.getTransformationTrace()));
		context.getFrameStack().put(Variable.createReadOnlyVariable("context", context));
		context.getFrameStack().put(Variable.createReadOnlyVariable("thisModule", this));
		
		EmlExecutorFactory emlExecutorFactory = new EmlExecutorFactory();
		emlExecutorFactory.setExecutionController(context.getExecutorFactory().getExecutionController());
		context.setExecutorFactory(emlExecutorFactory);
		
		//if (preBlock != null){
		//	context.getExecutorFactory().executeAST(preBlock.getAst(), context);
		//}
		
		execute(getPre(), context);
		
		context.getMergingStrategy().mergeModels(context);
		
		//if (postBlock != null){
		//	context.getExecutorFactory().executeAST(postBlock.getAst(), context);
		//}
		
		execute(getPost(), context);
		
		/*
		try {
			new MatchViewer((MofModel)leftModel, (MofModel)rightModel, context.getMatchTrace());
		} catch (Exception e) {
			e.printStackTrace();
		}
		*/
		
		// context.getModelRepository().shutdown();
		
		return null;
	}
	
	/*
	public List<ParseProblem> getParseProblems(){
		return parser.getParseProblems();
	}
	*/
	
	@Override
	public EmlContext getContext() {
		return context;
	}
	
	/*
	public AST getAST(){
		return parser.getAST();
	}
	*/
	
	@Override
	public void reset(){
		super.reset();
		//preBlock = null;
		//postBlock = null;
		//midBlock = null;
		declaredMergeRules = new MergeRules();
		mergeRules = null;
		//transformRules = new TransformRules();
	}
	/*
	public IEolModel getLeftModel() {
		return leftModel;
	}

	public void setLeftModel(IEolModel left) {
		this.leftModel = left;
	}

	public IEolModel getMergedModel() {
		return mergedModel;
	}

	public void setMergedModel(IEolModel merged) {
		this.mergedModel = merged;
	}

	public IEolModel getRightModel() {
		return rightModel;
	}

	public void setRightModel(IEolModel rightModel) {
		this.rightModel = rightModel;
	}
	
	public IEolModel getTargetModel() {
		return mergedModel;
	}
	*/
	public MergeRules getDeclaredMergeRules(){
		return declaredMergeRules;
	}
	
	public MergeRules getMergeRules() {
		if (mergeRules == null) {
			mergeRules = new MergeRules();
			for (EolImport import_ : imports) {
				if (import_.isLoaded() && (import_.getModule() instanceof EmlModule)) {
					EmlModule module = (EmlModule) import_.getModule();
					mergeRules.addAll(module.getMergeRules());
				}
			}
			mergeRules.addAll(declaredMergeRules);
		}
		return mergeRules;
	}
	
	@Override
	public List<ModuleElement> getChildren() {
		List children = new ArrayList();
		children.addAll(getImports());
		children.addAll(getDeclaredPre());
		//if (preBlock != null){
		//	children.add(preBlock);
		//}
		//if (midBlock != null){
		//	children.add(midBlock);
		//}
		//if (postBlock != null){
		//	children.add(postBlock);
		//}
		children.addAll(declaredMergeRules);
		children.addAll(declaredTransformRules);
		children.addAll(getDeclaredPost());
		children.addAll(getDeclaredOperations());
		return children;
	}

	@Override
	protected int getPostBlockTokenType() {
		return EmlParser.POST;
	}

	@Override
	protected int getPreBlockTokenType() {
		return EmlParser.PRE;
	}
	
	//public EolLabeledBlock getPreBlock() {
	//	return preBlock;
	//}

	//public EolLabeledBlock getPostBlock() {
	//	return postBlock;
	//}

	//public TransformRules getDeclaredTransformRules() {
	//	return transformRules;
	//}

	//public void setSourceModel(EolModel sourceModel) {
		
	//}

	//public EolModel getSourceModel() {
	//	return null;
	//}

	//public void setTargetModel(EolModel targetModel) {
		
	//}

	//public void setContext(EtlContext context) {
		
	//}
	
}

