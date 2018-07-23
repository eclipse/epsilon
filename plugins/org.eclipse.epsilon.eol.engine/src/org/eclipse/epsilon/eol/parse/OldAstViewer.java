/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.eol.parse;

import java.awt.Component;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeCellRenderer;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.common.util.StringUtil;


public class OldAstViewer extends JFrame{
	JTree tree = new JTree();
	
	//TODO: Add support for viewing properties of RichAst
	public OldAstViewer(AST ast){
		
		tree.setModel(new ASTModel(ast));
		tree.setCellRenderer(new ASTTreeCellRenderer());
		this.getContentPane().add(new JScrollPane(tree));
		
		this.setTitle("AST Viewer");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100,100,500,500);
		this.setVisible(true);
	} 
	 
	class ASTModel implements TreeModel{
		
		private AST ast = null;
		
		public ASTModel(AST ast){
			this.ast = ast;
		}
		
		public AST toAST(Object o){
			return (AST) o;
		}
		
		public Object getRoot() {
			return ast;
		}

		public Object getChild(Object arg0, int arg1) {
			AST child = toAST(arg0).getFirstChild();
			for (int i=0;i<arg1;i++){
				child = child.getNextSibling();
				if (child == null) return ((AST)arg0).getAnnotationsAst();
			}
			return child;
		}

		public int getChildCount(Object arg0) {
			if (((AST) arg0).getAnnotationsAst() != null) {
				return toAST(arg0).getNumberOfChildren() + 1;
			}
			else {
				return toAST(arg0).getNumberOfChildren();
			}
		}

		public boolean isLeaf(Object arg0) {
			return toAST(arg0).getNumberOfChildren() == 0;
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

	class ASTTreeCellRenderer implements TreeCellRenderer{

		public Component getTreeCellRendererComponent(JTree arg0, Object arg1, boolean selected, boolean expanded, boolean leaf, int row, boolean arg6) {
			JLabel label = new JLabel();
			
			AST ast = (AST) arg1;
			
			if (selected){
				label.setOpaque(true);
				label.setBackground(SystemColor.activeCaption);
				label.setForeground(SystemColor.activeCaptionText);
			}
			
			label.setIcon(new ImageIcon(ASTTreeCellRenderer.class.getResource("node.gif")));
			
			label.setText("<html>" +
					getText(ast) 
					+ " (" + ast.getType() + ")"
					+ "<font color='#C0C0C0'>"
					+ " (Line:" + ast.getLine() + ",Col:" 
					+ ast.getColumn() //+ ", Props: "
					//+ toString(((EolAst) ast).getProperties())
					//+ (ast instanceof FileAst ? ((FileAst) ast).getFile().getAbsolutePath() : "")
					+ ")"
					+ "</font>"
					+ "</html>");
			
			return label;
		}
		
		private String getText(AST ast){
			String str = StringUtil.escapeHtml(ast.getText());
			str = str.replaceAll("\r", "<font color='#336699'>\\\\r</font>");
			str = str.replaceAll("\n", "<font color='#336699'>\\\\n</font>");
			str = str.replaceAll("\t", "<font color='#336699'>\\\\t</font>");
			return str;
		}
	}
	
	
	
}
