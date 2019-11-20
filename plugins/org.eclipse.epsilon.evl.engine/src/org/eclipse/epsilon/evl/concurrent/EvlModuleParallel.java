/*********************************************************************
 * Copyright (c) 2018 The University of York.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.evl.concurrent;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Map;
import org.eclipse.epsilon.common.module.ModuleElement;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.concurrent.IEolContextParallel;
import org.eclipse.epsilon.eol.function.CheckedEolRunnable;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.evl.EvlModule;
import org.eclipse.epsilon.evl.dom.Constraint;
import org.eclipse.epsilon.evl.dom.ConstraintContext;
import org.eclipse.epsilon.evl.dom.GlobalConstraintContext;
import org.eclipse.epsilon.evl.execute.context.concurrent.EvlContextParallel;
import org.eclipse.epsilon.evl.execute.context.concurrent.IEvlContextParallel;

/**
 * 
 * @author Sina Madani
 * @since 1.6
 */
public class EvlModuleParallel extends EvlModule {
	
	static {
		CONFIG_PROPERTIES.add(IEolContextParallel.NUM_THREADS_CONFIG);
	}
	
	public EvlModuleParallel() {
		this(null);
	}
	
	public EvlModuleParallel(IEvlContextParallel context) {
		super(context != null ? context : new EvlContextParallel());
	}
	
	@Override
	protected void checkConstraints() throws EolRuntimeException {
		IEvlContextParallel context = getContext();
		
		for (ConstraintContext constraintContext : getConstraintContexts()) {
			final Collection<Constraint> constraintsToCheck = preProcessConstraintContext(constraintContext);
			final Collection<?> allOfKind = constraintContext.getAllOfSourceKind(context);
			final int numElements = allOfKind.size();
			final IModel model = constraintContext instanceof GlobalConstraintContext ?
				null : constraintContext.getType(context).getModel();
			
			final Collection<CheckedEolRunnable> jobs = new LinkedList<>();
			
			if (constraintContext.hasAnnotation("parallel")) {
				for (Object object : allOfKind) {
					if (context.shouldBeParallel(constraintContext, object, model, numElements)) {
						jobs.add(() -> constraintContext.execute(constraintsToCheck, object, context));
					}
					else {
						constraintContext.execute(constraintsToCheck, object, context);
					}
				}
				
				context.executeParallel(constraintContext, jobs);
			}	
			else {
				for (Constraint constraint : constraintsToCheck) {
					for (Object object : allOfKind) {
						if (constraintContext.appliesTo(object, context)) {
							if (context.shouldBeParallel(constraint, object, model, numElements)) {
								jobs.add(() -> constraint.execute(context, object));
							}
							else {
								constraint.execute(context, object);
							}
						}
					}
					
					context.executeParallel(constraint, jobs);
				}
			}
		}
	}
	
	/**
	 * Does not look up the element in the context.
	 */
	@Override
	public Constraint getConstraint(String constraintName, String contextName, Object modelElement, ModuleElement ast) throws EolRuntimeException {
		return super.getConstraint(constraintName, contextName, null, ast);
	}
	
	@Override
	public IEvlContextParallel getContext() {
		return (IEvlContextParallel) super.getContext();
	}
	
	/**
	 * WARNING: This method should only be called by the DT plugin for initialization purposes,
	 * as the context will be reset!
	 */
	@Override
	public void configure(Map<String, ?> properties) throws IllegalArgumentException {
		super.configure(properties);
		IEvlContextParallel context = getContext();
		setContext(IEolContextParallel.configureContext(
			properties,
			EvlContextParallel::new,
			context
		));
	}
}
