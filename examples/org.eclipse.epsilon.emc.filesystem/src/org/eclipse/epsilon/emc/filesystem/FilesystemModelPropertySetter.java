/*********************************************************************
* Copyright (c) 2008 The University of York.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.emc.filesystem;

import java.io.File;
import java.io.FileOutputStream;

import org.eclipse.epsilon.eol.exceptions.EolInternalException;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.introspection.java.JavaPropertySetter;

public class FilesystemModelPropertySetter extends JavaPropertySetter {
	
	@Override
	public void invoke(Object value) throws EolRuntimeException {
		if ("contents".equals(property)) {
			
			try {
				FileOutputStream fos = new FileOutputStream((File) object);
				fos.write((value + "").getBytes());
				fos.close();
			}
			catch (Exception e) {
				throw new EolInternalException(e);
			}
		}
		else {
			super.invoke(value);
		}
 	}
	
}
