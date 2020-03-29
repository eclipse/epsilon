/*********************************************************************
* Copyright (c) 2020 The University of York.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.picto.plantuml;

import java.io.ByteArrayOutputStream;
import java.nio.charset.Charset;

import org.eclipse.epsilon.picto.ViewContent;
import org.eclipse.epsilon.picto.ViewRenderer;
import org.eclipse.epsilon.picto.transformers.ViewContentTransformer;

import net.sourceforge.plantuml.FileFormat;
import net.sourceforge.plantuml.FileFormatOption;
import net.sourceforge.plantuml.SourceStringReader;

public class PlantUmlContentTransformer implements ViewContentTransformer {

	@Override
	public boolean canTransform(ViewContent content) {
		return content.getFormat().equals("plantuml");
	}

	@Override
	public String getLabel(ViewContent content) {
		return "Plant UML";
	}

	@Override
	public ViewContent transform(ViewContent content, ViewRenderer renderer) throws Exception {
		SourceStringReader reader = new SourceStringReader(content.getText());
		try (ByteArrayOutputStream os = new ByteArrayOutputStream()) {
			reader.outputImage(os, new FileFormatOption(FileFormat.SVG));
			String svg = new String(os.toByteArray(), Charset.forName("UTF-8"));
			return new ViewContent("svg", svg, content.getLayers(), content.getPatches());
		}
	}
}
