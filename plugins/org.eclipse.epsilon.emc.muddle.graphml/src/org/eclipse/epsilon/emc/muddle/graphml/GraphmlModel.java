package org.eclipse.epsilon.emc.muddle.graphml;

import java.io.File;

import org.eclipse.epsilon.common.util.StringProperties;
import org.eclipse.epsilon.emc.muddle.MuddleFactory;
import org.eclipse.epsilon.emc.muddle.MuddleModel;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;

public class GraphmlModel extends MuddleModel {
	
	public static final String PROPERTY_FILE = "file";
	protected File file = null;	
	
	public GraphmlModel() {
		
	}
	
	@Override
	public void load(StringProperties properties, String basePath)
			throws EolModelLoadingException {
		super.load(properties, basePath);
		String filePath = properties.getProperty(GraphmlModel.PROPERTY_FILE);
		
		if (filePath != null && filePath.trim().length() > 0) {
			if (basePath != null) filePath = basePath + filePath;
			file = new File(filePath);
		}
		
		load();
	}
	
	@Override
	public void load() throws EolModelLoadingException {
		if (readOnLoad) {
			GraphmlImporter importer = new GraphmlImporter();
			try {
				muddle = importer.importGraph(file);
			} catch (Exception e) {
				throw new EolModelLoadingException(e, this);
			}
		}
		else {
			muddle = MuddleFactory.eINSTANCE.createMuddle();
		}
	}
	
	public void setFile(File file) {
		this.file = file;
	}
	
	public File getFile() {
		return file;
	}
}
