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

import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import org.eclipse.epsilon.common.concurrent.ConcurrencyUtils;
import org.eclipse.epsilon.egl.EglTemplate;
import org.eclipse.epsilon.egl.EglTemplateFactory;
import org.eclipse.epsilon.egl.dom.GenerationRule;
import org.eclipse.epsilon.egl.execute.context.concurrent.IEgxContextParallel;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;

/**
 * Executes each element for each {@linkplain GenerationRule} in parallel.
 * @author Sina Madani
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
		IEgxContextParallel context = getContext();
		EglTemplateFactory templateFactory = context.getTemplateFactory();
		Map<URI, EglTemplate> templateCache = null;//ConcurrencyUtils.concurrentMap();
		
		for (GenerationRule rule : getGenerationRules()) {
			Collection<?> allElements = rule.getAllElements(context);
			ArrayList<Runnable> genJobs = new ArrayList<>(allElements.size());
			
			for (Object element : allElements) {
				genJobs.add(() -> {
					try {
						rule.generate(context, templateFactory, this, element, templateCache);
					}
					catch (EolRuntimeException exception) {
						context.handleException(exception);
					}
				});
			}
			
			context.executeParallel(rule, genJobs);
		}
	}
	
}
