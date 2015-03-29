package org.eclipse.epsilon.emc.spreadsheets.google;

import org.eclipse.epsilon.emc.spreadsheets.SpreadsheetColumn;

public class GSColumn extends SpreadsheetColumn
{
	private String googleColumnId;

	public GSColumn(final GSWorksheet worksheet, final int columnIndex)
	{
		super(worksheet, columnIndex);
		this.googleColumnId = null;
	}

	public String getGoogleColumnId()
	{
		return this.googleColumnId;
	}

	public void setGoogleColumnId(String id)
	{
		this.googleColumnId = id;
	}

	@Override
	public String toString()
	{
		return "GSColumn [googleColumnId = '" + googleColumnId + "', parent = " + super.toString() + "]";
	}

}
