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
import org.eclipse.epsilon.commons.module.IModule;
import org.eclipse.epsilon.commons.module.ModuleElement;
import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.commons.parse.EpsilonParser;
import org.eclipse.epsilon.commons.parse.problem.ParseProblem;
import org.eclipse.epsilon.commons.util.AstUtil;
import org.eclipse.epsilon.commons.util.ListSet;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.parse.EolLexer;
import org.eclipse.epsilon.eol.parse.EolParser;


public class EolLibraryModule extends AbstractModule implements IEolLibraryModule{
	
	protected EolOperations declaredOperations = new EolOperations();
	protected List<EolImport> imports = new ArrayList<EolImport>();
	protected EolOperations operations = null;
	protected List<EolModelDefinition> declaredModelDefinitions = new ArrayList<EolModelDefinition>();
	protected List<EolModelGroupDefinition> declaredModelGroupDefinitions = new ArrayList<EolModelGroupDefinition>();
	protected Set<EolModelDefinition> modelDefinitions = null;
	protected Set<EolModelGroupDefinition> modelGroupDefinitions = null;
	protected EolOperationFactory operationFactory = new EolOperationFactory();

	private IEolLibraryModule parent;

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

	public IEolContext getContext() {
		return null;
	}
	
	public HashMap<String, Class<?>> getImportConfiguration() {
		final HashMap<String, Class<?>> importConfiguration = new HashMap<String, Class<?>>();
		importConfiguration.put("eol", EolLibraryModule.class);
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
