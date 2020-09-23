/*********************************************************************
* Copyright (c) 2008 The University of York.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.emc.spreadsheets.google.dt;

import org.eclipse.epsilon.common.dt.launching.dialogs.AbstractModelConfigurationDialog;
import org.eclipse.epsilon.common.dt.util.DialogUtil;
import org.eclipse.epsilon.emc.spreadsheets.google.GSModel;
import org.eclipse.equinox.security.storage.ISecurePreferences;
import org.eclipse.equinox.security.storage.SecurePreferencesFactory;
import org.eclipse.equinox.security.storage.StorageException;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class GSModelConfigurationDialog extends AbstractModelConfigurationDialog {
	
	@Override
	protected String getModelName() {
		return "Google Spreadsheet";
	}

	@Override
	protected String getModelType() {
		return "SecureGSModel";
	}

	protected Label usernameLabel;
	protected Text usernameText;
	protected Label passwordLabel;
	protected Text passwordText;
	protected Label spreadsheetNameLabel;
	protected Text spreadsheetNameText;
	protected Label configFileTextLabel;
	protected Text configFileText;
	protected Button browseConfigFile;

	@Override
	protected void createGroups(final Composite control) {
		createNameAliasGroup(control);
		createConnectionGroup(control);
		createSpreadsheetGroup(control);
		createConfigurationFileGroup(control);
	}

	protected void createConnectionGroup(final Composite parent) {
		final Composite groupContent = DialogUtil.createGroupContainer(parent, "Connection Parameters", 2);
		usernameLabel = new Label(groupContent, SWT.NONE);
		usernameLabel.setText("Username: ");

		usernameText = new Text(groupContent, SWT.BORDER);
		usernameText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		passwordLabel = new Label(groupContent, SWT.NONE);
		passwordLabel.setText("Password: ");

		passwordText = new Text(groupContent, SWT.PASSWORD | SWT.BORDER);
		passwordText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		groupContent.layout();
		groupContent.pack();
	}

	protected void createSpreadsheetGroup(final Composite parent) {
		final Composite groupContent = DialogUtil.createGroupContainer(parent, "Spreadsheet Details", 2);

		spreadsheetNameLabel = new Label(groupContent, SWT.NONE);
		spreadsheetNameLabel.setText("Name: ");

		spreadsheetNameText = new Text(groupContent, SWT.BORDER);
		spreadsheetNameText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		groupContent.layout();
		groupContent.pack();
	}

	protected void createConfigurationFileGroup(final Composite parent) {
		final Composite groupContent = DialogUtil.createGroupContainer(parent, "ORM Meta-data", 3);

		configFileTextLabel = new Label(groupContent, SWT.NONE);
		configFileTextLabel.setText("File: ");

		configFileText = new Text(groupContent, SWT.BORDER);
		configFileText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		browseConfigFile = new Button(groupContent, SWT.NONE);
		browseConfigFile.setText("Browse Workspace...");
		browseConfigFile.addListener(SWT.Selection, new BrowseWorkspaceForModelsListener(configFileText,
			"XML meta-data file in the workspace", "Select an XML Meta-data File"));

		groupContent.layout();
		groupContent.pack();
	}

	@Override
	protected void loadProperties() {
		super.loadProperties();

		if (properties != null) {
			this.usernameText.setText(properties.getProperty(GSModel.GOOGLE_USERNAME));

			// Get password from the vault
			final SecureGSModel secureModel = new SecureGSModel();
			try {
				this.passwordText.setText(secureModel.loadPassword(properties));
			}
			catch (StorageException e) {
				final String message = "Unable to retrieve the password from Equinox Security vault";
				throw new RuntimeException(message);
			}

			this.spreadsheetNameText.setText(properties.getProperty(GSModel.SPREADSHEET_NAME));
			this.configFileText.setText(properties.getProperty(GSModel.CONFIGURATION_FILE));
		}
	}

	@Override
	protected void storeProperties() {
		super.storeProperties();
		super.properties.put(GSModel.GOOGLE_USERNAME, this.usernameText.getText());

		// Store the password in vault
		final ISecurePreferences preferences = SecurePreferencesFactory.getDefault();
		final ISecurePreferences node = preferences.node(this.usernameText.getText());
		try {
			node.put(GSModel.GOOGLE_PASSWORD, this.passwordText.getText(), true);
		}
		catch (StorageException e1) {
			final String message = "Equinox Security was unable to store the Google account password";
			throw new RuntimeException(message);
		}

		super.properties.put(GSModel.SPREADSHEET_NAME, this.spreadsheetNameText.getText());
		super.properties.put(GSModel.CONFIGURATION_FILE, this.configFileText.getText());
	}

}
