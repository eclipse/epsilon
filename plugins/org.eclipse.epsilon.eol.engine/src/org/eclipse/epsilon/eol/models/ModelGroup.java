/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.eol.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;

import org.eclipse.epsilon.common.util.StringProperties;
import org.eclipse.epsilon.eol.exceptions.EolIllegalPropertyException;
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
	
	protected ArrayList<IModel> models = new ArrayList<>();
	
	public ModelGroup(ModelRepository repository, String metaModel) throws EolModelNotFoundException {
		this.name = metaModel;
		for (IModel model : repository.getModels()){
			if (model.getAliases().contains(metaModel)){
				models.add(model);
			}
		}
		if (models.isEmpty()) throw new EolModelNotFoundException(metaModel);
	}
	
	public ArrayList<IModel> getModels() {
		return models;
	}
	
	@Override
	public void load() throws EolModelLoadingException {
		for (IModel model : models) {
			model.load();
		}
	}

	public String getMetaModel() {
		return null;
	}

	@Override
	public Object getEnumerationValue(String enumeration, String label) throws EolEnumerationValueNotFoundException {
		for (IModel model : models) {
			try {
				return model.getEnumerationValue(enumeration,label);
			}
			catch (Exception ex) {}
		}
		throw new EolEnumerationValueNotFoundException(enumeration, label, this.getName());
	}

	@Override
	public Collection<?> getAllOfType(String metaClass) throws EolModelElementTypeNotFoundException {
		ArrayList<Object> allOfClass = new ArrayList<>();
		for (IModel model : models) {
			if (model.hasType(metaClass)) allOfClass.addAll(model.getAllOfType(metaClass));
		}
		return allOfClass;
	}

	@Override
	public Collection<?> getAllOfKind(String metaClass) throws EolModelElementTypeNotFoundException {
		ArrayList<Object> allOfType = new ArrayList<>();
		for (IModel model : models) {
			if (model.hasType(metaClass)) allOfType.addAll(model.getAllOfKind(metaClass));
		}
		return allOfType;
	}
	
	@Override
	public Collection<Object> allContents() {
		final List<Object> allContents = new ArrayList<>();
		for (IModel model : models) {
			allContents.addAll(model.allContents());
		}
		return allContents;
	}

	@Override
	public Object getTypeOf(Object instance) {
		for (IModel model : models) {
			if (model.owns(instance)) return model.getTypeOf(instance);
		}
		return null;
	}

	@Override
	public String getTypeNameOf(Object instance) {
		for (IModel model : models) {
			if (model.isModelElement(instance))
				return model.getTypeNameOf(instance);
		}
		
		throw new IllegalArgumentException("No grouped model can contain: " + instance + " (" + instance.getClass().getCanonicalName() + ")");
	}
	
	@SuppressWarnings("serial")
	@Override
	public Object createInstance(String metaClass, Collection<Object> parameters)
			throws EolModelElementTypeNotFoundException,
			EolNotInstantiableModelElementTypeException {
		if (models.size() == 1) {
			return models.get(0).createInstance(metaClass, parameters);
		}
		else {
			throw new EolNotInstantiableModelElementTypeException(this.name, metaClass) {
				@Override
				public String getReason(){
					return "Cannot create an instance of " + typeName + " because model group " + name + " has more than one models";
				}
			};
		}
	}

	@Override
	@SuppressWarnings("serial")
	public Object createInstance(String metaClass) throws EolModelElementTypeNotFoundException, EolNotInstantiableModelElementTypeException {
		if (models.size() == 1) {
			return models.get(0).createInstance(metaClass);
		}
		else {
			throw new EolNotInstantiableModelElementTypeException(this.name, metaClass) {
				@Override
				public String getReason(){
					return "Cannot create an instance of " + typeName + " because model group " + name + " has more than one models";
				}
			};
		}
	}

	@Override
	public Object getElementById(String id) {
		ListIterator<IModel> li = models.listIterator();
		while (li.hasNext()){
			IModel model = li.next();
			Object instance = model.getElementById(id);
			if (instance!=null) return instance;
		}
		return null;
	}

	@Override
	public String getElementId(Object instance) {
		ListIterator<IModel> li = models.listIterator();
		while (li.hasNext()){
			IModel model = li.next();
			if (model.owns(instance)) return model.getElementId(instance);
		}
		return null;
	}
	
	@Override
	public void setElementId(Object instance, String newId) {
		ListIterator<IModel> li = models.listIterator();
		while (li.hasNext()){
			IModel model = li.next();
			if (model.owns(instance)) model.setElementId(instance, newId);
		}
	}

	@Override
	public void deleteElement(Object instance) throws EolRuntimeException{
		ListIterator<IModel> li = models.listIterator();
		while (li.hasNext()){
			IModel model = li.next();
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
	
	@Override
	public boolean owns(Object instance) {
		for (IModel model : models) {
			if (model.owns(instance)) return true;
		}
		return false;
	}

	
	@Override
	public boolean knowsAboutProperty(Object instance, String property) {
		for (IModel model : models) {
			if (model.knowsAboutProperty(instance, property)) return true;
		}
		return false;
	}
	
	@Override
	public boolean store(String fileName) {
		return false;
	}

	@Override
	public boolean store() {
		for (IModel model : models) {
			model.store();
		}
		return true;
	}

	@Override
	public void dispose() {
		for (IModel model : models) {
			model.dispose();
		}
	}

	@Override
	public boolean isInstantiable(String metaClass) {
		for (IModel model : models) {
			if (model.hasType(metaClass) && model.isInstantiable(metaClass)) return true;
		}
		return false;
	}

	@Override
	public boolean hasType(String metaClass) {
		for (IModel model : models) {
			if (model.hasType(metaClass)) return true;
		}
		return false;
	}

	@Override
	public void load(StringProperties properties, IRelativePathResolver resolver) throws EolModelLoadingException {
		load();
	}

	@Override
	public boolean isModelElement(Object instance) {
		for (IModel model : models) {
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

		@Override
		public Object invoke(Object object, String property)
				throws EolRuntimeException {
			
			for (IModel model : models) {
				if (model.knowsAboutProperty(object, property)) {
					return model.getPropertyGetter().invoke(object, property);
				}
			}
			throw new EolIllegalPropertyException(object, property, ast, context);
		}
		
	}
	
	public class DelegatingModelElementPropertySetter extends AbstractPropertySetter {
		
		@Override
		public void invoke(Object value) throws EolRuntimeException {
			
			for (IModel model : models) {
				if (model.knowsAboutProperty(object, property)) {
					IPropertySetter delegate = null;
					delegate = model.getPropertySetter();
					delegate.setObject(object);
					delegate.setProperty(property);
					delegate.setContext(context);
					delegate.setAst(ast);
					delegate.invoke(value);
					return;
				}
			}
			
			throw new EolIllegalPropertyException(object, property, ast, context);

		}
	}
}
