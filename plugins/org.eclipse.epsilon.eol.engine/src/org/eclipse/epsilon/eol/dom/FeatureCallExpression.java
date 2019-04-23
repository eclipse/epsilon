/*********************************************************************
* Copyright (c) 2008 The University of York.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.eol.dom;

import java.util.ArrayList;
import java.util.Arrays;
import org.eclipse.epsilon.common.module.IModule;
import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.exceptions.EolIllegalOperationException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.operations.AbstractOperation;
import org.eclipse.epsilon.eol.execute.operations.DynamicOperation;
import org.eclipse.epsilon.eol.execute.operations.declarative.IAbstractOperationContributor;
import org.eclipse.epsilon.eol.execute.operations.declarative.IAbstractOperationContributorProvider;
import org.eclipse.epsilon.eol.models.IModel;

public abstract class FeatureCallExpression extends Expression {
		
	protected boolean arrow;
	protected Expression targetExpression;
	
	public boolean isArrow() {
		return arrow;
	}
	
	@Override
	public void build(AST cst, IModule module) {
		super.build(cst, module);
		this.arrow = cst.getText().equals("->");
	}
	
	static Object wrap(Object o) {
		if (o instanceof Object[]) {
			return new ArrayList<>(Arrays.asList((Object[]) o));
		}
		else return o;
	}
	
	protected AbstractOperation getAbstractOperation(Object target, String name, IModel owningModel, IEolContext context) throws EolIllegalOperationException {
		AbstractOperation operation = null;
		// Objects implementing the IAbstractOperationContributor interface
		// can override the default higher-order operation implementations
		if (target instanceof IAbstractOperationContributor) {
			operation = ((IAbstractOperationContributor) target).getAbstractOperation(name);
			if (operation != null) return operation;
		}
		
		// Since we don't control the interface of all model elements, models
		// can also provide IAbstractOperationContributors for their model elements
		if (owningModel != null && owningModel instanceof IAbstractOperationContributorProvider) {
			IAbstractOperationContributor contributor = ((IAbstractOperationContributorProvider) owningModel).getAbstractOperationContributor(target);
			if (contributor != null) {
				operation = contributor.getAbstractOperation(name);
				if (operation != null) return operation;					
			}
		}
		
		operation = getOperationFromFactory(name, context);
		
		if (operation == null) {
			operation = new DynamicOperation();
		}
		
		return operation;
	}
	
	/**
	 * 
	 * @param name The requested operation name
	 * @param context The context from which the EolOperationFactory is derived.
	 * @return The operation
	 * @throws EolIllegalOperationException 
	 * @since 1.6
	 */
	protected AbstractOperation getOperationFromFactory(String name, IEolContext context) throws EolIllegalOperationException {
		return context.getOperationFactory().getOperationFor(name);
	}
	
	public Expression getTargetExpression() {
		return targetExpression;
	}
	
	public void setTargetExpression(Expression targetExpression) {
		this.targetExpression = targetExpression;
	}
}
