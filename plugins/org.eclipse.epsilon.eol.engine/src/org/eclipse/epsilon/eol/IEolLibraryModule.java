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

import java.util.List;
import java.util.Set;

import org.eclipse.epsilon.commons.module.IModule;
import org.eclipse.epsilon.commons.parse.problem.ParseProblem;
import org.eclipse.epsilon.eol.execute.context.IEolContext;

public interface IEolLibraryModule extends IModule{

	public EolOperations getDeclaredOperations();
	
	public EolOperations getOperations();
	
	public List<EolModelDefinition> getDeclaredModelDefinitions();
	
	public Set<EolModelDefinition> getModelDefinitions();
	
	public List<EolModelGroupDefinition> getDeclaredModelGroupDefinitions();
	
	public Set<EolModelGroupDefinition> getModelGroupDefinitions();
	
	public List getImports();
	
	public IEolContext getContext();
	
	public List<ParseProblem> getParseProblems();
	
	public EolOperationFactory getOperationFactory();
	
	public void setOperationFactory(EolOperationFactory operationFactory);
}
