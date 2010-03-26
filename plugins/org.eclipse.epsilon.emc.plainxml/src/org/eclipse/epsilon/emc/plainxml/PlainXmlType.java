package org.eclipse.epsilon.emc.plainxml;

public class PlainXmlType {
	
	protected String tagName = null;
	
	public String getTagName() {
		return tagName;
	}
	
	public static PlainXmlType parse(String type) {
		PlainXmlType x = null;
		if (type.startsWith("t_")) {
			x = new PlainXmlType();
			x.tagName = type.substring(2);
		}
		return x;
	}
	
}
