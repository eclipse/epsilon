/*********************************************************************
* Copyright (c) 2008 The University of York.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.emc.spreadsheets.test;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Properties;
import org.eclipse.epsilon.common.util.StringUtil;
import org.eclipse.epsilon.emc.spreadsheets.SpreadsheetModel;
import org.eclipse.epsilon.emc.spreadsheets.excel.ExcelModel;
import org.eclipse.epsilon.emc.spreadsheets.google.GSModel;

public class TestModelFactory {
	private static final String GOOGLE_TESTS_ENABLED = "google_tests_enabled";
	private static final String GOOGLE_USERNAME = "google_account_username";
	private static final String GOOGLE_PASSWORD = "google_account_password";
	private static Properties properties = new Properties();

	static {
		try {
			properties.load(new FileInputStream(SharedTestMethods.getBasePath() + "resources/properties.txt"));
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static GSModel getGSModel(String name, String configPath, String modelName) throws Exception {
		if (properties.getProperty(GOOGLE_TESTS_ENABLED).equalsIgnoreCase("yes")) {
			GSModel model = TestModelFactory.getGSModelNotLoaded(name, modelName);
			model.setConfigurationFile(SharedTestMethods.getBasePath() + configPath);
			model.load();
			return model;
		}
		else {
			return null;
		}
	}

	public static ExcelModel getExcelModel(String filePath, String configPath, String modelName) throws Exception {
		ExcelModel model = TestModelFactory.getExcelModelNotLoaded(filePath, modelName);
		model.setConfigurationFile(SharedTestMethods.getBasePath() + configPath);
		model.load();
		return model;
	}

	private static void setModelName(SpreadsheetModel model, String modelName) {
		if (!StringUtil.isEmpty(modelName)) {
			model.setName(modelName);
		}
	}

	public static GSModel getGSModelNotLoaded(String name, String modelName) throws Exception {
		if (properties.getProperty(GOOGLE_TESTS_ENABLED).equalsIgnoreCase("yes")) {
			GSModel model = new GSModel();
			model.setUsername(properties.getProperty(GOOGLE_USERNAME));
			model.setPassword(properties.getProperty(GOOGLE_PASSWORD));
			model.setSpreadsheetName(name);
			TestModelFactory.setModelName(model, modelName);
			return model;
		}
		else {
			return null;
		}
	}

	public static ExcelModel getExcelModelNotLoaded(String filePath, String modelName) {
		ExcelModel model = new ExcelModel();
		model.setSpreadsheetFile(SharedTestMethods.getBasePath() + filePath);
		TestModelFactory.setModelName(model, modelName);
		return model;
	}

	public static Collection<Object[]> getModelsToTest(String modelName, String excelFile, String configPath,
		String googleFileName) throws Exception {
		List<Object> testModels = new ArrayList<>();
		testModels.add(TestModelFactory.getExcelModel(excelFile, configPath, modelName));
		GSModel model = TestModelFactory.getGSModel(googleFileName, configPath, modelName);
		if (model != null) {
			return Arrays.asList(new Object[][] { { testModels.get(0) }, { model } });
		}
		return Arrays.asList(new Object[][] { { testModels.get(0) } });
	}

	public static Collection<Object[]> getModelsToTest(String modelName, String excelFile, String googleFileName)
		throws Exception {
		List<Object> testModels = new ArrayList<>();
		testModels.add(TestModelFactory.getExcelModelNotLoaded(excelFile, modelName));
		GSModel model = TestModelFactory.getGSModelNotLoaded(googleFileName, modelName);
		if (model != null) {
			return Arrays.asList(new Object[][] { { testModels.get(0) }, { model } });
		}
		return Arrays.asList(new Object[][] { { testModels.get(0) } });
	}

}
