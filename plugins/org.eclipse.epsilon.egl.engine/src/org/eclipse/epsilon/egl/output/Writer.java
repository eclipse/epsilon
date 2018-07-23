/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.egl.output;

import java.io.File;
import java.io.IOException;

import org.eclipse.epsilon.egl.util.FileUtil;

public class Writer {

	private final File file;
	private final String contents;
	
	public Writer(File file, String contents) {
		this.file     = file;
		this.contents = contents;
	}

	public void write() throws IOException {
		if (file!=null) {
			FileUtil.write(file, contents);
		}
	}
}
