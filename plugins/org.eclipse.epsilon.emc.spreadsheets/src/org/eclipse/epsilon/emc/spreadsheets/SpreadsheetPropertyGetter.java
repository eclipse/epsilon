/*********************************************************************
* Copyright (c) 2008 The University of York.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.emc.spreadsheets;

import java.util.*;
import org.eclipse.epsilon.common.util.StringUtil;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.introspection.java.JavaPropertyGetter;

/**
 * This class allows querying spreadsheet rows. Both individual rows and
 * collections of rows can be queried. If a single row is queried the value
 * stored by the column in the row is returned. If a collection of rows is
 * queried then a list of such values is returned. When querying a referencing
 * cell any referenced rows from the target worksheet are returned. If the
 * reference is one-to-one then the first target row is returned, otherwise all
 * such rows are returned.
 * 
 * @author Martins Francis
 */
public class SpreadsheetPropertyGetter extends JavaPropertyGetter {
	private final SpreadsheetModel model;

	public SpreadsheetPropertyGetter(final SpreadsheetModel model) {
		this.model = model;
	}

	@Override
	public Object invoke(final Object object, final String columnIdentifier, IEolContext context) throws EolRuntimeException {
		if (object instanceof Collection<?>) {
			return this.query((Collection<?>) object, columnIdentifier, context);
		}
		else if (object instanceof SpreadsheetRow) {
			return this.query((SpreadsheetRow) object, columnIdentifier);
		}
		else {
			return super.invoke(object, columnIdentifier, context);
		}
	}

	public List<Object> query(final Collection<?> collection, final String column, IEolContext context) throws EolRuntimeException {
		final List<Object> valuesToReturn = new ArrayList<>();
		for (final Object object : collection) {
			final Object queryResult = this.invoke(object, column, context);
			if (queryResult instanceof Collection) {
				valuesToReturn.addAll((Collection<?>) queryResult);
			}
			else {
				valuesToReturn.add(queryResult);
			}
		}
		return valuesToReturn;
	}

	public Object query(final SpreadsheetRow row, final String columnIdentifier) throws EolRuntimeException {
		if (row.getModel() != this.model) {
			throw new EolRuntimeException("Row does not belong to model '" + this.model.getName() + "'");
		}

		if (StringUtil.isEmpty(columnIdentifier)) {
			throw new EolRuntimeException("Column identifier '" + columnIdentifier + "' is blank");
		}

		if (columnIdentifier.startsWith(SpreadsheetConstants.PREFIX_VALUE)) {
			final int lengthOfPrefix = SpreadsheetConstants.PREFIX_COLUMN.length();
			final SpreadsheetColumn column = row.getColumn(columnIdentifier.substring(lengthOfPrefix));
			return row.getVisibleCellValue(column);
		}
		else {
			final SpreadsheetColumn column = row.getColumn(columnIdentifier);
			return this.query(row, column);
		}
	}

	public Object query(final SpreadsheetRow row, final SpreadsheetColumn column) {
		Collection<?> rowSourceRefs = row.getReferencesBySource(column);
		if (rowSourceRefs != null && !rowSourceRefs.isEmpty()) {
			return this.getValuesFromReferencingCell(row, column);
		}
		else {
			return this.getVisibleValuesFromCell(row, column);
		}
	}

	private List<Object> getValuesFromReferencingCell(final SpreadsheetRow row, final SpreadsheetColumn column) {
		final Set<Object> rowsToReturn = new LinkedHashSet<>();
		final List<String> cellValues = row.getAllVisibleCellValues(column);
		if (cellValues != null && !cellValues.isEmpty()) {
			final Set<SpreadsheetReference> references = row.getReferencesBySource(column);
			for (final SpreadsheetReference reference : references) {
				final SpreadsheetWorksheet referencedWorksheet = reference.getReferencedWorksheet();
				final SpreadsheetColumn referencedColumn = reference.getReferencedColumn();

				for (String value : cellValues) {
					List<SpreadsheetRow> referencedRows = referencedWorksheet.findRows(referencedColumn, value);
					if (reference.isMany()) {
						rowsToReturn.addAll(referencedRows);
					}
					else if (referencedRows != null && !referencedRows.isEmpty()) {
						rowsToReturn.add(referencedRows.get(0));
					}
				}
			}
		}
		return new ArrayList<>(rowsToReturn);
	}

	private Object getVisibleValuesFromCell(final SpreadsheetRow row, final SpreadsheetColumn column) {
		List<Object> returnObjects = new ArrayList<>(row.getAllVisibleCellValues(column));
		if (column.isMany()) {
			return returnObjects;
		}
		else if (returnObjects != null && !returnObjects.isEmpty()) {
			return returnObjects.iterator().next();
		}
		else {
			return null;
		}
	}
}
