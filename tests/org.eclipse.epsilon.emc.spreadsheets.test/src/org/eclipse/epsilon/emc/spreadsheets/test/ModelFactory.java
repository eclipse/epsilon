package org.eclipse.epsilon.emc.spreadsheets.test;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.epsilon.emc.spreadsheets.SpreadsheetModel;
import org.eclipse.epsilon.emc.spreadsheets.excel.ExcelModel;
import org.eclipse.epsilon.emc.spreadsheets.google.GSModel;

public class ModelFactory
{

	public static GSModel getGSModel(String name, String configPath, String modelName) throws Exception
	{
		GSModel model = ModelFactory.getGSModelNotLoaded(name, modelName);
		model.setConfigurationFile(configPath);
		model.load();
		return model;
	}

	public static ExcelModel getExcelModel(String filePath, String configPath, String modelName) throws Exception
	{
		ExcelModel model = ModelFactory.getExcelModelNotLoaded(filePath, modelName);
		model.setConfigurationFile(configPath);
		model.load();
		return model;
	}

	private static void setModelName(SpreadsheetModel model, String modelName)
	{
		if (StringUtils.isNotBlank(modelName))
		{
			model.setName(modelName);
		}
	}

	public static GSModel getGSModelNotLoaded(String name, String modelName) throws Exception
	{
		final Properties properties = new Properties();
		properties.load(new FileInputStream("resources/googleconfig.txt"));

		GSModel model = new GSModel();
		model.setUsername(properties.getProperty("username"));
		model.setPassword(properties.getProperty("password"));
		model.setSpreadsheetName(name);
		ModelFactory.setModelName(model, modelName);
		return model;
	}

	public static ExcelModel getExcelModelNotLoaded(String filePath, String modelName)
	{
		ExcelModel model = new ExcelModel();
		model.setSpreadsheetFile(filePath);
		ModelFactory.setModelName(model, modelName);
		return model;
	}

}
