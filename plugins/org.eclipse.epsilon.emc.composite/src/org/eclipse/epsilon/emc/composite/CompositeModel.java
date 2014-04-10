/*******************************************************************************
 * Copyright (c) 2012 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.emc.composite;
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

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

import org.eclipse.epsilon.ecl.trace.Match;
import org.eclipse.epsilon.ecl.trace.MatchTrace;
import org.eclipse.epsilon.eol.exceptions.EolIllegalPropertyException;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.exceptions.models.EolEnumerationValueNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelElementTypeNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.epsilon.eol.exceptions.models.EolNotInstantiableModelElementTypeException;
import org.eclipse.epsilon.eol.execute.introspection.AbstractPropertyGetter;
import org.eclipse.epsilon.eol.execute.introspection.AbstractPropertySetter;
import org.eclipse.epsilon.eol.execute.introspection.IPropertyGetter;
import org.eclipse.epsilon.eol.execute.introspection.IPropertySetter;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.eol.models.Model;

public class CompositeModel extends Model {
	
	protected Collection<IModel> models = new ArrayList<IModel>();
	protected ArrayList<ArrayList<Object>> equivalents = new ArrayList<ArrayList<Object>>();
	
	public CompositeModel(Collection<IModel> models) {
		this.models = models;
	}
	
	public CompositeModel(String name, Collection<IModel> models) {
		this(models);
		setName(name);
	}
	
	public CompositeModel(Collection<IModel> models, MatchTrace matchTrace) {
		this.models = models;
		findEquivalents(matchTrace.getReduced());
	}
	
	protected void findEquivalents(MatchTrace matchTrace) {
		for (Match m : matchTrace.getMatches()) {
			boolean existing = false;
			for (ArrayList<Object> eq : equivalents) {
				if (eq.contains(m.getLeft()) || eq.contains(m.getRight())) {
					existing = true;
					if (!eq.contains(m.getLeft())) eq.add(m.getLeft());
					if (!eq.contains(m.getRight())) eq.add(m.getRight());
 				}
			}
			if (!existing) {
				ArrayList<Object> eq = new ArrayList<Object>();
				eq.add(m.getLeft());
				eq.add(m.getRight());
				equivalents.add(eq);
			}
 		}
	}
	
	public Collection<Object> getEquivalents(Object instance) {
		Collection<Object> equivalents = new ArrayList<Object>();
		for (ArrayList<Object> eq : this.equivalents) {
			if (eq.contains(instance)) {
				equivalents.addAll(eq);
			}
		}
		
		return equivalents;
	}
	
	public void removeDuplicates(Collection<Object> original, Collection<Object> equivalents) {
		
		for (Object eq : equivalents) {
			if (original.contains(eq)) {
				for (Object rem : equivalents) {
					if (rem != eq) original.remove(rem);
				}
			}
		}
	}
	
	protected void removeDuplicates(Collection<Object> original) {
		for (ArrayList<Object> eq : equivalents) {
			removeDuplicates(original, eq);
		}
	}
	
	public Collection<?> allContents() {
		
		Collection<Object> all = new ArrayList<Object>();
		
		for (IModel m : models) {
			all.addAll(m.allContents());
		}
		
		removeDuplicates(all);
		
		return all;
	}

	public Object createInstance(String type)
			throws EolModelElementTypeNotFoundException,
			EolNotInstantiableModelElementTypeException {
		
		for (IModel m : models) {
			if (m.hasType(type))
				return m.createInstance(type);
		}
		
		throw new EolNotInstantiableModelElementTypeException(this.name, type);
	}

	public void deleteElement(Object instance) throws EolRuntimeException {
		for (IModel m : models) {
			if (m.owns(instance)) m.deleteElement(instance);
		}
	}

	public Collection<Object> getAllOfKind(String type)
			throws EolModelElementTypeNotFoundException {

		Collection<Object> all = new ArrayList<Object>();
		
		for (IModel m : models) {
			if (m.hasType(type))
				all.addAll(m.getAllOfKind(type));
		}
		
		removeDuplicates(all);
		
		return all;
	}

	public Collection<Object> getAllOfType(String type)
			throws EolModelElementTypeNotFoundException {


		Collection<Object> all = new ArrayList<Object>();
		
		for (IModel m : models) {
			if (m.hasType(type))
				all.addAll(m.getAllOfType(type));
		}
		
		removeDuplicates(all);
		
		return all;
	}

	public Object getElementById(String id) {
		for (IModel m : models) {
			Object element = null;
			element = m.getElementById(id);
			if (element != null) return element;
		}
		return null;
	}

	public String getElementId(Object instance) {
		for (IModel m : models) {
			if (m.owns(instance)) return m.getElementId(instance);
		}
		return null;
	}
	
	public void setElementId(Object instance, String newId) {
		for (IModel m : models) {
			if (m.owns(instance)) m.setElementId(instance, newId);
		}
	}

	public Object getEnumerationValue(String enumeration, String label)
			throws EolEnumerationValueNotFoundException {
		if (models.size() > 0) 
			return models.iterator().next().getEnumerationValue(enumeration, label);
		else return null;
	}

	public Object getTypeOf(Object instance) {
		for (IModel m : models) {
			if (m.owns(instance)) return m.getTypeOf(instance);
		}
		return false;
	}
	
	public String getTypeNameOf(Object instance) {
		for (IModel m : models) {
			if (m.isModelElement(instance)) return m.getTypeNameOf(instance);
		}

		throw new IllegalArgumentException("Cannot be contained by this model: " + instance);
	}

	public boolean hasType(String type) {
		for (IModel m : models) {
			if (m.hasType(type)) return true;
		}
		return false;
	}

	public boolean isInstantiable(String type) {
		return false;
	}

	public boolean isModelElement(Object instance) {
		for (IModel m : models) {
			if (m.isModelElement(instance)) return true;
		}
		return false;
	}

	public void load() throws EolModelLoadingException {
		
	}

	public boolean owns(Object instance) {
		for (IModel m : models) {
			if (m.owns(instance)) return true;
		}
		return false;
	}

	@Override
	public void dispose() {
		for (IModel m : models) {
			m.dispose();
		}
		
		super.dispose();
	}
	
	public boolean store(String location) {
		for (IModel m : models) {
			if (!m.store(location)) return false;
		}
		return true;
	}

	public boolean store() {
		for (IModel m : models) {
			if (!m.store()) return false;
		}
		return true;
	}

	@Override
	public IPropertyGetter getPropertyGetter() {
		return new CompositePropertyGetter();
	}
	
	class CompositePropertyGetter extends AbstractPropertyGetter {

		public Object invoke(Object object, String property)
				throws EolRuntimeException {
			
			HashMap<Object, IPropertyGetter> getters = new HashMap<Object, IPropertyGetter>();
			Collection<Object> equivalents = getEquivalents(object);
			
			if (equivalents.isEmpty()) equivalents.add(object);

			for (Object equivalent : equivalents) {
				
				for (IModel model : models) {
					if (model.owns(equivalent)) {
						getters.put(equivalent, model.getPropertyGetter());
					}
				}
			}
			
			Collection<Object> results = new HashSet<Object>();
			
			for (Object eq : equivalents) {
				
				Object result = getters.get(eq).invoke(eq, property);
				
				
				if (result instanceof Collection) {
					results.addAll((Collection<?>) result);
				}
				else {
					return result;
				}
			}
			
			removeDuplicates(results);
			return results;
		}
		
	}
	
	@Override
	public IPropertySetter getPropertySetter() {
		return new CompositePropertySetter();
	}
	
	
	private class CompositePropertySetter extends AbstractPropertySetter {

		public void invoke(Object value) throws EolRuntimeException {
			getDelegate().invoke(value);
		}
		
		
		private IPropertySetter getDelegate() throws EolIllegalPropertyException {
			for (IModel model : models) {
				if (model.owns(object)) {
					final IPropertySetter delegate = model.getPropertySetter();
					delegate.setAst(ast);
					delegate.setContext(context);
					delegate.setObject(object);
					delegate.setProperty(property);
					return delegate;
				}
			}
			
			throw new EolIllegalPropertyException(object, property, ast, context);
		}
		
	}
}
