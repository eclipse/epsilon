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

import org.eclipse.epsilon.picto.PictoView;
import org.eclipse.epsilon.picto.ViewContent;

public class TextContentTransformer implements ViewContentTransformer {

	@Override
	public boolean canTransform(ViewContent content) {
		return content.getFormat().equals("text");
	}

	@Override
	public ViewContent transform(ViewContent content, PictoView pictoView) throws Exception {
		return new ViewContent("html", pictoView.getViewRenderer().getVerbatim(content.getText()), content.getFile(), content.getLayers(), content.getPatches(), content.getBaseUris());
	}

	@Override
	public String getLabel(ViewContent content) {
		return "Text";
	}
	
	

}
