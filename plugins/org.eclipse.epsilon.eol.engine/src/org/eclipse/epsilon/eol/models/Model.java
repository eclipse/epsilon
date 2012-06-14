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
package org.eclipse.epsilon.eol.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.epsilon.commons.util.StringProperties;
import org.eclipse.epsilon.eol.exceptions.models.EolModelElementTypeNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.epsilon.eol.exceptions.models.EolNotInstantiableModelElementTypeException;
import org.eclipse.epsilon.eol.execute.introspection.IPropertyGetter;
import org.eclipse.epsilon.eol.execute.introspection.IPropertySetter;
import org.eclipse.epsilon.eol.execute.introspection.java.JavaPropertyGetter;
import org.eclipse.epsilon.eol.execute.introspection.java.JavaPropertySetter;
import org.eclipse.epsilon.eol.models.transactions.IModelTransactionSupport;
import org.eclipse.epsilon.eol.models.transactions.NoModelTransactionSupport;

public abstract class Model implements IModel{
	
	public static final String PROPERTY_NAME = "name";
	public static final String PROPERTY_READONLOAD = "readOnLoad";
	public static final String PROPERTY_STOREONDISPOSAL = "storeOnDisposal";
	public static final String PROPERTY_ALIASES = "aliases";
	

	protected String name;
	protected List<String> aliases = new ArrayList<String>();
	protected boolean storeOnDisposal = false;
	protected boolean readOnLoad = true;
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public List<String> getAliases() {
		return aliases;
	}
	
	public void load(StringProperties properties, String basePath) throws EolModelLoadingException {
		this.name = properties.getProperty(PROPERTY_NAME);
		this.readOnLoad = new Boolean(properties.getProperty(PROPERTY_READONLOAD)).booleanValue();
		this.storeOnDisposal = new Boolean(properties.getProperty(PROPERTY_STOREONDISPOSAL)).booleanValue();
		
		String[] aliases = properties.getProperty(PROPERTY_ALIASES).split(",");
		for (int i=0;i<aliases.length;i++){
			this.aliases.add(aliases[i].trim());
		}
	}
	
	public Object createInstance(String type, Collection<Object> parameters)
			throws EolModelElementTypeNotFoundException,
			EolNotInstantiableModelElementTypeException {
		return createInstance(type);
	}
	
	/*
	public Collection allInstances() {
		ArrayList allInstances = new ArrayList();
		Collection metaClasses = getAllClasses(true);
		Iterator it = metaClasses.iterator();
		while (it.hasNext()){
			String metaClass = it.next().toString();
			Collection instances = null;
			try {
				instances = getAllOfClass(metaClass);
			} catch (EolMetaClassNotFoundException e) {
				// Not going to happen
			}
			allInstances.addAll(instances);
		}
		return allInstances;
	}
	*/
	
	public Collection allInstances() {
		return allContents();
	}

	public boolean isOfKind(Object instance, String metaClass) throws EolModelElementTypeNotFoundException{
		Collection allOfKind = getAllOfKind(metaClass);
		if (allOfKind != null && allOfKind.contains(instance)){
			return true;
		}
		else {
			return false;
		}
	}

	public boolean isOfType(Object instance, String metaClass) throws EolModelElementTypeNotFoundException{
		Collection allOfClass = getAllOfType(metaClass);
		if (allOfClass != null && allOfClass.contains(instance)){
			return true;
		}
		else {
			return false;
		}		
	}
	
	@Override
	public String getFullyQualifiedTypeNameOf(Object instance) {
		return getTypeNameOf(instance);
	}
	
	/*
	EolEngine eolEngine = new EolEngine();
	public Object execute(EolString eol) throws Exception {
		return eolEngine.process(eol.getValue());
	}
	*/
	
	//public boolean isAbstract(String metaClass){
	//	return getAllClasses(true).contains(metaClass);
	//}
	
	/*
	public void setReadWrite(int readWrite){
		this.readWrite = readWrite;
	}
	
	public int getReadWrite(){
		return readWrite;
	}
	*/
	
	public boolean isReadOnLoad() {
		return readOnLoad;
	}

	public boolean isStoredOnDisposal() {
		return storeOnDisposal;
	}

	public void setReadOnLoad(boolean readOnLoad) {
		this.readOnLoad = readOnLoad;
	}

	public void setStoredOnDisposal(boolean storedOnDisposal) {
		this.storeOnDisposal = storedOnDisposal;
	}

	public IPropertyGetter getPropertyGetter() {
		return new JavaPropertyGetter();
	}

	public IPropertySetter getPropertySetter() {
		return new JavaPropertySetter();
	}
	
	public void dispose() {
		if (this.isStoredOnDisposal()){
			this.store();
		}
	}
	
	public boolean knowsAboutProperty(Object instance, String property) {
		return owns(instance);
	}
	
	NoModelTransactionSupport transactionSupport = new NoModelTransactionSupport();
	public IModelTransactionSupport getTransactionSupport() {
		return transactionSupport;
	}
}
