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
import org.eclipse.epsilon.eol.dom.AnnotationBlock;
import org.eclipse.epsilon.eol.dom.AssignmentStatement;
import org.eclipse.epsilon.eol.dom.BooleanLiteral;
import org.eclipse.epsilon.eol.dom.BreakStatement;
import org.eclipse.epsilon.eol.dom.Case;
import org.eclipse.epsilon.eol.dom.CollectionLiteralExpression;
import org.eclipse.epsilon.eol.dom.ContinueStatement;
import org.eclipse.epsilon.eol.dom.DeleteStatement;
import org.eclipse.epsilon.eol.dom.EnumerationLiteralExpression;
import org.eclipse.epsilon.eol.dom.ExecutableAnnotation;
import org.eclipse.epsilon.eol.dom.ExpressionInBrackets;
import org.eclipse.epsilon.eol.dom.ForStatement;
import org.eclipse.epsilon.eol.dom.FirstOrderOperationCallExpression;
import org.eclipse.epsilon.eol.dom.IfStatement;
import org.eclipse.epsilon.eol.dom.Import;
import org.eclipse.epsilon.eol.dom.IntegerLiteral;
import org.eclipse.epsilon.eol.dom.ItemSelectorExpression;
import org.eclipse.epsilon.eol.dom.MapLiteralExpression;
import org.eclipse.epsilon.eol.dom.ModelDeclaration;
import org.eclipse.epsilon.eol.dom.ModelDeclarationParameter;
import org.eclipse.epsilon.eol.dom.NameExpression;
import org.eclipse.epsilon.eol.dom.NewInstanceExpression;
import org.eclipse.epsilon.eol.dom.Operation;
import org.eclipse.epsilon.eol.dom.OperationCallExpression;
import org.eclipse.epsilon.eol.dom.OperationList;
import org.eclipse.epsilon.eol.dom.OperatorExpression;
import org.eclipse.epsilon.eol.dom.Parameter;
import org.eclipse.epsilon.eol.dom.ParameterValueList;
import org.eclipse.epsilon.eol.dom.PropertyCallExpression;
import org.eclipse.epsilon.eol.dom.RealLiteral;
import org.eclipse.epsilon.eol.dom.ReturnStatement;
import org.eclipse.epsilon.eol.dom.SimpleAnnotation;
import org.eclipse.epsilon.eol.dom.SpecialAssignmentStatement;
import org.eclipse.epsilon.eol.dom.StatementBlock;
import org.eclipse.epsilon.eol.dom.StringLiteral;
import org.eclipse.epsilon.eol.dom.SwitchStatement;
import org.eclipse.epsilon.eol.dom.ThrowStatement;
import org.eclipse.epsilon.eol.dom.TransactionStatement;
import org.eclipse.epsilon.eol.dom.TypeExpression;
import org.eclipse.epsilon.eol.dom.VariableDeclaration;
import org.eclipse.epsilon.eol.dom.WhileStatement;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.parse.EolLexer;
import org.eclipse.epsilon.eol.parse.EolParser;
import org.eclipse.epsilon.eol.tools.EolSystem;


public abstract class EolLibraryModule extends AbstractModule implements IEolLibraryModule{
	
	protected OperationList declaredOperations = new OperationList();
	protected List<Import> imports = new ArrayList<Import>();
	protected OperationList operations = null;
	protected List<ModelDeclaration> declaredModelDefinitions = new ArrayList<ModelDeclaration>();
	protected Set<ModelDeclaration> modelDefinitions = null;
	private IEolLibraryModule parent;
	
