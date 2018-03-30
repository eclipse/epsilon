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

import org.eclipse.epsilon.common.module.ModuleElement;
import org.eclipse.epsilon.eol.execute.context.IEolContext;

public class ExecutionProfiler implements ExecutionController {
	
	protected HashMap<ModuleElement, Long> profile = new HashMap<>();
	long previousTime = 0;
	ModuleElement previousAst = null;
	
	public ExecutionProfiler() {
		super();
	}

	public void control(ModuleElement ast, IEolContext context) {
		long currentTime = 0;
		
		if (previousAst != null) {
			Long timeSoFar = (Long) profile.get(previousAst);
			if (timeSoFar == null) {
				timeSoFar = 0L;
			}
			currentTime = System.currentTimeMillis();
			timeSoFar += currentTime - previousTime;
			profile.put(previousAst, timeSoFar);
		}
		
		previousTime = currentTime;
		previousAst = ast;
	}

	public boolean isTerminated() {
		return false;
	}

	public HashMap<ModuleElement, Long> getProfile() {
		return profile;
	}

	public void report(IEolContext context) {
		Iterator<ModuleElement> it = profile.keySet().iterator();
		while (it.hasNext()){
			ModuleElement key = it.next();
			context.getErrorStream().print(key);
			context.getErrorStream().print("-");
			context.getErrorStream().println(profile.get(key));
		}
	}

	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void done(ModuleElement ast, IEolContext context) {
		// nothing to do
	}
}
