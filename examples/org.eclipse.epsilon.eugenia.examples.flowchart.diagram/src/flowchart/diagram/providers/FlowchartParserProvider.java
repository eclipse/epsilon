/*
 * 
 */
package flowchart.diagram.providers;

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

import flowchart.FlowchartPackage;
import flowchart.diagram.edit.parts.DecisionNameEditPart;
import flowchart.diagram.edit.parts.SubflowNameEditPart;
import flowchart.diagram.edit.parts.TransitionNameEditPart;
import flowchart.diagram.parsers.MessageFormatParser;
import flowchart.diagram.part.FlowchartVisualIDRegistry;

/**
 * @generated
 */
public class FlowchartParserProvider extends AbstractProvider implements
		IParserProvider {

	/**
	 * @generated
	 */
	private IParser subflowName_5001Parser;

	/**
	 * @generated
	 */
	private IParser getSubflowName_5001Parser() {
		if (subflowName_5001Parser == null) {
			EAttribute[] features = new EAttribute[] { FlowchartPackage.eINSTANCE
					.getNode_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			subflowName_5001Parser = parser;
		}
		return subflowName_5001Parser;
	}

	/**
	 * @generated
	 */
	private IParser decisionName_5003Parser;

	/**
	 * @generated
	 */
	private IParser getDecisionName_5003Parser() {
		if (decisionName_5003Parser == null) {
			EAttribute[] features = new EAttribute[] { FlowchartPackage.eINSTANCE
					.getNode_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			decisionName_5003Parser = parser;
		}
		return decisionName_5003Parser;
	}

	/**
	 * @generated
	 */
	private IParser transitionName_6001Parser;

	/**
	 * @generated
	 */
	private IParser getTransitionName_6001Parser() {
		if (transitionName_6001Parser == null) {
			EAttribute[] features = new EAttribute[] { FlowchartPackage.eINSTANCE
					.getTransition_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			transitionName_6001Parser = parser;
		}
		return transitionName_6001Parser;
	}

	/**
	 * @generated
	 */
	protected IParser getParser(int visualID) {
		switch (visualID) {
		case SubflowNameEditPart.VISUAL_ID:
			return getSubflowName_5001Parser();
		case DecisionNameEditPart.VISUAL_ID:
			return getDecisionName_5003Parser();
		case TransitionNameEditPart.VISUAL_ID:
			return getTransitionName_6001Parser();
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
			return getParser(FlowchartVisualIDRegistry.getVisualID(vid));
		}
		View view = (View) hint.getAdapter(View.class);
		if (view != null) {
			return getParser(FlowchartVisualIDRegistry.getVisualID(view));
		}
		return null;
	}

	/**
	 * @generated
	 */
	public boolean provides(IOperation operation) {
		if (operation instanceof GetParserOperation) {
			IAdaptable hint = ((GetParserOperation) operation).getHint();
			if (FlowchartElementTypes.getElement(hint) == null) {
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
