package org.eclipse.epsilon.eol.dom;

import org.eclipse.epsilon.common.module.ModuleElement;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;

public interface IExecutableModuleElement extends ModuleElement {
	
	Object execute(IEolContext context) throws EolRuntimeException;
	
}
