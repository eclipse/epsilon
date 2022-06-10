package org.eclipse.epsilon.examples.standalone.egl.propertyaccessrecording;

import org.eclipse.epsilon.egl.dom.GenerationRule;
import org.eclipse.epsilon.eol.execute.introspection.recording.PropertyAccess;

public class GenerationRulePropertyAccess extends PropertyAccess {

	protected GenerationRule rule;
	protected Object element;

	public GenerationRulePropertyAccess(Object modelElement, String propertyName, GenerationRule rule, Object element) {
		super(modelElement, propertyName);
		this.rule = rule;
		this.element = element;
	}

	public GenerationRule getRule() {
		return rule;
	}

	public Object getElement() {
		return element;
	}

}