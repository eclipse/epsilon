package org.eclipse.epsilon.emc.spreadsheets;

import java.util.Collection;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.emc.spreadsheets.ISpreadsheetMetadata;
import org.eclipse.epsilon.emc.spreadsheets.SpreadsheetModel;
import org.eclipse.epsilon.emc.spreadsheets.SpreadsheetRow;
import org.eclipse.epsilon.emc.spreadsheets.SpreadsheetWorksheet;
import org.eclipse.epsilon.emc.spreadsheets.ISpreadsheetMetadata.SpreadsheetWorksheetMetadata;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.Variable;

public class ConcreteModel extends SpreadsheetModel
{

	@Override
	protected void loadSpreadsheet() throws Exception
	{
		// TODO Auto-generated method stub

	}

	@Override
	protected ISpreadsheetMetadata getSpreadsheetMetadata()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected boolean isMetadataConfigurationDefined()
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected SpreadsheetWorksheet createWorksheet(SpreadsheetWorksheetMetadata worksheetMetadata) throws Exception
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<SpreadsheetRow> find(Variable iterator, AST ast, IEolContext context) throws EolRuntimeException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void deleteWorksheet(SpreadsheetWorksheet worksheet)
	{
		// TODO Auto-generated method stub

	}

}
