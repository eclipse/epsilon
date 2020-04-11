package org.eclipse.epsilon.picto.transformers.elements;

import org.eclipse.epsilon.picto.PictoView;
import org.eclipse.epsilon.picto.ViewContent;

public abstract class AbstractHtmlElementTransformer implements HtmlElementTransformer {
	
	protected PictoView picto;
	protected ViewContent viewContent;
	
	@Override
	public void setPictoView(PictoView picto) {
		this.picto = picto;
	}
	
	@Override
	public void setViewContent(ViewContent viewContent) {
		this.viewContent = viewContent;
	}
}
