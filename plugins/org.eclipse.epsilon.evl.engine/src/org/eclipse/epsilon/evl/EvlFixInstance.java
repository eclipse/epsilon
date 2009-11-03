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
package org.eclipse.epsilon.evl;

import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.exceptions.flowcontrol.EolReturnException;
import org.eclipse.epsilon.eol.execute.context.FrameStack;
import org.eclipse.epsilon.evl.execute.context.IEvlContext;

public class EvlFixInstance {
	
	protected EvlFix fix;
	protected Object self;
	protected IEvlContext context;
	protected FrameStack scope;
	
	public IEvlContext getContext() {
		return context;
	}

	public EvlFixInstance(IEvlContext context) {
		super();
		this.context = context;
		this.scope = context.getFrameStack().clone();
	}

	public EvlFix getFix() {
		return fix;
	}

	public void setFix(EvlFix fix) {
		this.fix = fix;
	}
	
	public Object getSelf() {
		return self;
	}

	public void setSelf(Object self) {
		this.self = self;
	}
	
	
	protected String title = null;
	public String getTitle() throws EolRuntimeException {
		
		if (title == null) {
			try {
				FrameStack oldScope = context.getFrameStack();
				context.setFrameStack(this.scope);
				title = fix.getTitle(self,context);
				context.setFrameStack(oldScope);
			}
			catch (EolRuntimeException ex) {
				title = "<error>";
				throw ex;
			}
		}
		
		return title;
	}
	
	public void perform() throws EolRuntimeException {
		FrameStack oldScope = context.getFrameStack();
		context.setFrameStack(this.scope);
		try {
			context.getModelRepository().getTransactionSupport().startTransaction();
			fix.execute(self,context);
			context.getModelRepository().getTransactionSupport().commitTransaction();
		}
		catch(EolRuntimeException ex) {
			context.getModelRepository().getTransactionSupport().rollbackTransaction();
			throw ex;
		}
		finally {
			context.setFrameStack(oldScope);
		}
		
	}
	
	@Override
	public String toString() {
		try {
			return getTitle();
		} catch (EolRuntimeException e) {
			context.getErrorStream().println(e.getMessage());
			return "An exception occured while evaluating the title of the fix";
		}
	}
}
