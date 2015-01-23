package org.eclipse.epsilon.eol.models.m3;

import java.util.ArrayList;
import java.util.List;

public class MetaClass {
	
	protected List<MetaClass> superTypes = new ArrayList<MetaClass>();
	protected List<StructuralFeature> structuralFeatures = new ArrayList<StructuralFeature>();
	protected boolean isAbstract;
	
	public List<MetaClass> getSuperTypes() {
		return superTypes;
	}
	
	public List<StructuralFeature> getStructuralFeatures() {
		return structuralFeatures;
	}
	
	public List<StructuralFeature> getAllStructuralFeatures() {
		List<StructuralFeature> allStructuralFeatures = new ArrayList<StructuralFeature>();
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
	
}
