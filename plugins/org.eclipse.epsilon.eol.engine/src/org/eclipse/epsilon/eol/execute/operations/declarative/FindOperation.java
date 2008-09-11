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
package org.eclipse.epsilon.eol.execute.operations.declarative;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.eol.EolFormalParameter;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.operations.AbstractOperation;
import org.eclipse.epsilon.eol.types.EolType;


public class FindOperation extends AbstractOperation {

	@Override
	public Object execute(Object source, AST ast, IEolContext context)
			throws EolRuntimeException {

		
		List<EolFormalParameter> parameters = new ArrayList<EolFormalParameter>(); 
		
		AST parametersAst = ast.getFirstChild();
		AST declarationsAst = parametersAst.getFirstChild();
		AST bodyAst = declarationsAst.getNextSibling();
		
		AST declarationAst = declarationsAst.getFirstChild();
		AST iteratorNameAst = declarationAst.getFirstChild();
		AST iteratorTypeAst = iteratorNameAst.getNextSibling();
		
		String iteratorName = iteratorNameAst.getText();
		EolType iteratorType = null;
		
		
		return null;
	}

	protected List<List> getCombinations(Collection<Collection> collections) {
		
		List<List> combinations = new ArrayList<List>();
		
		int combinationsCount = 1;
		
		for (Collection collection : collections) {
			combinationsCount = combinationsCount * collection.size();
		}
		
		for (int i=0;i<combinationsCount;i++) {
			combinations.add(new ArrayList());
		}
		
		for (Collection collection : collections) {
			//int combinationIndex = 0;
			//Object item = collection.iterator().next();
			for (List combination : combinations) {
				
			}
		}
		
		return combinations;
		
		
	}
	
	
}
