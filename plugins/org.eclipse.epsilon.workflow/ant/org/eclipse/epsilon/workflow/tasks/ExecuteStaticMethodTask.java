package org.eclipse.epsilon.workflow.tasks;

import java.lang.reflect.Method;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Task;

public class ExecuteStaticMethodTask extends Task {
	
	protected String javaClass, method;
	
	public static void foo() {
		System.out.println("Foo invoked");
	}
	
	@Override
	public void execute() throws BuildException {
		try {
			for (Method m : Class.forName(javaClass).getMethods()) {
				if (m.getName().equals(method) && m.getParameterTypes().length == 0) {
					m.invoke(null, new Object[]{});
				}
			}
		} catch (Exception e) {
			throw new BuildException(e);
		}
	}
	
	public String getJavaClass() {
		return javaClass;
	}
	
	public void setJavaClass(String javaClass) {
		this.javaClass = javaClass;
	}
	
	public String getMethod() {
		return method;
	}
	
	public void setMethod(String method) {
		this.method = method;
	}
}
