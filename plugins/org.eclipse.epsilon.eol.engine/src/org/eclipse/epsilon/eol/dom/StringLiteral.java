package org.eclipse.epsilon.eol.dom;

import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;

public class StringLiteral extends Expression {
	
	protected String value;
	
	public StringLiteral() {}
	
	public StringLiteral(String value) {
		this.value = value;
	}
	
	@Override
	public void build() {
		super.build();
		value = unescape(getText());
	}
	
	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	
	@Override
	public Object execute(IEolContext context) throws EolRuntimeException {
		return getValue();
	}
	
	public String unescape(String str) {
		if (str == null) {
			return null;
		}
		int size = str.length();
		StringBuffer out = new StringBuffer();
		boolean slash = false;

		for (int i = 0; i < size; i++) {
			char ch = str.charAt(i);
			if (slash) {
				slash = false;
				switch (ch) {
				case '\\':
					out.append('\\');
					break;
				case '\'':
					out.append('\'');
					break;
				case '\"':
					out.append('"');
					break;
				case 'r':
					out.append('\r');
					break;
				case 'f':
					out.append('\f');
					break;
				case 't':
					out.append('\t');
					break;
				case 'n':
					out.append('\n');
					break;
				case 'b':
					out.append('\b');
					break;
				default:
					out.append(ch);
					break;
				}
				continue;
			} else if (ch == '\\') {
				slash = true;
				continue;
			}
			out.append(ch);
		}
		if (slash) {
			out.append('\\');
		}

		return out.toString();

	}
}
