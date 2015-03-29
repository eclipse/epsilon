/*******************************************************************************
 * Copyright (c) 2012 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Martins Francis - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.emc.spreadsheets.excel.dt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.eclipse.epsilon.common.util.StringProperties;
import org.eclipse.epsilon.emc.spreadsheets.excel.ExcelModel;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.epsilon.eol.models.IRelativePathResolver;
import org.eclipse.equinox.security.storage.ISecurePreferences;
import org.eclipse.equinox.security.storage.SecurePreferencesFactory;
import org.eclipse.equinox.security.storage.StorageException;

public class SecureExcelModel extends ExcelModel
{
	private static final Logger LOGGER = LoggerFactory.getLogger(SecureExcelModel.class);

	@Override
	public void load(final StringProperties properties, final IRelativePathResolver resolver)
			throws EolModelLoadingException
	{
		try
		{
			final String password = this.loadPassword(properties);
			properties.put(ExcelModel.SPREADSHEET_PASSWORD, password);

			super.load(properties, resolver);
		}
		catch (Exception e)
		{
			LOGGER.debug(e.getMessage());
			throw new EolModelLoadingException(e, this);
		}
	}

	public String loadPassword(final StringProperties properties) throws StorageException
	{
		final ISecurePreferences preferences = SecurePreferencesFactory.getDefault();
		if (preferences != null)
		{
			// Password is stored in the vault associated with the file name
			final String fileName = properties.getProperty(ExcelModel.SPREADSHEET_FILE);
			if (preferences.nodeExists(fileName))
			{
				final ISecurePreferences node = preferences.node(fileName);
				return node.get(ExcelModel.SPREADSHEET_PASSWORD, null);
			}
			else
			{
				final String message = "Equinox Security could not find password for '" + fileName + "'";
				LOGGER.error(message);
				throw new RuntimeException(message);
			}
		}
		else
		{
			final String message = "Equinox Security was unable to create secure preferences using default location";
			LOGGER.error(message);
			throw new RuntimeException(message);
		}
	}

}
