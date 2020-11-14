/*********************************************************************
 * Copyright (c) 2020 The University of York.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.flexmi.yaml;

import java.io.InputStream;
import java.io.InputStreamReader;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.epsilon.emc.emf.InMemoryEmfModel;
import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.epsilon.flexmi.FlexmiParser;
import org.eclipse.epsilon.flexmi.FlexmiResource;
import org.eclipse.epsilon.flexmi.FlexmiResourceFactory;
import org.eclipse.epsilon.flexmi.xml.FlexmiXmlParser;
import org.w3c.dom.Document;
import org.yaml.snakeyaml.Yaml;

public class FlexmiYamlParser extends FlexmiXmlParser {
	
	public static void main(String[] args) throws Exception {
		
		EPackage.Registry.INSTANCE.put(EcorePackage.eNS_URI, EcorePackage.eINSTANCE);
		
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new FlexmiResourceFactory() {
			@Override
			public FlexmiResource createResource(URI uri) {
				return new FlexmiResource(uri) {
					protected FlexmiParser createParser() {
						return new FlexmiYamlParser();
					};
				};
			}
		});
		
		FlexmiResource resource = (FlexmiResource) resourceSet.createResource(URI.createURI(FlexmiYamlParser.class.getResource("ecore.yaml").toURI().toString()));
		resource.load(null);
		
		EolModule module = new EolModule();
		module.parse(FlexmiYamlParser.class.getResource("ecore.eol").toURI());
		module.getContext().getModelRepository().addModel(new InMemoryEmfModel(resource));
		module.execute();
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	protected Document parse(InputStream inputStream) throws Exception {
		Yaml yaml = new Yaml();
		YamlDocument document = new YamlDocument(yaml.compose(new InputStreamReader(inputStream)));
		System.out.println(document.toXml());
		return document;
	}
	
}
