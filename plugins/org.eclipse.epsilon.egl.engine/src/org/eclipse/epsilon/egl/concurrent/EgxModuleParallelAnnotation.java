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
		IEgxContextParallel context = getContext();
		
		for (GenerationRule rule : getGenerationRules()) {
			final Collection<?> allElements = rule.getAllElements(context);
			final int numElements = allElements.size();
			ArrayList<CheckedEolRunnable> genJobs = new ArrayList<>(numElements);
			
			for (Object element : allElements) {
				if (shouldBeParallel(rule, element, rule.getOwningModelForType(context), numElements)) {
					genJobs.add(() -> rule.generate(element, this));
				}
				else {
					rule.generate(element, this);
				}
			}
			context.executeParallel(rule, genJobs);
		}
		return null;
	}
	
}
