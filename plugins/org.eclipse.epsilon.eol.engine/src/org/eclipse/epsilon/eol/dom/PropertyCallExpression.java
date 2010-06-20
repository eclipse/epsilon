package org.eclipse.epsilon.eol.dom;

public class PropertyCallExpression extends FeatureCallExpression {
	
	protected String property;
	protected boolean extended = false;
	
	public boolean isExtended() {
		return extended;
	}
	
	public void setExtended(boolean extended) {
		this.extended = extended;
	}
	
	public void setProperty(String property) {
		this.property = property;
	}
	
	public String getProperty() {
		return property;
	}
}
