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

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.epsilon.picto.ViewContent;
import org.eclipse.epsilon.picto.ViewTree;
import org.w3c.dom.Element;

public class PictoViewElementTransformer extends ReplacingElementTransformer {
	
	@Override
	public String getXPath() {
		return "//*[local-name() = 'picto-view']";
	}
	
	@Override
	public void transform(Element element) {
		String path = element.getAttribute("path");
		if (path != null) {
			ViewTree viewTree = picto.getViewTree().forPath(
					Arrays.asList(("," + path).split(",")).stream().map(s -> s.trim()).collect(Collectors.toList()));
			if (viewTree != null) {

				List<ViewContent> contents = viewTree.getContents(picto);

				ViewContent svgContent = contents.stream().filter(c -> c.getFormat().equals("svg")).findAny()
						.orElse(null);
				
				if (svgContent != null) {
					replace(element, svgContent, true);
				}
				else {
					replace(element, contents.get(contents.size() - 1), false);
				}
				
				/*
				if (svgContent != null) {
					try {
						Document document = new HtmlContentTransformer().parse(svgContent.getText());
						Element svg = document.getDocumentElement();
						element.getOwnerDocument().importNode(svg, true);
						element.getOwnerDocument().adoptNode(svg);
						element.getParentNode().replaceChild(svg, element);
						
						NamedNodeMap attributes = element.getAttributes();
						for (int i=0;i<attributes.getLength();i++) {
							Node node = attributes.item(i);
							svg.setAttribute(node.getNodeName(), node.getNodeValue());
						}
						
						return;
					} catch (Exception e) {
						element.getOwnerDocument().renameNode(element, element.getNamespaceURI(), "b");
						element.setTextContent(e.getMessage());
						return;
					}
				} else {
					try {
						ViewContent htmlContent = contents.get(contents.size() - 1);
						File temp = Files.createTempFile("picto-iframe", ".html").toFile();
						Files.write(Paths.get(temp.toURI()), htmlContent.getText().getBytes());
						element.getOwnerDocument().renameNode(element, element.getNamespaceURI(), "iframe");
						element.setAttribute("src", temp.getAbsolutePath());
					} catch (Exception ex) {}
				}*/
				
			}
		}
		
	}
	
	
}