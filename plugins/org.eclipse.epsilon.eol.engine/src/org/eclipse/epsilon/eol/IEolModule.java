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
import java.util.Map;
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
	
	public Object execute() throws EolRuntimeException;
	
	public StatementBlock getMain();
	
	public List<Statement> getPostOperationStatements();
	
	public boolean parse(String code, File file) throws Exception;
	
	public OperationList getDeclaredOperations();
	
	public OperationList getOperations();
	
	public List<ModelDeclaration> getDeclaredModelDeclarations();
	
	public Set<ModelDeclaration> getModelDelcarations();
	
	public IEolModule getParentModule();
	
	public void setParentModule(IEolModule parent);
	
	public List<Import> getImports();
	
	public IEolContext getContext();
	
	public void setContext(IEolContext context);
	
	public EolCompilationContext getCompilationContext();
	
	public List<ParseProblem> getParseProblems();
	
	/**
	 * Configure the IEolModule with the given properties
	 * @param properties a map of property:value 
	 */
	public void configure(Map<String, Object> properties);
	
	/**
	 * Get the set of property names that should be retrieved from the ILaunchConfiguration in order
	 * to configure this module.
	 * @return
	 */
	public Set<String> getConfigurationProperties();
}
