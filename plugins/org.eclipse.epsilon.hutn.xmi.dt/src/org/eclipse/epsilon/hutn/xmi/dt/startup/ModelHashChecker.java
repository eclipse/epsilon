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

import org.eclipse.epsilon.common.dt.console.EpsilonConsole;
import org.eclipse.epsilon.hutn.xmi.dt.HutnXmiBridgeDevelopmentToolsPlugin;
import org.eclipse.epsilon.hutn.xmi.dt.ModelHashCache;
import org.eclipse.epsilon.hutn.xmi.hashing.HutnXmiBridgeHashingException;
import org.eclipse.epsilon.hutn.xmi.hashing.Xmi2Hash;

public class ModelHashChecker {

	private final URI model;
	private final Xmi2Hash hasher;
	private final ModelHashCache hashCache;
	
	public ModelHashChecker(URI model) throws HutnXmiBridgeHashingException {
		this(model, new Xmi2Hash(model), HutnXmiBridgeDevelopmentToolsPlugin.getDefault().getModelHashCache());
	}
	
	ModelHashChecker(URI model, Xmi2Hash hasher, ModelHashCache hashCache) {
		this.model     = model;
		this.hasher    = hasher;
		this.hashCache = hashCache;
	}
	
	
	public boolean hasHashChangedFor() {
		final int currentHash = calculateCurrentHash();
		final boolean hashChanged = !matchesCachedHash(currentHash);
		
		if (hashChanged) {
			if (noCachedHash())
				EpsilonConsole.getInstance().getInfoStream().println("No previous hash for: " + model + " (new hash value: " + currentHash + ")");
			else
				EpsilonConsole.getInstance().getInfoStream().println("Hash changed for: " + model + " (" + previousHash() + " -> " + currentHash + ")");
				
			updateCachedHash(currentHash);
		}
		
		return hashChanged;
	}

	private boolean matchesCachedHash(int currentHash) {
		if (noCachedHash()) {
			return false;
		
		} else {
			return currentHash == previousHash();
		}
	}

	private int calculateCurrentHash() {
		return hasher.calculateMetamodelHash();
	}

	private boolean noCachedHash() {
		return hashCache.noHashFor(model);
	}
	
	private int previousHash() {
		return hashCache.getHashFor(model);
	}
	
	private void updateCachedHash(int hash) {
		hashCache.updateHashFor(model, hash);
	}
}
