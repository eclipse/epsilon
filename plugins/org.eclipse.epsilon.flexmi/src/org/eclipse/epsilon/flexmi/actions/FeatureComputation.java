package org.eclipse.epsilon.flexmi.actions;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.epsilon.emc.emf.InMemoryEmfModel;
import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.flexmi.FlexmiResource;

public class FeatureComputation extends Computation {
	
	protected EStructuralFeature eStructuralFeature;
	protected String attribute;
	
	public FeatureComputation(EObject eObject, EStructuralFeature eStructuralFeature, String attribute, String expression, URI uri, int lineNumber) {
		super();
		this.eObject = eObject;
		this.eStructuralFeature = eStructuralFeature;
		this.expression = expression;
		this.attribute = attribute;
		this.lineNumber = lineNumber;
		this.uri = uri;
	}
	
	public void compute(FlexmiResource resource) throws Exception {
		InMemoryEmfModel model = new InMemoryEmfModel(resource);
		EolModule module = new EolModule();
		module.parse("return " + expression + ";");
		if (module.getParseProblems().size() > 0) throw new Exception(module.getParseProblems().get(0).getReason());
		module.getContext().getFrameStack().putGlobal(Variable.createReadOnlyVariable("self", eObject));
		module.getContext().getModelRepository().addModel(model);
		for (String variable : resource.getVariables().keySet()) {
			module.getContext().getFrameStack().put(Variable.createReadOnlyVariable(variable, resource.getVariables().get(variable)));
		}
		eObject.eSet(eStructuralFeature, module.execute());
	}
	
	public EStructuralFeature geteStructuralFeature() {
		return eStructuralFeature;
	}
	
	public String getAttribute() {
		return attribute;
	}
	
}
