package org.eclipse.epsilon.emc.spreadsheets.excel;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.List;

import org.eclipse.epsilon.common.util.StringProperties;
import org.eclipse.epsilon.emc.spreadsheets.SpreadsheetRow;
import org.eclipse.epsilon.emc.spreadsheets.test.SharedTestMethods;
import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.epsilon.eol.models.IRelativePathResolver;
import org.junit.Test;

public class ExcelModelTest
{
	private final String PATH_TO_FILE = SharedTestMethods.getBasePath() + "resources/excel/ModelTest.xlsx";
	private final String PATH_TO_XLS_FILE = SharedTestMethods.getBasePath() + "resources/excel/ModelTest.xls";
	private final String PATH_TO_CONFIG = SharedTestMethods.getBasePath() + "resources/excel/ModelTestConfig.xml";
	private final String PATH_TO_INVALID_CONFIG = SharedTestMethods.getBasePath()
			+ "resources/excel/ModelTestInvalidConfig.xml";
	private final String PATH_TO_PROTECTED_FILE = SharedTestMethods.getBasePath()
			+ "resources/excel/ModelTestProtected.xlsx";
	private final String PATH_TO_PROTECTED_XLS_FILE = SharedTestMethods.getBasePath()
			+ "resources/excel/ModelTestProtected.xls";

	@Test
	public void testNullModel()
	{
		ExcelModel model = new ExcelModel();
		try
		{
			model.setSpreadsheetFile(null);
			model.load();
			fail("Expecting model not to be loaded due to null file path");
		}
		catch (Exception e)
		{
			return;
		}
	}

	@Test
	public void testEmptyModel()
	{
		ExcelModel model = new ExcelModel();
		try
		{
			model.setSpreadsheetFile("");
			fail("Expecting model not to be loaded due to empty file path");
		}
		catch (Exception e)
		{
			return;
		}
	}

	@Test
	public void testBlankModelPath()
	{
		ExcelModel model = new ExcelModel();
		try
		{
			model.setSpreadsheetFile("  ");
			model.load();
			fail("Expecting model not to be loaded due to blank file path");
		}
		catch (Exception e)
		{
			return;
		}
	}

	@Test
	public void testModelFileIsProvided()
	{
		ExcelModel model = new ExcelModel();
		model.setSpreadsheetFile(this.PATH_TO_FILE);

		try
		{
			model.load();
		}
		catch (EolModelLoadingException e)
		{
			fail("Expecting model to be loaded");
		}
	}

	@Test
	public void testModelXlsFileIsProvided()
	{
		ExcelModel model = new ExcelModel();
		model.setSpreadsheetFile(this.PATH_TO_XLS_FILE);

		try
		{
			model.load();
		}
		catch (EolModelLoadingException e)
		{
			fail("Expecting model to be loaded: " + e.getMessage());
		}
	}

	@Test
	public void testModelInvalidFileIsProvided()
	{
		ExcelModel model = new ExcelModel();
		model.setSpreadsheetFile(this.PATH_TO_FILE + "xyz");

		try
		{
			model.load();
			fail("Expecting model not to be loaded due to unknown file");
		}
		catch (EolModelLoadingException e)
		{
			return;
		}
	}

	@Test
	public void testNullConfigFilePath()
	{
		ExcelModel model = new ExcelModel();
		model.setSpreadsheetFile(this.PATH_TO_FILE);
		try
		{
			model.setConfigurationFile(null);
			model.load();
		}
		catch (Exception e)
		{
			fail("Expecting to load on null configuration file path");
		}
	}

	@Test
	public void testEmptyConfigFilePath()
	{
		ExcelModel model = new ExcelModel();
		model.setSpreadsheetFile(this.PATH_TO_FILE);
		try
		{
			model.setConfigurationFile("");
			model.load();
		}
		catch (Exception e)
		{
			fail("Expecting to load on empty configuration file path");
		}
	}

	@Test
	public void testBlankConfigFilePath()
	{
		ExcelModel model = new ExcelModel();
		model.setSpreadsheetFile(this.PATH_TO_FILE);
		try
		{
			model.setConfigurationFile("  ");
			model.load();
		}
		catch (Exception e)
		{
			fail("Expecting to load on blank configuration file path");
		}
	}

	@Test
	public void testValidConfigFilePath()
	{
		ExcelModel model = new ExcelModel();
		try
		{
			model.setSpreadsheetFile(this.PATH_TO_FILE);
			model.setConfigurationFile(this.PATH_TO_CONFIG);
			model.load();
		}
		catch (Exception e)
		{
			fail("Expecting to load both spreadsheet and config");
		}
	}

	@Test
	public void testInvalidConfigFile()
	{
		ExcelModel model = new ExcelModel();
		model.setSpreadsheetFile(this.PATH_TO_FILE);
		try
		{

			model.setConfigurationFile(this.PATH_TO_INVALID_CONFIG);
			fail("Expecting configuration file not to be parsed successfully");
		}
		catch (Exception e)
		{
			assert (true);
		}
	}

