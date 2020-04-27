/*********************************************************************
* Copyright (c) 2008 The University of York.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.emc.spreadsheets.google;

import org.eclipse.epsilon.emc.spreadsheets.SpreadsheetColumn;
import org.eclipse.epsilon.emc.spreadsheets.SpreadsheetRow;

import com.google.gdata.data.spreadsheet.ListEntry;

public class GSRow extends SpreadsheetRow {
	private ListEntry listEntry;

	public GSRow(final GSWorksheet worksheet, final ListEntry listEntry) {
		super(worksheet);
		this.listEntry = listEntry;
	}

	@Override
	public String getVisibleCellValue(final SpreadsheetColumn column) {
		super.validateColumn(column);
		try {
			final String googleColumnId = ((GSColumn) column).getGoogleColumnId();
			final String value = this.listEntry.getCustomElements().getValue(googleColumnId);
			return value == null ? "" : value; // null is returned when cell is completely empty
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new IllegalStateException(e.getMessage());
		}
	}

	@Override
	public void overwriteCellValue(final SpreadsheetColumn column, final String value) {
		super.validateColumn(column);
		try {
			final GSWorksheet worksheet = (GSWorksheet) super.worksheet;
			final String googleColumnId = ((GSColumn) column).getGoogleColumnId();
			// getting list entry again as the API seems to lose touch with the existing one
			final ListEntry listEntry = worksheet.getListEntry(this);
			listEntry.getCustomElements().setValueLocal(googleColumnId, value);
			this.listEntry = listEntry.update();
			worksheet.getSelf();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new IllegalStateException(e.getMessage());
		}
	}

}
