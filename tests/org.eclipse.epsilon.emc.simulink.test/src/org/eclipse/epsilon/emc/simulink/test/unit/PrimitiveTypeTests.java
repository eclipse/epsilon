package org.eclipse.epsilon.emc.simulink.test.unit;

import org.eclipse.epsilon.emc.simulink.test.util.AbstractSimulinkTest;
import org.junit.Test;

public class PrimitiveTypeTests extends AbstractSimulinkTest {

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
				"var returnValue = M.parseMatlabEngineVariable(out1.VariableName).get(0);" +
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
				"var returnValue = M.parseMatlabEngineVariable(out1.VariableName).get(0);" +
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
				"var returnValue = M.parseMatlabEngineVariable(out1.VariableName).get(0);" +
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
				"var returnValue = M.parseMatlabEngineVariable(out1.VariableName).get(0);" +
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
				"var returnValue = M.parseMatlabEngineVariable(out1.VariableName).get(0);" +
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
				"var returnValue = M.parseMatlabEngineVariable(out1.VariableName).get(0);" +
				"assert(returnValue = false);";
	}
}
