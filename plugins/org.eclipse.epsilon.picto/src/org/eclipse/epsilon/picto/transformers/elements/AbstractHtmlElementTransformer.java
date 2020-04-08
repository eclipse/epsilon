package org.eclipse.epsilon.picto.transformers.elements;

import org.eclipse.epsilon.picto.PictoView;

public abstract class AbstractHtmlElementTransformer implements HtmlElementTransformer {
	
	protected PictoView picto;
	
	@Override
	public void setPictoView(PictoView picto) {
		this.picto = picto;
	}
	
}
