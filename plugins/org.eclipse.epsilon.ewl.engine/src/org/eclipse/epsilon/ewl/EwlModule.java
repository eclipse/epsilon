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
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.Lexer;
import org.antlr.runtime.TokenStream;
import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.commons.parse.EpsilonParser;
import org.eclipse.epsilon.commons.util.AstUtil;
import org.eclipse.epsilon.eol.EolLibraryModule;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.ewl.execute.context.EwlContext;
import org.eclipse.epsilon.ewl.execute.context.IEwlContext;
import org.eclipse.epsilon.ewl.parse.EwlLexer;
import org.eclipse.epsilon.ewl.parse.EwlParser;


public class EwlModule extends EolLibraryModule implements IEwlModule {
	
	protected ArrayList templates = new ArrayList();
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
		// TODO Auto-generated method stub
		return new EwlParser(tokenStream);
	}

	@Override
	public String getMainRule() {
		return "ewlModule";
	}

	@Override
	public void buildModel() throws Exception {
		
		super.buildModel();
		
		Iterator it = AstUtil.getChildren(ast,EwlParser.WIZARD).iterator();
		while (it.hasNext()) {
			EwlWizard template = new EwlWizard();
			template.build((AST)it.next());
			templates.add(template);
		}
		
	}
	
	public List<EwlWizardInstance> getWizardsFor(Object self) throws EolRuntimeException {
		context.setModule(this);
		ListIterator li = templates.listIterator();
		ArrayList<EwlWizardInstance> applicableWizards = new ArrayList();
		while (li.hasNext()) { 
			EwlWizard wizard = (EwlWizard) li.next();
			if (wizard.appliesTo(self,context)){
				applicableWizards.add(new EwlWizardInstance(wizard, self, context));
			}
		}
		return applicableWizards;
	}
	
	@Override
	public IEwlContext getContext(){
		return context;
	}
	
	@Override
	public List getChildren(){
		List children = new ArrayList();
		children.addAll(getImports());
		children.addAll(templates);
		children.addAll(getDeclaredOperations());
		return children;
	}
	
	@Override
	public void reset(){
		super.reset();
		templates = new ArrayList();
		context = new EwlContext();
	}

}
