/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.eml.execute.context;

import org.eclipse.epsilon.ecl.trace.MatchTrace;
import org.eclipse.epsilon.eml.EmlModule;
import org.eclipse.epsilon.eml.strategy.IMergingStrategy;
import org.eclipse.epsilon.eml.trace.MergeTrace;
import org.eclipse.epsilon.etl.execute.context.IEtlContext;

public interface IEmlContext extends IEtlContext {

	public abstract IMergingStrategy getMergingStrategy();

	public abstract void setMergingStrategy(IMergingStrategy mergingStrategy);

	public abstract MatchTrace getMatchTrace();

	public abstract MergeTrace getMergeTrace();

	public abstract EmlModule getModule();

	public abstract void setModule(EmlModule module);

	public abstract void setMatchTrace(MatchTrace matchTrace);

	public abstract void setMergeTrace(MergeTrace mergeTrace);

}
