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

		if (element.hasAttribute("iframe")) {
			iframe = true;
		}

		if (!iframe) {
			try {
				Document document = xmlHelper.parse(viewContent.getText());
				Element docElem = document.getDocumentElement();
				owner.importNode(docElem, true);
				owner.adoptNode(docElem);
				element.getParentNode().replaceChild(docElem, element);

				NamedNodeMap attributes = element.getAttributes();
				for (int i = 0, length = attributes.getLength(); i < length; i++) {
					Node node = attributes.item(i);
					docElem.setAttribute(node.getNodeName(), node.getNodeValue());
				}

				return;
			}
			catch (Exception e) {
				iframe = true; // try again below within an iframe
			}
		}

		if (iframe) {
			try {
				Path tmp = ExternalContentTransformation.createTempFile("html", viewContent.getText().getBytes());

				owner.renameNode(element, element.getNamespaceURI(), "div");

				// outer resize library (inner must be present in the iframe contents)
				Element resizeLibrary = owner.createElement("script");
				resizeLibrary.setAttribute("src", "https://cdnjs.cloudflare.com/ajax/libs/iframe-resizer/4.3.2/iframeResizer.min.js");
				element.appendChild(resizeLibrary);

				Element iframeElem = owner.createElement("iframe");
				iframeElem.setAttribute("src", tmp.toAbsolutePath().toString());
				iframeElem.setAttribute("style", "border:none;");
				iframeElem.setAttribute("scrolling", "no");
				iframeElem.setAttribute("width", "100%");
				element.appendChild(iframeElem);

				Element resizeScript = owner.createElement("script");
				resizeScript.setTextContent("iFrameResize();");
				element.appendChild(resizeScript);
			}
			catch (Exception ex) {
				// Ignore
			}
		}
	}
}
