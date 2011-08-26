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

import org.eclipse.epsilon.commons.module.ModuleElement;
import org.eclipse.epsilon.commons.util.AstUtil;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.Return;
import org.eclipse.epsilon.eol.execute.context.EolContext;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.parse.EolParser;

public class EolModule extends EolLibraryModule implements IEolModule {
	
	protected EolMain main;
	protected IEolContext context;
	
	public EolModule(){
		reset();
	}	

	@Override
	public void buildModel() throws Exception {
		super.buildModel();
		main = new EolMain();
		main.setAst(AstUtil.getChild(ast, EolParser.BLOCK));
	}
	
	public Object execute() throws EolRuntimeException {
		prepareContext(getContext());
		
		return Return.getValue(getContext().getExecutorFactory().executeAST(main.getAst(), getContext()));
		
	}

	public EolMain getMain() {
		return main;
	}

	@Override
	public IEolContext getContext() {
		return context;
	}

	@Override
	public List<ModuleElement> getChildren() {
		final List<ModuleElement> children = new ArrayList<ModuleElement>();
		children.addAll(getImports());
		if (getMain()!=null){
			children.add(getMain());
		}
		children.addAll(getDeclaredOperations());
		return children;
	}

	//TODO: Clear context as well
	@Override
	public void reset() {
		super.reset();
		main = null;
		context = new EolContext();
	}

	/**
	 * Clear all cached results and type information, and all extended
	 * properties. Useful for rerunning the same EolModule with different sets
	 * of models, without having to parse it again.
	 */
	public void clearCache() {
		for (EolOperation op : getOperations()) {
			op.clearCache();
		}
		getContext().getExtendedProperties().clear();
	}

}
