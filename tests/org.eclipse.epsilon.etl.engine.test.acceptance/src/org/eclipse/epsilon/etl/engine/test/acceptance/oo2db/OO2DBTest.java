package org.eclipse.epsilon.etl.engine.test.acceptance.oo2db;

import java.io.File;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.epsilon.emc.emf.EmfUtil;
import org.eclipse.epsilon.etl.EtlModule;
import org.eclipse.epsilon.etl.engine.test.acceptance.EtlTest;
import org.eclipse.epsilon.test.util.ResourceComparator;
import org.junit.Test;
import static org.junit.Assert.*;

public class OO2DBTest extends EtlTest {
	
	@Test
	public void testOO2DBTransformation() throws Exception {
		
		EtlModule module = new EtlModule();
		module.parse(new File(getFullPath("OO2DB.etl")));
		
		registerMetamodel("models/OO.ecore");
		registerMetamodel("models/DB.ecore");
		registerMetamodel("models/TM.ecore");
		registerMetamodel("models/SimpleTrace.ecore");
		
		EmfModel dbModel = loadModel("DB", "models/DBInstance.model", "DB", false, false);
		
		module.getContext().getModelRepository().addModel(loadModel("OO", "models/OOInstance.model", "OO", true, false));
		module.getContext().getModelRepository().addModel(dbModel);
		module.getContext().getModelRepository().addModel(loadModel("OO2DB", "models/OO2DB.model", "TM", true, false));
		module.getContext().getModelRepository().addModel(loadModel("Trace", "models/Trace.model", "SimpleTrace", false, false));
		
		module.execute();
		
		Resource dbModelOracle = getResource("models/DBInstance.model");
		
		assertTrue(new ResourceComparator().compare(dbModelOracle, dbModel.getModelImpl()));
		
		
	}
		
}
