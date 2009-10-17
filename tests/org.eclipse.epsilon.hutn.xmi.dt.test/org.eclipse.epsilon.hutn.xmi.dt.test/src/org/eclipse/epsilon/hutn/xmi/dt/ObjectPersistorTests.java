/*******************************************************************************
 * Copyright (c) 2009 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************
 *
 * $Id$
 */
package org.eclipse.epsilon.hutn.xmi.dt;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ObjectPersistorTests {

	private static final File storage = new File("test.txt");
	private static final ObjectPersistor<Map<String, Integer>> persistor = new ObjectPersistor<Map<String, Integer>>(storage);
	
	@Before
	public void setup() {
		removeStorage();
	}
	
	@After
	public void teardown() {
		removeStorage();
	}
	
	public static void removeStorage() {
		if (storage.exists())
			storage.delete();
	}
	
	
	@Test
	public void loadAndStoreProducesSameObject() throws IOException {
		persistor.store(createMap());
		
		assertEquals(createMap(), persistor.load(new HashMap<String, Integer>()));
	}
	
	@Test
	public void overwritesExistingFile() throws IOException {
		fillStorageWithIrrelevantData();
		
		persistor.store(createMap());
		
		assertEquals(createMap(), persistor.load(new HashMap<String, Integer>()));
	}

	private void fillStorageWithIrrelevantData() throws IOException {
		final FileWriter writer = new FileWriter(storage);
		writer.write("foo");
		writer.close();
	}


	private Map<String, Integer> createMap() {
		final Map<String, Integer> ages = new HashMap<String, Integer>();
		ages.put("John Doe", 42);
		ages.put("Joe Bloggs", 22);
		return ages;
	}
}
