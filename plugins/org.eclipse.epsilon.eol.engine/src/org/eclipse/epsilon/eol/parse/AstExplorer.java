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
package org.eclipse.epsilon.eol.parse;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

import org.antlr.runtime.tree.Tree;
import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.common.parse.StaticFieldNameResolver;
import org.eclipse.epsilon.common.util.StringUtil;

public class AstExplorer extends JFrame {

	StaticFieldNameResolver resolver;
	JTree jTree = new JTree();

	public AstExplorer(Tree tree, Class<?> parserClass) {
		this.resolver = new StaticFieldNameResolver(parserClass);

		jTree.setModel(new AstTreeModel(tree));
		jTree.setCellRenderer(new AstTreeCellRenderer());

		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add(new JScrollPane(jTree), BorderLayout.CENTER);
		this.setTitle("AST Explorer");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(0, 0, 500, 1000);
		expandAll(jTree);
		this.setVisible(true);
	}

	public void expandAll(JTree tree) {
		int row = 0;
		while (row < tree.getRowCount()) {
			tree.expandRow(row);
			row++;
		}
	}

	class AstTreeModel implements TreeModel {

		private Tree tree = null;

		public AstTreeModel(Tree tree) {
			this.tree = tree;
		}

		public Tree toTree(Object o) {
			return (Tree) o;
		}

		public Object getRoot() {
			return tree;
		}

		public Object getChild(Object arg0, int arg1) {
			Tree child = toTree(arg0);
			return child.getChild(arg1);
		}

		public int getChildCount(Object arg0) {
			return toTree(arg0).getChildCount();
		}

		public boolean isLeaf(Object arg0) {
			return toTree(arg0).getChildCount() == 0;
		}

		public void valueForPathChanged(TreePath arg0, Object arg1) {
		}

		public int getIndexOfChild(Object arg0, Object arg1) {
			return 0;
		}

		public void addTreeModelListener(TreeModelListener arg0) {

		}

		public void removeTreeModelListener(TreeModelListener arg0) {

		}

	}

	class AstTreeCellRenderer extends DefaultTreeCellRenderer {

		public Component getTreeCellRendererComponent(JTree arg0, Object arg1,
				boolean selected, boolean expanded, boolean leaf, int row,
				boolean arg6) {
			JLabel label = (JLabel) super.getTreeCellRendererComponent(arg0, arg1, selected, expanded, leaf, row, arg6);

			AST ast = (AST) arg1;
			
			label.setIcon(new ImageIcon(AstTreeCellRenderer.class
					.getResource("node.gif")));
			
			String color = "#C0C0C0";
			if (ast.getClass().getSimpleName().equals("AST") && !ast.isImaginary()) color = "red";
			
			label.setText("<html>" + "[" + ast.getClass().getSimpleName() + "] " + getText(ast) + " ("
					+ resolver.getField(ast.getType()) + "-" + ast.getType()
					+ ")" + "<font color='" + color + "'>"
					+ " (Line:" + ast.getLine() + ", Col:" + ast.getCharPositionInLine() // +
					// ", Props: "
					// + toString(((EolAst) ast).getProperties())
					// + (ast instanceof FileAst ? ((FileAst)
					// ast).getFile().getAbsolutePath() : "")
					+ ", Region:" + ast.getRegion().getStart() + "->" + ast.getRegion().getEnd()
					+ ", Imaginary:" + ast.isImaginary() 
					+ ", Extra tokens:" + ast.getExtraTokens().toString()
					+ ", Token type:" + ast.getToken().getClass().getSimpleName()
					+ ")"
					// + StringUtil.toString(ast.getNextSibling())
					+ "</font>" + "</html>");

			return label;
		}

		private String getText(Tree ast) {
			String str = StringUtil.escapeHtml(ast.getText());
			str = str.replaceAll("\r", "<font color='#336699'>\\\\r</font>");
			str = str.replaceAll("\n", "<font color='#336699'>\\\\n</font>");
			str = str.replaceAll("\t", "<font color='#336699'>\\\\t</font>");
			return str;
		}
	}

}
