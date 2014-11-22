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
import java.util.List;
import java.util.ListIterator;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;

// TODO : Overload add, addAll, remove et.al and add results to a hashtable for better performance
@SuppressWarnings("serial")
public class OperationList extends ArrayList<Operation> {

	public Operation getOperation(String name) {
		
		for (Operation operation : this) {
			if (operation.getName().equalsIgnoreCase(name)){
				return operation;
			}
		}
		
		return null;
	}
	
	//TODO: In case more than one helpers match when the ofTypeOnly = false
	// throw something like an EolAmbiguousHelperCallException
	public Operation getOperation(Object object, String name, List<?> parameters, IEolContext context) throws EolRuntimeException{
		Operation operation = getOperation(object,name,parameters,true,context);
		if (operation == null){
			operation = getOperation(object,name,parameters,false,context);
		}
		return operation;
	}
	
	public Operation getOperation(Object object, String name, List<?> parameters, boolean ofTypeOnly, IEolContext context) throws EolRuntimeException{
		List<Operation> operations = getOperations(object, name, parameters, ofTypeOnly, context, true);
		if (operations.isEmpty()) return null;
		else return operations.get(0);
	}
	
	public List<Operation> getOperations(Object object, String name, List<?> parameters, boolean ofTypeOnly, IEolContext context) throws EolRuntimeException{
		return getOperations(object, name, parameters, ofTypeOnly, context, false);
	}
	
	public List<Operation> getOperations(Object object, String name, List<?> parameters, boolean ofTypeOnly, IEolContext context, boolean returnOne) throws EolRuntimeException{
		List<Operation> operations = new ArrayList<Operation>();
		
		for (Operation operation : this) {
			if (operation.getName().compareTo(name) == 0 
					&& operation.getFormalParameters().size() == parameters.size()) {
				
				boolean correctContext = false;
				if (ofTypeOnly){
					correctContext = operation.getContextType(context).isType(object);
				}
				else {
					correctContext = operation.getContextType(context).isKind(object);
				}
				
				if (correctContext){
					ListIterator<?> pi = parameters.listIterator();
					ListIterator<?> fpi = operation.getFormalParameters().listIterator();
					boolean correctParameters = true;
					while (pi.hasNext()){
						Object parameter = pi.next();
						Parameter formalParameter = (Parameter) fpi.next();
						if (ofTypeOnly){
							correctParameters = correctParameters && 
								(formalParameter.getType(context).isType(parameter) || parameter == null); 
						}
						else {
							correctParameters = correctParameters && 
								(formalParameter.getType(context).isKind(parameter) || parameter == null); 
						}
					}
					
					if (correctParameters) {
						operations.add(operation);
						if (returnOne) return operations;
					}
				}
			}
		}
		
		return operations;
	}
	
	public Operation getOperation(Object source, NameExpression operationNameExpression, List<?> parameters, IEolContext context) throws EolRuntimeException{
		
		Operation operation = null;
		
		operation = getOperation(source, operationNameExpression.getName(), parameters, true, context);
		if (operation == null) {
			operation = getOperation(source, operationNameExpression.getName(), parameters, false, context);
		}
		
		return operation;
		
	}
	
	public Object execute(Object source, Operation operation, ArrayList<?> parameters, IEolContext context) throws EolRuntimeException{

		return operation.execute(source,parameters,context);
		
	}
}
