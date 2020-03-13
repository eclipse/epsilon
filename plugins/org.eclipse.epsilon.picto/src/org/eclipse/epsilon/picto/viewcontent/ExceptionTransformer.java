package org.eclipse.epsilon.picto.viewcontent;

import org.eclipse.epsilon.picto.ViewRenderer;

public class ExceptionTransformer implements ViewContentTransformer {

	@Override
	public boolean canTransform(ViewContent content) {
		return content.getFormat().equals("exception");
	}

	@Override
	public ViewContent transform(ViewContent content, ViewRenderer renderer) {
		return new ViewContent("html", "<html><body style=\"zoom:" + renderer.getZoom() + "\"><pre style='color:red'>" + content.getText() + "</pre></body></html>");
	}
	
	public ViewContent getViewContent(Exception ex, ViewRenderer renderer) {
		return transform(new ViewContent("exception", ex.getMessage()), renderer);
	}

}
