package org.eclipse.epsilon.picto.transformers;

import java.util.Collections;

import org.eclipse.epsilon.picto.ViewContent;
import org.eclipse.epsilon.picto.ViewRenderer;

public class ExceptionContentTransformer implements ViewContentTransformer {

	@Override
	public boolean canTransform(ViewContent content) {
		return content.getFormat().equals("exception");
	}

	@Override
	public ViewContent transform(ViewContent content, ViewRenderer renderer) {
		return new ViewContent("html", "<html><body style=\"zoom:" + renderer.getZoom() + "\"><pre>" + content.getText() + "</pre></body></html>", content.getPatches());
	}
	
	public ViewContent getViewContent(Exception ex, ViewRenderer renderer) {
		return transform(new ViewContent("exception", ex.getMessage(), Collections.emptyList()), renderer);
	}
	
	@Override
	public String getLabel(ViewContent content) {
		return "Exception";
	}
	
}
