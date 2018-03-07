package org.eclipse.epsilon.emc.simulink.test.unit;

import org.eclipse.epsilon.emc.simulink.test.util.AbstractSimulinkTest;
import org.junit.Test;

public class OperationTests extends AbstractSimulinkTest {
	
	@Test
	public void testStateflowObjectMethodWithNoParams() {
		eol = "var chart = new `sflib/Chart`; "
				+ "var sfChart = `Stateflow.Chart`.all.first; " 
				+ "var state = new `Stateflow.State`(sfChart); "
				+ "assert(state.isCommented() = false);";
	}
	
	@Test
	public void testStateflowObjectMethodWithOneParam() {
		eol = "var chart = new `sflib/Chart`; "
				+ "var sfChart = `Stateflow.Chart`.all.first; " 
				+ "var state = new `Stateflow.State`(sfChart); "
				+ "state.name = 'sA';"
				+ "assert(state.get('name') = 'sA');";
	}
	
	@Test
	public void testMethodFromStateflowBlockClass() {
		eol = "var chart = new `sflib/Chart`; "
				+ "var sA = new `Stateflow.State`; "
				+ "var sfChart = `Stateflow.Chart`.all.first; "
				+ "sfChart.add(sA);"
				+ "assert(sA.parent = sfChart)";
	}
	
	@Test
	public void testMethodFromSimulinkBlockClass() {
		eol = "var gain = new `simulink/Math Operations/Gain`; "
				+ "assert(gain.type = 'Gain')";
	}
	
	@Test
	public void testModelObjectMethodForNoContextSimulink() {
		eol = "M.add_param('a', '2'); "
				+ "var res = M.get_param('a'); "
				+ "assert(res = '2');";
	}
	
	@Test
	public void testContextlessUserDefinedOperation() {
		eol = "var msg = 'hello world'; "
				+ "assert ( opA(msg) = msg); "
				+ "operation opA(msg : String) : String { return msg; }";
	}
		
	@Test
	public void testSimulinkObjectMethodWithOneParam() {
		eol = "var gain = new `simulink/Math Operations/Gain`; "
				+ "assert(gain.get_param(\"BlockType\".asString()).println = 'Gain');";
	}
	
	@Test
	public void testSimulinkUserDefinedOperation() {
		eol = "var gain = new `simulink/Math Operations/Gain`; "
				+ "var msg = 'hello world'; "
				+ "gain.name = msg; "
				+ "assert ( gain.opA() = msg); "
				+ "operation Gain opA() : String { return self.name; }";
	}
	
	@Test 
	public void testStateflowUserDefinedOperation() {
		eol = "var chart = new `sflib/Chart`; "
				+ "var sfChart = `Stateflow.Chart`.all.first; "
				+ "var sA = new `Stateflow.State`(sfChart); "
				+ "var msg = 'hello_world'; "
				+ "sA.name = msg; "
				+ "assert ( sA.opA().println = msg); "
				+ "operation `Stateflow.State` opA() : String { return self.name; }";
	}
	
}