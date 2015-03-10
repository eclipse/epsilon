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
package org.eclipse.epsilon.ewl.dom;

import java.util.Collections;
import java.util.List;

import org.eclipse.epsilon.common.util.AstUtil;
import org.eclipse.epsilon.eol.dom.AnnotatableModuleElement;
import org.eclipse.epsilon.eol.dom.ExecutableBlock;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.FrameType;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.ewl.parse.EwlParser;


public class Wizard extends AnnotatableModuleElement {
	
	protected String name;
	protected ExecutableBlock<Boolean> guardBlock;
	protected ExecutableBlock<Void> bodyBlock;
	protected ExecutableBlock<String> titleBlock;
	
	public Wizard() {
		super();
	}
	
	@SuppressWarnings("unchecked")
	public void build() {
		super.build();
		this.name = this.getText();
		this.guardBlock = (ExecutableBlock<Boolean>) AstUtil.getChild(this, EwlParser.GUARD);
		this.bodyBlock = (ExecutableBlock<Void>) AstUtil.getChild(this,EwlParser.DO);
		this.titleBlock = (ExecutableBlock<String>) AstUtil.getChild(this, EwlParser.TITLE);
	}
	
	public boolean appliesTo(Object self, IEolContext context) throws EolRuntimeException{
		if (guardBlock != null && guardBlock.getBody() != null) {
			context.getFrameStack().enterLocal(FrameType.UNPROTECTED, guardBlock.getBody());
			return guardBlock.execute(context, false, Variable.createReadOnlyVariable("self", self));
		}
		else {
			return true;
		}
	}
	
	public void process(Object self, IEolContext context) throws EolRuntimeException {
		bodyBlock.execute(context, true, FrameType.UNPROTECTED, Variable.createReadOnlyVariable("self",self));
	}
	
	public String getTitle(Object self, IEolContext context) throws EolRuntimeException{
		return titleBlock.execute(context, true, FrameType.UNPROTECTED, Variable.createReadOnlyVariable("self",self));
	}

	public List<?> getModuleElements() {
		return Collections.emptyList();
	}
	
	@Override
	public String toString(){
		return name;
	}

	public String getName() {
		return name;
	}
	
}

