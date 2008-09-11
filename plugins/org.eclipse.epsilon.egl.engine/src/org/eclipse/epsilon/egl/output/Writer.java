/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
