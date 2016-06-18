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
package org.eclipse.epsilon.eol;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.epsilon.common.module.IModule;
import org.eclipse.epsilon.common.module.ModuleElement;
import org.eclipse.epsilon.common.module.ModuleMarker;
import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.common.util.AstUtil;
import org.eclipse.epsilon.eol.compile.context.EolCompilationContext;
import org.eclipse.epsilon.eol.dom.Expression;
import org.eclipse.epsilon.eol.dom.ExpressionStatement;
import org.eclipse.epsilon.eol.dom.ModelDeclaration;
import org.eclipse.epsilon.eol.dom.Operation;
import org.eclipse.epsilon.eol.dom.Statement;
import org.eclipse.epsilon.eol.dom.StatementBlock;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.Return;
import org.eclipse.epsilon.eol.execute.context.EolContext;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.parse.EolParser;

public class EolModule extends EolLibraryModule implements IEolModule {
	
	protected StatementBlock main;
	protected IEolContext context;
	protected List<Statement> postOperationStatements = new ArrayList<Statement>();
	
	public static void main(String[] args) throws Exception {
		EolModule module = new EolModule();
		//module.parse(new File("/Users/dkolovos/git/org.eclipse.epsilon/"
		//		+ "tests/org.eclipse.epsilon.eol.engine.test.acceptance/src/org/eclipse/epsilon/"
		//		+ "eol/engine/test/acceptance/CollectionsTests.eol"));		
		
		/*
		EolContext context = new EolContext();
		context.setModule(module);
		module.setContext(context);
		
		for (Operation op : module.getOperations()) {
			System.out.println(op.getName());
			
			op.execute(null, Collections.EMPTY_LIST, context);
		}*/
		
		module.parse("new Native('javax.swing.JFrame');");
		
		ModuleElement me = module.getChildren().get(0).getChildren().get(0).getChildren().get(0);
		int column = me.getRegion().getStart().getColumn();
		
		System.out.println(me + " " + column);
		
		module.execute();
		
	}
	
	public EolModule(){
		reset();
	}
	
	@Override
	public void build(AST cst, IModule module) {
		super.build(cst, module);
		main = (StatementBlock) createAst(AstUtil.getChild(cst, EolParser.BLOCK), this);
		for (AST child : cst.getChildren()) {
			if (child.getType() != EolParser.BLOCK 
					&& child.getType() != EolParser.ANNOTATIONBLOCK && 
					child.getType() != EolParser.HELPERMETHOD && 
					child.getType() != EolParser.MODELDECLARATION &&
					child.getType() != EolParser.IMPORT) {
				ExpressionStatement expressionStatement = new ExpressionStatement((Expression) module.createAst(child, this));
				expressionStatement.setParent(this);
				this.getChildren().add(expressionStatement);
				postOperationStatements.add(expressionStatement);
			}
		}
	}
	
	@Override
	public ModuleElement adapt(AST cst, ModuleElement parentAst) {
		if (cst == null) return null;
		if (cst.getParent() != null && cst.getParent().getType() == EolParser.EOLMODULE && cst.getType() == EolParser.BLOCK){
			return new StatementBlock();
		}
		return super.adapt(cst, parentAst);
	}
	
	public Object execute() throws EolRuntimeException {
		prepareContext(getContext());
		return Return.getValue(getContext().getExecutorFactory().executeAST(main, getContext()));
	}
	
	public List<ModuleMarker> compile() {
		EolCompilationContext context = getCompilationContext();
		for (ModelDeclaration modelDeclaration : getDeclaredModelDeclarations()) {
			modelDeclaration.compile(context);
		}
		for (Operation operation : getDeclaredOperations()) {
			operation.compile(context);
		}
		main.compile(context);
		return context.getMarkers();
	}
	
	public List<Statement> getPostOperationStatements() {
		return postOperationStatements;
	}
	
	public StatementBlock getMain() {
		return main;
	}

	public void setMain(StatementBlock main) {
		this.main = main;
	}
	
	@Override
	public IEolContext getContext() {
		return context;
	}

	@Override
	public void setContext(IEolContext context) {
		this.context = context;
	}
	
	public IEolContext createContext() {
		return new EolContext();
	}
	
	//TODO: Clear context as well
	@Override
	public void reset() {
		super.reset();
		main = null;
		context = createContext();
	}

	/**
	 * Clear all cached results and type information, and all extended
	 * properties. Useful for rerunning the same EolModule with different sets
	 * of models, without having to parse it again.
	 */
	public void clearCache() {
		for (Operation op : getOperations()) {
			op.clearCache();
		}
		getContext().getExtendedProperties().clear();
	}

}
