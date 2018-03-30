package org.eclipse.epsilon.evl.engine.test.acceptance;

import static org.junit.Assert.*;
import java.io.File;
import java.util.*;
import java.util.Map.Entry;
import java.util.function.Supplier;
import org.eclipse.epsilon.common.util.FileUtil;
import org.eclipse.epsilon.emc.plainxml.PlainXmlModel;
import org.eclipse.epsilon.eol.dom.ExecutableBlock;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.FrameStack;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.evl.IEvlModule;
import org.eclipse.epsilon.evl.dom.Constraint;
import org.eclipse.epsilon.evl.dom.ConstraintContext;
import org.eclipse.epsilon.evl.dom.ConstraintSelectTransfomer;
import org.eclipse.epsilon.evl.execute.FixInstance;
import org.eclipse.epsilon.evl.execute.UnsatisfiedConstraint;
import org.eclipse.epsilon.evl.execute.context.*;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class EvlTests {

	private static final IModel
		TEST_MODEL = setUpModel("test.xml"),
		OPTIMISED_MODEL = setUpModel("optimised.xml");
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		TEST_MODEL.load();
		OPTIMISED_MODEL.load();
	}
	
	@Parameter
	public Supplier<? extends IEvlModule> moduleGetter;
	
	private IEvlModule module;
	
	@Parameters(name = "{0}")
	public static Iterable<Supplier<? extends IEvlModule>> modules() {
		//Shouldn't take long to run, so test everything.
		return EvlAcceptanceTestUtil.modules();
	}
	
	private static IModel setUpModel(String modelName) {
		PlainXmlModel model = new PlainXmlModel();
		model.setFile(new File(EvlAcceptanceTestUtil.modelsRoot+modelName));
		model.setName(FileUtil.removeExtension(model.getFile().getName()));
		//model.setCachingEnabled(true);
		return model;
	}
	
	public static IModel getTestModel(boolean optimised) {
		return optimised ? OPTIMISED_MODEL : TEST_MODEL;
	}
	
	public static File getTestScript(IEvlModule module) {
		return getTestScript("test", module);
	}
	
	private static File getTestScript(String scriptName, IEvlModule module) {
		if (scriptName.equals("test")) {
			FrameStack frameStack = module.getContext().getFrameStack();
			frameStack.putGlobal(
				Variable.createReadOnlyVariable("frameStack", frameStack),
				Variable.createReadOnlyVariable("blackboard", new HashMap<>())
			);
		}
		return new File(EvlAcceptanceTestUtil.scriptsRoot+scriptName+".evl");
	}
	
	public static void loadEVL(IEvlModule module, boolean optimised) throws Exception {
		loadEVL(module, optimised, optimised ? "optimised" : "test");
	}
	
	public static void loadEVL(IEvlModule module, boolean optimised, String scriptName) throws Exception {
		module.parse(getTestScript(scriptName, module));
		module.getContext().getModelRepository().addModel(getTestModel(optimised));
	}
	
	private IEvlModule loadEVL(boolean optimised) throws Exception {
		module = moduleGetter.get();
		loadEVL(module, optimised);
		return module;
	}
	
	private IEvlModule loadEVL(String scriptName) throws Exception {
		module = moduleGetter.get();
		loadEVL(module, false, scriptName);
		return module;
	}
	
	private void assertUnsatisfiedConstraints(int number, String contextName, String constraintName) {
		int matches = 0;
		for (UnsatisfiedConstraint uc : module.getContext().getUnsatisfiedConstraints()) {
			Constraint ucConstraint = uc.getConstraint();
			String contextTypeName = ucConstraint.getConstraintContext().getTypeName();
			
			if ((contextName == null || Objects.equals(contextTypeName, contextName)) &&
				(constraintName == null || Objects.equals(ucConstraint.getName(), constraintName))) {
				
				matches++;
			}
		}
		assertEquals(number, matches);
	}
	
	@SuppressWarnings("rawtypes")
	@Test
	public void testEvl() throws Exception {
		module = loadEVL(false);

		IEvlContext context = module.getContext();
		module.execute();
		
		assertUnsatisfiedConstraints(0, null, "CanAccessPre");
		assertUnsatisfiedConstraints(1, null, "EolTest");
		assertUnsatisfiedConstraints(0, "t_a", "GuardVariableInvisibleInBlock");
		assertUnsatisfiedConstraints(0, "t_a", "NeverChecked");
		assertUnsatisfiedConstraints(2, "t_b", "EolTest2");
		assertUnsatisfiedConstraints(2, "t_b", "AlwaysFalse");
		assertUnsatisfiedConstraints(0, "t_b", "AlwaysTrue");
		assertUnsatisfiedConstraints(2, "t_b", "ElementOperationInConstraint");
		assertUnsatisfiedConstraints(0, "t_b", "NeverChecked");
		assertUnsatisfiedConstraints(0, "t_b", "RequiresNonLazyConstraint");
		assertUnsatisfiedConstraints(0, "t_b", "LazyWithGuard");
		assertUnsatisfiedConstraints(2, "t_b", "RequiresLazyConstraint");
		assertUnsatisfiedConstraints(2, "t_b", "RequiresContextlessLazy");
		assertUnsatisfiedConstraints(2, "t_b", "InsaneLazyChain");
		assertUnsatisfiedConstraints(2, "t_c", "WrongType");
		assertUnsatisfiedConstraints(0, "t_c", "AlwaysTrueOperation");
		assertUnsatisfiedConstraints(2, "t_c", "AlwaysFalseOperation");
		assertUnsatisfiedConstraints(2, "t_c", "SatisfiesOneLazyAndNonLazy");
		assertUnsatisfiedConstraints(2, "t_c", "SatisfiesAllLazyAndNonLazy");
		assertUnsatisfiedConstraints(0, "t_c", "NeverCalledLazyGuard");
		assertUnsatisfiedConstraints(2, "t_c", "LazyAlwaysFalseOperation");
		assertUnsatisfiedConstraints(0, "t_c", "ExtendedPropertyCanBeAccessed");
		assertUnsatisfiedConstraints(1, null, "LazyContextlessCallsLazy");
		assertUnsatisfiedConstraints(1, null, "LazyContextlessDependedOn");
		assertUnsatisfiedConstraints(0, null, "LazyContextlessNeverCalled");
		assertUnsatisfiedConstraints(0, null, "ImportedOperationWithoutContext");
		
		for (UnsatisfiedConstraint uc : context.getUnsatisfiedConstraints()) {
			uc.getMessage();
			for (FixInstance fix : uc.getFixes()) {
				fix.getTitle();
				fix.getFix().execute(uc.getInstance(), context);
			}
		}
		
		assertEquals("true", ((Map)context.getFrameStack().get("blackboard").getValue()).get("fix-do-executed"));
		
	}

	@Test
	public void testCanBeTransformedEVL() throws Exception {
		module = loadEVL(true);

		final Set<String> canBeTransformed = new HashSet<>(Arrays.asList(
				"NoGuardAlwaysTrue", "NoGuardAlwaysFalse", "GuardedEmpty", "GuardedNonEmpty",
				"SingleReturnBlockGuard", "SingleReturnBlockCheck"));
		final Set<String> cannotBeTransformed = new HashSet<>(Arrays.asList(
				"Satisfies", "SatisfiesAll", "SatisfiesOne", "ComplexBlockGuard", "ComplexBlockCheck"));

		final ConstraintSelectTransfomer transformer = new ConstraintSelectTransfomer();
		assertEquals(canBeTransformed.size() + cannotBeTransformed.size(), module.getConstraints().size());
		for (Constraint c : module.getConstraints()) {
			String cName = c.getName();
			if (canBeTransformed.contains(cName)) {
				assertTrue("Constraint " + cName + " should be optimisable", transformer.canBeTransformed(c));
			}
			else if (cannotBeTransformed.contains(cName)) {
				assertFalse("Constraint " + cName + " should not be optimisable", transformer.canBeTransformed(c));
			}
			else {
				fail("Unexpected constraint " + cName);
			}
		}
	}

	/**
	 * Tests the constraint optimization manually, without the {@link ConstraintContext#checkAll} integration.
	 */
	@Test
	public void testOptimizedConstraints() throws Exception {
		module = loadEVL(true);

		final ConstraintSelectTransfomer transformer = new ConstraintSelectTransfomer();
		final Map<String, Constraint> constraintByName = new HashMap<>();
		for (Constraint c : module.getConstraints()) {
			constraintByName.put(c.getName(), c);
		}

		final Map<String, Integer> expectedFound = new HashMap<>();
		expectedFound.put("NoGuardAlwaysTrue", 0);
		expectedFound.put("NoGuardAlwaysFalse", 4);
		expectedFound.put("GuardedEmpty", 0);
		expectedFound.put("GuardedNonEmpty", 1);
		expectedFound.put("SingleReturnBlockGuard", 1);
		expectedFound.put("SingleReturnBlockCheck", 1);

		for (Entry<String, Integer> entry : expectedFound.entrySet()) {
			final String constraintName = entry.getKey();
			final int expectedInvalid = entry.getValue();

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
		module = loadEVL(true);
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
	
	/**
	 * Tests whether the program halts when encountering an issue with the script.
	 */
	@Test
	public void testInvalidExecution() throws Exception {
		module = loadEVL("invalid");
		try {
			module.execute();
		}
		catch (EolRuntimeException ex) {
			String reason = ex.getReason();
			String message = ex.getMessage();
			assertTrue("Exception has reason", reason != null && reason.length() > 0);
			assertTrue("Exception has Epsilon trace",
				message != null &&
				message.length() > 0 &&
				!message.equalsIgnoreCase("Unknown reason") &&
				message.split("\\n").length > 1
			);
			return;
		}
		fail("No exception thrown!");
	}
}
