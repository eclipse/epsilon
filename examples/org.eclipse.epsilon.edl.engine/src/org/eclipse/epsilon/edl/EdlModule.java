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
package org.eclipse.epsilon.edl;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.Lexer;
import org.antlr.runtime.TokenStream;
import org.eclipse.epsilon.common.module.ModuleElement;
import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.common.parse.EpsilonParser;
import org.eclipse.epsilon.common.parse.problem.ParseProblem;
import org.eclipse.epsilon.common.util.AstUtil;
import org.eclipse.epsilon.edl.parse.EdlLexer;
import org.eclipse.epsilon.edl.parse.EdlParser;
import org.eclipse.epsilon.emc.plainxml.PlainXmlModel;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.EolContext;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.erl.ErlModule;


public class EdlModule extends ErlModule {
	
	protected List<ProcessRule> declaredProcessRules = null;
	protected IEolContext context = null;

	public static void main(String[] args) throws Exception {
		
		EdlModule module = new EdlModule();
		module.parse(new File("resources/test.edl"));
		if (!module.getParseProblems().isEmpty()) {
			System.err.println("The following errors were identified");
			for (ParseProblem parseProblem : module.getParseProblems()) {
				System.err.println("- " + parseProblem);
			}
			return;
		}
		
		PlainXmlModel model = new PlainXmlModel();
		model.setFile(new File("resources/library.xml"));
		model.setName("M");
		model.load();
		
		module.getContext().getModelRepository().addModel(model);
		module.execute();
	}
	
	public EdlModule(){
		reset();
	}
	
	@Override
	public ModuleElement adapt(AST cst, AST parentAst) {
		if (cst.getType() == EdlParser.PROCESS) {
			return new ProcessRule();
		}
		return super.adapt(cst, parentAst);
	}
	
	@Override
	public Lexer createLexer(ANTLRInputStream inputStream) {
		return new EdlLexer(inputStream);
	}

	@Override
	public EpsilonParser createParser(TokenStream tokenStream) {
		return new EdlParser(tokenStream);
	}

	@Override
	public String getMainRule() {
		return "edlModule";
	}
	
	@Override
	public void buildModel() throws Exception {
		
		super.buildModel();
		
		for (AST processRuleAst : AstUtil.getChildren(ast, EdlParser.PROCESS)) {
			declaredProcessRules.add((ProcessRule) processRuleAst);
		}

	}

	@Override
	public HashMap<String, Class<?>> getImportConfiguration() {
		HashMap<String, Class<?>> importConfiguration = super.getImportConfiguration();
		importConfiguration.put("edl", EdlModule.class);
		return importConfiguration;
	}
	
	public Object execute() throws EolRuntimeException {
		
		// Initialize the context
		prepareContext(context);
		
		execute(getPre(), context);

		for (ProcessRule processRule : declaredProcessRules) {
			processRule.execute(context);
		}
		
		execute(getPost(), context);
		
		return null;
	}
	
	@Override
	public IEolContext getContext(){
		return context;
	}

	@Override
	public void setContext(IEolContext context) {
		this.context = context;
	}
	
	@Override
	public List<ModuleElement> getModuleElements(){
		final List<ModuleElement> children = new ArrayList<ModuleElement>();
		children.addAll(getImports());
		children.addAll(getDeclaredPre());
		children.addAll(getDeclaredProcessRules());
		children.addAll(getDeclaredOperations());
		children.addAll(getDeclaredPost());
		return children;
	}
	
	@Override
	public void reset(){
		super.reset();
		declaredProcessRules = new ArrayList<ProcessRule>();
		context = new EolContext();
	}

	@Override
	protected int getPostBlockTokenType() {
		return EdlParser.POST;
	}

	@Override
	protected int getPreBlockTokenType() {
		return EdlParser.PRE;
	}
	
	public List<ProcessRule> getDeclaredProcessRules() {
		return declaredProcessRules;
	}
}
