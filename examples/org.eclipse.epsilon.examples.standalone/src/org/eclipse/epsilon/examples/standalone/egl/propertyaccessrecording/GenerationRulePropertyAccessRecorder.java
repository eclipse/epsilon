package org.eclipse.epsilon.examples.standalone.egl.propertyaccessrecording;

import org.eclipse.epsilon.egl.dom.GenerationRule;
import org.eclipse.epsilon.eol.execute.introspection.recording.PropertyAccess;
import org.eclipse.epsilon.eol.execute.introspection.recording.PropertyAccessRecorder;

public class GenerationRulePropertyAccessRecorder extends PropertyAccessRecorder {

	protected GenerationRule rule = null;
	protected Object element = null;
	
	public GenerationRulePropertyAccessRecorder() {
		super();
	}
	
	public Object getElement() {
		return element;
	}
	
	public void setElement(Object element) {
		this.element = element;
	}
	
	public void setRule(GenerationRule rule) {
		this.rule = rule;
	}
	
	public GenerationRule getRule() {
		return rule;
	}
	
	@Override
	protected PropertyAccess createPropertyAccess(Object modelElement, String propertyName) {
		return new GenerationRulePropertyAccess(modelElement, propertyName, rule, element);
	}

}