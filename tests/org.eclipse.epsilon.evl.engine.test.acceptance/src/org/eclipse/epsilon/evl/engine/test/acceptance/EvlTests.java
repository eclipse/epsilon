package org.eclipse.epsilon.evl.engine.test.acceptance;

import java.io.File;
import java.util.HashMap;

import org.eclipse.epsilon.emc.plainxml.PlainXmlModel;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.evl.EvlModule;
import org.eclipse.epsilon.evl.execute.FixInstance;
import org.eclipse.epsilon.evl.execute.UnsatisfiedConstraint;
import org.junit.Test;

import static org.junit.Assert.*;

public class EvlTests {
	
	protected EvlModule module = null;
	
	@Test
	public void testEvl() throws Exception {
		
		HashMap<String, String> blackboard = new HashMap<String, String>();
		module = new EvlModule();
		module.parse(new File(EvlTests.class.getResource("test.evl").toURI()));
		
		PlainXmlModel model = new PlainXmlModel();
		model.setName("M");
		model.setFile(new File(EvlTests.class.getResource("test.xml").toURI()));
		model.load();
		
		module.getContext().getModelRepository().addModel(model);
		module.getContext().getFrameStack().put(Variable.createReadOnlyVariable("frameStack", module.getContext().getFrameStack()));
		module.getContext().getFrameStack().put(Variable.createReadOnlyVariable("blackboard", blackboard));
		module.execute();
		
		assertUnsatisfiedConstraints(2, "t_b", "AlwaysFalse");
		assertUnsatisfiedConstraints(0, "t_b", "AlwaysTrue");
		assertUnsatisfiedConstraints(0, "t_a", "GuardVariableInvisibleInBlock");
		assertUnsatisfiedConstraints(0, "t_a", "NeverChecked");
		
		for (UnsatisfiedConstraint uc : module.getContext().getUnsatisfiedConstraints()) {
			uc.getMessage();
			for (FixInstance fix : uc.getFixes()) {
				fix.getTitle();
				fix.getFix().execute(uc.getInstance(), module.getContext());
			}
		}
		
		assertEquals("true", blackboard.get("fix-do-executed"));
		
	}
	
	protected void assertUnsatisfiedConstraints(int number, String context, String constraint) {
		int matches = 0;
		for (UnsatisfiedConstraint uc : module.getContext().getUnsatisfiedConstraints()) {
			if (uc.getConstraint().getConstraintContext().getTypeName().equals(context) &&
					uc.getConstraint().getName().equals(constraint)) {
				matches ++;
			}
		}
		assertEquals(number, matches);
	}
	
}
