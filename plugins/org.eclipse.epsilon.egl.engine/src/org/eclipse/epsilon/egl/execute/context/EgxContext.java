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

import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import org.eclipse.epsilon.egl.EglTemplate;
import org.eclipse.epsilon.egl.EglTemplateFactory;
import org.eclipse.epsilon.egl.IEgxModule;
import org.eclipse.epsilon.erl.execute.context.ErlContext;

/**
 * 
 * @since 1.6 extends ERL rather than EGL
 */
public class EgxContext extends ErlContext implements IEgxContext {
	
	private EgxModuleTemplateAdapter baseTemplate;
	private EglTemplateFactory templateFactory;
	protected Map<URI, EglTemplate> templateCache = new HashMap<>();
	
	public EgxContext() {
		this(null);
	}
	
	public EgxContext(EglTemplateFactory templateFactory) {
		this.templateFactory = templateFactory != null ? templateFactory : new EglTemplateFactory();
	}
	
	public EgxModuleTemplateAdapter getTrace() {
		if (baseTemplate == null) {
			baseTemplate = new EgxModuleTemplateAdapter(getModule());
		}
		return baseTemplate;
	}
	
	public void setBaseTemplate(EgxModuleTemplateAdapter baseTemplate) {
		this.baseTemplate = baseTemplate;
	}
	
	@Override
	public IEgxModule getModule() {
		return (IEgxModule) super.getModule();
	}

	@Override
	public void setTemplateFactory(EglTemplateFactory templateFactory) {
		this.templateFactory = templateFactory;
	}

	@Override
	public EglTemplateFactory getTemplateFactory() {
		return templateFactory;
	}

	/**
	 * @since 1.6
	 */
	@Override
	public Map<URI, EglTemplate> getTemplateCache() {
		return templateCache;
	}
}
