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
package org.eclipse.epsilon.hutn.xmi.hashing;

import java.net.URI;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.epsilon.hutn.xmi.HutnXmiBridgeException;
import org.eclipse.epsilon.hutn.xmi.UriContentReader;
import org.eclipse.epsilon.hutn.xmi.hashing.hashers.ecore.EPackageHasher;
import org.eclipse.epsilon.hutn.xmi.hashing.xmi2nsUri.NsUriIdentifyingParser;

public class Xmi2Hash {

	private final int hash;
	
	public Xmi2Hash(URI uri) throws HutnXmiBridgeHashingException {
		this(readContents(uri));		
	}

	private static String readContents(URI uri) throws HutnXmiBridgeHashingException {
		try {
			return new UriContentReader(uri).readContents();
		} catch (HutnXmiBridgeException e) {
			throw new HutnXmiBridgeHashingException(e);
		}
	}
	
	public Xmi2Hash(String xmi) throws HutnXmiBridgeHashingException {
		try {
			final String nsUri      = new NsUriIdentifyingParser(xmi).parse();
			final EPackage ePackage = EPackage.Registry.INSTANCE.getEPackage(nsUri);
			
			hash = EPackageHasher.getInstance().hashSafely(ePackage);
			
		} catch (Exception e) {
			throw new HutnXmiBridgeHashingException(e);
		}
	}
	
	public int calculateMetamodelHash() {
		return hash;
	}
}
