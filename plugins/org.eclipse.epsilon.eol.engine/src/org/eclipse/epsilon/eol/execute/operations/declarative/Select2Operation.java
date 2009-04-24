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
package org.eclipse.epsilon.eol.execute.operations.declarative;

import java.awt.Dialog.ModalExclusionType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.eol.EolEvaluator;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.FrameStack;
import org.eclipse.epsilon.eol.execute.context.FrameType;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.execute.operations.AbstractOperation;
import org.eclipse.epsilon.eol.parse.AstViewer;
import org.eclipse.epsilon.eol.types.EolAnyType;
import org.eclipse.epsilon.eol.types.EolBoolean;
import org.eclipse.epsilon.eol.types.EolCollection;
import org.eclipse.epsilon.eol.types.EolType;
import org.eclipse.epsilon.eol.types.EolString;

public class Select2Operation extends AbstractOperation {
	
	
	public static void main(String[] args) {
		
		EolEvaluator evaluator = new EolEvaluator();
		evaluator.execute("Sequence{1,2,3}.select2(x,y|x > 2).println();");
		
	}
	
	public static void main2(String[] args) {
		
		Collection<Integer> numbers1 = new ArrayList<Integer>();
		numbers1.add(1);
		numbers1.add(2);
		numbers1.add(3);
		
		Collection<Integer> numbers2 = new ArrayList<Integer>();
		numbers2.add(1);
		numbers2.add(2);
		numbers2.add(3);
		
		//System.err.println(combinations(numbers));
		
		littleDemo();
	}
	
	public static Collection<Collection<Integer>> combinations (Collection<Collection<Integer>> c) {
		
		
		return null;
	}
	
	protected boolean returnOnFirstMatch = false;
	
	public boolean isReturnOnFirstMatch() {
		return returnOnFirstMatch;
	}


	public void setReturnOnFirstMatch(boolean returnOnFirstMatch) {
		this.returnOnFirstMatch = returnOnFirstMatch;
	}

	@Override
	public Object execute(Object obj, AST ast, IEolContext context) throws EolRuntimeException{
		
		new AstViewer(ast);
		
		AST declarationsAst = ast.getFirstChild();
		AST bodyAst = declarationsAst.getNextSibling();
		
		AST declarationAst = declarationsAst.getFirstChild();
		AST iteratorNameAst = declarationAst.getFirstChild();
		AST iteratorTypeAst = iteratorNameAst.getNextSibling();
		
		String iteratorName = iteratorNameAst.getText();
		EolType iteratorType = null;
		
		if (iteratorTypeAst != null){
			iteratorType = (EolType) context.getExecutorFactory().executeAST(iteratorTypeAst,context);
		}
		else {
			iteratorType = EolAnyType.Instance;
		}
		
		EolCollection source = EolCollection.asCollection(obj);
		EolCollection result = source.createCollection();
		
		Iterator li = source.getStorage().iterator();
		FrameStack scope = context.getFrameStack();
		
		while (li.hasNext()){
			Object listItem = li.next();
			
			if (iteratorType==null || iteratorType.isKind(listItem)){
				scope.enter(FrameType.UNPROTECTED, ast);
				//scope.put(new Variable(iteratorName, listItem, iteratorType, true));
				scope.put(Variable.createReadOnlyVariable(iteratorName,listItem));
				Object bodyResult = context.getExecutorFactory().executeAST(bodyAst, context);
				if (bodyResult instanceof EolBoolean && ((EolBoolean) bodyResult).getValue()){
					result.add(listItem);
					if (isReturnOnFirstMatch()) {
						scope.leave(ast);
						return result;
					}
				}
				scope.leave(ast);
			}
		}
		
		return result;
	}

	
	/* Begin Edd's addition:
	 * Note: These operations are intended to be able to work for
	 * lists of any type, e.g., model element types, ints, etc -- however,
	 * I'm not entirely sure of the base type of the EOL system, hence
	 * I've defined the operations to simply work over Objects. Feel free
	 * to change this as necessary! Ta...
	 */
	
	/*
	 * The operations below contains demonstrates generation of 
	 * lists of *ordered* lists for arbitrary lists of lists.
	 * The purpose of doing this follows from ET/DK talks in York on 23 March,
	 * where ET noted it might be possible (?!) to remove redundant EVL checks
	 * when there are multiple contexts, e.g., checking some constraint 
	 * for some pair of objects (objA, objB) only and not vice-versa.
	 *  
	 *  Side note:
	 *  Currently working over ArrayList<ArrayList<Object>> elements. It is assumed that
	 *  in future Object would be replaced by the super type of all Epsilon model elements,
	 *  e.g., EolType... I wasn't sure so cheated and stuck in Object ;) ??
	 *  
	 *  So what is the reduction in num of checks??
	 *  I believe for a list of list of Strings L = [X1,...,Xn], where X1,...,Xn are 
	 *  themselves lists of Strings, the size of the resulting collection will be:
	 *  |X1| x ... x |Xn|, or in general (in latex):
	 *  $\Pi_{l \in L} |l|$
	 *  (where \Pi is the standard product of a series of terms 
	 *  (see wikipedia "Capital pi notation" for more info if ya want: http://en.wikipedia.org/wiki/Multiplication)
	 *  
	 *  If we do not do this ordering, and we evaluate all permutations, then there are (I believe)
	 *  (|X1| x |X2| x |X3|) x |L|! orderings, or in general:
	 *  $(\Pi_{l \in L} \mid l\mid) \times \mid L! \mid$
	 *  
	 *  So the reduction in the number of evaluations is proportional to the factorial of the size of L.
	 *  
	 *  Small example L = [[a1,a2], [b1,b2,b3], [c1,c2,c3,c4]]
	 *  Evaluations with ordered lists:
	 *    [a1,b1,c1]
	 *    [a1,b1,c2]
	 *    ...
	 *    [a2,b1,c1]
	 *    [a2,b1,c2]
	 *    ... and so on
	 *    total = 2 x 3 x 4 = 24
	 *    
	 *  Evaluations without ordered lists:
	 *    [a1,b1,c1] [a1,c1,b1] [b1,a1,c1] [b1,c1,a1] [c1,a1,b1] [c1,b1,a1]
	 *    [a1,b1,c2] [a1,c2,b1] [b1,a1,c2] [b1,c2,a1] [c2,a1,b1] [c2,b1,a1]
	 *    ... and so on
	 *    total = (2 x 3 x 4) x 3! = 144 (i.e., more checks than when using ordered lists)
	 */
	
