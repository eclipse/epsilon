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
package org.eclipse.epsilon.eol.execute.operations;

import java.util.HashMap;

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.eol.exceptions.EolIllegalOperationException;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.operations.declarative.ClosureOperation;
import org.eclipse.epsilon.eol.execute.operations.declarative.CollectOperation;
import org.eclipse.epsilon.eol.execute.operations.declarative.ExistsOperation;
import org.eclipse.epsilon.eol.execute.operations.declarative.ForAllOperation;
import org.eclipse.epsilon.eol.execute.operations.declarative.IterateOperation;
import org.eclipse.epsilon.eol.execute.operations.declarative.OneOperation;
import org.eclipse.epsilon.eol.execute.operations.declarative.RejectOperation;
import org.eclipse.epsilon.eol.execute.operations.declarative.Select2Operation;
import org.eclipse.epsilon.eol.execute.operations.declarative.SelectOneOperation;
import org.eclipse.epsilon.eol.execute.operations.declarative.SelectOperation;
import org.eclipse.epsilon.eol.execute.operations.declarative.SortByOperation;
import org.eclipse.epsilon.eol.execute.operations.simple.AllSuperClassesOperation;
import org.eclipse.epsilon.eol.execute.operations.simple.AsBagOperation;
import org.eclipse.epsilon.eol.execute.operations.simple.AsBooleanOperation;
import org.eclipse.epsilon.eol.execute.operations.simple.AsFloatOperation;
import org.eclipse.epsilon.eol.execute.operations.simple.AsIntegerOperation;
import org.eclipse.epsilon.eol.execute.operations.simple.AsOrderedSetOperation;
import org.eclipse.epsilon.eol.execute.operations.simple.AsRealOperation;
import org.eclipse.epsilon.eol.execute.operations.simple.AsSequenceOperation;
import org.eclipse.epsilon.eol.execute.operations.simple.AsSetOperation;
import org.eclipse.epsilon.eol.execute.operations.simple.AsStringOperation;
import org.eclipse.epsilon.eol.execute.operations.simple.ErrOperation;
import org.eclipse.epsilon.eol.execute.operations.simple.ErrlnOperation;
import org.eclipse.epsilon.eol.execute.operations.simple.HasPropertyOperation;
import org.eclipse.epsilon.eol.execute.operations.simple.IdOperation;
import org.eclipse.epsilon.eol.execute.operations.simple.IfUndefinedOperation;
import org.eclipse.epsilon.eol.execute.operations.simple.IsDefinedOperation;
import org.eclipse.epsilon.eol.execute.operations.simple.IsKindOfOperation;
import org.eclipse.epsilon.eol.execute.operations.simple.IsTypeOfOperation;
import org.eclipse.epsilon.eol.execute.operations.simple.IsUndefinedOperation;
import org.eclipse.epsilon.eol.execute.operations.simple.LastOperation;
import org.eclipse.epsilon.eol.execute.operations.simple.NativeTypeOperation;
import org.eclipse.epsilon.eol.execute.operations.simple.OwningModelOperation;
import org.eclipse.epsilon.eol.execute.operations.simple.PrintOperation;
import org.eclipse.epsilon.eol.execute.operations.simple.PrintlnOperation;
import org.eclipse.epsilon.eol.execute.operations.simple.RandomOperation;
import org.eclipse.epsilon.eol.execute.operations.simple.SizeOperation;
import org.eclipse.epsilon.eol.execute.operations.simple.ToEnumOperation;
import org.eclipse.epsilon.eol.execute.operations.simple.ToStringOperation;
import org.eclipse.epsilon.eol.execute.operations.simple.TypeOperation;
import org.eclipse.epsilon.eol.execute.operations.simple.UnwrapOperation;
import org.eclipse.epsilon.eol.execute.operations.simple.assertions.AssertEqualsOperation;
import org.eclipse.epsilon.eol.execute.operations.simple.assertions.AssertErrorOperation;
import org.eclipse.epsilon.eol.execute.operations.simple.assertions.AssertNotEqualsOperation;
import org.eclipse.epsilon.eol.execute.operations.simple.assertions.AssertOperation;


public class OperationFactory {
	
	//protected ArrayList lookupPackages = new ArrayList();
	
	protected HashMap<String, AbstractOperation> operationCache = new HashMap();
	
	public OperationFactory(){
		createCache();
	}
	
