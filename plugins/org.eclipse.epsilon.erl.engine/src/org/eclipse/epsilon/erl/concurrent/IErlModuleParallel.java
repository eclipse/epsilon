/*********************************************************************
 * Copyright (c) 2019 The University of York.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.erl.concurrent;

import org.eclipse.epsilon.eol.dom.AnnotatableModuleElement;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.erl.IErlModule;
import org.eclipse.epsilon.erl.execute.context.concurrent.IErlContextParallel;

/**
 * 
 * @author Sina Madani
 * @since 1.6
 */
public interface IErlModuleParallel extends IErlModule {

	public static final String PARALLEL_ANNOTATION_NAME = "parallel";
	
	default boolean shouldBeParallel(AnnotatableModuleElement ast, Object self, IModel model, int numElements) throws EolRuntimeException {
		IErlContextParallel context = getContext();
		if (!context.isParallelisationLegal()) return false;
		return ast.getBooleanAnnotationValue(PARALLEL_ANNOTATION_NAME, context, () -> new Variable[] {
			Variable.createReadOnlyVariable("self", self),
			Variable.createReadOnlyVariable("NUM_ELEMENTS", numElements),
			Variable.createReadOnlyVariable("MODEL", model),
			Variable.createReadOnlyVariable("THREADS", context.getParallelism())
		});
	}
	
	@Override
	default IErlContextParallel getContext() {
		return (IErlContextParallel) IErlModule.super.getContext();
	}
}
