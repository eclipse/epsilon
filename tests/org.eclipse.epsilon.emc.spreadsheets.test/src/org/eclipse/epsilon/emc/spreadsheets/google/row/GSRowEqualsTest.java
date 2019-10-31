/*********************************************************************
* Copyright (c) 2008 The University of York.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.emc.spreadsheets.google.row;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.epsilon.emc.spreadsheets.SpreadsheetModel;
import org.eclipse.epsilon.emc.spreadsheets.SpreadsheetRow;
import org.eclipse.epsilon.emc.spreadsheets.test.TestModelFactory;
import org.eclipse.epsilon.emc.spreadsheets.test.SharedTestMethods;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class GSRowEqualsTest
{
	private static SpreadsheetModel model = null;

	public GSRowEqualsTest(SpreadsheetModel model)
	{
		GSRowEqualsTest.model = model;
	}

	@Parameterized.Parameters
	public static Collection<Object[]> models() throws Exception
	{
		String pathToConfig = "resources/instantiate/CreateInstanceTestConfig.xml";
		SpreadsheetModel gsModel = TestModelFactory.getGSModel("ReadTest", pathToConfig, "");
		if (gsModel != null)
		{
			return Arrays.asList(new Object[][] { { gsModel } });
		}
		else
		{
			return Arrays.asList(new Object[][] {});
		}
	}

	@Test
	public void test() throws Exception
	{
		SharedTestMethods.clearWorksheet(model, "Sheet1");
		SharedTestMethods.clearWorksheet(model, "Sheet2");
		
		assertTrue(model.getAllOfType("Sheet1").size() == 0);
		assertTrue(model.getAllOfType("Sheet2").size() == 0);
		
		Map<String, Object> values1 = new HashMap<>();
		values1.put("c_0", "value01");
		values1.put("c_1", "value11");
		SpreadsheetRow row1Sheet1 = (SpreadsheetRow) model.createInstance("Sheet1", values1);
		SpreadsheetRow row2Sheet1 = (SpreadsheetRow) model.createInstance("Sheet1", values1);
		assertTrue(model.getAllOfType("Sheet1").size() == 2);
		
		assertTrue(row1Sheet1.equals(row1Sheet1));
		assertTrue(!row1Sheet1.equals(row2Sheet1));
		assertTrue(row2Sheet1.equals(row2Sheet1));
		assertTrue(!row2Sheet1.equals(row1Sheet1));
		
		Map<String, Object> values2 = new HashMap<>();
		values2.put("c_0", "value02");
		values2.put("c_1", "value12");
		SpreadsheetRow row1Sheet2 = (SpreadsheetRow) model.createInstance("Sheet2", values2);
		SpreadsheetRow row2Sheet2 = (SpreadsheetRow) model.createInstance("Sheet2", values2);
		assertTrue(model.getAllOfType("Sheet2").size() == 2);
		
		assertTrue(!row1Sheet1.equals(row1Sheet2));
		assertTrue(!row1Sheet1.equals(row2Sheet2));
		assertTrue(!row2Sheet1.equals(row1Sheet2));
		assertTrue(!row2Sheet1.equals(row2Sheet2));
		
		assertTrue(!row1Sheet1.equals(null));
		assertTrue(!row1Sheet1.equals(model));
	}

}
