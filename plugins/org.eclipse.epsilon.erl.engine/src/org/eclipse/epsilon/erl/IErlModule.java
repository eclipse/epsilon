/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
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
