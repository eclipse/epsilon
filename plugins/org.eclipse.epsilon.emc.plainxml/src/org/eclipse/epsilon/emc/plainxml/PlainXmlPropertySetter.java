/*******************************************************************************
 * Copyright (c) 2012 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.emc.plainxml;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.introspection.java.JavaPropertySetter;
import org.eclipse.epsilon.eol.execute.operations.contributors.CollectionOperationContributor;
import org.w3c.dom.Element;

public class PlainXmlPropertySetter extends JavaPropertySetter {
	
	protected PlainXmlModel model = null;
	
	public PlainXmlPropertySetter(PlainXmlModel model) {
		this.model = model;
	}
	
	@Override
	public void invoke(Object value) throws EolRuntimeException {
		
		if (object instanceof Element) {
			Element e = (Element) object;
			
			if ("text".equals(property)) {
				e.setTextContent(String.valueOf(value));
				return;
			}
			
			PlainXmlProperty p = PlainXmlProperty.parse(property);
			if (p!=null) {
				if (p.isAttribute()) {
					e.setAttribute(p.getProperty(), p.cast(String.valueOf(value)) + "");
					return;
				}
				else if (p.isText()) {
					e.setTextContent(p.cast(String.valueOf(value)) + "");
					return;
				}
				else if (p.isReference()) {
					String sourceTag = e.getTagName();
					
					for (Binding binding : model.getBindings()) {
						if (sourceTag.matches(binding.getSourceTag()) && p.getProperty().matches(binding.getSourceAttribute())) {
							String sourceAttribute = p.getProperty();
							if (binding.isMany()) {
								
								ArrayList<String> referenceIds = new ArrayList<String>();
								
								Collection values = null;
								if (value instanceof Collection) {
									values = (Collection) value;
								}
								else {
									values = new ArrayList();
									values.add(value);
								}
								
								for (Object o : values) {
									Element candidate = (Element) o;
									if (candidate.getTagName().matches(binding.getTargetTag())) {
										String referenceId = candidate.getAttribute(binding.getTargetAttribute());
										if (referenceId != null && referenceId.trim().length() > 0) {
											referenceIds.add(referenceId);
										}
									}	
								}
								e.setAttribute(sourceAttribute, new CollectionOperationContributor(referenceIds).concat(", "));
								return;
							}
							else {
								if (value instanceof Element) {
									Element candidate = (Element) value;
									if (candidate.getTagName().matches(binding.getTargetTag())) {
										String referenceId = candidate.getAttribute(binding.getTargetAttribute());
										if (referenceId != null && referenceId.trim().length() > 0) {
											e.setAttribute(sourceAttribute, referenceId);
											return;
										}					
									}	
								}
							}
						}
					}

				}
			}
			
		}
		
		super.invoke(value);
	}
	
}
