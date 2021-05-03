package org.eclipse.epsilon.examples.standalone.flock;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.epsilon.flock.FlockModule;

public class FlockStandaloneExample {
	
	public static void main(String[] args) throws Exception {
		
		Path root = Paths.get(FlockStandaloneExample.class.getResource("").toURI()),
				modelsRoot = root.getParent().resolve("models");
			
		// Set up the original model
		EmfModel original = new EmfModel();
		original.setName("Source");
		original.setReadOnLoad(true);
		original.setStoredOnDisposal(false);
		original.setMetamodelFile(modelsRoot.resolve("Tree.ecore").toAbsolutePath().toString());
		original.setModelFile(modelsRoot.resolve("Tree.xmi").toAbsolutePath().toString());
		original.load();
		
		// Set up the migrated model
		EmfModel migrated = new EmfModel();
		migrated.setName("Migrated");
		migrated.setReadOnLoad(false);
		migrated.setStoredOnDisposal(true);
		migrated.setMetamodelFile(modelsRoot.resolve("Tree.ecore").toAbsolutePath().toString());
		migrated.setModelFile(modelsRoot.resolve("Tree.migrated.xmi").toAbsolutePath().toString().replace("/target/classes/", "/src/"));
		migrated.load();
		
		// Run the migration transformation
		FlockModule module = new FlockModule();
		module.parse(root.resolve("tree2tree.mig"));
		module.getContext().getModelRepository().addModel(original);
		module.getContext().getModelRepository().addModel(migrated);
		module.getContext().setOriginalModel(original);
		module.getContext().setMigratedModel(migrated);
		module.execute();
		
		// Save the migrated model
		module.getContext().getModelRepository().dispose();
	}
	
}
