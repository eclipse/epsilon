package org.eclipse.epsilon.common.dt.locators;

public interface IModelElementLocator {
	
	public final static String EXTENSION_POINT = "org.eclipse.epsilon.common.dt.modelElementLocator";
	
	public boolean canLocate(Object o);
	
	public void locate(Object o);
	
}
