package org.eclipse.epsilon.edl;

import java.util.Collections;
import java.util.List;

import org.eclipse.epsilon.common.module.ModuleElement;
import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.EolFormalParameter;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.FrameType;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.types.EolModelElementType;

public class ProcessRule implements ModuleElement {
	
	protected EolFormalParameter parameter;
	protected AST body;
	protected AST ast;
	
	public ProcessRule(AST ast) {
		this.ast = ast;
		parameter = new EolFormalParameter(ast.getFirstChild());
		body = ast.getFirstChild().getNextSibling();
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
	
	public EolFormalParameter getParameter() {
		return parameter;
	}
	
	public void setParameter(EolFormalParameter parameter) {
		this.parameter = parameter;
	}
	
	public AST getBody() {
		return body;
	}
	
	public void setBody(AST body) {
		this.body = body;
	}

	@Override
	public AST getAst() {
		return ast;
	}

	@Override
	public List<?> getChildren() {
		return Collections.emptyList();
	}
	
	@Override
	public String toString() {
		return getParameter().getTypeName();
	}
	
}
