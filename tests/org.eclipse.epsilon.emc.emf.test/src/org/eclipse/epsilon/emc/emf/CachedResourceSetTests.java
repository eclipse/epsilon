package org.eclipse.epsilon.emc.emf;

import static org.junit.Assert.*;

import java.io.File;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EcorePackage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CachedResourceSetTests {
	
	protected EmfModel model1;
	protected EmfModel model2;
	
	@Before
	public void setup() throws Exception {
		CachedResourceSet.getCache().clear();
		model1 = getSimpleEcore();
		model2 = getSimpleEcore();
	}
	
	@After
	public void teardown() {
		CachedResourceSet.getCache().clear();
	}
	
	@Test
	public void testSameResource() throws Exception {
		model1.load();
		model2.load();
		assertEquals(model1.getResource(), model2.getResource());
	}
	
	@Test
	public void testUnloadModels() throws Exception {
		model1.load();
		model2.load();
		
		model1.dispose();
		assertTrue(CachedResourceSet.getCache().isCached(model1.getModelFileUri()));
		model2.dispose();
		assertFalse(CachedResourceSet.getCache().isCached(model1.getModelFileUri()));
		
		assertEquals(0, CachedResourceSet.getCache().size());
	}

	@Test
	public void testGc() throws Exception {
		model1.load();
		model2.load();
		
		model1.dispose();
		assertTrue(CachedResourceSet.getCache().isCached(model1.getModelFileUri()));
		model2 = null;
		// This test depends on GC actually running before the assertFalse statement
		// This works fine in my setup but since GC is not deterministic it may fail sometimes
		System.gc();
		assertFalse(CachedResourceSet.getCache().isCached(model1.getModelFileUri()));		
	}
	
	protected EmfModel getSimpleEcore() throws Exception {
		EmfModel model = new EmfModel();
		File file = new File("../org.eclipse.epsilon.emc.emf.test/model/Simple.ecore");
		model.setModelFileUri(URI.createFileURI(file.getCanonicalPath()));
		model.setMetamodelUri(EcorePackage.eINSTANCE.getNsURI());
		return model;
	}
	
}
