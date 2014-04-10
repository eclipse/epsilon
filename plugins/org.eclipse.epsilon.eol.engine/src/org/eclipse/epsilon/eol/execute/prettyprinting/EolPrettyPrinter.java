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
package org.eclipse.epsilon.eol.execute.prettyprinting;

import java.util.Collections;

import org.eclipse.epsilon.common.util.StringUtil;
import org.eclipse.epsilon.eol.EolOperation;
import org.eclipse.epsilon.eol.IEolLibraryModule;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;

public class EolPrettyPrinter implements PrettyPrinter {
	
	protected IEolContext context;
	
	
	public EolPrettyPrinter (IEolContext context) {
		this.context = context;
	}

	public boolean appliesTo(Object o) {
		
		try {
			EolOperation operation = ((IEolLibraryModule)context.getModule()).getOperations().getOperation(o, "toString", Collections.emptyList(), context);
			if (operation != null) return true;
		} catch (EolRuntimeException e) {
			return false;
		}
		
		return false;
	}

	public String print(Object o) {
		EolOperation operation;
		try {
			operation = ((IEolLibraryModule)context.getModule()).getOperations().getOperation(o, "toString", Collections.emptyList(), context);
			return StringUtil.toString(operation.execute(o, Collections.emptyList(), context));
		} catch (EolRuntimeException e) {
			return e.getMessage();
		}
	}
	
	
	
}
