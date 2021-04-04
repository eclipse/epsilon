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
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.epsilon.emc.emf.InMemoryEmfModel;
import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.epsilon.flexmi.FlexmiFlavour;
import org.eclipse.epsilon.flexmi.FlexmiParseException;
import org.eclipse.epsilon.flexmi.FlexmiParser;
import org.eclipse.epsilon.flexmi.FlexmiResource;
import org.eclipse.epsilon.flexmi.FlexmiResourceFactory;
import org.eclipse.epsilon.flexmi.templates.Template;
import org.eclipse.epsilon.flexmi.xml.FlexmiXmlParser;
import org.eclipse.epsilon.flexmi.xml.Location;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.ProcessingInstruction;
import org.yaml.snakeyaml.DumperOptions.FlowStyle;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.nodes.MappingNode;
import org.yaml.snakeyaml.nodes.Node;
import org.yaml.snakeyaml.nodes.NodeTuple;
import org.yaml.snakeyaml.nodes.ScalarNode;
import org.yaml.snakeyaml.nodes.SequenceNode;
import org.yaml.snakeyaml.scanner.ScannerException;

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
	public Document parse(InputStream inputStream) throws Exception {
		Yaml yaml = new Yaml();
		try {
			Document document = toDocument(yaml.compose(new InputStreamReader(inputStream)));
			return document;
		}
		catch (ScannerException ex) {
			int line = 0;
			if (ex.getProblemMark() != null) line = ex.getProblemMark().getLine();
			if (ex.getContextMark() != null) line = ex.getContextMark().getLine();
			throw new FlexmiParseException(ex, line + 1);
		}
	}
	
	@Override
	public FlexmiFlavour getFlavour() {
		return FlexmiFlavour.YAML;
	}
	
	protected Document toDocument(Node node) throws Exception {
		
		Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
		Element documentElement = toElement(document, "_", node);
		document.appendChild(documentElement);
		return document;
	}
	
	protected Element toElement(Document document, ScalarNode nameNode, Node node) {
		Element element = toElement(document, nameNode.getValue(), node);
		element.setUserData(Location.ID,  new Location(nameNode.getStartMark().getLine()+1, nameNode.getStartMark().getColumn(), 
				nameNode.getEndMark().getLine()+1, nameNode.getEndMark().getColumn()), null);
		return element;
	}
	
	protected Element toElement(Document document, String nodeName, Node node) {
		
		Element element = document.createElement(nodeName);
		List<Node> childNodes = new ArrayList<Node>();
		
		if (node instanceof SequenceNode) {
			childNodes.addAll(((SequenceNode) node).getValue());
		}
		else if (node instanceof MappingNode) {
			childNodes.add((MappingNode) node);
		}
		
		for (Node childNode : childNodes) {
			
			if (childNode instanceof MappingNode) {
				MappingNode mappingNode = (MappingNode) childNode;	
				
				for (NodeTuple tuple : mappingNode.getValue()) {
					
					ScalarNode keyNode = (ScalarNode) tuple.getKeyNode();
					
					if (tuple.getValueNode() instanceof ScalarNode) {
						if (keyNode.getValue().startsWith("?")) {
							ProcessingInstruction pi = document.createProcessingInstruction(keyNode.getValue().substring(1), ((ScalarNode)tuple.getValueNode()).getValue());
							element.appendChild(pi);
						}
						else {
							element.setAttribute(keyNode.getValue(), ((ScalarNode) tuple.getValueNode()).getValue());
						}
					}
					else {
						// Sequences of primitive values
						if (tuple.getValueNode() instanceof SequenceNode && 
								((SequenceNode) tuple.getValueNode()).getValue().stream().allMatch(n -> n instanceof ScalarNode && !isSlot((ScalarNode) n))) {
							for (Node sequenceNode : ((SequenceNode) tuple.getValueNode()).getValue()) {
								
								Element child = document.createElement(keyNode.getValue());
								child.setTextContent(((ScalarNode) sequenceNode).getValue());
								child.setUserData(Location.ID,  new Location(sequenceNode.getStartMark().getLine()+1, sequenceNode.getStartMark().getColumn(), 
										sequenceNode.getEndMark().getLine()+1, sequenceNode.getEndMark().getColumn()), null);
								element.appendChild(child);
							}
						}
						// Sequences (arrays) of nodes
						else if (tuple.getValueNode() instanceof SequenceNode && 
								((SequenceNode) tuple.getValueNode()).getFlowStyle() == FlowStyle.FLOW) {
							
							System.out.println();
							for (Node sequenceNode : ((SequenceNode) tuple.getValueNode()).getValue()) {
								Element child = toElement(document, keyNode, sequenceNode);
								element.appendChild(child);
							}
						}
						else {
							Element child = toElement(document, keyNode, tuple.getValueNode());
							element.appendChild(child);
						}
					}
				}
			}
			else if (childNode instanceof ScalarNode){
				Element child = document.createElement(((ScalarNode) childNode).getValue());
				element.appendChild(child);
			}
		}
		
		return element;
		
	}
	
	protected boolean isSlot(ScalarNode node) {
		return (Template.PREFIX + "slot").equals(node.getValue());
	}
	
	protected String toXml(Document document) {
		Transformer transformer;
		try {
			transformer = TransformerFactory.newInstance().newTransformer();
			transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		try (StringWriter writer = new StringWriter()) {
			StreamResult result = new StreamResult(writer);
			transformer.transform(new DOMSource(document.getDocumentElement()), result);
			return writer.toString();
		}
		catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}
	
}
