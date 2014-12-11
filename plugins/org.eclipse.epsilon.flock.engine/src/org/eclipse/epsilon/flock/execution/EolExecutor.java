/*******************************************************************************
 * Copyright (c) 2011 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.flock.execution;

import org.eclipse.epsilon.eol.execute.context.EolContext;

public class EolExecutor {
	
	public final EolContext context; // FIXME this class should probably disappear, but this definitely shouldn't be public
	
	public EolExecutor(EolContext context) {
		this.context = context;
	}
}