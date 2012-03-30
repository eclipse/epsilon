package org.eclipse.epsilon.epl;

import java.util.HashMap;

public class PatternMatch {
	
	protected Pattern pattern;
	protected HashMap<String, Object> roleBindings = new HashMap<String, Object>();
	
	public PatternMatch(Pattern pattern) {
		this.pattern = pattern;
	}
	
	public HashMap<String, Object> getRoleBindings() {
		return roleBindings;
	}
	
	public Object getRoleBinding(String name) {
		return getRoleBindings().get(name);
	}
	
	public Pattern getPattern() {
		return pattern;
	}
	
}
