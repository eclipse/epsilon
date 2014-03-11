package org.eclipse.epsilon.emc.muddle.graphml;

import java.util.ArrayList;
import java.util.List;

import org.jdom.Element;

public class DomUtil {
	
	public static List<Element> getChildren(Element parent, String name) {
		List<Element> children = new ArrayList<Element>();
		for (Object o : parent.getChildren()) {
			if (o instanceof Element) {
				Element e = (Element) o;
				if (e.getName().equals(name)) {
					children.add(e);
				}
			}
		}
		return children;
	}
	
}
