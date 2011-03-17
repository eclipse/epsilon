/*******************************************************************************
 * Copyright (c) 2011 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Antonio Garcia-Dominguez - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.eunit.dt.ui;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.eol.execute.context.Frame;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.execute.prettyprinting.PrettyPrinterManager;
import org.eclipse.epsilon.eol.parse.EolParser;
import org.eclipse.jface.viewers.StyledCellLabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.ViewerCell;

/**
 * Label provider for the failure trace tree in the EUnit view. Frames are
 * labelled using the name of the operation and the location in the file it
 * belongs to. Variables list their real types and values.
 *
 * @author Antonio García-Domínguez
 * @version 1.0
 */
class FailureTraceTreeLabelProvider extends StyledCellLabelProvider  {

	private PrettyPrinterManager prettyPrinterManager = new PrettyPrinterManager();

	@Override
	public void update(ViewerCell cell) {
		Object element = cell.getElement();

		StyledString str;
		if (element instanceof Frame) {
			str = getStyledString((Frame)element);
		}
		else if (element instanceof Variable) {
			str = getStyledString((Variable)element);
		}
		else {
			str = new StyledString(element.toString());
		}

		cell.setText(str.getString());
		cell.setStyleRanges(str.getStyleRanges());
		cell.setImage(null);
		super.update(cell);
	}

	public void setPrettyPrinterManager(PrettyPrinterManager prettyPrinterManager) {
		this.prettyPrinterManager = prettyPrinterManager;
	}

	public PrettyPrinterManager getPrettyPrinterManager() {
		return prettyPrinterManager;
	}

	private StyledString getStyledString(Variable var) {
		StyledString str = new StyledString(var.getName());
		str.append(" = ");
		if (var.getValue() != null) {
			str.append(prettyPrinterManager.print(var.getValue()));
			str.append(" : ", StyledString.QUALIFIER_STYLER);
			str.append(var.getValue().getClass().getName(), StyledString.QUALIFIER_STYLER);
		} else {
			str.append("null");
		}
		return str;
	}

	private StyledString getStyledString(Frame frame) {
		final StyledString str = new StyledString();
		final AST entryPoint = frame.getEntryPoint();
		if (entryPoint != null) {
			if (entryPoint.getType() == EolParser.HELPERMETHOD) {
				str.append(entryPoint.getFirstChild().toString());
			} else {
				str.append(entryPoint.toString());
			}

			final AST currentStmt = frame.getCurrentStatement();
			final AST point = currentStmt != null ? currentStmt : entryPoint;

			str.append(" @ ", StyledString.QUALIFIER_STYLER);
			str.append(getSourcePathForAST(point), StyledString.QUALIFIER_STYLER);
			str.append(" (", StyledString.QUALIFIER_STYLER);
			str.append(Integer.toString(point.getLine()), StyledString.QUALIFIER_STYLER);
			str.append(':', StyledString.QUALIFIER_STYLER);
			str.append(Integer.toString(point.getColumn()), StyledString.QUALIFIER_STYLER);
			str.append(")", StyledString.QUALIFIER_STYLER);
		}
		else {
			str.append("globals");
		}
		return str;
	}

	private String getSourcePathForAST(AST entryPoint) {
		IFile[] workspaceFiles = ResourcesPlugin.getWorkspace().getRoot().findFilesForLocationURI(entryPoint.getFile().toURI());
		String prettyPath = entryPoint.getFile().getPath();
		if (workspaceFiles.length > 0) {
			prettyPath = workspaceFiles[0].toString();
		}
		return prettyPath;
	}
}