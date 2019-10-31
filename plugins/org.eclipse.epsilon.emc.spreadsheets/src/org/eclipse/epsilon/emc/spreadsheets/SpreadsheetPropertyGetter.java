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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.introspection.java.JavaPropertyGetter;

/**
 * This class allows querying spreadsheet rows. Both individual rows and collections of rows can be queried. If a single
 * row is queried the value stored by the column in the row is returned. If a collection of rows is queried then a list
 * of such values is returned. When querying a referencing cell any referenced rows from the target worksheet are
 * returned. If the reference is one-to-one then the first target row is returned, otherwise all such rows are returned.
 * 
 * @author Martins Francis
 */
public class SpreadsheetPropertyGetter extends JavaPropertyGetter
{
	private final SpreadsheetModel model;

	public SpreadsheetPropertyGetter(final SpreadsheetModel model)
	{
		this.model = model;
	}

	@Override
	public Object invoke(final Object object, final String columnIdentifier) throws EolRuntimeException
	{
		if (object instanceof Collection<?>)
		{
			return this.query((Collection<?>) object, columnIdentifier);
		}
		else if (object instanceof SpreadsheetRow)
		{
			return this.query((SpreadsheetRow) object, columnIdentifier);
		}
		else
		{
			return super.invoke(object, columnIdentifier);
		}
	}

	public List<Object> query(final Collection<?> collection, final String column) throws EolRuntimeException
	{
		final List<Object> valuesToReturn = new ArrayList<>();
		for (final Object object : collection)
		{
			final Object queryResult = this.invoke(object, column);
			if (queryResult instanceof Collection)
			{
				valuesToReturn.addAll((Collection<?>) queryResult);
			}
			else
			{
				valuesToReturn.add(queryResult);
			}
		}
		return valuesToReturn;
	}

	public Object query(final SpreadsheetRow row, final String columnIdentifier) throws EolRuntimeException
	{
		if (row.getModel() != this.model)
		{
			throw new EolRuntimeException("Row does not belong to model '" + this.model.getName() + "'");
		}

		if (StringUtils.isBlank(columnIdentifier))
		{
			throw new EolRuntimeException("Column identifier '" + columnIdentifier + "' is blank");
		}

		if (columnIdentifier.startsWith(SpreadsheetConstants.PREFIX_VALUE))
		{
			final int lengthOfPrefix = SpreadsheetConstants.PREFIX_COLUMN.length();
			final SpreadsheetColumn column = row.getColumn(columnIdentifier.substring(lengthOfPrefix));
			return row.getVisibleCellValue(column);
		}
		else
		{
			final SpreadsheetColumn column = row.getColumn(columnIdentifier);
			return this.query(row, column);
		}
	}

	public Object query(final SpreadsheetRow row, final SpreadsheetColumn column)
	{
		final boolean columnIsReferencing = CollectionUtils.isNotEmpty(row.getReferencesBySource(column));
		if (columnIsReferencing)
		{
			return this.getValuesFromReferencingCell(row, column);
		}
		else
		{
			return this.getVisibleValuesFromCell(row, column);
		}
	}

	private List<Object> getValuesFromReferencingCell(final SpreadsheetRow row, final SpreadsheetColumn column)
	{
		final Set<Object> rowsToReturn = new LinkedHashSet<>();
		final List<String> cellValues = row.getAllVisibleCellValues(column);
		if (CollectionUtils.isNotEmpty(cellValues))
		{
			final Set<SpreadsheetReference> references = row.getReferencesBySource(column);
			for (final SpreadsheetReference reference : references)
			{
				final SpreadsheetWorksheet referencedWorksheet = reference.getReferencedWorksheet();
				final SpreadsheetColumn referencedColumn = reference.getReferencedColumn();

				final Iterator<String> it = cellValues.iterator();
				while (it.hasNext())
				{
					List<SpreadsheetRow> referencedRows = referencedWorksheet.findRows(referencedColumn, it.next());
					if (reference.isMany())
					{
						rowsToReturn.addAll(referencedRows);
					}
					else
					{
						if (CollectionUtils.isNotEmpty(referencedRows))
						{
							rowsToReturn.add(referencedRows.get(0));
						}
					}

				}
			}
		}
		return new ArrayList<>(rowsToReturn);
	}

	private Object getVisibleValuesFromCell(final SpreadsheetRow row, final SpreadsheetColumn column)
	{
		List<Object> returnObjects = new ArrayList<>(row.getAllVisibleCellValues(column));
		if (column.isMany())
		{
			return returnObjects;
		}
		else
		{
			if (CollectionUtils.isEmpty(returnObjects))
			{
				return null;
			}
			else
			{
				return returnObjects.iterator().next();
			}
		}
	}

}
