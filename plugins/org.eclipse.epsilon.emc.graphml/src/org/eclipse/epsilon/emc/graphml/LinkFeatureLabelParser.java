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

import org.eclipse.epsilon.emc.muddle.Feature;
import org.eclipse.epsilon.emc.muddle.MuddleFactory;


public class LinkFeatureLabelParser {
	
	protected Feature feature;
	
	public LinkFeatureLabelParser(String label) {
		Parser nameAndMultiplicityParser = new Parser("(\\S+?)\\s*\\*");
		feature = MuddleFactory.eINSTANCE.createFeature();
		
		if (nameAndMultiplicityParser.matches(label)) {
			feature.setMany(true);
			feature.setName(nameAndMultiplicityParser.getGroups().get(0));
		}
		else {
			feature.setName(label);
		}
	}
	
	public Feature getFeature() {
		return feature;
	}
}
