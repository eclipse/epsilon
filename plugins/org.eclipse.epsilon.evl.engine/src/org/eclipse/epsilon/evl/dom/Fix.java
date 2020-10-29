/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.evl.dom;

import org.eclipse.epsilon.common.module.AbstractModuleElement;
import org.eclipse.epsilon.common.module.IModule;
import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.common.util.AstUtil;
import org.eclipse.epsilon.eol.dom.ExecutableBlock;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.FrameType;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.evl.execute.context.IEvlContext;
import org.eclipse.epsilon.evl.parse.EvlParser;

public class Fix extends AbstractModuleElement {

	protected ExecutableBlock<Boolean> guardBlock;
	protected ExecutableBlock<String> titleBlock;
	protected ExecutableBlock<Void> bodyBlock;
	
	@SuppressWarnings("unchecked")
	public void build(AST cst, IModule module) {
		super.build(cst, module);
		guardBlock = (ExecutableBlock<Boolean>) module.createAst(AstUtil.getChild(cst, EvlParser.GUARD), this);
		titleBlock = (ExecutableBlock<String>) module.createAst(AstUtil.getChild(cst,EvlParser.TITLE), this);
		bodyBlock = (ExecutableBlock<Void>) module.createAst(AstUtil.getChild(cst,EvlParser.DO), this);
	}
	
	public String getTitle(Object self, IEvlContext context) throws EolRuntimeException{
		return titleBlock.execute(context, true, FrameType.UNPROTECTED);
	}
	
	public void execute(Object self, IEvlContext context) throws EolRuntimeException {
		bodyBlock.execute(context, true, FrameType.UNPROTECTED);
	}

	public boolean appliesTo(Object self, IEvlContext context) throws EolRuntimeException {
		if (guardBlock != null) {
			return guardBlock.execute(context, Variable.createReadOnlyVariable("self", self));
		}
		else return true;
	}
	
	public void accept(IEvlVisitor visitor) {
		visitor.visit(this);
	}
	
	public ExecutableBlock<Boolean> getGuardBlock() {
		return guardBlock;
	}
	
	public void setGuardBlock(ExecutableBlock<Boolean> guardBlock) {
		this.guardBlock = guardBlock;
	}
	
	public ExecutableBlock<String> getTitleBlock() {
		return titleBlock;
	}
	
	public void setTitleBlock(ExecutableBlock<String> titleBlock) {
		this.titleBlock = titleBlock;
	}
	
	public ExecutableBlock<Void> getBodyBlock() {
		return bodyBlock;
	}
	
	public void setBodyBlock(ExecutableBlock<Void> bodyBlock) {
		this.bodyBlock = bodyBlock;
	}
}
