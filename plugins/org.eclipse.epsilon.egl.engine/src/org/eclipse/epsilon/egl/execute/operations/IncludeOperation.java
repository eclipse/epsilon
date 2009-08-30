package org.eclipse.epsilon.egl.execute.operations;

import java.util.List;

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.egl.exceptions.EglRuntimeException;
import org.eclipse.epsilon.egl.output.OutputBuffer;
import org.eclipse.epsilon.egl.template.TemplateFactory;
import org.eclipse.epsilon.egl.types.EglTemplate;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.execute.operations.simple.AbstractSimpleOperation;
import org.eclipse.epsilon.eol.types.EolString;

public class IncludeOperation extends AbstractSimpleOperation {

	@Override
	public Object execute(Object source, List parameters, IEolContext context_,
			AST ast) throws EolRuntimeException {
				
		Variable templateFactoryVariable = context_.getFrameStack().get("TemplateFactory");
		TemplateFactory templateFactory = (TemplateFactory) templateFactoryVariable.getValue();
		
		Variable outVariable = context_.getFrameStack().get("out");
		
		OutputBuffer out = (OutputBuffer)outVariable.getValue();
		
		String templatePath = ((EolString) parameters.get(0)).getValue();
		EglTemplate template = templateFactory.load(templatePath);
		
		try {
			String output = template.process();
			out.println(output);
		}
		catch (EglRuntimeException ex) {
			throw ex;
		}

		return null;
		
	}

}
