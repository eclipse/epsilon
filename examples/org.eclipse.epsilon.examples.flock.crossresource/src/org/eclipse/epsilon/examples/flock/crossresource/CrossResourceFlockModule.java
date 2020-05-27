package org.eclipse.epsilon.examples.flock.crossresource;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.epsilon.eol.models.IReflectiveModel;
import org.eclipse.epsilon.flock.FlockModule;
import org.eclipse.epsilon.flock.model.domain.MigrationStrategy;

public class CrossResourceFlockModule extends FlockModule {
	
	protected Map<IReflectiveModel, IReflectiveModel> modelMap = new HashMap<IReflectiveModel, IReflectiveModel>();
	
	@Override
	protected MigrationStrategy createMigrationStrategy() {
		return new CrossResourceMigrationStrategy(modelMap);
	}
	
	public Map<IReflectiveModel, IReflectiveModel> getModelMap() {
		return modelMap;
	}
	
}
