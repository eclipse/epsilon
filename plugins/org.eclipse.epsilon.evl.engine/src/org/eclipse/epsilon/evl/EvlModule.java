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
package org.eclipse.epsilon.evl;

import java.io.IOException;
import java.io.InputStream;
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
import org.eclipse.epsilon.eol.EolImport;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.erl.ErlModule;
import org.eclipse.epsilon.evl.execute.EvlOperationFactory;
import org.eclipse.epsilon.evl.execute.context.EvlContext;
import org.eclipse.epsilon.evl.execute.context.IEvlContext;
import org.eclipse.epsilon.evl.parse.EvlLexer;
import org.eclipse.epsilon.evl.parse.EvlParser;


public class EvlModule extends ErlModule implements IEvlModule {
	
	protected IEvlFixer fixer = null;
	protected ArrayList<EvlConstraintContext> declaredConstraintContexts = new ArrayList<EvlConstraintContext>();
	protected ArrayList<EvlConstraintContext> constraintContexts;
	protected EvlConstraints constraints = new EvlConstraints();
	protected IEvlContext context = null;
	
	public EvlModule(){
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
		return new EvlLexer(input);
	}
 
	@Override
	public EpsilonParser createParser(TokenStream tokenStream) {
		return new EvlParser(tokenStream);
	}

	@Override
	public String getMainRule() {
		return "evlModule";
	}

	@Override
	public HashMap<String, Class<?>> getImportConfiguration() {
		HashMap<String, Class<?>> importConfiguration = super.getImportConfiguration();
		importConfiguration.put("evl", EvlModule.class);
		return importConfiguration;
	}
	
	@Override
	public void buildModel() throws Exception {
		
		super.buildModel();
		
		for (AST matchRuleAst : AstUtil.getChildren(ast, EvlParser.CONTEXT)) {
			EvlConstraintContext constraintContext = new EvlConstraintContext();
			constraintContext.build(matchRuleAst);
			declaredConstraintContexts.add(constraintContext);
		}
		
		// Cache all the constraints
		for (EvlConstraintContext constraintContext : getConstraintContexts()) {
			for (EvlConstraint constraint : constraintContext.getConstraints()) {
				constraints.addConstraint(constraint);
			}
		}
	}
	
	public ArrayList<EvlConstraintContext> getDeclaredConstraintContexts() {
		return declaredConstraintContexts;
	}

	public ArrayList<EvlConstraintContext> getConstraintContexts() {
		if (constraintContexts == null) {
			constraintContexts = new ArrayList<EvlConstraintContext>();
			for (EolImport import_ : imports) {
				if (import_.isLoaded() && (import_.getModule() instanceof IEvlModule)) {
					IEvlModule module = (IEvlModule) import_.getModule();
					constraintContexts.addAll(module.getConstraintContexts());
				}
			}
			constraintContexts.addAll(declaredConstraintContexts);
		}
		return constraintContexts;
	}
	
	public Object execute() throws EolRuntimeException {
		
		// Initialize the context
		prepareContext(context);
		context.setOperationFactory(new EvlOperationFactory());
		context.getFrameStack().put(Variable.createReadOnlyVariable("constraintTrace", context.getConstraintTrace()));
		context.getFrameStack().put(Variable.createReadOnlyVariable("thisModule", this));
		
		execute(getPre(), context);
		
		for (EvlConstraintContext constraintContext : getConstraintContexts()) {
			constraintContext.checkAll(context);
		}
		
		
		if (fixer != null) {
			fixer.fix(this);
		}
		
		execute(getPost(), context);
		
		return null;
	}
	
	@Override
	public IEvlContext getContext(){
		return context;
	}
	
	public EvlConstraints getConstraints(){ 
		return constraints;
	}
	
	@Override
	public List<ModuleElement> getChildren(){
		final List<ModuleElement> children = new ArrayList<ModuleElement>();
		children.addAll(getImports());
		children.addAll(getDeclaredPre());
		children.addAll(getDeclaredConstraintContexts());
		children.addAll(getDeclaredOperations());
		children.addAll(getDeclaredPost());
		return children;
	}
	
	@Override
	public void reset(){
		super.reset();
		constraintContexts = null;
		declaredConstraintContexts = new ArrayList<EvlConstraintContext>();
		context = new EvlContext();
	}

	public void setUnsatisfiedConstraintFixer(IEvlFixer fixer) {
		this.fixer = fixer;
	}

	public IEvlFixer getUnsatisfiedConstraintFixer() {
		return fixer;
	}

	@Override
	protected int getPostBlockTokenType() {
		return EvlParser.POST;
	}

	@Override
	protected int getPreBlockTokenType() {
		return EvlParser.PRE;
	}
	
}
