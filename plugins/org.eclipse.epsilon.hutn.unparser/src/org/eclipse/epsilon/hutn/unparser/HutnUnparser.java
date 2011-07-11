/*******************************************************************************
 * Copyright (c) 2009 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************
 *
 * $Id$
 */
package org.eclipse.epsilon.hutn.unparser;

import org.eclipse.epsilon.hutn.model.hutn.Spec;
import org.eclipse.epsilon.hutn.unparser.formatter.HutnFormatter;
import org.eclipse.epsilon.hutn.unparser.internal.SpecUnparser;

public class HutnUnparser {

	private final SpecUnparser   unparser;
	private final HutnFormatter beautifier = new HutnFormatter();
	
	public HutnUnparser(Spec spec) {
		this.unparser = new SpecUnparser(spec);
	}
	
	public String unparse() {
		return beautifier.format(unparser.unparse());
	}
}
