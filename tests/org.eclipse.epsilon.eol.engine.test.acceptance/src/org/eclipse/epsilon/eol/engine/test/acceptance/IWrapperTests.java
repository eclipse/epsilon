package org.eclipse.epsilon.eol.engine.test.acceptance;

import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.execute.operations.contributors.IWrapper;
import org.eclipse.epsilon.test.util.MultilineCommentReader;
import org.junit.Test;

public class IWrapperTests {
	
	@Test
	public void testWrapped() throws Exception {
		
		EolModule module = new EolModule();
		module.parse(new MultilineCommentReader().readNextComment());
		module.getContext().getFrameStack().put(Variable.createReadOnlyVariable("d", new DummyWrapper(new Dummy())));
		
		/*
		 	d.stringAttr = "foo";
		 	assertEquals(d.stringAttr, "foo");
		 	d.boolAttr = false;
		 	assertEquals(d.boolAttr, false);
		 */
		
		module.execute();
		
		
	}
	
	public class Dummy {
		
		protected String stringAttr;
		protected boolean boolAttr;
		
		public String getStringAttr() {
			return stringAttr;
		}

		public void setStringAttr(String stringAttr) {
			this.stringAttr = stringAttr;
		}

		public boolean isBoolAttr() {
			return boolAttr;
		}

		public void setBoolAttr(boolean boolAttr) {
			this.boolAttr = boolAttr;
		}

		
	}
	
	public class DummyWrapper implements IWrapper {
		protected Dummy dummy;

		public DummyWrapper(Dummy dummy) {
			this.dummy = dummy;
		}
		
		public Object getWrapped() {
			return dummy;
		}
		
		
	}
}
