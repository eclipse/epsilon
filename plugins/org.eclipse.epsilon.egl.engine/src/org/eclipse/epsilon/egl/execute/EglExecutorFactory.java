/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.egl.execute;

import org.eclipse.epsilon.eol.execute.AbstractExecutor;
import org.eclipse.epsilon.eol.execute.ExecutorFactory;
import org.eclipse.epsilon.eol.parse.EolParser;

public class EglExecutorFactory extends ExecutorFactory {

	@Override
	public AbstractExecutor getExecutorFor(int type){
		
		if (type == EolParser.TYPE){
			return new EglTypeExecutor();
		}
		return super.getExecutorFor(type);
	}
	
	
}

