package org.eclipse.epsilon.eml.dt.launching;

import org.eclipse.epsilon.eml.parse.EmlParser;
import org.eclipse.epsilon.etl.dt.launching.EtlDebugger;

public class EmlDebugger extends EtlDebugger {

	public EmlDebugger() {
		super();
		expressionOrStatementBlockContainers.add(EmlParser.MERGE);
		structuralBlocks.add(EmlParser.MERGE);
	}
	
	
}
