/*******************************************************************************
 * Copyright (c) 2014 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitris Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.emc.graphml;

import java.io.File;

import org.eclipse.epsilon.common.util.StringProperties;
import org.eclipse.epsilon.emc.muddle.MuddleFactory;
import org.eclipse.epsilon.emc.muddle.MuddleModel;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.epsilon.eol.models.IRelativePathResolver;

public class GraphmlModel extends MuddleModel {
	
	public static final String PROPERTY_FILE = "file";
	protected File file = null;	
	
	public GraphmlModel() {
		
	}
	
	@Override
	public void load(StringProperties properties, IRelativePathResolver resolver)
			throws EolModelLoadingException {
		super.load(properties, resolver);
		
		file = new File(resolver.resolve(properties.getProperty(GraphmlModel.PROPERTY_FILE)));
		load();
	}
	
	@Override
	public void load() throws EolModelLoadingException {
		if (readOnLoad) {
			GraphmlImporter importer = new GraphmlImporter();
			try {
				muddle = importer.importGraph(file);
			} catch (Exception e) {
				throw new EolModelLoadingException(e, this);
			}
		}
		else {
			muddle = MuddleFactory.eINSTANCE.createMuddle();
		}
	}
	
	public void setFile(File file) {
		this.file = file;
	}
	
	public File getFile() {
		return file;
	}
}
