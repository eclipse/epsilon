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
package org.eclipse.epsilon.eol.types;

import org.eclipse.epsilon.eol.exceptions.EolInternalException;

public class EolClasspathNativeTypeDelegate extends AbstractToolNativeTypeDelegate{

	public boolean knowsAbout(String clazz) {
		try {
			Class.forName(clazz);
		} catch (ClassNotFoundException e) {
			return false;
		}
		return true;
	}

	public Object createInstance(String clazz) throws EolInternalException {
		try {
			return Class.forName(clazz).newInstance();
		} catch (Exception e) {
			throw new EolInternalException(e);
		}
	}

}
