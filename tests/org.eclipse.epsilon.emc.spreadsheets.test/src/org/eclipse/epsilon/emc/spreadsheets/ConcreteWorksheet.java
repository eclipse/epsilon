package org.eclipse.epsilon.emc.spreadsheets;

import java.util.List;
import java.util.Map;

import org.eclipse.epsilon.emc.spreadsheets.SpreadsheetColumn;
import org.eclipse.epsilon.emc.spreadsheets.SpreadsheetModel;
import org.eclipse.epsilon.emc.spreadsheets.SpreadsheetRow;
import org.eclipse.epsilon.emc.spreadsheets.SpreadsheetWorksheet;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;

public class ConcreteWorksheet extends SpreadsheetWorksheet
{

	public ConcreteWorksheet(SpreadsheetModel model, String name, boolean existsInSpreadsheet)
	{
		super(model, name, existsInSpreadsheet);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void createInSpreadsheet()
	{
		// TODO Auto-generated method stub

	}

	@Override
	protected void loadHeader() throws EolModelLoadingException
	{
		// TODO Auto-generated method stub

	}

	@Override
	protected SpreadsheetColumn createColumn(int index)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDefaultEmptyCellValue()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected SpreadsheetRow insertRow(Map<SpreadsheetColumn, String> values)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeRow(SpreadsheetRow row)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public List<SpreadsheetRow> getRows()
	{
		// TODO Auto-generated method stub
		return null;
	}

}
