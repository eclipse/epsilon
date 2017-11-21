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
		
		HashMap<Object, Object> map = new HashMap<Object, Object>();
		if (bestAssignment != null) {
			for (Assignment assignment : bestAssignment) {
				if (scorer.score(assignment.getLeft(), assignment.getRight()) >= 0) {
					map.put(assignment.getLeft(), assignment.getRight());
				}
			}
		}
		return map;
	}
	
	private ArrayList<?> toArrayList(List<?> list) {
		if (list instanceof ArrayList<?>) {
			return (ArrayList<?>) list;
		}
		else {
			return new ArrayList<Object>(list);
		}
	}
	
	
	private ArrayList<ArrayList<Assignment>> calculateAssignments(ArrayList<?> leftList, ArrayList<?> rightList) {
		
		Tree<Assignment> root = new Tree<Assignment>();
		
		calculateAssignments(root, leftList, rightList);
		
		ArrayList<ArrayList<Assignment>> assignmentLists = new ArrayList<ArrayList<Assignment>>();
		
		for (ArrayList<Tree<Assignment>> path : root.getAllPaths()) {
			ArrayList<Assignment> assignmentList = new ArrayList<Assignment>();
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
			Tree<Assignment> tree = new Tree<Assignment>();
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
	
	private class Tree<T> {
		
		protected ArrayList<Tree<T>> children = new ArrayList<Tree<T>>();
		protected T value;
		
		public List<Tree<T>> getChildren() {
			return children;
		}
		
		public ArrayList<ArrayList<Tree<T>>> getAllPaths() {
			
			ArrayList<ArrayList<Tree<T>>> allPaths = new ArrayList<ArrayList<Tree<T>>>();
			
			for (Tree<T> child : getChildren()) {
				ArrayList<Tree<T>> path = new ArrayList<Tree<T>>();
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
