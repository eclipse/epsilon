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
import java.nio.file.Path;
import java.nio.file.Paths;
import org.eclipse.epsilon.common.util.OperatingSystem;
import org.eclipse.epsilon.picto.PictoView;
import org.eclipse.epsilon.picto.ViewContent;

public class MermaidContentTransformer implements ViewContentTransformer {

	@Override
	public boolean canTransform(ViewContent content) {
		return "mermaid".equalsIgnoreCase(content.getFormat());
	}

	@Override
	public String getLabel(ViewContent content) {
		return "Mermaid";
	}

	@Override
	public ViewContent transform(ViewContent content, PictoView pictoView) throws Exception {
		String html = "<div>" +
			"<script src=\"https://cdnjs.cloudflare.com/ajax/libs/mermaid/8.6.0/mermaid.min.js\"/>\n" + 
			"<script>\n" + "mermaid.initialize({startOnLoad:true});\n" + "</script>\n"+
			"<div class=\"mermaid\">\n" + content.getText() + "</div></div>";
		
		return new ViewContent("svg", html, content);
	}
	
	
	/**
	 * 
	 * @param mmd The Mermaid as plain text.
	 * @return The SVG as an XML string.
	 * @throws IOException 
	 */
	public static String mermaidToRawSvg(String mmd) throws IOException {
		return mermaidToRawSvg(ExternalContentTransformation.createTempFile("mm", mmd.getBytes()));
	}
	
	/**
	 * 
	 * @param mmd The Mermaid file.
	 * @return The SVG as an XML string.
	 * @throws IOException
	 */
	public static String mermaidToRawSvg(Path mmd) throws IOException {
		return new String(mermaid(mmd, "svg").call());
	}
	
	/**
	 * 
	 * @param mmd The Mermaid as plain text.
	 * @param ext The output file extension.
	 * @return The image as a file.
	 * @throws IOException 
	 */
	public static Path mermaidToImage(String mmd, String ext) throws IOException {
		return mermaidToImage(ExternalContentTransformation.createTempFile("mm", mmd.getBytes()), ext);
	}
	
	/**
	 * 
	 * @param mmd The Mermaid file.
	 * @param ext The output file extension.
	 * @return The path to the output file.
	 * @throws IOException If invoking the CLI tool goes wrong.
	 */
	public static Path mermaidToImage(Path mmd, String ext) throws IOException {
		ExternalContentTransformation ect = mermaid(mmd, ext);
		ect.call();
		return ect.getOutputFile();
	}
	
	protected static ExternalContentTransformation mermaid(Path mmd, String ext) {
		Path imgTmp = mmd.getParent().resolve(mmd.getFileName()+"."+ext);
		String program = Paths.get(System.getProperty("user.home"))
			.resolve("node_modules").resolve(".bin").resolve(
				OperatingSystem.isWindows() ? "mmdc.cmd" : "mmdc"
			).toString();
			
		return new ExternalContentTransformation(
			imgTmp, program, "-i", mmd, "-o", imgTmp
		);
	}
	
}
