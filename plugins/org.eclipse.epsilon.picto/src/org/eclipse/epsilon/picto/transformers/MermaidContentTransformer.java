/*********************************************************************
* Copyright (c) 2020 The University of York.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.picto.transformers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.eclipse.epsilon.common.util.OperatingSystem;
import org.eclipse.epsilon.eol.tools.EolSystem;
import org.eclipse.epsilon.picto.PictoView;
import org.eclipse.epsilon.picto.ViewContent;

public class MermaidContentTransformer implements ViewContentTransformer {

	@Override
	public boolean canTransform(ViewContent content) {
		return "mermaid".equals(content.getFormat().toLowerCase());
	}

	@Override
	public String getLabel(ViewContent content) {
		return "Mermaid";
	}

	@Override
	public ViewContent transform(ViewContent content, PictoView pictoView) throws Exception {
		String html = "<div>" +
			"<script src=\"https://cdnjs.cloudflare.com/ajax/libs/mermaid/7.1.2/mermaid.min.js\"></script>\n" + 
			"<script>\n" + "mermaid.initialize({startOnLoad:true});\n" + "</script>\n"+
			"<div class=\"mermaid\">\n" + content.getText() + "</div></div>";
		
		return new ViewContent("svg", html, content.getFile(), content.getLayers(), content.getPatches(), content.getBaseUris());
	}
	
	/**
	 * 
	 * @param mmd The Mermaid as plain text.
	 * @return The created SVG.
	 * @throws IOException
	 */
	public static Path mermaidToSvg(String mmd) throws IOException {
		return mermaidToSvg(Files.write(Files.createTempFile("mermaid", ".mm"), mmd.getBytes()));
	}
	
	public static Path mermaidToSvg(Path mmd) throws IOException {
		Path svgTmp = mmd.getParent().resolve(mmd.getFileName()+".svg");
		try {
			Path program = Paths.get(System.getProperty("user.home"))
				.resolve("node_modules").resolve(".bin").resolve(
					OperatingSystem.isWindows() ? "mmdc.cmd" : "mmdc"
				);
			
			String[] commands = {program+"", "-i", mmd+"", "-o", svgTmp+""};
			if (EolSystem.executeNativeAsync(commands).waitFor() == 0) {
				return svgTmp;
			}
			else {
				throw new IOException(
					"Failed to execute "+program
					+ " with input path "+mmd
					+ "and output path "+svgTmp
				);
			}
		}
		catch (InterruptedException ie) {
			throw new IOException(ie);
		}
	}
	
}
