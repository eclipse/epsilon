/*********************************************************************
* Copyright (c) 2008 The University of York.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.emc.spreadsheets.google;

import org.eclipse.epsilon.emc.spreadsheets.SpreadsheetColumn;

public class GSColumn extends SpreadsheetColumn {
	private String googleColumnId;

	public GSColumn(final GSWorksheet worksheet, final int columnIndex) {
		super(worksheet, columnIndex);
		this.googleColumnId = null;
	}

	public String getGoogleColumnId() {
		return this.googleColumnId;
	}

	public void setGoogleColumnId(String id) {
		this.googleColumnId = id;
	}

	@Override
	public String toString() {
		return "GSColumn [googleColumnId = '" + googleColumnId + "', parent = " + super.toString() + "]";
	}

}
