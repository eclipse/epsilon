package org.eclipse.epsilon.eol.dom;

import org.eclipse.epsilon.common.module.IModule;
import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.compile.context.EolCompilationContext;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.types.EolPrimitiveType;

public class StringLiteral extends Expression {
	
	protected String value;
	
	public StringLiteral() {}
	
	public StringLiteral(String value) {
		this.value = value;
	}
	
	@Override
	public void build(AST cst, IModule module) {
		super.build(cst, module);
		value = unescape(cst.getText());
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
	
	@Override
	public void compile(EolCompilationContext context) {
		resolvedType = EolPrimitiveType.String;
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
