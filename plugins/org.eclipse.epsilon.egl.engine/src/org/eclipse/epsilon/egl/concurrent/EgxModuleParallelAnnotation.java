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
import org.eclipse.epsilon.erl.concurrent.IErlModuleParallelAnnotation;

/**
 * Evaluates {@linkplain GenerationRule}-element pairs in parallel
 * based on user-defined annotation predicates.
 * 
 * @author Sina Madani
 * @since 1.6
 */
public class EgxModuleParallelAnnotation extends EgxModuleParallel implements IErlModuleParallelAnnotation {

	public EgxModuleParallelAnnotation() {
		super();
	}

	public EgxModuleParallelAnnotation(int parallelism) {
		super(parallelism);
	}

	public EgxModuleParallelAnnotation(IEgxContextParallel egxContext) {
		super(egxContext);
	}

	@Override
	protected void generateRules() throws EolRuntimeException {
		IEgxContextParallel context = getContext();
		EglTemplateFactory templateFactory = context.getTemplateFactory();
		Map<URI, EglTemplate> templateCache = ConcurrencyUtils.concurrentMap();
		
		for (GenerationRule rule : getGenerationRules()) {
			final Collection<?> allElements = rule.getAllElements(context);
			final int numElements = allElements.size();
			ArrayList<Runnable> genJobs = new ArrayList<>(numElements);
			
			for (Object element : allElements) {
				if (shouldBeParallel(rule, element, rule.getOwningModelForType(context), numElements)) {
					genJobs.add(() -> {
						try {
							rule.generate(context, templateFactory, this, element, templateCache);
						}
						catch (EolRuntimeException exception) {
							context.handleException(exception);
						}
					});
				}
				else {
					rule.generate(context, templateFactory, this, element, templateCache);
				}
			}
			
			context.executeParallel(rule, genJobs);
		}
	}
	
}
