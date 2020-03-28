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

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.eclipse.epsilon.picto.ViewContent;
import org.eclipse.epsilon.picto.ViewRenderer;

public class TextContentTransformer implements ViewContentTransformer {

	@Override
	public boolean canTransform(ViewContent content) {
		return content.getFormat().equals("text");
	}

	@Override
	public ViewContent transform(ViewContent content, ViewRenderer renderer) throws Exception {
		File temp = File.createTempFile("picto-renderer", ".txt");
		Files.write(Paths.get(temp.toURI()), content.getText().getBytes());
		return new ViewContent("html", temp, content.getLayers(), content.getPatches());
	}

	@Override
	public String getLabel(ViewContent content) {
		return "Text";
	}

}
