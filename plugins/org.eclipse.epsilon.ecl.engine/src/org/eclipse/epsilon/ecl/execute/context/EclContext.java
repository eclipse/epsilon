/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.ecl.execute.context;

import org.eclipse.epsilon.ecl.IEclModule;
import org.eclipse.epsilon.ecl.trace.MatchTrace;
import org.eclipse.epsilon.eol.execute.context.EolContext;

public class EclContext extends EolContext implements IEclContext {
	
	protected MatchTrace matchTrace = new MatchTrace();
	protected MatchTrace tempMatchTrace = new MatchTrace();
	
	@Override
	public void setMatchTrace(MatchTrace matchTrace) {
		this.matchTrace = matchTrace;
	}
	
	@Override
	public MatchTrace getMatchTrace() {
		return matchTrace;
	}
	
	@Override
	public MatchTrace getTempMatchTrace() {
		return tempMatchTrace;
	}

	@Override
	public IEclModule getModule() {
		return (IEclModule) module;
	}
	
}
