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
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.Lexer;
import org.antlr.runtime.TokenStream;
import org.eclipse.epsilon.common.module.IModule;
import org.eclipse.epsilon.common.module.ModuleElement;
import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.common.parse.EpsilonParser;
import org.eclipse.epsilon.common.parse.problem.ParseProblem;
import org.eclipse.epsilon.common.util.AstUtil;
import org.eclipse.epsilon.common.util.ListSet;
import org.eclipse.epsilon.eol.dom.AbortStatement;
import org.eclipse.epsilon.eol.dom.Annotation;
import org.eclipse.epsilon.eol.dom.AssignmentStatement;
import org.eclipse.epsilon.eol.dom.BooleanLiteralExpression;
import org.eclipse.epsilon.eol.dom.BreakStatement;
import org.eclipse.epsilon.eol.dom.CollectionLiteralExpression;
import org.eclipse.epsilon.eol.dom.ContinueStatement;
import org.eclipse.epsilon.eol.dom.DeleteStatement;
import org.eclipse.epsilon.eol.dom.EnumerationLiteralExpression;
import org.eclipse.epsilon.eol.dom.FeatureCallExpression;
import org.eclipse.epsilon.eol.dom.FeatureNameExpression;
import org.eclipse.epsilon.eol.dom.ForStatement;
import org.eclipse.epsilon.eol.dom.HigherOrderOperationCallExpression;
import org.eclipse.epsilon.eol.dom.IdentifierExpression;
import org.eclipse.epsilon.eol.dom.IfStatement;
import org.eclipse.epsilon.eol.dom.ImportStatement;
import org.eclipse.epsilon.eol.dom.IntegerLiteralExpression;
import org.eclipse.epsilon.eol.dom.OperationCallExpression;
import org.eclipse.epsilon.eol.dom.OperationDeclaration;
import org.eclipse.epsilon.eol.dom.OperatorExpression;
import org.eclipse.epsilon.eol.dom.ParameterDeclaration;
import org.eclipse.epsilon.eol.dom.PropertyCallExpression;
import org.eclipse.epsilon.eol.dom.RealLiteralExpression;
import org.eclipse.epsilon.eol.dom.ReturnStatement;
import org.eclipse.epsilon.eol.dom.StatementBlock;
import org.eclipse.epsilon.eol.dom.StringLiteralExpression;
import org.eclipse.epsilon.eol.dom.ThrowStatement;
import org.eclipse.epsilon.eol.dom.TransactionStatement;
import org.eclipse.epsilon.eol.dom.TypeExpression;
import org.eclipse.epsilon.eol.dom.VariableDeclaration;
import org.eclipse.epsilon.eol.dom.WhileStatement;
import org.eclipse.epsilon.eol.execute.BreakAllStatementExecutor;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.parse.AstExplorer;
import org.eclipse.epsilon.eol.parse.EolLexer;
import org.eclipse.epsilon.eol.parse.EolParser;


public abstract class EolLibraryModule extends AbstractModule implements IEolLibraryModule{
	
	protected EolOperations declaredOperations = new EolOperations();
	protected List<EolImport> imports = new ArrayList<EolImport>();
	protected EolOperations operations = null;
	protected List<EolModelDefinition> declaredModelDefinitions = new ArrayList<EolModelDefinition>();
	protected List<EolModelGroupDefinition> declaredModelGroupDefinitions = new ArrayList<EolModelGroupDefinition>();
	protected Set<EolModelDefinition> modelDefinitions = null;
	protected Set<EolModelGroupDefinition> modelGroupDefinitions = null;
	protected EolOperationFactory operationFactory = new EolOperationFactory();
	private IEolLibraryModule parent;

	public static void main(String[] args) throws Exception {
		
		EolModule module = new EolModule();
		
		//module.parse(new File("/Users/dimitrioskolovos/Downloads/" + 
		//		"eclipse-modeling-kepler/workspace/org.eclipse.epsilon.eugenia/" + 
		//		"transformations/FixGMFGen.eol"));
		module.parse("if (true) transaction { a = 5; abort;}");
		//module.execute();
		new AstExplorer(module.getAst(), EolParser.class).setVisible(true);
		
	}
	
