package org.eclipse.epsilon.flexmi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

public class AttributeStructuralFeatureAllocator {
	
	protected StringSimilarityProvider stringSimilarityProvider = new CachedStringSimilarityProvider(new DefaultStringSimilarityProvider());
	
	public static void main(String[] args) {
		Map<String, String> allocation = new AttributeStructuralFeatureAllocator().allocate(Arrays.asList("b", "c", "name"),  Arrays.asList("a", "b", "nc"));
		for (String key : allocation.keySet()) {
			System.out.println(key + "->" + allocation.get(key));
		}
	}
	
	public Map<Node, EStructuralFeature> allocate(NamedNodeMap attributes, List<EStructuralFeature> structuralFeatures) {
		
		List<String> attributeNames = new ArrayList<String>();
		for (int i=0;i<attributes.getLength();i++) {
			attributeNames.add(attributes.item(i).getNodeName());
		}
		
		List<String> structuralFeatureNames = new ArrayList<String>();
		for (EStructuralFeature feature : structuralFeatures) {
			structuralFeatureNames.add(feature.getName());
		}
		
		Map<String, String> nameAllocation = allocate(attributeNames, structuralFeatureNames);
		
		HashMap<Node, EStructuralFeature> allocation = new HashMap<Node, EStructuralFeature>();
		
		for (String attributeName : nameAllocation.keySet()) {
			String structuralFeatureName = nameAllocation.get(attributeName);
			EStructuralFeature feature = null;
			for (EStructuralFeature f : structuralFeatures) {
				if (structuralFeatureName.equals(f.getName())) {
					feature = f;
					break;
				}
			}
			allocation.put(attributes.getNamedItem(attributeName), feature);
		}
		
		return allocation;
		
	}
	
	public Map<String, String> allocate(List<String> values, List<String> slots) {
		AllocationTree tree = new AllocationTree();
		tree.allocate(values, slots);
		int bestSimilarity = -1;
		AllocationTree bestAllocation = null;
		for (AllocationTree leaf : tree.getLeafs()) {
			int similarity = 0;
			for (Allocation allocation : leaf.getAllAllocations()) {
				similarity += stringSimilarityProvider.getSimilarity(allocation.getSlot(), allocation.getValue());
			}
			if (similarity > bestSimilarity) {
				bestAllocation = leaf;
				bestSimilarity = similarity;
			}
		}
		
		HashMap<String, String> result = new HashMap<String, String>();
		if (bestAllocation != null) {
			for (Allocation allocation : bestAllocation.getAllAllocations()) {
				result.put(allocation.getValue(), allocation.getSlot());
			}
		}
		return result;
		
	}
	
	
	class AllocationTree {
		
		protected List<AllocationTree> children = new ArrayList<AttributeStructuralFeatureAllocator.AllocationTree>();
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
				List<String> newSlots = new ArrayList<String>(slots);
				newSlots.remove(childTree.getAllocation().getSlot());
				List<String> newValues = new ArrayList<String>(values);
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
		
		public void print() {
			print(-1);
		}
		
		protected void print(int indentation) {
			for (int i=0;i<indentation;i++) { System.out.print("\t"); }
			if (allocation != null) System.out.println(allocation.getValue() + "->" + allocation.getSlot());
			for (AllocationTree child : getChildren()) {
				child.print(indentation + 1);
			}
		}
		
		public boolean isLeaf() {
			return getChildren().isEmpty();
		}
		
		public List<AllocationTree> getLeafs() {
			if (isLeaf()) {
				return Arrays.asList(this);
			}
			else {
				ArrayList<AllocationTree> leafs = new ArrayList<AllocationTree>();
				for (AllocationTree childTree : getChildren()) {
					leafs.addAll(childTree.getLeafs());
				}
				return leafs;
			}
		}
		
		public List<Allocation> getAllAllocations() {
			List<Allocation> allAllocations = new ArrayList<Allocation>();
			if (allocation != null) allAllocations.add(allocation);
			AllocationTree parent = this.parent;
			while (parent != null) {
				allAllocations.addAll(parent.getAllAllocations());
				parent = parent.getParent();
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
