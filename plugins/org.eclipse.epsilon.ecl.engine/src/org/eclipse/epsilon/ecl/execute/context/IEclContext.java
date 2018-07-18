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
import org.eclipse.epsilon.eol.execute.context.IEolContext;

public interface IEclContext extends IEolContext{
	
	public MatchTrace getMatchTrace();
	
	public void setMatchTrace(MatchTrace matchTrace);
	
	public MatchTrace getTempMatchTrace();
	
	//public MatchingStrategy getMatchingStrategy();
	
	//public void setMatchingStrategy(MatchingStrategy matchingStrategy);
	
	public IEclModule getModule();

}
