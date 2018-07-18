/*********************************************************************
* Copyright (c) 2008 The University of York.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.emc.spreadsheets.google.load;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;

import org.eclipse.epsilon.emc.spreadsheets.SpreadsheetModel;
import org.eclipse.epsilon.emc.spreadsheets.SpreadsheetWorksheetHeader;
import org.eclipse.epsilon.emc.spreadsheets.google.GSConstants;
import org.eclipse.epsilon.emc.spreadsheets.google.GSWorksheet;
import org.eclipse.epsilon.emc.spreadsheets.test.TestModelFactory;
import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class LoadNonExistingWorksheetTest
{
	private static SpreadsheetModel model = null;

	public LoadNonExistingWorksheetTest(SpreadsheetModel model)
	{
		LoadNonExistingWorksheetTest.model = model;
	}

	@Parameterized.Parameters
	public static Collection<Object[]> models() throws Exception
	{
		String CONFIG = "resources/google/LoadNonExistingWorksheetTest.xml";
		SpreadsheetModel gsModel = TestModelFactory.getGSModel("ReadTest", CONFIG, "");
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
	public void testLoadWorksheetsWithBlankHeader() throws Exception
	{
		SpreadsheetWorksheetHeader header4 = model.getWorksheetByType("Sheet4").getHeader();
		assertTrue(header4.getColumn("c_0").getName().equals(GSConstants.DEFAULT_COLUMN_VALUE));
		assertTrue(header4.getColumn("c_1").getName() == null);
		assertTrue(header4.getColumn("c_2").getName() == null);
		assertTrue(header4.getColumn("c_3").getName() == null);

		SpreadsheetWorksheetHeader header5 = model.getWorksheetByType("Sheet5").getHeader();
		assertTrue(header5.getColumn("c_0").getName().equals("column1"));
		assertTrue(header5.getColumn("c_1").getName() == null);
		assertTrue(header5.getColumn("c_2").getName().equals("column3"));
		assertTrue(header5.getColumn("c_3").getName() == null);

		SpreadsheetWorksheetHeader header6 = model.getWorksheetByType("Sheet6").getHeader();
		assertTrue(header6.getColumn("c_0").getName().equals("column1"));
		assertTrue(header6.getColumn("c_1").getName().equals("column2"));
		assertTrue(header6.getColumn("c_2").getName().equals("column3"));
		assertTrue(header6.getColumn("c_3").getName().equals("column4"));
	}

	@AfterClass
	public static void tearDown() throws Exception
	{
		if (model != null)
		{
			GSWorksheet sheet4 = (GSWorksheet) model.getWorksheetByType("Sheet4");
			GSWorksheet sheet5 = (GSWorksheet) model.getWorksheetByType("Sheet5");
			GSWorksheet sheet6 = (GSWorksheet) model.getWorksheetByType("Sheet6");

			sheet4.delete();
			sheet5.delete();
			sheet6.delete();
		}
	}
}
