/*******************************************************************************
 * Copyright (c) 2012 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.egl.execute.context;

import org.eclipse.epsilon.egl.EglTemplateFactory;
import org.eclipse.epsilon.egl.EgxModule;
import org.eclipse.epsilon.egl.traceability.Template;

public class EgxContext extends EglContext {
	
	protected Template baseTemplate = null;
	
	public EgxContext(EglTemplateFactory templateFactory) {
		super(templateFactory);
	}
	
	@Override
	public Template getTrace() {
		if (baseTemplate == null) {
			baseTemplate = new EgxModuleTemplateAdapter((EgxModule) module);
		}
		return baseTemplate;
	}
	
	public void setBaseTemplate(Template baseTemplate) {
		this.baseTemplate = baseTemplate;
	}
	
}
