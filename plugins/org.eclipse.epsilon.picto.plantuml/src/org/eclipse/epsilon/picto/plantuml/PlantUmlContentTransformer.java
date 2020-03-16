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
		final ByteArrayOutputStream os = new ByteArrayOutputStream();
		reader.outputImage(os, new FileFormatOption(FileFormat.SVG));
		os.close();
		String svg = new String(os.toByteArray(), Charset.forName("UTF-8"));
		return new ViewContent("svg", svg);
	}

}
