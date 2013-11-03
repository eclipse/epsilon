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
package org.eclipse.epsilon.common.parse;

import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.antlr.runtime.CommonToken;
import org.antlr.runtime.Token;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.Tree;
import org.eclipse.epsilon.common.module.IModule;

public class AST extends CommonTree {

	protected URI uri;
	protected Integer line = null;
	protected Integer column = null;
	protected Region region;
	protected AST annotations;
	protected boolean imaginary;
	protected List<Token> extraTokens = new ArrayList<Token>();
	protected List<AST> descendants = null;
	protected IModule module;
	
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
	
	public AST(Token token, AST real) {
		super(token);
		this.region = real.getRegion();
		this.uri = real.getUri();
		this.module = real.getModule();
	}
	
	public AST(Token token, URI uri) {
		super(token);
		this.uri = uri;
	}
	
	public AST(Token token, URI uri, IModule module) {
		super(token);
		this.uri = uri;
		this.module = module;
	}
	
	public IModule getModule() {
		return module;
	}
	
	public AST setModule(IModule module) {
		this.module = module;
		return this;
	}
	
	public AST setAnnotationsAst(AST annotations) {
		this.annotations = annotations;
		return this;
	}

	public AST getAnnotationsAst() {
		return annotations;
	}

	/**
	 * Returns the basename of the URI of this AST, which is the last segment of
	 * its URI. {@link #getFile()} returns <code>null</code> for non-
	 * <code>file:///</code> URIs, which is correct in its own regard, but may
	 * produce NPEs in our case.
	 */
	public String getBasename() {
		final String uriPath = getUri().getPath();
		final int lastSlash = uriPath.lastIndexOf("/");
		final String filename = lastSlash == -1 ? uriPath : uriPath.substring(lastSlash + 1);
		return filename;
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
	public List<AST> getChildren() {
		List<AST> children = super.getChildren();
		if (children == null) return Collections.EMPTY_LIST;
		else return children;
	}
	
	public AST getParent() {
		return (AST) parent;
	}
	
	public AST setLine(int line) {
		this.line = line;
		return this;
	}
	
	public int getLine() {
		if (this.line == null) {
			return super.getLine();
		}
		else {
			return line;
		}
	}
	
	public AST setColumn(int column) {
		this.column = column;
		return this;
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
	
	public AST setNextSibling(AST sibling) {
		if (parent != null && sibling != null) {
			parent.getChildren().add(this.childIndex, sibling);
		}
		return this;
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
	
	public AST setFirstChild(AST child) {
		if (getChildCount() == 0) {
			addChild(child);
			
		} else { 
			super.children.add(0, child);
			freshenParentAndChildIndexes();
		}
		return this;
	}
	
	public Region getRegion() {
		if (region == null) {
			region = new Region();
			
			Position startPosition = new Position();
			if (!isImaginary()) {
				startPosition.setLine(this.getLine());
				startPosition.setColumn(this.getColumn());
			}
			else {
				startPosition.setLine(100000);
				startPosition.setColumn(0);
			}
			region.setStart(startPosition);
			
			Position endPosition = new Position();
			if (!isImaginary()) {
				endPosition.setLine(this.getLine());
				endPosition.setColumn(this.getColumn() + ((CommonToken)getToken()).getStopIndex() - ((CommonToken)getToken()).getStartIndex() + 1);
			}
			else {
				endPosition.setLine(-1);
				endPosition.setColumn(0);
			}
			region.setEnd(endPosition);
			
			for (AST child : getChildren()) {
				Region childRegion = child.getRegion();
				if (childRegion.getStart().isBefore(region.getStart())) {
					region.setStart(childRegion.getStart());
				}
				if (childRegion.getEnd().isAfter(region.getEnd())) {
					region.setEnd(childRegion.getEnd());
				}
			}
			
			for (Token token : getExtraTokens()) {
				if (token == null) continue;
				Position tokenStartPosition = new Position();
				tokenStartPosition.setLine(token.getLine());
				tokenStartPosition.setColumn(token.getCharPositionInLine());
				
				Position tokenEndPosition = new Position();
				tokenEndPosition.setLine(token.getLine());
				tokenEndPosition.setColumn(token.getCharPositionInLine() + token.getText().length());
				
				if (tokenStartPosition.isBefore(region.getStart())) {
					region.setStart(tokenStartPosition);
				}
				if (tokenEndPosition.isAfter(region.getEnd())) {
					region.setEnd(tokenEndPosition);
				}
				
			}
			
		}
		
		
		return region;
	}
	
	public List<AST> getDescendants() {
		if (descendants == null) {
			descendants = new ArrayList<AST>();
			collectDescendants(this, descendants, false);
		}
		return descendants;
	}
	
	protected void collectDescendants(AST ast, List<AST> descendants, boolean addAst) {
		if (addAst) descendants.add(ast);
		for (AST child : ast.getChildren()) {
			collectDescendants(child, descendants, true);
		}
	}
	
	public void setRegion(Region region) {
		this.region = region;
	}
	
	public AST setImaginary(boolean imaginary) {
		this.imaginary = imaginary;
		return this;
	}
	
	public boolean isImaginary() {
		return imaginary;
	}
	
	public List<Token> getExtraTokens() {
		return extraTokens;
	}
	
}
