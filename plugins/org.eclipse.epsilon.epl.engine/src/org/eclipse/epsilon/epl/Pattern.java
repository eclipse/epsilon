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
package org.eclipse.epsilon.epl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.epsilon.common.module.AbstractModuleElement;
import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.common.util.AstUtil;
import org.eclipse.epsilon.eol.annotations.EolAnnotationsUtil;
import org.eclipse.epsilon.eol.annotations.EolSimpleAnnotation;
import org.eclipse.epsilon.eol.annotations.IEolAnnotation;
import org.eclipse.epsilon.epl.parse.EplParser;

public class Pattern extends AbstractModuleElement {
	
	protected String name;
	protected List<Role> roles = new ArrayList<Role>();
	protected AST doAst = null;
	protected AST matchAst = null;
	protected AST noMatchAst = null;
	protected AST onMatchAst = null;
	protected int level = 0;
	
	public Pattern(AST ast) {
		this.ast = ast;
		name = ast.getText();
		IEolAnnotation levelAnnotation = EolAnnotationsUtil.getAnnotation(ast, "level");
		if (levelAnnotation != null && levelAnnotation instanceof EolSimpleAnnotation) {
			EolSimpleAnnotation simpleLevelAnnotation = (EolSimpleAnnotation) levelAnnotation;
			level = Integer.parseInt(simpleLevelAnnotation.getValue(null));
		}
		
		doAst = AstUtil.getChild(ast, EplParser.DO); if (doAst != null) doAst = doAst.getFirstChild();
		matchAst = AstUtil.getChild(ast, EplParser.MATCH); if (matchAst != null) matchAst = matchAst.getFirstChild();
		noMatchAst = AstUtil.getChild(ast, EplParser.NOMATCH); if (noMatchAst != null) noMatchAst = noMatchAst.getFirstChild();
		onMatchAst = AstUtil.getChild(ast, EplParser.ONMATCH); if (onMatchAst != null) onMatchAst = onMatchAst.getFirstChild();
		
		for (AST roleAst : AstUtil.getChildren(ast, EplParser.ROLE)) {
			roles.add(new Role(roleAst));
		}
	}
	
	public String getName() {
		return name;
	}
	
	public List<Role> getRoles() {
		return roles;
	}
	
	@Override
	public List<?> getChildren() {
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
