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
import org.eclipse.epsilon.common.util.AstUtil;
import org.eclipse.epsilon.eol.dom.ExecutableBlock;
import org.eclipse.epsilon.eol.dom.Import;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.erl.ErlModule;
import org.eclipse.epsilon.evl.dom.Constraint;
import org.eclipse.epsilon.evl.dom.ConstraintContext;
import org.eclipse.epsilon.evl.dom.Constraints;
import org.eclipse.epsilon.evl.dom.Fix;
import org.eclipse.epsilon.evl.dom.GlobalConstraintContext;
import org.eclipse.epsilon.evl.execute.EvlOperationFactory;
import org.eclipse.epsilon.evl.execute.context.EvlContext;
import org.eclipse.epsilon.evl.execute.context.IEvlContext;
import org.eclipse.epsilon.evl.parse.EvlLexer;
import org.eclipse.epsilon.evl.parse.EvlParser;


public class EvlModule extends ErlModule implements IEvlModule {
	
	protected IEvlFixer fixer = null;
	protected ArrayList<ConstraintContext> declaredConstraintContexts = new ArrayList<ConstraintContext>();
	protected ArrayList<ConstraintContext> constraintContexts;
	protected Constraints constraints = new Constraints();
	protected IEvlContext context = null;
	
	public static void main(String[] args) throws Exception {
		
		EvlModule module = new EvlModule();
		module.parse(new File("/Users/dimitrioskolovos/Downloads/eclipse-modeling-kepler/workspace/org.eclipse.epsilon.evl.engine/src/org/eclipse/epsilon/evl/test.evl"));
		System.out.println(module.getOperations());
		
	}
	
	public EvlModule(){
		reset();
	}
	
	@Override
	protected Lexer createLexer(ANTLRInputStream inputStream) {
		return new EvlLexer(inputStream);
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
	public AST adapt(AST cst, AST parentAst) {
		switch (cst.getType()) {
			case EvlParser.FIX: return new Fix();
			case EvlParser.DO: return new ExecutableBlock<Void>(Void.class);
			case EvlParser.TITLE: return new ExecutableBlock<String>(String.class);
			case EvlParser.MESSAGE: return new ExecutableBlock<String>(String.class);
			case EvlParser.CONSTRAINT: return new Constraint();
			case EvlParser.CRITIQUE: return new Constraint();
			case EvlParser.CONTEXT: return new ConstraintContext();
			case EvlParser.CHECK: return new ExecutableBlock<Boolean>(Boolean.class);
			case EvlParser.GUARD: return new ExecutableBlock<Boolean>(Boolean.class);
		}
		return super.adapt(cst, parentAst);
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
		
		GlobalConstraintContext globalConstraintContext = new GlobalConstraintContext();
		
		for (AST constraintAst : AstUtil.getChildren(ast, EvlParser.CONSTRAINT)) {
			globalConstraintContext.getConstraints().addConstraint((Constraint) constraintAst); 
			((Constraint) constraintAst).setConstraintContext(globalConstraintContext);
		}
		
		for (AST critiqueAst : AstUtil.getChildren(ast, EvlParser.CRITIQUE)) {
			globalConstraintContext.getConstraints().addConstraint((Constraint) critiqueAst); 
			((Constraint) critiqueAst).setConstraintContext(globalConstraintContext);
		}
		
		if (!globalConstraintContext.getConstraints().values().isEmpty()) declaredConstraintContexts.add(globalConstraintContext);
		
		for (AST constraintContextAst : AstUtil.getChildren(ast, EvlParser.CONTEXT)) {
			ConstraintContext constraintContext = (ConstraintContext) constraintContextAst;
			declaredConstraintContexts.add(constraintContext);
		}
		
		// Cache all the constraints
		for (ConstraintContext constraintContext : getConstraintContexts()) {
			for (Constraint constraint : constraintContext.getConstraints()) {
				constraints.addConstraint(constraint);
			}
		}
	}
	
	public ArrayList<ConstraintContext> getDeclaredConstraintContexts() {
		return declaredConstraintContexts;
	}

	public ArrayList<ConstraintContext> getConstraintContexts() {
		if (constraintContexts == null) {
			constraintContexts = new ArrayList<ConstraintContext>();
			for (Import import_ : imports) {
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
		
		for (ConstraintContext constraintContext : getConstraintContexts()) {
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
	
	public Constraints getConstraints(){ 
		return constraints;
	}
	
	@Override
	public List<ModuleElement> getModuleElements(){
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
		declaredConstraintContexts = new ArrayList<ConstraintContext>();
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

	@Override
	public void setContext(IEolContext context) {
		if (context instanceof IEvlContext) {
			this.context = (IEvlContext) context;
		}
	}
	
}
