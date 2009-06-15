/*
 * 
 */
package flowchart.diagram.part;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import flowchart.FlowchartPackage;

/**
 * @generated
 */
public class FlowchartDomainModelElementTester extends PropertyTester {

	/**
	 * @generated
	 */
	public boolean test(Object receiver, String method, Object[] args,
			Object expectedValue) {
		if (false == receiver instanceof EObject) {
			return false;
		}
		EObject eObject = (EObject) receiver;
		EClass eClass = eObject.eClass();
		if (eClass == FlowchartPackage.eINSTANCE.getFlowchart()) {
			return true;
		}
		if (eClass == FlowchartPackage.eINSTANCE.getNode()) {
			return true;
		}
		if (eClass == FlowchartPackage.eINSTANCE.getTransition()) {
			return true;
		}
		if (eClass == FlowchartPackage.eINSTANCE.getSubflow()) {
			return true;
		}
		if (eClass == FlowchartPackage.eINSTANCE.getAction()) {
			return true;
		}
		if (eClass == FlowchartPackage.eINSTANCE.getDecision()) {
			return true;
		}
		return false;
	}

}
