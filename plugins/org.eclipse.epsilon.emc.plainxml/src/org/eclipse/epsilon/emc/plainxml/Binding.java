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
package org.eclipse.epsilon.emc.plainxml;

public class Binding {
	
	protected String sourceTag;
	protected String sourceAttribute;
	protected String targetTag;
	protected String targetAttribute;
	protected boolean many;
	
	public Binding(String sourceTag, String sourceAttribute, String targetTag,
			String targetAttribute, boolean many) {
		super();
		
		if (sourceTag.equals("*")) sourceTag =  ".*";
		if (targetTag.equals("*")) targetTag =  ".*";
		
		this.sourceTag = sourceTag;
		this.sourceAttribute = sourceAttribute;
		this.targetTag = targetTag;
		this.targetAttribute = targetAttribute;
		this.many = many;
	}

	public String getSourceTag() {
		return sourceTag;
	}
		
	public String getSourceAttribute() {
		return sourceAttribute;
	}
		
	public String getTargetTag() {
		return targetTag;
	}
	
	public String getTargetAttribute() {
		return targetAttribute;
	}
	
	public boolean isMany() {
		return many;
	}

}
