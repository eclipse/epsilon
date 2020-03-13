package org.eclipse.epsilon.picto.viewcontent;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.eclipse.epsilon.picto.ViewRenderer;

public class TextTransformer implements ViewContentTransformer {

	@Override
	public boolean canTransform(ViewContent content) {
		return content.getFormat().equals("text");
	}

	@Override
	public ViewContent transform(ViewContent content, ViewRenderer renderer) throws Exception {
		File temp = File.createTempFile("picto-renderer", ".txt");
		Files.write(Paths.get(temp.toURI()), content.getText().getBytes());
		return new ViewContent(temp);
	}

}
