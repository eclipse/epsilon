/*******************************************************************************
 * Copyright (c) 2009 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************
 *
 * $Id$
 */
package org.eclipse.epsilon.hutn.dt.editor;

import static org.hamcrest.CoreMatchers.any;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.epsilon.emc.emf.EmfMetaModel;
import org.eclipse.epsilon.eol.exceptions.models.EolModelElementTypeNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.epsilon.hutn.model.hutn.NsUri;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;


public class EmfMetamodelDirectory {

	private final Collection<EmfMetaModel> metamodels = new LinkedList<EmfMetaModel>();
	
	public EmfMetamodelDirectory(String nsUri) throws EolModelLoadingException {
		this.metamodels.add(loadMetamodel(nsUri));
	}
	
	public EmfMetamodelDirectory(Collection<NsUri> nsUris) throws EolModelLoadingException {
		for (NsUri nsUri : nsUris) {
			this.metamodels.add(loadMetamodel(nsUri.getValue()));
		}
	}
	
	private static EmfMetaModel loadMetamodel(String nsUri) throws EolModelLoadingException {
		final EmfMetaModel metamodel = new EmfMetaModel(nsUri);
		metamodel.load();
		return metamodel;
	}
	
	public Collection<String> classifierNames() {
		return namesOfTypedElements("EClassifier");
	}

	public Collection<String> packageNames() {
		return namesOfTypedElements("EPackage");
	}
	
	public Collection<String> concreteClassNames() {
		return namesOfTypedElements("EClass", new ConcreteClassMatcher());
	}
	
	
	private Collection<String> namesOfTypedElements(String type) {
		return namesOfTypedElements(type, any(EObject.class));
	}
	
	private Collection<String> namesOfTypedElements(String type, Matcher<EObject> filter) {
		try {
			final Collection<String> names = new LinkedList<String>();

			for (EmfMetaModel metamodel : metamodels) {
				for (EObject element : metamodel.getAllOfKind(type)) {
					if (filter.matches(element)) {
						names.add(((ENamedElement)element).getName());
					}
				}
			}
			
			return names;
			
		} catch (EolModelElementTypeNotFoundException e) {
			return Collections.emptyList();
		}
	}
	
	
	
	private static class ConcreteClassMatcher extends TypeSafeMatcher<EObject> {

		@Override
		protected boolean matchesSafely(EObject item) {
			return item instanceof EClass && isConcrete((EClass)item);
		}
		
		private boolean isConcrete(EClass cls) {
			return !cls.isAbstract();
		}

		public void describeTo(Description description) {
			description.appendText("concrete class");
		}
		
	}
}
