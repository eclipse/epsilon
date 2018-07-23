/*******************************************************************************
 * Copyright (c) 2009 The University of York.
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
package org.eclipse.epsilon.concordance.core.hashing;

import java.net.URI;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.epsilon.concordance.core.hashing.hashers.ecore.EPackageHasher;
import org.eclipse.epsilon.concordance.core.hashing.xmi2nsUri.NsUriIdentifyingParser;
import org.eclipse.epsilon.hutn.xmi.HutnXmiBridgeException;
import org.eclipse.epsilon.hutn.xmi.UriContentReader;

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
