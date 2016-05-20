package org.eclipse.epsilon.evl.engine.test.acceptance;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.epsilon.emc.plainxml.PlainXmlModel;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.evl.EvlModule;
import org.eclipse.epsilon.evl.dom.Constraint;
import org.eclipse.epsilon.evl.dom.ConstraintSelectTransfomer;
import org.eclipse.epsilon.evl.execute.FixInstance;
import org.eclipse.epsilon.evl.execute.UnsatisfiedConstraint;
import org.junit.Test;

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

	@Test
	public void testCanBeTransformedEVL() throws Exception {
		module = new EvlModule();
		module.parse(new File(EvlTests.class.getResource("optimised.evl").toURI()));

		final Set<String> canBeTransformed = new HashSet<String>(
				Arrays.asList("NoGuardAlwaysTrue", "NoGuardAlwaysFalse", "GuardedEmpty", "GuardedNonEmpty",
						"SingleReturnBlockGuard", "SingleReturnBlockCheck"));
		final Set<String> cannotBeTransformed = new HashSet<String>(
				Arrays.asList("Satisfies", "SatisfiesAll", "SatisfiesAny", "ComplexBlockGuard", "ComplexBlockCheck"));

		final ConstraintSelectTransfomer transformer = new ConstraintSelectTransfomer();
		assertEquals(canBeTransformed.size() + cannotBeTransformed.size(), module.getConstraints().values().size());
		for (Constraint c : module.getConstraints()) {
			if (canBeTransformed.contains(c.getName())) {
				assertTrue("Constraint " + c.getName() + " should be optimisable", transformer.canBeTransformed(c));
			} else if (cannotBeTransformed.contains(c.getName())) {
				assertFalse("Constraint " + c.getName() + " should not be optimisable", transformer.canBeTransformed(c));
			} else {
				fail("Unexpected constraint " + c.getName());
			}
		}
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
