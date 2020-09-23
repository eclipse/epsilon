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

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

import org.eclipse.epsilon.common.util.StringUtil;
import org.eclipse.epsilon.emc.spreadsheets.ISpreadsheetMetadata.SpreadsheetColumnMetadata;
import org.eclipse.epsilon.emc.spreadsheets.SpreadsheetColumn;
import org.eclipse.epsilon.emc.spreadsheets.SpreadsheetRow;
import org.eclipse.epsilon.emc.spreadsheets.SpreadsheetWorksheet;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;

import com.google.gdata.data.spreadsheet.CellEntry;
import com.google.gdata.data.spreadsheet.CellFeed;
import com.google.gdata.data.spreadsheet.ListEntry;
import com.google.gdata.data.spreadsheet.ListFeed;
import com.google.gdata.data.spreadsheet.WorksheetEntry;
import com.google.gdata.util.ServiceException;

public class GSWorksheet extends SpreadsheetWorksheet {
	private GSModel model;
	private WorksheetEntry worksheetEntry;
	private ListFeed listFeed;
	private HashSet<GSRow> rows;

	/*
	 * This field indicates whether the Google worksheet has any value set in the
	 * header. Required because when header is blank the first row written using
	 * ListFeed is written to the header row. Bug reported to Google:
	 * https://code.google.com/a/google.com/p/apps-api-issues/issues/detail?id=3355
	 */
	private boolean headerInWorksheetIsEmpty;

	/*
	 * Each Google Spreadsheet column is identified by some unique Google-assigned
	 * id. We may want to manage columns that do not have a title (value in header
	 * row cell) thus this id is required, for example, to write a row.
	 */
	private boolean hasGoogleIdsSet;

	public GSWorksheet(final GSModel model, final WorksheetEntry worksheetEntry, final boolean existsInSpreadsheet)
		throws Exception {
		super(model, worksheetEntry.getTitle().getPlainText(), existsInSpreadsheet);

		this.model = model;
		this.worksheetEntry = worksheetEntry;
		this.headerInWorksheetIsEmpty = true;
		this.hasGoogleIdsSet = false;
		this.rows = null;
		this.initialise();
	}

	private void initialise() throws Exception {
		if (super.existsInSpreadsheet) {
			this.initialiseListFeed();
			this.loadHeader();
		}
	}

	private void initialiseListFeed() throws Exception {
		final URL listFeedUrl = new URL(this.worksheetEntry.getListFeedUrl().toString());// + "?return-empty=true");
		this.listFeed = this.model.getWorksheetListFeed(listFeedUrl);
	}

