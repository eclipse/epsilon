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
import org.eclipse.epsilon.egl.execute.context.concurrent.IEgxContextParallel;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.function.CheckedEolRunnable;

/**
 * Executes each element for each {@linkplain GenerationRule} in parallel.
 * 
 * @author Sina Madani
 * @since 1.6
 */
public class EgxModuleParallelRules extends EgxModuleParallel {

	public EgxModuleParallelRules() {
		super();
	}

	public EgxModuleParallelRules(int parallelism) {
		super(parallelism);
	}

	public EgxModuleParallelRules(IEgxContextParallel egxContext) {
		super(egxContext);
	}

	@Override
	protected void generateRules() throws EolRuntimeException {
		for (GenerationRule rule : getGenerationRules()) {
			Collection<?> allElements = rule.getAllElements(context);
			ArrayList<CheckedEolRunnable> genJobs = new ArrayList<>(allElements.size());
			
			for (Object element : allElements) {
				genJobs.add(() -> rule.generate(element, this));
			}
			
			getContext().executeParallel(rule, genJobs);
		}
	}
	
}
