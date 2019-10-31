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

import static org.easymock.classextension.EasyMock.expect;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.easymock.IMocksControl;
import org.easymock.classextension.EasyMock;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.junit.Test;

public class SpreadsheetPropertyGetterTest
{
	IMocksControl control = EasyMock.createControl();

	@Test
	public void testColumnNotMany() throws EolRuntimeException
	{
		String columnName = "COLUMN";
		List<String> values = new ArrayList<>();
		values.add("VALUE");
		Set<SpreadsheetReference> sourceReferences = new HashSet<>();
		SpreadsheetModel model = control.createMock(SpreadsheetModel.class);
		SpreadsheetRow row = control.createMock(SpreadsheetRow.class);
		SpreadsheetColumn column = control.createMock(SpreadsheetColumn.class);

		control.reset();

		expect(row.getModel()).andReturn(model);
		expect(row.getColumn(columnName)).andReturn(column);
		expect(row.getAllVisibleCellValues(column)).andReturn(values);
		expect(row.getReferencesBySource(column)).andReturn(sourceReferences);
		expect(column.isMany()).andReturn(false);

		control.replay();

		SpreadsheetPropertyGetter getter = new SpreadsheetPropertyGetter(model);
		Object response = getter.invoke(row, columnName);

		control.verify();

		assertTrue(((String) response).equals("VALUE"));
	}

	@Test
	public void testColumnNotManyAndCellIsBlank() throws EolRuntimeException
	{
		String columnName = "COLUMN";
		List<String> values = new ArrayList<>();
		Set<SpreadsheetReference> sourceReferences = new HashSet<>();
		SpreadsheetModel model = control.createMock(SpreadsheetModel.class);
		SpreadsheetRow row = control.createMock(SpreadsheetRow.class);
		SpreadsheetColumn column = control.createMock(SpreadsheetColumn.class);

		control.reset();

		expect(row.getModel()).andReturn(model);
		expect(row.getColumn(columnName)).andReturn(column);
		expect(row.getAllVisibleCellValues(column)).andReturn(values);
		expect(row.getReferencesBySource(column)).andReturn(sourceReferences);
		expect(column.isMany()).andReturn(false);

		control.replay();

		SpreadsheetPropertyGetter getter = new SpreadsheetPropertyGetter(model);
		Object response = getter.invoke(row, columnName);

		control.verify();

		assertTrue(response == null);
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testColumnIsMany() throws EolRuntimeException
	{
		String columnName = "COLUMN";
		List<String> values = new ArrayList<>();
		values.add("VALUE1");
		values.add("VALUE2");
		Set<SpreadsheetReference> sourceReferences = new HashSet<>();
		SpreadsheetModel model = control.createMock(SpreadsheetModel.class);
		SpreadsheetRow row = control.createMock(SpreadsheetRow.class);
		SpreadsheetColumn column = control.createMock(SpreadsheetColumn.class);

		control.reset();

		expect(row.getModel()).andReturn(model);
		expect(row.getColumn(columnName)).andReturn(column);
		expect(row.getAllVisibleCellValues(column)).andReturn(values);
		expect(row.getReferencesBySource(column)).andReturn(sourceReferences);
		expect(column.isMany()).andReturn(true);

		control.replay();

		SpreadsheetPropertyGetter getter = new SpreadsheetPropertyGetter(model);
		Object response = getter.invoke(row, columnName);

		control.verify();

		assertTrue(((List<String>) response).containsAll(values));
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testColumnIsManyAndCellIsBlank() throws EolRuntimeException
	{
		String columnName = "COLUMN";
		List<String> values = new ArrayList<>();
		Set<SpreadsheetReference> sourceReferences = new HashSet<>();
		SpreadsheetModel model = control.createMock(SpreadsheetModel.class);
		SpreadsheetRow row = control.createMock(SpreadsheetRow.class);
		SpreadsheetColumn column = control.createMock(SpreadsheetColumn.class);

		control.reset();

		expect(row.getModel()).andReturn(model);
		expect(row.getColumn(columnName)).andReturn(column);
		expect(row.getAllVisibleCellValues(column)).andReturn(values);
		expect(row.getReferencesBySource(column)).andReturn(sourceReferences);
		expect(column.isMany()).andReturn(true);

		control.replay();

		SpreadsheetPropertyGetter getter = new SpreadsheetPropertyGetter(model);
		Object response = getter.invoke(row, columnName);

		control.verify();

		assertTrue(((List<String>) response).size() == 0);
	}

	@Test
	public void testCollection() throws EolRuntimeException
	{
		SpreadsheetRow row1 = control.createMock(SpreadsheetRow.class);
		SpreadsheetRow row2 = control.createMock(SpreadsheetRow.class);
		List<SpreadsheetRow> rows = new ArrayList<>();
		rows.add(row1);
		rows.add(row2);

		String columnName = "COLUMN";
		List<String> values1 = new ArrayList<>();
		values1.add("VALUE1");
		List<String> values2 = new ArrayList<>();
		values2.add("VALUE2");

		Set<SpreadsheetReference> sourceReferences = new HashSet<>();
		SpreadsheetModel model = control.createMock(SpreadsheetModel.class);
		SpreadsheetColumn column = control.createMock(SpreadsheetColumn.class);

		control.reset();

		expect(row1.getModel()).andReturn(model);
		expect(row1.getColumn(columnName)).andReturn(column);
		expect(row1.getAllVisibleCellValues(column)).andReturn(values1);
		expect(row1.getReferencesBySource(column)).andReturn(sourceReferences);
		expect(column.isMany()).andReturn(false);

		expect(row2.getModel()).andReturn(model);
		expect(row2.getColumn(columnName)).andReturn(column);
		expect(row2.getAllVisibleCellValues(column)).andReturn(values2);
		expect(row2.getReferencesBySource(column)).andReturn(sourceReferences);
		expect(column.isMany()).andReturn(false);

		control.replay();

		SpreadsheetPropertyGetter getter = new SpreadsheetPropertyGetter(model);
		Object response = getter.invoke(rows, columnName);

		control.verify();

		@SuppressWarnings("unchecked")
		Iterator<String> it = ((List<String>) response).iterator();
		String value1 = it.next();
		String value2 = it.next();
		assertTrue(value1.equals("VALUE1") && value2.equals("VALUE2") || value1.equals("VALUE2")
				&& value2.equals("VALUE1"));
	}
}
