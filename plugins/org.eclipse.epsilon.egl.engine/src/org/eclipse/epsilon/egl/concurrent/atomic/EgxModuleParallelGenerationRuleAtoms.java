/*********************************************************************
 * Copyright (c) 2019 The University of York.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.egl.concurrent.atomic;

import java.util.List;
import org.eclipse.epsilon.egl.exceptions.EglRuntimeException;
import org.eclipse.epsilon.egl.execute.atoms.GenerationRuleAtom;
import org.eclipse.epsilon.egl.execute.context.concurrent.IEgxContextParallel;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;

/**
 * 
 * @author Sina Madani
 * @since 1.6
 */
public class EgxModuleParallelGenerationRuleAtoms extends EgxModuleParallelAtomic<GenerationRuleAtom> {

	public EgxModuleParallelGenerationRuleAtoms() {
		super();
	}

	public EgxModuleParallelGenerationRuleAtoms(String outputRoot) throws EglRuntimeException {
		super(outputRoot);
	}

	public EgxModuleParallelGenerationRuleAtoms(IEgxContextParallel context) {
		super(context);
	}
	
	@Override
	protected List<GenerationRuleAtom> getAllJobsImpl() throws EolRuntimeException {
		return GenerationRuleAtom.getAllJobs(this);
	}
}
