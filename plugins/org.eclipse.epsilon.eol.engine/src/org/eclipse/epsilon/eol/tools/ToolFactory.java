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
package org.eclipse.epsilon.eol.tools;

import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.Variable;

public class ToolFactory {
	
	public static boolean createTool(String name, String clazz, IEolContext context) {
		
		Object tool;
		
		try {
			tool = Class.forName(clazz).getDeclaredConstructor().newInstance();
		} catch (Exception e) {
			return false;
		}
		
		if (tool instanceof ITool) {
			((ITool) tool).setContext(context);
		}
		
		context.getFrameStack().put(Variable.createReadOnlyVariable(name, tool));
		return true;
	}
}
