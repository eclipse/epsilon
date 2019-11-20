/*********************************************************************
 * Copyright (c) 2018 The University of York.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.egl.concurrent;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Callable;
import org.eclipse.epsilon.egl.dom.GenerationRule;
import org.eclipse.epsilon.egl.exceptions.EglRuntimeException;
import org.eclipse.epsilon.egl.execute.context.IEgxContext;
import org.eclipse.epsilon.egl.execute.context.concurrent.IEgxContextParallel;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.ExecutorFactory;
import org.eclipse.epsilon.erl.IErlModuleParallelAnnotation;

/**
 * 
 * @author Sina Madani
 * @since 1.6
 */
public class EgxModuleParallelAnnotation extends EgxModuleParallel implements IErlModuleParallelAnnotation {

	public EgxModuleParallelAnnotation() {
		super();
	}

	public EgxModuleParallelAnnotation(String outputRoot) throws EglRuntimeException {
		super(outputRoot);
	}

	public EgxModuleParallelAnnotation(IEgxContextParallel context) {
		super(context);
	}

	@Override
	protected Object processRules() throws EolRuntimeException {
		IEgxContextParallel pContext = getContext();
		ExecutorFactory executorFactory = pContext.getExecutorFactory();
		
		for (GenerationRule rule : getGenerationRules()) {
			final Collection<?> allElements = rule.getAllElements(pContext);
			final Collection<Callable<?>> genJobs = new ArrayList<>(allElements.size());
			
			for (Object element : allElements) {
				if (shouldBeParallel(rule, element)) {
					genJobs.add(() -> {
						IEgxContext sContext = getShadowContext();
						return sContext.getExecutorFactory().execute(rule, sContext, element);
					});
				}
				else {
					executorFactory.execute(rule, pContext, element);
				}
			}
			pContext.executeAll(rule, genJobs);
		}
		return null;
	}
	
}
