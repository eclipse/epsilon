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
import static org.junit.Assert.fail;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.easymock.classextension.EasyMock;
import org.easymock.IMocksControl;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.junit.Test;

public class SpreadsheetPropertySetterTest {
	IMocksControl control = EasyMock.createControl();

	@Test
	public void testEditNull() throws EolRuntimeException {
		SpreadsheetRow row = null;
		final String columnName = "COLUMN";
		final String value = "VALUE";
		SpreadsheetModel model = control.createMock(SpreadsheetModel.class);

		control.reset();

		control.replay();

		SpreadsheetPropertySetter setter = new SpreadsheetPropertySetter(model);
		setter.setObject(row);
		setter.setProperty(columnName);

		try {
			setter.invoke(value);
			fail();
		}
		catch (Exception e) {
			assertTrue(true); // exception from JavaPropertySetter
		}
	}

	@Test
	public void testSettingToNull() throws EolRuntimeException {
		SpreadsheetRow row = control.createMock(SpreadsheetRow.class);
		final String columnName = "COLUMN";
		final String value = null;
		SpreadsheetModel model = control.createMock(SpreadsheetModel.class);
		SpreadsheetColumn column = control.createMock(SpreadsheetColumn.class);

		control.reset();

		expect(row.getColumn(columnName)).andReturn(column);
		expect(row.getReferencesBySource(column)).andReturn(new HashSet<SpreadsheetReference>());
		expect(row.getReferencesByTarget(column)).andReturn(new HashSet<SpreadsheetReference>());
		expect(column.isMany()).andReturn(true);
		expect(column.getDelimiter()).andReturn(",");
		row.writeVisibleCellValues(column, Arrays.asList("null"));

		control.replay();

		SpreadsheetPropertySetter setter = new SpreadsheetPropertySetter(model);
		setter.setObject(row);
		setter.setProperty(columnName);
		setter.invoke(value);
	}

	@Test
	public void testColumnNull() throws EolRuntimeException {
		SpreadsheetRow row = control.createMock(SpreadsheetRow.class);
		final String columnName = null;
		final String value = null;
		SpreadsheetModel model = control.createMock(SpreadsheetModel.class);

		control.reset();

		expect(row.getColumn(columnName)).andReturn(null);

		control.replay();

		SpreadsheetPropertySetter setter = new SpreadsheetPropertySetter(model);
		setter.setObject(row);
		setter.setProperty(columnName);

		try {
			setter.invoke(value);
			fail();
		}
		catch (EolRuntimeException e) {
			assertTrue(true);
		}
	}

	@Test
	public void testColumnNotMany() throws EolRuntimeException {
		SpreadsheetRow row = control.createMock(SpreadsheetRow.class);
		final String columnName = "COLUMN";
		final String value = "VALUE";
		SpreadsheetModel model = control.createMock(SpreadsheetModel.class);
		SpreadsheetColumn column = control.createMock(SpreadsheetColumn.class);

		control.reset();

		expect(row.getColumn(columnName)).andReturn(column);
		expect(row.getReferencesBySource(column)).andReturn(new HashSet<SpreadsheetReference>());
		expect(row.getReferencesByTarget(column)).andReturn(new HashSet<SpreadsheetReference>());
		expect(column.isMany()).andReturn(false);
		row.writeVisibleCellValues(column, Arrays.asList(value));

		control.replay();

		SpreadsheetPropertySetter setter = new SpreadsheetPropertySetter(model);
		setter.setObject(row);
		setter.setProperty(columnName);
		setter.invoke(value);
	}

