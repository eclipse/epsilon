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
package org.eclipse.epsilon.egl.config;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.epsilon.egl.execute.context.IEglContext;
import org.eclipse.epsilon.egl.merge.partition.CompositePartitioner;

public class XMLContentTypeRepository implements ContentTypeRepository {

	private final ConfigFileReader reader = new XMLConfigFileReader();
	
	private Map<String, CompositePartitioner> partitioners = new HashMap<String, CompositePartitioner>();
	
	
	public XMLContentTypeRepository(IEglContext context) {
		try {
			final InputStream defaultConfig = XMLContentTypeRepository.class.getResourceAsStream("DefaultConfig.xml");
			
			load(defaultConfig);
			
		} catch (PersistenceException e) {
			context.getErrorStream().println("Failed to load default content type configuration:");
			context.getErrorStream().print(e.getLocalizedMessage());
		}
	}
	
	public XMLContentTypeRepository(InputStream config) throws PersistenceException {
		load(config);
	}
	
	public void load(InputStream path) throws PersistenceException {
		partitioners = reader.read(path);
	}
	
	public CompositePartitioner partitionerFor(String contentType) {
		return partitioners.get(contentType);
	}
}
