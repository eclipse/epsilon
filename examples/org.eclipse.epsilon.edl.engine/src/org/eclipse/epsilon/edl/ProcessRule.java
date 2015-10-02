package org.eclipse.epsilon.edl;

import java.util.Collections;
import java.util.List;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.dom.AnnotatableModuleElement;
import org.eclipse.epsilon.eol.dom.Parameter;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.FrameType;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.types.EolModelElementType;

public class ProcessRule extends AnnotatableModuleElement {
	
	protected Parameter parameter;
	protected AST body;
	
	@Override
	public void build() {
		super.build();
		parameter = (Parameter) getFirstChild();
		body = getFirstChild().getNextSibling();
	}
	
	protected void execute(IEolContext context) throws EolRuntimeException {
		
		EolModelElementType parameterType = (EolModelElementType) parameter.getType(context);
		
		for (Object o : parameterType.getAllOfKind()) {
			context.getFrameStack().enterLocal(FrameType.PROTECTED, body);
			context.getFrameStack().put(Variable.createReadOnlyVariable(parameter.getName(), o));
			context.getExecutorFactory().executeAST(body, context);
			context.getFrameStack().leaveLocal(body);
		}
	}
	
	public Parameter getParameter() {
		return parameter;
	}
	
	public void setParameter(Parameter parameter) {
		this.parameter = parameter;
	}
	
	public AST getBody() {
		return body;
	}
	
	public void setBody(AST body) {
		this.body = body;
	}

	@Override
	public String toString() {
		return getParameter().getTypeName();
	}
	
}
