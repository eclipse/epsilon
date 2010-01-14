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
import java.util.LinkedList;

import org.eclipse.epsilon.commons.profiling.Profiler;
import org.eclipse.epsilon.commons.profiling.ProfilerTarget;
import org.eclipse.epsilon.ecl.trace.Match;
import org.eclipse.epsilon.ecl.trace.MatchTrace;
import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.exceptions.models.EolEnumerationValueNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelElementTypeNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.epsilon.eol.exceptions.models.EolNotInstantiableModelElementTypeException;
import org.eclipse.epsilon.eol.execute.introspection.AbstractPropertyGetter;
import org.eclipse.epsilon.eol.execute.introspection.IPropertyGetter;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.eol.models.Model;
import org.eclipse.epsilon.eol.models.java.JavaObjectModel;
import org.eclipse.epsilon.eol.types.EolCollection;

public class CompositeModel extends Model {
	
	
	public static void main(String[] args) throws Exception {
		
		Tree t1 = new Tree("lr1");
		t1.createChild("l1").createChildren("l2", "l3", "l4");
		t1.createChild("l5").createChildren("l6", "l7");
		
		Tree t2 = new Tree("rr2");
		t2.createChild("r1").createChildren("r2", "r3", "r4");
		t2.createChild("r5").createChildren("r6", "r8");
		
		JavaObjectModel j1 = new JavaObjectModel();
		j1.setName("j1");
		j1.getImportedPackages().add("org.eclipse.epsilon.emc.emf.composite");
		j1.allContents().add(t1);
		j1.allContents().addAll(t1.getAllChildren());
		
		JavaObjectModel j2 = new JavaObjectModel();
		j2.setName("j2");
		j2.getImportedPackages().add("org.eclipse.epsilon.emc.composite");
		j2.allContents().add(t2);
		j2.allContents().addAll(t2.getAllChildren());
		
		MatchTrace trace = new MatchTrace();
		//System.err.println("JAVA" + t2.getChild("r5").getChildren());
		trace.add(t1.getChild("l5"), t2.getChild("r5"), true, null);
		trace.add(t1.getChild("l6"), t2.getChild("r6"), true, null);
		trace.add(t1.getChild("l1"), t2.getChild("r1"), true, null);
		trace.add(t1.getChild("l2"), t2.getChild("r2"), true, null);
		
		ArrayList<IModel> models = new ArrayList<IModel>();
		models.add(j1);
		models.add(j2);
		
		CompositeModel model = new CompositeModel(models, trace);
		model.setName("Composite");
		
		ProfilerTarget t = Profiler.INSTANCE.start("EOL");
		EolModule module = new EolModule();
		module.parse("Tree.all.println().selectOne(t|t.label='l1').println().children.collect(c|c.label).println();");
		module.getContext().getModelRepository().addModel(model);
		module.execute();
		Profiler.INSTANCE.stop();
		System.err.println(t.getWorked(true));
	}

	
	
	protected Collection<IModel> models = new ArrayList<IModel>();
	protected ArrayList<ArrayList<Object>> equivalents = new ArrayList<ArrayList<Object>>();
	
	public CompositeModel(Collection<IModel> models) {
		this.models = models;
	}
	
	public CompositeModel(Collection<IModel> models, MatchTrace matchTrace) {
		this.models = models;
		findEquivalents(matchTrace.getReduced());
	}
	
	protected void findEquivalents(MatchTrace matchTrace) {
		for (Match m : matchTrace.getMatches()) {
			boolean existing = false;
			for (ArrayList eq : equivalents) {
				if (eq.contains(m.getLeft()) || eq.contains(m.getRight())) {
					existing = true;
					if (!eq.contains(m.getLeft())) eq.add(m.getLeft());
					if (!eq.contains(m.getRight())) eq.add(m.getRight());
 				}
			}
			if (!existing) {
				ArrayList eq = new ArrayList();
				eq.add(m.getLeft());
				eq.add(m.getRight());
				equivalents.add(eq);
			}
 		}
	}
	
	public Collection getEquivalents(Object instance) {
		Collection equivalents = new ArrayList<Object>();
		for (ArrayList<Object> eq : this.equivalents) {
			if (eq.contains(instance)) {
				equivalents.addAll(eq);
			}
		}
		
		return equivalents;
	}
	
	public void removeDuplicates(Collection original, Collection equivalents) {
		
		for (Object eq : equivalents) {
			if (original.contains(eq)) {
				for (Object rem : equivalents) {
					if (rem != eq) original.remove(rem);
				}
			}
		}
	}
	
	protected void removeDuplicates(Collection original) {
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
		
		throw new EolNotInstantiableModelElementTypeException(this.name, type);
		
	}

	public void deleteElement(Object instance) throws EolRuntimeException {
		for (IModel m : models) {
			if (m.owns(instance)) m.deleteElement(instance);
		}
	}

	public Collection getAllOfKind(String type)
			throws EolModelElementTypeNotFoundException {

		Collection all = new ArrayList<Object>();
		
		for (IModel m : models) {
			if (m.hasType(type))
				all.addAll(m.getAllOfKind(type));
		}
		
		removeDuplicates(all);
		
		return all;
	}

	public Collection getAllOfType(String type)
			throws EolModelElementTypeNotFoundException {


		Collection all = new ArrayList<Object>();
		
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
	
	public Collection<String> getPropertiesOf(String type) throws EolModelElementTypeNotFoundException {		
		for (IModel m : models) {
			if (m.hasType(type))
				return m.getPropertiesOf(type);
		}

		throw new IllegalArgumentException("Not an element of this model: " + type);
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

	public boolean store(String location) {
		return false;
	}

	public boolean store() {
		return false;
	}

	@Override
	public IPropertyGetter getPropertyGetter() {
		return new CompositePropertyGetter();
	}
	
	class CompositePropertyGetter extends AbstractPropertyGetter {

		public Object invoke(Object object, String property)
				throws EolRuntimeException {
			
			HashMap<Object, IPropertyGetter> getters = new HashMap<Object, IPropertyGetter>();
			Collection equivalents = getEquivalents(object);
			
			if (equivalents.isEmpty()) equivalents.add(object);

			for (Object equivalent : equivalents) {
				
				for (IModel model : models) {
					if (model.owns(equivalent)) {
						//System.err.println("MODEL : " + model.getName() + " -> " + equivalent);
						getters.put(equivalent, model.getPropertyGetter());
					}
				}
			}
			
			Collection<Object> results = new HashSet<Object>();
			
			//System.err.println(getters.keySet());
			for (Object eq : equivalents) {
				
				Object result = getters.get(eq).invoke(eq, property);
				
				//System.err.println("Result = " + result);
				
				if (result instanceof Collection || result instanceof EolCollection) {
					//System.err.println("Adding " + result);
					if (result instanceof EolCollection) result = ((EolCollection) result).getStorage();
					results.addAll((Collection) result);
				}
				else {
					//System.err.println("Returning " + result);
					return result;
				}
			}
			
			removeDuplicates(results);
			return results;
		}
		
	}
	
}
