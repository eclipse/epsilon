package org.eclipse.epsilon.picto.viewcontent;

import org.eclipse.epsilon.picto.ViewRenderer;

public interface ViewContentTransformer {
	
	public boolean canTransform(ViewContent content);
	
	public ViewContent transform(ViewContent content, ViewRenderer renderer) throws Exception;
	
}
