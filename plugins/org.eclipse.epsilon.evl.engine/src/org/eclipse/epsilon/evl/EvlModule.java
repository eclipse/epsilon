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
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.Lexer;
import org.antlr.runtime.TokenStream;
import org.eclipse.epsilon.commons.module.ModuleElement;
import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.commons.parse.EpsilonParser;
import org.eclipse.epsilon.commons.util.AstUtil;
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
	protected ArrayList<EvlConstraintContext> constraintContexts = new ArrayList<EvlConstraintContext>();
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
		// TODO Auto-generated method stub
		return new EvlParser(tokenStream);
	}

	@Override
	public String getMainRule() {
		return "evlModule";
	}

	@Override
	public void buildModel() throws Exception {
		
		super.buildModel();
		
		Iterator it = AstUtil.getChildren(ast, EvlParser.CONTEXT).iterator();
		while (it.hasNext()){
			AST matchRuleAst = (AST) it.next();
			EvlConstraintContext constraintContext = new EvlConstraintContext();
			constraintContext.build(matchRuleAst);
			constraintContexts.add(constraintContext);
		}
		
		// Cache all the constraints
		it = constraintContexts.iterator();
		while (it.hasNext()){
			EvlConstraintContext constraintContext = (EvlConstraintContext) it.next();
			Iterator li = constraintContext.getConstraints().iterator();
			while (li.hasNext()){
				constraints.addConstraint((EvlConstraint)li.next());
			}
		}
	}
	
	public ArrayList getConstraintContexts() {
		return constraintContexts;
	}

	public Object execute() throws EolRuntimeException {
		
		// Initialize the context
		context.setModule(this);
		context.setOperationFactory(new EvlOperationFactory());
		context.getFrameStack().put(Variable.createReadOnlyVariable("constraintTrace", context.getConstraintTrace()));
		context.getFrameStack().put(Variable.createReadOnlyVariable("thisModule", this));
		
		execute(getPre(), context);
		
		ListIterator li = getConstraintContexts().listIterator();
		while (li.hasNext()){
			EvlConstraintContext constraintContext = ((EvlConstraintContext) li.next());
			constraintContext.checkAll(context);
		}
		
		//final EolRuntimeExceptionReference postException = new EolRuntimeExceptionReference(null);
		
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
		List children = new ArrayList();
		children.addAll(getImports());
		children.addAll(getDeclaredPre());
		children.addAll(constraintContexts);
		children.addAll(getDeclaredOperations());
		children.addAll(getDeclaredPost());
		return children;
	}
	
	@Override
	public void reset(){
		super.reset();
		constraintContexts = new ArrayList();
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
