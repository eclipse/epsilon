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
package org.eclipse.epsilon.util.emf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.StringTokenizer;

import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.epsilon.common.dt.util.LogUtil;
import org.eclipse.epsilon.emc.emf.EmfUtil;

public class EmfRegistryManager {

	protected static EmfRegistryManager instance = null;
	protected HashMap<String, List<EPackage>> managedMetamodels = new HashMap<String, List<EPackage>>();
	
	public static EmfRegistryManager getInstance() {
		if (instance == null) {
			instance = new EmfRegistryManager();
		}
		return instance;
	}

	private EmfRegistryManager() {

		for (String metamodel : getMetamodels()) {
			try {
				registerMetamodel(metamodel);
			} catch (Exception ex) {
				LogUtil.log(ex);
			}
		}
		initChangeListener();
	}

	protected void initChangeListener() {
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IResourceChangeListener listener = new IResourceChangeListener() {
			public void resourceChanged(IResourceChangeEvent event) {
				// we are only interested in POST_CHANGE events
				if (event.getType() != IResourceChangeEvent.POST_CHANGE)
					return;
				IResourceDelta rootDelta = event.getDelta();
				// get the delta, if any, for the documentation directory
				// IResourceDelta docDelta = rootDelta.findMember(DOC_PATH);
				// if (docDelta == null)
				// return;
				final ArrayList<IResourceDelta> changed = new ArrayList();
				IResourceDeltaVisitor visitor = new IResourceDeltaVisitor() {
					public boolean visit(IResourceDelta delta) {
						// only interested in changed resources (not added or
						// removed)
						/*
						 * if (delta.getKind() != IResourceDelta.CHANGED) return
						 * true; //only interested in content changes if
						 * ((delta.getFlags() & IResourceDelta.CONTENT) == 0)
						 * return true; IResource resource =
						 * delta.getResource(); //only interested in files with
						 * the "txt" extension if (resource.getType() ==
						 * IResource.FILE &&
						 * "txt".equalsIgnoreCase(resource.getFileExtension())) {
						 * changed.add(resource); }
						 */
						changed.add(delta);
						return true;
					}
				};
				try {
					rootDelta.accept(visitor);
				} catch (CoreException e) {
					e.printStackTrace();
				}

				if (changed.size() == 0)
					return;

				for (IResourceDelta delta : changed) {
					//System.err.println(delta.getResource().getFullPath()
					//		.toOSString()
					//		+ "->" + delta.getKind());
					
					String metamodel = delta.getResource().getFullPath().toOSString();
					List<String> metamodels = getMetamodels();
					if (metamodels.contains(metamodel)) {
						if (delta.getKind() == IResourceDelta.REMOVED) {
							removeMetamodel(metamodel);
							if (delta.getMovedToPath() != null) {
								try {
									addMetamodel(delta.getMovedToPath().toOSString());
								} catch (Exception e) {
									LogUtil.log(e);
								}
							}
						}
						else {
							try {
								//System.err.println(metamodel);
								//EmfUtil.register(URI.createPlatformResourceURI(metamodel, true), EPackage.Registry.INSTANCE);
								registerMetamodel(metamodel);
							}
							catch (Exception ex) {
								ex.printStackTrace();
							}
						}
					}
				}

			}
		};
		workspace.addResourceChangeListener(listener);
	}
	
	public void addMetamodel(String fileName) throws Exception {
		registerMetamodel(fileName);
		List<String> metamodels = getMetamodels();
		if (!metamodels.contains(fileName)) {
			metamodels.add(fileName);
			setMetamodels(metamodels);
		}
	}
	
	private void registerMetamodel(String fileName) throws Exception{
		List<EPackage> ePackages = EmfUtil.register(URI.createPlatformResourceURI(fileName, true), EPackage.Registry.INSTANCE);
		managedMetamodels.put(fileName, ePackages);
	}
	
