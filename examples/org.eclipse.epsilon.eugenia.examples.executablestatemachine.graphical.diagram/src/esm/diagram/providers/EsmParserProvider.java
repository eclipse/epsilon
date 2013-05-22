/*
 * 
 */
package esm.diagram.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.GetParserOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserProvider;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserService;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.ui.services.parser.ParserHintAdapter;
import org.eclipse.gmf.runtime.notation.View;

import esm.EsmPackage;
import esm.diagram.edit.parts.EndStateNameEditPart;
import esm.diagram.edit.parts.StateNameEditPart;
import esm.diagram.edit.parts.TransitionActionEditPart;
import esm.diagram.parsers.ActionXtext2GmfParser;
import esm.diagram.parsers.MessageFormatParser;
import esm.diagram.part.EsmVisualIDRegistry;

/**
 * @generated
 */
public class EsmParserProvider extends AbstractProvider implements
		IParserProvider {

	/**
	 * @generated
	 */
	private IParser endStateName_5002Parser;

	/**
	 * @generated
	 */
	private IParser getEndStateName_5002Parser() {
		if (endStateName_5002Parser == null) {
			EAttribute[] features = new EAttribute[] { EsmPackage.eINSTANCE
					.getState_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			endStateName_5002Parser = parser;
		}
		return endStateName_5002Parser;
	}

	/**
	 * @generated
	 */
	private IParser stateName_5001Parser;

	/**
	 * @generated
	 */
	private IParser getStateName_5001Parser() {
		if (stateName_5001Parser == null) {
			EAttribute[] features = new EAttribute[] { EsmPackage.eINSTANCE
					.getState_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			stateName_5001Parser = parser;
		}
		return stateName_5001Parser;
	}

	/**
	 * @generated
	 */
	private IParser transitionAction_6001Parser;

	/**
	 * @generated
	 */
	private IParser getTransitionAction_6001Parser() {
		if (transitionAction_6001Parser == null) {
			EAttribute[] features = new EAttribute[] { EsmPackage.eINSTANCE
					.getTransition_Action() };
			ActionXtext2GmfParser parser = new ActionXtext2GmfParser(features);
			transitionAction_6001Parser = parser;
		}
		return transitionAction_6001Parser;
	}

	/**
	 * @generated
	 */
	protected IParser getParser(int visualID) {
		switch (visualID) {
		case EndStateNameEditPart.VISUAL_ID:
			return getEndStateName_5002Parser();
		case StateNameEditPart.VISUAL_ID:
			return getStateName_5001Parser();
		case TransitionActionEditPart.VISUAL_ID:
			return getTransitionAction_6001Parser();
		}
		return null;
	}

	/**
	 * Utility method that consults ParserService
	 * @generated
	 */
	public static IParser getParser(IElementType type, EObject object,
			String parserHint) {
		return ParserService.getInstance().getParser(
				new HintAdapter(type, object, parserHint));
	}

	/**
	 * @generated
	 */
	public IParser getParser(IAdaptable hint) {
		String vid = (String) hint.getAdapter(String.class);
		if (vid != null) {
			return getParser(EsmVisualIDRegistry.getVisualID(vid));
		}
		View view = (View) hint.getAdapter(View.class);
		if (view != null) {
			return getParser(EsmVisualIDRegistry.getVisualID(view));
		}
		return null;
	}

	/**
	 * @generated
	 */
	public boolean provides(IOperation operation) {
		if (operation instanceof GetParserOperation) {
			IAdaptable hint = ((GetParserOperation) operation).getHint();
			if (EsmElementTypes.getElement(hint) == null) {
				return false;
			}
			return getParser(hint) != null;
		}
		return false;
	}

	/**
	 * @generated
	 */
	private static class HintAdapter extends ParserHintAdapter {

		/**
		 * @generated
		 */
		private final IElementType elementType;

		/**
		 * @generated
		 */
		public HintAdapter(IElementType type, EObject object, String parserHint) {
			super(object, parserHint);
			assert type != null;
			elementType = type;
		}

		/**
		 * @generated
		 */
		public Object getAdapter(Class adapter) {
			if (IElementType.class.equals(adapter)) {
				return elementType;
			}
			return super.getAdapter(adapter);
		}
	}

}
