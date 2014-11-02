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
import org.eclipse.epsilon.eml.dom.MergeRule;
import org.eclipse.epsilon.eml.execute.EmlExecutorFactory;
import org.eclipse.epsilon.eml.execute.context.EmlContext;
import org.eclipse.epsilon.eml.parse.EmlLexer;
import org.eclipse.epsilon.eml.parse.EmlParser;
import org.eclipse.epsilon.eol.dom.Import;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.erl.dom.NamedRuleList;
import org.eclipse.epsilon.etl.EtlModule;


public class EmlModule extends EtlModule {
	
	protected EmlContext context = new EmlContext();
	protected NamedRuleList<MergeRule> declaredMergeRules = null;
	protected NamedRuleList<MergeRule> mergeRules = null;
	
	public EmlModule(){
		reset();
	}
	
	@Override
	protected Lexer createLexer(ANTLRInputStream inputStream) {
		return new EmlLexer(inputStream);
	}

	@Override
	public EpsilonParser createParser(TokenStream tokenStream) {
		return new EmlParser(tokenStream);
	}

	@Override
	public String getMainRule() {
		return "emlModule";
	}

	@Override
	public HashMap<String, Class<?>> getImportConfiguration() {
		HashMap<String, Class<?>> importConfiguration = super.getImportConfiguration();
		importConfiguration.put("eml", EmlModule.class);
		return importConfiguration;
	}

	@Override
	public void buildModel() throws Exception {
		
		super.buildModel();
		
		// Parse the merge rules
		for (AST mergeRuleAst : AstUtil.getChildren(ast, EmlParser.MERGE)) {
			declaredMergeRules.add((MergeRule) mergeRuleAst);
		}
		
		getParseProblems().addAll(calculateSuperRules(getMergeRules()));		
	}
	
	@Override
	public Object execute() throws EolRuntimeException{
		
		prepareContext(context);
		
		context.getFrameStack().put(Variable.createReadOnlyVariable("matchTrace", context.getMatchTrace()));
		context.getFrameStack().put(Variable.createReadOnlyVariable("mergeTrace", context.getMergeTrace()));
		context.getFrameStack().put(Variable.createReadOnlyVariable("transTrace", context.getTransformationTrace()));
		context.getFrameStack().put(Variable.createReadOnlyVariable("context", context));
		context.getFrameStack().put(Variable.createReadOnlyVariable("thisModule", this));
		
		EmlExecutorFactory emlExecutorFactory = new EmlExecutorFactory();
		emlExecutorFactory.setExecutionController(context.getExecutorFactory().getExecutionController());
		context.setExecutorFactory(emlExecutorFactory);
		
		execute(getPre(), context);
		context.getMergingStrategy().mergeModels(context);
		execute(getPost(), context);
		
		return null;
	}
	
	@Override
	public EmlContext getContext() {
		return context;
	}
	
	@Override
	public AST adapt(AST cst, AST parentAst) {
		if (cst.getType() == EmlParser.MERGE) {
			return new MergeRule();
		}
		return super.adapt(cst, parentAst);
	}
	
	@Override
	public void reset(){
		super.reset();
		declaredMergeRules = new NamedRuleList<MergeRule>();
		mergeRules = null;
	}
	
	public List<MergeRule> getDeclaredMergeRules(){
		return declaredMergeRules;
	}
	
	public List<MergeRule> getMergeRules() {
		if (mergeRules == null) {
			mergeRules = new NamedRuleList<MergeRule>();
			for (Import import_ : imports) {
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
	public List<ModuleElement> getModuleElements() {
		final List<ModuleElement> children = new ArrayList<ModuleElement>();
		children.addAll(getImports());
		children.addAll(getDeclaredPre());
		children.addAll(declaredMergeRules);
		children.addAll(declaredTransformationRules);
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
}