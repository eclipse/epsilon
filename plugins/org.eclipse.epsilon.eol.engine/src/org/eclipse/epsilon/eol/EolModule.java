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
import org.eclipse.epsilon.eol.exceptions.flowcontrol.EolReturnException;
import org.eclipse.epsilon.eol.execute.context.EolContext;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.Variable;
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
	
	public void prepare() {
		context.setModule(this);
		//context.getExecutorFactory().setExecutionController(new ExecutionProfiler());
		//context.getScope().put(Variable.createReadOnlyVariable("ModelFactory", new ModelFactory()));
		//context.getScope().put(Variable.createReadOnlyVariable("antlrParser", new AntlrParser()));
		context.getFrameStack().put(Variable.createReadOnlyVariable("null", null));
		//context.getFrameStack().put(Variable.createReadOnlyVariable("context",context));
		EolSystem system = new EolSystem();
		system.setContext(context);
		context.getFrameStack().put(Variable.createReadOnlyVariable("System",system));
	}
	
	public Object execute() throws EolRuntimeException {
		prepare();
		
		try {
			context.getExecutorFactory().executeAST(main.getAst(), context);
		}
		
		catch (EolReturnException rex){
			return rex.getReturned();
		}
		
		//context.getExecutorFactory().getExecutionController().report(context);
		
		return null;
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
		ArrayList children = new ArrayList();
		children.addAll(getImports());
		if (getMain()!=null){
			children.add(getMain());
		}
		//children.addAll(getDeclaredModelDefinitions());
		//children.addAll(getDeclaredModelGroupDefinitions());
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

}
