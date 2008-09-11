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

import java.util.Comparator;

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.commons.util.AstUtil;
import org.eclipse.epsilon.commons.util.StringUtil;
import org.eclipse.epsilon.eol.EolImport;
import org.eclipse.epsilon.eol.EolLabeledBlock;
import org.eclipse.epsilon.eol.EolLibraryModule;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.erl.rules.INamedRule;
import org.eclipse.epsilon.erl.rules.LabeledNamedRule;
import org.eclipse.epsilon.erl.rules.NamedRules;


public abstract class ErlModule extends EolLibraryModule implements IErlModule {
	
	protected NamedRules declaredPre = new NamedRules();
	protected NamedRules declaredPost = new NamedRules();
	protected NamedRules pre = null;
	protected NamedRules post = null;
	
	@Override
	public void buildModel() throws Exception {
		super.buildModel();
		
		for (AST preBlockAst : AstUtil.getChildren(ast, getPreBlockTokenType())){
			declaredPre.add(new LabeledNamedRule(preBlockAst,"pre"));
		}
		
		for (AST postBlockAst : AstUtil.getChildren(ast, getPostBlockTokenType())){
			declaredPost.add(new LabeledNamedRule(postBlockAst,"post"));
		}
		
	}

	public NamedRules getPost() {
		if (post == null) {
			post = new NamedRules();
			for (EolImport import_ : imports) {
				if (import_.isLoaded() && (import_.getModule() instanceof IErlModule)) {
					IErlModule module = (IErlModule) import_.getModule();
					post.addAll(module.getPost());
				}
			}
			post.addAll(declaredPost);
			
		}
		return post;
	}

	public NamedRules getPre() {
		if (pre == null) {
			pre = new NamedRules();
			for (EolImport import_ : imports) {
				if (import_.isLoaded() && (import_.getModule() instanceof IErlModule)) {
					IErlModule module = (IErlModule) import_.getModule();
					pre.addAll(module.getPre());
				}
			}
			pre.addAll(declaredPre);
		}
		return pre;
	}

	public NamedRules getDeclaredPost() {
		return declaredPost;
	}

	public NamedRules getDeclaredPre() {
		return declaredPre;
	}
	
	protected void execute(NamedRules namedRules, IEolContext context) throws EolRuntimeException {
		for (INamedRule namedRule : namedRules) {
			context.getExecutorFactory().executeAST(namedRule.getAst(), context);
		}
	}
	
	protected abstract int getPreBlockTokenType();
	protected abstract int getPostBlockTokenType();
	
	@Override
	public void reset() {
		super.reset();
		pre = null;
		post = null;
		declaredPre.clear();
		declaredPost.clear();
	}
	
	class EolLabeledBlockComparator implements Comparator<EolLabeledBlock> {
		public int compare(EolLabeledBlock o1, EolLabeledBlock o2) {
			if (StringUtil.areEqual(o1.getName(), o2.getName())) {
				return 0;
			}
			else {
				return 1;
			}
		}
	}
	
}
