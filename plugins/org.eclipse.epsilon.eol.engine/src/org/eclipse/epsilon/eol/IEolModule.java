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

import org.eclipse.epsilon.eol.dom.Statement;
import org.eclipse.epsilon.eol.dom.StatementBlock;

public interface IEolModule extends IEolExecutableModule{
	
	public StatementBlock getMain();
	
	public List<Statement> getPostOperationStatements();
	
	public boolean parse(String code, File file) throws Exception;
	
}