	/*
	// TODO: Map literals
	@Override
	public AST adapt(AST cst, AST parentAst) {
		switch (cst.getType()) {
			case EolParser.FOR: return new ForStatement();
			case EolParser.IF: return new IfStatement();
			case EolParser.ARROW:
			case EolParser.POINT: {
				if (cst.getSecondChild().getChildren().size() == 0) {
					return new PropertyCallExpression();
				}
				else {
					if (cst.getSecondChild().getFirstChild().getType() == EolParser.PARAMLIST) {
						return new HigherOrderOperationCallExpression();
					}
					else {
						return new OperationCallExpression();
					}
				}
			}
			case EolParser.NAME: return new IdentifierExpression();
			case EolParser.FORMAL: return new ParameterDeclaration();
			case EolParser.BLOCK: return new StatementBlock();
			case EolParser.FEATURECALL: {
				if (cst.getParent().getSecondChild() == cst && parentAst instanceof FeatureCallExpression) {
					return new FeatureNameExpression();
				}
				else {
					return new IdentifierExpression();
				}
			}
			case EolParser.STRING: return new StringLiteralExpression();
			case EolParser.INT: return new IntegerLiteralExpression();
			case EolParser.BOOLEAN: return new BooleanLiteralExpression();
			case EolParser.FLOAT: return new RealLiteralExpression();
			case EolParser.ASSIGNMENT: return new AssignmentStatement();
			case EolParser.VAR: return new VariableDeclaration();
			case EolParser.NEW: return new VariableDeclaration();
			case EolParser.TYPE: return new TypeExpression();
			case EolParser.IMPORT: return new ImportStatement();
			case EolParser.OPERATOR: {
				if (cst.getText().equals("=") && (parentAst instanceof IfStatement || parentAst instanceof ForStatement || parentAst instanceof WhileStatement || parent instanceof StatementBlock )) {
					return new AssignmentStatement();
				}
				else {
					return new OperatorExpression();
				}
			}
			case EolParser.CONTINUE: return new ContinueStatement();
			case EolParser.DELETE: return new DeleteStatement();
			case EolParser.HELPERMETHOD: return new OperationDeclaration();
			case EolParser.RETURN: return new ReturnStatement();
			case EolParser.ENUMERATION_VALUE: return new EnumerationLiteralExpression();
			case EolParser.Annotation: return new Annotation();
			case EolParser.COLLECTION: return new CollectionLiteralExpression();
			case EolParser.BREAK: return new BreakStatement(false);
			case EolParser.BREAKALL: return new BreakStatement(true);
			case EolParser.THROW: return new ThrowStatement();
			case EolParser.ABORT: return new AbortStatement();
			case EolParser.TRANSACTION: return new TransactionStatement();
			
			default: return super.adapt(cst, parentAst);
		}
	}*/
	
