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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.epsilon.flexmi.yaml.base.BaseElement;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.yaml.snakeyaml.nodes.MappingNode;
import org.yaml.snakeyaml.nodes.Node;
import org.yaml.snakeyaml.nodes.NodeTuple;
import org.yaml.snakeyaml.nodes.ScalarNode;
import org.yaml.snakeyaml.nodes.SequenceNode;

public class YamlElement extends BaseElement implements YamlNode {
	
	protected org.yaml.snakeyaml.nodes.Node node;
	protected YamlNodeList children = new YamlNodeList();
	protected YamlAttributes attributes = new YamlAttributes();
	protected String name;
	protected org.w3c.dom.Node parentNode = null;
	
	public YamlElement(String name) {
		this.name = name;
	}
	
	public YamlElement(String name, Node node) {
		this.name = name;
		this.node = node;
		
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
							YamlProcessingInstruction pi = new YamlProcessingInstruction(keyNode.getValue().substring(1), 
								((ScalarNode)tuple.getValueNode()).getValue());
							children.add(pi);
						}
						else {
							attributes.put(keyNode.getValue(), ((ScalarNode) tuple.getValueNode()).getValue());
						}
					}
					else {
						YamlElement child = new YamlElement(keyNode.getValue(), tuple.getValueNode());
						children.add(child);
						child.setParentNode(this);
					}
				}
			}
			else if (childNode instanceof ScalarNode){
				YamlElement child = new YamlElement(((ScalarNode) childNode).getValue());
				children.add(child);
				child.setParentNode(this);
			}
		}
		
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public YamlNodeList getChildren() {
		return children;
	}
	
	@Override
	public String getNodeName() {
		return name;
	}
	
	@Override
	public org.w3c.dom.Node getParentNode() {
		return parentNode;
	}
	
	public void setParentNode(org.w3c.dom.Node parentNode) {
		this.parentNode = parentNode;
	}
	
	@Override
	public NodeList getChildNodes() {
		return children;
	}
	
	@Override
	public NamedNodeMap getAttributes() {
		return attributes;
	}
	
	@Override
	public String getAttribute(String name) {
		return attributes.get(name);
	}
}
