package org.eclipse.epsilon.epl.dt.launching;

import org.eclipse.epsilon.eol.dt.debug.EolDebugger;
import org.eclipse.epsilon.epl.parse.EplParser;

public class EplDebugger extends EolDebugger {
	
	public EplDebugger() {
		super();
		expressionOrStatementBlockContainers.add(EplParser.DO);
		expressionOrStatementBlockContainers.add(EplParser.GUARD);
		expressionOrStatementBlockContainers.add(EplParser.DOMAIN);
		expressionOrStatementBlockContainers.add(EplParser.MATCH);
		expressionOrStatementBlockContainers.add(EplParser.NOMATCH);
		structuralBlocks.add(EplParser.PATTERN);
	}
	
}
