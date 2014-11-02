/*******************************************************************************
 * Copyright (c) 2012 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.epl.dom;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.common.util.AstUtil;
import org.eclipse.epsilon.eol.dom.AnnotatableModuleElement;
import org.eclipse.epsilon.eol.dom.Annotation;
import org.eclipse.epsilon.eol.dom.SimpleAnnotation;
import org.eclipse.epsilon.epl.parse.EplParser;

public class Pattern extends AnnotatableModuleElement {
	
	protected String name;
	protected List<Role> roles = new ArrayList<Role>();
	protected AST doAst = null;
	protected AST matchAst = null;
	protected AST noMatchAst = null;
	protected AST onMatchAst = null;
	protected int level = 0;
	
	public Pattern() {
		
	}
	
	public void build() {
		super.build();
		name = getText();
		Annotation levelAnnotation = getAnnotation("level");
		if (levelAnnotation != null && levelAnnotation instanceof SimpleAnnotation) {
			SimpleAnnotation simpleLevelAnnotation = (SimpleAnnotation) levelAnnotation;
			level = Integer.parseInt(simpleLevelAnnotation.getValue());
		}
		
		doAst = AstUtil.getChild(this, EplParser.DO); if (doAst != null) doAst = doAst.getFirstChild();
		matchAst = AstUtil.getChild(this, EplParser.MATCH); if (matchAst != null) matchAst = matchAst.getFirstChild();
		noMatchAst = AstUtil.getChild(this, EplParser.NOMATCH); if (noMatchAst != null) noMatchAst = noMatchAst.getFirstChild();
		onMatchAst = AstUtil.getChild(this, EplParser.ONMATCH); if (onMatchAst != null) onMatchAst = onMatchAst.getFirstChild();
		
		for (AST roleAst : AstUtil.getChildren(this, EplParser.ROLE)) {
			roles.add((Role) roleAst);
		}
	}
	
	public String getName() {
		return name;
	}
	
	public List<Role> getRoles() {
		return roles;
	}
	
	@Override
	public List<?> getModuleElements() {
		return Collections.emptyList();
	}
	
	public AST getMatchAst() {
		return matchAst;
	}
	
	public AST getDoAst() {
		return doAst;
	}
	
	public AST getNoMatchAst() {
		return noMatchAst;
	}
	
	public AST getOnMatchAst() {
		return onMatchAst;
	}
	
	public int getLevel() {
		return level;
	}
}
