package org.eclipse.epsilon.eol.dom;

import org.eclipse.epsilon.common.module.AbstractModuleElement;

public class ModelDeclarationParameter extends AbstractModuleElement {
	
	protected String key;
	protected String value;
	
	@Override
	public void build() {
		super.build();
		this.key = getFirstChild().getText();
		this.value = getSecondChild().getText();
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}
