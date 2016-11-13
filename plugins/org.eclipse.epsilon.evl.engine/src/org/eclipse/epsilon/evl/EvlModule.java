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

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.Lexer;
import org.antlr.runtime.TokenStream;
import org.eclipse.epsilon.common.module.IModule;
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


/**
 * The Class EvlModule.
 */
public class EvlModule extends ErlModule implements IEvlModule {
	
	/** The fixer. */
	protected IEvlFixer fixer = null;
	
	/** The declared constraint contexts. */
	protected ArrayList<ConstraintContext> declaredConstraintContexts = new ArrayList<ConstraintContext>();
	
	/** The constraint contexts. */
	protected ArrayList<ConstraintContext> constraintContexts;
	
	/** The constraints. */
	protected Constraints constraints = new Constraints();
	
	/** The context. */
	protected IEvlContext context = new EvlContext();
	
	/** The optimize constraints. */
	private boolean optimizeConstraints = false;
	
	/* (non-Javadoc)
	 * @see org.eclipse.epsilon.eol.EolLibraryModule#createLexer(org.antlr.runtime.ANTLRInputStream)
	 */
	@Override
	protected Lexer createLexer(ANTLRInputStream inputStream) {
		return new EvlLexer(inputStream);
	}
 
	/* (non-Javadoc)
	 * @see org.eclipse.epsilon.eol.EolLibraryModule#createParser(org.antlr.runtime.TokenStream)
	 */
	@Override
	public EpsilonParser createParser(TokenStream tokenStream) {
		return new EvlParser(tokenStream);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.epsilon.eol.EolLibraryModule#getMainRule()
	 */
	@Override
	public String getMainRule() {
		return "evlModule";
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.epsilon.erl.ErlModule#adapt(org.eclipse.epsilon.common.parse.AST, org.eclipse.epsilon.common.module.ModuleElement)
	 */
	@Override
	public ModuleElement adapt(AST cst, ModuleElement parentAst) {
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
	
	/* (non-Javadoc)
	 * @see org.eclipse.epsilon.eol.EolLibraryModule#getImportConfiguration()
	 */
	@Override
	public HashMap<String, Class<?>> getImportConfiguration() {
		HashMap<String, Class<?>> importConfiguration = super.getImportConfiguration();
		importConfiguration.put("evl", EvlModule.class);
		return importConfiguration;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.epsilon.erl.ErlModule#build(org.eclipse.epsilon.common.parse.AST, org.eclipse.epsilon.common.module.IModule)
	 */
	@Override
	public void build(AST cst, IModule module) {
		super.build(cst, module);
		
		GlobalConstraintContext globalConstraintContext = new GlobalConstraintContext();
		globalConstraintContext.setModule(this);
		globalConstraintContext.setParent(this);
		this.getChildren().add(globalConstraintContext);
		
		for (AST constraintAst : AstUtil.getChildren(cst, EvlParser.CONSTRAINT)) {
			Constraint constraint = (Constraint) module.createAst(constraintAst, globalConstraintContext);
			globalConstraintContext.getConstraints().addConstraint(constraint); 
			constraint.setConstraintContext(globalConstraintContext);
		}
		
		for (AST critiqueAst : AstUtil.getChildren(cst, EvlParser.CRITIQUE)) {
			Constraint critique = (Constraint) module.createAst(critiqueAst, globalConstraintContext);
			globalConstraintContext.getConstraints().addConstraint(critique); 
			critique.setConstraintContext(globalConstraintContext);
		}
		
		if (!globalConstraintContext.getConstraints().values().isEmpty()) declaredConstraintContexts.add(globalConstraintContext);
		
		for (AST constraintContextAst : AstUtil.getChildren(cst, EvlParser.CONTEXT)) {
			ConstraintContext constraintContext = (ConstraintContext) module.createAst(constraintContextAst, this);
			declaredConstraintContexts.add(constraintContext);
		}
		
		// Cache all the constraints
		for (ConstraintContext constraintContext : getConstraintContexts()) {
			for (Constraint constraint : constraintContext.getConstraints()) {
				constraints.addConstraint(constraint);
			}
		}
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.epsilon.evl.IEvlModule#getDeclaredConstraintContexts()
	 */
	public ArrayList<ConstraintContext> getDeclaredConstraintContexts() {
		return declaredConstraintContexts;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.epsilon.evl.IEvlModule#getConstraintContexts()
	 */
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
	
	/* (non-Javadoc)
	 * @see org.eclipse.epsilon.eol.IEolExecutableModule#execute()
	 */
	public Object executeImpl() throws EolRuntimeException {
		
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
	
	/* (non-Javadoc)
	 * @see org.eclipse.epsilon.eol.IEolLibraryModule#getContext()
	 */
	@Override
	public IEvlContext getContext(){
		return context;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.epsilon.evl.IEvlModule#getConstraints()
	 */
	public Constraints getConstraints(){ 
		return constraints;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.epsilon.evl.IEvlModule#setUnsatisfiedConstraintFixer(org.eclipse.epsilon.evl.IEvlFixer)
	 */
	public void setUnsatisfiedConstraintFixer(IEvlFixer fixer) {
		this.fixer = fixer;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.epsilon.evl.IEvlModule#getUnsatisfiedConstraintFixer()
	 */
	public IEvlFixer getUnsatisfiedConstraintFixer() {
		return fixer;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.epsilon.erl.ErlModule#getPostBlockTokenType()
	 */
	@Override
	protected int getPostBlockTokenType() {
		return EvlParser.POST;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.epsilon.erl.ErlModule#getPreBlockTokenType()
	 */
	@Override
	protected int getPreBlockTokenType() {
		return EvlParser.PRE;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.epsilon.eol.IEolLibraryModule#setContext(org.eclipse.epsilon.eol.execute.context.IEolContext)
	 */
	@Override
	public void setContext(IEolContext context) {
		if (context instanceof IEvlContext) {
			this.context = (IEvlContext) context;
		}
	}
	
	/**
	 * Checks if is optimize constraints.
	 *
	 * @return true, if is optimize constraints
	 */
	public boolean isOptimizeConstraints() {
		return optimizeConstraints;
	}

	/**
	 * Sets the optimize constraints.
	 *
	 * @param optimizeConstraints the new optimize constraints
	 */
	public void setOptimizeConstraints(boolean optimizeConstraints) {
		this.optimizeConstraints = optimizeConstraints;
	}
	
}
