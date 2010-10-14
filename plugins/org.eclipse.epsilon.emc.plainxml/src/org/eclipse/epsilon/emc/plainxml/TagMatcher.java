package org.eclipse.epsilon.emc.plainxml;

import org.w3c.dom.Element;

public class TagMatcher {
	
	public static boolean matches(Element e, String pattern) {
		if (e == null) return false;
		if (pattern.equals("*")) return true;
		return e.getTagName().equals(pattern);
	}
	
}
