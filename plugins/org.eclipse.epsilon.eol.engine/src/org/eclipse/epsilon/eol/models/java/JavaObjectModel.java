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
import java.util.HashSet;

import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.exceptions.models.EolEnumerationValueNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelElementTypeNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.epsilon.eol.exceptions.models.EolNotInstantiableModelElementTypeException;
import org.eclipse.epsilon.eol.models.Model;

public class JavaObjectModel extends Model{
	
	public static void main(String[] args) throws Exception {
		
		try {
			JavaObjectModel model = new JavaObjectModel();
			model.setName("JavaModel");
			model.allContents().add(1);
			model.allContents().add(2);
			model.allContents().add(2);
			model.allContents().add("boo");
			model.getImportedPackages().add("java.lang");
			
			System.err.println(model.getAllOfType("Integer"));
			System.err.println(model.getAllOfKind("Object"));
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		
	}
	
	protected Collection<Object> contents = new HashSet<Object>();
	protected ArrayList<String> importedPackages = new ArrayList<String>();
	
	public Collection allContents() {
		return contents;
	}

	public ArrayList<String> getImportedPackages() {
		return importedPackages;
	}

	public Object createInstance(String type)
			throws EolModelElementTypeNotFoundException,
			EolNotInstantiableModelElementTypeException {
		
		Class clazz = classForName(type);
		
		try {
			Object instance = clazz.newInstance();
			contents.add(instance);
			return instance;
		}
		catch (Exception ex) {
			throw new EolNotInstantiableModelElementTypeException(this.name, type);
		}
		
	}

	public Class classForName(String name) throws EolModelElementTypeNotFoundException {
		
		Class clazz = null;
		
		clazz = getJavaClass(name);
		
		if (clazz == null) {
			for (String p : importedPackages) {
				clazz = getJavaClass(p + "." + name);
				if (clazz != null) return clazz;
			}
		}
		
		throw new EolModelElementTypeNotFoundException(this.name, name);
	}
	
	protected Class getJavaClass(String name) {
		try {
			return Class.forName(name);
		}
		catch (Exception ex) {
			return null;
		}
	}
	
	public void deleteElement(Object instance) throws EolRuntimeException {
		contents.remove(instance);
	}

	public Collection getAllOfKind(String type)
			throws EolModelElementTypeNotFoundException {
		
		Class clazz = classForName(type);
		ArrayList<Object> all = new ArrayList<Object>();
		
		for (Object o : contents) {
			try {
				o.getClass().asSubclass(clazz);
				all.add(o);
			}
			catch (Exception ex) {
				// Do nothing
			}
		}
		
		return all;
		
	}

	public Collection getAllOfType(String type)
			throws EolModelElementTypeNotFoundException {
		
		Class clazz = classForName(type);
		ArrayList<Object> all = new ArrayList<Object>();
		
		for (Object o : contents) {
			if (o.getClass() == clazz) {
				all.add(o);
			}
		}
		
		return all;
		
	}

	public Object getElementById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getElementId(Object instance) {
		return instance.hashCode() + "";
	}

	public Object getEnumerationValue(String enumeration, String label)
			throws EolEnumerationValueNotFoundException {
		
		return null;
	}

	public Object getTypeOf(Object instance) {
		return instance.getClass();
	}

	public boolean hasType(String type) {
		try {
			classForName(type);
			return true;
		} catch (EolModelElementTypeNotFoundException e) {
			return false;
		}
	}

	public boolean isInstantiable(String type) {
		return true;
	}

	public boolean isModelElement(Object instance) {
		return true;
	}

	public void load() throws EolModelLoadingException {
		
	}

	public boolean owns(Object instance) {
		return contents.contains(instance);
	}

	public boolean store(String location) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean store() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void dispose() {
		super.dispose();
		contents.clear();
		importedPackages.clear();
	}

}
