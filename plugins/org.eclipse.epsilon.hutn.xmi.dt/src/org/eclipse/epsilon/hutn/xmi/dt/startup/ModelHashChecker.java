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
package org.eclipse.epsilon.hutn.xmi.dt.startup;

import java.net.URI;

import org.eclipse.epsilon.hutn.xmi.dt.HutnXmiBridgeDevelopmentToolsPlugin;
import org.eclipse.epsilon.hutn.xmi.dt.ModelHashCache;
import org.eclipse.epsilon.hutn.xmi.hashing.HutnXmiBridgeHashingException;
import org.eclipse.epsilon.hutn.xmi.hashing.Xmi2Hash;

public class ModelHashChecker {

	private final URI model;
	
	public ModelHashChecker(URI model) {
		this.model = model;
	}
	
	public boolean hasHashChangedFor() {		
		try {
			final boolean hashChanged;
			final int currentHash = calculateCurrentHashOfModel();
			
			if (modelHasNoPreviousHash()) {
				hashChanged = true;
			
			} else {
				hashChanged = currentHash != previousHashOfModel();
			}
			
			changeHashOfModelTo(currentHash);
			
			return hashChanged;
		
		} catch (HutnXmiBridgeHashingException e) {
			return true; // if in doubt, signal that hash has changed;
		}
	}

	private boolean modelHasNoPreviousHash() {
		return getModelHashCache().noHashFor(model);
	}
	
	private int previousHashOfModel() {
		return getModelHashCache().getHashFor(model);
	}

	private int calculateCurrentHashOfModel() throws HutnXmiBridgeHashingException {
		return new Xmi2Hash(model).calculateMetamodelHash();
	}
	
	private void changeHashOfModelTo(int hash) {
		getModelHashCache().updateHashFor(model, hash);
	}
	
	
	private static ModelHashCache getModelHashCache() {
		return HutnXmiBridgeDevelopmentToolsPlugin.getDefault().getModelHashCache();
	}
}
