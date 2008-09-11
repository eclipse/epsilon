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
package org.eclipse.epsilon.ecl.exceptions;

import org.eclipse.epsilon.ecl.MatchRule;
import org.eclipse.epsilon.ecl.execute.context.IEclContext;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;

public class EclNotApplicableSuperRuleException extends EolRuntimeException {
	
	protected MatchRule rule;
	protected Object left;
	protected Object right;
	protected IEclContext context;
	
	public EclNotApplicableSuperRuleException(Object left, Object right, MatchRule rule, IEclContext context) {
		super();
		this.rule = rule;
		this.left = left;
		this.right = right;
		this.context = context;
		this.ast = rule.getAst();
	}
	
	@Override
	public String getReason() {
		return rule.getName() + " does not apply to objects \r\n" +  
		context.getPrettyPrinterManager().toString(left) + "\r\n" + 
		context.getPrettyPrinterManager().toString(right) + "\r\n";
	}
}
