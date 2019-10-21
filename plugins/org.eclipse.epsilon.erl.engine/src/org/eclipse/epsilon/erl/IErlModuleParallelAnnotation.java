/*********************************************************************
 * Copyright (c) 2018 The University of York.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.erl;

import java.util.function.Supplier;
import org.eclipse.epsilon.eol.dom.AnnotatableModuleElement;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.erl.execute.context.concurrent.IErlContextParallel;

/**
 * 
 * @author Sina Madani
 * @since 1.6
 */
public interface IErlModuleParallelAnnotation extends IErlModule {
	
	default boolean shouldBeParallel(AnnotatableModuleElement ast, Supplier<? extends Variable[]> variables) throws EolRuntimeException {
		IErlContextParallel context = getContext();
		if (!context.isParallelisationLegal()) return false;
		return ast.getBooleanAnnotationValue("parallel", context, variables);
	}
	
	default boolean shouldBeParallel(AnnotatableModuleElement ast, Object self, IModel model, int numElements) throws EolRuntimeException {
		return shouldBeParallel(ast, () -> new Variable[] {
			Variable.createReadOnlyVariable("self", self),
			Variable.createReadOnlyVariable("NUM_ELEMENTS", numElements),
			Variable.createReadOnlyVariable("MODEL", model),
			Variable.createReadOnlyVariable("THREADS", getContext().getParallelism())
		});
	}
	
	@Override
	IErlContextParallel getContext();
	
}
