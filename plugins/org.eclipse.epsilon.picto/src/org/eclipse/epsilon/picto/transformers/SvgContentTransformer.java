package org.eclipse.epsilon.picto.transformers;

import org.eclipse.epsilon.picto.ViewContent;
import org.eclipse.epsilon.picto.ViewRenderer;

public class SvgContentTransformer implements ViewContentTransformer {

	@Override
	public boolean canTransform(ViewContent content) {
		return content.getFormat().equals("svg");
	}

	@Override
	public ViewContent transform(ViewContent content, ViewRenderer renderer) throws Exception {
		return new ViewContent("html", "<html><body style=\"zoom:" + renderer.getZoom() + "\">" + content.getText() + "</body></html>", content.getLayers(), content.getPatches());
	}
	
	@Override
	public String getLabel(ViewContent content) {
		return "SVG";
	}
	
}
