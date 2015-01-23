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
import org.eclipse.epsilon.eol.compile.context.EolCompilationContext;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.types.EolAnyType;
import org.eclipse.epsilon.eol.types.EolType;

public class Parameter extends AbstractModuleElement implements ICompilableModuleElement {
	
	protected NameExpression nameExpression;
	protected TypeExpression typeExpression;
	protected EolType type;
	
	public Parameter(){}
	
	public Parameter(NameExpression nameExpression, TypeExpression typeExpression) {
		this.nameExpression = nameExpression;
		this.typeExpression = typeExpression;
	}
	
	@Override
	public void build(){
		super.build();
		this.nameExpression = (NameExpression) getFirstChild();
		this.typeExpression = (TypeExpression) getSecondChild();
	}

	public TypeExpression getTypeExpression(){
		return typeExpression;
	}
	
	public void setTypeExpression(TypeExpression typeExpression) {
		this.typeExpression = typeExpression;
	}
	
	public NameExpression getNameExpression() {
		return nameExpression;
	}
	
	public void setNameExpression(NameExpression nameExpression) {
		this.nameExpression = nameExpression;
	}
	
	public String getName() {
		return nameExpression.getName();
	}

	public String getTypeName() {
		if (typeExpression == null) {
			return "Any";
		}
		else {
			return typeExpression.getName();
		}
	}
	
	@Override
	public String toString(){
		return getName() + ":" + getTypeName();
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

	@Override
	public void compile(EolCompilationContext context) {
		if (typeExpression != null) typeExpression.compile(context);
		EolType type = null;
		if (typeExpression != null) type = typeExpression.getCompilationType();
		else type = EolAnyType.Instance;
		context.getFrameStack().put(new Variable(getName(), type));
	}

}
