package org.eclipse.epsilon.emc.simulink.test.unit;

import org.eclipse.epsilon.emc.simulink.test.util.AbstractSimulinkTest;
import org.junit.Ignore;
import org.junit.Test;

public class OperationTests extends AbstractSimulinkTest {
	
	@Test
	public void testStateflowObjectMethodWithNoParams() {
		eol = "var chart = new `sflib/Chart`; "
				+ "var state = new `Stateflow.State`(chart); "
				+ "assert(state.isCommented() = false);";
	}
	
	@Test
	public void testStateflowObjectMethodWithOneParam() {
		eol = "var chart = new `sflib/Chart`; "
				+ "var state = new `Stateflow.State`(chart); "
				+ "state.name = 'sA';"
				+ "assert(state.get('name') = 'sA');";
	}
	
	@Test 
	@Ignore// FIXME
	public void testStateflowObjectMethodWithTwoParams() {
		eol = "var chart = new `sflib/Chart`; "
				+ "var sA = new `Stateflow.State`; "
				+ "sA.position = '[50 50 310 200]';"
				+ "var sA1 = new `Stateflow.State`; "
				+ "sA1.position = '[80 120 90 60]'; "
				+ "chart.add(sA); "
				+ "chart.add(sA1); "
				//+ "var result = chart.asStateflow().find('-isa','Stateflow.State'); "
				//+ "assert(result <> null); "
				+ "var method = chart.asStateflow().find('-depth',1); "
				+ "var children = chart.getChildren(); ";
				//+ "assert(method = children);";
	}
	
	@Test
	public void testMethodFromStateflowBlockClass() {
		eol = "var chart = new `sflib/Chart`; "
				+ "var sA = new `Stateflow.State`; "
				+ "chart.add(sA);"
				+ "assert(sA.parent = chart)";
	}
	
	@Test
	@Ignore// FIXME
	public void testSimulinkObjectMethodWithOneParam() {
		eol = "var gain = new `simulink/Math Operations/Gain`; "
				+ "assert(gain.get_param('BlockType') = 'Gain');";
	}
	
	@Test
	public void testMethodFromSimulinkBlockClass() {
		eol = "var gain = new `simulink/Math Operations/Gain`; "
				+ "assert(gain.getSimpleType() = 'Gain')";
	}
	
	@Test
	public void testModelObjectMethodForNoContextSimulink() {
		eol = "var name = M.getSimulinkModelName(); "
				+ "name.println; "
				+ "M.add_param(name, 'a', '2'); "
				+ "var res = M.get_param(name, 'a'); "
				+ "res.println; "
				+ "assert(res = '2');";
	}
	
	@Test
	public void testContextlessUserDefinedOperation() {
		eol = "var msg = 'hello world'; "
				+ "assert ( opA(msg) = msg); "
				+ "operation opA(msg : String) : String { return msg; }";
	}
	
	@Test
	@Ignore // FIXME
	public void testSimulinkUserDefinedOperation() {
		eol = "var gain = new `simulink/Math Operations/Gain`; "
				+ "var msg = 'hello world'; "
				+ "assert ( gain.opA() = msg); "
				//+ "operation Gain opA() : String { return self.name; }";
				+ "operation `simulink/Math Operations/Gain` opA() : String { return self.name; }";
				//+ "operation SimulinkBlock opA() : String { return self.name; }";
	}
	
	@Test 
	@Ignore // FIXME
	public void testStateflowUserDefinedOperation() {
		eol = "var chart = new `sflib/Chart`; "
				+ "var sA = new `Stateflow.State`(chart); "
				+ "var msg = 'hello world'; "
				+ "assert ( sA.opA() = msg); "
				+ "operation StateflowBlock opA() : String { return self.name; }";
		//+ "operation StateflowBlock opA() : String { return self.name; }";
	}
	
}