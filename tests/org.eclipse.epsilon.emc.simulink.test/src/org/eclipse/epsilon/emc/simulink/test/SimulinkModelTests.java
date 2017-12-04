package org.eclipse.epsilon.emc.simulink.test;

import org.junit.Ignore;
import org.junit.Test;

public class SimulinkModelTests extends AbstractSimulinkTest {

	@Test
	public void createGain() {
		eol = "var gain = new `simulink/Math Operations/Gain`; "
				+ "assert (Gain.all.size() = 1);";
	}

	@Test
	public void setAndGetGainGain() {
		// gain.gain returns a Character at the moment
		eol = "var gain = new `simulink/Math Operations/Gain`; "
				+ "gain.gain = 3; "
				+ "assert('3' = (gain.gain + ''));";
	}

	@Test
	public void setAndGetSubsystemParent() {
		eol = "var s1 = new `simulink/Ports & Subsystems/Subsystem`; " +
				"var s2 = new `simulink/Ports & Subsystems/Subsystem`;" + 
				"s1.parent = s2; " +
				"assert(s1.parent = s2);";
	}

	@Test
	public void setAndUnsetSubsystemParent() {
		eol = "var s1 = new `simulink/Ports & Subsystems/Subsystem`; " +
				"var s2 = new `simulink/Ports & Subsystems/Subsystem`;" + 
				"s1.parent = s2; " +
				"s1.parent = null; " +
				"assert(s1.parent = null);";
	}

	@Test
	public void createFunctionAndSetScript() {
		eol = "var f = new `simulink/User-Defined Functions/MATLAB Function`;" +
				"var script = 'function y = fcn(x) \\\n y = x;';" +
				"f.script = script;" +
				"assert(f.script = script);";
	}

	@Test
	public void simulateAndGetWorkspaceVariableDouble() {
		eol = "var constant1 = new `simulink/Sources/Constant`;" +
				"constant1.Value = 2;" +
				"var out1 = new `simulink/Sinks/To Workspace`;" + 
				"out1.SaveFormat = \"Array\";" +
				"var function1 = new `simulink/User-Defined Functions/MATLAB Function`;" + 
				"function1.script = \"y = 5*u + 4;\";" +
				"constant1.link(function1,1,1);" +
				"function1.link(out1,1,1);" + 
				"M.simulate();" +
				"var returnValue = M.getArrayWorkspaceVariable(out1.VariableName).get(0);" +
				"assert(returnValue = 14.0);";
	}

	@Test
	public void simulateAndGetWorkspaceVariableInt() {
		eol = "var constant1 = new `simulink/Sources/Constant`; " + 
				"constant1.OutDataTypeStr = \"int32\";" +
				"constant1.Value = 5;" +
				"var constant2 = new `simulink/Sources/Constant`;" +
				"constant2.OutDataTypeStr = \"int32\";" +
				"constant2.Value = 1;" +
				"var out1 = new `simulink/Sinks/To Workspace`;" +
				"out1.SaveFormat = \"Array\";" + 
				"var subtract1 = new `simulink/Math Operations/Subtract`;" +
				"constant1.link(subtract1,1,1);" +
				"constant2.link(subtract1,1,2);" +
				"subtract1.link(out1,1,1);" +
				"M.simulate();" +
				"var returnValue = M.getArrayWorkspaceVariable(out1.VariableName).get(0);" +
				"assert(returnValue = 4);";
	}

	@Test
	public void simulateAndGetWorkspaceVariableFloat() {
		eol = "var constant1 = new `simulink/Sources/Constant`; " + 
				"constant1.OutDataTypeStr = \"single\";" +
				"constant1.Value = 5;" +
				"var constant2 = new `simulink/Sources/Constant`;" +
				"constant2.OutDataTypeStr = \"single\";" +
				"constant2.Value = 1;" +
				"var out1 = new `simulink/Sinks/To Workspace`;" +
				"out1.SaveFormat = \"Array\";" + 
				"var subtract1 = new `simulink/Math Operations/Subtract`;" +
				"constant1.link(subtract1,1,1);" +
				"constant2.link(subtract1,1,2);" +
				"subtract1.link(out1,1,1);" +
				"M.simulate();" +
				"var returnValue = M.getArrayWorkspaceVariable(out1.VariableName).get(0);" +
				"assert(returnValue = 4.0);";
	}

	@Test
	public void simulateAndGetWorkspaceVariableShort() {
		eol = "var constant1 = new `simulink/Sources/Constant`; " + 
				"constant1.OutDataTypeStr = \"int16\";" +
				"constant1.Value = 5;" +
				"var constant2 = new `simulink/Sources/Constant`;" +
				"constant2.OutDataTypeStr = \"int16\";" +
				"constant2.Value = 1;" +
				"var out1 = new `simulink/Sinks/To Workspace`;" +
				"out1.SaveFormat = \"Array\";" + 
				"var subtract1 = new `simulink/Math Operations/Subtract`;" +
				"constant1.link(subtract1,1,1);" +
				"constant2.link(subtract1,1,2);" +
				"subtract1.link(out1,1,1);" +
				"M.simulate();" +
				"var returnValue = M.getArrayWorkspaceVariable(out1.VariableName).get(0);" +
				"assert(returnValue = 4);";
	}

	@Test
	public void simulateAndGetWorkspaceVariableByte() {
		eol = "var constant1 = new `simulink/Sources/Constant`; " + 
				"constant1.OutDataTypeStr = \"int8\"; " +
				"constant1.Value = 5; " +
				"var constant2 = new `simulink/Sources/Constant`;" +
				"constant2.OutDataTypeStr = \"int8\";" +
				"constant2.Value = 1;" +
				"var out1 = new `simulink/Sinks/To Workspace`;" +
				"out1.SaveFormat = \"Array\";" + 
				"var subtract1 = new `simulink/Math Operations/Subtract`;" +
				"constant1.link(subtract1,1,1);" +
				"constant2.link(subtract1,1,2);" +
				"subtract1.link(out1,1,1);" +
				"M.simulate();" +
				"var returnValue = M.getArrayWorkspaceVariable(out1.VariableName).get(0);" +
				"assert(returnValue = 4);";
	}

	@Test
	public void simulateAndGetWorkspaceVariableBoolean() {
		eol = "var constant1 = new `simulink/Sources/Constant`; " + 
				"constant1.OutDataTypeStr = \"int8\"; " +
				"constant1.Value = 5; " +
				"var out1 = new `simulink/Sinks/To Workspace`;" +
				"out1.SaveFormat = \"Array\";" + 
				"var compare1 = new `simulink/Logic and Bit Operations/Compare To Constant`;" +
				"constant1.link(compare1,1,1);" +
				"compare1.link(out1,1,1);" +
				"M.simulate();" +
				"var returnValue = M.getArrayWorkspaceVariable(out1.VariableName).get(0);" +
				"assert(returnValue = false);";
	}

	@Test 
	@Ignore
	public void testActiveChart() {
		eol = "M.activeChart.println";
	}

}