	public void removeMetamodel(String fileName) {
		
		List<EPackage> ePackages = managedMetamodels.get(fileName);
		
		if (ePackages == null) return;
		
		for (EPackage ePackage : ePackages) {
			EPackage.Registry.INSTANCE.remove(ePackage.getNsURI());
		}
		
		managedMetamodels.remove(fileName);
		List<String> metamodels = getMetamodels();
		metamodels.remove(fileName);
		setMetamodels(metamodels);
		
	}
	
	/*
	public void register(String fileName) throws Exception {
		// File f = new File(fileName);
		
		if (!f.isAbsolute()) {
			fileName = ResourcesPlugin.getWorkspace().getRoot()
					.getRawLocation().toPortableString()
					+ fileName;
		}

		Map etfm = Resource.Factory.Registry.INSTANCE
				.getExtensionToFactoryMap();
		if (!etfm.containsKey("*")) {
			etfm.put("*", new XMIResourceFactoryImpl());
		}

		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getPackageRegistry().put(EcorePackage.eINSTANCE.getNsURI(),
				EcorePackage.eINSTANCE);
		
		// resourceSet.getPackageRegistry().putAll(EPackage.Registry.INSTANCE);
		Resource metamodel = resourceSet.createResource(URI.createURI(""));
		
		System.err.println(resourceSet.getResource(URI.createPlatformResourceURI(fileName, false), true));
		
		//try {
			//metamodel.load(new FileInputStream(fileName), Collections.EMPTY_MAP);
			metamodel = resourceSet.getResource(URI.createPlatformResourceURI(fileName, false), true);
		//} catch (IOException e) {
		//	throw e;
			//EmfUtilPlugin.getDefault().getLog().log(new Status());
		//}
		// e.printStackTrace();
		// MessageDialog.openError(null,"Error", e.toString());
		// return;
		// }

		setDataTypesInstanceClasses(metamodel);

		Iterator it = metamodel.getContents().iterator();
		while (it.hasNext()) {
			Object next = it.next();
			if (next instanceof EPackage) {
				EPackage p = (EPackage) next;
				if (p.getNsURI() == null)
					p.setNsURI(p.getName());
				// if (p.getNsPrefix() == null) p.setNsPrefix(p.getName());
				EPackage.Registry.INSTANCE.put(p.getNsURI(), p);
				metamodel.setURI(URI.createURI(p.getNsURI()));
			}
		}
	
	}
	*/
	/*
	protected void setDataTypesInstanceClasses(Resource metamodel) {
		Iterator it = metamodel.getAllContents();
		while (it.hasNext()) {
			EObject eObject = (EObject) it.next();
			if (eObject instanceof EEnum) {
				// ((EEnum) eObject).setInstanceClassName("java.lang.Integer");
			} else if (eObject instanceof EDataType) {
				EDataType eDataType = (EDataType) eObject;
				String instanceClass = "";
				if (eDataType.getName().equals("String")) {
					instanceClass = "java.lang.String";
				} else if (eDataType.getName().equals("Boolean")) {
					instanceClass = "java.lang.Boolean";
				} else if (eDataType.getName().equals("Integer")) {
					instanceClass = "java.lang.Integer";
				} else if (eDataType.getName().equals("Float")) {
					instanceClass = "java.lang.Float";
				} else if (eDataType.getName().equals("Double")) {
					instanceClass = "java.lang.Double";
				}
				eDataType.setInstanceClassName(instanceClass);
			}
		}
	}
	*/
	public List<String> getMetamodels() {
		List<String> metamodels = new ArrayList();
		String concat = EmfUtilPlugin.getDefault().getPreferenceStore()
				.getString("metamodels");
		StringTokenizer st = new StringTokenizer(concat, ";");
		while (st.hasMoreTokens()) {
			metamodels.add(st.nextToken());
		}
		return metamodels;
	}
	
	
	private void setMetamodels(List<String> metamodels) {
		StringBuffer sb = new StringBuffer();
		ListIterator li = metamodels.listIterator();
		while (li.hasNext()) {
			sb.append(li.next());
			if (li.hasNext()) {
				sb.append(";");
			}
		}
		EmfUtilPlugin.getDefault().getPreferenceStore().setValue("metamodels",
				sb.toString());
	}
}
