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
package org.eclipse.epsilon.common.module;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.antlr.runtime.Token;
import org.eclipse.epsilon.common.parse.AST;


public abstract class AbstractModuleElement extends AST implements ModuleElement {
	
	protected List<Comment> comments = new ArrayList<Comment>();
	
	@Override
	public void build() {
		super.build();
		for (Token commentToken : getCommentTokens()) {
			Comment comment = new Comment(commentToken);
			comment.setUri(getUri());
			comments.add(comment);
		}
	}
	
	@Override
	public List<?> getModuleElements() {
		return Collections.emptyList();
	}
	
	public List<Comment> getComments() {
		return comments;
	}
	
	public String getDebugInfo() { return ""; }
	
}
