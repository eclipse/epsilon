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
import org.eclipse.epsilon.egl.dom.GenerationRule;
import org.eclipse.epsilon.egl.exceptions.EglRuntimeException;
import org.eclipse.epsilon.egl.execute.context.concurrent.IEgxContextParallel;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.function.CheckedEolRunnable;

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

	public EgxModuleParallelElements(IEgxContextParallel context) {
		super(context);
	}
	
	public EgxModuleParallelElements(String outputRoot) throws EglRuntimeException {
		super(outputRoot);
	}

	@Override
	protected Object processRules() throws EolRuntimeException {
		final IEgxContextParallel context = getContext();
		
		for (GenerationRule rule : getGenerationRules()) {
			final Collection<?> allElements = rule.getAllElements(context);
			final ArrayList<CheckedEolRunnable> genJobs = new ArrayList<>(allElements.size());
			
			for (final Object element : allElements) {
				genJobs.add(() -> rule.generate(element, this));
			}
			
			context.executeParallel(rule, genJobs);
		}
		return null;
	}
	
}
