/*********************************************************************
* Copyright (c) 2008 The University of York.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.commons.util;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import java.util.Map.Entry;

import org.eclipse.epsilon.common.util.StringProperties;
import org.junit.Test;

public class StringPropertiesTests {
	
	@Test
	public void testCreateFromParameters() {
		String parameter = "name=libnames" + System.lineSeparator() +
				"type=String" + System.lineSeparator() + 
				"value=Congress,University,City,Cafe,House" + System.lineSeparator() +
				"size=3"  + System.lineSeparator() +
				"use=false";
		StringProperties sp = new StringProperties(parameter);
		assertThat(sp.getProperty("name"), is("libnames"));
		assertThat(sp.getProperty("type"), is("String"));
		assertThat(sp.getProperty("value"), is("Congress,University,City,Cafe,House"));
		assertThat(sp.getIntegerProperty("size", 0), is(3));
		assertThat(sp.getBooleanProperty("use", true), is(false));
	}
	
	@Test
	public void testHasProperty() {
		StringProperties sp = new StringProperties();
		sp.put("valuedKey", "libnames");
		sp.put("emptyKey", "");
		assertThat("StringProperties has property valuedKey.", sp.hasProperty("valuedKey"), is(true));
		assertThat("StringProperties does not have property emptyKey.", sp.hasProperty("emptyKey"), is(false));
		assertThat("StringProperties does not have unknown property.", sp.hasProperty("unkown"), is(false));
	}
	
	@Test
	public void testCloneProperties() {
		String parameter = "name=libnames" + System.lineSeparator() +
				"type=String" + System.lineSeparator() + 
				"value=Congress,University,City,Cafe,House" + System.lineSeparator() +
				"size=3"  + System.lineSeparator() +
				"use=false";
		StringProperties sp = new StringProperties(parameter);
		StringProperties spClone = sp.clone();
		for(Entry<Object, Object> e : sp.entrySet()) {
			assertThat("Clone has key", spClone.hasProperty((String) e.getKey()), is(true));
			assertThat("Clone matches va;lue", spClone.getProperty((String) e.getKey()), is(e.getValue()));
		}
	}
	
	@Test
	public void testGetBooleanProperty() {
		StringProperties sp = new StringProperties();
		sp.put("trueKey", "true");
		sp.put("falseKey", "false");
		sp.put("notBooleanKey", "notBoolean");
		assertThat("True key is true.", sp.getBooleanProperty("trueKey", false), is(true));
		assertThat("False key is false.", sp.getBooleanProperty("falseKey", false), is(false));
		assertThat("Not boolean key defaults true", sp.getBooleanProperty("notBooleanKey", true), is(true));
		assertThat("Not boolean key defaults false", sp.getBooleanProperty("notBooleanKey", false), is(false));
	}
	
	@Test
	public void testGetIntegerProprety() {
		StringProperties sp = new StringProperties();
		sp.put("integerKey", "3");
		assertThat("Integer key value is 3", sp.getIntegerProperty("integerKey", -1), is(3));
		assertThat("Integer key value is default(-1)", sp.getIntegerProperty("missingKey", -1), is(-1));
	}
	
	@Test
	public void testGetStringDefaultProperty() {
		StringProperties sp = new StringProperties();
		sp.put("someProperty", "someValue");
		assertThat(sp.getProperty("someProperty"), is("someValue"));
		assertThat(sp.getProperty("notPresent", "defaultValue"), is("defaultValue"));
	}
	
	
}
