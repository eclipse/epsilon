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
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Path;
import org.eclipse.epsilon.common.util.StringUtil;
import org.eclipse.epsilon.picto.PictoView;
import org.eclipse.epsilon.picto.ViewContent;
import org.eclipse.epsilon.picto.transformers.ExternalContentTransformation;
import org.eclipse.epsilon.picto.transformers.ViewContentTransformer;
import net.sourceforge.plantuml.FileFormat;
import net.sourceforge.plantuml.FileFormatOption;
import net.sourceforge.plantuml.SourceStringReader;

public class PlantUmlContentTransformer implements ViewContentTransformer {

	@Override
	public boolean canTransform(ViewContent content) {
		return StringUtil.isOneOf(content.getFormat().toLowerCase(), "plantuml", "puml");
	}

	@Override
	public String getLabel(ViewContent content) {
		return "Plant UML";
	}

	@Override
	public ViewContent transform(ViewContent content, PictoView pictoView) throws Exception {
		return new ViewContent("svg", plantumlToSvg(content.getText()), content);
	}
	
	/**
	 * Converts PlantUML diagram to SVG as a String.
	 * 
	 * @param plant The Plant UML description.
	 * @return The generated SVG as an XML string.
	 * @throws IOException If writing to file fails.
	 */
	public static String plantumlToSvg(String plant) throws IOException {
		SourceStringReader reader = new SourceStringReader(plant);
		try (ByteArrayOutputStream os = new ByteArrayOutputStream()) {
			reader.outputImage(os, new FileFormatOption(FileFormat.SVG));
			String rawOutput = new String(os.toByteArray(), Charset.forName("UTF-8"));
			return rawOutput.replaceAll("<!--[\\s\\S]*?-->", "");
		}
	}
	
	/**
	 * Converts PlantUML diagram to a temporary PNG file.
	 * 
	 * @param plant The Plant UML description.
	 * @return The path to the generated PNG.
	 * @throws IOException If writing to file fails.
	 */
	public static Path plantumlToPng(String plant) throws IOException {
		SourceStringReader reader = new SourceStringReader(plant);
		Path png = ExternalContentTransformation.createTempFile("png", null);
		try (FileOutputStream os = new FileOutputStream(png.toFile())) {
			reader.outputImage(os, new FileFormatOption(FileFormat.PNG));
		}
		return png;
	}
}
