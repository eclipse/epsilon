package org.eclipse.epsilon.egl.execute.operations;

import java.util.List;

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.egl.exceptions.EglUnallocatedOutputBufferException;
import org.eclipse.epsilon.eol.EolFormalParameterList;
import org.eclipse.epsilon.eol.EolOperation;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.exceptions.EolTypeNotFoundException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.types.EolType;

public class EglOperationWrapper extends EolOperation {

	private final EolOperation wrapped;
	
	public EglOperationWrapper(EolOperation wrapped) {
		this.wrapped = wrapped;
	}
	
	@SuppressWarnings("unchecked")
	public Object execute(Object self, List parameterValues, IEolContext context, boolean inNewStackFrame) throws EolRuntimeException {
		try {
			return wrapped.execute(self, parameterValues, context, inNewStackFrame);
		} catch (EolTypeNotFoundException e) {
			checkForUnallocatedOutputBuffer(e);
			throw e;
		}
	}
	
	@SuppressWarnings("unchecked")
	public Object execute(Object self, List parameterValues, IEolContext context) throws EolRuntimeException {
		try {
			return wrapped.execute(self, parameterValues, context);
		} catch (EolTypeNotFoundException e) {
			checkForUnallocatedOutputBuffer(e);
			throw e;
		}
	}

	private void checkForUnallocatedOutputBuffer(EolTypeNotFoundException e) throws EolRuntimeException {
		if (e.getReason().contains("'out'")) {
			throw new EglUnallocatedOutputBufferException("The operation '" + getName() + "' uses a static section but has not been annotated with @template.", e);
		}
	}

	public void clearCache() {
		wrapped.clearCache();
	}

	public boolean equals(Object obj) {
		return wrapped.equals(obj);
	}

	public AST getAst() {
		return wrapped.getAst();
	}

	public AST getBody() {
		return wrapped.getBody();
	}

	@SuppressWarnings("unchecked")
	public List getChildren() {
		return wrapped.getChildren();
	}

	public EolType getContextType(IEolContext context) throws EolRuntimeException {
		return wrapped.getContextType(context);
	}

	public EolFormalParameterList getFormalParameters() {
		return wrapped.getFormalParameters();
	}

	public String getName() {
		return wrapped.getName();
	}

	public EolType getReturnType(IEolContext context) throws EolRuntimeException {
		return wrapped.getReturnType(context);
	}

	public int hashCode() {
		return wrapped.hashCode();
	}

	public boolean isCached() {
		return wrapped.isCached();
	}

	public void parse(AST ast) {
		wrapped.parse(ast);
	}

	public void setAst(AST ast) {
		wrapped.setAst(ast);
	}

	public void setBody(AST body) {
		wrapped.setBody(body);
	}

	public void setFormalParameters(EolFormalParameterList formalParameters) {
		wrapped.setFormalParameters(formalParameters);
	}

	public void setName(String name) {
		wrapped.setName(name);
	}

	public String toString() {
		return wrapped.toString();
	}	
}
