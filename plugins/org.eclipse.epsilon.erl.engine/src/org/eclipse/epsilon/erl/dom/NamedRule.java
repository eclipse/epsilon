/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.erl.dom;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import org.eclipse.epsilon.common.module.IModule;
import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.dom.AnnotatableModuleElement;
import org.eclipse.epsilon.eol.dom.NameExpression;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.erl.execute.context.IErlContext;

public class NamedRule extends AnnotatableModuleElement {
	
	protected NameExpression nameExpression;

	@Override
	public void build(AST cst, IModule module) {
		super.build(cst, module);
		nameExpression = (NameExpression) module.createAst(getNameAst(cst), this);
	}
	
	protected AST getNameAst(AST cst) {
		return cst.getFirstChild();
	}
	
	public String getName() { 
		if (nameExpression != null) {
			return nameExpression.getName();
		}
		return "";
	}
	
	public NameExpression getNameExpression() {
		return nameExpression;
	}
	
	public void setNameExpression(NameExpression nameExpression) {
		this.nameExpression = nameExpression;
	}
	
	public List<?> getModuleElements() {
		return Collections.emptyList();
	}
	
	public Object execute(Object self, IErlContext context) throws EolRuntimeException {
		return context.getExecutorFactory().execute(this, self, context);
	}
	
	public Object executeImpl(Object self, IErlContext context) throws EolRuntimeException {
		return null;
	}
	
	@Override
	public String toString() {
		return getName();
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), toString());
	}
	
	@Override
	public boolean equals(Object other) {
		if (!super.equals(other))
			return false;
		
		return Objects.equals(this.toString(), other.toString());
	}
}
