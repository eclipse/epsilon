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
	
	protected void run(String eol) {
		SimulinkModel model = null;
		
		File simulinkEngineJar = new File("/Applications/MATLAB_R2017a.app/extern/engines/java/jar/engine.jar");
		File simulinkLibraryPath = new File("/Applications/MATLAB_R2017a.app/bin/maci64");
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
