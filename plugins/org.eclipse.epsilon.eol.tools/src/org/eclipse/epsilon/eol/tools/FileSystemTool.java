/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.eol.tools;

import java.io.File;

import org.eclipse.epsilon.common.util.FileUtil;

public class FileSystemTool {
	
	public boolean exists(String path) {
		return toFile(path).exists();
	}
	
	public boolean isDirectory(String path) {
		return toFile(path).isDirectory();
	}
	
	public String getContents(String path) throws Exception {
		return FileUtil.getFileContents(toFile(path));
	}

	private File toFile(String path) {
		return new File(path);
	}
}
