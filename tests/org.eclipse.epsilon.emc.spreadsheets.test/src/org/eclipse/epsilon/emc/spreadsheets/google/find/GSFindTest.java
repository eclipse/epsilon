/*********************************************************************
* Copyright (c) 2008 The University of York.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.emc.spreadsheets.google.find;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.epsilon.emc.spreadsheets.SpreadsheetColumn;
import org.eclipse.epsilon.emc.spreadsheets.SpreadsheetModel;
import org.eclipse.epsilon.emc.spreadsheets.SpreadsheetRow;
import org.eclipse.epsilon.emc.spreadsheets.test.SharedTestMethods;
import org.eclipse.epsilon.emc.spreadsheets.test.TestModelFactory;
import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class GSFindTest {
	private static SpreadsheetModel model = null;

	public GSFindTest(SpreadsheetModel model) {
		GSFindTest.model = model;
	}

	@Parameterized.Parameters
	public static Collection<Object[]> models() throws Exception {
		String pathToConfig = "resources/find/GSFindTestConfig.xml";
		SpreadsheetModel gsModel = TestModelFactory.getGSModel("FindTest", pathToConfig, "MODEL");
		if (gsModel != null) {
			return Arrays.asList(new Object[][] { { gsModel } });
		}
		else {
			return Arrays.asList(new Object[][] {});
		}
	}

	@Test
	public void testFindValues() throws Exception {
		SharedTestMethods.clearWorksheet(model, "Sheet1");
		assertTrue(model.getAllOfType("Sheet1").size() == 0);

		Map<String, Object> values1 = new HashMap<>();
		values1.put("c_0", "value0");
		Map<String, Object> values2 = new HashMap<>();
		values2.put("c_0", "value1");
		model.createInstance("Sheet1", values1);
		model.createInstance("Sheet1", values1);
		model.createInstance("Sheet1", values2);
		assertTrue(model.getAllOfType("Sheet1").size() == 3);

		SpreadsheetColumn column = model.getWorksheetByType("Sheet1").getColumn("c_0");

		final EolModule module = new EolModule();
		module.parse("return MODEL.find(s : Sheet1 | s.c_0='value0');");
		module.getContext().getModelRepository().addModel(model);
		Object result = module.execute();

		assertTrue(result instanceof Collection);
		@SuppressWarnings("unchecked")
		List<Object> rows = new ArrayList<>((Collection<Object>) result);
		assertTrue(rows.size() == 2);
		assertTrue(((SpreadsheetRow) rows.get(0)).getVisibleCellValue(column).equals("value0"));
		assertTrue(((SpreadsheetRow) rows.get(1)).getVisibleCellValue(column).equals("value0"));
	}

	@Test
	public void testFindInManyValues() throws Exception {
		SharedTestMethods.clearWorksheet(model, "Sheet1");
		assertTrue(model.getAllOfType("Sheet1").size() == 0);

		Map<String, Object> values1 = new HashMap<>();
		values1.put("c_2", "value0, value1");
		Map<String, Object> values2 = new HashMap<>();
		values2.put("c_2", "value1, value2");
		model.createInstance("Sheet1", values1);
		model.createInstance("Sheet1", values1);
		model.createInstance("Sheet1", values2);
		assertTrue(model.getAllOfType("Sheet1").size() == 3);

		final EolModule module = new EolModule();
		module.parse("return MODEL.find(s : Sheet1 | s.c_2='value1');");
		module.getContext().getModelRepository().addModel(model);
		Object result = module.execute();

		assertTrue(result instanceof Collection);
		@SuppressWarnings("unchecked")
		List<Object> rows = new ArrayList<>((Collection<Object>) result);
		assertTrue(rows.size() == 0);
	}

	@Test
	public void testFindInUnknownWorksheet() throws Exception {
		try {
			final EolModule module = new EolModule();
			module.parse("return MODEL.find(s : UnknownSheet | s.c_0='value');");
			module.getContext().getModelRepository().addModel(model);
			module.execute();
			fail();
		}
		catch (EolRuntimeException e) {
			assertTrue(true);
		}
	}

	@Test
	public void testInvalidFindFormatMissingSheetIdFromColumn() throws Exception {
		try {
			final EolModule module = new EolModule();
			module.parse("return MODEL.find(s : Sheet1 | c_0='value');");
			module.getContext().getModelRepository().addModel(model);
			module.execute();
			fail();
		}
		catch (EolRuntimeException e) {
			assertTrue(true);
		}
	}

	@Test
	public void testUnknownColumn() throws Exception {
		try {
			final EolModule module = new EolModule();
			module.parse("return MODEL.find(s : Sheet1 | s.unknwonColumn='value');");
			module.getContext().getModelRepository().addModel(model);
			module.execute();
			fail();
		}
		catch (EolRuntimeException e) {
			assertTrue(true);
		}
	}

	@Test
	public void testDoubleColumn() throws Exception {
		try {
			final EolModule module = new EolModule();
			module.parse("return MODEL.find(s : Sheet1 | s.c_0.c_0='value');");
			module.getContext().getModelRepository().addModel(model);
			module.execute();
			fail();
		}
		catch (EolRuntimeException e) {
			assertTrue(true);
		}
	}

	@Test
	public void testFindMultipleValues() throws Exception {
		SharedTestMethods.clearWorksheet(model, "Sheet1");
		assertTrue(model.getAllOfType("Sheet1").size() == 0);

		Map<String, Object> values1 = new HashMap<>();
		values1.put("c_0", "value0");
		Map<String, Object> values2 = new HashMap<>();
		values2.put("c_0", "value1");
		model.createInstance("Sheet1", values1);
		model.createInstance("Sheet1", values1);
		model.createInstance("Sheet1", values2);
		assertTrue(model.getAllOfType("Sheet1").size() == 3);

		SpreadsheetColumn column = model.getWorksheetByType("Sheet1").getColumn("c_0");

		final EolModule module = new EolModule();
		module.parse("return MODEL.find(s : Sheet1 | s.c_0='value0' or s.c_0='value1');");
		module.getContext().getModelRepository().addModel(model);
		Object result = module.execute();

		assertTrue(result instanceof Collection);
		@SuppressWarnings("unchecked")
		List<Object> rows = new ArrayList<>((Collection<Object>) result);
		assertTrue(rows.size() == 3);
		assertTrue(((SpreadsheetRow) rows.get(0)).getVisibleCellValue(column).equals("value0"));
		assertTrue(((SpreadsheetRow) rows.get(1)).getVisibleCellValue(column).equals("value0"));
		assertTrue(((SpreadsheetRow) rows.get(2)).getVisibleCellValue(column).equals("value1"));
	}

	@Test
	public void testFindMultipleValuesInMultipleCells() throws Exception {
		SharedTestMethods.clearWorksheet(model, "Sheet1");
		assertTrue(model.getAllOfType("Sheet1").size() == 0);

		Map<String, Object> values1 = new HashMap<>();
		values1.put("c_0", "value0");
		values1.put("c_2", "10");
		Map<String, Object> values2 = new HashMap<>();
		values2.put("c_0", "value1");
		values2.put("c_2", "20");
		model.createInstance("Sheet1", values1);
		model.createInstance("Sheet1", values1);
		model.createInstance("Sheet1", values2);
		assertTrue(model.getAllOfType("Sheet1").size() == 3);

		SpreadsheetColumn column0 = model.getWorksheetByType("Sheet1").getColumn("c_0");
		SpreadsheetColumn column2 = model.getWorksheetByType("Sheet1").getColumn("c_2");

		final EolModule module = new EolModule();
		module.parse("return MODEL.find(s : Sheet1 | s.c_0='value0' and s.c_2 > 10 or s.c_0='value1');");
		module.getContext().getModelRepository().addModel(model);
		Object result = module.execute();

		assertTrue(result instanceof Collection);
		@SuppressWarnings("unchecked")
		List<Object> rows = new ArrayList<>((Collection<Object>) result);
		assertTrue(rows.size() == 1);
		assertTrue(((SpreadsheetRow) rows.get(0)).getVisibleCellValue(column0).equals("value1"));
		assertTrue(((SpreadsheetRow) rows.get(0)).getVisibleCellValue(column2).equals("20"));
	}

}
