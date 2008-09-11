/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.egl.dt.views;

import org.eclipse.epsilon.egl.traceability.Template;

public class CurrentTemplateObserverEvent {

	private final Template oldTemplate;
	private final Template newTemplate;
	
	public CurrentTemplateObserverEvent(Template oldTemplate, Template newTemplate) {
		this.oldTemplate = oldTemplate;
		this.newTemplate = newTemplate;
	}
	
	public Template getNewTemplate() {
		return newTemplate;
	}
	
	public Template getOldTemplate() {
		return oldTemplate;
	}
}
