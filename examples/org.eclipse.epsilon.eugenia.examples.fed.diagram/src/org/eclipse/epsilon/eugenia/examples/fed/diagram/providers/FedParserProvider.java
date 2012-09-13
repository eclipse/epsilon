/*
 * 
 */
package org.eclipse.epsilon.eugenia.examples.fed.diagram.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.epsilon.eugenia.examples.fed.FedPackage;
import org.eclipse.epsilon.eugenia.examples.fed.diagram.edit.parts.FeatureNameEditPart;
import org.eclipse.epsilon.eugenia.examples.fed.diagram.edit.parts.PluginName2EditPart;
import org.eclipse.epsilon.eugenia.examples.fed.diagram.edit.parts.PluginNameEditPart;
import org.eclipse.epsilon.eugenia.examples.fed.diagram.parsers.MessageFormatParser;
import org.eclipse.epsilon.eugenia.examples.fed.diagram.part.FedVisualIDRegistry;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.GetParserOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserProvider;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserService;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.ui.services.parser.ParserHintAdapter;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class FedParserProvider extends AbstractProvider implements
		IParserProvider {

	/**
	 * @generated
	 */
	private IParser featureName_5002Parser;

	/**
	 * @generated
	 */
	private IParser getFeatureName_5002Parser() {
		if (featureName_5002Parser == null) {
			EAttribute[] features = new EAttribute[] { FedPackage.eINSTANCE
					.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			featureName_5002Parser = parser;
		}
		return featureName_5002Parser;
	}

	/**
	 * @generated
	 */
	private IParser pluginName_5003Parser;

	/**
	 * @generated
	 */
	private IParser getPluginName_5003Parser() {
		if (pluginName_5003Parser == null) {
			EAttribute[] features = new EAttribute[] { FedPackage.eINSTANCE
					.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			pluginName_5003Parser = parser;
		}
		return pluginName_5003Parser;
	}

	/**
	 * @generated
	 */
	private IParser pluginName_5001Parser;

	/**
	 * @generated
	 */
	private IParser getPluginName_5001Parser() {
		if (pluginName_5001Parser == null) {
			EAttribute[] features = new EAttribute[] { FedPackage.eINSTANCE
					.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			pluginName_5001Parser = parser;
		}
		return pluginName_5001Parser;
	}

	/**
	 * @generated
	 */
	protected IParser getParser(int visualID) {
		switch (visualID) {
		case FeatureNameEditPart.VISUAL_ID:
			return getFeatureName_5002Parser();
		case PluginNameEditPart.VISUAL_ID:
			return getPluginName_5003Parser();
		case PluginName2EditPart.VISUAL_ID:
			return getPluginName_5001Parser();
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
			return getParser(FedVisualIDRegistry.getVisualID(vid));
		}
		View view = (View) hint.getAdapter(View.class);
		if (view != null) {
			return getParser(FedVisualIDRegistry.getVisualID(view));
		}
		return null;
	}

	/**
	 * @generated
	 */
	public boolean provides(IOperation operation) {
		if (operation instanceof GetParserOperation) {
			IAdaptable hint = ((GetParserOperation) operation).getHint();
			if (FedElementTypes.getElement(hint) == null) {
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
