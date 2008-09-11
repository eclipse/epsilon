/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.dt.exeed.modelink;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.eclipse.core.resources.IFile;
import org.eclipse.epsilon.common.dt.util.LogUtil;
import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

public class ModeLink {
	
	protected List<LinkedModel> linkedModels = new ArrayList();
	protected boolean threeWay = true;
	
	public void load(IFile file) throws Exception {
		SAXBuilder builder = new SAXBuilder();
		Document doc = builder.build(file.getContents());
		Element root = doc.getDocument().getRootElement();
		linkedModels.clear();
		threeWay = ! root.getAttributeValue("threeWay","").equalsIgnoreCase("false");
		
		ListIterator li = root.getChildren().listIterator();

		while (li.hasNext()) {
			Object next = li.next();
			if (next instanceof Element) {
				Element el = (Element) next;
				linkedModels.add(new LinkedModel(el.getAttributeValue("path"), el.getAttributeValue("position")));
			}
		}
	}
	
	public void store(IFile file) {
		
		Document doc = new Document();
		Element root = new Element("modelink");
		root.getAttributes().add(new Attribute("threeWay", threeWay + ""));
		doc.setRootElement(root);
		
		for (LinkedModel m : linkedModels) {
			Element el = new Element("model");
			el.getAttributes().add(new Attribute("path", m.getPath()));
			el.getAttributes().add(new Attribute("position", m.getPosition().toString()));
			root.addContent(el);
		}
		
		try {
			new StoreXmlDocumentOperation(doc, file).run(null);
			file.refreshLocal(0, null);
		} catch (Exception e) {
			LogUtil.log(e);
		}
	}

	public List<LinkedModel> getLinkedModels() {
		return linkedModels;
	}

	public boolean isThreeWay() {
		return threeWay;
	}

	public void setThreeWay(boolean threeWay) {
		this.threeWay = threeWay;
	}
	
	
}
