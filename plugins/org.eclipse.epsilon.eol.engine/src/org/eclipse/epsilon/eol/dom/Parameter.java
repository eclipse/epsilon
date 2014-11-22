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
import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.types.EolAnyType;
import org.eclipse.epsilon.eol.types.EolType;


public class Parameter extends AbstractModuleElement {
	
	protected String name;
	protected TypeExpression typeExpression;
	protected EolType type;
	
	public Parameter(){}
	
	public static void main(String[] args) throws Exception {
		EolModule module = new EolModule();
		module.parse("var x : Foo!Bar;");
		System.out.println(module.getAst().toExtendedStringTree());
	}
	
	@Override
	public void build(){
		super.build();
		this.name = getFirstChild().getText();
		this.typeExpression = (TypeExpression) getSecondChild();
	}

	public TypeExpression getTypeExpression(){
		return typeExpression;
	}
	
	public void setTypeExpression(TypeExpression typeExpression) {
		this.typeExpression = typeExpression;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTypeName() {
		if (typeExpression == null) {
			return "Any";
		}
		else {
			return getTypeExpression().getName();
		}
	}
	
	@Override
	public String toString(){
		return name + ":" + getTypeName();
	}
	
	public EolType getType(IEolContext context) throws EolRuntimeException{
		if (type == null){
			if (typeExpression != null){
				type = (EolType) context.getExecutorFactory().executeAST(typeExpression,context);
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
