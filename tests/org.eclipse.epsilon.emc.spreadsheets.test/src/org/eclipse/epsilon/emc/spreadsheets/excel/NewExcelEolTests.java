package org.eclipse.epsilon.emc.spreadsheets.excel;

import java.io.File;
import java.nio.file.Files;

import org.eclipse.epsilon.emc.spreadsheets.test.SharedTestMethods;
import org.eclipse.epsilon.eol.EolModule;
import org.junit.Test;

public class NewExcelEolTests {
	
	@Test
	public void testNewExcelSpreadsheet() throws Exception {
		
		File spreadsheetFile = Files.createTempFile("", ".xlsx").toFile();
		
		ExcelModel model = getExcelModel(spreadsheetFile, false, true);
		
		EolModule module = new EolModule();
		module.parse("var t : new Team(id='1', mark=10); \n" + 
					 "var s : new Student(firstName='Tom', average=82.1, team=t);");
		module.getContext().getModelRepository().addModel(model);
		module.execute();
		model.dispose();
		
		model = getExcelModel(spreadsheetFile, true, false);
		
		module = new EolModule();
		module.getContext().getModelRepository().addModel(model);
		module.parse(
				"assert(Student.all.size() == 1);" + 
				"assert(Student.all.first().firstName == 'Tom');" +
				"assert(Student.all.first().team.mark == 10);" +
				"assert((Student.all.first().average - 82.1).abs() < 0.01);" +
				"assert(Team.all.first().mark == 10);");
		;
		module.execute();
		
	}
	
	protected ExcelModel getExcelModel(File spreadsheetFile, boolean readOnLoad, boolean storeOnDisposal) throws Exception {
		ExcelModel model = new ExcelModel();
		model.setSpreadsheetFile(spreadsheetFile.getAbsolutePath());
		model.setConfigurationFile(SharedTestMethods.getBasePath() + "resources/excel/teams.config.xml");
		model.setReadOnLoad(readOnLoad);
		model.setStoredOnDisposal(storeOnDisposal);
		model.load();
		return model;
	}
	
}
