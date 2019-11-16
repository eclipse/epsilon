package org.eclipse.epsilon.picto.source;

public abstract class GraphvizSource extends SimpleSource {

	@Override
	public String getFormat() {
		return "graphviz-" + getFileExtension();
	}
	
}
