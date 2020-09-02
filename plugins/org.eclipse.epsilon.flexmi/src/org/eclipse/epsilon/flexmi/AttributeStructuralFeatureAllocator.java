/*********************************************************************
* Copyright (c) 2008 The University of York.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.flexmi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.epsilon.flexmi.templates.Template;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

public class AttributeStructuralFeatureAllocator {
	
	protected StringSimilarityProvider stringSimilarityProvider = new CachedStringSimilarityProvider(new DefaultStringSimilarityProvider());
		
	public Map<Node, EStructuralFeature> allocate(NamedNodeMap attributes, List<EStructuralFeature> structuralFeatures) {

		final int attrLen = attributes.getLength();
		Map<String, String> attributeNamesMap = new HashMap<>();
		for (int i = 0; i < attrLen; i++) {
			// use only the latest apparition of an attribute (expression or not)
			String nodeName = attributes.item(i).getNodeName();
			attributeNamesMap.put(removePrefix(nodeName), nodeName);
		}
		List<String> attributeNames = new ArrayList<>(attributeNamesMap.values());
		
		List<String> structuralFeatureNames = new ArrayList<>(structuralFeatures.size());
		for (EStructuralFeature feature : structuralFeatures) {
			structuralFeatureNames.add(feature.getName());
		}
		
		Map<String, String> nameAllocation = allocate(attributeNames, structuralFeatureNames);
		Map<Node, EStructuralFeature> allocation = new HashMap<>();
		
		for (Map.Entry<String, String> entry : nameAllocation.entrySet()) {
			String structuralFeatureName = entry.getValue();
			EStructuralFeature feature = null;
			for (EStructuralFeature f : structuralFeatures) {
				if (structuralFeatureName.equals(f.getName())) {
					feature = f;
					break;
				}
			}
			allocation.put(attributes.getNamedItem(entry.getKey()), feature);
		}
		
		return allocation;
		
	}
	
	public Map<String, String> allocate(List<String> values, List<String> slots) {
		
		HashMap<String, String> result = new HashMap<>();
		for (String value : new ArrayList<>(values)) {
			String slot = slots.stream().filter(s -> s.equalsIgnoreCase(removePrefix(value))).findFirst().orElse(null);
			if (slot != null) {
				values.remove(value);
				slots.remove(slot);
				result.put(value, slot);
			}
		}
		
		AllocationTree tree = new AllocationTree();
		tree.allocate(values, slots);
		
		int bestSimilarity = -1;
		AllocationTree bestAllocation = null;
		for (AllocationTree leaf : tree.getLeafs()) {
			int similarity = 0;
			for (Allocation allocation : leaf.getAllAllocations()) {
				similarity += stringSimilarityProvider.getSimilarity(allocation.getSlot(), removePrefix(allocation.getValue()));
			}
			if (similarity > bestSimilarity) {
				bestAllocation = leaf;
				bestSimilarity = similarity;
			}
		}
		
		
		if (bestAllocation != null) {
			for (Allocation allocation : bestAllocation.getAllAllocations()) {
				result.put(allocation.getValue(), allocation.getSlot());
			}
		}
		return result;
		
	}
	
	protected String removePrefix(String str) {
		if (str.startsWith(Template.PREFIX)) {
			str = str.substring(Template.PREFIX.length());
		}
		return str;
	}
	
	class AllocationTree {
		
		protected List<AllocationTree> children = new ArrayList<>();
		protected Allocation allocation = null;
		protected AllocationTree parent;
		
		public AllocationTree() {
			this(null);
		}
		
		public AllocationTree(AllocationTree parent) {
			this.parent = parent;
			if (parent != null) parent.children.add(this);
		}
		
		public void allocate(List<String> values, List<String> slots) {

			for (String value : values) {
				for (String slot : slots) {
					AllocationTree child = new AllocationTree(this);
					child.setAllocation(new Allocation(slot, value));
				}
			}
			
			for (AllocationTree childTree : getChildren()) {
				List<String> newSlots = new ArrayList<>(slots);
				newSlots.remove(childTree.getAllocation().getSlot());
				
				List<String> newValues = new ArrayList<>(values);
				newValues.remove(childTree.getAllocation().getValue());
				childTree.allocate(newValues, newSlots);
			}
		}
		
		public Allocation getAllocation() {
			return allocation;
		}
		
		public void setAllocation(Allocation allocation) {
			this.allocation = allocation;
		}
		
		public List<AllocationTree> getChildren() {
			return Collections.unmodifiableList(children);
		}
		
		public AllocationTree getParent() {
			return parent;
		}
		
		public boolean isLeaf() {
			return getChildren().isEmpty();
		}
		
		public List<AllocationTree> getLeafs() {
			if (isLeaf()) {
				return Arrays.asList(this);
			}
			else {
				ArrayList<AllocationTree> leafs = new ArrayList<>();
				for (AllocationTree childTree : getChildren()) {
					leafs.addAll(childTree.getLeafs());
				}
				return leafs;
			}
		}
		
		public List<Allocation> getAllAllocations() {
			List<Allocation> allAllocations = new ArrayList<>();
			if (allocation != null) allAllocations.add(allocation);
			
			for (AllocationTree parent = this.parent; parent != null; parent = parent.getParent()) {
				allAllocations.addAll(parent.getAllAllocations());
			}
			return Collections.unmodifiableList(allAllocations);
		}
		
	}
	
	class Allocation {
		protected String value;
		protected String slot;
		
		public Allocation(String slot, String value) {
			super();
			this.slot = slot;
			this.value = value;
		}

		public String getSlot() {
			return slot;
		}
		
		public void setSlot(String slot) {
			this.slot = slot;
		}
		
		public String getValue() {
			return value;
		}
		
		public void setValue(String value) {
			this.value = value;
		}
		
	}
	
}
