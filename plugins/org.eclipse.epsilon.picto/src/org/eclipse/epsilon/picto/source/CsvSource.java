package org.eclipse.epsilon.picto.source;

public class CsvSource extends VerbatimSource {

	@Override
	public String getFormat() {
		return getFileExtension();
	}

	@Override
	public String getFileExtension() {
		return "csv";
	}
}
