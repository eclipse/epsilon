/*********************************************************************
* Copyright (c) 2020 The University of York.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.picto.transformers.elements;

import java.nio.file.Path;
import org.eclipse.epsilon.picto.ViewContent;
import org.eclipse.epsilon.picto.XmlHelper;
import org.eclipse.epsilon.picto.transformers.ExternalContentTransformation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

public abstract class ReplacingElementTransformer extends AbstractHtmlElementTransformer {
	
	protected XmlHelper xmlHelper = new XmlHelper();
	
	protected final void replace(Element element, ViewContent viewContent) {
		replace(element, viewContent, false);
	}
	
	protected void replace(Element element, ViewContent viewContent, boolean iframe) {
		Document owner = element.getOwnerDocument();
		if (iframe) try {
			Path tmp = ExternalContentTransformation.createTempFile("html", viewContent.getText().getBytes());
			owner.renameNode(element, element.getNamespaceURI(), "iframe");
			element.setAttribute("src", tmp.toAbsolutePath().toString());
		}
		catch (Exception ex) {
			// Ignore
		}
		else try {
			Document document = xmlHelper.parse(viewContent.getText());
			Element svg = document.getDocumentElement();
			owner.importNode(svg, true);
			owner.adoptNode(svg);
			element.getParentNode().replaceChild(svg, element);
			
			NamedNodeMap attributes = element.getAttributes();
			for (int i = 0, length = attributes.getLength(); i < length; i++) {
				Node node = attributes.item(i);
				svg.setAttribute(node.getNodeName(), node.getNodeValue());
			}
			
			return;
		}
		catch (Exception e) {
			owner.renameNode(element, element.getNamespaceURI(), "b");
			element.setTextContent(e.getMessage());
			return;
		}
	}
	
}
