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

	protected IdentifierExpression name;
	protected List<IdentifierExpression> aliases = new ArrayList<IdentifierExpression>();
	protected IdentifierExpression driver;
	protected List<ModelDeclarationParameter> parameters = new ArrayList<ModelDeclarationParameter>();
	
	@Override
	public void build() {
		super.build();
		name = (IdentifierExpression) getFirstChild();
		driver = (IdentifierExpression) AstUtil.getChild(this, EolParser.DRIVER).getFirstChild();
		AST aliasesAst = AstUtil.getChild(this, EolParser.ALIAS);
		if (aliasesAst != null) {
			for (AST aliasAst : aliasesAst.getChildren()) {
				aliases.add((IdentifierExpression) aliasAst);
			}
		}
		AST parametersAst = AstUtil.getChild(this, EolParser.MODELDECLARATIONPARAMETERS);
		if (parametersAst != null) {
			for (AST parameterAst : parametersAst.getChildren()) {
				parameters.add((ModelDeclarationParameter) parameterAst);
			}
		}
	}
	
	public IdentifierExpression getName() {
		return name;
	}

	public void setName(IdentifierExpression name) {
		this.name = name;
	}

	public IdentifierExpression getDriver() {
		return driver;
	}

	public void setDriver(IdentifierExpression driver) {
		this.driver = driver;
	}

	public List<IdentifierExpression> getAliases() {
		return aliases;
	}

	public List<ModelDeclarationParameter> getParameters() {
		return parameters;
	}

	public List<?> getModuleElements() {
		return Collections.emptyList();
	}
}
