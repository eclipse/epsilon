/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.ecl.execute.context;

import org.eclipse.epsilon.ecl.IEclModule;
import org.eclipse.epsilon.ecl.trace.MatchTrace;
import org.eclipse.epsilon.eol.execute.context.EolContext;

public class EclContext extends EolContext implements IEclContext{
	
	protected MatchTrace matchTrace = new MatchTrace();
	protected MatchTrace tempMatchTrace = new MatchTrace();
	
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
