/*********************************************************************
* Copyright (c) 2008 The University of York.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.emc.csv;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.eclipse.epsilon.eol.exceptions.models.EolModelElementTypeNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolNotInstantiableModelElementTypeException;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ CsvModelTests.LoadModelTests.class,
				CsvModelTests.ModelAccessTests.class,
				CsvModelTests.ElementIdTests.class})
public class CsvModelTests {
	
	private static final String NEWLINE = System.lineSeparator();
	
	public static class LoadModelTests {
		
		@Test
		public void simpleCSV() throws Exception {
			final String csv = "604-78-8459,Ricoriki,Dwyr,rdwyr0@parallels.com,Male,VP Quality Control,,Duis at velit eu est congue elementum.,Horror" + NEWLINE +
							   "212-06-7778,Rabbi,Varran,rvarrand@jugem.jp,Male,GIS Technical Architect,3551249058791476,Suspendisse potenti.,Horror";
			CsvModel model = new CsvModel();
			char fieldSeparator = ',';
			model.setFieldSeparator(fieldSeparator);
			model.setKnownHeaders(false);
			model.setVarargsHeaders(false);
			StringReader reader = new StringReader(csv);
			model.setReader(new BufferedReader(reader));
			model.load();
			Collection<Map<String, Object>> allRows = model.allContentsFromModel();
			assertThat(allRows.size(), is(2));
			for (Map<String, Object> row : allRows) {
				assertThat(row, hasKey("field"));
			}
			Object[] allRowsArray = allRows.toArray();
			String[] csvData = csv.split(NEWLINE);
			for (int i=0;i < allRowsArray.length; i++) {
				@SuppressWarnings("unchecked")
				Map<String, Object> row = (Map<String, Object>) allRowsArray[i];
				@SuppressWarnings("unchecked")
				List<String> csvRowValues = (List<String>) row.get("field");
				String[] rowData = csvData[i].split(String.valueOf(fieldSeparator));
				assertThat(String.format("Row data matches csv values, row = %s.", i), rowData, arrayContaining(csvRowValues.toArray()));
			}
		}
		
		@Test
		public void simpleCSVOtherSeparator() throws Exception {
			final String csv = "604-78-8459;Ricoriki;Dwyr;rdwyr0@parallels.com;Male;VP Quality Control;;Duis at velit eu est congue elementum.;Horror" + NEWLINE +
							   "212-06-7778;Rabbi;Varran;rvarrand@jugem.jp;Male;GIS Technical Architect;3551249058791476;Suspendisse potenti.;Horror";
			CsvModel model = new CsvModel();
			char fieldSeparator = ',';
			model.setFieldSeparator(fieldSeparator);
			model.setKnownHeaders(false);
			model.setVarargsHeaders(false);
			StringReader reader = new StringReader(csv);
			model.setReader(new BufferedReader(reader));
			model.load();
			Collection<Map<String, Object>> allRows = model.allContentsFromModel();
			assertThat(allRows.size(), is(2));
			for (Map<String, Object> row : allRows) {
				assertThat(row, hasKey("field"));
			}
			Object[] allRowsArray = allRows.toArray();
			String[] csvData = csv.split(NEWLINE);
			for (int i=0;i < allRowsArray.length; i++) {
				@SuppressWarnings("unchecked")
				Map<String, Object> row = (Map<String, Object>) allRowsArray[i];
				@SuppressWarnings("unchecked")
				List<String> csvRowValues = (List<String>) row.get("field");
				String[] rowData = csvData[i].split(String.valueOf(fieldSeparator));
				assertThat(String.format("Row data matches csv values, row = %s.", i), rowData, arrayContaining(csvRowValues.toArray()));
			}
		}
		
		@Test
		public void simpleCSVWithHeaders() throws Exception {
			final String[] headers = new String[]{"id","first_name","last_name","email","gender","job","credit_card","quote","movies"}; 
			final char fieldSeparator = ',';
			final String csv = "id,first_name,last_name,email,gender,job,credit_card,quote,movies" + NEWLINE + 
							   "604-78-8459,Ricoriki,Dwyr,rdwyr0@parallels.com,Male,VP Quality Control,,Duis at velit eu est congue elementum.,Horror" + NEWLINE +
							   "212-06-7778,Rabbi,Varran,rvarrand@jugem.jp,Male,GIS Technical Architect,3551249058791476,Suspendisse potenti.,Horror" + NEWLINE +
							   "318-48-3006,Constantino,Eyckelbeck,ceyckelbeckf@histats.com,Male,Recruiter,564182300132483644,In hac habitasse platea dictumst. Maecenas ut massa quis augue luctus tincidunt.,War";
			CsvModel model = new CsvModel();
			model.setKnownHeaders(true);
			model.setVarargsHeaders(false);
			StringReader reader = new StringReader(csv);
			model.setReader(new BufferedReader(reader));
			model.load();
			Collection<Map<String, Object>> allRows = model.allContentsFromModel();
			assertThat("All rows have ben read", allRows.size(), is(3));
			for (Map<String, Object> row : allRows) {
				assertThat(row, hasKey("id"));
				assertThat(row, hasKey("first_name"));
				assertThat(row, hasKey("last_name"));
				assertThat(row, hasKey("email"));
				assertThat(row, hasKey("gender"));
				assertThat(row, hasKey("job"));
				assertThat(row, hasKey("credit_card"));
				assertThat(row, hasKey("quote"));
				assertThat(row, hasKey("movies"));
			}
			Object[] allRowsArray = allRows.toArray();
			String[] csvData = csv.split(NEWLINE);
			for (int i=0;i < allRowsArray.length; i++) {
				@SuppressWarnings("unchecked")
				Map<String, Object> row = (Map<String, Object>) allRowsArray[i];
				String[] rowData = csvData[i+1].split(String.valueOf(fieldSeparator));
				for (int j=0; j<headers.length; j++) {
					assertThat(String.format("Row data matches csv field %s, row = %s.", headers[j], i),
								row.get(headers[j]), is(rowData[j]));
				}
			}
		}
		
		@Test
		public void varargsCSVWithHeaders() throws Exception {
			final String[] headers = new String[]{"id","first_name","last_name","email","gender","job","credit_card","quote","movies"}; 
			char fieldSeparator = ',';
			final String csv = "id,first_name,last_name,email,gender,job,credit_card,quote,movies" + NEWLINE + 
							   "604-78-8459,Ricoriki,Dwyr,rdwyr0@parallels.com,Male,VP Quality Control,,Duis at velit eu est congue elementum.,Horror" + NEWLINE +
							   "272-41-1349,Norry,Halpin,nhalpin1@slashdot.org,Female,Legal Assistant,,Aenean sit amet justo. Morbi ut odio.,Drama,Film-Noir,Thriller" + NEWLINE +
							   "850-05-5333,Flossy,Mobberley,fmobberley7@msn.com,Female,Chief Design Engineer,3558038696922012,Nulla tempus.,Comedy,Romance";
			CsvModel model = new CsvModel();
			model.setFieldSeparator(fieldSeparator);
			model.setKnownHeaders(true);
			model.setVarargsHeaders(true);
			StringReader reader = new StringReader(csv);
			model.setReader(new BufferedReader(reader));
			model.load();
			Collection<Map<String, Object>> allRows = model.allContentsFromModel();
			assertThat("All rows have ben read", allRows.size(), is(3));
			for (Map<String, Object> row : allRows) {
				assertThat(row, hasKey("id"));
				assertThat(row, hasKey("first_name"));
				assertThat(row, hasKey("last_name"));
				assertThat(row, hasKey("email"));
				assertThat(row, hasKey("gender"));
				assertThat(row, hasKey("job"));
				assertThat(row, hasKey("credit_card"));
				assertThat(row, hasKey("quote"));
				assertThat(row, hasKey("movies"));
			}
			Object[] allRowsArray = allRows.toArray();
			String[] csvData = csv.split(NEWLINE);
			for (int i=0;i < allRowsArray.length; i++) {
				@SuppressWarnings("unchecked")
				Map<String, Object> row = (Map<String, Object>) allRowsArray[i];
				String[] rowData = csvData[i+1].split(String.valueOf(fieldSeparator));
				for (int j=0; j<headers.length; j++) {
					//Varargs
					if (j == headers.length-1) {
						List<String> varargRowData = new ArrayList<String>();
						for(int k=0; k<rowData.length-headers.length+1;k++) {
							varargRowData.add(rowData[j+k]);
						}
						assertThat(String.format("Row data matches csv field %s, row = %s.", headers[j], i),
								row.get(headers[j]), is(varargRowData));
					}
					else {
						assertThat(String.format("Row data matches csv field %s, row = %s.", headers[j], i),
									row.get(headers[j]), is(rowData[j]));
					}
				}
			}
		}
		
	}
	
	public static class ModelAccessTests {
		
		final String[] headers = new String[]{"id","first_name","last_name","email","gender","job","credit_card","quote","movies"}; 
		
		@Rule
	    public ExpectedException thrown = ExpectedException.none();
		
		private CsvModel model;

		@Before
		public void setup() throws Exception {
			char fieldSeparator = ',';
			final String csv = "id,first_name,last_name,email,gender,job,credit_card,quote,movies" + NEWLINE + 
							   "604-78-8459,Ricoriki,Dwyr,rdwyr0@parallels.com,Male,VP Quality Control,,Duis at velit eu est congue elementum.,Horror" + NEWLINE +
							   "272-41-1349,Norry,Halpin,nhalpin1@slashdot.org,Female,Legal Assistant,,Aenean sit amet justo. Morbi ut odio.,Drama,Film-Noir,Thriller" + NEWLINE +
							   "850-05-5333,Flossy,Mobberley,fmobberley7@msn.com,Female,Chief Design Engineer,3558038696922012,Nulla tempus.,Comedy,Romance";
			model = new CsvModel();
			model.setFieldSeparator(fieldSeparator);
			model.setKnownHeaders(true);
			model.setVarargsHeaders(true);
			StringReader reader = new StringReader(csv);
			model.setReader(new BufferedReader(reader));
			model.load();
		}
		
		@After
		public void teardown() {
			model.dispose();
		}
		
		@Test
		public void testIsModelElement() {
			Random rand = new Random();
			Collection<Map<String, Object>> rows = model.allContentsFromModel();
			int rowIndex = rand.nextInt(rows.size());
			Map<String, Object> row = rows.stream().skip(rowIndex).findFirst().get();
			assertTrue(model.isModelElement(row));
			Map<String, Object> row2 = new LinkedHashMap<>();
			assertFalse(model.isModelElement(row2));
			row2 = new HashMap<String, Object>();
			row2.putAll(row);
			assertFalse(model.isModelElement(row2));
		}

		@Test
		public void testGetTypeOf() {
			Random rand = new Random();
			Collection<Map<String, Object>> rows = model.allContentsFromModel();
			int rowIndex = rand.nextInt(rows.size());
			Map<String, Object> row = rows.stream().skip(rowIndex).findFirst().get();
			assertThat(model.getTypeOf(row), sameInstance(LinkedHashMap.class));
			Map<String, Object> row2 = new LinkedHashMap<>();
			thrown.expect(IllegalArgumentException.class);
	        thrown.expectMessage("Not a valid CSV model instance");
			model.getTypeOf(row2);
			row2 = new HashMap<String, Object>();
			row2.putAll(row);
			model.getTypeOf(row2);
		}

		@Test
		public void testDeleteElementInModel() throws Exception {
			Random rand = new Random();
			Collection<Map<String, Object>> rows = model.allContentsFromModel();
			int size = rows.size();
			int rowIndex = rand.nextInt(rows.size());
			Map<String, Object> row = rows.stream().skip(rowIndex).findFirst().get();
			boolean result = false;
			result = model.deleteElementInModel(row);
			assertTrue(result);
			rows = model.allContentsFromModel();
			assertThat("Size has decreased because element was removed.", rows.size(), is(lessThan(size)));
			Map<String, Object> row2 = new LinkedHashMap<>();
			result = model.deleteElementInModel(row2);
			assertFalse(result);
			
		}

		@Test
		public void testGetAllTypeNamesOf() {
			Random rand = new Random();
			Collection<Map<String, Object>> rows = model.allContentsFromModel();
			int rowIndex = rand.nextInt(rows.size());
			Map<String, Object> row = rows.stream().skip(rowIndex).findFirst().get();
			Collection<String>  names = model.getAllTypeNamesOf(row);
			assertThat("Only one name.", names.size(), is(1));
			assertThat("Name is 'Row'", names, hasItem("Row"));
			Map<String, Object> row2 = new LinkedHashMap<>();
			thrown.expect(IllegalArgumentException.class);
	        thrown.expectMessage("Not a valid CSV model instance");
			model.getAllTypeNamesOf(row2);
			row2 = new HashMap<String, Object>();
			row2.putAll(row);
			model.getAllTypeNamesOf(row2);
		}

		@Test
		public void testGetEnumerationValue() throws Exception {
			thrown.expect(UnsupportedOperationException.class);
	        thrown.expectMessage("CSV Models don't support enumerations.");
			model.getEnumerationValue("enum", "label");
		}

		@Test
		public void testGetTypeNameOf() {
			Random rand = new Random();
			Collection<Map<String, Object>> rows = model.allContentsFromModel();
			int rowIndex = rand.nextInt(rows.size());
			Map<String, Object> row = rows.stream().skip(rowIndex).findFirst().get();
			String name = model.getTypeNameOf(row);
			assertThat("Name is 'Row'", name, is(LinkedHashMap.class.getName()));
			Map<String, Object> row2 = new LinkedHashMap<>();
			thrown.expect(IllegalArgumentException.class);
	        thrown.expectMessage("Not a valid CSV model instance");
			model.getTypeNameOf(row2);
			row2 = new HashMap<String, Object>();
			row2.putAll(row);
			model.getTypeNameOf(row2);
		}

		@Test
		public void testOwns() {
			Random rand = new Random();
			Collection<Map<String, Object>> rows = model.allContentsFromModel();
			int rowIndex = rand.nextInt(rows.size());
			Map<String, Object> row = rows.stream().skip(rowIndex).findFirst().get();
			assertThat("Row is in model", model.owns(row), is(true));
			Map<String, Object> row2 = new LinkedHashMap<>();
			thrown.expect(IllegalArgumentException.class);
	        thrown.expectMessage("Not a valid CSV model instance");
			model.getTypeNameOf(row2);
			row2 = new HashMap<String, Object>();
			row2.putAll(row);
			model.getTypeNameOf(row2);
			
			fail("Not yet implemented");
		}

		@Test
		public void testIsInstantiable() {
			String type = "Row";
			assertThat("Row type is instantiatable.", model.isInstantiable(type), is (true));
			type ="other";
			assertThat("Only Row type is instantiatable", model.isInstantiable(type), is(false));
		}

		@Test
		public void testHasType() {
			String type = "Row";
			assertThat("Row type is known.", model.hasType(type), is (true));
			type ="other";
			assertThat("Only Row type is known", model.hasType(type), is(false));
		}

		@Test
		public void testGetAllOfTypeFromModelString() throws Exception {
			Collection<Map<String, Object>> rows = model.getAllOfTypeFromModel("Row");
			Collection<Map<String, Object>> rows2 = model.allContentsFromModel();
			assertThat(rows, is(rows2));
			thrown.expect(EolModelElementTypeNotFoundException.class);
			rows = model.getAllOfTypeFromModel("TypeA");
		}

		@Test
		public void testGetAllOfKindFromModelString() throws Exception {
			Collection<Map<String, Object>> rows = model.getAllOfKindFromModel("Row");
			Collection<Map<String, Object>> rows2 = model.allContentsFromModel();
			assertThat(rows, is(rows2));
			thrown.expect(EolModelElementTypeNotFoundException.class);
			rows = model.getAllOfKindFromModel("TypeA");
		}

		@Test
		public void testCreateInstanceInModelString() throws Exception, EolNotInstantiableModelElementTypeException {
			Map<String, Object> newRow = model.createInstanceInModel("Row");
			for (int i=0;i<headers.length;i++) {
				String key = headers[i];
				assertThat(String.format("Field %s should be empty", key), newRow.get(key), is(""));
			}
			thrown.expect(EolModelElementTypeNotFoundException.class);
			newRow = model.createInstanceInModel("TypeA");
			
		}

		@Test
		public void testHasProperty() throws Exception {
			for (int i=0;i<headers.length;i++) {
				String key = headers[i];
				assertThat(String.format("Row has property %s.", key), model.hasProperty("Row", key), is(true));
			}
			assertThat("Row doesn't have property someProperty.", model.hasProperty("Row", "someProperty"), is(false));
			model.dispose();
			char fieldSeparator = ',';
			final String csv = "604-78-8459,Ricoriki,Dwyr,rdwyr0@parallels.com,Male,VP Quality Control,,Duis at velit eu est congue elementum.,Horror" + NEWLINE +
							   "272-41-1349,Norry,Halpin,nhalpin1@slashdot.org,Female,Legal Assistant,,Aenean sit amet justo. Morbi ut odio.,Drama,Film-Noir,Thriller" + NEWLINE +
							   "850-05-5333,Flossy,Mobberley,fmobberley7@msn.com,Female,Chief Design Engineer,3558038696922012,Nulla tempus.,Comedy,Romance";
			model = new CsvModel();
			model.setFieldSeparator(fieldSeparator);
			model.setKnownHeaders(false);
			model.setVarargsHeaders(true);
			StringReader reader = new StringReader(csv);
			model.setReader(new BufferedReader(reader));
			model.load();
			assertThat("Row has property field.", model.hasProperty("Row", "field"), is(true));
			assertThat("Row doesn't have property someProperty.", model.hasProperty("Row", "someProperty"), is(false));
			thrown.expect(EolModelElementTypeNotFoundException.class);
			model.hasProperty("TypeA", headers[0]);
		}
		
		
	}

	public static class ElementIdTests {
		
		@Rule
	    public ExpectedException thrown = ExpectedException.none();
		
		@Test
		public void noId() throws Exception {
			char fieldSeparator = ',';
			final String csv = "id,first_name,last_name,email,gender,job,credit_card,quote,movies" + NEWLINE + 
							   "604-78-8459,Ricoriki,Dwyr,rdwyr0@parallels.com,Male,VP Quality Control,,Duis at velit eu est congue elementum.,Horror" + NEWLINE +
							   "272-41-1349,Norry,Halpin,nhalpin1@slashdot.org,Female,Legal Assistant,,Aenean sit amet justo. Morbi ut odio.,Drama,Film-Noir,Thriller" + NEWLINE +
							   "850-05-5333,Flossy,Mobberley,fmobberley7@msn.com,Female,Chief Design Engineer,3558038696922012,Nulla tempus.,Comedy,Romance";
			CsvModel model = new CsvModel();
			model.setFieldSeparator(fieldSeparator);
			model.setKnownHeaders(true);
			model.setVarargsHeaders(true);
			StringReader reader = new StringReader(csv);
			model.setReader(new BufferedReader(reader));
			model.load();
			Random rand = new Random();
			Collection<Map<String, Object>> rows = model.allContentsFromModel();
			int rowIndex = rand.nextInt(rows.size());
			Map<String, Object> row = rows.stream().skip(rowIndex).findFirst().get();
			thrown.expect(UnsupportedOperationException.class);
			thrown.expectMessage("The if field has not been set. To use ids, make sure the launch "
					+ "configuration defines the name or index of the id field.");
			model.getElementId(row);
			model.dispose();
		}
		
		@Test
		public void fieldNameId() throws Exception {
			char fieldSeparator = ',';
			final String csv = "id,first_name,last_name,email,gender,job,credit_card,quote,movies" + NEWLINE + 
							   "604-78-8459,Ricoriki,Dwyr,rdwyr0@parallels.com,Male,VP Quality Control,,Duis at velit eu est congue elementum.,Horror" + NEWLINE +
							   "272-41-1349,Norry,Halpin,nhalpin1@slashdot.org,Female,Legal Assistant,,Aenean sit amet justo. Morbi ut odio.,Drama,Film-Noir,Thriller" + NEWLINE +
							   "850-05-5333,Flossy,Mobberley,fmobberley7@msn.com,Female,Chief Design Engineer,3558038696922012,Nulla tempus.,Comedy,Romance";
			CsvModel model = new CsvModel();
			model.setFieldSeparator(fieldSeparator);
			model.setKnownHeaders(true);
			model.setVarargsHeaders(true);
			model.setIdFieldName("id");
			StringReader reader = new StringReader(csv);
			model.setReader(new BufferedReader(reader));
			model.load();
			Collection<Map<String, Object>> rows = model.allContentsFromModel();
			Map<String, Object> row;
			for (int i=0;i<3; i++) {
				row = rows.stream().skip(i).findFirst().get();
				String id = model.getElementId(row);
				assertThat("Row's id field matches id", row.get("id"), is(id));
			}
			model.dispose();
		}
		
		@Test
		public void fieldIndexId() throws Exception {
			char fieldSeparator = ',';
			final String csv = "604-78-8459,Ricoriki,Dwyr,rdwyr0@parallels.com,Male,VP Quality Control,,Duis at velit eu est congue elementum.,Horror" + NEWLINE +
							   "272-41-1349,Norry,Halpin,nhalpin1@slashdot.org,Female,Legal Assistant,,Aenean sit amet justo. Morbi ut odio.,Drama,Film-Noir,Thriller" + NEWLINE +
							   "850-05-5333,Flossy,Mobberley,fmobberley7@msn.com,Female,Chief Design Engineer,3558038696922012,Nulla tempus.,Comedy,Romance";
			CsvModel model = new CsvModel();
			model.setFieldSeparator(fieldSeparator);
			model.setKnownHeaders(false);
			model.setIdFieldIndex(0);
			StringReader reader = new StringReader(csv);
			model.setReader(new BufferedReader(reader));
			model.load();
			Collection<Map<String, Object>> rows = model.allContentsFromModel();
			Map<String, Object> row;
			for (int i=0;i<3; i++) {
				row = rows.stream().skip(i).findFirst().get();
				String id = model.getElementId(row);
				@SuppressWarnings("unchecked")
				List<String> actual = (List<String>) row.get("field");
				assertThat("Row's id field matches id", actual.get(0), is(id));
			}
			model.dispose();
		}
		
		@Test
		public void getElementBtId() throws Exception {
			char fieldSeparator = ',';
			String csv = "604-78-8459,Ricoriki,Dwyr,rdwyr0@parallels.com,Male,VP Quality Control,,Duis at velit eu est congue elementum.,Horror" + NEWLINE +
							   "272-41-1349,Norry,Halpin,nhalpin1@slashdot.org,Female,Legal Assistant,,Aenean sit amet justo. Morbi ut odio.,Drama,Film-Noir,Thriller" + NEWLINE +
							   "850-05-5333,Flossy,Mobberley,fmobberley7@msn.com,Female,Chief Design Engineer,3558038696922012,Nulla tempus.,Comedy,Romance";
			CsvModel model = new CsvModel();
			model.setFieldSeparator(fieldSeparator);
			model.setKnownHeaders(false);
			model.setIdFieldIndex(0);
			StringReader reader = new StringReader(csv);
			model.setReader(new BufferedReader(reader));
			model.load();
			Collection<Map<String, Object>> rows = model.allContentsFromModel();
			Iterator<Map<String, Object>> it = rows.iterator();
			assertThat("Element matches id.", model.getElementById("604-78-8459"), is(it.next()));
			assertThat("Element matches id.", model.getElementById("272-41-1349"), is(it.next()));
			assertThat("Element matches id.", model.getElementById("850-05-5333"), is(it.next()));
			assertThat("Element matches id.", model.getElementById("someId"), is(nullValue()));
			model.dispose();
			csv = "id,first_name,last_name,email,gender,job,credit_card,quote,movies" + NEWLINE + 
					   "604-78-8459,Ricoriki,Dwyr,rdwyr0@parallels.com,Male,VP Quality Control,,Duis at velit eu est congue elementum.,Horror" + NEWLINE +
					   "272-41-1349,Norry,Halpin,nhalpin1@slashdot.org,Female,Legal Assistant,,Aenean sit amet justo. Morbi ut odio.,Drama,Film-Noir,Thriller" + NEWLINE +
					   "850-05-5333,Flossy,Mobberley,fmobberley7@msn.com,Female,Chief Design Engineer,3558038696922012,Nulla tempus.,Comedy,Romance";
			model.setKnownHeaders(true);
			model.setVarargsHeaders(true);
			model.setIdFieldName("email");
			reader = new StringReader(csv);
			model.setReader(new BufferedReader(reader));
			model.load();
			rows = model.allContentsFromModel();
			it = rows.iterator();
			assertThat("Element matches id.", model.getElementById("rdwyr0@parallels.com"), is(it.next()));
			assertThat("Element matches id.", model.getElementById("nhalpin1@slashdot.org"), is(it.next()));
			assertThat("Element matches id.", model.getElementById("fmobberley7@msn.com"), is(it.next()));
			assertThat("Element matches id.", model.getElementById("someId"), is(nullValue()));
			model.dispose();
		}
		
	}
}
