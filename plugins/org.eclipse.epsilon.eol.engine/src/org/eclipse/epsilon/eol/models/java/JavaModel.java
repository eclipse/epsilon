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
package org.eclipse.epsilon.eol.models.java;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.exceptions.models.EolEnumerationValueNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelElementTypeNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.epsilon.eol.exceptions.models.EolNotInstantiableModelElementTypeException;
import org.eclipse.epsilon.eol.models.Model;

public class JavaModel extends Model {
	

	protected Collection<Object> objects;
	protected Collection<Class> classes;
	
	public JavaModel(Collection<Object> objects, Collection<Class> classes) {
		this.objects = objects;
		this.classes = classes;
	}
	
	public Collection allContents() {
		return objects;
	}
	
	public Class classForName(String name) {
		for (Class c : classes) {
			if (c.getSimpleName().equals(name) || c.getCanonicalName().replaceAll("::", ".").equals(name)) {
				return c;
			}
		}
		return null;
	}
	
	public Object createInstance(String type)
			throws EolModelElementTypeNotFoundException,
			EolNotInstantiableModelElementTypeException {
		Class c = classForName(type);
		if (c!=null) {
			if (isInstantiable(c)) {
				try {
					Object newInstance = c.newInstance();
					objects.add(newInstance);
					return newInstance;
				} catch (Exception e) {
					throw new EolNotInstantiableModelElementTypeException(this.getName(), type);
				}
			}
			else {
				throw new EolNotInstantiableModelElementTypeException(this.getName(), type);
			}
		}
		throw new EolModelElementTypeNotFoundException(this.getName(), type);
	}
	
	public boolean isInstantiable(Class c) {
		return !c.isInterface();
	}
	
	
	public void deleteElement(Object instance) throws EolRuntimeException {
		objects.remove(instance);
	}

	
	public Collection getAllOfKind(String type)
			throws EolModelElementTypeNotFoundException {
		Class c = classForName(type);
		Collection<Object> allOfKind = new ArrayList<Object>();
		if (c != null) {
			for (Object o : objects) {
				if (c.isInstance(o)) {
					allOfKind.add(o);
				}
			}
			return allOfKind;
		}
		else {
			throw new EolModelElementTypeNotFoundException(this.getName(), type);
		}
	}

	
	public Collection getAllOfType(String type)
			throws EolModelElementTypeNotFoundException {
		Class c = classForName(type);
		Collection<Object> allOfType = new ArrayList<Object>();
		if (c != null) {
			for (Object o : objects) {
				if (o.getClass() == c) {
					allOfType.add(o);
				}
			}
			return allOfType;
		}
		else {
			throw new EolModelElementTypeNotFoundException(this.getName(), type);
		}
	}

	
	public Object getElementById(String id) {
		int hashCode = 0;
		try {
			hashCode = new Integer(id).intValue();
			for (Object o : objects) {
				if (o.hashCode() == hashCode) {
					return o;
				}
			}
			return null;
		}
		catch (Exception ex) {
			return null;
		}
	}

	
	public String getElementId(Object instance) {
		return instance.hashCode() + "";
	}

	
	public Object getEnumerationValue(String enumeration, String label)
			throws EolEnumerationValueNotFoundException {
		throw new UnsupportedOperationException();
	}

	
	public Object getTypeOf(Object instance) {
		return instance.getClass();
	}

	
	public boolean hasType(String type) {
		return classForName(type) != null;
	}

	
	public boolean isInstantiable(String type) {
		return isInstantiable(classForName(type));
	}

	
	public boolean isModelElement(Object instance) {
		return true;
	}

	
	public void load() throws EolModelLoadingException {
		
	}

	
	public boolean owns(Object instance) {
		return objects.contains(instance);
	}

	
	public boolean store(String location) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public boolean store() {
		// TODO Auto-generated method stub
		return false;
	}

	
	public void dispose() {
		objects.clear();
		classes.clear();
		objects = null;
		classes = null;
	}

}
