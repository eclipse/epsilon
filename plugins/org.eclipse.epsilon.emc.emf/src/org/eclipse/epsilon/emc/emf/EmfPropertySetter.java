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
import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.epsilon.eol.exceptions.EolIllegalPropertyAssignmentException;
import org.eclipse.epsilon.eol.exceptions.EolIllegalPropertyException;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.introspection.AbstractPropertySetter;
import org.eclipse.epsilon.eol.types.EolCollection;
import org.eclipse.epsilon.eol.types.EolTypeWrapper;

public class EmfPropertySetter extends AbstractPropertySetter{

	public void invoke(Object value) throws EolRuntimeException {
		EObject eObject = (EObject) object;
		EStructuralFeature sf = EmfUtil.getEStructuralFeature(eObject.eClass(), property);
		
		if (sf != null) {
			
			// Make all features changeable
			// if (!sf.isChangeable()) sf.setChangeable(true);
			
			if (value != null) {
				//eObject.eUnset(sf);
				if (sf.isMany()){
					Collection sourceValues = (Collection) eObject.eGet(sf);
					if (value instanceof EolCollection){	
						//System.err.println("Setting feature " + sf.getName() + " of class " + eObject.eClass().getName() + " with value " + new PrettyPrinterManager().toString(value));
						copyCollectionValues(
							((EolCollection)value).getStorage()
							,sourceValues);
					}
					else {
						throw new EolIllegalPropertyAssignmentException(
								this.getProperty(), this.getAst());
					}
				}
				else {
					//try {
						eObject.eSet(sf, EolTypeWrapper.getInstance().unwrap(value));
					//}
					//catch (Exception ex) {
						//System.err.println("Hit exception while setting the value of "
						//		 + sf.getEContainingClass().getName() + "." + sf.getName() + 
						//		 " to " + value);
						//ex.printStackTrace();
					//}
				}
			}
			//else {
				//eObject.eUnset(sf);
			//}
		}
		else {
			throw new EolIllegalPropertyException(object, property, ast, context);
		}
	}
	
	protected void copyCollectionValues(Collection source, Collection target) {
		target.clear();
		Iterator it = source.iterator();
		while (it.hasNext()){
			Object next = EolTypeWrapper.getInstance().unwrap(it.next());
			//System.err.println(target.getClass() + " + " + next.getClass());
			target.add(next);
		}
	}
	
}
