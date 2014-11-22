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

	protected NameExpression nameExpression;
	protected List<NameExpression> aliasNameExpressions = new ArrayList<NameExpression>();
	protected NameExpression driverNameExpression;
	protected List<ModelDeclarationParameter> modelDeclarationParameters = new ArrayList<ModelDeclarationParameter>();
	
	public ModelDeclaration() {}
	
	@Override
	public void build() {
		super.build();
		nameExpression = (NameExpression) getFirstChild();
		driverNameExpression = (NameExpression) AstUtil.getChild(this, EolParser.DRIVER).getFirstChild();
		AST aliasesAst = AstUtil.getChild(this, EolParser.ALIAS);
		if (aliasesAst != null) {
			for (AST aliasAst : aliasesAst.getChildren()) {
				aliasNameExpressions.add((NameExpression) aliasAst);
			}
		}
		AST parametersAst = AstUtil.getChild(this, EolParser.MODELDECLARATIONPARAMETERS);
		if (parametersAst != null) {
			for (AST parameterAst : parametersAst.getChildren()) {
				modelDeclarationParameters.add((ModelDeclarationParameter) parameterAst);
			}
		}
	}

	public NameExpression getNameExpression() {
		return nameExpression;
	}

	public void setNameExpression(NameExpression nameExpression) {
		this.nameExpression = nameExpression;
	}
	
	public NameExpression getDriverNameExpression() {
		return driverNameExpression;
	}

	public void setDriverNameExpression(NameExpression driverNameExpression) {
		this.driverNameExpression = driverNameExpression;
	}

	public List<NameExpression> getAliasNameExpressions() {
		return aliasNameExpressions;
	}

	public List<ModelDeclarationParameter> getModelDeclarationParameters() {
		return modelDeclarationParameters;
	}

	public List<?> getModuleElements() {
		return Collections.emptyList();
	}
}
