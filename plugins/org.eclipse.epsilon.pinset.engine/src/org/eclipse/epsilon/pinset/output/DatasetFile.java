/*********************************************************************
 * Copyright (c) 2020 The University of York.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *********************************************************************/
package org.eclipse.epsilon.pinset.output;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.epsilon.pinset.ValueWrapper;

/**
 * DatasetFile.
 *
 * @author Alfonso de la Vega
 * @since 2.1
 */
public class DatasetFile {
	protected PrintWriter pw = null;
	protected String separator = ",";

	public DatasetFile(String path) throws FileNotFoundException {
		File file = new File(path);
		file.getParentFile().mkdirs();
		pw = new PrintWriter(file);
	}

	public void headerRecord(List<String> columnNames) {
		addRecord(columnNames);
	}

	public void rowRecord(List<ValueWrapper> wrappers) {
		List<String> records = new ArrayList<>(wrappers.size());
		for (ValueWrapper wrapper : wrappers) {
			records.add(wrapper.toString());
		}
		addRecord(records);
	}

	private void addRecord(List<String> records) {
		pw.println(String.join(separator, records));
	}

	public void close() {
		pw.close();
	}

	public String getSeparator() {
		return separator;
	}

	public void setSeparator(String separator) {
		this.separator = separator;
	}
}
