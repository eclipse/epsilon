package org.eclipse.epsilon.eol.execute.control;

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.commons.profiling.FileMarker;
import org.eclipse.epsilon.commons.profiling.Profiler;
import org.eclipse.epsilon.eol.execute.context.IEolContext;

public class ProfilingExecutionListener implements IExecutionListener {

	@Override
	public void aboutToExecute(AST ast, IEolContext context) {
		Profiler.INSTANCE.start(ast.toString(), "", new FileMarker(ast.getFile(), ast.getLine(), ast.getColumn()));
	}

	@Override
	public void finishedExecuting(AST ast, IEolContext context) {
		Profiler.INSTANCE.stop(ast.toString());
	}

}
