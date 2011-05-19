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


public class EmlModule extends EtlModule {
	
	protected EmlContext context = new EmlContext();
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
			declaredMergeRules.add(new MergeRule(mergeRuleAst));
		}
		
		getParseProblems().addAll(declaredMergeRules.calculateSuperRules(getMergeRules()));		
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
	public void reset(){
		super.reset();
		declaredMergeRules = new MergeRules();
		mergeRules = null;
	}
	
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
		final List<ModuleElement> children = new ArrayList<ModuleElement>();
		children.addAll(getImports());
		children.addAll(getDeclaredPre());
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
}