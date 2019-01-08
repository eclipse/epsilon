package org.eclipse.epsilon.flexmi;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.epsilon.emc.emf.InMemoryEmfModel;
import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.epsilon.eol.execute.context.Variable;

public class Constructor extends Computation {
	
	public Constructor(EObject eObject, String expression, URI uri, int lineNumber) {
		this.eObject = eObject;
		this.expression = expression;
		this.uri = uri;
		this.lineNumber = lineNumber;
	}
	
	@Override
	public void compute() throws Exception {
		InMemoryEmfModel model = new InMemoryEmfModel(eObject.eResource());
		EolModule module = new EolModule();
		module.parse(expression);
		if (module.getParseProblems().size() > 0) throw new Exception("Parse problem " + module.getParseProblems().get(0).getReason());
		module.getContext().getFrameStack().putGlobal(Variable.createReadOnlyVariable("self", eObject));
		module.getContext().getModelRepository().addModel(model);
		module.execute();
	}
	
}
