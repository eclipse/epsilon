/*******************************************************************************
 * Copyright (c) 2016 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Antonio Garcia-Dominguez - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.evl.dom;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.common.util.AstUtil;
import org.eclipse.epsilon.eol.dom.ExecutableBlock;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.evl.parse.Evl_EolParserRules;

/**
 * Decides if a constraint with context T, guard G and check C can be rephrased
 * into a single T.all.select(x|G and not C) query, which can be efficiently
 * executed by certain {@link IModel} implementations.
 */
public class ConstraintSelectTransfomer {

	public boolean canBeTransformed(Constraint c) {
		return isOptimisableExpression(c.getGuardBlock()) && isOptimisableExpression(c.getCheckBlock());
	}

	private boolean isOptimisableExpression(ExecutableBlock<Boolean> block) {
		if (block == null) {
			// non-existing blocks are trivially optimisable
			return true;
		}

		// First check: AST does not contain any invocations of satisfies*
		if (isDependentOnOtherRules(block)) {
			return false;
		}

		// Second, either this is not a block (just an expression), or it's
		// a "simple" block with a single "return EXPRESSION;" statement.
		AST expressionOrBlock = block.getFirstChild();
		if (expressionOrBlock.getType() != Evl_EolParserRules.BLOCK) {
			return true;
		} else {
			return isSimpleBlock(expressionOrBlock);
		}
	}

	private boolean isSimpleBlock(AST block) {
		if (block.getChildren().size() > 1) {
			return false;
		}

		return block.getFirstChild().getType() == Evl_EolParserRules.RETURN;
	}

	private boolean isDependentOnOtherRules(AST node) {
		if (node.getType() == Evl_EolParserRules.FEATURECALL) {
			final AST paramsNode = AstUtil.getChild(node, Evl_EolParserRules.PARAMETERS);

			if (paramsNode != null) {
				// It's a proper function call, e.g. x(a1, a2, ..., aN) 
				final String functionName = node.getText();

				if ("satisfies".equals(functionName)
					|| "satisfiesAll".equals(functionName)
					|| "satisfiesAny".equals(functionName)) {

					// It's one of the functions that declares dependencies between rules and prevents this optimisation from happening 
					return true;
				}
			}
		}

		for (AST child : node.getChildren()) {
			if (isDependentOnOtherRules(child)) {
				return true;
			}
		}

		return false;
	}

}
