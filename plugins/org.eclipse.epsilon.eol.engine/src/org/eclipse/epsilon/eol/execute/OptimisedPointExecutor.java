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
package org.eclipse.epsilon.eol.execute;

import java.util.Arrays;
import java.util.HashSet;

import org.antlr.runtime.CommonToken;
import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.PointExecutor;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.eol.models.ISearchableModel;
import org.eclipse.epsilon.eol.models.ModelRepository;
import org.eclipse.epsilon.eol.parse.EolParser;
import org.eclipse.epsilon.eol.types.EolModelElementType;

/**
 * Detects queries of the type X.all.select(x|x.foo = "bar") and if the model of X is an ISearchableModel
 * it turns them to M.find(x:X|foo = "bar"). Works for select, selectOne, exists and forAll.
 *
 */
public class OptimisedPointExecutor extends PointExecutor {
	
	protected HashSet<String> optimisableOperations = new HashSet<String>(Arrays.asList("select", "selectOne", "exists", "forAll"));
	protected HashSet<String> allOperations = new HashSet<String>(Arrays.asList("all", "allInstances"));
	protected boolean arrow;
	
	public OptimisedPointExecutor(boolean arrow) {
		this.arrow = arrow;
	}
	
	@Override
	protected boolean isArrow() {
		return arrow;
	}
	
	protected boolean containsSearchableModels(ModelRepository modelRepository) {
		for (IModel model : modelRepository.getModels()) {
			if (model instanceof ISearchableModel) return true;
		}
		return false;
	}
	
	@Override
	public Object execute(AST ast, IEolContext context)
			throws EolRuntimeException {
		
		// If no searchable models are contained in the model repository
		// there is nothing to optimise
		if (!containsSearchableModels(context.getModelRepository())) {
			return super.execute(ast, context);
		}
		
		AST targetAst = ast.getChild(0);
		AST featureCallAst = ast.getChild(1);
		
		String operationName = featureCallAst.getText();
		
		if (targetAst.getType() == EolParser.POINT && optimisableOperations.contains(operationName)) {
			
			AST targetTargetAst = targetAst.getChild(0);
			AST targetFeatureCallAst = targetAst.getChild(1);
			
			boolean targetTargetLooksLikeTypeName = 
					(targetTargetAst.getType() == EolParser.NAME) || // e.g. X!Y
					(targetTargetAst.getType() == EolParser.FEATURECALL && targetTargetAst.getChildren().isEmpty()); // simple names
			
			if (allOperations.contains(targetFeatureCallAst.getText()) && targetTargetLooksLikeTypeName) {
				
				try {
					EolModelElementType type = EolModelElementType.forName(targetTargetAst.getText(), context);
					
					boolean one = !operationName.equals("select");
					
					if (type != null && type.getModel() instanceof ISearchableModel) {
						ISearchableModel searchableModel = (ISearchableModel) type.getModel();
						
						String iteratorName = featureCallAst.getFirstChild().getFirstChild().getFirstChild().getText();
						Variable iterator = new Variable(iteratorName, null, type);
						
						AST parametersAst = featureCallAst.getChild(1);
						if (operationName.equals("forAll")) {
							CommonToken notToken = new CommonToken(EolParser.OPERATOR);
							notToken.setText("not");
							AST notAst = new AST(notToken, null);
							notAst.addChild(parametersAst);
							parametersAst = notAst;
						}
						
						if (one) {
							Object result = searchableModel.findOne(iterator, parametersAst, context);
							if (operationName.equals("exists")) return result != null;
							else if (operationName.equals("selectOne")) return result;
							else if (operationName.equals("forAll")) return result == null;
						}
						else {
							return searchableModel.find(iterator, parametersAst, context);
						}
					}
					
				}
				catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
		return super.execute(ast, context);
	}

}
