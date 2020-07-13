package org.eclipse.epsilon.pinset.engine.test.acceptance;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.epsilon.common.util.FileUtil;
import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.epsilon.emc.emf.EmfUtil;

public class PinsetTests {

	protected EmfModel loadModel(String name, String modelFile, String metamodelUri, boolean read, boolean store) throws Exception {
		EmfModel model = new EmfModel();
		model.setCachingEnabled(false);
		model.setName(name);
		model.setModelFile(getFullPath(modelFile));
		model.setMetamodelUri(metamodelUri);
		model.setReadOnLoad(read);
		model.setStoredOnDisposal(store);
		model.load();
		return model;
	}

	protected final File getFile(String fileName) throws IOException {
		return FileUtil.getFileStandalone(fileName, getClass());
	}

	protected final String getFullPath(String path) throws IOException {
		return getFullPath(path, getClass());
	}

	protected static final String getFullPath(String path, Class<?> currentClass) throws IOException {
		return FileUtil.getFileStandalone(path, currentClass).getAbsolutePath();
	}

	protected static final void registerMetamodel(String path, Class<?> currentClass) throws Exception {
		EmfUtil.register(URI.createFileURI(getFullPath(path, currentClass)), EPackage.Registry.INSTANCE);
	}

	protected String getTempDir() throws IOException {
		return Files.createTempDirectory("pinset").toString();
	}

	protected void assertEquivalent(List<String> generatedDatasetFiles, String resultFolder) throws Exception {

		for (String datasetFile : generatedDatasetFiles) {
			String expectedDataset = FileUtil.getFileContents(
					getFile(String.format("expected/%s", datasetFile)));
			String resultDataset = FileUtil.getFileContents(
					new File(String.format("%s/%s", resultFolder, datasetFile)));
			assertTrue(datasetFile, expectedDataset.equals(resultDataset));
		}

	}
}
