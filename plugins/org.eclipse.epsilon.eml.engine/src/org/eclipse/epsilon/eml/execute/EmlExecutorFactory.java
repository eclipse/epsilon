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
package org.eclipse.epsilon.eml.execute;

import org.eclipse.epsilon.eml.parse.EmlParser;
import org.eclipse.epsilon.eol.execute.AbstractExecutor;
import org.eclipse.epsilon.eol.execute.ExecutorFactory;

public class EmlExecutorFactory extends ExecutorFactory{

	@Override
	public AbstractExecutor getExecutorFor(int type){
		if (type == EmlParser.SPECIAL_ASSIGNMENT){
			return new EquivalentAssignExecutor();
		}
		return super.getExecutorFor(type);
	}
	
	
}
