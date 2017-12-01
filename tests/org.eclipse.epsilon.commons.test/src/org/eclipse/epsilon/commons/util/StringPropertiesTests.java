package org.eclipse.epsilon.commons.util;

import static org.hamcrest.MatcherAssert.*;

import org.eclipse.epsilon.common.util.StringProperties;
import org.junit.Test;

public class StringPropertiesTests {
	
	@Test
	public void createFromParameters() {
		String parameter = "name=libnames" + System.lineSeparator() +
				"type=String" + System.lineSeparator() + 
				"value=Congress,University,City,Cafe,House" + System.lineSeparator() +
				"size=3"  + System.lineSeparator() +
				"use=false";
		StringProperties sp = new StringProperties(parameter);
		asserThat(sp.getProperty("name"), is("libnames"));
		
	}
}
