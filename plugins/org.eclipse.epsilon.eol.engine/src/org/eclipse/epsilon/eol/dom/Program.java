/*******************************************************************************
 * Copyright (c) 2012 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.eol.dom;

import java.util.ArrayList;

public class Program extends DomElement {
	
	protected ArrayList<Statement> statements = new ArrayList<Statement>();
	public ArrayList<Import> imports = new ArrayList<Import>();
	
	public ArrayList<Import> getImports() {
		return imports;
	}

	public ArrayList<Statement> getStatements() {
		return statements;
	}
	
}
