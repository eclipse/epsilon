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
package org.eclipse.epsilon.commons.util;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.epsilon.commons.parse.AST;


public class AstUtil {
	
	public static int getChildrenCount(AST parent) {
		int count = 0;
		if (parent == null) return count;
		AST child = parent.getFirstChild();
		while (child != null){
			count++;
			child = child.getNextSibling();
		}
		return count;
	}
	
	public static AST getChildAt(AST parent, int index) {
		int count = 0;
		if (parent == null) return null;
		AST child = parent.getFirstChild();
		while (child != null){
			if (count == index) {
				return child;
			}
			else {
				child = child.getNextSibling();
				count++;
			}
		}
		return null;
	}
	
	public static List<AST> getChildren(AST parent){
		return getChildren(parent, -1);
	}
	
	public static List<AST> getChildrenBut(AST parent, int type){
		List<AST> children = new ArrayList<AST>();
		AST child = parent.getFirstChild();
		while (child != null){
			if (!(child.getType() == type)){
				children.add(child);
			}
			child = child.getNextSibling();
		}
		return children;
	}
	public static List<AST> getChildren(AST parent, int... type){
		List<AST> children = new ArrayList<AST>();
		
		if (parent != null) {
			AST child = parent.getFirstChild();
			while (child != null){
				for (int i=0;i<type.length;i++) {
					if (child.getType() == type[i] || type[i] == -1){
						children.add(child);
					}
				}
				child = child.getNextSibling();
			}
		}
		
		return children;
	}
	
	public static AST getChild(AST parent, int type){
		if (parent == null) return null;
		AST child = parent.getFirstChild();
		while (child != null){
			if (child.getType() == type){
				return child;
			}
			child = child.getNextSibling();
		}
		return null;
	}
	
	public static AST getFirstConcreteChild(AST parent){
		if (parent.getLine() > 0){
			return parent;
		}
		else {
			AST child = parent.getFirstChild();
			while (child != null){
				AST result = getFirstConcreteChild(child);
				if (result != null){
					return result;
				}
			}
			return null;
		}
	}
	
}
