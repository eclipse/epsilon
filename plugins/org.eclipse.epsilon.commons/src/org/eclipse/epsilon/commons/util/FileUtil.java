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
package org.eclipse.epsilon.commons.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class FileUtil {
	
	public static void setFileContents(String str, File file) throws Exception {
		FileWriter writer = new FileWriter(file);
		writer.append(str);
		writer.flush();
		writer.close();
	}
	
	public static String getFileContents(File file) throws Exception {
		FileReader reader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(reader);
		StringBuffer buffer = new StringBuffer();
		String line = bufferedReader.readLine();
		while (line != null) {
			buffer.append(line);
			buffer.append("\r\n");
			line = bufferedReader.readLine();
		}
		return buffer.toString();
	}
	
	public static String getAbsolutePath(String basePath, String relativePath) {
		File file = new File(relativePath);
		if (!file.isAbsolute()) {
			file = new File(basePath, relativePath);
		}
		return file.getAbsolutePath();
	}
	
	public static File getFile(String name, Class<?> relativeTo) {
		try {
			final File clazz = new File(URLDecoder.decode(relativeTo.getResource(relativeTo.getSimpleName() + ".class").getFile(), "UTF-8"));
			
			return new File(clazz.getParentFile(), name);
		
		} catch (UnsupportedEncodingException e) {
			throw new IllegalArgumentException(name + " could not be located relative to " + relativeTo);
		}
	}
	
	public static String getPath(String name, Class<?> relativeTo) {
		return getFile(name, relativeTo).getAbsolutePath();
	}
}
