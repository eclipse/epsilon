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

import java.util.Map;
import org.eclipse.epsilon.common.module.ModuleElement;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.concurrent.EolContextParallel;
import org.eclipse.epsilon.eol.execute.context.concurrent.IEolContextParallel;
import org.eclipse.epsilon.evl.EvlModule;
import org.eclipse.epsilon.evl.dom.Constraint;
import org.eclipse.epsilon.evl.execute.context.concurrent.EvlContextParallel;
import org.eclipse.epsilon.evl.execute.context.concurrent.IEvlContextParallel;

/**
 * 
 * @author Sina Madani
 * @since 1.6
 */
public abstract class EvlModuleParallel extends EvlModule {
	
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
	protected abstract void checkConstraints() throws EolRuntimeException;
	
	@Override
	protected void postExecution() throws EolRuntimeException {
		if (context instanceof EolContextParallel) {
			((EolContextParallel) context).clearShadows();
		}
		super.postExecution();
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
	 * WARNING: This method should only be called by the DT plugin for initialisation purposes,
	 * as the context will be reset!
	 */
	@Override
	public void configure(Map<String, ?> properties) throws IllegalArgumentException {
		super.configure(properties);
		setContext(IEolContextParallel.configureContext(
			properties,
			EvlContextParallel::new,
			getContext()
		));
	}
}
