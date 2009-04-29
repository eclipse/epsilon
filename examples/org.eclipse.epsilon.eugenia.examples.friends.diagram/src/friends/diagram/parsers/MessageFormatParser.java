/*******************************************************************************
 * Copyright (c) 2009 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package friends.diagram.parsers;

import java.text.FieldPosition;
import java.text.MessageFormat;
import java.text.ParsePosition;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserEditStatus;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserEditStatus;
import org.eclipse.osgi.util.NLS;

import friends.diagram.part.FriendsDiagramEditorPlugin;
import friends.diagram.part.Messages;

/**
 * @generated
 */
public class MessageFormatParser extends AbstractParser {

	/**
	 * @generated
	 */
	private String defaultPattern;

	/**
	 * @generated
	 */
	private MessageFormat viewProcessor;

	/**
	 * @generated
	 */
	private MessageFormat editorProcessor;

	/**
	 * @generated
	 */
	private MessageFormat editProcessor;

	/**
	 * @generated
	 */
	public MessageFormatParser(EAttribute[] features) {
		super(features);
	}

	/**
	 * @generated
	 */
	protected String getDefaultPattern() {
		if (defaultPattern == null) {
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < features.length; i++) {
				if (i > 0) {
					sb.append(' ');
				}
				sb.append('{');
				sb.append(i);
				sb.append('}');
			}
			defaultPattern = sb.toString();
		}
		return defaultPattern;
	}

	/**
	 * @generated
	 */
	public String getViewPattern() {
		String pattern = super.getViewPattern();
		return pattern != null ? pattern : getDefaultPattern();
	}

	/**
	 * @generated
	 */
	public void setViewPattern(String viewPattern) {
		super.setViewPattern(viewPattern);
		viewProcessor = null;
	}

	/**
	 * @generated
	 */
	protected MessageFormat createViewProcessor(String viewPattern) {
		return new MessageFormat(viewPattern);
	}

	/**
	 * @generated
	 */
	protected MessageFormat getViewProcessor() {
		if (viewProcessor == null) {
			viewProcessor = createViewProcessor(getViewPattern());
		}
		return viewProcessor;
	}

	/**
	 * @generated
	 */
	public String getEditorPattern() {
		String pattern = super.getEditorPattern();
		return pattern != null ? pattern : getDefaultPattern();
	}

	/**
	 * @generated
	 */
	public void setEditorPattern(String editorPattern) {
		super.setEditorPattern(editorPattern);
		editorProcessor = null;
	}

	/**
	 * @generated
	 */
	protected MessageFormat createEditorProcessor(String editorPattern) {
		return new MessageFormat(editorPattern);
	}

	/**
	 * @generated
	 */
	protected MessageFormat getEditorProcessor() {
		if (editorProcessor == null) {
			editorProcessor = createEditorProcessor(getEditorPattern());
		}
		return editorProcessor;
	}

	/**
	 * @generated
	 */
	public String getEditPattern() {
		String pattern = super.getEditPattern();
		return pattern != null ? pattern : getDefaultPattern();
	}

	/**
	 * @generated
	 */
	public void setEditPattern(String editPattern) {
		super.setEditPattern(editPattern);
		editProcessor = null;
	}

	/**
	 * @generated
	 */
	protected MessageFormat createEditProcessor(String editPattern) {
		return new MessageFormat(editPattern);
	}

	/**
	 * @generated
	 */
	protected MessageFormat getEditProcessor() {
		if (editProcessor == null) {
			editProcessor = createEditProcessor(getEditPattern());
		}
		return editProcessor;
	}

	/**
	 * @generated
	 */
	public String getPrintString(IAdaptable adapter, int flags) {
		EObject element = (EObject) adapter.getAdapter(EObject.class);
		return getViewProcessor().format(getValues(element),
				new StringBuffer(), new FieldPosition(0)).toString();
	}

	/**
	 * @generated
	 */
	public String getEditString(IAdaptable adapter, int flags) {
		EObject element = (EObject) adapter.getAdapter(EObject.class);
		return getEditorProcessor().format(getValues(element),
				new StringBuffer(), new FieldPosition(0)).toString();
	}

	/**
	 * @generated
	 */
	public IParserEditStatus isValidEditString(IAdaptable adapter,
			String editString) {
		ParsePosition pos = new ParsePosition(0);
		Object[] values = getEditProcessor().parse(editString, pos);
		if (values == null) {
			return new ParserEditStatus(FriendsDiagramEditorPlugin.ID,
					IParserEditStatus.UNEDITABLE, NLS.bind(
							Messages.MessageFormatParser_InvalidInputError,
							new Integer(pos.getErrorIndex())));
		}
		return validateNewValues(values);
	}

	/**
	 * @generated
	 */
	public ICommand getParseCommand(IAdaptable adapter, String newString,
			int flags) {
		Object[] values = getEditProcessor().parse(newString,
				new ParsePosition(0));
		return getParseCommand(adapter, values, flags);
	}
}
