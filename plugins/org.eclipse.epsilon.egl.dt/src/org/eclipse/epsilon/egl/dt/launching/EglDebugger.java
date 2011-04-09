package org.eclipse.epsilon.egl.dt.launching;

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.egl.internal.EglPreprocessorModule;
import org.eclipse.epsilon.egl.preprocessor.Trace;
import org.eclipse.epsilon.eol.dt.debug.EolDebugger;
import org.eclipse.epsilon.eol.execute.context.IEolContext;

public class EglDebugger extends EolDebugger {
	
	protected Trace trace = null;
	
	@Override
	protected boolean controls(AST ast, IEolContext context) {
		//this.context = (EglContext) context;
		this.trace = ((EglPreprocessorModule) context.getModule()).getTrace();
		return super.controls(ast, context);
	}
	
	@Override
	protected int getRealLine(int line) {
		return trace.getEglLineNumberFor(line);
	}
	
}
