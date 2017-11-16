package org.eclipse.epsilon.emc.simulink.test;

import java.io.File;
import java.util.UUID;

import org.eclipse.epsilon.emc.simulink.SimulinkModel;
import org.eclipse.epsilon.eol.EolModule;
import org.junit.Test;

public class SimulinkModelTests {
	
	@Test
	public void createGain() {
		run("var gain = new `simulink/Math Operations/Gain`; assert (Gain.all.size() = 1);");
	}
	
	@Test
	public void setAndGetGainGain() {
		// gain.gain returns a Character at the moment
		run("var gain = new `simulink/Math Operations/Gain`; gain.gain = 3; assert('3' = (gain.gain + ''));");
	}
	
	@Test
	public void setAndGetSubsystemParent() {
		run("var s1 = new `simulink/Ports & Subsystems/Subsystem`; " +
			"var s2 = new `simulink/Ports & Subsystems/Subsystem`;" + 
			"s1.parent = s2; " +
			"assert(s1.parent = s2);");
	}

	@Test
	public void setAndUnsetSubsystemParent() {
		run("var s1 = new `simulink/Ports & Subsystems/Subsystem`; " +
			"var s2 = new `simulink/Ports & Subsystems/Subsystem`;" + 
			"s1.parent = s2; " +
			"s1.parent = null; " +
			"assert(s1.parent = null);");
	}
	
	@Test
	public void createFunctionAndSetScript() {
		run("var f = new `simulink/User-Defined Functions/MATLAB Function`;" +
			"var script = 'function y = fcn(x) \\\n y = x;';" +
			"f.script = script;" +
			"assert(f.script = script);");
	}
	
	@Test
	public void simulateAndGetWorkspaceVariableDouble() {
		run("var constant1 = new `simulink/Sources/Constant`;" +
			"constant1.Value = 2;" +
			"var out1 = new `simulink/Sinks/To Workspace`;" + 
			"out1.SaveFormat = \"Array\";" +
			"var function1 = new `simulink/User-Defined Functions/MATLAB Function`;" + 
			"function1.script = \"y = 5*u + 4;\";" +
			"constant1.link(function1,1,1);" +
			"function1.link(out1,1,1);" + 
			"M.simulate();" +
			"var returnValue = M.getArrayWorkspaceVariable(out1.VariableName).get(0);" +
			"assert(returnValue = 14.0);");
	}
	
	@Test
	public void simulateAndGetWorkspaceVariableInt() {
		run("var constant1 = new `simulink/Sources/Constant`; " + 
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
			"assert(returnValue = 4);");
	}
	
	@Test
	public void simulateAndGetWorkspaceVariableFloat() {
		run("var constant1 = new `simulink/Sources/Constant`; " + 
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
			"assert(returnValue = 4.0);");
	}
	
	@Test
	public void simulateAndGetWorkspaceVariableShort() {
		run("var constant1 = new `simulink/Sources/Constant`; " + 
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
			"assert(returnValue = 4);");
	}
	
	@Test
	public void simulateAndGetWorkspaceVariableByte() {
		run("var constant1 = new `simulink/Sources/Constant`; " + 
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
			"assert(returnValue = 4);");
	}
	
	@Test
	public void simulateAndGetWorkspaceVariableBoolean() {
		run("var constant1 = new `simulink/Sources/Constant`; " + 
			"constant1.OutDataTypeStr = \"int8\"; " +
			"constant1.Value = 5; " +
			"var out1 = new `simulink/Sinks/To Workspace`;" +
			"out1.SaveFormat = \"Array\";" + 
			"var compare1 = new `simulink/Logic and Bit Operations/Compare To Constant`;" +
			"constant1.link(compare1,1,1);" +
			"compare1.link(out1,1,1);" +
			"M.simulate();" +
			"var returnValue = M.getArrayWorkspaceVariable(out1.VariableName).get(0);" +
			"assert(returnValue = false);");
	}
	
	
	protected void run(String eol) {
		SimulinkModel model = null;
		File simulinkEngineJar = new File("/Applications/MATLAB_R2017a.app/extern/engines/java/jar/engine.jar");
		File simulinkLibraryPath = new File("/Applications/MATLAB_R2017a.app/bin/maci64");
		if (System.getProperty("os.name").toLowerCase().contains("windows")) {
			simulinkEngineJar = new File("C:/Program Files/MATLAB/R2017a/extern/engines/java/jar/engine.jar");
			simulinkLibraryPath = new File("C:/Program Files/MATLAB/R2017a/bin/win64");
		}
		if (!simulinkEngineJar.exists() || !simulinkLibraryPath.exists()) return;
		
		try {
			EolModule module = new EolModule();
			module.parse(eol);
			model = new SimulinkModel();
			model.setName("M");
			model.setFile(new File("model" + String.valueOf(UUID.randomUUID()).replace("-", "") + ".slx"));
			model.setReadOnLoad(false);
			model.setStoredOnDisposal(false);
			model.setLibraryPath(simulinkLibraryPath.getAbsolutePath());
			model.setEngineJarPath(simulinkEngineJar.getAbsolutePath());
			model.load();
			module.getContext().getModelRepository().addModel(model);
			module.execute();
		}
		catch (Exception ex) { 
			throw new RuntimeException(ex);
		}
		finally {
			 model.dispose();
		}
	}
	
}
