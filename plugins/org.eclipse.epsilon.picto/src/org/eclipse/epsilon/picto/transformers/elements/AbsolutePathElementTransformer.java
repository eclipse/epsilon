package org.eclipse.epsilon.picto.transformers.elements;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;

import org.w3c.dom.Element;

public class AbsolutePathElementTransformer extends AbstractHtmlElementTransformer {
	
	protected String elementName;
	protected String attributeName;
	
	public AbsolutePathElementTransformer(String elementName, String attributeName) {
		this.elementName = elementName;
		this.attributeName = attributeName;
	}
	
	@Override
	public String getXPath() {
		return "//*[local-name() = '" + elementName + "']";
	}

	@Override
	public void transform(Element element) {
		if (viewContent.getFile() != null) {
			String attributeValue = element.getAttribute(attributeName);
			if (attributeValue != null && !attributeValue.trim().isEmpty()) {
				try {
					URI uri = new URI(attributeValue);
					if (! uri.isAbsolute()) element.setAttribute(attributeName, 
						new File(viewContent.getFile().getParentFile(), attributeValue).toURI() + "");
				} catch (URISyntaxException e) {
				}
			}
		}
	}

	
}
