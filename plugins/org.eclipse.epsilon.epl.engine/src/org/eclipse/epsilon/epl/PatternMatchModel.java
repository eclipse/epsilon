package org.eclipse.epsilon.epl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.exceptions.models.EolEnumerationValueNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelElementTypeNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.epsilon.eol.exceptions.models.EolNotInstantiableModelElementTypeException;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.execute.introspection.IPropertyGetter;
import org.eclipse.epsilon.eol.execute.introspection.IPropertySetter;
import org.eclipse.epsilon.eol.execute.operations.contributors.StringOperationContributor;
import org.eclipse.epsilon.eol.models.Model;

public class PatternMatchModel extends Model{
	
	protected HashMap<String, List<PatternMatch>> matchMap = new HashMap<String, List<PatternMatch>>();
	protected HashSet<PatternMatch> matches = new HashSet<PatternMatch>();
	protected PatternMatchPropertyGetter propertyGetter;
	protected PatternMatchPropertySetter propertySetter = new PatternMatchPropertySetter();
	protected HashMap<String, HashSet<Object>> componentMap = new HashMap<String, HashSet<Object>>();
	
	public void addMatch(PatternMatch match) {
		String patternName = match.getPattern().getName();
		List<PatternMatch> matchMapMatches = matchMap.get(patternName);
		matchMapMatches.add(match);
		matchMap.put(patternName, matchMapMatches);
		
		matches.add(match);
		
		StringOperationContributor stringOps = new StringOperationContributor();
		for (String componentName : match.getRoleBindings().keySet()) {
			stringOps.setTarget(componentName);
			HashSet<Object> values = componentMap.get(patternName + stringOps.firstToUpperCase());
			if (values!=null) values.add(match.getRoleBindings().get(componentName)); 
		}
	}
	
	protected HashMap<String, HashSet<Object>> getComponentMap() {
		return componentMap;
	}
	
	public void setPatterns(List<Pattern> patterns) {
		
		StringOperationContributor stringOps = new StringOperationContributor();
		
		for (Pattern pattern : patterns) {
			matchMap.put(pattern.getName(), new ArrayList<PatternMatch>());
			for (Role role : pattern.getRoles()) {
				if (role.isNegative()) continue;
				for (String name : role.getNames()) {
					stringOps.setTarget(name);
					String componentName = pattern.getName() +
							stringOps.firstToUpperCase();
					componentMap.put(componentName, new HashSet<Object>());
				}
			}
		}
	}
	
	/*
	@Override
	public boolean knowsAboutProperty(Object instance, String property) {
		return property.startsWith("is") && property.length() > 4
			&& componentMap.get(property.substring(2)) != null;
	}*/
	
	@Override
	public void load() throws EolModelLoadingException {

	}

	@Override
	public Object getEnumerationValue(String enumeration, String label)
			throws EolEnumerationValueNotFoundException {
		
		return null;
	}

	@Override
	public Collection<?> allContents() {
		return getMatches();
	}
	
	public HashSet<PatternMatch> getMatches() {
		return matches;
	}
	
	@Override
	public Collection<?> getAllOfType(String type)
			throws EolModelElementTypeNotFoundException {
		if (matchMap.containsKey(type))
			return matchMap.get(type);
		else 
			return componentMap.get(type);
	}

	@Override
	public Collection<?> getAllOfKind(String type)
			throws EolModelElementTypeNotFoundException {
		return getAllOfType(type);
	}

	@Override
	public Object getTypeOf(Object instance) {
		return PatternMatch.class;
	}

	@Override
	public String getTypeNameOf(Object instance) {
		if (instance instanceof PatternMatch) {
			return ((PatternMatch) instance).getPattern().getName();
		}
		return null;
	}

	@Override
	public Object createInstance(String type)
			throws EolModelElementTypeNotFoundException,
			EolNotInstantiableModelElementTypeException {
		throw new EolNotInstantiableModelElementTypeException(this.name, type);
	}

	@Override
	public Object getElementById(String id) {
		return null;
	}

	@Override
	public String getElementId(Object instance) {
		return null;
	}

	@Override
	public void setElementId(Object instance, String newId) {
		
	}

	@Override
	public void deleteElement(Object instance) throws EolRuntimeException {
		
	}

	@Override
	public boolean owns(Object instance) {
		return matches.contains(instance);
	}

	@Override
	public boolean isInstantiable(String type) {
		return false;
	}

	@Override
	public boolean isModelElement(Object instance) {
		return owns(instance);
	}

	@Override
	public boolean hasType(String type) {
		return matchMap.containsKey(type) ||
			componentMap.containsKey(type);
	}

	@Override
	public boolean store(String location) {
		return false;
	}

	@Override
	public boolean store() {
		return false;
	}
	
	@Override
	public IPropertyGetter getPropertyGetter() {
		if (propertyGetter == null) {
			propertyGetter = new PatternMatchPropertyGetter();
		}
		return propertyGetter;
	}
	
	@Override
	public IPropertySetter getPropertySetter() {
		return propertySetter;
	}

}
