/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.eol.execute;

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;

public class StringExecutor extends AbstractExecutor {

	@Override
	public Object execute(AST ast, IEolContext context)
			throws EolRuntimeException {

		//return new EolString(unescape(ast.getText()));
		return unescape(ast.getText());
		
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
