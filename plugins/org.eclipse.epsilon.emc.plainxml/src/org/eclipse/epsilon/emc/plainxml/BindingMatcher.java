package org.eclipse.epsilon.emc.plainxml;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.w3c.dom.Element;

public class BindingMatcher {
	
	public static Collection<Binding> getMatchingBindings(PlainXmlModel model, Element e, String property) {
		List<Binding> bindings = new ArrayList<Binding>();
		for (Binding binding : model.getBindings()) {
			if (TagMatcher.matches(e, binding.getSourceTag())
					&& property.equals(binding.getSourceAttribute())) {
				bindings.add(binding);
			}
		}
		return bindings;
	}
	
}