	protected void createCache() {
		
		// Operations declaring variables
		operationCache.put("assert", new AssertOperation());
		operationCache.put("assertEquals", new AssertEqualsOperation());
		operationCache.put("assertNotEquals", new AssertNotEqualsOperation());
		operationCache.put("assertError", new AssertErrorOperation());
		operationCache.put("collect", new CollectOperation());
		operationCache.put("exists", new ExistsOperation());
		operationCache.put("one", new OneOperation());
		operationCache.put("forAll", new ForAllOperation());
		operationCache.put("iterate", new IterateOperation());
		operationCache.put("reject", new RejectOperation());
		operationCache.put("select", new SelectOperation());
		operationCache.put("select2", new Select2Operation());
		operationCache.put("selectOne", new SelectOneOperation());
		operationCache.put("closure", new ClosureOperation());
		operationCache.put("sortBy", new SortByOperation());
		
		// Type convertion operations
		operationCache.put("asBag", new AsBagOperation());
		operationCache.put("asBoolean", new AsBooleanOperation());
		operationCache.put("asInteger", new AsIntegerOperation());
		operationCache.put("asReal", new AsRealOperation());
		operationCache.put("asFloat", new AsFloatOperation());
		operationCache.put("asSequence", new AsSequenceOperation());
		operationCache.put("asSet", new AsSetOperation());
		operationCache.put("asOrderedSet", new AsOrderedSetOperation());
		operationCache.put("asString", new AsStringOperation());
		
		// Introspection etc
		operationCache.put("hasProperty", new HasPropertyOperation());
		operationCache.put("id", new IdOperation());
		//operationCache.put("indexOf", new IndexOfOperation());
		operationCache.put("isDefined", new IsDefinedOperation());
		operationCache.put("isTypeOf", new IsTypeOfOperation());
		operationCache.put("isKindOf", new IsKindOfOperation());
		operationCache.put("isUndefined", new IsUndefinedOperation());
		operationCache.put("ifUndefined", new IfUndefinedOperation());
		operationCache.put("last", new LastOperation());
		operationCache.put("nativeType", new NativeTypeOperation());
		operationCache.put("owningModel", new OwningModelOperation());
		operationCache.put("println", new PrintlnOperation());
		operationCache.put("print", new PrintOperation());
		operationCache.put("err", new ErrOperation());
		operationCache.put("errln", new ErrlnOperation());
		operationCache.put("size", new SizeOperation());
		operationCache.put("sortBy", new SortByOperation());
		operationCache.put("type", new TypeOperation());
		operationCache.put("unwrap", new UnwrapOperation());
		
		// Misc operations...
		operationCache.put("allSuperClasses", new AllSuperClassesOperation());
		operationCache.put("toEnum", new ToEnumOperation());
		operationCache.put("toString", new ToStringOperation());
		operationCache.put("random", new RandomOperation());
	}
	
	/*
	
	public List getLookupPackages(){
		return lookupPackages;
	}
	
	*/
	
	/**
	 * Create an instance of the specified operation.
	 * Implementations of operations exist under the
	 * lookupPackage package collection. The implementation of 
	 * the requested operation must have the following 
	 * class name: 
	 * <code>toCamel(name) + "Operation"</code>
	 * so for <code>o-&gt;print()</code> the method will try to instantiate
	 * and return <code>org.xol.execute.operations.simple.PrintOperation</code>
	 * @param name
	 * @return AbstractOperation
	 */
	/*
	protected AbstractOperation getOperationFor(String name){
		
		AbstractOperation operation = null;
		
		ListIterator li = lookupPackages.listIterator();
		
		while (li.hasNext()){
			String className = li.next().toString() + "." + StringUtil.firstToUpper(name) + "Operation";
			try {
				operation = (AbstractOperation) Class.forName(className).newInstance();
				if (operation != null){
					return operation;
				}
			}
			catch (Exception ex){
				// Safely ignore the exception
			}
		}
		return null;
	}
	*/
	
	public AbstractOperation getOperationFor(String name) {
		return operationCache.get(name);
	}
	
	public AbstractOperation getOperationFor(AST operationAst, IEolContext context){
		return getOperationFor(operationAst.getText());
	}
	
	public Object executeOperation(Object source, AST operationAst, IEolContext context) throws EolRuntimeException{
		AbstractOperation operation = getOperationFor(operationAst.getText());
		if (operation == null) {
			throw new EolIllegalOperationException(source, operationAst.getText(), operationAst);
		} else {
			return operation.execute(source, operationAst, context);
		}
	}
}
