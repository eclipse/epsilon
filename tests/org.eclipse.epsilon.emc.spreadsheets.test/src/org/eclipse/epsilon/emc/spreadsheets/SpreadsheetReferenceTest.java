package org.eclipse.epsilon.emc.spreadsheets;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.eclipse.epsilon.emc.spreadsheets.ISpreadsheetMetadata.SpreadsheetReferenceMetadata;
import org.eclipse.epsilon.emc.spreadsheets.SpreadsheetReference;
import org.eclipse.epsilon.emc.spreadsheets.excel.ExcelModel;
import org.eclipse.epsilon.emc.spreadsheets.test.SharedTestMethods;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.junit.BeforeClass;
import org.junit.Test;

public class SpreadsheetReferenceTest
{
	private static ExcelModel model;

	@BeforeClass
	public static void setup() throws EolModelLoadingException
	{
		model = new ExcelModel();
		model.setSpreadsheetFile(SharedTestMethods.getBasePath() + "resources/excel/ModelTest.xlsx");
		model.load();
	}

	@Test
	public void testSourceIsNull()
	{
		SpreadsheetReferenceMetadata metadata = new SpreadsheetReferenceMetadata();
		metadata.source = null;
		metadata.target = null;
		metadata.many = null;
		metadata.cascadeUpdates = null;
		try
		{
			new SpreadsheetReference(model, metadata);
			fail("Should not be able to construct reference");
		}
		catch (IllegalArgumentException e)
		{
			System.out.println(e.getMessage());
			assertTrue(true);
		}
	}

	@Test
	public void testTargetIsNull()
	{
		SpreadsheetReferenceMetadata metadata = new SpreadsheetReferenceMetadata();
		metadata.source = "SOURCE";
		metadata.target = null;
		metadata.many = null;
		metadata.cascadeUpdates = null;
		try
		{
			new SpreadsheetReference(model, metadata);
			fail("Should not be able to construct reference");
		}
		catch (IllegalArgumentException e)
		{
			System.out.println(e.getMessage());
			assertTrue(true);
		}
	}

	@Test
	public void testInvalidSourceTargetFormat()
	{
		SpreadsheetReferenceMetadata metadata = new SpreadsheetReferenceMetadata();
		metadata.source = "Sheet1";
		metadata.target = "Sheet1";
		metadata.many = null;
		metadata.cascadeUpdates = null;
		try
		{
			new SpreadsheetReference(model, metadata);
			fail("Should not be able to construct reference");
		}
		catch (IllegalArgumentException e)
		{
			System.out.println(e.getMessage());
			assertTrue(true);
		}
	}

	@Test
	public void testSourceTargetColumnNotSet()
	{
		SpreadsheetReferenceMetadata metadata = new SpreadsheetReferenceMetadata();
		metadata.source = "Sheet1-> ";
		metadata.target = "Sheet1-> ";
		metadata.many = null;
		metadata.cascadeUpdates = null;
		try
		{
			new SpreadsheetReference(model, metadata);
			fail("Should not be able to construct reference");
		}
		catch (IllegalArgumentException e)
		{
			System.out.println(e.getMessage());
			assertTrue(true);
		}
	}

	@Test
	public void testColumnReferencingItself()
	{
		SpreadsheetReferenceMetadata metadata = new SpreadsheetReferenceMetadata();
		metadata.source = "Sheet1->c_0";
		metadata.target = "Sheet1->c_0";
		metadata.many = null;
		metadata.cascadeUpdates = null;
		try
		{
			new SpreadsheetReference(model, metadata);
			fail("Should not be able to construct reference");
		}
		catch (IllegalArgumentException e)
		{
			System.out.println(e.getMessage());
			assertTrue(true);
		}
	}

	@Test
	public void testValidSourceAndTarget()
	{
		SpreadsheetReferenceMetadata metadata = new SpreadsheetReferenceMetadata();
		metadata.source = "Sheet1->c_0";
		metadata.target = "Sheet1->c_1";
		metadata.many = null;
		metadata.cascadeUpdates = null;
		new SpreadsheetReference(model, metadata);
	}

	@Test
	public void testNotBoolean()
	{
		SpreadsheetReferenceMetadata metadata = new SpreadsheetReferenceMetadata();
		metadata.source = "Sheet1->c_0";
		metadata.target = "Sheet1->c_1";
		metadata.many = "YES";
		metadata.cascadeUpdates = "NO";
		SpreadsheetReference reference = new SpreadsheetReference(model, metadata);
		assertTrue(reference.isMany() == false);
		assertTrue(reference.isCascadingUpdates() == false);
	}

	@Test
	public void testBooleans()
	{
		SpreadsheetReferenceMetadata metadata = new SpreadsheetReferenceMetadata();
		metadata.source = "Sheet1->c_0";
		metadata.target = "Sheet1->c_1";
		metadata.many = "true";
		metadata.cascadeUpdates = "TRUE";
		SpreadsheetReference reference = new SpreadsheetReference(model, metadata);
		assertTrue(reference.isMany() == true);
		assertTrue(reference.isCascadingUpdates() == true);
		System.out.println(reference.toString());
		assertTrue(model == reference.getModel());
	}

}
