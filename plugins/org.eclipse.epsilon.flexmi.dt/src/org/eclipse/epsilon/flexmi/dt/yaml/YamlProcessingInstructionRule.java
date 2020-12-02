package org.eclipse.epsilon.flexmi.dt.yaml;

import org.eclipse.jface.text.rules.IToken;

public class YamlProcessingInstructionRule extends YamlMappingRule {
	
	public YamlProcessingInstructionRule(IToken token) {
		super(token);
	}
	
	@Override
	protected boolean isWordStart(char c) {
		return c == '?';
	}
	
}
