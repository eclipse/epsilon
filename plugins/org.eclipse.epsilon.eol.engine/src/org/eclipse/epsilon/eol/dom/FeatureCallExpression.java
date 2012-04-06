/*******************************************************************************
 * Copyright (c) 2012 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.eol.dom;

public abstract class FeatureCallExpression extends Expression {
	
	protected Expression target;
	protected boolean arrow;
	
	public boolean isArrow() {
		return arrow;
	}
	
	public void setArrow(boolean arrow) {
		this.arrow = arrow;
	}
	
	public void setTarget(Expression target) {
		this.target = target;
	}
	
	public Expression getTarget() {
		return target;
	}
}
