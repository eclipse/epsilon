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

public class OperationDefinition extends DomElement {
	
	protected String name;
	protected String contextType;
	protected String returnType;
	protected ArrayList<VariableDeclarationExpression> parameters = new ArrayList<VariableDeclarationExpression>();
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getContextType() {
		return contextType;
	}
	
	public void setContextType(String contextType) {
		this.contextType = contextType;
	}
	
	public ArrayList<VariableDeclarationExpression> getParameters() {
		return parameters;
	}
	
	public void setReturnType(String returnType) {
		this.returnType = returnType;
	}
	
	public String getReturnType() {
		return returnType;
	}
	
}
