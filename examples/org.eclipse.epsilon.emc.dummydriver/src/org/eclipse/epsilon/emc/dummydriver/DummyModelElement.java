package org.eclipse.epsilon.emc.dummydriver;

import java.util.HashMap;

public class DummyModelElement {
	
	protected String type = "";
	protected HashMap<String, Object> props = new HashMap<String, Object>();
	
	public DummyModelElement(String type) {
		super();
		this.type = type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public String getType() {
		return type;
	}
	
	public HashMap<String, Object> getProps() {
		return props;
	}
	
	public DummyModelElement put(String name, Object value) {
		props.put(name, value);
		return this;
	}
	
	@Override
	public String toString() {
		return "Object of type " + type;
	}
	
}
