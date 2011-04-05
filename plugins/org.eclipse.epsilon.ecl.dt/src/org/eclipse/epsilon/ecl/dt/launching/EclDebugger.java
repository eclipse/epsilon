package org.eclipse.epsilon.ecl.dt.launching;

import org.eclipse.epsilon.ecl.parse.EclParser;
import org.eclipse.epsilon.eol.dt.debug.EolDebugger;

public class EclDebugger extends EolDebugger {
	
	public EclDebugger() {
		super();
		expressionOrStatementBlockContainers.add(EclParser.DO);
		expressionOrStatementBlockContainers.add(EclParser.COMPARE);
		structuralBlocks.add(EclParser.MATCH);
	}
	
}
