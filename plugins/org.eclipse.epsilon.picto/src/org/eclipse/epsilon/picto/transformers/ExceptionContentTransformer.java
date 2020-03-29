/*********************************************************************
* Copyright (c) 2008 The University of York.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
**********************************************************************/
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
		return new ViewContent("html", renderer.getZoomableVerbatim(content.getText()), content.getLayers(), content.getPatches());
	}
	
	public ViewContent getViewContent(Exception ex, ViewRenderer renderer) {
		return transform(new ViewContent("exception", ex.getMessage(), Collections.emptyList(), Collections.emptyList()), renderer);
	}
	
	@Override
	public String getLabel(ViewContent content) {
		return "Exception";
	}
	
}
