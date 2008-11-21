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

package org.eclipse.epsilon.dt.exeed;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.epsilon.commons.profiling.Profiler;
import org.eclipse.epsilon.emc.emf.InMemoryEmfModel;
import org.eclipse.jface.resource.ImageDescriptor;

public class ImageTextProvider2 extends ImageTextProvider{

	protected ImageTextProvider2(InMemoryEmfModel model, ExeedPlugin plugin) {
		super(model, plugin);
	}

	@Override
	protected String addStructuralInfo(Object object, String label,
			boolean forReference) {
		Profiler.INSTANCE.start("addStructuralInfo");
		String zuper = super.addStructuralInfo(object, label, forReference);
		Profiler.INSTANCE.stop();
		return zuper;		
	}

	@Override
	protected ImageDescriptor getEClassImageDescriptor(EClass class1,
			ImageDescriptor def) {
		// TODO Auto-generated method stub
		Profiler.INSTANCE.start("getEClassImageDescriptor");
		ImageDescriptor zuper = super.getEClassImageDescriptor(class1, def);
		Profiler.INSTANCE.stop();
		return zuper;
	}

	@Override
	protected String getEEnumLiteralLabel(EEnumLiteral literal) {
		Profiler.INSTANCE.start("getEEnumLiteralLabel");
		String zuper = super.getEEnumLiteralLabel(literal);
		Profiler.INSTANCE.stop();
		return zuper;
	}

	@Override
	protected ImageDescriptor getEObjectImageDescriptor(Object object,
			ImageDescriptor def) {
		// TODO Auto-generated method stub
		Profiler.INSTANCE.start("getEObjectImageDescriptor");
		ImageDescriptor zuper = super.getEObjectImageDescriptor(object, def);
		Profiler.INSTANCE.stop();
		return zuper;
	}

	@Override
	protected String getEObjectLabel(Object object, String def,
			boolean forReference) {
		// TODO Auto-generated method stub
		Profiler.INSTANCE.start("getEObjectLabel");
		String zuper = super.getEObjectLabel(object, def, forReference);
		Profiler.INSTANCE.stop();
		return zuper;
	}

	@Override
	protected String getEObjectReferenceLabel(Object object, String def) {
		// TODO Auto-generated method stub
		Profiler.INSTANCE.start("getEObjectReferenceLabel");
		String zuper = super.getEObjectReferenceLabel(object, def);
		Profiler.INSTANCE.stop();
		return zuper;
		
	}

	@Override
	protected String getEStructuralFeatureLabel(EStructuralFeature feature,
			String def) {
		// TODO Auto-generated method stub
		Profiler.INSTANCE.start("getEStructuralFeatureLabel");
		String zuper = super.getEStructuralFeatureLabel(feature, def);
		Profiler.INSTANCE.stop();
		return zuper;
	}
	
}
 