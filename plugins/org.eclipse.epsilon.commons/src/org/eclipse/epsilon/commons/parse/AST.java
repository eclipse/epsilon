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
package org.eclipse.epsilon.commons.parse;

import java.io.File;
import java.net.URI;
import java.util.Collections;
import java.util.List;

import org.antlr.runtime.Token;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.Tree;

public class AST extends CommonTree {

	protected URI uri;
	protected Integer line = null;
	protected Integer column = null;
	
	protected AST annotations;

	public AST() {
		super();
	}

	public AST(CommonTree commontree) {
		super(commontree);
		
		if (commontree.getChildren() != null) {
			for (Object child : commontree.getChildren()) {
				addChild((CommonTree)child);
			}
		}
	}

	public AST(Token token, URI uri) {
		super(token);
		this.uri = uri;
	}

	public void setAnnotationsAst(AST annotations) {
		this.annotations = annotations;
	}

	public AST getAnnotationsAst() {
		return annotations;
	}
	
	public File getFile() {
		if (uri != null && "file".equals(uri.getScheme())) {
			return new File(uri);
		}
		return null;
	}

	public URI getUri() {
		return uri;
	}

	// Methods for compatibility with ANTLR2

	private AST cast(Tree tree) {
		if (tree instanceof AST) {
			return (AST)tree;
		
		} else if (tree instanceof CommonTree){
			return new AST((CommonTree)tree);
		}
		
		throw new IllegalArgumentException("Cannot cast " + tree.getClass().getSimpleName() + " to AST.");
	}
	
	@Override
	public List<? extends AST> getChildren() {
		List<AST> children = super.getChildren();
		if (children == null) return Collections.EMPTY_LIST;
		else return children;
	}
	
	public AST getParent() {
		return (AST) parent;
	}
	
	public void setLine(int line) {
		this.line = line;
	}
	
	public int getLine() {
		if (this.line == null) {
			return super.getLine();
		}
		else {
			return line;
		}
	}
	
	public void setColumn(int column) {
		this.column = column;
	}
	
	public int getColumn() {
		if (column == null) {
			return super.getCharPositionInLine();
		}
		else {
			return column;
		}
	}
	
	public AST getNextSibling() {
		if (parent == null)
			return null;
		List<Tree> siblings = parent.getChildren();
		if (this.childIndex >= siblings.size() - 1) {
			return null;
		} else {
			return cast(siblings.get(this.childIndex + 1));
		}
	}
	
	public void setNextSibling(AST sibling) {
		if (parent != null && sibling != null) {
			parent.getChildren().add(this.childIndex, sibling);
		}
	}
	
	public AST getChild(int i) {
		return cast(super.getChild(i));
	}
	
	public int getNumberOfChildren() {
		return this.getChildCount();
	}

	public AST getFirstChild() {
		if (this.getChildCount() > 0) {
			return cast(this.getChild(0));
		} else {
			return null;
		}
	}
	
	public void setFirstChild(AST child) {
		if (getChildCount() == 0) {
			addChild(child);
			
		} else { 
			super.children.add(0, child);
			freshenParentAndChildIndexes();
		}
	}
}