	@Test
	public void testModelName()
	{
		ExcelModel model = new ExcelModel();
		model.setSpreadsheetFile(this.PATH_TO_FILE);

		try
		{
			model.load();
			assertTrue(model.getName() == null);
			model.setName("MODEL_NAME");
			assertTrue(model.getName().equals("MODEL_NAME"));
		}
		catch (EolModelLoadingException e)
		{
			return;
		}
	}

	@Test
	public void testStore()
	{
		ExcelModel model = new ExcelModel();
		try
		{
			model.setSpreadsheetFile(this.PATH_TO_FILE);
			model.load();
			model.store();
		}
		catch (Exception e)
		{
			fail("Expecting the store to work");
		}
	}

	@Test
	public void testStoreWithRead()
	{
		ExcelModel model = new ExcelModel();
		try
		{
			model.setSpreadsheetFile(this.PATH_TO_FILE);
			model.setName("M");
			model.load();

			EolModule module = new EolModule();
			module.parse("M!Sheet1.all.println();");
			module.getContext().getModelRepository().addModel(model);
			module.execute();

			model.store();
		}
		catch (Exception e)
		{
			fail(e.getMessage());
		}
	}

	@Test
	public void testProtectedXlsxModelFileLoadAndStore()
	{
		ExcelModel model = new ExcelModel();
		model.setSpreadsheetFile(this.PATH_TO_PROTECTED_FILE);

		try
		{
			model.setPassword("test");
			model.load();
			model.store();
		}
		catch (EolModelLoadingException e)
		{
			fail("Expecting model to be loaded and stored: " + e.getMessage());
		}
	}

	@Test
	public void testProtectedXlsModelFileLoad()
	{
		ExcelModel model = new ExcelModel();
		model.setSpreadsheetFile(this.PATH_TO_PROTECTED_XLS_FILE);

		try
		{
			model.setPassword("test");
			model.load();
			fail("Expecting model not to be loaded");
		}
		catch (EolModelLoadingException e)
		{
			return;
		}
	}

	@Test
	public void testLoadFromDt()
	{
		StringProperties properties = new StringProperties();
		properties.put(ExcelModel.SPREADSHEET_FILE, this.PATH_TO_PROTECTED_FILE);
		properties.put(ExcelModel.CONFIGURATION_FILE, this.PATH_TO_CONFIG);
		properties.put(ExcelModel.SPREADSHEET_PASSWORD, "test");

		ExcelModel model = new ExcelModel();
		try
		{
			model.load(properties, new IRelativePathResolver() {
				@Override
				public String resolve(String relativePath)
				{
					return relativePath;
				}
			});
		}
		catch (EolModelLoadingException e)
		{
			fail(e.getMessage());
		}
	}

	@Test
	public void testFindNotSupported()
	{
		ExcelModel model = new ExcelModel();
		model.setName("M");
		model.setSpreadsheetFile(this.PATH_TO_FILE);
		try
		{
			model.load();
		}
		catch (EolModelLoadingException e)
		{
			fail("Expected model to load successfully");
		}
		try
		{
			model.find(null, null, null);
			fail("Expecting find() to fail");
		}
		catch (UnsupportedOperationException e)
		{
			assert (true);
		}
		catch (EolRuntimeException e)
		{
			fail("EOL Runtime Exception not expected");
		}
	}

	@Test
	public void testAddWorksheetNull() throws Exception
	{
		ExcelModel model = new ExcelModel();
		model.setSpreadsheetFile(this.PATH_TO_FILE);
		int worksheets = model.getWorksheets().size();
		model.addWorksheet(null);
		assertTrue(worksheets == model.getWorksheets().size());
	}

	@Test
	public void testAddReferenceNull() throws Exception
	{
		ExcelModel model = new ExcelModel();
		model.setSpreadsheetFile(this.PATH_TO_FILE);
		int references = model.getReferences().size();
		model.addReference(null);
		assertTrue(references == model.getReferences().size());
	}

	@Test
	public void testOwnsModel() throws Exception
	{
		ExcelModel model = new ExcelModel();
		model.setSpreadsheetFile(PATH_TO_FILE);
		model.setConfigurationFile(PATH_TO_CONFIG);
		model.load();

		ExcelModel model2 = new ExcelModel();
		model2.setSpreadsheetFile(PATH_TO_FILE);
		model2.setConfigurationFile(PATH_TO_CONFIG);
		model2.load();

		assertTrue(model.owns(model));
		assertTrue(!model.owns(model2));
		assertTrue(!model2.owns(model));
	}

