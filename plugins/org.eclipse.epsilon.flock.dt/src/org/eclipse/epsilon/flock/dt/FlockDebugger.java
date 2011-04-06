package org.eclipse.epsilon.flock.dt;

import org.eclipse.epsilon.eol.dt.debug.EolDebugger;
import org.eclipse.epsilon.flock.parse.FlockParser;

public class FlockDebugger extends EolDebugger {
	
	public FlockDebugger() {
		super();
		expressionOrStatementBlockContainers.add(FlockParser.GUARD);
		expressionOrStatementBlockContainers.add(FlockParser.MIGRATE);
		structuralBlocks.add(FlockParser.MIGRATE);
		structuralBlocks.add(FlockParser.DELETE);
		structuralBlocks.add(FlockParser.RETYPE);
	}
	
}
