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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AssignmentCalculator {
	
	public static void main(String[] args) {
		
		Map<Object, Object> assignment = new AssignmentCalculator().calculateAssignment(Arrays.asList(10, 20), Arrays.asList(5,6,7), new AssignmentScorer() {
			
			@Override
			public float score(Object left, Object right) {
				Integer leftInt = (Integer) left;
				Integer rightInt = (Integer) right;
				
				if (leftInt > rightInt) {
					return rightInt / (float) leftInt;
				}
				else {
					return -1;
				}
			}
		});
		
		for (Object key : assignment.keySet()) {
			System.out.println(key + "->" + assignment.get(key));
		}
	}
	
	public Map<Object, Object> calculateAssignment(List<?> leftList, List<?> rightList, AssignmentScorer scorer) {
		ArrayList<?> leftArrayList = toArrayList(leftList);
		ArrayList<?> rightArrayList = toArrayList(rightList);
		List<Assignment> bestAssignment = null;
		float maxScore = Float.NEGATIVE_INFINITY;
		
		for (List<Assignment> assignmentList : calculateAssignments(leftArrayList, rightArrayList)) {
			float score = 0;
			for (Assignment assignment : assignmentList) {
				score += scorer.score(assignment.getLeft(), assignment.getRight());
			}
			if (score > maxScore) {
				maxScore = score;
				bestAssignment = assignmentList;
			}
		}
		
		HashMap<Object, Object> map = new HashMap<>();
		if (bestAssignment != null) {
			for (Assignment assignment : bestAssignment) {
				if (scorer.score(assignment.getLeft(), assignment.getRight()) >= 0) {
					map.put(assignment.getLeft(), assignment.getRight());
				}
			}
		}
		return map;
	}
	
	private static ArrayList<?> toArrayList(List<?> list) {
		if (list instanceof ArrayList<?>) {
			return (ArrayList<?>) list;
		}
		else {
			return new ArrayList<Object>(list);
		}
	}
	
	
	private ArrayList<ArrayList<Assignment>> calculateAssignments(ArrayList<?> leftList, ArrayList<?> rightList) {
		
		Tree<Assignment> root = new Tree<>();
		
		calculateAssignments(root, leftList, rightList);
		
		ArrayList<ArrayList<Tree<Assignment>>> allPaths = root.getAllPaths();
		ArrayList<ArrayList<Assignment>> assignmentLists = new ArrayList<>(allPaths.size());
		
		for (ArrayList<Tree<Assignment>> path : allPaths) {
			ArrayList<Assignment> assignmentList = new ArrayList<>(path.size());
			for (Tree<Assignment> tree : path) {
				assignmentList.add(tree.getValue());
			}
			assignmentLists.add(assignmentList);
		}
		
		return assignmentLists;
	}
	
	private void calculateAssignments(Tree<Assignment> parent, ArrayList<?> leftList, ArrayList<?> rightList) {
		
		if (leftList.size() == 0) return;
		
		Object firstLeft = leftList.get(0);
		for (Object right : rightList) {
			Tree<Assignment> tree = new Tree<>();
			tree.setValue(new Assignment(firstLeft, right));
			parent.getChildren().add(tree);
			
			ArrayList<Object> newLeftList = (ArrayList<Object>) leftList.clone();
			newLeftList.remove(firstLeft);
			ArrayList<Object> newRightList = (ArrayList<Object>) rightList.clone();
			newRightList.remove(right);
			
			calculateAssignments(tree, newLeftList, newRightList);
			
		}
	}
	
	public interface AssignmentScorer {
		
		public float score(Object left, Object right);
		
	}
	
	class Tree<T> {
		
		protected ArrayList<Tree<T>> children = new ArrayList<>();
		protected T value;
		
		public List<Tree<T>> getChildren() {
			return children;
		}
		
		public ArrayList<ArrayList<Tree<T>>> getAllPaths() {
			
			ArrayList<ArrayList<Tree<T>>> allPaths = new ArrayList<>();
			
			for (Tree<T> child : getChildren()) {
				ArrayList<Tree<T>> path = new ArrayList<>();
				path.add(child);
				collectAllPaths(path, allPaths);
			}
			
			return allPaths;
		}
		
		public void collectAllPaths(ArrayList<Tree<T>> path, ArrayList<ArrayList<Tree<T>>> allPaths) {
			Tree<T> lastElement = path.get(path.size()-1);
			if (lastElement.getChildren().isEmpty()) {
				allPaths.add(path);
			}
			else {
				for (Tree<T> child : lastElement.getChildren()) {
					ArrayList<Tree<T>> newPath = new ArrayList<Tree<T>>((List) path.clone());
					newPath.add(child);
					collectAllPaths(newPath, allPaths);
				}
			}
		}
		
		public void setValue(T value) {
			this.value = value;
		}
		
		public T getValue() {
			return value;
		}
		
	}
	
	private class Assignment {
		
		protected Object left;
		protected Object right;
		
		public Assignment(Object left, Object right) {
			this.left = left;
			this.right = right;
		}
		
		public Object getLeft() {
			return left;
		}
		
		public Object getRight() {
			return right;
		}
		
		@Override
		public String toString() {
			return left + " -> " + right;
		}
	}
	
}
