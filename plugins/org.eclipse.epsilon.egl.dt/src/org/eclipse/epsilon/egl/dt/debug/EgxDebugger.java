package org.eclipse.epsilon.egl.dt.debug;

import org.eclipse.epsilon.egl.parse.EgxParser;
import org.eclipse.epsilon.eol.dt.debug.EolDebugger;

public class EgxDebugger extends EolDebugger {
	
	public EgxDebugger() {
		super();
		expressionOrStatementBlockContainers.add(EgxParser.GENERATE);
		expressionOrStatementBlockContainers.add(EgxParser.GUARD);
		expressionOrStatementBlockContainers.add(EgxParser.PRE);
		expressionOrStatementBlockContainers.add(EgxParser.POST);
		expressionOrStatementBlockContainers.add(EgxParser.TEMPLATE);
		expressionOrStatementBlockContainers.add(EgxParser.OVERWRITE);
		expressionOrStatementBlockContainers.add(EgxParser.TARGET);
		expressionOrStatementBlockContainers.add(EgxParser.PROTECTREGIONS);
		
		structuralBlocks.add(EgxParser.GENERATE);
	}
	
}
