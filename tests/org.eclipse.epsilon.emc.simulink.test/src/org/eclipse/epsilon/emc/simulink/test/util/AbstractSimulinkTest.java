package org.eclipse.epsilon.emc.simulink.test.util;

import java.io.File;
import java.util.UUID;

import org.eclipse.epsilon.emc.simulink.common.test.AbstractCommonSimulinkTest;
import org.eclipse.epsilon.emc.simulink.model.IGenericSimulinkModel;
import org.eclipse.epsilon.emc.simulink.model.SimulinkModel;
import org.eclipse.epsilon.emc.simulink.util.MatlabEngineSetupEnum;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;

public class AbstractSimulinkTest extends AbstractCommonSimulinkTest {

	@Override
	public IGenericSimulinkModel loadSimulinkModel(File file, boolean activeCaching) throws Exception {
		SimulinkModel model = getModel();
		model.setName("M");
		if (file != null) {
			model.setFile(file);
			model.setReadOnLoad(true);
			model.setWorkingDir(file.getParentFile());
		} else {
			model.setFile(new File("model" + String.valueOf(UUID.randomUUID()).replace("-", "") + ".slx"));
			model.setWorkingDir(new File(System.getProperty("user.dir")));
			model.setReadOnLoad(false);
		}
		model.setStoredOnDisposal(false);
		model.setShowInMatlabEditor(false);
		model.setCachingEnabled(activeCaching);
		String version = installation.getVersion();
		String path;
		try {
			path = MatlabEngineSetupEnum.LIBRARY_PATH.path(version);
			System.out.println(path);
			model.setLibraryPath(path);
			String engine = MatlabEngineSetupEnum.ENGINE_JAR.path(version);
			System.out.println(engine);
			model.setEngineJarPath(engine);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		model.setFollowLinks(false);
		try {
			model.load();
		} catch (EolModelLoadingException e) {
			e.printStackTrace();
			throw e;
		}
		return model;
	}

	@Override
	public SimulinkModel getModel() {
		return new SimulinkModel();
	}

}
