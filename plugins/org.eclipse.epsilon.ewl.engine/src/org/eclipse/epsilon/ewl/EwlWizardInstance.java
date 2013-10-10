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
package org.eclipse.epsilon.ewl;

import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.FrameStack;
import org.eclipse.epsilon.eol.execute.context.IEolContext;

public class EwlWizardInstance {

	protected IEolContext context;
	protected Object self;
	protected EwlWizard wizard;
	protected FrameStack scope;
	
	public EwlWizardInstance(EwlWizard wizard, Object self, IEolContext context) {
		super();
		this.context = context;
		this.scope = context.getFrameStack().clone();
		this.self = self;
		this.wizard = wizard;
	}

	public EwlWizardInstance() {
		super();
	}

	public IEolContext getContext() {
		return context;
	}

	public void setContext(IEolContext context) {
		this.context = context;
	}

	public Object getSelf() {
		return self;
	}

	public void setSelf(Object self) {
		this.self = self;
	}

	public EwlWizard getWizard() {
		return wizard;
	}

	public void setWizard(EwlWizard template) {
		this.wizard = template;
	}
	
	public void process() throws EolRuntimeException {
		FrameStack oldScope = context.getFrameStack();
		context.setFrameStack(scope);
		try {
			context.getModelRepository().getTransactionSupport().startTransaction();
			wizard.process(self, context);
			context.getModelRepository().getTransactionSupport().commitTransaction();
		}
		catch (EolRuntimeException rex) {
			context.getModelRepository().getTransactionSupport().rollbackTransaction();
			throw rex;
		}
		finally {
			context.setFrameStack(oldScope);
		}
	}
	
	public String getTitle() throws EolRuntimeException {
		FrameStack oldScope = context.getFrameStack();
		context.setFrameStack(scope);
		try {
			return wizard.getTitle(self, context);
		}
		catch (EolRuntimeException rex) {
			throw rex;
		}
		finally {
			context.setFrameStack(oldScope);
		}
	}
}
