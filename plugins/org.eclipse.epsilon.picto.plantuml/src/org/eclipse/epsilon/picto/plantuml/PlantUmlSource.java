package org.eclipse.epsilon.picto.plantuml;

import org.eclipse.epsilon.picto.source.VerbatimSource;

public class PlantUmlSource extends VerbatimSource {

	public PlantUmlSource() {}

	@Override
	public String getFormat() {
		return "plantuml";
	}

	@Override
	public String getFileExtension() {
		return "puml";
	}

}
