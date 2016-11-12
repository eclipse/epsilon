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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.epsilon.common.module.IModule;
import org.eclipse.epsilon.common.module.ModuleElement;
import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.common.parse.problem.ParseProblem;
import org.eclipse.epsilon.common.util.AstUtil;
import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.epsilon.eol.dom.Import;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.erl.dom.ExtensibleNamedRule;
import org.eclipse.epsilon.erl.dom.NamedRuleList;
import org.eclipse.epsilon.erl.dom.NamedStatementBlockRule;
import org.eclipse.epsilon.erl.dom.Post;
import org.eclipse.epsilon.erl.dom.Pre;
import org.eclipse.epsilon.erl.exceptions.ErlCircularRuleInheritanceException;
import org.eclipse.epsilon.erl.exceptions.ErlRuleNotFoundException;

public abstract class ErlModule extends EolModule implements IErlModule {
	
	protected NamedRuleList<Pre> declaredPre = new NamedRuleList<Pre>();
	protected NamedRuleList<Post> declaredPost = new NamedRuleList<Post>();
	protected NamedRuleList<Pre> pre = null;
	protected NamedRuleList<Post> post = null;
	
	@Override
	public void build(AST cst, IModule module) {
		super.build(cst, module);
		
		for (AST preBlockAst : AstUtil.getChildren(cst, getPreBlockTokenType())){
			declaredPre.add((Pre) module.createAst(preBlockAst, this));
		}
		
		for (AST postBlockAst : AstUtil.getChildren(cst, getPostBlockTokenType())){
			declaredPost.add((Post) module.createAst(postBlockAst, this));
		}
	}
	
	public List<Post> getPost() {
		if (post == null) {
			post = new NamedRuleList<Post>();
			for (Import import_ : imports) {
				if (import_.isLoaded() && (import_.getModule() instanceof IErlModule)) {
					IErlModule module = (IErlModule) import_.getModule();
					post.addAll(module.getPost());
				}
			}
			post.addAll(declaredPost);
			
		}
		return post;
	}

	public List<Pre> getPre() {
		if (pre == null) {
			pre = new NamedRuleList<Pre>();
			for (Import import_ : imports) {
				if (import_.isLoaded() && (import_.getModule() instanceof IErlModule)) {
					IErlModule module = (IErlModule) import_.getModule();
					pre.addAll(module.getPre());
				}
			}
			pre.addAll(declaredPre);
		}
		return pre;
	}

	@Override
	public ModuleElement adapt(AST cst, ModuleElement parentAst) {
		if (cst.getType() == getPreBlockTokenType()) {
			return new Pre();
		}
		else if (cst.getType() == getPostBlockTokenType()) {
			return new Post();
		}
		return super.adapt(cst, parentAst);
	}
	
	public List<Post> getDeclaredPost() {
		return declaredPost;
	}

	public List<Pre> getDeclaredPre() {
		return declaredPre;
	}
	
	
	protected void execute(List<? extends NamedStatementBlockRule> namedRules, IEolContext context) throws EolRuntimeException {
		for (NamedStatementBlockRule namedRule : namedRules) {
			context.getExecutorFactory().executeAST(namedRule.getBody(), context);
		}
	}
	
	protected abstract int getPreBlockTokenType();
	protected abstract int getPostBlockTokenType();

	public List<ParseProblem> calculateSuperRules(List<? extends ExtensibleNamedRule> allRules){
		List<ParseProblem> parseProblems = new ArrayList<ParseProblem>();
		for (ExtensibleNamedRule rule : allRules) {
			try {
				rule.calculateSuperRules(allRules);
			} catch (ErlRuleNotFoundException e) {
				ParseProblem problem = new ParseProblem();
				problem.setLine(rule.getRegion().getStart().getLine());
				problem.setReason(e.getReason());
				parseProblems.add(problem);
			} catch (ErlCircularRuleInheritanceException e) {
				ParseProblem problem = new ParseProblem();
				problem.setLine(rule.getRegion().getStart().getLine());
				problem.setReason(e.getReason());
				parseProblems.add(problem);
			}
		}
		return parseProblems;
	}
}
