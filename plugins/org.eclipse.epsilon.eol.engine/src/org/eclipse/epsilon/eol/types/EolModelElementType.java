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
package org.eclipse.epsilon.eol.types;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.common.util.CollectionUtil;
import org.eclipse.epsilon.common.util.CollectionUtil.ElementPrinter;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelElementTypeNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelNotFoundException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.eol.models.ModelRepository.AmbiguityCheckResult;

public class EolModelElementType extends EolType{
	
	protected String modelName = "";
	protected String typeName = "";
	protected IModel model;
	
	//static HashMap<String, EolModelElementType> cache = new HashMap<String, EolModelElementType>();
	
	public static EolModelElementType forName(String modelAndMetaClass, IEolContext context) throws EolModelElementTypeNotFoundException, EolModelNotFoundException {
		EolModelElementType type = null;
		///if (cache.containsKey(modelAndMetaClass)) {
		//	type = cache.get(modelAndMetaClass);
		//}
		//else {
			type = new EolModelElementType(modelAndMetaClass, context);
		//	cache.put(modelAndMetaClass, type);
		//}
		return type;
	}

	private EolModelElementType(String modelAndMetaClass,IEolContext context) throws EolModelNotFoundException, EolModelElementTypeNotFoundException {
		
		if (modelAndMetaClass.indexOf("!") > -1){
			String[] parts = modelAndMetaClass.split("!");
			modelName = parts[0];
			typeName = parts[1];
		}
		else {
			modelName = "";
			typeName = modelAndMetaClass;
		}
		
		checkAmbiguityOfType(context);

		try {
			model = context.getModelRepository().getModelByName(modelName);
		}
		catch (EolModelNotFoundException ex) {
			Variable modelVariable = context.getFrameStack().get(modelName);
			if (modelVariable.getValue() instanceof IModel) {
				model = (IModel) modelVariable.getValue();
			}
		}
		
		if (model==null || !model.hasType(typeName)){
			throw new EolModelElementTypeNotFoundException(modelName,typeName);
		}
	}

	private void checkAmbiguityOfType(IEolContext context) {
		if (modelName.isEmpty()) {
			final AmbiguityCheckResult result = context.getModelRepository().checkAmbiguity(typeName);

			if (result.isAmbiguous) {
				issueAmbiguousTypeWarning(context, result);
			}
		}
	}

	private void issueAmbiguousTypeWarning(IEolContext context, AmbiguityCheckResult result) {
		final String potentialTypes = CollectionUtil.join(result.namesOfOwningModels, " ", new ElementPrinter() {
			
			@Override
			public String print(Object element) {
				return "'" + element + "!" + typeName + "'";
			}
		});
		
		context.getWarningStream().println("Warning: The type '" + typeName + "' " + 
		                                   "is ambiguous and could refer to any of the following: " + potentialTypes + ". " + 
		                                   "The type '" + result.nameOfSelectedModel + "!" + typeName + "' has been assumed. " +
		                                   determineLocation(context.getFrameStack().getCurrentStatement()));
	}

	private String determineLocation(AST statement) {
		if (statement == null)
			return "";
		else
			return "(" + statement.getFile() + "@" + statement.getLine() + ":" + statement.getColumn() + ")";
	}

	public String getModelName() {
		return modelName;
	}
	
	public void setModelName(String model) {
		this.modelName = model;
	}
	
	public String getTypeName() {
		return typeName;
	}
	
	public void setTypeName(String type) {
		this.typeName = type;
	}
	
	public Collection<?> getAllOfKind(){
		try {
			return model.getAllOfKind(typeName);
		}
		catch (Exception e) {
			e.printStackTrace();
			return Collections.EMPTY_LIST;
		}
	}
	
	public Collection<?> getAllOfType(){
		try {
			return model.getAllOfType(typeName);
		}
		catch (Exception e) {
			e.printStackTrace();
			return Collections.EMPTY_LIST;
		}
	}
	
	public Collection<?> getAll() {
		return getAllOfKind();
	}
	
	public Collection<?> all() {
		return getAllOfKind();
	}
	
	public Collection<?> getAllInstances(){
		return getAllOfKind();
	}
	
	public Collection<?> allInstances(){
		return getAllOfKind();
	}
	
	public boolean isInstantiable(){
		return model.isInstantiable(typeName);
	}
	
	@Override
	public boolean isType(Object o){
		try {
			return model.isOfType(o,typeName);
		}
		catch (Exception ex){
			ex.printStackTrace();
			return false;
		}
	}
	
	@Override
	public Object createInstance() throws EolRuntimeException{
		return model.createInstance(typeName);
	}

	@Override
	public Object createInstance(List<Object> parameters)
			throws EolRuntimeException {
		return model.createInstance(typeName, parameters);
	}
	
	@Override
	public boolean isKind(Object o) {
		try {
			return model.isOfKind(o,typeName);
		}
		catch (Exception ex){
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public String getName() {
		String name = "";
		if (modelName.length() > 0){
			name = modelName + "!";
		}
		return name + typeName; 
	}
	
	public IModel getModel() {
		return model;
	}
}
