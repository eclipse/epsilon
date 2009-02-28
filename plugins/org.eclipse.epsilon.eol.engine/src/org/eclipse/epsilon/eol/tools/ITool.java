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

import java.util.List;

import org.eclipse.epsilon.eol.execute.context.IEolContext;

public interface ITool {
	
	public void setContext(IEolContext context);
	public IEolContext getContext();
	public void initialize(List<Object> parameters);
}
