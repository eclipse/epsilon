/*******************************************************************************
 * Copyright (c) 2008-2016 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 *     Antonio Garcia-Dominguez - aggregate into select(...)
 ******************************************************************************/
package org.eclipse.epsilon.evl.dom;

import java.util.*;
import org.eclipse.epsilon.common.module.IModule;
import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.common.util.AstUtil;
import org.eclipse.epsilon.eol.dom.AnnotatableModuleElement;
import org.eclipse.epsilon.eol.dom.ExecutableBlock;
import org.eclipse.epsilon.eol.dom.TypeExpression;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelElementTypeNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelNotFoundException;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.function.CheckedEolPredicate;
import org.eclipse.epsilon.eol.types.EolModelElementType;
import org.eclipse.epsilon.evl.execute.context.IEvlContext;
import org.eclipse.epsilon.evl.parse.EvlParser;

public class ConstraintContext extends AnnotatableModuleElement {
	
	protected final Constraints constraints = new Constraints();
	protected TypeExpression typeExpression;
	protected ExecutableBlock<Boolean> guardBlock;
	protected EolModelElementType type;
	protected Boolean isLazy = null;
	
	@SuppressWarnings("unchecked")
	public void build(AST cst, IModule module) {
		super.build(cst, module);
		
		typeExpression = (TypeExpression) module.createAst(cst.getFirstChild(), this);
		guardBlock = (ExecutableBlock<Boolean>) module.createAst(AstUtil.getChild(cst, EvlParser.GUARD), this);
		
		List<AST> constraintASTs = AstUtil.getChildren(cst, EvlParser.CONSTRAINT, EvlParser.CRITIQUE);
		constraints.ensureCapacity(constraintASTs.size());
		
		for (AST constraintAst : constraintASTs) {
			Constraint constraint = (Constraint) module.createAst(constraintAst, this);
			constraint.setConstraintContext(this);
			constraints.add(constraint);
		}
	}

	public boolean shouldBeChecked(Object modelElement, IEvlContext context) throws EolRuntimeException {
		return !isLazy(context) && appliesTo(modelElement, context, false);
	}
	
	public void execute(IEvlContext context) throws EolRuntimeException {
		if (!isLazy(context))
			checkAll(context);
	}
	
	public boolean appliesTo(Object object, IEvlContext context) throws EolRuntimeException {
		return appliesTo(object, context, false);
	}

	public boolean appliesTo(Object object, IEvlContext context, final boolean checkType) throws EolRuntimeException {
		if (checkType && !context.getModelRepository().getOwningModel(object).isOfType(object, getTypeName()))
			return false;

		if (guardBlock != null)
			return guardBlock.execute(context, Variable.createReadOnlyVariable("self", object));
		
		return true;
	}
	
	public void checkAll(IEvlContext context) throws EolRuntimeException {
		checkAll(context, constraints);
	}
	
	public void checkAll(IEvlContext context, Collection<Constraint> constraintsToCheck) throws EolRuntimeException {
		if (constraintsToCheck != constraints) {
			for (Constraint constraint : constraintsToCheck) {
				if (constraint.getConstraintContext() != this)
					throw new IllegalArgumentException("ConstraintContext '"+getTypeName()+"' is not applicable for Constraint '"+constraint.getName()+"'.");
			}
		}

		for (Object object : getAllOfSourceKind(context)) {
			if (appliesTo(object, context, false)) {
				for (Constraint constraint : constraintsToCheck) {
					constraint.execute(object, context);
				}
			}
		}
	}
	
	/**
	 * An entire context is lazy if all constraints are lazy, or if it is
	 * itself marked as lazy.
	 */
	public boolean isLazy(IEvlContext context) throws EolRuntimeException {
		if (isLazy == null) {
			isLazy = getBooleanAnnotationValue("lazy", context) ||
				constraints.stream()
					.allMatch((CheckedEolPredicate<Constraint>) c -> c.isLazy(context));
		}
		return isLazy;
	}
	
	public String getTypeName() {
		return typeExpression != null ? typeExpression.getName() : null;
	}
	
	public Constraints getConstraints() {
		return constraints;
	}
	
	public TypeExpression getTypeExpression() {
		return typeExpression;
	}
	
	public void setTypeExpression(TypeExpression typeExpression) {
		this.typeExpression = typeExpression;
	}
	
	public Collection<?> getAllOfSourceType(IEvlContext context) throws EolModelElementTypeNotFoundException, EolModelNotFoundException {
		return getType(context).getAllOfType();
	}

	public Collection<?> getAllOfSourceKind(IEvlContext context) throws EolModelElementTypeNotFoundException, EolModelNotFoundException {
		return getType(context).getAllOfKind();
	}

	protected EolModelElementType getType(IEvlContext context) throws EolModelNotFoundException, EolModelElementTypeNotFoundException {
		if (type == null) {
			type = new EolModelElementType(getTypeName(), context);
		}
		return type;
	}	

	@Override
	public String toString() {
		return getTypeName();
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), getTypeName(), constraints.size());
	}

	@Override
	public boolean equals(Object other) {
		if (!super.equals(other))
			return false;
		
		ConstraintContext cc = (ConstraintContext) other;
		return
			Objects.equals(this.getTypeName(), cc.getTypeName()) &&
			this.constraints.size() == cc.constraints.size();
	}
}
