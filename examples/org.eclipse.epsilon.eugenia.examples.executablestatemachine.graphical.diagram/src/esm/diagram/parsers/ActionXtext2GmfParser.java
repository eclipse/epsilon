/*
 * 
 */
package esm.diagram.parsers;

import java.util.Arrays;
import java.util.Collection;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.epsilon.eugenia.examples.executablestatemachine.glue.ActionGlue;
import org.eclipse.epsilon.eugenia.examples.executablestatemachine.glue.ActionParser;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserEditStatus;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserEditStatus;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;

import org.eclipse.gmf.tooling.runtime.parsers.AbstractAttributeParser;
import esm.diagram.part.EsmDiagramEditorPlugin;

/**
 * @generated
 */
public class ActionXtext2GmfParser extends AbstractAttributeParser {

	/**
	 * @generated
	 */
	private ActionParser parser = ActionParser.create();

	/**
	 * @generated
	 */
	private ActionGlue glue = new ActionGlue();

	/**
	 * @generated
	 */
	public ActionXtext2GmfParser(EAttribute[] features) {
		super(features);
		if (features.length != 1) {
			throw new IllegalArgumentException(Arrays.toString(features));
		}
	}

	/**
	 * @generated
	 */
	public ActionXtext2GmfParser(EAttribute[] features,
			EAttribute[] editableFeatures) {
		super(features, editableFeatures);
		if (features.length != 1) {
			throw new IllegalArgumentException(Arrays.toString(features));
		}
		if (editableFeatures.length != 1) {
			throw new IllegalArgumentException(
					Arrays.toString(editableFeatures));
		}
	}

	/**
	 * @generated
	 */
	public String getEditString(IAdaptable adapter, int flags) {
		EObject element = (EObject) adapter.getAdapter(EObject.class);
		String s = EcoreUtil.convertToString(
				editableFeatures[0].getEAttributeType(),
				element.eGet(editableFeatures[0]));
		return s != null ? s : ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	public IParserEditStatus isValidEditString(IAdaptable adapter,
			String editString) {
		final Collection<?> issues = parser.validate(editString);

		if (issues.isEmpty()) {
			return ParserEditStatus.EDITABLE_STATUS;
		} else {
			return new ParserEditStatus(EsmDiagramEditorPlugin.ID,
					IParserEditStatus.UNEDITABLE, issues.toString());
		}
	}

	/**
	 * @generated
	 */
	public ICommand getParseCommand(IAdaptable adapter, String newString,
			int flags) {
		Object value = EcoreUtil.createFromString(
				editableFeatures[0].getEAttributeType(), newString);
		ICommand textCommand = getParseCommand(adapter, new Object[] { value },
				flags);
		EObject modelElement = (EObject) adapter.getAdapter(EObject.class);
		SetRequest request = new SetRequest(modelElement,
				glue.targetFor(features), parser.parse(newString));
		SetValueCommand setValueCommand = new SetValueCommand(request);
		return textCommand.compose(setValueCommand);
	}

	/**
	 * @generated
	 */
	public String getPrintString(IAdaptable adapter, int flags) {
		EObject element = (EObject) adapter.getAdapter(EObject.class);
		String s = EcoreUtil.convertToString(features[0].getEAttributeType(),
				element.eGet(features[0]));
		return s != null ? s : ""; //$NON-NLS-1$
	}

}
