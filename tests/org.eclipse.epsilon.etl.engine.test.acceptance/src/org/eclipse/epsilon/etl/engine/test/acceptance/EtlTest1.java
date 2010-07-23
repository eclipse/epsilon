package org.eclipse.epsilon.etl.engine.test.acceptance;

import org.eclipse.epsilon.etl.EtlModule;
import org.eclipse.epsilon.test.util.MultilineCommentReader;
import org.junit.Test;
import static org.junit.Assert.*;

public class EtlTest1 {
	
	@Test
	public void test1() throws Exception {
		
		EtlModule module = new EtlModule();
		module.parse(new MultilineCommentReader().readNextComment());
		
		/*
		 pre {
		 	// skooby.println();
		 	Foo.all.println();
		 }
		 */
		
		module.execute();
		
	}
	
}
