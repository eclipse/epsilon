package org.eclipse.epsilon.picto.transformers.elements;

import java.io.InputStream;
import java.nio.file.*;
import java.util.LinkedHashSet;
import java.util.Set;

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
	public void transform(Element element) throws Exception {
		
		Set<java.net.URI> baseUris = new LinkedHashSet<>(viewContent.getBaseUris());
		if (viewContent.getFile() != null) {
			baseUris.add(viewContent.getFile().toURI());
		}
		
		String attributeValue = element.getAttribute(attributeName);
		
		if (attributeValue != null && !attributeValue.trim().isEmpty()) {
			java.net.URI uri = java.net.URI.create(attributeValue);
			if (!uri.isAbsolute()) {
				for (java.net.URI baseUri : baseUris) {
					java.net.URI fileUri = baseUri.resolve(attributeValue);
					try (InputStream in = fileUri.toURL().openStream()) {
						if ("file".equals(fileUri.getScheme())) {
							element.setAttribute(attributeName, fileUri.toString());
						}
						else {
							Path temp = Files.createTempFile("picto", Paths.get(attributeValue).getFileName().toString());
							Files.copy(in, temp, StandardCopyOption.REPLACE_EXISTING);
							element.setAttribute(attributeName, temp.toAbsolutePath().toString());
						}
						break;
					}
				}
			}
		}
	}

}
