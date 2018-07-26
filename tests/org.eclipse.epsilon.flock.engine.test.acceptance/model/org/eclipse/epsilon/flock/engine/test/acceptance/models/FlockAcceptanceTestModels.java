/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************
 *
 * $Id$
 */
package org.eclipse.epsilon.flock.engine.test.acceptance.models;


import java.io.File;

import org.eclipse.emf.common.util.URI;
import org.eclipse.epsilon.hutn.test.models.util.FileUtil;

public abstract class FlockAcceptanceTestModels {

	private FlockAcceptanceTestModels() {}
	
	public static File getDoesModelFile() {
		return FileUtil.getFile("Does.model", FlockAcceptanceTestModels.class);
	}
	
	public static URI getDoesModelUri() {
		return URI.createFileURI(getDoesModelFile().getAbsolutePath());
	}

	public static File getBloggsModelFile() {
		return FileUtil.getFile("Bloggs.model", FlockAcceptanceTestModels.class);
	}
}
