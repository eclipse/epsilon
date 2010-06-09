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
import java.util.ListIterator;

import org.eclipse.epsilon.commons.util.StringProperties;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.exceptions.models.EolEnumerationValueNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelElementTypeNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolNotInstantiableModelElementTypeException;
import org.eclipse.epsilon.eol.execute.introspection.AbstractPropertyGetter;
import org.eclipse.epsilon.eol.execute.introspection.AbstractPropertySetter;
import org.eclipse.epsilon.eol.execute.introspection.IPropertyGetter;
import org.eclipse.epsilon.eol.execute.introspection.IPropertySetter;

public class ModelGroup extends Model {
	
	protected ArrayList<IModel> models = new ArrayList<IModel>();
	
	public ModelGroup(ModelRepository repository, String metaModel) throws EolModelNotFoundException {
		this.name = metaModel;
		for (IModel model : repository.getModels()){
			if (model.getAliases().contains(metaModel)){
				models.add(model);
			}
		}
		if (models.size() == 0) throw new EolModelNotFoundException(metaModel);
	}

	public void load() throws EolModelLoadingException {
		for (IModel model : models) {
			model.load();
		}
	}

	public String getMetaModel() {
		return null;
	}

	public Object getEnumerationValue(String enumeration, String label) throws EolEnumerationValueNotFoundException {
		return models.get(0).getEnumerationValue(enumeration,label);
	}

	public Collection getAllOfType(String metaClass) throws EolModelElementTypeNotFoundException {
		ArrayList allOfClass = new ArrayList();
		for (IModel model : models) {
			allOfClass.addAll(model.getAllOfType(metaClass));
		}
		return allOfClass;
	}

	public Collection getAllOfKind(String metaClass) throws EolModelElementTypeNotFoundException {
		ArrayList allOfType = new ArrayList();
		for (IModel model : models) {
			allOfType.addAll(model.getAllOfKind(metaClass));
		}
		return allOfType;
	}
	
	public Collection<Object> allContents() {
		final List<Object> allContents = new ArrayList<Object>();
		for (IModel model : models) {
			allContents.addAll(model.allContents());
		}
		return allContents;
	}

	public Object getTypeOf(Object instance) {
		for (IModel model : models) {
			if (model.owns(instance)) return model.getTypeOf(instance);
		}
		return null;
	}

	public String getTypeNameOf(Object instance) {
		for (IModel model : models) {
			if (model.isModelElement(instance))
				return model.getTypeNameOf(instance);
		}
		
		throw new IllegalArgumentException("No grouped model can contain: " + instance + " (" + instance.getClass().getCanonicalName() + ")");
	}

	public Object createInstance(String metaClass) throws EolModelElementTypeNotFoundException, EolNotInstantiableModelElementTypeException {
		if (models.size() == 1) {
			return models.get(0).createInstance(metaClass);
		}
		else {
			throw new EolNotInstantiableModelElementTypeException(this.name, metaClass) {
				@Override
				public String getReason(){
					return "Cannot create an instance of " + metaClass + " because model group " + name + " has more than one models";
				}
			};
		}
	}

	public Object getElementById(String id) {
		ListIterator li = models.listIterator();
		while (li.hasNext()){
			IModel model =(IModel) li.next();
			Object instance = model.getElementById(id);
			if (instance!=null) return instance;
		}
		return null;
	}

	public String getElementId(Object instance) {
		ListIterator li = models.listIterator();
		while (li.hasNext()){
			IModel model =(IModel) li.next();
			if (model.owns(instance)) return model.getElementId(instance);
		}
		return null;
	}
	
	public void setElementId(Object instance, String newId) {
		ListIterator li = models.listIterator();
		while (li.hasNext()){
			IModel model =(IModel) li.next();
			if (model.owns(instance)) model.setElementId(instance, newId);
		}
	}

	public void deleteElement(Object instance) throws EolRuntimeException{
		ListIterator li = models.listIterator();
		while (li.hasNext()){
			IModel model =(IModel) li.next();
			if (model.owns(instance)) model.deleteElement(instance);
		}
	}
	
	/*
	public String getClassOf(Object instance) {
		ListIterator li = models.listIterator();
		while (li.hasNext()){
			EolModel model =(EolModel) li.next();
			if (model.owns(instance)) return model.getClassOf(instance);
		}
		return null;
	}
*/	
	
	public boolean owns(Object instance) {
		ListIterator li = models.listIterator();
		while (li.hasNext()){
			IModel model =(IModel) li.next();
			if (model.owns(instance)) return true;
		}
		return false;
	}

	public boolean store(String fileName) {
		return false;
	}

	public boolean store() {
		ListIterator li = models.listIterator();
		while (li.hasNext()){
			IModel model =(IModel) li.next();
			model.store();
		}
		return true;
	}

	@Override
	public void dispose() {
		ListIterator li = models.listIterator();
		while (li.hasNext()){
			IModel model =(IModel) li.next();
			model.dispose();
		}
	}

	public boolean isInstantiable(String metaClass) {
		return ((IModel) models.get(0)).isInstantiable(metaClass);
	}

	public boolean hasType(String metaClass) {
		return ((IModel) models.get(0)).hasType(metaClass);
	}

	@Override
	public void load(StringProperties properties, String basePath) throws EolModelLoadingException {
		load();
	}

	public boolean isModelElement(Object instance) {
		ListIterator li = models.listIterator();
		while (li.hasNext()){
			IModel model =(IModel) li.next();
			if (model.isModelElement(instance)) return true;
		}
		return false;
	}
	
	@Override
	public IPropertyGetter getPropertyGetter() {
		return new DelegatingModelElementPropertyGetter();
	}
	
	@Override
	public IPropertySetter getPropertySetter() {
		return new DelegatingModelElementPropertySetter();
	}
	
	public class DelegatingModelElementPropertyGetter extends AbstractPropertyGetter {

		public Object invoke(Object object, String property)
				throws EolRuntimeException {
			for (IModel model : models) {
				if (model.owns(object)) {
					return model.getPropertyGetter().invoke(object, property);
				}
			}
			return null;
		}
		
	}
	
	public class DelegatingModelElementPropertySetter extends AbstractPropertySetter {

		IPropertySetter delegate = null;
		
		@Override
		public void setObject(Object object) {
			super.setObject(object);
			for (IModel model : models) {
				if (model.owns(object)) {
					delegate = model.getPropertySetter();
				}
			}
		}
		
		public void invoke(Object value) throws EolRuntimeException {
			delegate.invoke(value);
		}
	}
}
