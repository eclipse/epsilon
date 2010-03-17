package org.eclipse.epsilon.emc.plainxml;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class DomUtil {
	
	public static List<Element> getChildren(Element parent) {
		List<Element> result = new ArrayList<Element>();
		NodeList childNodes = parent.getChildNodes();
		for (int i=0; i<childNodes.getLength(); i++) {
			Object o = childNodes.item(i);
			if (o instanceof Element) {
				result.add((Element) o);
			}
		}
		return result;
	}
	
}
