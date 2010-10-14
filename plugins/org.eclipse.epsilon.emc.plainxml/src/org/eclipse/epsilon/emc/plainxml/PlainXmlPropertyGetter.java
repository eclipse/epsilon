package org.eclipse.epsilon.emc.plainxml;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.introspection.java.JavaPropertyGetter;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class PlainXmlPropertyGetter extends JavaPropertyGetter {
	
	protected PlainXmlModel model;
	
	public PlainXmlPropertyGetter(PlainXmlModel model) {
		this.model = model;
	}
	
	@Override
	public Object invoke(Object object, String property)
			throws EolRuntimeException {

		if(object instanceof Element) {
			
			final Element e = (Element) object;
			
			if ("children".equals(property)) {
				return DomUtil.getChildren(e);
			}
			
			if ("text".equals(property)) {
				return e.getTextContent();
			}
			
			PlainXmlProperty p = PlainXmlProperty.parse(property);
			
			if (p != null) {
			
				if (p.isAttribute()) {
					return p.cast(e.getAttribute(p.getProperty()));
				}
				else if (p.isText()) {
					return p.cast(e.getTextContent());
				}
				else if (p.isReference()) {
					
					for (final Binding binding : BindingMatcher.getMatchingBindings(model, e, p.getProperty())) {
						if (binding.isMany()) {
							LoudList<Element> referenced = new LoudList<Element>();
							String[] referencedIds = e.getAttribute(p.getProperty()).split(",");
							for (Object o : model.allContents()) {
								Element candidate = (Element) o;
								if (TagMatcher.matches(candidate, binding.getTargetTag())) {
									for (String referencedId : referencedIds) {
										if (candidate.getAttribute(binding.getTargetAttribute()).equals(referencedId.trim())) {
											referenced.add(candidate);
										}
									}
								}	
							}
							
							referenced.addListener(new LoudListChangeListener<Element>() {

								@Override
								public void listChanged(LoudList<Element> list) {
									String newAttributeValue = "";
									Iterator<Element> li = list.iterator();
									while (li.hasNext()) {
										Element i = li.next();
										newAttributeValue = newAttributeValue + 
											i.getAttribute(binding.getTargetAttribute());
										if (li.hasNext()) {
											newAttributeValue += ", ";
										}
									}
									e.setAttribute(binding.getSourceAttribute(), newAttributeValue);
								}
							});
							
							return referenced;
						}
						else {
							String referencedId = e.getAttribute(p.getProperty());

							for (Object o : model.allContents()) {
								Element candidate = (Element) o;
								if (candidate.getTagName().matches(binding.getTargetTag())) {
									if (candidate.getAttribute(binding.getTargetAttribute()).equals(referencedId.trim())) {
										return candidate;
									}						
								}	
							}
						}
					}
				}
			}
			else {
				List<Element> children = DomUtil.getChildren(e);
				List<Element> result = new ArrayList<Element>();
				
				// Look for elements with this specific tag name
				for (Element child : children) {
					if (child.getTagName().equals(p.getProperty())) {
						result.add(child);
					}
				}
				
				if (p.isMany()) {
					return result;
				}
				else if (result.size() > 0) {
					return result.get(0);
				}
				else {
					return null;
				}
				
			}	
		}
		
		return super.invoke(object, property);
		
	}

}
