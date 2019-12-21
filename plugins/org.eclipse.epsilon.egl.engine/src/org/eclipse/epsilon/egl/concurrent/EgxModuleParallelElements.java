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

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Callable;
import org.eclipse.epsilon.egl.dom.GenerationRule;
import org.eclipse.epsilon.egl.exceptions.EglRuntimeException;
import org.eclipse.epsilon.egl.execute.context.IEgxContext;
import org.eclipse.epsilon.egl.execute.context.concurrent.EgxContextParallel;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;

/**
 * Executes each element for each {@linkplain GenerationRule} in parallel.
 * 
 * @author Sina Madani
 * @since 1.6
 */
public class EgxModuleParallelElements extends EgxModuleParallel {

	public EgxModuleParallelElements() {
		super();
	}

	public EgxModuleParallelElements(EgxContextParallel context) {
		super(context);
	}
	
	public EgxModuleParallelElements(Path outputRoot) throws EglRuntimeException {
		super(outputRoot);
	}

	@Override
	protected Object processRules() throws EolRuntimeException {
		final EgxContextParallel pContext = (EgxContextParallel) getContext();
		
		for (GenerationRule rule : getGenerationRules()) {
			final Collection<?> allElements = rule.getAllElements(pContext);
			final ArrayList<Callable<?>> genJobs = new ArrayList<>(allElements.size());
			
			for (final Object element : allElements) {
				genJobs.add(() -> {
					IEgxContext sContext = pContext.getShadow();
					return sContext.getExecutorFactory().execute(rule, sContext, element);
				});
			}
			
			pContext.executeAll(rule, genJobs);
		}
		return null;
	}
	
}
