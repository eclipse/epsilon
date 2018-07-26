/*********************************************************************
* Copyright (c) 2008 The University of York.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual.actions.ActionsPackage;
import org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual.actions.Dec;
import org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual.actions.If;
import org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual.actions.Inc;
import org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual.actions.Print;
import org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual.actions.Set;
import org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual.services.ActionsGrammarAccess;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticNodeProvider.INodesForEObjectProvider;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;

@SuppressWarnings("all")
public class ActionsSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private ActionsGrammarAccess grammarAccess;
	
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == ActionsPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case ActionsPackage.DEC:
				if(context == grammarAccess.getActionRule() ||
				   context == grammarAccess.getDecRule()) {
					sequence_Dec(context, (Dec) semanticObject); 
					return; 
				}
				else break;
			case ActionsPackage.IF:
				if(context == grammarAccess.getActionRule() ||
				   context == grammarAccess.getIfRule()) {
					sequence_If(context, (If) semanticObject); 
					return; 
				}
				else break;
			case ActionsPackage.INC:
				if(context == grammarAccess.getActionRule() ||
				   context == grammarAccess.getIncRule()) {
					sequence_Inc(context, (Inc) semanticObject); 
					return; 
				}
				else break;
			case ActionsPackage.PRINT:
				if(context == grammarAccess.getActionRule() ||
				   context == grammarAccess.getPrintRule()) {
					sequence_Print(context, (Print) semanticObject); 
					return; 
				}
				else break;
			case ActionsPackage.SET:
				if(context == grammarAccess.getActionRule() ||
				   context == grammarAccess.getSetRule()) {
					sequence_Set(context, (Set) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     var=ID
	 */
	protected void sequence_Dec(EObject context, Dec semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ActionsPackage.Literals.DEC__VAR) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ActionsPackage.Literals.DEC__VAR));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getDecAccess().getVarIDTerminalRuleCall_1_0(), semanticObject.getVar());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (var=ID value=INT)
	 */
	protected void sequence_If(EObject context, If semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ActionsPackage.Literals.IF__VAR) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ActionsPackage.Literals.IF__VAR));
			if(transientValues.isValueTransient(semanticObject, ActionsPackage.Literals.IF__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ActionsPackage.Literals.IF__VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getIfAccess().getVarIDTerminalRuleCall_1_0(), semanticObject.getVar());
		feeder.accept(grammarAccess.getIfAccess().getValueINTTerminalRuleCall_3_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     var=ID
	 */
	protected void sequence_Inc(EObject context, Inc semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ActionsPackage.Literals.INC__VAR) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ActionsPackage.Literals.INC__VAR));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getIncAccess().getVarIDTerminalRuleCall_1_0(), semanticObject.getVar());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     msg=STRING
	 */
	protected void sequence_Print(EObject context, Print semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ActionsPackage.Literals.PRINT__MSG) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ActionsPackage.Literals.PRINT__MSG));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getPrintAccess().getMsgSTRINGTerminalRuleCall_2_0(), semanticObject.getMsg());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (var=ID value=INT)
	 */
	protected void sequence_Set(EObject context, Set semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ActionsPackage.Literals.SET__VAR) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ActionsPackage.Literals.SET__VAR));
			if(transientValues.isValueTransient(semanticObject, ActionsPackage.Literals.SET__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ActionsPackage.Literals.SET__VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getSetAccess().getVarIDTerminalRuleCall_1_0(), semanticObject.getVar());
		feeder.accept(grammarAccess.getSetAccess().getValueINTTerminalRuleCall_3_0(), semanticObject.getValue());
		feeder.finish();
	}
}
