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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.epsilon.common.module.ModuleElement;
import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.common.util.AstUtil;
import org.eclipse.epsilon.eol.dom.AnnotatableModuleElement;
import org.eclipse.epsilon.eol.dom.ExecutableBlock;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelElementTypeNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelNotFoundException;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.types.EolModelElementType;
import org.eclipse.epsilon.evl.execute.UnsatisfiedConstraint;
import org.eclipse.epsilon.evl.execute.context.IEvlContext;
import org.eclipse.epsilon.evl.parse.EvlParser;


public class ConstraintContext extends AnnotatableModuleElement {
	
	protected ExecutableBlock<Boolean> guardBlock = null;
	protected Constraints constraints = new Constraints();
	protected AST typeAst;
	protected EolModelElementType type = null;
	protected boolean ofTypeOnly;
	protected String name;
	
	public ConstraintContext() {
		super();
	}
	
	public String getTypeName() {
		return typeAst.getText();
	}
	
	public List<ModuleElement> getModuleElements() {
		return new ArrayList<ModuleElement>(constraints.values());
	}
	
	@SuppressWarnings("unchecked")
	public void build() {
		super.build();
		this.typeAst = getFirstChild();
		this.ofTypeOnly = false;
		this.name = typeAst.getText();
	
		guardBlock = (ExecutableBlock<Boolean>) AstUtil.getChild(this, EvlParser.GUARD);
		
		for (AST constraintAst : AstUtil.getChildren(this, EvlParser.CONSTRAINT, EvlParser.CRITIQUE)) {
			Constraint constraint = (Constraint) constraintAst;
			constraint.setConstraintContext(this);
			constraints.addConstraint(constraint);
		}
		
	}
	
	public boolean appliesTo(Object object, IEvlContext context) throws EolRuntimeException {
		
		if ((ofTypeOnly && getAllOfSourceType(context).contains(object))||
				(!ofTypeOnly && getAllOfSourceKind(context).contains(object))) {
			
			if (guardBlock != null) {
				return guardBlock.execute(context, Variable.createReadOnlyVariable("self", object));
			}
			else {
				return true;
			}
		}
		
		return false;
	}
	
	public void checkAll(IEvlContext context) throws EolRuntimeException {
		/*
		 * TODO: alternate mode that doesn't go through all of source kind if it
		 * doesn't have to and/or enables this new behaviour?
		 */
		final ConstraintSelectTransfomer transformer = new ConstraintSelectTransfomer();
		final List<Constraint> remainingConstraints = new ArrayList<Constraint>(constraints.values());
		for (Iterator<Constraint> itConstraint = remainingConstraints.iterator(); itConstraint.hasNext();) {
			Constraint constraint = itConstraint.next();
			if (transformer.canBeTransformed(constraint)) {
				ExecutableBlock<?> transformedConstraint = transformer.transformIntoSelect(constraint);
				List<?> results = (List<?>) transformedConstraint.execute(context);
				// Postprocess the invalid objects to support custom messages and fix blocks

				/*
				 * TODO how do we deal with valid objects in this mode? Do we
				 * still need trace items for them?
				 */
				for (Object self : results) {
					UnsatisfiedConstraint unsatisfiedConstraint = new UnsatisfiedConstraint();
					constraint.processFailingCheck(self, context, unsatisfiedConstraint);
				}

				// Don't try to reexecute this rule later on
				itConstraint.remove();
			}
		}

		if (!remainingConstraints.isEmpty()) {
			for (Object object : getAllOfSourceKind(context)) {
				if (appliesTo(object, context)) {
					for (Constraint constraint : remainingConstraints) {
						if (!constraint.isLazy(context) && constraint.appliesTo(object, context)) {
							constraint.check(object, context);
						}
					}
				}
			}
		}

	}
	
	public Constraints getConstraints() {
		return constraints;
	}
	
	public Collection<?> getAllOfSourceType(IEvlContext context) throws EolModelElementTypeNotFoundException, EolModelNotFoundException {
		if (type == null) {
			type = new EolModelElementType(typeAst.getText(), context);
		}
		return type.getAllOfType();
	}

	public Collection<?> getAllOfSourceKind(IEvlContext context) throws EolModelElementTypeNotFoundException, EolModelNotFoundException {
		if (type == null) {
			type = new EolModelElementType(typeAst.getText(), context);
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
