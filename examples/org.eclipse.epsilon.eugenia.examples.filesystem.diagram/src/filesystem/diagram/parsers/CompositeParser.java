/*
 * 
 */
package filesystem.diagram.parsers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserEditStatus;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;

/**
 * @generated
 */
public class CompositeParser implements IParser {

	/**
	 * @generated
	 */
	private final IParser reader;

	/**
	 * @generated
	 */
	private final IParser writer;

	/**
	 * @generated
	 */
	public CompositeParser(IParser reader, IParser writer) {
		this.reader = reader;
		this.writer = writer;
	}

	/**
	 * @generated
	 */
	public boolean isAffectingEvent(Object event, int flags) {
		return reader.isAffectingEvent(event, flags);
	}

	/**
	 * @generated
	 */
	public String getPrintString(IAdaptable adapter, int flags) {
		return reader.getPrintString(adapter, flags);
	}

	/**
	 * @generated
	 */
	public String getEditString(IAdaptable adapter, int flags) {
		return reader.getEditString(adapter, flags);
	}

	/**
	 * @generated
	 */
	public IParserEditStatus isValidEditString(IAdaptable adapter,
			String editString) {
		return writer.isValidEditString(adapter, editString);
	}

	/**
	 * @generated
	 */
	public ICommand getParseCommand(IAdaptable adapter, String newString,
			int flags) {
		return writer.getParseCommand(adapter, newString, flags);
	}

	/**
	 * @generated
	 */
	public IContentAssistProcessor getCompletionProcessor(IAdaptable adapter) {
		return writer.getCompletionProcessor(adapter);
	}
}
