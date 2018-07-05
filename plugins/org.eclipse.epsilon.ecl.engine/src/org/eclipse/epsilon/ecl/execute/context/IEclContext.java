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
import org.eclipse.epsilon.eol.execute.context.IEolContext;

public interface IEclContext extends IEolContext {
	
	void setMatchTrace(MatchTrace matchTrace);
	
	MatchTrace getMatchTrace();
	
	MatchTrace getTempMatchTrace();
	
	// MatchingStrategy getMatchingStrategy();
	
	// void setMatchingStrategy(MatchingStrategy matchingStrategy);
	
	@Override
	IEclModule getModule();

}