	@Test
	public void testOwnsWorksheet() throws Exception
	{
		ExcelModel model = new ExcelModel();
		model.setSpreadsheetFile(PATH_TO_FILE);
		model.setConfigurationFile(PATH_TO_CONFIG);
		model.load();

		ExcelModel model2 = new ExcelModel();
		model2.setSpreadsheetFile(PATH_TO_FILE);
		model2.setConfigurationFile(PATH_TO_CONFIG);
		model2.load();

		assertTrue(model.owns(model.getWorksheetByType("Sheet1")));
		assertTrue(!model.owns(model2.getWorksheetByType("Sheet1")));
		assertTrue(!model2.owns(model.getWorksheetByType("Sheet1")));
	}

	@Test
	public void testOwnsRow() throws Exception
	{
		ExcelModel model = new ExcelModel();
		model.setSpreadsheetFile(PATH_TO_FILE);
		model.setConfigurationFile(PATH_TO_CONFIG);
		model.load();

		ExcelModel model2 = new ExcelModel();
		model2.setSpreadsheetFile(PATH_TO_FILE);
		model2.setConfigurationFile(PATH_TO_CONFIG);
		model2.load();

		assertTrue(model.owns(model.getAllOfType("Sheet1").get(0)));
		assertTrue(!model.owns(model2.getAllOfType("Sheet1").get(0)));
		assertTrue(!model2.owns(model.getAllOfType("Sheet1").get(0)));
	}

	@Test
	public void testOwnsColumn() throws Exception
	{
		ExcelModel model = new ExcelModel();
		model.setSpreadsheetFile(PATH_TO_FILE);
		model.setConfigurationFile(PATH_TO_CONFIG);
		model.load();

		ExcelModel model2 = new ExcelModel();
		model2.setSpreadsheetFile(PATH_TO_FILE);
		model2.setConfigurationFile(PATH_TO_CONFIG);
		model2.load();

		assertTrue(model.owns(model.getWorksheetByType("Sheet1").getColumn(0)));
		assertTrue(!model.owns(model2.getWorksheetByType("Sheet1").getColumn(0)));
		assertTrue(!model2.owns(model.getWorksheetByType("Sheet1").getColumn(0)));
	}

	@Test
	public void testOwnsCollectionOfString() throws Exception
	{
		ExcelModel model = new ExcelModel();
		model.setSpreadsheetFile(PATH_TO_FILE);
		model.setConfigurationFile(PATH_TO_CONFIG);
		model.load();

		ExcelModel model2 = new ExcelModel();
		model2.setSpreadsheetFile(PATH_TO_FILE);
		model2.setConfigurationFile(PATH_TO_CONFIG);
		model2.load();

		assertTrue(!model.owns(Arrays.asList("V1", "V2")));
		assertTrue(!model2.owns(Arrays.asList("V1", "V2")));
	}

	@Test
	public void testOwnsCollectionOfRows() throws Exception
	{
		ExcelModel model = new ExcelModel();
		model.setSpreadsheetFile(PATH_TO_FILE);
		model.setConfigurationFile(PATH_TO_CONFIG);
		model.load();

		ExcelModel model2 = new ExcelModel();
		model2.setSpreadsheetFile(PATH_TO_FILE);
		model2.setConfigurationFile(PATH_TO_CONFIG);
		model2.load();

		assertTrue(model.owns(Arrays.asList(model.getAllOfType("Sheet1").get(0))));
		assertTrue(!model.owns(Arrays.asList(model2.getAllOfType("Sheet1").get(0))));
		assertTrue(!model2.owns(Arrays.asList(model.getAllOfType("Sheet1").get(0))));

		List<SpreadsheetRow> mixedList = Arrays.asList(model.getAllOfType("Sheet1").get(0),
				model2.getAllOfType("Sheet1").get(0));
		assertTrue(!model.owns(mixedList));
		assertTrue(!model2.owns(mixedList));
	}

	@Test
	public void testAddWorksheetFromAnotherModel() throws Exception
	{
		ExcelModel model = new ExcelModel();
		model.setSpreadsheetFile(PATH_TO_FILE);
		model.setConfigurationFile(PATH_TO_CONFIG);
		model.load();

		ExcelModel model2 = new ExcelModel();
		model2.setSpreadsheetFile(PATH_TO_FILE);
		model2.setConfigurationFile(PATH_TO_CONFIG);
		model2.load();

		try
		{
			model.addWorksheet(model2.getWorksheetByType("Sheet1"));
			fail("Should not be able to add worksheet that belongs to another spreadsheet model");
		}
		catch (IllegalArgumentException e)
		{
			assertTrue(true);
		}
	}

	@Test
	public void testHasType() throws Exception
	{
		ExcelModel model = new ExcelModel();
		model.setSpreadsheetFile(PATH_TO_FILE);
		model.setConfigurationFile(PATH_TO_CONFIG);
		model.load();
		assertTrue(model.hasType("Sheet1"));
	}

	@Test
	public void testIsInstantiable() throws Exception
	{
		ExcelModel model = new ExcelModel();
		model.setSpreadsheetFile(PATH_TO_FILE);
		model.setConfigurationFile(PATH_TO_CONFIG);
		model.load();
		assertTrue(model.isInstantiable("Sheet1"));
	}
}