	@Override
	public AST adapt(AST cst, AST parentAst) {
		switch (cst.getType()) {
			case EolParser.FOR: return new ForStatement();
			case EolParser.WHILE: return new WhileStatement();
			case EolParser.DEFAULT:
			case EolParser.CASE: return new Case();
			case EolParser.SWITCH: return new SwitchStatement();
			case EolParser.IF: return new IfStatement();
			case EolParser.ITEMSELECTOR: return new ItemSelectorExpression();
			case EolParser.ARROW:
			case EolParser.POINT: {
				if (cst.getSecondChild().getChildren().size() == 0) {
					return new PropertyCallExpression();
				}
				else {
					if (cst.getSecondChild().getFirstChild().getType() == EolParser.PARAMLIST) {
						return new FirstOrderOperationCallExpression();
					}
					else {
						return new OperationCallExpression();
					}
				}
			}
			case EolParser.NAME: {
				if (cst.hasChildren() && cst.getFirstChild().getType() == EolParser.PARAMLIST) {
					return new FirstOrderOperationCallExpression();
				}
				else {
					return new NameExpression();
				}
			}
			case EolParser.FORMAL: return new Parameter();
			case EolParser.BLOCK: return new StatementBlock();
			case EolParser.FEATURECALL: {
				if (cst.hasChildren() && cst.getFirstChild().getType() == EolParser.PARAMETERS && 
						((cst.getParent().getType() != EolParser.ARROW && cst.getParent().getType() != EolParser.POINT) ||
						(cst.getParent().getType() == EolParser.ARROW || cst.getParent().getType() == EolParser.POINT) && cst.getParent().getFirstChild() == cst)) {
					return new OperationCallExpression(true);
				}
				else {
					return new NameExpression();
				}
			}
			case EolParser.STRING: return new StringLiteral();
			case EolParser.INT: return new IntegerLiteral();
			case EolParser.BOOLEAN: return new BooleanLiteral();
			case EolParser.FLOAT: return new RealLiteral();
			case EolParser.ASSIGNMENT: return new AssignmentStatement();
			case EolParser.SPECIAL_ASSIGNMENT: return new SpecialAssignmentStatement();
			case EolParser.EXPRESSIONINBRACKETS: return new ExpressionInBrackets();
			case EolParser.VAR: return new VariableDeclaration();
			case EolParser.NEW: {
				if (cst.getFirstChild().getType() == EolParser.TYPE) {
					return new NewInstanceExpression();
				}
				else {
					return new VariableDeclaration();
				}
			}
			case EolParser.TYPE: return new TypeExpression();
			case EolParser.IMPORT: return new Import();
			case EolParser.OPERATOR: {
				if (cst.getText().equals("=") && ((parentAst instanceof IfStatement || parentAst instanceof ForStatement || parentAst instanceof WhileStatement) && (cst.getParent().getFirstChild() != cst)) || parentAst instanceof StatementBlock || parentAst.getText().equals("BLOCK")) {
					return new AssignmentStatement();
				}
				else {
					return new OperatorExpression();
				}
			}
			case EolParser.CONTINUE: return new ContinueStatement();
			case EolParser.DELETE: return new DeleteStatement();
			case EolParser.HELPERMETHOD: return new Operation();
			case EolParser.RETURN: return new ReturnStatement();
			case EolParser.ENUMERATION_VALUE: return new EnumerationLiteralExpression();
			case EolParser.Annotation: return new SimpleAnnotation();
			case EolParser.EXECUTABLEANNOTATION: return new ExecutableAnnotation();
			case EolParser.ANNOTATIONBLOCK: return new AnnotationBlock();
			case EolParser.MAP: return new MapLiteralExpression();
			case EolParser.COLLECTION: return new CollectionLiteralExpression();
			case EolParser.BREAK: return new BreakStatement(false);
			case EolParser.BREAKALL: return new BreakStatement(true);
			case EolParser.THROW: return new ThrowStatement();
			case EolParser.ABORT: return new AbortStatement();
			case EolParser.TRANSACTION: return new TransactionStatement();
			case EolParser.MODELDECLARATION: return new ModelDeclaration();
			case EolParser.MODELDECLARATIONPARAMETER: return new ModelDeclarationParameter();
			
			default: return super.adapt(cst, parentAst);
		}
	}
		
	protected Lexer createLexer(ANTLRInputStream inputStream) {
		return new EolLexer(inputStream);
	}
	
