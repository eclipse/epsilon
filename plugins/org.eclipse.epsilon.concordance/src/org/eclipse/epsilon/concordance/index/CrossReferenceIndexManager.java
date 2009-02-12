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

package org.eclipse.epsilon.concordance.index;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.epsilon.concordance.Activator;
import org.eclipse.epsilon.concordance.analysis.ResourceAnalytics;
import org.eclipse.epsilon.concordance.analysis.ResourceAnalyzer;
import org.eclipse.epsilon.concordance.builder.LastDelta;
import org.eclipse.epsilon.concordance.ui.ModelExtensionsManager;

public class CrossReferenceIndexManager {
	
	public static String MARKER_ID = "org.eclipse.epsilon.concordance.danglingCrossReference";
	
	public static CrossReferenceIndexManager INSTANCE = new CrossReferenceIndexManager();
	protected CrossReferenceIndex index = null;
	
	public CrossReferenceIndexManager() {
		String indexPath = Activator.getDefault().getStateLocation().toOSString() + "/index";
		index = new CrossReferenceIndex(indexPath);
	}
	
	public CrossReferenceIndex getCrossReferenceIndex() {
		return index;
	}
	
	
	protected String getURI(IFile file) {
		return URI.createPlatformResourceURI(file.getFullPath().toOSString(), true).toString();		
	}
	
	public Collection<CrossReference> getIncomingCrossReferences(EObject eObject) {
		String id = eObject.eResource().getURIFragment(eObject);
		String resource = eObject.eResource().getURI().toString();
		return index.searchByTargetResourceAndId(resource, id);
	}
	
	public Collection<CrossReference> getOutgoingCrossReferences(EObject eObject) {
		String id = eObject.eResource().getURIFragment(eObject);
		String resource = eObject.eResource().getURI().toString();
		return index.searchBySourceResourceAndId(resource, id);
	}
	
	public boolean isModel(IResource resource) {
		if (resource instanceof IFile) {
			for (String extension : ModelExtensionsManager.getInstance().getExtensions()) {
				if (resource.getName().endsWith(extension)) {
					return true;
				}
			}
		}
		return false;
	}

