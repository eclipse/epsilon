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
package org.eclipse.epsilon.evl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.epsilon.commons.module.AbstractModuleElement;
import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.eol.exceptions.EolIllegalReturnException;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.exceptions.flowcontrol.EolReturnException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelElementTypeNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelNotFoundException;
import org.eclipse.epsilon.eol.execute.context.FrameType;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.types.EolBoolean;
import org.eclipse.epsilon.eol.types.EolModelElementType;
import org.eclipse.epsilon.evl.execute.context.IEvlContext;
import org.eclipse.epsilon.evl.parse.EvlParser;


public class EvlConstraintContext extends AbstractModuleElement {
	
	protected AST guardAst = null;
	protected EvlConstraints constraints = new EvlConstraints();
	protected AST typeAst;
	protected EolModelElementType type = null;
	protected boolean ofTypeOnly;
	protected String name;
	
	public EvlConstraintContext() {
		super();
	}

	public List getChildren() {
		return new ArrayList(constraints.values());
	}
	
	public void build(AST ast) {
		
		this.ast = ast;
		AST constraintAst = null;
		
		/*
		if (AstUtil.getChild(ast, EvlParserTokenTypes.TYPEOF) != null) {
			this.ofTypeOnly = true;
			this.name = ast.getFirstChild().getText();
			this.typeAst = ast.getFirstChild().getNextSibling().getNextSibling();
		}
		else if (AstUtil.getChild(ast, EvlParserTokenTypes.KINDOF) != null) {
			this.ofTypeOnly = false;
			this.name = ast.getFirstChild().getText();
			this.typeAst = ast.getFirstChild().getNextSibling().getNextSibling();	}
		else {*/
			this.typeAst = ast.getFirstChild();
			this.ofTypeOnly = false;
			this.name = typeAst.getText();
		/*}*/
		
		if (typeAst.getNextSibling() != null && typeAst.getNextSibling().getType() == EvlParser.GUARD) {
			guardAst = typeAst.getNextSibling();
			constraintAst = guardAst.getNextSibling();
		}
		else {
			constraintAst = typeAst.getNextSibling();
		}
		
		while (constraintAst != null) {
			EvlConstraint constraint = new EvlConstraint();
			constraint.setConstraintContext(this);
			constraint.build(constraintAst);
			constraints.addConstraint(constraint);
			constraintAst = constraintAst.getNextSibling();
		}
		
	}
	
	public boolean appliesTo(Object object, IEvlContext context) throws EolRuntimeException {
		
		if ((ofTypeOnly && getAllOfSourceType(context).contains(object))||
				(!ofTypeOnly && getAllOfSourceKind(context).contains(object))) {
		
			if (guardAst != null) {
				context.getFrameStack().enter(FrameType.UNPROTECTED,guardAst);
				context.getFrameStack().put(Variable.createReadOnlyVariable("self", object));
				Object result = null;
				try {
					context.getExecutorFactory().executeBlockOrExpressionAst(guardAst.getFirstChild(),context);
				}
				catch (EolReturnException rex) {
					result = rex.getReturned();
				}
				context.getFrameStack().leave(guardAst);
				if (result instanceof EolBoolean){
					return ((EolBoolean) result).getValue();
				}
				else {
					throw new EolIllegalReturnException("Boolean", result, guardAst, context);
				}
			}
			else {
				return true;
			}
		}
		return false;
	}
	
	public void checkAll(IEvlContext context) throws EolRuntimeException {
		
		Collection allOfKind = getAllOfSourceKind(context);
		Iterator it = allOfKind.iterator();
		
		while (it.hasNext()){
			Object object = it.next();
			if (appliesTo(object,context)){
				
				Iterator cit = constraints.values().iterator();
				while (cit.hasNext()){
					EvlConstraint constraint = (EvlConstraint) cit.next();
					if (!constraint.isLazy(context) && constraint.appliesTo(object,context)){
						constraint.check(object,context);
					}
				}
				
			}
		}
		
	}
	
	public EvlConstraints getConstraints() {
		return constraints;
	}
	
	public Collection getAllOfSourceType(IEvlContext context) throws EolModelElementTypeNotFoundException, EolModelNotFoundException {
		if (type == null) {
			type = EolModelElementType.forName(typeAst.getText(), context);
		}
		return type.getAllOfType();
	}

	public Collection getAllOfSourceKind(IEvlContext context) throws EolModelElementTypeNotFoundException, EolModelNotFoundException {
		if (type == null) {
			type = EolModelElementType.forName(typeAst.getText(), context);
		}
		return type.getAllOfKind();
	}	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString(){
		return this.name;
	}
}
