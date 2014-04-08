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

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.GenericXMLResourceFactoryImpl;
import org.eclipse.epsilon.common.util.StringProperties;
import org.eclipse.epsilon.common.util.StringUtil;
import org.eclipse.epsilon.emc.emf.AbstractEmfModel;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.epsilon.eol.execute.introspection.IPropertySetter;
import org.eclipse.epsilon.eol.execute.operations.contributors.IOperationContributorProvider;
import org.eclipse.epsilon.eol.execute.operations.contributors.OperationContributor;
import org.eclipse.xsd.ecore.XSDEcoreBuilder;

public class XmlModel extends AbstractEmfModel implements IOperationContributorProvider {
	
	public static String PROPERTY_MODEL_FILE = "modelFile";
	public static String PROPERTY_XSD_FILE = "xsdFile";
	protected MixedElementOperationContributor mixedElementOperationContributor = new MixedElementOperationContributor();
	
	protected String modelFile = "";
	protected String xsdFile = "";
	
	static String basePath = "E://Projects//Eclipse//3.3//workspace//org.eclipse.epsilon.eol.models.emf//src//org//epsilon//eol//models//emf//xml//";
	
	@Override
	public void load(StringProperties properties, String basePath) throws EolModelLoadingException {
		super.load(properties, basePath);
		this.modelFile = StringUtil.toString(basePath) + properties.getProperty(PROPERTY_MODEL_FILE);
		this.xsdFile = StringUtil.toString(basePath) + properties.getProperty(PROPERTY_XSD_FILE);
		
		load();
	}
	
	public static void main(String[] args) throws Exception {

		XmlModel model = new XmlModel();
		model.modelFile = basePath + "Test.xml";
		model.xsdFile = basePath + "TestCases.xsd";
		model.load();
		
		model.store(model.modelFile + "copy.xml");
		
	}
	
	@Override
	protected void loadModel() throws EolModelLoadingException {
		
		ResourceSet resourceSet = new ResourceSetImpl();
	    
		if (xsdFile != null && xsdFile.endsWith("xsd")) {
			XSDEcoreBuilder xsdEcoreBuilder = new XSDEcoreBuilder();
			
		    Collection<EObject> eCorePackages = xsdEcoreBuilder.generate(URI.createFileURI(xsdFile));
		    
		    for (Iterator<EObject> iter = eCorePackages.iterator(); iter.hasNext();) {
		    	EPackage element = (EPackage) iter.next();
		    	if (element.getNsURI() == null || element.getNsURI().length() == 0) {
		    		element.setNsURI(element.getName());
		    	}
		    	// element.setNsPrefix("");
		    	resourceSet.getPackageRegistry().put(element.getNsURI(), element);
		    }
		}
		
		Map<String, Object> etfm = resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap();
		if(!etfm.containsKey("*")) {
			etfm.put("*", new GenericXMLResourceFactoryImpl());
			//etfm.put("*", new XMLResourceFactoryImpl());
		}
		
	    Resource resource = resourceSet.createResource(URI.createFileURI(modelFile));
	    
	    try {
			if (readOnLoad) resource.load(null);
		} catch (IOException e) {
			throw new EolModelLoadingException(e, this);
		}
		
		this.modelImpl = resource;
	}

	public boolean store() {
		return store(this.modelFile);
	}
	
	public boolean store(String fileName) {
		FileOutputStream fos = null;

		try {
			fos = new FileOutputStream(fileName);
			modelImpl.save(fos, null);
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		finally {
			try {
				fos.flush();
				fos.close();
			}
			catch (Exception ex){
				ex.printStackTrace();
			}
		}
		return true;
	}

	@Override
	public IPropertySetter getPropertySetter() {
		return new XmlPropertySetter();
	}

	@Override
	public OperationContributor getOperationContributor() {
		return mixedElementOperationContributor;
	}
	
}
