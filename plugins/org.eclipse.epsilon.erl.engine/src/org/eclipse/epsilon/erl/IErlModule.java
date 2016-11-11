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

import java.util.List;

import org.eclipse.epsilon.eol.IEolModule;
import org.eclipse.epsilon.erl.dom.Post;
import org.eclipse.epsilon.erl.dom.Pre;

public interface IErlModule extends IEolModule {
	
	public List<Pre> getPre();
	public List<Post> getPost();
	public List<Pre> getDeclaredPre();
	public List<Post> getDeclaredPost();
	
}
