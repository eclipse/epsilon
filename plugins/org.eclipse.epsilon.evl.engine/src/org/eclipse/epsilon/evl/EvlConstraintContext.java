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

import org.eclipse.epsilon.common.module.AbstractModuleElement;
import org.eclipse.epsilon.common.module.ModuleElement;
import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.common.util.AstUtil;
import org.eclipse.epsilon.eol.exceptions.EolIllegalReturnException;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelElementTypeNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelNotFoundException;
import org.eclipse.epsilon.eol.execute.Return;
import org.eclipse.epsilon.eol.execute.context.FrameType;
import org.eclipse.epsilon.eol.execute.context.Variable;
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

	public List<ModuleElement> getChildren() {
		return new ArrayList<ModuleElement>(constraints.values());
	}
	
	public void build(AST ast) {
		
		this.ast = ast;
		
		this.typeAst = ast.getFirstChild();
		this.ofTypeOnly = false;
		this.name = typeAst.getText();
	
		guardAst = AstUtil.getChild(ast, EvlParser.GUARD);
			
		for (AST constraintAst : AstUtil.getChildren(ast, EvlParser.CONSTRAINT, EvlParser.CRITIQUE)) {
			EvlConstraint constraint = new EvlConstraint();
			constraint.setConstraintContext(this);
			constraint.build(constraintAst);
			constraints.addConstraint(constraint);
			constraintAst = constraintAst.getNextSibling();
		}
		
		/*
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
		*/
	}
	
	public boolean appliesTo(Object object, IEvlContext context) throws EolRuntimeException {
		
		if ((ofTypeOnly && getAllOfSourceType(context).contains(object))||
				(!ofTypeOnly && getAllOfSourceKind(context).contains(object))) {
		
			if (guardAst != null) {
				context.getFrameStack().enterLocal(FrameType.UNPROTECTED, guardAst);
				context.getFrameStack().put(Variable.createReadOnlyVariable("self", object));
				Object result = context.getExecutorFactory().executeBlockOrExpressionAst(guardAst.getFirstChild(),context);
				
				if (result instanceof Return) {
					result = Return.getValue(result);
				}
				context.getFrameStack().leaveLocal(guardAst);
				if (result instanceof Boolean){
					return ((Boolean) result);
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
		
		Collection<?> allOfKind = getAllOfSourceKind(context);
		Iterator<?> it = allOfKind.iterator();
		
		while (it.hasNext()){
			Object object = it.next();
			if (appliesTo(object,context)){
				
				Iterator<EvlConstraint> cit = constraints.values().iterator();
				while (cit.hasNext()){
					EvlConstraint constraint = cit.next();
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
	
	public Collection<?> getAllOfSourceType(IEvlContext context) throws EolModelElementTypeNotFoundException, EolModelNotFoundException {
		if (type == null) {
			type = EolModelElementType.forName(typeAst.getText(), context);
		}
		return type.getAllOfType();
	}

	public Collection<?> getAllOfSourceKind(IEvlContext context) throws EolModelElementTypeNotFoundException, EolModelNotFoundException {
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
