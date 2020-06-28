package org.eclipse.epsilon.picto.transformers.elements;

import java.io.InputStream;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
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
	public void transform(Element element) {
		
		Set<URI> baseUris = new LinkedHashSet<URI>(viewContent.getBaseUris());
		if (viewContent.getFile() != null) {
			baseUris.add(viewContent.getFile().toURI());
		}
		
		String attributeValue = element.getAttribute(attributeName);
		
		if (attributeValue != null && !attributeValue.trim().isEmpty()) {
			try {
				URI uri = new URI(attributeValue);
				if (!uri.isAbsolute()) {
					for (URI baseUri : baseUris) {
						URI fileUri = baseUri.resolve(attributeValue);
						try (InputStream in = fileUri.toURL().openStream()){
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
						catch (Exception ex) {}
					}
				}
			}
			catch (Exception ex) {}
		}
		
	}

}
