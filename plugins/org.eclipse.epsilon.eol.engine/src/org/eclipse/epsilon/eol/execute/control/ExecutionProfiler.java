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
package org.eclipse.epsilon.eol.execute.control;

import java.util.HashMap;
import java.util.Iterator;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.execute.context.IEolContext;


public class ExecutionProfiler implements ExecutionController {
	
	protected HashMap profile = new HashMap();
	long previousTime = 0;
	AST previousAst = null;
	
	public ExecutionProfiler() {
		super();
	}

	public void control(AST ast, IEolContext context) {
		long currentTime = 0;
		
		if (previousAst != null){
			Long timeSoFar = (Long) profile.get(previousAst);
			if (timeSoFar == null){
				timeSoFar = new Long(0);
			}
			currentTime = System.currentTimeMillis();
			timeSoFar = new Long(timeSoFar.longValue() + currentTime - previousTime);
			profile.put(previousAst, timeSoFar);
		}
		
		previousTime = currentTime;
		previousAst = ast;
	}

	public boolean isTerminated() {
		return false;
	}

	public HashMap getProfile() {
		return profile;
	}

	public void report(IEolContext context) {
		Iterator it = profile.keySet().iterator();
		while (it.hasNext()){
			Object key = it.next();
			context.getErrorStream().print(key);
			context.getErrorStream().print("-");
			context.getErrorStream().println(profile.get(key));
		}
	}

	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void done(AST ast, IEolContext context) {
		// nothing to do
	}
	
}
