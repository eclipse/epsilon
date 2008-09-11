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
package org.eclipse.epsilon.eol.execute.operations.simple;

import java.util.Iterator;
import java.util.List;

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.types.EolCollection;
import org.eclipse.epsilon.eol.types.EolString;


public class AsStringOperation extends AbstractSimpleOperation {

	public AsStringOperation() {
		super();
	}

	@Override
	public Object execute(Object source, List parameters, IEolContext context, AST ast) throws EolRuntimeException {
		if (parameters.size() == 1 && source instanceof EolCollection) {
			String delimiter = parameters.get(0).toString();
			String str = "";
			Iterator it = ((EolCollection) source).iterator();
			while (it.hasNext()) {
				str = str + context.getPrettyPrinterManager().toString(it.next());
				if (it.hasNext()) {
					str = str + delimiter;
				}
			}
			return new EolString(str);
		}
		else {
			return new EolString(context.getPrettyPrinterManager().toString(source));
		}
	}

}
