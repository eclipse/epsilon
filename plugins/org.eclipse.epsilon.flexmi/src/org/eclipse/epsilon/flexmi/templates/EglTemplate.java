/*********************************************************************
* Copyright (c) 2008 The University of York.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.flexmi.templates;

import java.net.URI;
import java.util.List;

import org.eclipse.epsilon.egl.EglTemplateFactory;
import org.eclipse.epsilon.egl.EglTemplateFactoryModuleAdapter;
import org.eclipse.epsilon.eol.execute.context.FrameType;
import org.eclipse.epsilon.flexmi.FlexmiResource;
import org.eclipse.epsilon.flexmi.xml.Xml;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class EglTemplate extends DynamicTemplate {

	protected EglTemplateFactoryModuleAdapter module;

	public EglTemplate(Element element, FlexmiResource resource, URI uri) {
		super(element, resource, uri);
	}

	@Override
	public List<Element> getApplication(Element call) {
		try {
			if (module == null) {
				module = new EglTemplateFactoryModuleAdapter(new EglTemplateFactory());
				module.parse(content.getTextContent().trim(), uri);
				if (!module.getParseProblems().isEmpty())
					throw new RuntimeException(module.getParseProblems().get(0).toString());
			}

			module.getContext().getFrameStack().enterLocal(FrameType.UNPROTECTED, module);

			prepareModule(module, call);
			
			String xml = "<?xml version=\"1.0\"?><root>" + (module.execute() + "").trim() + "</root>";
			Document document = Xml.parse(xml);
			replaceSlots(call, document.getDocumentElement());

			module.getContext().getFrameStack().leaveLocal(module);

			// reset for next template application
			module.getCurrentTemplate().reset();

			return Xml.getChildren(document.getDocumentElement());
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
