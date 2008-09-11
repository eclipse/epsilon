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
package org.eclipse.epsilon.commons.module;

import java.io.File;
import java.net.URI;
import java.util.List;

import org.eclipse.epsilon.commons.parse.problem.ParseProblem;

public interface IModule extends ModuleElement {
	
	public boolean parse(File file) throws Exception;
	
	public boolean parse(URI uri) throws Exception;
	
	public boolean parse(String code) throws Exception;
	
	public void buildModel() throws Exception;	
	
	public List<ParseProblem> getParseProblems();
	
	public void reset();
	
}