	@Test
	public void testColumnMany() throws EolRuntimeException {
		SpreadsheetRow row = control.createMock(SpreadsheetRow.class);
		final String columnName = "COLUMN";
		final String value = "VALUE";
		SpreadsheetModel model = control.createMock(SpreadsheetModel.class);
		SpreadsheetColumn column = control.createMock(SpreadsheetColumn.class);

		control.reset();

		expect(row.getColumn(columnName)).andReturn(column);
		expect(row.getReferencesBySource(column)).andReturn(new HashSet<SpreadsheetReference>());
		expect(row.getReferencesByTarget(column)).andReturn(new HashSet<SpreadsheetReference>());
		expect(column.isMany()).andReturn(true);
		expect(column.getDelimiter()).andReturn(",");
		row.writeVisibleCellValues(column, Arrays.asList(value));

		control.replay();

		SpreadsheetPropertySetter setter = new SpreadsheetPropertySetter(model);
		setter.setObject(row);
		setter.setProperty(columnName);
		setter.invoke(value);
	}

	@Test
	public void testEditReferencingCellWithoutRow() throws EolRuntimeException {
		SpreadsheetRow row = control.createMock(SpreadsheetRow.class);
		final String columnName = "COLUMN";
		final String value = "VALUE";
		SpreadsheetModel model = control.createMock(SpreadsheetModel.class);
		SpreadsheetColumn column = control.createMock(SpreadsheetColumn.class);
		Set<SpreadsheetReference> sourceReferences = new HashSet<>();
		SpreadsheetReference reference = control.createMock(SpreadsheetReference.class);
		sourceReferences.add(reference);

		control.reset();

		expect(row.getColumn(columnName)).andReturn(column);
		expect(row.getReferencesBySource(column)).andReturn(sourceReferences);
		expect(row.getReferencesByTarget(column)).andReturn(new HashSet<SpreadsheetReference>());

		control.replay();

		SpreadsheetPropertySetter setter = new SpreadsheetPropertySetter(model);
		setter.setObject(row);
		setter.setProperty(columnName);

		try {
			setter.invoke(value);
			fail();
		}
		catch (IllegalArgumentException e) {
			assertTrue(true);
		}
	}

	@Test
	public void testEditReferencingCellWithRow() throws EolRuntimeException {
		SpreadsheetRow row = control.createMock(SpreadsheetRow.class);
		final String columnName = "COLUMN";
		SpreadsheetRow valueRow = control.createMock(SpreadsheetRow.class);
		SpreadsheetModel model = control.createMock(SpreadsheetModel.class);
		SpreadsheetColumn column = control.createMock(SpreadsheetColumn.class);
		Set<SpreadsheetReference> sourceReferences = new HashSet<>();
		SpreadsheetReference reference = control.createMock(SpreadsheetReference.class);
		sourceReferences.add(reference);
		SpreadsheetWorksheet targetWorksheet = control.createMock(SpreadsheetWorksheet.class);
		final List<String> newValues = new ArrayList<>();
		newValues.add("V1");
		SpreadsheetColumn targetColumn = control.createMock(SpreadsheetColumn.class);
		final List<String> currentValues = new ArrayList<>();
		currentValues.add("V1");
		currentValues.add("V2");
		currentValues.add("V3");
		currentValues.add("V4");

		control.reset();

		expect(row.getColumn(columnName)).andReturn(column);
		expect(row.getReferencesBySource(column)).andReturn(sourceReferences).times(2);
		expect(row.getReferencesByTarget(column)).andReturn(new HashSet<SpreadsheetReference>());
		expect(reference.getReferencedWorksheet()).andReturn(targetWorksheet);
		expect(valueRow.getWorksheet()).andReturn(targetWorksheet);
		expect(reference.getReferencedColumn()).andReturn(targetColumn);
		expect(valueRow.getAllVisibleCellValues(targetColumn)).andReturn(currentValues);
		expect(column.isNotMany()).andReturn(true).times(2);
		expect(row.getReferencesByTarget(column)).andReturn(new HashSet<SpreadsheetReference>());
		row.writeVisibleCellValues(column, newValues);

		control.replay();

		SpreadsheetPropertySetter setter = new SpreadsheetPropertySetter(model);
		setter.setObject(row);
		setter.setProperty(columnName);
		setter.invoke(valueRow);
	}
}
