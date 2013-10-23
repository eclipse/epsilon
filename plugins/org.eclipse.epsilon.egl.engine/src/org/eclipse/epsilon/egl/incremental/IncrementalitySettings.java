/*******************************************************************************
 * Copyright (c) 2013 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.egl.incremental;

public class IncrementalitySettings {

	private boolean overwriteUnchangedFiles = false;

	public IncrementalitySettings() {}
	
	public IncrementalitySettings(IncrementalitySettings original) {
		this.overwriteUnchangedFiles = original.overwriteUnchangedFiles;
	}

	public boolean isOverwriteUnchangedFiles() {
		return overwriteUnchangedFiles;
	}
	
	public void setOverwriteUnchangedFiles(boolean overwriteUnchangedFiles) {
		this.overwriteUnchangedFiles = overwriteUnchangedFiles;
	}
	
}
