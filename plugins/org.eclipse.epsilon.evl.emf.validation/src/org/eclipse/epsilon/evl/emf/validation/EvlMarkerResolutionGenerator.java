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
package org.eclipse.epsilon.evl.emf.validation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.epsilon.common.dt.util.LogUtil;
import org.eclipse.epsilon.emc.emf.EmfPrettyPrinter;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.evl.EvlFixInstance;
import org.eclipse.ui.IMarkerResolution;
import org.eclipse.ui.IMarkerResolutionGenerator;

public class EvlMarkerResolutionGenerator implements IMarkerResolutionGenerator {
	
	public static EvlMarkerResolutionGenerator INSTANCE = new EvlMarkerResolutionGenerator();
	
	protected HashMap<String, Collection<EvlFixInstance>> resolutions = new HashMap<String, Collection<EvlFixInstance>>();
	
	protected HashMap<EvlFixInstance, String> messages = new HashMap<EvlFixInstance, String>();
	
	protected HashMap<EvlFixInstance, String> modelNames = new HashMap<EvlFixInstance, String>();
	
	protected HashMap<EvlFixInstance, String> ePackageUris = new HashMap<EvlFixInstance, String>();
	
	public IMarkerResolution[] getResolutions(IMarker marker) {
		
		if (this != INSTANCE) return INSTANCE.getResolutions(marker);
		
		if (!EvlMarkerResolverManager.INSTANCE.canResolve(marker)) return new IMarkerResolution[]{};
		
		ArrayList<EvlMarkerResolution> resolutions = new ArrayList<EvlMarkerResolution>();
		String elementId = "";
		
		try {
			elementId = EvlMarkerResolverManager.INSTANCE.getAbsoluteElementId(marker);
			String message = EvlMarkerResolverManager.INSTANCE.getMessage(marker);
			
			if (this.resolutions.get(elementId) != null) {
				for (EvlFixInstance fix : this.resolutions.get(elementId)) {
					if (message.equals(messages.get(fix))) {
						resolutions.add(new EvlMarkerResolution(elementId, fix, modelNames.get(fix), ePackageUris.get(fix)));
					}
				}
			}
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		
		IMarkerResolution[] iMarkerResolutions = new IMarkerResolution[resolutions.size() + 1];
	
		int i = 0;
		for (IMarkerResolution resolution : resolutions) {
			iMarkerResolutions[i] = resolution;
			i++;
		}
		
		iMarkerResolutions[iMarkerResolutions.length - 1] = new IMarkerResolution() {

			public String getLabel() {
				return "Ignore";
			}

			public void run(IMarker marker) {
				// Just (try to) delete the marker
				try {
					marker.delete();
				} catch (CoreException e) {
					LogUtil.log(e);
				}
			}
			
		};
		
		return iMarkerResolutions;
	}

	protected EmfPrettyPrinter printer = new EmfPrettyPrinter();
	public void removeFixesFor(EObject eObject) {

		String eObjectId = getEObjectId(eObject);
		Collection<EvlFixInstance> fixes = resolutions.remove(eObjectId);
		if (fixes != null) {
			for (EvlFixInstance fix : fixes) {
				messages.remove(fix);
				modelNames.remove(fix);
			}
		}
	}
	
	public String getEObjectId(Object instance) {
		return EcoreUtil.getURI((EObject) instance).toString();
	}
	
	public void addResolution(String message, EvlFixInstance fix, String modelName, String ePackageUri) {

		messages.put(fix, message);
		modelNames.put(fix, modelName);
		ePackageUris.put(fix, ePackageUri);
		
		String elementId = getEObjectId(fix.getSelf());
		Collection<EvlFixInstance> fixes;
		if (resolutions.containsKey(elementId)) {
			fixes = resolutions.get(elementId);
		}
		else {
			fixes = new ArrayList<EvlFixInstance>();
			resolutions.put(elementId, fixes);
		}
		fixes.add(disconnect(fix));
	}
	
	protected EvlFixInstance disconnect(EvlFixInstance fix) {
		try {
			fix.getTitle();
		} catch (EolRuntimeException e) {
			LogUtil.log(e);
		} 
		fix.setSelf(null);
		fix.getContext().getModelRepository().getModels().clear();
		return fix;
	}
	
	
}
