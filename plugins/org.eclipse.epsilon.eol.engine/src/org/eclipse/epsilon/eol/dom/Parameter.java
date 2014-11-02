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
package org.eclipse.epsilon.eol.dom;

import org.eclipse.epsilon.common.module.AbstractModuleElement;
import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.types.EolAnyType;
import org.eclipse.epsilon.eol.types.EolType;


public class Parameter extends AbstractModuleElement {
	
	protected String name;
	protected String typeName = "";
	protected AST typeAst;
	protected EolType type;
	
	public Parameter(){}
	
	@Override
	public void build(){
		this.name = this.getFirstChild().getText();
		this.typeAst = this.getFirstChild().getNextSibling();
		if (this.typeAst!=null){
			typeName = typeAst.getText();
		}
	}

	public AST getTypeAst(){
		return this.getFirstChild().getNextSibling();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setType(String type) {
		this.typeName = type;
	}
	
	@Override
	public String toString(){
		return name + ":" + typeName;
	}
	
	public EolType getType(IEolContext context) throws EolRuntimeException{
		if (type == null){
			if (typeAst != null){
				type = (EolType) context.getExecutorFactory().executeAST(typeAst,context);
			}
			else {
				type = EolAnyType.Instance;
			}
		}
		return type;
	}

	/**
	 * Clear any cached information. This is useful for running EUnit, which has to rerun
	 * the same EOL script with different sets of models without reparsing it.
	 */
	public void clearCache() {
		type = null;
	}

}
