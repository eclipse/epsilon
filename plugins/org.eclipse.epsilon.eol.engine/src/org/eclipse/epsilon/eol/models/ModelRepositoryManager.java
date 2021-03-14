package org.eclipse.epsilon.eol.models;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class ModelRepositoryManager {
	
	protected static ModelRepositoryManager INSTANCE = new ModelRepositoryManager();
	protected LinkedHashMap<String, ModelRepository> repositories = new LinkedHashMap<>();
	
	public static ModelRepositoryManager getInstance() {
		return INSTANCE;
	}
	
	public HashMap<String, ModelRepository> getRepositories() {
		return repositories;
	}
	
	public void dispose() {
		for (ModelRepository repository : repositories.values()) {
			if (repository != null) repository.dispose();
		}
		repositories.clear();
	}
}