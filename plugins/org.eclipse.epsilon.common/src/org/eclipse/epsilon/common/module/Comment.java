package org.eclipse.epsilon.common.module;

import org.antlr.runtime.Token;

public class Comment extends AbstractModuleElement {
	
	protected boolean multiline;
	protected String text;
	
	public Comment(Token token) {
		this.token = token;
		multiline = getText().startsWith("/*") || getText().startsWith("-*");
		text = getText();
		if (multiline) {
			text = text.substring(2, text.length() - 2);
		}
		else {
			text = text.substring(2);
		}
	}
	
	@Override
	public String toString() {
		return text;
	}
	
}
