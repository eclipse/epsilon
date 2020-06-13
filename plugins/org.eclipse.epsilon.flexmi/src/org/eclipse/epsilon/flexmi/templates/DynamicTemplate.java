package org.eclipse.epsilon.flexmi.templates;

import java.net.URI;

import org.eclipse.epsilon.eol.IEolModule;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.flexmi.FlexmiResource;
import org.w3c.dom.Element;

public abstract class DynamicTemplate extends XmlTemplate {

	public DynamicTemplate(Element element, FlexmiResource resource, URI uri) {
		super(element, resource, uri);
	}
	
	protected void prepareModule(IEolModule module, Element call) {
		for (Parameter parameter : getParameters()) {
			String parameterName = parameter.getName();
			String value = call.getAttribute(parameterName);
			if (call.hasAttribute(Template.PREFIX + parameterName)) value = call.getAttribute(Template.PREFIX + parameterName);
			module.getContext().getFrameStack().put(Variable.createReadOnlyVariable(parameterName, value));
		}
		
		FlexmiResource resource = this.resource;
		while (resource != null) {
			module.getOperations().addAll(resource.getOperations());
			if (resource.getImportedFrom() != null) resource = resource.getImportedFrom();
			else resource = null;
		}
	}
	
}
