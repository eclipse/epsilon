/*********************************************************************
* Copyright (c) 2008 The University of York.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.emc.simulink.test.util;

import java.io.File;
import java.net.URL;

public class FileUtils {

	public static File getModelFile(String fileName) {
		String resource = FileUtils.getResource("models/" + fileName);
		return (resource != null) ? new File(resource) : null;
	}

	public static String getScript(String fileName) {
		return FileUtils.getResource("scripts/" + fileName);
	}
	
	public static String getResource(String resourceLocation) {
		URL resource = FileUtils.class.getClassLoader().getResource(resourceLocation);
		return resource != null ? resource.getFile() : null;
	}
}