	@Override
	public EpsilonParser createParser(TokenStream tokenStream) {
		return new EolParser(tokenStream);
	}
	
	@Override
	public String getMainRule() {
		return "eolModule";
	}
	
	public OperationList getDeclaredOperations() {
		return declaredOperations;
	}
	
	public HashMap<String, Class<?>> getImportConfiguration() {
		final HashMap<String, Class<?>> importConfiguration = new HashMap<String, Class<?>>();
		importConfiguration.put("eol", EolModule.class);
		return importConfiguration;
	}
	
	@Override
	public void buildModel() throws Exception {
		
		build(ast);
		checkImports();
		
		for (String extension : getImportConfiguration().keySet()) {
			imports.addAll(getImportsByExtension(extension, getImportConfiguration().get(extension)));
		}
		
		for (AST child : ast.getChildren()) {
			if (child instanceof Operation) {
				declaredOperations.add((Operation) child);
			}
		}
		
		/*
		for (AST helperAst : AstUtil.getChildren(ast, EolParser.HELPERMETHOD)) {
			EolOperation helper = operationFactory.createOperation(helperAst); //new EolOperation(helperAst);
			declaredOperations.add(helper);
		}*/
	}
	
	protected void build(AST ast) {
		ast.build();
		for (AST child : ast.getChildren()) {
			build(child);
		}
	}
	
	protected void prepareContext(IEolContext context) {
		final EolSystem system = new EolSystem();
		system.setContext(context);

		context.setModule(this);
		
		for (Import import_ : getImports()) {
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
	public List<ModuleElement> getModuleElements() {
		final List<ModuleElement> children = new ArrayList<ModuleElement>();
		children.addAll(imports);
		children.addAll(declaredOperations);
		return children;
	}

	public File getSourceFile() {
		return sourceFile;
	}

	public List<Import> getImports() {
		return imports;
	}
	
	@Override
	public String toString() {
		if (this.sourceFile != null) {
			return this.sourceFile.getAbsolutePath();
		}
		else return super.toString();
	}

	public Set<ModelDeclaration> getModelDefinitions() {
		if (modelDefinitions == null){
			modelDefinitions = new ListSet<ModelDeclaration>();
			for (Import import_ : imports) {
				if (import_.isLoaded() && import_.getModule() instanceof IEolLibraryModule){
					modelDefinitions.addAll(((IEolLibraryModule)import_.getModule()).getModelDefinitions());
				}
			}
			modelDefinitions.addAll(this.getDeclaredModelDefinitions());
		}
		return modelDefinitions;
	}
	
	public OperationList getOperations() {
		if (operations == null){
			operations = new OperationList();
			operations.addAll(this.getDeclaredOperations());
			for (Import import_ : imports) {
				if (import_.isLoaded() && import_.getModule() instanceof IEolLibraryModule){
					operations.addAll(((IEolLibraryModule)import_.getModule()).getOperations());
				}
			}
		}
		return operations;
	}
	
	protected Collection<Import> getImportsByExtension(String extension, Class<?> moduleImplClass) {
		
		final List<Import> imports = new ArrayList<Import>();
		
		for (AST importAst : AstUtil.getChildren(ast, EolParser.IMPORT)) {
			IModule module = null;
			try {
				module = (IModule) moduleImplClass.newInstance();
				if (module instanceof IEolLibraryModule) {
					((IEolLibraryModule)module).setParentModule(this);
				}
			} catch (Exception e) {
				e.printStackTrace();
				continue;
			}
			
			Import import_ = (Import) importAst;
			
			if (!import_.getPath().endsWith("." + extension)) continue;
			
			import_.setParentModule(this);
			import_.setImportedModule(module);
			
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

	public List<ModelDeclaration> getDeclaredModelDefinitions() {
		return declaredModelDefinitions;
	}

	@Override
	public IEolLibraryModule getParentModule() {
		return parent;
	}

	@Override
	public void setParentModule(IEolLibraryModule parent) {
		this.parent = parent;
	}

}
