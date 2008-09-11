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
package org.eclipse.epsilon.eol.execute.operations.simple;

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.operations.AbstractOperation;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.eol.types.EolCollectionType;
import org.eclipse.epsilon.eol.types.EolPrimitiveType;


public class TypeOperation extends AbstractOperation {

	@Override
	public Object execute(Object source, AST operationAst, IEolContext context) throws EolRuntimeException {
		
		if (EolPrimitiveType.String.isType(source)){
			return EolPrimitiveType.String;
		}
		else if (EolPrimitiveType.Boolean.isType(source)){
			return EolPrimitiveType.Boolean;
		}
		else if (EolPrimitiveType.Real.isType(source)){
			return EolPrimitiveType.Real;
		}
		else if (EolPrimitiveType.Integer.isType(source)){
			return EolPrimitiveType.Integer;
		}
		else if (EolCollectionType.Bag.isType(source)){
			return EolCollectionType.Bag;
		}
		else if (EolCollectionType.Sequence.isType(source)){
			return EolCollectionType.Sequence;
		}
		else if (EolCollectionType.Set.isType(source)){
			return EolCollectionType.Set;
		}
		else if (EolCollectionType.OrderedSet.isType(source)){
			return EolCollectionType.OrderedSet;
		}
		
		IModel model = context.getModelRepository().getOwningModel(source);
		if (model != null){
			return model.getTypeOf(source);
		}
		
		return null;
	}

}
