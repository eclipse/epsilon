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
package org.eclipse.epsilon.emc.emf.xml;

import javax.xml.namespace.QName;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.epsilon.emc.emf.EmfPropertySetter;
import org.eclipse.epsilon.emc.emf.EmfUtil;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;

public class XmlPropertySetter extends EmfPropertySetter {

	@Override
	public void invoke(Object value) throws EolRuntimeException {
		EObject eObject = (EObject) object;
		EStructuralFeature sf = EmfUtil.getEStructuralFeature(eObject.eClass(), property);
		
		if (sf.getEType().getName().equals("QName")) {
			QName qName = QName.valueOf((String)(value));
			eObject.eSet(sf, qName);
		}
		else {
			super.invoke(value);
		}
	}
	
	
	
}
