package org.eclipse.epsilon.evl.engine.test.acceptance;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.epsilon.emc.plainxml.PlainXmlModel;
import org.eclipse.epsilon.eol.dom.ExecutableBlock;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.evl.EvlModule;
import org.eclipse.epsilon.evl.dom.Constraint;
import org.eclipse.epsilon.evl.dom.ConstraintContext;
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
		loadOptimisedEVL();

		final Set<String> canBeTransformed = new HashSet<String>(
				Arrays.asList("NoGuardAlwaysTrue", "NoGuardAlwaysFalse", "GuardedEmpty", "GuardedNonEmpty",
						"SingleReturnBlockGuard", "SingleReturnBlockCheck"));
		final Set<String> cannotBeTransformed = new HashSet<String>(
				Arrays.asList("Satisfies", "SatisfiesAll", "SatisfiesOne", "ComplexBlockGuard", "ComplexBlockCheck"));

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

	/**
	 * Tests the constraint optimization manually, without the {@link ConstraintContext#checkAll} integration.
	 */
	@Test
	public void testOptimizedConstraints() throws Exception {
		loadOptimisedEVL();

		final ConstraintSelectTransfomer transformer = new ConstraintSelectTransfomer();
		final Map<String, Constraint> constraintByName = new HashMap<String, Constraint>();
		for (Constraint c : module.getConstraints()) {
			constraintByName.put(c.getName(), c);
		}

		final Map<String, Integer> expectedFound = new HashMap<String, Integer>();
		expectedFound.put("NoGuardAlwaysTrue", 0);
		expectedFound.put("NoGuardAlwaysFalse", 4);
		expectedFound.put("GuardedEmpty", 0);
		expectedFound.put("GuardedNonEmpty", 1);
		expectedFound.put("SingleReturnBlockGuard", 1);
		expectedFound.put("SingleReturnBlockCheck", 1);

		for (Entry<String, Integer> e : expectedFound.entrySet()) {
			final String constraintName = e.getKey();
			final int expectedInvalid = e.getValue();

			final ExecutableBlock<?> transformed = transformer.transformIntoSelect(constraintByName.get(constraintName));
			final List<?> results = (List<?>) transformed.execute(module.getContext());
			assertEquals("Rule " + constraintName + " should find " + expectedInvalid + " invalid objects", expectedInvalid, results.size());
		}
	}

	/**
	 * Tests the constraint optimization from end to end, including the integration.
	 */
	@Test
	public void testOptimizedExecution() throws Exception {
		loadOptimisedEVL();
		module.execute();

		assertUnsatisfiedConstraints(0, "t_b", "NoGuardAlwaysTrue");
		assertUnsatisfiedConstraints(4, "t_b", "NoGuardAlwaysFalse");
		assertUnsatisfiedConstraints(0, "t_b", "GuardedEmpty");
		assertUnsatisfiedConstraints(1, "t_b", "GuardedNonEmpty");
		assertUnsatisfiedConstraints(1, "t_b", "SingleReturnBlockGuard");
		assertUnsatisfiedConstraints(1, "t_b", "SingleReturnBlockCheck");
		assertUnsatisfiedConstraints(0, "t_b", "Satisfies");
		assertUnsatisfiedConstraints(0, "t_b", "SatisfiesAll");
		assertUnsatisfiedConstraints(4, "t_b", "SatisfiesOne");
		assertUnsatisfiedConstraints(2, "t_b", "ComplexBlockGuard");
		assertUnsatisfiedConstraints(2, "t_b", "ComplexBlockCheck");
	}

	private void loadOptimisedEVL() throws Exception, URISyntaxException, EolModelLoadingException {
		module = new EvlModule();
		module.parse(new File(EvlTests.class.getResource("optimised.evl").toURI()));

		PlainXmlModel model = new PlainXmlModel();
		model.setName("M");
		model.setFile(new File(EvlTests.class.getResource("optimised.xml").toURI()));
		model.load();

		module.getContext().getModelRepository().addModel(model);
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
