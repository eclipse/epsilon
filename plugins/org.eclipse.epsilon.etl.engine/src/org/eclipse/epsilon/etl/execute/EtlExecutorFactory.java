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
package org.eclipse.epsilon.etl.execute;

import org.eclipse.epsilon.eol.execute.AbstractExecutor;
import org.eclipse.epsilon.eol.execute.ExecutorFactory;
import org.eclipse.epsilon.etl.parse.EtlParser;

public class EtlExecutorFactory extends ExecutorFactory{

	@Override
	public AbstractExecutor getExecutorFor(int type){
		
		if (type == EtlParser.SPECIAL_ASSIGNMENT){
			return new EquivalentAssignExecutor();
		}
		return super.getExecutorFor(type);
	}
	
	
}
