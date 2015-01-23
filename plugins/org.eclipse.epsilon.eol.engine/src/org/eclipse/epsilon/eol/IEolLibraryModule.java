/*******************************************************************************
 * Copyright (c) 2008-2012 The University of York, Antonio García-Domínguez.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 *     Antonio García-Domínguez - add {get, set}Parent
 ******************************************************************************/
package org.eclipse.epsilon.eol;

import java.util.List;
import java.util.Set;

import org.eclipse.epsilon.common.module.IModule;
import org.eclipse.epsilon.common.parse.problem.ParseProblem;
import org.eclipse.epsilon.eol.compile.context.EolCompilationContext;
import org.eclipse.epsilon.eol.dom.Import;
import org.eclipse.epsilon.eol.dom.ModelDeclaration;
import org.eclipse.epsilon.eol.dom.OperationList;
import org.eclipse.epsilon.eol.execute.context.IEolContext;

public interface IEolLibraryModule extends IModule{

	public OperationList getDeclaredOperations();
	
	public OperationList getOperations();
	
	public List<ModelDeclaration> getDeclaredModelDeclarations();
	
	public Set<ModelDeclaration> getModelDelcarations();
	
	public IEolLibraryModule getParentModule();
	
	public void setParentModule(IEolLibraryModule parent);
	
	public List<Import> getImports();
	
	public IEolContext getContext();
	
	public void setContext(IEolContext context);
	
	public EolCompilationContext getCompilationContext();
	
	public List<ParseProblem> getParseProblems();
	
}
