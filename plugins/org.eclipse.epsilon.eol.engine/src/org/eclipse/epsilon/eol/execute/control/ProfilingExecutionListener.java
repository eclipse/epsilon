package org.eclipse.epsilon.eol.execute.control;

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.commons.profiling.FileMarker;
import org.eclipse.epsilon.commons.profiling.Profiler;
import org.eclipse.epsilon.commons.util.AstUtil;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.parse.EolParser;

public class ProfilingExecutionListener implements IExecutionListener {

	@Override
	public void aboutToExecute(AST ast, IEolContext context) {
		if (AstUtil.getParentType(ast) == EolParser.BLOCK)
			Profiler.INSTANCE.start(getLabel(ast), "", new FileMarker(ast.getFile(), ast.getLine(), ast.getColumn()));
	}

	@Override
	public void finishedExecuting(AST ast, Object evaluatedAst, IEolContext context) {
		if (AstUtil.getParentType(ast) == EolParser.BLOCK)
			Profiler.INSTANCE.stop(getLabel(ast));
	}
	
	protected String getLabel(AST ast) {
		return "Line " + ast.getLine();
	}
	
}
