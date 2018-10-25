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
import org.eclipse.epsilon.egl.IEgxModule;
import org.eclipse.epsilon.erl.execute.RuleExecutorFactory;

public class EgxContext extends EglContext implements IEgxContext {
	
	protected EgxModuleTemplateAdapter baseTemplate;
	
	public EgxContext() {
		this(null);
	}
	
	public EgxContext(EglTemplateFactory templateFactory) {
		super(templateFactory);
		executorFactory = new RuleExecutorFactory();
	}
	
	@Override
	public EgxModuleTemplateAdapter getTrace() {
		if (baseTemplate == null) {
			baseTemplate = new EgxModuleTemplateAdapter(getModule());
		}
		return baseTemplate;
	}
	
	@Override
	public void setBaseTemplate(EgxModuleTemplateAdapter baseTemplate) {
		this.baseTemplate = baseTemplate;
	}
	
	@Override
	public IEgxModule getModule() {
		return (IEgxModule) module;
	}
	
	@Override
	public RuleExecutorFactory getExecutorFactory() {
		return (RuleExecutorFactory) executorFactory;
	}
}
