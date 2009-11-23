package org.eclipse.epsilon.examples.tools;

public class SampleTool {
	
	protected String name;
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public String sayHello() {
		return "Hello " + name;
	}
	
}
