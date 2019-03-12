/*******************************************************************************
 * Copyright (c) 2008-2019 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 *     Sina Madani - concurrency support
 ******************************************************************************/
package org.eclipse.epsilon.evl;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import org.eclipse.epsilon.common.module.ModuleElement;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.erl.IErlModule;
import org.eclipse.epsilon.evl.dom.Constraint;
import org.eclipse.epsilon.evl.dom.ConstraintContext;
import org.eclipse.epsilon.evl.dom.GlobalConstraintContext;
import org.eclipse.epsilon.evl.execute.UnsatisfiedConstraint;
import org.eclipse.epsilon.evl.execute.context.IEvlContext;
import org.eclipse.epsilon.evl.execute.exceptions.EvlConstraintNotFoundException;

public interface IEvlModule extends IErlModule {
	
	List<Constraint> getConstraints();
	
	List<ConstraintContext> getDeclaredConstraintContexts();
	
	List<ConstraintContext> getConstraintContexts();
	
	/**
	 * @since 1.6 returns Collection instead of List
	 */
	@Override
	Collection<UnsatisfiedConstraint> execute() throws EolRuntimeException;
	
	void setUnsatisfiedConstraintFixer(IEvlFixer fixer);
	
	IEvlFixer getUnsatisfiedConstraintFixer();
	
	@Override
	default IEvlContext getContext() {
		return (IEvlContext) ((IErlModule)this).getContext();
	}
	
	// UTILS
	
	/**
	 * 
	 * @param name
	 * @return
	 * @since 1.6
	 */
	default ConstraintContext getConstraintContext(String name) {
		return getConstraintContexts()
			.stream()
			.filter(cc -> cc.getTypeName().equals(name))
			.findAny()
			.orElse(null);
	}
	
	/**
	 * 
	 * @param name
	 * @param target
	 * @param context
	 * @param ast
	 * @return
	 * @throws EolRuntimeException
	 * @since 1.6
	 */
	default Constraint getConstraint(String name, Object target, IEvlContext context, ModuleElement ast) throws EolRuntimeException {
		Optional<Constraint> constraint = getConstraint(name, null, target, context, false);
		if (!constraint.isPresent()) {
			constraint = getConstraints().stream().filter(c -> c.getName().equals(name)).findFirst();
		}
		return constraint.orElseThrow(() -> new EvlConstraintNotFoundException(name, ast));
	}
	
	/**
	 * 
	 * @param name
	 * @param constraintContext
	 * @param target
	 * @param context
	 * @param appliesTo
	 * @return
	 * @throws EolRuntimeException#
	 * @since 1.6
	 */
	default Optional<Constraint> getConstraint(String name, ConstraintContext constraintContext, Object target, IEvlContext context, boolean appliesTo) throws EolRuntimeException {
		for (Constraint constraint : getConstraints()) {
			ConstraintContext cc = constraintContext == null ? constraint.getConstraintContext() : constraintContext;
			if (
				constraint.getName().equals(name) && 
				(
					(cc instanceof GlobalConstraintContext) ||
					cc.getAllOfSourceKind(context).contains(target)
				) &&
				(!appliesTo || constraint.appliesTo(target, context))
			) {
				return Optional.of(constraint);
			}
		}
		return Optional.empty();
	}
}
