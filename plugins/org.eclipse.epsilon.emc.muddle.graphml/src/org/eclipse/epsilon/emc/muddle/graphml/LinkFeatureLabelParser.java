package org.eclipse.epsilon.emc.muddle.graphml;

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
