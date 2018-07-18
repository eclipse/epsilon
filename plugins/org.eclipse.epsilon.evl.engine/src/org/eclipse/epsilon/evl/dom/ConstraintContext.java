/*******************************************************************************
 * Copyright (c) 2008-2016 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 *     Antonio Garcia-Dominguez - aggregate into select(...)
 ******************************************************************************/
package org.eclipse.epsilon.evl.dom;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.epsilon.common.module.IModule;
import org.eclipse.epsilon.common.module.ModuleElement;
import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.common.util.AstUtil;
import org.eclipse.epsilon.eol.dom.AnnotatableModuleElement;
import org.eclipse.epsilon.eol.dom.ExecutableBlock;
import org.eclipse.epsilon.eol.dom.TypeExpression;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelElementTypeNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelNotFoundException;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.eol.types.EolModelElementType;
import org.eclipse.epsilon.evl.EvlModule;
import org.eclipse.epsilon.evl.execute.UnsatisfiedConstraint;
import org.eclipse.epsilon.evl.execute.context.IEvlContext;
import org.eclipse.epsilon.evl.parse.EvlParser;


public class ConstraintContext extends AnnotatableModuleElement {
	
	protected TypeExpression typeExpression = null;
	protected ExecutableBlock<Boolean> guardBlock = null;
	protected Constraints constraints = new Constraints();
	protected EolModelElementType type = null;
	
	public ConstraintContext() {
		super();
	}
	
	public String getTypeName() {
		return typeExpression != null ? typeExpression.getName() : null;
	}
	
	public List<ModuleElement> getModuleElements() {
		return new ArrayList<ModuleElement>(constraints.values());
	}
	
	@SuppressWarnings("unchecked")
	public void build(AST cst, IModule module) {
		super.build(cst, module);
		
		typeExpression = (TypeExpression) module.createAst(cst.getFirstChild(), this);
		guardBlock = (ExecutableBlock<Boolean>) module.createAst(AstUtil.getChild(cst, EvlParser.GUARD), this);
		
		for (AST constraintAst : AstUtil.getChildren(cst, EvlParser.CONSTRAINT, EvlParser.CRITIQUE)) {
			Constraint constraint = (Constraint) module.createAst(constraintAst, this);
			constraint.setConstraintContext(this);
			constraints.addConstraint(constraint);
		}
		
	}

	/**
	 * Compatibility version of {@link #appliesTo(Object, IEvlContext)} for old clients.
	 */
	public boolean appliesTo(Object object, IEvlContext context) throws EolRuntimeException {
		return appliesTo(object, context, true);
	}

	public boolean appliesTo(Object object, IEvlContext context, final boolean checkType) throws EolRuntimeException {
		final IModel owningModel = context.getModelRepository().getOwningModel(object);
		if (checkType && !owningModel.isOfType(object, getTypeName())) {
			return false;
		}

		if (guardBlock != null) {
			return guardBlock.execute(context, Variable.createReadOnlyVariable("self", object));
		} else {
			return true;
		}
	}
	
	public void checkAll(IEvlContext context) throws EolRuntimeException {
		if (isLazy(context)) {
			return;
		}
		// Check if constraints shold be optimized
		final Collection<Constraint> remainingConstraints;
		if (!((EvlModule)getModule()).isOptimizeConstraints()) {
			remainingConstraints = constraints.values();
		}
		else {
			final ConstraintSelectTransfomer transformer = new ConstraintSelectTransfomer();
			remainingConstraints = new ArrayList<Constraint>(constraints.values());
			for (Iterator<Constraint> itConstraint = remainingConstraints.iterator(); itConstraint.hasNext();) {
				Constraint constraint = itConstraint.next();
				if (transformer.canBeTransformed(constraint) && !constraint.isLazy(context)) {
					ExecutableBlock<?> transformedConstraint = transformer.transformIntoSelect(constraint);
					List<?> results = (List<?>) transformedConstraint.execute(context);

					// Postprocess the invalid objects to support custom messages and fix blocks
					for (Object self : results) {
						UnsatisfiedConstraint unsatisfiedConstraint = constraint.preprocessCheck(self, context);
						// We know result = false because we found it with the negated condition
						constraint.postprocessCheck(self, context, unsatisfiedConstraint, false);
					}

					// Mark this constraint as executed in an optimised way: we will only have
					// explicit trace items for invalid objects, so we'll have to tweak isChecked
					// and isSatisfied accordingly.
					context.getConstraintTrace().addCheckedOptimised(constraint);

					// Don't try to reexecute this rule later on
					itConstraint.remove();
				}
			}
		}
		if (!remainingConstraints.isEmpty()) {
			for (Object object : getAllOfSourceKind(context)) {
				if (appliesTo(object, context, false)) {
					for (Constraint constraint : remainingConstraints) {
						if (!constraint.isLazy(context) && constraint.appliesTo(object, context, false)) {
							constraint.check(object, context, false);
						}
					}
				}
			}
		}

	}

	/**
	 * An entire context is lazy if all constraints are lazy, or if it is
	 * itself marked as lazy.
	 */
	public boolean isLazy(IEvlContext context) throws EolRuntimeException {
		if (getBooleanAnnotationValue("lazy", context)) {
			return true;
		}

		for (Constraint c : constraints) {
			if (!c.isLazy(context)) {
				return false;
			}
		}
		return true;
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
	public String toString(){
		return getTypeName();
	}
}
