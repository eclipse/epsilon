/*********************************************************************
 * Copyright (c) 2018 The University of York.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.erl.execute.context.concurrent;

import org.eclipse.epsilon.eol.dom.AnnotatableModuleElement;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.execute.context.concurrent.IEolContextParallel;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.erl.IErlModuleAtomicBatches;
import org.eclipse.epsilon.erl.execute.context.IErlContext;
import org.eclipse.epsilon.erl.execute.data.JobBatch;
import org.eclipse.epsilon.erl.execute.data.RuleAtom;

/**
 * 
 * @author Sina Madani
 * @since 1.6
 */
public interface IErlContextParallel extends IErlContext, IEolContextParallel {

	public static final String PARALLEL_ANNOTATION_NAME = "parallel";
	
	default boolean shouldBeParallel(AnnotatableModuleElement ast, Object self, IModel model, int numElements) throws EolRuntimeException {
		if (!isParallelisationLegal()) return false;
		return ast.getBooleanAnnotationValue(PARALLEL_ANNOTATION_NAME, this, () -> new Variable[] {
			Variable.createReadOnlyVariable("self", self),
			Variable.createReadOnlyVariable("NUM_ELEMENTS", numElements),
			Variable.createReadOnlyVariable("MODEL", model),
			Variable.createReadOnlyVariable("THREADS", getParallelism())
		});
	}
	
	@Override
	default Object executeJob(Object job) throws EolRuntimeException {
		if (job instanceof RuleAtom) {
			return ((RuleAtom<?>) job).execute(this);
		}
		Object module;
		if (job instanceof JobBatch && (module = getModule()) instanceof IErlModuleAtomicBatches) {
			 return executeJob(((JobBatch) job).split(((IErlModuleAtomicBatches<?>) module).getAllJobs()));
		}
		return IEolContextParallel.super.executeJob(job);
	}
}
