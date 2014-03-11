package org.eclipse.epsilon.emc.muddle;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.exceptions.models.EolEnumerationValueNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelElementTypeNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.epsilon.eol.exceptions.models.EolNotInstantiableModelElementTypeException;
import org.eclipse.epsilon.eol.execute.introspection.IPropertyGetter;
import org.eclipse.epsilon.eol.execute.introspection.IPropertySetter;
import org.eclipse.epsilon.eol.models.Model;

public class MuddleModel extends Model {

	
	public static void main(String[] args) throws Exception {
		
		EPackage ePackage = EcoreFactory.eINSTANCE.createEPackage();
		ePackage.setName("m2");
		ePackage.setNsURI(ePackage.getName());
		ePackage.setNsPrefix(ePackage.getName());
		EClass eClass = EcoreFactory.eINSTANCE.createEClass();
		eClass.setName("C1");
		EAttribute eAttribute = EcoreFactory.eINSTANCE.createEAttribute();
		eAttribute.setName("a1");
		eAttribute.setEType(EcorePackage.eINSTANCE.getEClassifier("EString"));
		eClass.getEStructuralFeatures().add(eAttribute);
		ePackage.getEClassifiers().add(eClass);
		
		
		/*
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.createResource(URI.createURI("foo"));
		*/
		
		EObject object = ePackage.getEFactoryInstance().create(eClass);
		//object.eSet(eClass.getEStructuralFeature("a1"), "v1");
		System.out.println(object.eGet(eClass.getEStructuralFeature("a1")));
		
		EAttribute eAttribute2 = EcoreFactory.eINSTANCE.createEAttribute();
		eAttribute2.setName("a2");
		eAttribute2.setEType(EcorePackage.eINSTANCE.getEClassifier("EString"));
		eClass.getEStructuralFeatures().add(eAttribute2);		
		
		object.eSet(eClass.getEStructuralFeature("a2"), "v2");
		
		
	}
	
	protected Muddle muddle;
	protected Set<Feature> unusedFeatures;
	
	@Override
	public Collection<?> allContents() {
		return muddle.getElements();
	}
	
	public Set<Feature> getUnusedFeatures() {
		if (unusedFeatures == null && muddle != null) {
			unusedFeatures = new HashSet<Feature>();
			for (Type type : muddle.getTypes()) {
	               if (type instanceof MuddleElementType) {
	            	   unusedFeatures.addAll(((MuddleElementType) type).getFeatures());
	               }
	          }
		}
		return unusedFeatures;
	}
	
	@Override
	public Object createInstance(String t)
			throws EolModelElementTypeNotFoundException,
			EolNotInstantiableModelElementTypeException {
		
		MuddleElementType type = muddleElementTypeForName(t);
		
		if (type == null) {
			type = MuddleFactory.eINSTANCE.createMuddleElementType();
			type.setName(t);
			muddle.getTypes().add(type);
		}
		
		MuddleElement element = MuddleFactory.eINSTANCE.createMuddleElement();
		element.setType(type);
		muddle.getElements().add(element);
		
		return element;
	}

	@Override
	public void deleteElement(Object o) throws EolRuntimeException {
		muddle.getElements().remove(o);
	}

	@Override
	public Collection<?> getAllOfKind(String type)
			throws EolModelElementTypeNotFoundException {
		
		ArrayList<MuddleElement> elements = new ArrayList<MuddleElement>();
		for (MuddleElementType elementType : getAllSubTypes(muddleElementTypeForName(type))) {
			elements.addAll(elementType.getInstances());
		}
		return elements;
	}
	
	protected Set<MuddleElementType> getAllSubTypes(MuddleElementType elementType) {
		HashSet<MuddleElementType> allSubTypes = new HashSet<MuddleElementType>();
		collectAllSubTypes(elementType, allSubTypes);
		return allSubTypes;
	}
	
	protected void collectAllSubTypes(MuddleElementType elementType, Set<MuddleElementType> allSubTypes) {
		if (!allSubTypes.contains(elementType)) {
			allSubTypes.add(elementType);
			for (MuddleElementType subType : elementType.getSubTypes()) {
				collectAllSubTypes(subType, allSubTypes);
			}
		}
	}
	
	@Override
	public Collection<?> getAllOfType(String type)
			throws EolModelElementTypeNotFoundException {
		return muddleElementTypeForName(type).getInstances();
	}

	@Override
	public Object getElementById(String id) {
		for (MuddleElement element : muddle.getElements()) {
			if (element.getId().equals(id)) return element;
		}
		return null;
	}

	@Override
	public String getElementId(Object o) {
		return ((MuddleElement) o).getId();
	}

	@Override
	public Object getEnumerationValue(String arg0, String arg1)
			throws EolEnumerationValueNotFoundException {
		return null;
	}

	@Override
	public String getTypeNameOf(Object o) {
		return ((MuddleElement) o).getType().getName();
	}

	@Override
	public boolean hasType(String type) {
		return muddleElementTypeForName(type) != null;
	}

	@Override
	public boolean isInstantiable(String type) {
		return true;
	}

	@Override
	public boolean owns(Object o) {
		return muddle.getElements().contains(o);
	}

	@Override
	public void setElementId(Object o, String id) {
		((MuddleElement) o).setId(id);
	}

	@Override
	public boolean store() {
		return false;
	}

	@Override
	public boolean store(String arg0) {
		return false;
	}
	
	protected MuddleElementType muddleElementTypeForName(String name) {
		for (Type type : muddle.getTypes()) {
			if (type instanceof MuddleElementType && type.getName().equals(name)) {
				return (MuddleElementType) type;
			}
		}
		return null;
	}
	
	public void setMuddle(Muddle muddle) {
		this.muddle = muddle;
	}
	
	public Muddle getMuddle() {
		return muddle;
	}
	
	protected MuddleModelPropertyGetter propertyGetter = new MuddleModelPropertyGetter(this);
	protected MuddleModelPropertySetter propertySetter = new MuddleModelPropertySetter(this);
	
	@Override
	public IPropertyGetter getPropertyGetter() {
		return propertyGetter;
	}

	@Override
	public IPropertySetter getPropertySetter() {
		return propertySetter;
	}
	
	@Override
	public void load() throws EolModelLoadingException {
		
	}
	
}
