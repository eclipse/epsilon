/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.ewl.dom;

import java.util.Collections;
import java.util.List;

import org.eclipse.epsilon.common.module.IModule;
import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.common.util.AstUtil;
import org.eclipse.epsilon.eol.dom.ExecutableBlock;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.FrameType;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.erl.dom.NamedRule;
import org.eclipse.epsilon.ewl.parse.EwlParser;


public class Wizard extends NamedRule {
	
	protected ExecutableBlock<Boolean> guardBlock;
	protected ExecutableBlock<Void> bodyBlock;
	protected ExecutableBlock<String> titleBlock;
	
	public Wizard() {
		super();
	}
	
	@SuppressWarnings("unchecked")
	public void build(AST cst, IModule module) {
		super.build(cst, module);
		this.guardBlock = (ExecutableBlock<Boolean>) module.createAst(AstUtil.getChild(cst, EwlParser.GUARD), this);
		this.bodyBlock = (ExecutableBlock<Void>) module.createAst(AstUtil.getChild(cst,EwlParser.DO), this);
		this.titleBlock = (ExecutableBlock<String>) module.createAst(AstUtil.getChild(cst, EwlParser.TITLE), this);
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
		return getName();
	}
	
}

