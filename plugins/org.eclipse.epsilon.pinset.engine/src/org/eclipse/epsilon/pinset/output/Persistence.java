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

import java.io.FileNotFoundException;
import java.util.List;

import org.eclipse.epsilon.pinset.Dataset;
import org.eclipse.epsilon.pinset.ValueWrapper;

/**
 * Persistence.
 *
 * @author Alfonso de la Vega
 * @since 2.1
 */
public class Persistence {

	public static void persist(Dataset dataset, String filePath, String separator) {
		DatasetFile df = null;
		try {
			df = new DatasetFile(filePath);
			df.setSeparator(separator);
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
			return;
		}
		df.headerRecord(dataset.getColumnNames());
		for (List<ValueWrapper> wrappers : dataset.getRows()) {
			df.rowRecord(wrappers);
		}
		df.close();
	}
}
