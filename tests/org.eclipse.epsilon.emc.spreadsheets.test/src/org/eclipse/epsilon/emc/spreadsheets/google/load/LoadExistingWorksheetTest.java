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
public class LoadExistingWorksheetTest
{
	private static SpreadsheetModel model = null;

	public LoadExistingWorksheetTest(SpreadsheetModel model)
	{
		LoadExistingWorksheetTest.model = model;
	}

	@Parameterized.Parameters
	public static Collection<Object[]> models() throws Exception
	{
		String CONFIG = "resources/google/LoadExistingWorksheetTest.xml";
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
		SpreadsheetWorksheetHeader header1 = model.getWorksheetByType("Sheet1").getHeader();
		assertTrue(header1.getColumn("c_0").getName().equals(GSConstants.DEFAULT_COLUMN_VALUE));
		assertTrue(header1.getColumn("c_1").getName() == null);
		assertTrue(header1.getColumn("c_2").getName() == null);
		assertTrue(header1.getColumn("c_3").getName() == null);

		SpreadsheetWorksheetHeader header2 = model.getWorksheetByType("Sheet2").getHeader();
		assertTrue(header2.getColumn("c_0").getName().equals("column1"));
		assertTrue(header2.getColumn("c_1").getName() == null);
		assertTrue(header2.getColumn("c_2").getName().equals("column3"));
		assertTrue(header2.getColumn("c_3").getName() == null);
	}

	@Test
	public void testLoadWorksheetsWithPartialHeader() throws Exception
	{
		SpreadsheetWorksheetHeader header3 = model.getWorksheetByType("Sheet3").getHeader();
		assertTrue(header3.getColumn("c_0").getName().equals("column1"));
		assertTrue(header3.getColumn("c_1").getName().equals("column2"));
		assertTrue(header3.getColumn("c_2").getName().equals("column3"));
		assertTrue(header3.getColumn("c_3").getName().equals("column4"));
	}

	@AfterClass
	public static void tearDown() throws Exception
	{
		if (model != null)
		{
			GSWorksheet sheet1 = (GSWorksheet) model.getWorksheetByType("Sheet1");
			sheet1.writeHeaderCell(1, "");
			sheet1.writeHeaderCell(2, "");
			sheet1.writeHeaderCell(3, "");
			sheet1.writeHeaderCell(4, "");
			GSWorksheet sheet2 = (GSWorksheet) model.getWorksheetByType("Sheet2");
			sheet2.writeHeaderCell(1, "");
			sheet2.writeHeaderCell(2, "");
			sheet2.writeHeaderCell(3, "");
			sheet2.writeHeaderCell(4, "");
			GSWorksheet sheet3 = (GSWorksheet) model.getWorksheetByType("Sheet3");
			sheet3.writeHeaderCell(1, "column1");
			sheet3.writeHeaderCell(2, "column2");
			sheet3.writeHeaderCell(3, "");
			sheet3.writeHeaderCell(4, "");
		}
	}
}
