package org.eclipse.epsilon.eol.dom;

import org.eclipse.epsilon.common.module.AbstractModuleElement;
import org.eclipse.epsilon.common.module.IModule;
import org.eclipse.epsilon.common.parse.AST;

public class ModelDeclarationParameter extends AbstractModuleElement {
	
	protected String key;
	protected String value;
	
	@Override
	public void build(AST cst, IModule module) {
		super.build(cst, module);
		this.key = cst.getFirstChild().getText();
		this.value = cst.getSecondChild().getText();
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
