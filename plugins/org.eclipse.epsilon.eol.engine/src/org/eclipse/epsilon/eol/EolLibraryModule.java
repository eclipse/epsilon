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
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.Lexer;
import org.antlr.runtime.TokenStream;
import org.eclipse.epsilon.commons.module.IModule;
import org.eclipse.epsilon.commons.module.ModuleElement;
import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.commons.parse.EpsilonParser;
import org.eclipse.epsilon.commons.parse.problem.ParseProblem;
import org.eclipse.epsilon.commons.util.AstUtil;
import org.eclipse.epsilon.commons.util.ListSet;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.parse.EolLexer;
import org.eclipse.epsilon.eol.parse.EolParser;


public class EolLibraryModule extends AbstractModule implements IEolLibraryModule{
	
	protected EolOperations declaredOperations = new EolOperations();
	protected List<EolImport> imports = new ArrayList();
	protected EolOperations operations = null;
	protected List<EolModelDefinition> declaredModelDefinitions = new ArrayList<EolModelDefinition>();
	protected List<EolModelGroupDefinition> declaredModelGroupDefinitions = new ArrayList<EolModelGroupDefinition>();
	protected Set<EolModelDefinition> modelDefinitions = null;
	protected Set<EolModelGroupDefinition> modelGroupDefinitions = null;
	protected EolOperationFactory operationFactory = new EolOperationFactory();
	
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
	
	/*
	@Override
	public TokenStream createLexer(Reader reader) {
		return new EolLexer(reader);
	}

	@Override
	public LLkParser createParser(TokenStream tokenStream) {
		return new EolParser(tokenStream);
	}
	 */
	
	@Override
	public String getMainRule() {
		return "eolModule";
	}

	/*
	protected EolParser getParser() {
		return (EolParser) parser;
	}
	*/
	
	public EolOperations getDeclaredOperations() {
		return declaredOperations;
	}

	public IEolContext getContext() {
		return null;
	}
	
	public HashMap<String, Class> getImportConfiguration() {
		HashMap<String, Class> importConfiguration = new HashMap();
		importConfiguration.put("eol", EolLibraryModule.class);
		return importConfiguration;
	}
	
	@Override
	public void buildModel() throws Exception {
		/*
		Iterator it = AstUtil.getChildren(ast, EolParserTokenTypes.IMPORT).iterator();
		
		while (it.hasNext()){
			AST importAst = (AST) it.next();
			EolImport import_ = new EolImport(importAst, new EolLibraryModuleImpl());
			if (!import_.getPath().endsWith(".eol")) continue;
			import_.load(this.sourceFile);
			if (!import_.isLoaded()){
				ParseProblem problem = new ParseProblem();
				problem.setLine(importAst.getLine());
				problem.setReason("File " + importAst.getFirstChild().getText() + " not found");
				getParseProblems().add(problem);
			}
			imports.add(import_);
		}
		*/
		
		checkImports();
		
		for (String extension : getImportConfiguration().keySet()) {
			imports.addAll(getImportsByExtension(extension, getImportConfiguration().get(extension)));
		}
		
		/*
		Iterator it = AstUtil.getChildren(ast, EolParserTokenTypes.MODEL).iterator();
		
		while (it.hasNext()) {
			EolAst modelDefinitionAst = (EolAst) it.next();
			AST namesAst = modelDefinitionAst.getFirstChild();
			for (AST nameAst : AstUtil.getChildren(namesAst)) {
				EolModelDefinition modelDefinition = new EolModelDefinition();
				modelDefinition.setAst(modelDefinitionAst);
				modelDefinition.setModel(nameAst.getText());
				declaredModelDefinitions.add(modelDefinition);
			}
		}
		
		it = AstUtil.getChildren(ast, EolParserTokenTypes.GROUP).iterator();
		
		while (it.hasNext()) {
			EolAst modelGroupDefinitionAst = (EolAst) it.next();
			AST namesAst = modelGroupDefinitionAst.getFirstChild();
			AST groupNameAst = namesAst.getNextSibling();
			EolModelGroupDefinition modelGroupDefinition = new EolModelGroupDefinition();
			modelGroupDefinition.setGroup(groupNameAst.getText());
			modelGroupDefinition.setAst(modelGroupDefinitionAst);
			for (AST nameAst : AstUtil.getChildren(namesAst)) {
				modelGroupDefinition.getModels().add(nameAst.getText());
			}
			declaredModelGroupDefinitions.add(modelGroupDefinition);
		}
		
		//imports.addAll(getImportsByExtension("eol", EolLibraryModuleImpl.class));
		*/
		
		Iterator it = AstUtil.getChildren(ast, EolParser.HELPERMETHOD).iterator();
		while (it.hasNext()){
			AST helperAst = (AST) it.next();
			EolOperation helper = operationFactory.createOperation(helperAst); //new EolOperation(helperAst);
			//helper.setSourceFile(this.getSourceFile());
			declaredOperations.add(helper);
		}
	}
	
	@Override
	public void reset() {
		imports.clear();
		declaredOperations.clear();
	}

	@Override
	public AST getAst() {
		return ast;
	}

	@Override
	public List<ModuleElement> getChildren() {
		ArrayList children = new ArrayList();
		children.addAll(imports);
		//children.addAll(declaredModelDefinitions);
		//children.addAll(declaredModelGroupDefinitions);
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
			ListIterator li = imports.listIterator();
			while (li.hasNext()){
				EolImport import_ = (EolImport) li.next();
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
			ListIterator li = imports.listIterator();
			while (li.hasNext()){
				EolImport import_ = (EolImport) li.next();
				if (import_.isLoaded() && import_.getModule() instanceof IEolLibraryModule){
					operations.addAll(((IEolLibraryModule)import_.getModule()).getOperations());
				}
			}
		}
		return operations;
	}
	
	protected Collection<EolImport> getImportsByExtension(String extension, Class moduleImplClass) {
		Iterator it = AstUtil.getChildren(ast, EolParser.IMPORT).iterator();
		
		ArrayList<EolImport> imports = new ArrayList();
		while (it.hasNext()){
			AST importAst = (AST) it.next();
			IModule module = null;
			try {
				module = (IModule) moduleImplClass.newInstance();
			} catch (Exception e) {
				e.printStackTrace();
				continue;
			}
			EolImport import_ = new EolImport(importAst, module);
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
					reason = "File " + importAst.getFirstChild().getText() + " contains errors";
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
			ListIterator li = imports.listIterator();
			while (li.hasNext()){
				EolImport import_ = (EolImport) li.next();
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
	
}
