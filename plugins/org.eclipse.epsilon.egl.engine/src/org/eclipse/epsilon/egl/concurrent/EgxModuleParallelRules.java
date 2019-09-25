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
import java.util.List;
import org.eclipse.epsilon.egl.dom.GenerationRule;
import org.eclipse.epsilon.egl.exceptions.EglRuntimeException;
import org.eclipse.epsilon.egl.execute.context.concurrent.IEgxContextParallel;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.function.CheckedEolRunnable;
import org.eclipse.epsilon.erl.concurrent.IErlModuleParallelAtomicBatches;
import org.eclipse.epsilon.erl.execute.data.ExecutableRuleAtom;

/**
 * Executes each element for each {@linkplain GenerationRule} in parallel.
 * 
 * @author Sina Madani
 * @since 1.6
 */
public class EgxModuleParallelRules extends EgxModuleParallel implements IErlModuleParallelAtomicBatches<ExecutableRuleAtom<GenerationRule>> {

	public EgxModuleParallelRules() {
		super();
	}

	public EgxModuleParallelRules(IEgxContextParallel context) {
		super(context);
	}
	
	public EgxModuleParallelRules(String outputRoot) throws EglRuntimeException {
		this();
		setFileGeneratingTemplateFactory(outputRoot);
	}

	@Override
	protected Object processRules() throws EolRuntimeException {
		for (GenerationRule rule : getGenerationRules()) {
			Collection<?> allElements = rule.getAllElements(context);
			ArrayList<CheckedEolRunnable> genJobs = new ArrayList<>(allElements.size());
			
			for (Object element : allElements) {
				genJobs.add(() -> rule.generate(element, this));
			}
			
			getContext().executeParallel(rule, genJobs);
		}
		return null;
	}

	@Override
	public List<? extends ExecutableRuleAtom<GenerationRule>> getAllJobs() throws EolRuntimeException {
		IEgxContextParallel context = getContext();
		final ArrayList<ExecutableRuleAtom<GenerationRule>> atoms = new ArrayList<>();
		
		for (GenerationRule rule : getGenerationRules()) {
			Collection<?> allElements = rule.getAllElements(context);
			atoms.ensureCapacity(atoms.size() + allElements.size());
			for (Object element : allElements) {
				atoms.add(new ExecutableRuleAtom<>(rule, element, context));
			}
		}
		
		return atoms;
	}
	
}
