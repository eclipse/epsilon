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
package org.eclipse.epsilon.eol.dom;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.epsilon.common.module.AbstractModuleElement;
import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.common.util.AstUtil;
import org.eclipse.epsilon.eol.parse.EolParser;

public class ModelDeclaration extends AbstractModuleElement {

	protected NameExpression name;
	protected List<NameExpression> aliases = new ArrayList<NameExpression>();
	protected NameExpression driver;
	protected List<ModelDeclarationParameter> parameters = new ArrayList<ModelDeclarationParameter>();
	
	@Override
	public void build() {
		super.build();
		name = (NameExpression) getFirstChild();
		driver = (NameExpression) AstUtil.getChild(this, EolParser.DRIVER).getFirstChild();
		AST aliasesAst = AstUtil.getChild(this, EolParser.ALIAS);
		if (aliasesAst != null) {
			for (AST aliasAst : aliasesAst.getChildren()) {
				aliases.add((NameExpression) aliasAst);
			}
		}
		AST parametersAst = AstUtil.getChild(this, EolParser.MODELDECLARATIONPARAMETERS);
		if (parametersAst != null) {
			for (AST parameterAst : parametersAst.getChildren()) {
				parameters.add((ModelDeclarationParameter) parameterAst);
			}
		}
	}
	
	public NameExpression getName() {
		return name;
	}

	public void setName(NameExpression name) {
		this.name = name;
	}

	public NameExpression getDriver() {
		return driver;
	}

	public void setDriver(NameExpression driver) {
		this.driver = driver;
	}

	public List<NameExpression> getAliases() {
		return aliases;
	}

	public List<ModelDeclarationParameter> getParameters() {
		return parameters;
	}

	public List<?> getModuleElements() {
		return Collections.emptyList();
	}
}
