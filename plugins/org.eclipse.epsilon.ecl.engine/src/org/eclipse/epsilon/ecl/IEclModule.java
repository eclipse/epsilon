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
package org.eclipse.epsilon.ecl;

import java.util.List;

import org.eclipse.epsilon.ecl.dom.MatchRule;
import org.eclipse.epsilon.ecl.execute.context.IEclContext;
import org.eclipse.epsilon.ecl.trace.Match;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.erl.IErlModule;

public interface IEclModule extends IErlModule{
		
	public List<MatchRule> getMatchRules();
	
	public List<MatchRule> getDeclaredMatchRules();
	
	//public void setLeftModel(IModel leftModel);
	
	//public IModel getLeftModel();
	
	//public void setRightModel(IModel rightModel);
	
	//public IModel getRightModel();
	
	public IEclContext getContext();
	
	public void matchModels() throws EolRuntimeException;
	
	public Match match(Object left, Object right, boolean forcedMatch) throws EolRuntimeException;
}
