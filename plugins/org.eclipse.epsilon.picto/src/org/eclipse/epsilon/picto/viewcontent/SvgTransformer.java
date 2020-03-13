package org.eclipse.epsilon.picto.viewcontent;

import org.eclipse.epsilon.picto.ViewRenderer;

public class SvgTransformer implements ViewContentTransformer {

	@Override
	public boolean canTransform(ViewContent content) {
		return content.getFormat().equals("svg");
	}

	@Override
	public ViewContent transform(ViewContent content, ViewRenderer renderer) throws Exception {
		return new ViewContent("html", "<html><body style=\"zoom:" + renderer.getZoom() + "\">" + content.getText() + "</body></html>");
	}

}
