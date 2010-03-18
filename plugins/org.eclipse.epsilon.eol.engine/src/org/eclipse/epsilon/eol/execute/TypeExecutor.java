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

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.exceptions.EolTypeNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelElementTypeNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelNotFoundException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.types.EolAnyType;
import org.eclipse.epsilon.eol.types.EolCollectionType;
import org.eclipse.epsilon.eol.types.EolModelElementType;
import org.eclipse.epsilon.eol.types.EolNativeType;
import org.eclipse.epsilon.eol.types.EolNoType;
import org.eclipse.epsilon.eol.types.EolPrimitiveType;
import org.eclipse.epsilon.eol.types.EolType;


public class TypeExecutor extends AbstractExecutor{

	@Override
	public Object execute(AST ast, IEolContext context) throws EolRuntimeException {
		
		String typeName = ast.getText();
		
		if (typeName.equals("Integer")){
			return EolPrimitiveType.Integer;
		}
		else if (typeName.equals("Any")){
			return EolAnyType.Instance;
		}
		else if (typeName.equals("Boolean")){
			return EolPrimitiveType.Boolean;
		}
		else if (typeName.equals("String")){
			return EolPrimitiveType.String;
		}
		else if (typeName.equals("Real")){
			return EolPrimitiveType.Real;
		}
		else if (typeName.equals("Map")){
			return EolPrimitiveType.Map;
		}
		else if (typeName.equals("Sequence") || typeName.equals("List")){
			return EolCollectionType.Sequence;
		}
		else if (typeName.equals("Bag")){
			return EolCollectionType.Bag;
		}
		else if (typeName.equals("Set")){
			return EolCollectionType.Set;
		}
		else if (typeName.equals("OrderedSet")){
			return EolCollectionType.OrderedSet;
		}
		else if (typeName.equals("Collection")){
			return EolCollectionType.Collection;
		}
		else if (typeName.equals("Native")){
			return new EolNativeType(ast.getFirstChild(), context);
		}
		else if (typeName.equals("Nothing")) {
			return EolNoType.Instance;
		}
		
		try {
			EolType type = EolModelElementType.forName(typeName ,context);
			return type;
		}
		catch (EolModelNotFoundException ex){
			// Ignore
		}
		catch (EolModelElementTypeNotFoundException mex){
			// throw new EolTypeNotFoundException(typeName,ast);
		}
		
		//return null;
		
		//return new EolNativeType(ast, context);
		
		throw new EolTypeNotFoundException(typeName, ast);
		
	}

}