	@Override
	public Lexer createLexer(InputStream inputStream) {
		ANTLRInputStream input = null;
		try {
			input = new ANTLRInputStream(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new EolLexer(input);
	}

	@Override
	public EpsilonParser createParser(TokenStream tokenStream) {
		return new EolParser(tokenStream);
	}
	
	@Override
	public String getMainRule() {
		return "eolModule";
	}
	
	public EolOperations getDeclaredOperations() {
		return declaredOperations;
	}
	
	public HashMap<String, Class<?>> getImportConfiguration() {
		final HashMap<String, Class<?>> importConfiguration = new HashMap<String, Class<?>>();
		importConfiguration.put("eol", EolModule.class);
		return importConfiguration;
	}
	
	@Override
	public void buildModel() throws Exception {
		checkImports();
		
		for (String extension : getImportConfiguration().keySet()) {
			imports.addAll(getImportsByExtension(extension, getImportConfiguration().get(extension)));
		}
		
		for (AST helperAst : AstUtil.getChildren(ast, EolParser.HELPERMETHOD)) {
			EolOperation helper = operationFactory.createOperation(helperAst); //new EolOperation(helperAst);
			declaredOperations.add(helper);
		}
	}
	
	protected void prepareContext(IEolContext context) {
		final EolSystem system = new EolSystem();
		system.setContext(context);

		context.setModule(this);
		
		for (EolImport import_ : getImports()) {
			import_.setContext(context);
		}
		
		context.getFrameStack().putGlobal(Variable.createReadOnlyVariable("null", null));
		context.getFrameStack().putGlobal(Variable.createReadOnlyVariable("System",system));
	}
	
	@Override
	public void reset() {
		imports.clear();
		declaredOperations.clear();
		operations = null;
	}

	@Override
	public AST getAst() {
		return ast;
	}

	@Override
	public List<ModuleElement> getChildren() {
		final List<ModuleElement> children = new ArrayList<ModuleElement>();
		children.addAll(imports);
		children.addAll(declaredOperations);
		return children;
	}

	public File getSourceFile() {
		return sourceFile;
	}

	public List<EolImport> getImports() {
		return imports;
	}
	
	@Override
	public String toString() {
		if (this.sourceFile != null) {
			return this.sourceFile.getAbsolutePath();
		}
		else return super.toString();
	}

	public Set<EolModelDefinition> getModelDefinitions() {
		if (modelDefinitions == null){
			modelDefinitions = new ListSet<EolModelDefinition>();
			for (EolImport import_ : imports) {
				if (import_.isLoaded() && import_.getModule() instanceof IEolLibraryModule){
					modelDefinitions.addAll(((IEolLibraryModule)import_.getModule()).getModelDefinitions());
				}
			}
			modelDefinitions.addAll(this.getDeclaredModelDefinitions());
		}
		return modelDefinitions;
	}
	
	public EolOperations getOperations() {
		if (operations == null){
			operations = new EolOperations();
			operations.addAll(this.getDeclaredOperations());
			for (EolImport import_ : imports) {
				if (import_.isLoaded() && import_.getModule() instanceof IEolLibraryModule){
					operations.addAll(((IEolLibraryModule)import_.getModule()).getOperations());
				}
			}
		}
		return operations;
	}
	
	protected Collection<EolImport> getImportsByExtension(String extension, Class<?> moduleImplClass) {
		final List<EolImport> imports = new ArrayList<EolImport>();
		
		for (AST importAst : AstUtil.getChildren(ast, EolParser.IMPORT)) {
			IModule module = null;
			try {
				module = (IModule) moduleImplClass.newInstance();
				if (module instanceof IEolLibraryModule) {
					((IEolLibraryModule)module).setParent(this);
				}
			} catch (Exception e) {
				e.printStackTrace();
				continue;
			}
			EolImport import_ = new EolImport(importAst, this, module);
			if (!import_.getPath().endsWith("." + extension)) continue;
			
			if (sourceUri == null && sourceFile == null) {
				import_.load(null);
			
			} else if (sourceUri != null) {
				import_.load(sourceUri);
			
			} else {
				import_.load(sourceFile.toURI());
			}
			
			if (!import_.isLoaded()){
				ParseProblem problem = new ParseProblem();
				problem.setLine(importAst.getLine());
				String reason;
				if (!import_.isFound()) {
					reason = "File " + importAst.getFirstChild().getText() + " not found";
				}
				else {
					reason = "File " + importAst.getFirstChild().getText() + " contains errors: " + import_.getModule().getParseProblems();
				}
				problem.setReason(reason);
				getParseProblems().add(problem);
			}
			imports.add(import_);
		}
		return imports;
	}
	
	protected void checkImports() {
		for (AST importAst : AstUtil.getChildren(ast, EolParser.IMPORT)){
			String importedFile = importAst.getFirstChild().getText();
			boolean validExtension = false;
			for (String extension : getImportConfiguration().keySet()) {
				if (importedFile.endsWith("." + extension)) {
					validExtension = true;
				}
			}
			if (!validExtension) {
				ParseProblem problem = new ParseProblem();
				problem.setLine(importAst.getLine());
				problem.setReason("Importing " + importAst.getFirstChild().getText() + " is not supported in this language");
				problem.setSeverity(ParseProblem.WARNING);
				getParseProblems().add(problem);
			}
		}		
	}

	public List<EolModelDefinition> getDeclaredModelDefinitions() {
		return declaredModelDefinitions;
	}

	public List<EolModelGroupDefinition> getDeclaredModelGroupDefinitions() {
		return declaredModelGroupDefinitions;
	}

	public Set<EolModelGroupDefinition> getModelGroupDefinitions() {
		if (modelGroupDefinitions == null){
			modelGroupDefinitions = new ListSet<EolModelGroupDefinition>();

			for (EolImport import_ : imports) {
				if (import_.isLoaded() && import_.getModule() instanceof IEolLibraryModule){
					modelGroupDefinitions.addAll(((IEolLibraryModule)import_.getModule()).getModelGroupDefinitions());
				}
			}
			modelGroupDefinitions.addAll(this.getDeclaredModelGroupDefinitions());
		}
		return modelGroupDefinitions;
	}

	public EolOperationFactory getOperationFactory() {
		return operationFactory;
	}

	public void setOperationFactory(EolOperationFactory operationFactory) {
		this.operationFactory = operationFactory;
	}

	@Override
	public IEolLibraryModule getParent() {
		return parent;
	}

	@Override
	public void setParent(IEolLibraryModule parent) {
		this.parent = parent;
	}

}
