/*********************************************************************
 * Copyright (c) 2018 The University of York.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.eol.concurrent;

import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.concurrent.EolContextParallel;
import org.eclipse.epsilon.eol.execute.context.concurrent.IEolContextParallel;

public class EolModuleParallel extends EolModule {

	public EolModuleParallel() {
		this.context = new EolContextParallel();
	}
	
	public EolModuleParallel(int numThreads) {
		this.context = new EolContextParallel(numThreads);
	}
	
	@Override
	protected void prepareContext() {
		super.prepareContext();
		getContext().goParallel();
	}
	
	@Override
	public Object execute() throws EolRuntimeException {
		Object result = super.execute();
		getContext().endParallel();
		return result;
	}
	
	@Override
	public void setContext(IEolContext context) {
		if (context instanceof IEolContextParallel) {
			super.setContext(context);
		}
	}
	
	@Override
	public IEolContextParallel getContext() {
		return (IEolContextParallel) context;
	}
}
