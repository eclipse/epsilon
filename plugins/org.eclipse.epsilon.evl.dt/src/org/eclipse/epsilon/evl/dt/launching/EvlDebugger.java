package org.eclipse.epsilon.evl.dt.launching;

import org.eclipse.epsilon.eol.dt.debug.EolDebugger;
import org.eclipse.epsilon.evl.parse.EvlParser;

public class EvlDebugger extends EolDebugger {
	
	public EvlDebugger() {
		super();
		expressionOrStatementBlockContainers.add(EvlParser.GUARD);
		expressionOrStatementBlockContainers.add(EvlParser.TITLE);
		expressionOrStatementBlockContainers.add(EvlParser.MESSAGE);
		expressionOrStatementBlockContainers.add(EvlParser.CHECK);
		expressionOrStatementBlockContainers.add(EvlParser.DO);
		structuralBlocks.add(EvlParser.CONTEXT);
		structuralBlocks.add(EvlParser.CONSTRAINT);
		structuralBlocks.add(EvlParser.CRITIQUE);
		structuralBlocks.add(EvlParser.FIX);
	}	
}