	/*
	 * Generate a simple ArrayList<Object> of specified size and with each 
	 * element having a specified prefix.
	 */
	public static ArrayList<Object> genSimpleCollection(int size, String prefix) {
		ArrayList<Object> arr = new ArrayList<Object>();
		for(int i = 0; i < size; i++) {
			arr.add(new EolString(prefix + i));
		}
		return arr;
	}
	
	/*
	 * Find the head of an ArrayList<ArrayList<Object>>
	 */
	public static ArrayList<Object> head(ArrayList<ArrayList<Object>> arr) {
		if(arr.size() == 0) {
			return new ArrayList<Object>();
		}
		else {
			return arr.get(0);
		}
	}
	
	/*
	 * Find the tail of an ArrayList<ArrayList<String>>
	 */
	public static ArrayList<ArrayList<Object>> tail(ArrayList<ArrayList<Object>> arr) {
		if(arr.size() < 2) {
			return new ArrayList<ArrayList<Object>>();
		}
		else {
			ArrayList<ArrayList<Object>> toReturn = new ArrayList<ArrayList<Object>>();
			for(int i = 0; i < arr.size(); i++) {
				if(i > 0) {
					toReturn.add(arr.get(i));
				}
			}
			return toReturn;
		}
	}
	
	public static ArrayList<ArrayList<Object>> getCombinations(ArrayList<ArrayList<Object>> arr) {
		return getCombinations(arr, new ArrayList<ArrayList<Object>>());
	}
	
	 /*
	 -- The idea is to pass to this operation to, say, [[a1,a2],[b1,b2]] and an empty ArrayList
	 -- and have returned [[a1,b1],[a1,b2],[a2,b1],[a2,b2]]
	 -- It takes as parameter currentResult: the result to eventually return, as computed so far.
	 -- Basically, a tree-like structure is built-up in a breadth first fashion.
	 ------------
	 -- So, as an example:
	 -- arr = [[a1,a2],[b1,b2]]
	 ------------
	 -- Then, on first call:
	 -- head of arr = [a1,a2]
	 -- currentResult@pre = [], currentResult@post = [[a1],[a2]]
	 ------------
	 -- On second call:
	 -- head = [b1,b2]
	 -- currentResult@pre = [[a1],[a2]], currentResult@post = [[a1,b1],[a1,b2],[a2,b1],[a2,b2]]
	 ------------
	 -- On third call:
	 -- head = []
	 -- thing_to_return = currentResult = [[a1,b1],[a1,b2],[a2,b1],[a2,b2]]
	 ------------
	 */
	public static ArrayList<ArrayList<Object>> getCombinations(ArrayList<ArrayList<Object>> arr, ArrayList<ArrayList<Object>> currentResult) {
		if(arr.isEmpty()) { // finished processing
			return currentResult;
		}
		else {
			ArrayList<Object> head = head(arr);
			ArrayList<ArrayList<Object>> newList = new ArrayList<ArrayList<Object>>();
			
			if(currentResult.isEmpty()) { // typically true on first call of getCollections
				for(Object h : head) {
					ArrayList<Object> newSubList = new ArrayList<Object>();
					newSubList.add(h);
					newList.add(newSubList);
				}
			}
			else {
				for(ArrayList<Object> c : currentResult) {
					for(Object h : head) {
						ArrayList<Object> newSubList = new ArrayList<Object>();
						newSubList.addAll(c);
						newSubList.add(h);
						newList.add(newSubList);
					}
				}
			}
			
			return getCombinations(tail(arr), newList);
		}
	}
	
	public static void printCollections(ArrayList<ArrayList<Object>> arr) {
		System.out.println("================================");
		System.out.println("   -- Printing Combinations --   ");
		for(ArrayList<Object> c : arr) {
			System.out.println(c.toString());
		}
		System.out.println("  -- Printed "+arr.size()+" Combinations --   ");
		System.out.println("================================");
	}
	
	public static void littleDemo() {
		ArrayList<ArrayList<Object>> arr = new ArrayList<ArrayList<Object>>();
		arr.add(genSimpleCollection(2,"a"));
		arr.add(genSimpleCollection(3,"b"));
		arr.add(genSimpleCollection(4,"c"));
		//arr.add(genSimpleCollection(6,"d"));
		
		
		System.out.println("Input collection = "+ arr);
		//System.out.println(head(arr));
		//System.out.println(tail(arr));
		
		ArrayList<ArrayList<Object>> res = getCombinations(arr);
		printCollections(res);
	}
}
