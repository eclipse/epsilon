package org.eclipse.epsilon.etl.dt.launching;

import org.eclipse.epsilon.eol.dt.debug.EolDebugger;
import org.eclipse.epsilon.etl.parse.EtlParser;

public class EtlDebugger extends EolDebugger {
	
	public EtlDebugger() {
		super();
		expressionOrStatementBlockContainers.add(EtlParser.TRANSFORM);
		expressionOrStatementBlockContainers.add(EtlParser.GUARD);
		expressionOrStatementBlockContainers.add(EtlParser.PRE);
		expressionOrStatementBlockContainers.add(EtlParser.POST);
		structuralBlocks.add(EtlParser.TRANSFORM);
	}
	
}
