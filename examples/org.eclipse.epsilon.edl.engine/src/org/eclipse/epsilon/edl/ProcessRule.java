package org.eclipse.epsilon.edl;

import org.eclipse.epsilon.common.module.IModule;
import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.dom.AnnotatableModuleElement;
import org.eclipse.epsilon.eol.dom.Parameter;
import org.eclipse.epsilon.eol.dom.StatementBlock;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.FrameType;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.types.EolModelElementType;

public class ProcessRule extends AnnotatableModuleElement {
	
	protected Parameter parameter;
	protected StatementBlock body;
	
	@Override
	public void build(AST cst, IModule module) {
		super.build(cst, module);
		parameter = (Parameter) module.createAst(cst.getFirstChild(), this);
		body = (StatementBlock) module.createAst(cst.getSecondChild(), this);
	}
	
	protected void execute(IEolContext context) throws EolRuntimeException {
		
		EolModelElementType parameterType = (EolModelElementType) parameter.getType(context);
		
		for (Object o : parameterType.getAllOfKind()) {
			context.getFrameStack().enterLocal(FrameType.PROTECTED, body);
			context.getFrameStack().put(Variable.createReadOnlyVariable(parameter.getName(), o));
			context.getExecutorFactory().execute(body, context);
			context.getFrameStack().leaveLocal(body);
		}
	}
	
	public Parameter getParameter() {
		return parameter;
	}
	
	public void setParameter(Parameter parameter) {
		this.parameter = parameter;
	}
	
	public StatementBlock getBody() {
		return body;
	}
	
	public void setBody(StatementBlock body) {
		this.body = body;
	}
	
}
