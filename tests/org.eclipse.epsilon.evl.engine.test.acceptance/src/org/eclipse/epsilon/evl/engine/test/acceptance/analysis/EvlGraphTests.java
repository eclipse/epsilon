package org.eclipse.epsilon.evl.engine.test.acceptance.analysis;

import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.eclipse.epsilon.evl.EvlModule;
import org.eclipse.epsilon.evl.IEvlModule;
import org.eclipse.epsilon.evl.dom.Constraint;
import org.eclipse.epsilon.evl.engine.test.acceptance.EvlTests;
import org.eclipse.epsilon.evl.graph.EvlGraph;

@RunWith(Parameterized.class)
public class EvlGraphTests {

	EvlGraph graph;
	
	@Parameter
	public IEvlModule module;

	@Parameters(name = "{0}")
	public static Iterable<? extends IEvlModule> modules() {
		return Arrays.asList(
			new EvlModule()
			/*new EvlModuleParallelGraph(),
			new EvlModuleParallelGraph(new EvlContextParallel(1))*/
		);
	}
	
	@Before
	public void setUp() throws Exception {
		EvlTests.loadEVL(module, false);
		graph = new EvlGraph(module.getContext());
		graph.addConstraintContexts(module.getConstraintContexts());
	}
	
	@Test
	public void testConstraintsDependedOn() {
		Set<String>
			actualDependencies = graph.getAllConstraintsDependedOn().stream().map(Constraint::toString).collect(Collectors.toSet()),
			expectedDependencies = new HashSet<>(Arrays.asList(
				"LazyAlwaysFalseOperation",
				"AlwaysTrueOperation",
				"AlwaysFalseOperation",
				"LazyContextlessDependedOn",
				"RequiresContextlessLazy",
				"LazyContextlessCallsLazy",
				"LazyWithGuard",
				"AlwaysFalse"
			));
		
		assertEquals("Correctly identifies all constraints depended upon", expectedDependencies, actualDependencies);
	}

	@Test
	public void testConstraintSequence() {
		List<String>
			actualSequence = graph.getConstraintSequence().stream().map(Constraint::toString).collect(Collectors.toList()),
			expectedSequence = Arrays.asList(
				//insert optimal order here...
			);
		
		assertEquals("Expected constraints order", expectedSequence, actualSequence);
	}
	
}
