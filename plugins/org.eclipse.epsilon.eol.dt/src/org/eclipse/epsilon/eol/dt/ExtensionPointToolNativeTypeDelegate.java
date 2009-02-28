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
package org.eclipse.epsilon.eol.dt;

import java.util.HashMap;
import java.util.List;

import org.eclipse.epsilon.common.dt.launching.extensions.ToolExtension;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.types.AbstractToolNativeTypeDelegate;

public class ExtensionPointToolNativeTypeDelegate extends AbstractToolNativeTypeDelegate{
	
	protected HashMap<String, ToolExtension> tools = new HashMap<String, ToolExtension>();
	
	public ExtensionPointToolNativeTypeDelegate() {
		for (ToolExtension extension : ToolExtension.getInstances()) {
			tools.put(extension.getClazz(), extension);
		}
	}
	
	public Object createInstance(String clazz, List<Object> parameters) throws EolRuntimeException {
		return tools.get(clazz).createTool(parameters);
	}

	public boolean knowsAbout(String clazz) {
		return tools.containsKey(clazz);
	}

}
