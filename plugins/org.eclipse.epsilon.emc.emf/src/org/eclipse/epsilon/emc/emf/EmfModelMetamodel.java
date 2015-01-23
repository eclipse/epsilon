package org.eclipse.epsilon.emc.emf;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.epsilon.common.util.StringProperties;
import org.eclipse.epsilon.eol.compile.m3.MetaClass;
import org.eclipse.epsilon.eol.compile.m3.Metamodel;
import org.eclipse.epsilon.eol.models.IRelativePathResolver;

public class EmfModelMetamodel extends Metamodel {
	
	public EmfModelMetamodel(StringProperties properties, IRelativePathResolver resolver) {
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
						metaTypes.add(metaClass);
					}
				}
			}
		}
	}
	
}
