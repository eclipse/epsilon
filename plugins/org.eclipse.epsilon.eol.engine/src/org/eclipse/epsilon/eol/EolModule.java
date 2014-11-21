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
package org.eclipse.epsilon.eol;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.epsilon.common.module.ModuleElement;
import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.common.util.AstUtil;
import org.eclipse.epsilon.eol.dom.Main;
import org.eclipse.epsilon.eol.dom.Operation;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.Return;
import org.eclipse.epsilon.eol.execute.context.EolContext;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.parse.EolParser;

public class EolModule extends EolLibraryModule implements IEolModule {
	
	protected Main main;
	protected IEolContext context;
	
	public EolModule(){
		reset();
	}

	@Override
	public void buildModel() throws Exception {
		super.buildModel();
		main = (Main) AstUtil.getChild(ast, EolParser.BLOCK);
	}
	
	@Override
	public AST adapt(AST cst, AST parentAst) {
		if (cst.getParent() != null && cst.getParent().getType() == EolParser.EOLMODULE && cst.getType() == EolParser.BLOCK){
			return new Main();
		}
		return super.adapt(cst, parentAst);
	}
	
	public Object execute() throws EolRuntimeException {
		prepareContext(getContext());
		return Return.getValue(getContext().getExecutorFactory().executeAST(main, getContext()));
	}

	public Main getMain() {
		return main;
	}

	public void setMain(Main main) {
		this.main = main;
	}
	
	@Override
	public IEolContext getContext() {
		return context;
	}

	@Override
	public void setContext(IEolContext context) {
		this.context = context;
	}
	
	@Override
	public List<ModuleElement> getModuleElements() {
		final List<ModuleElement> children = new ArrayList<ModuleElement>();
		children.addAll(getImports());
		if (getMain()!=null){
			children.add(getMain());
		}
		children.addAll(getDeclaredOperations());
		return children;
	}
	
	public IEolContext createContext() {
		return new EolContext();
	}
	
	//TODO: Clear context as well
	@Override
	public void reset() {
		super.reset();
		main = null;
		context = createContext();
	}

	/**
	 * Clear all cached results and type information, and all extended
	 * properties. Useful for rerunning the same EolModule with different sets
	 * of models, without having to parse it again.
	 */
	public void clearCache() {
		for (Operation op : getOperations()) {
			op.clearCache();
		}
		getContext().getExtendedProperties().clear();
	}

}
