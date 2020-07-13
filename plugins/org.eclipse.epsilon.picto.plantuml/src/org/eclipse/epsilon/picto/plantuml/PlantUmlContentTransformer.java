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
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import org.eclipse.epsilon.picto.PictoView;
import org.eclipse.epsilon.picto.ViewContent;
import org.eclipse.epsilon.picto.transformers.ViewContentTransformer;

import net.sourceforge.plantuml.FileFormat;
import net.sourceforge.plantuml.FileFormatOption;
import net.sourceforge.plantuml.SourceStringReader;

public class PlantUmlContentTransformer implements ViewContentTransformer {

	@Override
	public boolean canTransform(ViewContent content) {
		return "plantuml".equalsIgnoreCase(content.getFormat());
	}

	@Override
	public String getLabel(ViewContent content) {
		return "Plant UML";
	}

	@Override
	public ViewContent transform(ViewContent content, PictoView pictoView) throws Exception {
		SourceStringReader reader = new SourceStringReader(content.getText());
		try (ByteArrayOutputStream os = new ByteArrayOutputStream()) {
			reader.outputImage(os, new FileFormatOption(FileFormat.SVG));
			String svg = new String(os.toByteArray(), Charset.forName("UTF-8"));
			return new ViewContent("svg", svg, content.getFile(), content.getLayers(), content.getPatches(), content.getBaseUris());
		}
	}
	
	/**
	 * Converts PlantUML diagram to static SVG file.
	 * 
	 * @param plant The Plant UML description.
	 * @return The location of the generated SVG.
	 * @throws IOException If writing to file fails.
	 */
	public static Path plantumlToSvg(String plant) throws IOException {
		SourceStringReader reader = new SourceStringReader(plant);
		try (ByteArrayOutputStream os = new ByteArrayOutputStream()) {
			reader.outputImage(os, new FileFormatOption(FileFormat.SVG));
			return Files.write(Files.createTempFile("plantuml", ".svg"), os.toByteArray());
		}
	}
}
