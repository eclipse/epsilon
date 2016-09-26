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
package org.eclipse.epsilon.profiling;

import org.eclipse.epsilon.common.module.ModuleElement;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.control.IExecutionListener;

public class ProfilingExecutionListener implements IExecutionListener {

	@Override
	public void aboutToExecute(ModuleElement ast, IEolContext context) {
		//if (AstUtil.getParentType(ast) == EolParser.POINT)
			Profiler.INSTANCE.start(getLabel(ast), "", ast);
	}

	@Override
	public void finishedExecuting(ModuleElement ast, Object evaluatedAst, IEolContext context) {
		//if (AstUtil.getParentType(ast) == EolParser.POINT)
			Profiler.INSTANCE.stop(getLabel(ast));
	}
	
	@Override
	public void finishedExecutingWithException(ModuleElement ast, EolRuntimeException exception, IEolContext context) {}
	
	protected String getLabel(ModuleElement ast) {
		return ast.getClass().getSimpleName() + " (" + ast.getRegion().getStart().getLine() + ":" + ast.getRegion().getStart().getColumn() + ")";
	}
	
}
