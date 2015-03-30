package org.eclipse.epsilon.emc.spreadsheets.common;

import static org.junit.Assert.assertTrue;

import java.util.Collection;

import org.eclipse.epsilon.emc.spreadsheets.SpreadsheetModel;
import org.eclipse.epsilon.emc.spreadsheets.test.SharedTestMethods;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class IgnoreWorksheetTest
{
	private SpreadsheetModel model = null;

	public IgnoreWorksheetTest(SpreadsheetModel model)
	{
		this.model = model;
	}

	@Parameterized.Parameters
	public static Collection<Object[]> models() throws Exception
	{
		String PATH_TO_FILE = "resources/common/IgnoreWorksheetTest.xlsx";
		String CONFIG = "resources/common/IgnoreWorksheetTestConfig.xml";
		return SharedTestMethods.getModelsToTest("", PATH_TO_FILE, CONFIG, "IgnoreWorksheetTest");
	}

	@Test
	public void testIgnoreWorksheet() throws Exception
	{
		assertTrue(model.getWorksheets().size() == 1);
		assertTrue(model.getWorksheetByType("Sheet1") != null);
		assertTrue(model.getWorksheetByType("Sheet2") == null);
	}

}
