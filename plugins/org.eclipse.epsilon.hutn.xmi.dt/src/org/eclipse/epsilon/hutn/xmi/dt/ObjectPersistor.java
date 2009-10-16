/*******************************************************************************
 * Copyright (c) 2009 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************
 *
 * $Id$
 */
package org.eclipse.epsilon.hutn.xmi.dt;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectPersistor<T> {

	private File storage;
	
	public ObjectPersistor(File storage) {
		this.storage = storage;
	}
	
	@SuppressWarnings("unchecked")
	public T load(T defaultValue) {		
		try {
			ObjectInputStream stream = null;
			
			try {
				stream = new ObjectInputStream(new FileInputStream(storage));
				
				return (T)stream.readObject();	
			
			} finally {
				if (stream != null)
					stream.close();
			}
			
		} catch (Exception e) {
			return defaultValue;
		}
	}
	
	public void store(T value) throws IOException {
		ObjectOutputStream stream = null;
		
		try {
			stream = new ObjectOutputStream(new FileOutputStream(storage));
			
			stream.writeObject(value);	
		
		} finally {
			if (stream != null)
				stream.close();
		}
	}
}
