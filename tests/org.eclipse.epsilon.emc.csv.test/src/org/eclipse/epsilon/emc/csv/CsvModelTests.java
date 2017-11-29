package org.eclipse.epsilon.emc.csv;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.arrayContaining;
import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.is;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({CsvModelTests.LoadModelTests.class})
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
				assertThat("Row has 9 fields", csvRowValues.size(), is(9));
				String[] rowData = csvData[i].split(String.valueOf(fieldSeparator));
				assertThat(String.format("Row data matches csv values, row = %s.", i), rowData, arrayContaining(csvRowValues.toArray()));
			}
		}
		
		@Test
		public void simpleCSVOtherSeparator() throws Exception {
			final String csv = "604-78-8459;Ricoriki;Dwyr;rdwyr0@parallels.com;Male;VP Quality Control;;Duis at velit eu est congue elementum.;Horror" + NEWLINE +
							   "212-06-7778;Rabbi;Varran;rvarrand@jugem.jp;Male;GIS Technical Architect;3551249058791476;Suspendisse potenti.;Horror";
			CsvModel model = new CsvModel();
			char fieldSeparator = ';';
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
				assertThat("Row has 9 fields", csvRowValues.size(), is(9));
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
			model.setFieldSeparator(fieldSeparator);
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
				assertThat("Row has 9 fields", row.size(), is(9));
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
			final char fieldSeparator = ',';
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
			assertThat("All rows have ben read", allRows.size(), is(3));
			String[] csvData = csv.split(NEWLINE);
			for (int i=0;i < allRowsArray.length; i++) {
				@SuppressWarnings("unchecked")
				Map<String, Object> row = (Map<String, Object>) allRowsArray[i];
				assertThat("Row has 9 fields", row.size(), is(9));
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
		
		@Test
		public void simpleCSVQuoted() throws Exception {
			final String csv = "605-52-9809,Tull,Ingerith,tingerith8@surveymonkey.com,Male,VP Quality Control,,\"Morbi vestibulum, velit id pretium iaculis, diam erat fermentum justo, nec condimentum neque sapien placerat ante. Nulla justo.\",Drama" + NEWLINE +
							   "164-18-3409,Giffie,Boards,gboardsc@gmpg.org,Male,Graphic Designer,3575314620284632,\"Morbi vel lectus in quam fringilla rhoncus. Mauris enim leo, rhoncus sed, vestibulum sit amet, cursus id, turpis.\",Comedy";
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
				assertThat("Row has 9 fields", csvRowValues.size(), is(9));
				// Can't compare splitting csv String because split will ignore quoted strings too 
			}
		}
	}
}
