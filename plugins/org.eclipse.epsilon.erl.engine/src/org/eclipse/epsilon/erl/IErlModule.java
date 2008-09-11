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
package org.eclipse.epsilon.erl;

import org.eclipse.epsilon.eol.IEolExecutableModule;
import org.eclipse.epsilon.erl.rules.NamedRules;

public interface IErlModule extends IEolExecutableModule {
	
	public NamedRules getPre();
	public NamedRules getPost();
	public NamedRules getDeclaredPre();
	public NamedRules getDeclaredPost();
	
}
