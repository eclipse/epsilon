package org.eclipse.epsilon.picto.transformers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.eclipse.epsilon.common.util.OperatingSystem;
import org.eclipse.epsilon.picto.ViewContent;
import org.eclipse.epsilon.picto.ViewRenderer;

public class GraphvizContentTransformer implements ViewContentTransformer {
	
	protected File tempDir;
	
	@Override
	public boolean canTransform(ViewContent content) {
		return content.getFormat().startsWith("graphviz-");
	}

	@Override
	public ViewContent transform(ViewContent content, ViewRenderer renderer) throws Exception {
		String[] parts = content.getFormat().split("-");
		
		String program = parts[1].trim();
		String imageType = "svg";
		if (parts.length > 2) {
			imageType = parts[2];
		}
		
		File temp = Files.createTempFile(getTempDir().toPath(), "picto-renderer", ".dot").toFile(); 
		
		File image = new File(temp.getAbsolutePath() + "." + imageType);
		File log = new File(temp.getAbsolutePath() + ".log" );
		
		Files.write(Paths.get(temp.toURI()), content.getText().getBytes());
		
		if (OperatingSystem.isMac()) {
			program = "/usr/local/bin/" + program;
		}
		else if (OperatingSystem.isUnix()) {
			program = "/usr/bin/" + program;
		}
		
		ProcessBuilder pb = new ProcessBuilder(new String[] {program, "-T" + imageType, temp.getAbsolutePath(), "-o", image.getAbsolutePath()});
		pb.redirectError(log);
		Process p = pb.start();
		p.waitFor();
		
		if (image.exists()) {
			return new ViewContent("svg", new String(Files.readAllBytes(image.toPath())), content.getPatches());
		}
		else {
			return new ViewContent("exception", new String(Files.readAllBytes(log.toPath())), content.getPatches());
		}
	}
	
	protected File getTempDir() {
		try { tempDir = Files.createTempDirectory("picto").toFile(); } catch (IOException e) {}
		return tempDir;
	}
	
	@Override
	public String getLabel(ViewContent content) {
		return "Graphviz";
	}
	
}
