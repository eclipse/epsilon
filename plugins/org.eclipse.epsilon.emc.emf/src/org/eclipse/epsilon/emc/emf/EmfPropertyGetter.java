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
package org.eclipse.epsilon.emc.emf;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.epsilon.eol.exceptions.EolIllegalPropertyException;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.introspection.AbstractPropertyGetter;
import org.eclipse.epsilon.eol.types.EolBag;
import org.eclipse.epsilon.eol.types.EolOrderedSet;
import org.eclipse.epsilon.eol.types.EolSequence;
import org.eclipse.epsilon.eol.types.EolSet;
import org.eclipse.epsilon.eol.types.EolTypeWrapper;

public class EmfPropertyGetter extends AbstractPropertyGetter{

	public Object invoke(Object object, String property) throws EolRuntimeException {
		EObject eObject = (EObject) object;
		
		EStructuralFeature sf = EmfUtil.getEStructuralFeature(eObject.eClass(), property);
		
		if (sf != null) {
			
			if (sf.isMany()){
				Collection values = (Collection) eObject.eGet(sf);
				
				//System.err.println(values.getClass());
				
				//if (values instanceof BasicEList){
				//	if ((BasicEList)values).
				//	((BasicEList) values).grow(1000);
				//}
				if (sf.isOrdered() && sf.isUnique()) return new EolOrderedSet(values);
				else if (sf.isOrdered()) return new EolSequence(values);
				else if (sf.isUnique()) return new EolSet(values);
				else return new EolBag(values);
			}
			else {
				Object result = EolTypeWrapper.getInstance().wrap(eObject.eGet(sf));
				return result;
			}
		}
		else {
			throw new EolIllegalPropertyException(object, property, ast, context);
		}
	}

}
