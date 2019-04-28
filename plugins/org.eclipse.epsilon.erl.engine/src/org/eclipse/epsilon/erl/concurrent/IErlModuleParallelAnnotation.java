/*********************************************************************
 * Copyright (c) 2018 The University of York.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.erl.concurrent;

import org.eclipse.epsilon.eol.dom.AnnotatableModuleElement;
import org.eclipse.epsilon.eol.dom.Annotation;
import org.eclipse.epsilon.eol.dom.ExecutableAnnotation;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.FrameStack;
import org.eclipse.epsilon.eol.execute.context.FrameType;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.erl.IErlModule;
import org.eclipse.epsilon.erl.execute.context.concurrent.IErlContextParallel;

/**
 * Marker interface providing convenience method for parallel execution based on annotations.
 * @author Sina Madani
 * @since 1.6
 */
public interface IErlModuleParallelAnnotation extends IErlModule {
	
	public static final String PARALLEL_ANNOTATION_NAME = "parallel";
	
	default boolean shouldBeParallel(AnnotatableModuleElement ast, Variable... variables) throws EolRuntimeException {
		Annotation parallelAnnotation = ast.getAnnotation(PARALLEL_ANNOTATION_NAME);
		
		if (parallelAnnotation != null) {
			if (parallelAnnotation instanceof ExecutableAnnotation && parallelAnnotation.hasValue()) {
				IEolContext context = getContext();
				FrameStack frameStack = context.getFrameStack();
				
				frameStack.enterLocal(FrameType.PROTECTED, ast, variables);
				Object result = parallelAnnotation.getValue(context);
				frameStack.leaveLocal(ast);
				
				if (result instanceof Boolean) {
					return (boolean) result;
				}
			}
			else return true;
		}
		
		return false;
	}

	default boolean shouldBeParallel(AnnotatableModuleElement ast, Object self, IModel model, int numElements) throws EolRuntimeException {
		return shouldBeParallel(ast, new Variable[] {
			Variable.createReadOnlyVariable("self", self),
			Variable.createReadOnlyVariable("NUM_ELEMENTS", numElements),
			Variable.createReadOnlyVariable("MODEL", model),
			Variable.createReadOnlyVariable("THREADS", getContext().getParallelism())
		});
	}
	
	@Override
	default IErlContextParallel getContext() {
		return (IErlContextParallel) IErlModule.super.getContext();
	}
}
