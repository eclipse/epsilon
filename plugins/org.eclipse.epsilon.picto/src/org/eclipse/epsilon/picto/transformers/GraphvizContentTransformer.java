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

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.eclipse.epsilon.common.util.OperatingSystem;
import org.eclipse.epsilon.picto.PictoView;
import org.eclipse.epsilon.picto.ViewContent;

public class GraphvizContentTransformer implements ViewContentTransformer {
	
	@Override
	public boolean canTransform(ViewContent content) {
		return content.getFormat().toLowerCase().startsWith("graphviz-");
	}

	@Override
	public ViewContent transform(ViewContent content, PictoView pictoView) throws Exception {
		String[] parts = content.getFormat().split("-");
		
		String program = parts[1].trim();
		String imageType = "svg";
		if (parts.length > 2) {
			imageType = parts[2];
		}
		
		Path temp =
			Files.createTempFile(Files.createTempDirectory("picto"), "picto-renderer", ".dot").toAbsolutePath(),
			image = Paths.get(temp + "." + imageType).toAbsolutePath(),
			log = Paths.get(temp + ".log").toAbsolutePath();
		
		Files.write(temp, content.getText().getBytes());
		
		if (OperatingSystem.isMac()) {
			program = "/usr/local/bin/" + program;
		}
		else if (OperatingSystem.isUnix()) {
			program = "/usr/bin/" + program;
		}
		/*else {
			throw new UnsupportedOperationException(program + " is not supported on "+OperatingSystem.getOSFamily());
		}*/
		
		ProcessBuilder pb = new ProcessBuilder(program, "-T" + imageType, temp.toString(), "-o", image.toString());
		pb.redirectError(log.toFile());
		pb.start().waitFor();
		
		Path viewFile;
		String format;
		
		if (image.toFile().exists()) {
			viewFile = image;
			format = "svg";
		}
		else {
			viewFile = log;
			format = "exception";
		}
		return new ViewContent(format, new String(Files.readAllBytes(viewFile)), content.getFile(), content.getLayers(), content.getPatches(), content.getBaseUris());
	}
	
	@Override
	public String getLabel(ViewContent content) {
		return "Graphviz";
	}
	
}
