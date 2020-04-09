package org.eclipse.epsilon.picto.transformers.elements;

import org.eclipse.epsilon.picto.PictoView;
import org.w3c.dom.Element;

public interface HtmlElementTransformer {
	
	public String getXPath();
	public void transform(Element element);
	public void setPictoView(PictoView picto);
	
}