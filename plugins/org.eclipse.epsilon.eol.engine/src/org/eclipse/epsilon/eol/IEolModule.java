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
import java.util.List;
import java.util.Set;

import org.eclipse.epsilon.common.module.IModule;
import org.eclipse.epsilon.common.parse.problem.ParseProblem;
import org.eclipse.epsilon.eol.compile.context.EolCompilationContext;
import org.eclipse.epsilon.eol.dom.Import;
import org.eclipse.epsilon.eol.dom.ModelDeclaration;
import org.eclipse.epsilon.eol.dom.OperationList;
import org.eclipse.epsilon.eol.dom.Statement;
import org.eclipse.epsilon.eol.dom.StatementBlock;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;

public interface IEolModule extends IModule {
	
	Object execute() throws EolRuntimeException;
	
	StatementBlock getMain();
	
	List<Statement> getPostOperationStatements();
	
	boolean parse(String code, File file) throws Exception;
	
	OperationList getDeclaredOperations();
	
	OperationList getOperations();
	
	List<ModelDeclaration> getDeclaredModelDeclarations();
	
	Set<ModelDeclaration> getModelDelcarations();
	
	IEolModule getParentModule();
	
	void setParentModule(IEolModule parent);
	
	List<Import> getImports();
	
	IEolContext getContext();
	
	void setContext(IEolContext context);
	
	EolCompilationContext getCompilationContext();
	
	List<ParseProblem> getParseProblems();
	
}
