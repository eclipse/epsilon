/*********************************************************************
 * Copyright (c) 2018 The University of York.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.egl.execute.context.concurrent;

import org.eclipse.epsilon.egl.EglTemplateFactory;
import org.eclipse.epsilon.egl.exceptions.EglRuntimeException;
import org.eclipse.epsilon.egl.execute.context.EglContext;
import org.eclipse.epsilon.egl.execute.context.IEgxContext;
import org.eclipse.epsilon.eol.execute.concurrent.executors.EolExecutorService;
import org.eclipse.epsilon.erl.execute.context.concurrent.IErlContextParallel;

/**
 * 
 * @author Sina Madani
 * @since 1.6
 */
public interface IEgxContextParallel extends IEgxContext, IErlContextParallel {

	default EglTemplateFactory newTemplateFactory() throws EglRuntimeException {
		EglTemplateFactory tf = new EglTemplateFactory(this.getTemplateFactory());
		tf.setContext(new EglContext(tf));
		this.copyInto(tf.getContext());
		return tf;
	}
	
	@Override
	default EolExecutorService newExecutorService() {
		// TODO optimise
		return IErlContextParallel.super.newExecutorService();
	}
	
}
