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
package org.eclipse.epsilon.ewl;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.Lexer;
import org.antlr.runtime.TokenStream;
import org.eclipse.epsilon.common.module.ModuleElement;
import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.common.parse.EpsilonParser;
import org.eclipse.epsilon.common.util.AstUtil;
import org.eclipse.epsilon.eol.EolLibraryModule;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.ewl.execute.context.EwlContext;
import org.eclipse.epsilon.ewl.execute.context.IEwlContext;
import org.eclipse.epsilon.ewl.parse.EwlLexer;
import org.eclipse.epsilon.ewl.parse.EwlParser;


public class EwlModule extends EolLibraryModule implements IEwlModule {
	
	protected List<EwlWizard> templates = new ArrayList<EwlWizard>();
	protected IEwlContext context = null;
	
	public EwlModule(){
		reset();
	}
	
	@Override
	public Lexer createLexer(InputStream inputStream) {
		ANTLRInputStream input = null;
		try {
			input = new ANTLRInputStream(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new EwlLexer(input);
	}

	@Override
	public EpsilonParser createParser(TokenStream tokenStream) {
		return new EwlParser(tokenStream);
	}

	@Override
	public String getMainRule() {
		return "ewlModule";
	}

	@Override
	public void buildModel() throws Exception {
		
		super.buildModel();
		
		for (AST wizardAst : AstUtil.getChildren(ast,EwlParser.WIZARD)) {
			final EwlWizard template = new EwlWizard();
			template.build(wizardAst);
			templates.add(template);
		}
	}
	
	public List<EwlWizardInstance> getWizardsFor(Object self) throws EolRuntimeException {
		prepareContext(context);

		final List<EwlWizardInstance> applicableWizards = new ArrayList<EwlWizardInstance>();
		
		for (EwlWizard wizard : templates) {
			if (wizard.appliesTo(self,context)){
				applicableWizards.add(new EwlWizardInstance(wizard, self, context));
			}
		}

		// Run the same wizard over a collection of applicable objects
		if (self instanceof Collection && !((Collection<?>)self).isEmpty()) {
			@SuppressWarnings("unchecked")
			final Collection<Object> collection = (Collection<Object>)self;

			for (EwlWizard wizard : templates) {
				if (allApply(wizard, collection)) {
					applicableWizards.add(new EwlWizardLoopInstance(wizard, collection, context));
				}
			}
		}

		return applicableWizards;
	}

	@Override
	public IEwlContext getContext(){
		return context;
	}
	
	@Override
	public List<ModuleElement> getChildren(){
		final List<ModuleElement> children = new ArrayList<ModuleElement>();
		children.addAll(getImports());
		children.addAll(templates);
		children.addAll(getDeclaredOperations());
		return children;
	}
	
	@Override
	public void reset(){
		super.reset();
		templates = new ArrayList<EwlWizard>();
		context = new EwlContext();
	}

	private boolean allApply(EwlWizard wizard, Collection<Object> self) throws EolRuntimeException {
		for (Object o : self) {
			if (!wizard.appliesTo(o, context)) {
				return false;
			}
		}
		return true;
	}

}