	public void removeModelsFromIndex(IProject project) {
		
		try {
		
		project.accept(new IResourceVisitor() {

			public boolean visit(IResource resource) throws CoreException {
				if (isModel(resource)) {
					IFile file = (IFile) resource;
					removeModelFromIndex(file);
				}
				return true;
			}
			
		});
		}
		
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	protected void addInvalidReferenceMarker(String uri, CrossReference reference) {
		
		
		String error = "Dangling reference" +
			" from feature " + reference.getFeature() + 
			" of element " + reference.getSourceLabel() +
			" to element " + 
			reference.getTargetLabel() + " (" +
			reference.getTargetResource() + 
			"#" + reference.getTargetElementId() + ")";
		
		addErrorMarker(uri, error, 0);
		
	}
	
	protected void fixOutgoingReferences(URI fromURI, URI toURI) {
		Set<String> targetResourceURIs = new HashSet<String>();
		
		Collection<CrossReference> references = index.searchBySourceResource(fromURI.toString());	
		references.addAll(index.searchBySourceResource(toURI.toString()));
		
		for (CrossReference ref : references) {
			if (ref.isExternal()) {
				targetResourceURIs.add(ref.getTargetResource());
			}
		}
		
		if (targetResourceURIs.isEmpty()) return;
		
		Resource sourceResource = null; 
		
		try {
			sourceResource = readAndResolveResource(fromURI);
			storeResource(sourceResource);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		index.deleteBySourceResource(fromURI.toString());
		index.deleteBySourceResource(toURI.toString());
		
		for (CrossReference reference : references) {
			reference.setSourceResource(toURI.toString());
			reference.setTargetResource(LastDelta.INSTANCE.getCurrentPath(reference.getTargetResource()));
		}
		
		index.addAll(references);
		index.commitChanges();
	}
	
	public void storeResource(Resource resource) throws IOException {
		
		for (Resource r : resource.getResourceSet().getResources()) {
			URI loadedBy = r.getURI();
			URI toStoreIn = URI.createURI(LastDelta.INSTANCE.getCurrentPath(loadedBy.toString()));
			r.setURI(toStoreIn);
		}
		
		resource.save(null);
	}

	protected void fixIncomingReferences(URI fromURI, URI toURI) {
		Collection<CrossReference> references = index.searchByTargetResource(fromURI.toString());
		
		references.addAll(index.searchByTargetResource(toURI.toString()));
		
		Set<String> sourceResourceURIs = new HashSet<String>();
		
		for (CrossReference ref : references) {
			if (ref.isExternal()) {
				sourceResourceURIs.add(ref.getSourceResource());
			}
		}
			
		if (sourceResourceURIs.isEmpty()) return;
				
		for (String sourceResourceURI : sourceResourceURIs) {
			
			try {
				
				Resource sourceResource = readAndResolveResource(URI.createURI(sourceResourceURI));
				
				storeResource(sourceResource);
				
			} catch (IOException e) {
				e.printStackTrace();
				return;
			}
			
		}
		
		index.deleteByTargetResource(fromURI.toString());
		index.deleteByTargetResource(toURI.toString());
		
		for (CrossReference reference : references) {
			reference.setSourceResource(LastDelta.INSTANCE.getCurrentPath(reference.getSourceResource()));
			reference.setTargetResource(toURI.toString());
		}
		index.addAll(references);
		index.commitChanges();
	}

	public Resource loadResource(URI uri) throws IOException {
		
		
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource resource = resourceSet.createResource(getOldURI(uri));
		
		IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(getCurrentURI(uri).toPlatformString(true)));
		FileInputStream fileInputStream = new FileInputStream(file.getRawLocation().toOSString());
		resource.load(fileInputStream, null);
		fileInputStream.close();
		
		return resource;
	}
	
	public URI getCurrentURI(URI uri) {
		return URI.createURI(LastDelta.INSTANCE.getCurrentPath(uri.toString()));
	}
	
	public URI getOldURI(URI uri) {
		return URI.createURI(LastDelta.INSTANCE.getOldPath(uri.toString()));
	}
	
	
	public Resource readAndResolveResource(URI uri) throws IOException {
		
		Resource main = loadResource(uri);
		
		Collection<CrossReference> references = index.searchBySourceResource(getOldURI(uri).toString());
		references.addAll(index.searchBySourceResource(getCurrentURI(uri).toString()));
		
		Set<String> targetResourceURIs = new HashSet<String>();
		
		for (CrossReference ref : references) {
			if (ref.isExternal()) {
				targetResourceURIs.add(ref.getTargetResource());
			}
		}		
		
		for (String targetResourceURI : targetResourceURIs) {
			main.getResourceSet().getResources().add(
					loadResource(
							URI.createURI(targetResourceURI)));
			
		}
		
		EcoreUtil.resolveAll(main);
		
		return main;
		
	}
	
	protected String getOtherResourcesNames(Resource resource) {
		String result = "";
		for (Resource res : resource.getResourceSet().getResources()) {
			if (res!=resource)
			result += res.getURI();
		}
		return result;
	}
	
	public void moveModel(IPath from, IPath to) {
		
		URI fromURI = URI.createPlatformResourceURI(from.toOSString(), true);
		URI toURI = URI.createPlatformResourceURI(to.toOSString(), true);
		
		fixIncomingReferences(fromURI, toURI);
		fixOutgoingReferences(fromURI, toURI);
		
	}
	
	protected void addAnalysisFailedMarker(IFile file, Exception ex) {
		
		String error = "Could not load model: " + ex.getLocalizedMessage();
		int line = 0;
		
		if (ex.getCause() instanceof Diagnostic) {
			Diagnostic diagnostic = (Diagnostic) ex.getCause();
			line = diagnostic.getLine();
		}
		
		addErrorMarker(file, error, line);
	}
	
	protected void addErrorMarker(String uri, String error, int line) {
		IFile file = getFile(uri);
		if (file != null) {
			addErrorMarker(file, error, line);
		}
	}
	
	protected void addErrorMarker(IFile file, String error, int line) {
		try {
			IMarker marker = file.createMarker(MARKER_ID);
			marker.setAttribute(IMarker.MESSAGE, error);
			marker.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_ERROR);
			marker.setAttribute(IMarker.LINE_NUMBER, line);
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}
	
	public void updateStatus(Collection<String> uris) {
		for (String uri : uris) {
			updateDanglingReferencesMarkers(uri);
		}
	}
	
	public void removeMarkers(IFile file) {
		try {
			file.deleteMarkers(MARKER_ID, true, IResource.DEPTH_ZERO);
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}
	
	public void updateDanglingReferencesMarkers(String uri) {
		
		IFile file = getFile(uri);
		
		if (file == null) return;
		
		removeMarkers(file);
		
		Collection<CrossReference> references = index.searchBySourceResource(uri);
		for (CrossReference reference : references) {
			if (reference.isDangling()) {
				addInvalidReferenceMarker(uri, reference);
			}
		}
		
	}
	
	public void addModelToIndex(IFile file) {
		ResourceAnalyzer resourceAnalyzer = new ResourceAnalyzer();
		String uri = getURI(file);
		ResourceAnalytics analytics = null;
		
		try {
			analytics = resourceAnalyzer.analyzeResource(file);
		}
		catch (Exception ex) {
			addAnalysisFailedMarker(file, ex);
			return;
		}
		
		Collection<CrossReference> incomingReferences = index.searchByTargetResource(uri);
		
		if (incomingReferences.size() > 0) {
			Collection<String> toUpdateStatus = new ArrayList<String>();
			for (CrossReference incoming : incomingReferences) {
				if (incoming.isDangling() && analytics.getElementIds().contains(incoming.getTargetElementId())) {
					incoming.setDangling(false);
					toUpdateStatus.add(incoming.getSourceResource());
				}
			}
			index.deleteByTargetResource(uri);
			index.addAll(incomingReferences);
			updateStatus(toUpdateStatus);
		}
		
		System.err.println("+" + analytics.getCrossReferences().size());
		
		index.addAll(analytics.getCrossReferences());
		
		index.commitChanges();
		
		System.err.println("=" + CrossReferenceIndexManager.INSTANCE.getCrossReferenceIndex().getAll().size());
		
		
	}
	
	public void updateModelInIndex(IFile file) throws Exception {
		ResourceAnalyzer resourceAnalyzer = new ResourceAnalyzer();
		String uri = getURI(file);
		index.deleteBySourceResource(uri);
		index.commitChanges();
		ResourceAnalytics analytics = null;
		
		try {
			removeMarkers(file);
			analytics = resourceAnalyzer.analyzeResource(file);
		}
		catch (Exception ex) {
			addAnalysisFailedMarker(file, ex);
			removeModelFromIndex(file);
			return;
		}
		
		index.addAll(analytics.getCrossReferences());
		index.commitChanges();
		
		Collection<CrossReference> incomingReferences = index.searchByTargetResource(uri);
		
		if (incomingReferences.size() > 0) {
			Collection<String> toUpdateStatus = new ArrayList<String>();
			for (CrossReference incoming : incomingReferences) {
				if (incoming.isDangling() && analytics.getElementIds().contains(incoming.getTargetElementId())) {
					incoming.setDangling(false);
					toUpdateStatus.add(incoming.getSourceResource());
				} 
				else if (!incoming.isDangling() && !analytics.getElementIds().contains(incoming.getTargetElementId())) {
					incoming.setDangling(true);
					toUpdateStatus.add(incoming.getSourceResource());
				}
			}
			
			index.deleteByTargetResource(uri);
			index.addAll(incomingReferences);
			index.commitChanges();
			
			updateStatus(toUpdateStatus);
		}
	}
	
	public void removeModelFromIndex(IFile file) {
		String path = getURI(file);
		index.deleteBySourceResource(path);
		index.commitChanges();
		Collection<CrossReference> references = index.searchByTargetResource(path);
		for (CrossReference reference : references) {
			reference.setDangling(true);
			addInvalidReferenceMarker(reference.getSourceResource(), reference);
		}
		index.deleteByTargetResource(path);
		index.addAll(references);
		index.commitChanges();
	}
	
	public IFile getFile(String uri) {
		
		String targetPath = URI.createURI(uri).toPlatformString(true);
		
		if (targetPath == null) return null;
		
		return ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(targetPath));	
	}
	
}
 