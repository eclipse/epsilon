package org.eclipse.epsilon.eol.compile.m3;

import java.util.ArrayList;
import java.util.List;

public class MetaClass extends MetaType {
	
	protected List<MetaClass> superTypes = new ArrayList<>();
	protected List<StructuralFeature> structuralFeatures = new ArrayList<>();
	protected boolean isAbstract;
	
	public List<MetaClass> getSuperTypes() {
		return superTypes;
	}
	
	public List<StructuralFeature> getStructuralFeatures() {
		return structuralFeatures;
	}
	
	public List<StructuralFeature> getAllStructuralFeatures() {
		List<StructuralFeature> allStructuralFeatures = new ArrayList<>();
		for (MetaClass superType : superTypes) {
			allStructuralFeatures.addAll(superType.getAllStructuralFeatures());
		}
		allStructuralFeatures.addAll(getStructuralFeatures());
		return allStructuralFeatures;
	}
	
	public boolean isAbstract() {
		return isAbstract;
	}
	
	public void setAbstract(boolean isAbstract) {
		this.isAbstract = isAbstract;
	}
	
	public StructuralFeature getStructuralFeature(String name) {
		for (StructuralFeature structuralFeature : getAllStructuralFeatures()) {
			if (structuralFeature.getName().equals(name)) {
				return structuralFeature;
			}
		}
		return null;
	}
	
}