	@Override
	protected void loadHeader() throws EolModelLoadingException {
		try {
			final CellFeed headerRow = this.getHeaderCellFeed();
			if (headerRow != null) {
				for (final CellEntry headerCell : headerRow.getEntries()) {
					final String name = headerCell.getCell().getValue();
					if (!StringUtil.isEmpty(name)) {
						int i = headerCell.getCell().getCol();
						super.addColumn(i - getColumnOffset(), name);
						this.headerInWorksheetIsEmpty = false;
					}
				}
				this.writeValueInFirstCellIfHeaderIsEmpty();
			}
			else {
				throw new EolRuntimeException("Cell feed failed to load the header row");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new EolModelLoadingException(e, this.model);
		}
	}

	private CellFeed getHeaderCellFeed() throws Exception {
		final StringBuilder uri = new StringBuilder(this.worksheetEntry.getCellFeedUrl().toString());
		uri.append("?min-row=" + Integer.toString(GSConstants.HEADER_ROW_INDEX));
		uri.append("&max-row=" + Integer.toString(GSConstants.HEADER_ROW_INDEX));
		uri.append("&return-empty=true");
		final URL cellFeedUrl = new URI(uri.toString()).toURL();
		return this.model.getWorksheetCellFeed(cellFeedUrl);
	}

	private void writeValueInFirstCellIfHeaderIsEmpty() throws Exception {
		if (this.headerInWorksheetIsEmpty) {
			this.writeHeaderCell(1, GSConstants.DEFAULT_COLUMN_VALUE);
			super.addColumn(0, GSConstants.DEFAULT_COLUMN_VALUE);
			this.headerInWorksheetIsEmpty = false;
		}
	}

	public void writeHeaderCell(final int columnIndex, final String columnName) throws Exception {
		final CellFeed cellFeed = this.getHeaderCellFeed();
		final CellEntry cellEntry = new CellEntry(GSConstants.HEADER_ROW_INDEX, columnIndex, columnName);
		cellFeed.insert(cellEntry);
	}

	/**
	 * Deletes this worksheet from the containing spreadsheet.
	 * 
	 * @throws IOException
	 * @throws ServiceException
	 */
	public void delete() throws Exception {
		this.worksheetEntry.delete();
	}

	@Override
	public SpreadsheetColumn addColumn(final SpreadsheetColumnMetadata metadata) {
		final SpreadsheetColumn column = super.addColumn(metadata);
		if (!StringUtil.isEmpty(column.getName())) {
			this.headerInWorksheetIsEmpty = false;
		}
		return column;
	}

	@Override
	public SpreadsheetColumn createColumn(final int columnIndex) {
		return new GSColumn(this, columnIndex);
	}

	@Override
	public List<SpreadsheetRow> getRows() {
		this.checkThatWorksheetExists();
		if (this.rows == null) {
			try {
				this.rows = new LinkedHashSet<>();
				this.listFeed = this.listFeed.getSelf();
				for (final ListEntry listEntry : this.listFeed.getEntries()) {
					final GSRow row = new GSRow(this, listEntry);
					this.rows.add(row);
				}
			}
			catch (Exception e) {
				e.printStackTrace();
				throw new IllegalStateException(e.getMessage());
			}
		}
		return new ArrayList<>(this.rows);
	}

	@Override
	protected SpreadsheetRow insertRow(final Map<SpreadsheetColumn, String> values) {
		this.checkThatWorksheetExists();
		try {
			ListEntry listEntry = new ListEntry();
			for (final Map.Entry<SpreadsheetColumn, String> entry : values.entrySet()) {
				final GSColumn column = (GSColumn) entry.getKey();
				String value = entry.getValue().equals("") ? this.getDefaultEmptyCellValue() : entry.getValue();
				listEntry.getCustomElements().setValueLocal(column.getGoogleColumnId(), value);
			}
			listEntry = this.model.insertRow(worksheetEntry, listEntry);
			this.worksheetEntry = this.worksheetEntry.getSelf();

			final GSRow row = new GSRow(this, listEntry);
			this.rows.add(row);
			return row;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public void removeRow(final SpreadsheetRow row) {
		this.checkThatWorksheetExists();
		try {
			final int rowIndex = new ArrayList<>(this.rows).indexOf(row);
			this.listFeed = this.listFeed.getSelf();
			this.listFeed.getEntries().get(rowIndex).delete();
			this.worksheetEntry = this.worksheetEntry.getSelf();
			this.rows.remove(row);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	protected void checkThatWorksheetExists() {
		this.createInSpreadsheet();
		try {
			this.getGoogleColumnIds();
		}
		catch (EolRuntimeException e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}

	}

	@Override
	public String getDefaultEmptyCellValue() {
		return " ";
	}

	public int getColumnOffset() {
		return 1;
	}

	/**
	 * Returns the List Feed URL for working with this worksheet.
	 * 
	 * @return URL
	 * @throws ServiceException
	 * @throws IOException
	 */
	public URL getListFeedURL() throws IOException, ServiceException {
		this.worksheetEntry = this.worksheetEntry.getSelf();
		return this.worksheetEntry.getListFeedUrl();
	}

	public int getRowIndex(GSRow row) {
		return new ArrayList<>(this.rows).indexOf(row);
	}

	public ListEntry getListEntry(final GSRow row) throws IOException, ServiceException {
		this.worksheetEntry = this.worksheetEntry.getSelf();
		this.listFeed = this.listFeed.getSelf();
		int i = this.getRowIndex(row);
		return this.listFeed.getEntries().get(i);
	}

	@Override
	protected void createInSpreadsheet() {
		try {
			if (!super.existsInSpreadsheet) {
				this.worksheetEntry = this.model.insertWorksheet(this.worksheetEntry);
				super.existsInSpreadsheet = true;
				this.writeHeader();
				this.worksheetEntry = this.worksheetEntry.getSelf();
				this.initialiseListFeed();
				this.getGoogleColumnIds();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
	}

	private void writeHeader() throws Exception {
		for (final SpreadsheetColumn column : this.getHeader().getColumns()) {
			if (!StringUtil.isEmpty(column.getName())) {
				this.writeHeaderCell(column.getIndex() + this.getColumnOffset(), column.getName());
				this.headerInWorksheetIsEmpty = false;
			}
		}
		this.writeValueInFirstCellIfHeaderIsEmpty();
	}

	private void getGoogleColumnIds() throws EolRuntimeException {
		super.checkThatWorksheetExists();
		if (this.hasGoogleIdsSet) {
			return;
		}

		try {
			this.hasGoogleIdsSet = true;
			final int maxColIndex = this.getHeader().getColumns().last().getIndex() + this.getColumnOffset();
			final int rowIndex = this.getRows().size() + GSConstants.HEADER_ROW_INDEX + 1;
			this.extendWorksheet(rowIndex);
			this.writeTemporaryRow(rowIndex, maxColIndex);
			final GSRow temporaryRow = this.loadGoogleColumnIds(rowIndex, maxColIndex);
			this.rows.add(temporaryRow);
			this.removeRow(temporaryRow);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new EolRuntimeException(e.getMessage());
		}
	}

	private void extendWorksheet(final int rowIndex) throws IOException, ServiceException {
		this.worksheetEntry = this.worksheetEntry.getSelf();
		if (this.worksheetEntry.getRowCount() < rowIndex) {
			this.worksheetEntry.setRowCount(rowIndex + GSConstants.DEFAULT_WORKSHEET_ROWS);
			this.worksheetEntry = this.worksheetEntry.update();
		}
	}

	private void writeTemporaryRow(final int rowIndex, final int lastColumnIndex) throws Exception {
		final StringBuilder uri = new StringBuilder(this.worksheetEntry.getCellFeedUrl().toString());
		uri.append("?min-row=" + Integer.toString(rowIndex));
		uri.append("&max-row=" + Integer.toString(rowIndex));
		uri.append("&min-col=1&max-col=" + Integer.toString(lastColumnIndex));
		uri.append("&return-empty=true");
		final URL cellFeedUrl = new URI(uri.toString()).toURL();
		final CellFeed cellFeed = this.model.getWorksheetCellFeed(cellFeedUrl);
		for (final CellEntry cell : cellFeed.getEntries()) {
			cell.changeInputValueLocal(GSConstants.DEFAULT_COLUMN_VALUE);
			cell.update();
		}
	}

	private GSRow loadGoogleColumnIds(final int rowIndex, final int lastColumnIndex) throws Exception {
		final StringBuilder uri = new StringBuilder(this.worksheetEntry.getListFeedUrl().toString());
		uri.append("?start-index=" + Integer.toString(rowIndex - GSConstants.HEADER_ROW_INDEX));
		uri.append("&max-results=1");
		final URL listFeedUrl = new URL(uri.toString());
		final ListFeed listFeed = this.model.getWorksheetListFeed(listFeedUrl);
		final List<ListEntry> listEntries = listFeed.getEntries();
		if (listEntries.size() == 1) {
			final ListEntry temporaryRow = listEntries.get(0);
			this.extractGoogleIdsFromRow(temporaryRow, lastColumnIndex);
			return new GSRow(this, temporaryRow);
		}
		else {
			throw new IllegalStateException("Failed to retrieve temporary row");
		}
	}

	private void extractGoogleIdsFromRow(final ListEntry row, final int lastColumnIndex) {
		int columnIndex = 1 - this.getColumnOffset();
		final Iterator<String> it = row.getCustomElements().getTags().iterator(); // Google preserves column ordering
		while (it.hasNext()) {
			final String googleColumnId = it.next();
			final GSColumn column = (GSColumn) super.getColumn(columnIndex);
			if (column != null) {
				column.setGoogleColumnId(googleColumnId);
			}
			final boolean lastColumnReached = columnIndex == lastColumnIndex;
			if (lastColumnReached) {
				break;
			}
			columnIndex++;
		}
	}

	public void getSelf() throws Exception {
		this.worksheetEntry = this.worksheetEntry.getSelf();
	}

}
