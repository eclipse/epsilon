package org.eclipse.epsilon.emc.emf;

import java.util.HashMap;

import org.eclipse.emf.common.notify.impl.BasicNotifierImpl.EAdapterList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.epsilon.common.util.StringProperties;
import org.eclipse.epsilon.eol.compile.m3.Attribute;
import org.eclipse.epsilon.eol.compile.m3.MetaClass;
import org.eclipse.epsilon.eol.compile.m3.Metamodel;
import org.eclipse.epsilon.eol.compile.m3.Reference;
import org.eclipse.epsilon.eol.compile.m3.StructuralFeature;
import org.eclipse.epsilon.eol.models.IRelativePathResolver;

public class EmfModelMetamodel extends Metamodel {
	
	
	
	public EmfModelMetamodel(StringProperties properties, IRelativePathResolver resolver) {
		
		HashMap<EClass, MetaClass> eClassMetaClassMap = new HashMap<EClass, MetaClass>();
		String nsuri = properties.getProperty("nsuri");
		if (nsuri == null) {
			getErrors().add("Required property nsuri not found");
		}
		else {
			EPackage ePackage = EPackage.Registry.INSTANCE.getEPackage(nsuri);
			if (ePackage == null) {
				getErrors().add("EPackage with nsURI " + nsuri + " is not available in EPackage.Registry.INSTANCE");
			}
			else {
				for (EClassifier eClassifier : ePackage.getEClassifiers()) {
					if (eClassifier instanceof EClass) {
						MetaClass metaClass = new MetaClass();
						metaClass.setName(eClassifier.getName());
						eClassMetaClassMap.put((EClass) eClassifier, metaClass);
						metaTypes.add(metaClass);
					}
				}
				for (EClass eClass : eClassMetaClassMap.keySet()) {
					MetaClass metaClass = eClassMetaClassMap.get(eClass);
					for (EClass eSuperType : eClass.getESuperTypes()) {
						metaClass.getSuperTypes().add(eClassMetaClassMap.get(eSuperType));
					}
					for (EStructuralFeature eStructuralFeature : eClass.getEStructuralFeatures()) {
						StructuralFeature structuralFeature = null;
						if (eStructuralFeature instanceof EAttribute) {
							structuralFeature = new Attribute();
						}
						else {
							structuralFeature = new Reference();
						}
						structuralFeature.setName(eStructuralFeature.getName());
						metaClass.getStructuralFeatures().add(structuralFeature);
					}
				}
			}
		}
	}
	
}
